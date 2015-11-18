/*******************************************************************************
 * Copyright (c) 2015 Goulwen Le Fur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.smartcontext.osgitools.p2repository.publisher.internal.template;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fr.smartcontext.osgitools.p2repository.publisher.ApplicationParametersConstants;
import fr.smartcontext.osgitools.p2repository.publisher.internal.data.Artifact;
import fr.smartcontext.osgitools.p2repository.publisher.internal.data.P2Repository;
import fr.smartcontext.osgitools.p2repository.publisher.p2.P2Service;
import fr.smartcontext.yatte.engine.ContextInitializer;
import fr.smartcontext.yatte.engine.ProcessingContext;
import fr.smartcontext.yatte.engine.ProcessingContextImpl;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class ContextInitializeImpl implements ContextInitializer {

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.engine.ContextInitializer#initContext(org.osgi.framework.BundleContext, org.apache.commons.cli.CommandLine)
	 */
	@Override
	public ProcessingContext initContext(BundleContext bundleContext, CommandLine commandLine) throws Exception {
		ProcessingContextImpl processingContext = new ProcessingContextImpl(bundleContext);

		String propertiesPath = commandLine.getOptionValue(ApplicationParametersConstants.PROPERTIES_PATH_OPTION_NAME);
		if (propertiesPath != null) {
			URL entry = bundleContext.getBundle().getEntry(propertiesPath);
			Properties prop = new Properties();
			InputStream openStream = entry.openStream();
			prop.load(openStream);
			Collection<String> searchVariableNames = searchVariableNames(prop);
			for (String varName : searchVariableNames) {
				Collection<String> features = searchFeatureForVariable(prop, varName);
				String type = prop.getProperty(varName + TYPE_SUFFIX);
				Class<?> class_ = bundleContext.getBundle().loadClass(type);
				Object instance = class_.newInstance();
				for (String feature : features) {
					setFeature(prop, varName, class_, instance, feature);
				}
				processingContext.setVar(varName, instance);			
			}
		}
		
		
		ServiceReference<P2Service> p2ServiceRef = bundleContext.getServiceReference(P2Service.class);
		P2Service p2Service = bundleContext.getService(p2ServiceRef);
		IProvisioningAgent p2Agent = p2Service.setupAgent(bundleContext, new URI("file:/home/glefur/Perso/Softwares/eclipses/mars-osgi-jee/p2/"));
		IMetadataRepository repository = p2Service.loadRepository(p2Agent, new URI("file:/home/glefur/Perso/repositories/glefur.github.io/p2/p2CoJaL/0.9.1/repository"));
		IQueryResult<IInstallableUnit> query = repository.query(QueryUtil.createIUAnyQuery(), new NullProgressMonitor());
		P2Repository repo = (P2Repository) processingContext.getVar("repo");
		for (IInstallableUnit unit : query) {
			Artifact artifact = new Artifact(unit.getId(), unit.getVersion().toString(), (String)unit.getProperty(IInstallableUnit.PROP_NAME), (String)unit.getProperty(IInstallableUnit.PROP_DESCRIPTION));
			repo.addArtifact(artifact);
		}
		return processingContext;
	}
	
	private Collection<String> searchVariableNames(Properties properties) {
		Collection<String> result = new ArrayList<>();
		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			if (key instanceof String) {
				String str = (String) key;
				if (str.endsWith(TYPE_SUFFIX)) {
					result.add(str.substring(0, str.length() - TYPE_SUFFIX.length()));
				}
			}
		}
		return result;
	}
	
	private Collection<String> searchFeatureForVariable(Properties properties, String varName) {
		Collection<String> result = new ArrayList<>();
		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			if (key instanceof String) {
				String str = (String) key;
				if (str.startsWith(varName + DOT) && !str.equals(varName + TYPE_SUFFIX)) {
					result.add(str.substring((varName + DOT).length(), str.length()));
				}
			}
		}
		return result;
	}

	private void setFeature(Properties prop, String varName, Class<?> class_, Object instance, String feature) throws NoSuchFieldException, IllegalAccessException {
		String value = prop.getProperty(varName + DOT + feature);
		Field field = class_.getDeclaredField(feature);
		field.setAccessible(true);
		field.set(instance, value);
	}

}
