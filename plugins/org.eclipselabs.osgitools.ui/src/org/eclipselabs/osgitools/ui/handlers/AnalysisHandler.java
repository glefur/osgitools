package org.eclipselabs.osgitools.ui.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;
import org.eclipselabs.osgitools.internal.services.OSGiServiceImpl;
import org.eclipselabs.osgitools.services.OSGiService;
import org.eclipselabs.osgitools.ui.dialogs.AnalyzerConfigurator;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class AnalysisHandler extends AbstractHandler {
	
	private OSGiService osgiService;
	
	/**
	 * The constructor.
	 */
	public AnalysisHandler() {
		osgiService = new OSGiServiceImpl();
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		StructuredSelection currentSelection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		List<IProject> toProcess = new ArrayList<IProject>();
		if (!currentSelection.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Object> selectedElements = currentSelection.toList();
			for (Object object : selectedElements) {
				if (object instanceof IProject) {
					toProcess.add((IProject) object);
				} else if (object instanceof JavaProject) {
					toProcess.add(((JavaProject)object).getProject());
				}
			}
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		try {
			AnalyzerConfigurator configurator = new AnalyzerConfigurator();
			Project project = osgiService.createProject(configurator.getModelName(), toProcess);
			Resource resource = configurator.getModelResource(new ResourceSetImpl());
			resource.getContents().add(project);
			resource.save(Collections.emptyMap());
//			DependenciesManager dependenciesManager = osgiService.createDependenciesManager(project);
//			Collection<DependencyPath> cycles = osgiService.getCycles(dependenciesManager);
//			if (cycles.isEmpty()) {
//				System.out.println("No cycle found");
//			} else {
//				for (DependencyPath dependencyPath : cycles) {
//					StringBuilder builder = new StringBuilder("Cycle: ");
//					builder.append(dependencyPath.getHops().get(0).getFrom());
//					for (Hop hop : dependencyPath.getHops()) {
//						builder.append(" --[");
//						builder.append(hop.getVia().getName());
//						builder.append("]--> ");
//						builder.append(hop.getTo());
//					}
//				}
//			}
			MessageDialog.openInformation(window.getShell(), "OSGi Tools", "Infrastructure model generated");
		} catch (Exception e) {
			MessageDialog.openError(window.getShell(), "Oops", "An error occured. " + e);
		}
		return null;
	}
}
