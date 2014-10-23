/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.osgitools.internal.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipselabs.osgitools.OSGiInfrastructure.Bundle;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructureFactory;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;
import org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesFactory;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency;
import org.eclipselabs.osgitools.services.OSGiService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
@SuppressWarnings("restriction")
public class OSGiServiceImpl implements OSGiService {

	/**
	 * {@inheritDoc} 
	 * @see org.eclipselabs.osgitools.services.OSGiService#createProject(java.lang.String, java.util.Collection)
	 */
	@Override
	public Project createProject(String name, Collection<IProject> projects) throws Exception {
		Project result = OSGiInfrastructureFactory.eINSTANCE.createProject();
		result.setName(name);
		for (IProject pdeProject : projects) {
			IFile manifestFile = PDEProject.getManifest(pdeProject);
			if (manifestFile.exists() && manifestFile.isAccessible()) {
				Manifest manifest = new Manifest(manifestFile.getContents());
				Attributes attributes = manifest.getMainAttributes();
				Bundle bundle = OSGiInfrastructureFactory.eINSTANCE.createBundle();
				String bundleName = attributes.getValue("Bundle-SymbolicName");
				setBundleName(bundle, bundleName);
				IFolder OSGiINFFolder = PDEProject.getOSGiInf(pdeProject);
				if (OSGiINFFolder.exists() && OSGiINFFolder.isAccessible()) {
					for (IResource resource : OSGiINFFolder.members()) {
						if (resource instanceof IFile) {
							IFile iFile = (IFile) resource;
							if ("xml".equals(iFile.getFileExtension())) {
								DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
								DocumentBuilder builder = factory.newDocumentBuilder();
								Document document = builder.parse(((IFile)resource).getContents());
								Element element = document.getDocumentElement();
								if ("scr:component".equals(element.getTagName())) {
									DynamicComponent component = createComponent(result, element);
									bundle.getComponents().add(component);
								}
							}
						}
					}
				}
				result.getBundles().add(bundle);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc} 
	 * @see org.eclipselabs.osgitools.services.OSGiService#createDependenciesManager(org.eclipselabs.osgitools.OSGiInfrastructure.Project)
	 */
	@Override
	public DependenciesManager createDependenciesManager(Project project) {
		DependenciesManager manager = DependenciesFactory.eINSTANCE.createDependenciesManager();
		manager.setProject(project);
		Map<DynamicComponent, DependencyNode> nodes = new HashMap<DynamicComponent, DependencyNode>();
		for (DynamicComponent component : project.getAllComponents()) {
			DependencyNode node = nodes.get(component);
			if (node == null) {
				node = DependenciesFactory.eINSTANCE.createDependencyNode();
				node.setSource(component);
				nodes.put(component, node);
			}
			EList<Service> requiredServices = component.getRequiredServices();
			for (Service service : requiredServices) {
				EList<DynamicComponent> providers = project.getProviders(service);
				for (DynamicComponent provider : providers) {
					ServiceDependency dependency = DependenciesFactory.eINSTANCE.createServiceDependency();
					dependency.setVia(service);
					DependencyNode dependencyNode = nodes.get(provider);
					if (dependencyNode == null) {
						dependencyNode = DependenciesFactory.eINSTANCE.createDependencyNode();
						dependencyNode.setSource(provider);
						nodes.put(provider, dependencyNode);
					}
					dependency.setTarget(dependencyNode);
					node.getDependencies().add(dependency);
				}
			}
			node.setComplete(true);
		}
		manager.setNodes(nodes);
		return manager;
	}

	/**
	 * {@inheritDoc} 
	 * @see org.eclipselabs.osgitools.services.OSGiService#getCycles(org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager)
	 */
	@Override
	public Collection<DependencyPath> getCycles(DependenciesManager dependenciesManager) {
		List<DependencyPath> cycles = new ArrayList<DependencyPath>();
		EList<DynamicComponent> allComponents = dependenciesManager.getProject().getAllComponents();
		for (DynamicComponent dynamicComponent : allComponents) {
			EList<ServiceDependency> dependencies = dependenciesManager.getNodes().get(dynamicComponent).getDependencies();
			if (!dependencies.isEmpty()) { 
				for (ServiceDependency serviceDependency : dependencies) {
					List<ServiceDependency> path = new ArrayList<ServiceDependency>();
					path.add(serviceDependency);
					buildCycles(cycles, dependenciesManager, dynamicComponent, path);
				}
			}
		}
		return cycles;
	}

	private void setBundleName(Bundle bundle, String bundleName) {
		int delimiterIndex = bundleName.indexOf(";");
		if (delimiterIndex < 0) {
			bundle.setSymbolicName(bundleName);
		} else {
			bundle.setSymbolicName(bundleName.substring(0, delimiterIndex));
		}
	}

	private DynamicComponent createComponent(Project result, Element element) {
		DynamicComponent component = OSGiInfrastructureFactory.eINSTANCE.createDynamicComponent();
		String nameAttr = element.getAttribute("name");
		component.setName(nameAttr);
		for (Element provideElement : getProvidedServiceElements(element)) {			
			Service service = getProvidedService(result, provideElement);
			component.getProvides().add(service);
		}
		for (Element requireElement : getRequiredServiceElement(element)) {
			Service service = getRequiredService(result, requireElement);
			ServiceRequirement req = OSGiInfrastructureFactory.eINSTANCE.createServiceRequirement();
			req.setReference(service);
			req.setCardinality(requireElement.getAttribute("cardinality"));
			String policyName = requireElement.getAttribute("policy");
			if ("static".equals(policyName)) {
				req.setPolicy(LINKING_POLICY.STATIC);
			} else {
				req.setPolicy(LINKING_POLICY.DYNAMIC);
			}
			component.getRequires().add(req);
		}
		return component;
	}

	private List<Element> getProvidedServiceElements(Element componentElement) {
		List<Element> result = new ArrayList<Element>();
		NodeList servicesNode = componentElement.getElementsByTagName("service");
		if (servicesNode.getLength() > 0) {
			for (int i = 0; i < servicesNode.getLength(); i++) {
				Node serviceNode = servicesNode.item(i);
				if (serviceNode instanceof Element) {
					Element serviceElement = (Element)serviceNode;
					NodeList provideList = serviceElement.getElementsByTagName("provide");
					if (provideList.getLength() > 0) {
						for (int j = 0; j < provideList.getLength(); j++) {
							Node provideNode = provideList.item(j);
							if (provideNode instanceof Element) {
								result.add((Element) provideNode);
							}
							
						}
					}
				}
			}
		}
		return result;
	}

	private Service getProvidedService(Project result, Element provideElement) {
		String providedService = provideElement.getAttribute("interface");
		Service service = result.getService(providedService);
		if (service == null) {
			service = OSGiInfrastructureFactory.eINSTANCE.createService();
			service.setName(providedService);
			result.getServices().add(service);
		}
		return service;
	}
	

	private List<Element> getRequiredServiceElement(Element componentElement) {
		List<Element> result = new ArrayList<Element>();
		NodeList referenceList = componentElement.getElementsByTagName("reference");
		if (referenceList.getLength() > 0) {
			for (int j = 0; j < referenceList.getLength(); j++) {
				Node referenceNode = referenceList.item(j);
				if (referenceNode instanceof Element) {
					result.add((Element) referenceNode);
				}
				
			}
		}
		return result;
	}
	
	private Service getRequiredService(Project project, Element requireElement) {
		String requiredService = requireElement.getAttribute("interface");
		Service service = project.getService(requiredService);
		if (service == null) {
			service = OSGiInfrastructureFactory.eINSTANCE.createService();
			service.setName(requiredService);
			project.getServices().add(service);
		}
		return service;
	}
	
	private void buildCycles(List<DependencyPath> cycles, DependenciesManager dependenciesManager, DynamicComponent startPoint, List<ServiceDependency> path) {		
		DependencyPath fullPath = buildPath(startPoint, path);
		// 1 - the path is a cycle. We return only the path (cycle) and we stop the crawling
		if (fullPath.isCycle()) {
			if (!cycles.contains(fullPath)) {
				cycles.add(fullPath);
			}
		} else {
			ServiceDependency currentDependency = path.get(path.size() - 1);
			DynamicComponent currentComponent = currentDependency.getTarget().getSource();
			EList<ServiceDependency> currentComponentDependencies = dependenciesManager.getNodes().get(currentComponent).getDependencies();
			// 2 - The current component has dependencies so we continue the algorithm with its dependencies
			if (!currentComponentDependencies.isEmpty()) {
				for (ServiceDependency serviceDependency : currentComponentDependencies) {
					List<ServiceDependency> newPath = new ArrayList<ServiceDependency>(path);
					newPath.add(serviceDependency);
					buildCycles(cycles, dependenciesManager, startPoint, newPath);
				}
			} 
		}
	}
	
	private DependencyPath buildPath(DynamicComponent startPoint, List<ServiceDependency> path) {
		DependencyPath result = DependenciesFactory.eINSTANCE.createDependencyPath();
		if (!path.isEmpty()) {
			DynamicComponent comp = startPoint;
			for (int i = 0; i < path.size(); i++) {
				ServiceDependency serviceDependency = path.get(i);
				Hop hop = DependenciesFactory.eINSTANCE.createHop();
				hop.setFrom(comp);
				hop.setTo(serviceDependency.getTarget().getSource());
				hop.setVia(serviceDependency.getVia());
				result.getHops().add(hop);
				comp = serviceDependency.getTarget().getSource();
			}
			
		}
		return result;
	}
	
}


