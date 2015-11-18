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

import java.net.URI;

import org.apache.commons.cli.CommandLine;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fr.smartcontext.osgitools.p2repository.publisher.PublisherParametersConstants;
import fr.smartcontext.osgitools.p2repository.publisher.internal.data.Artifact;
import fr.smartcontext.osgitools.p2repository.publisher.internal.data.P2Repository;
import fr.smartcontext.osgitools.p2repository.publisher.p2.P2Service;
import fr.smartcontext.yatte.application.context.PropertiesContextInitializer;
import fr.smartcontext.yatte.engine.context.ProcessingContext;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class ContextInitializeImpl extends PropertiesContextInitializer {

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.application.context.ContextInitializer#initContext(org.osgi.framework.BundleContext, org.apache.commons.cli.CommandLine)
	 */
	@Override
	public ProcessingContext initContext(BundleContext bundleContext, CommandLine cmdLine) throws Exception {
		ProcessingContext processingContext = super.initContext(bundleContext, cmdLine);
		ServiceReference<P2Service> p2ServiceRef = bundleContext.getServiceReference(P2Service.class);
		P2Service p2Service = bundleContext.getService(p2ServiceRef);
		IProvisioningAgent p2Agent = p2Service.setupAgent(bundleContext, new URI("file:" + cmdLine.getOptionValue(PublisherParametersConstants.AGENT_OPTION_NAME)));
		IMetadataRepository repository = p2Service.loadRepository(p2Agent, new URI("file:" + cmdLine.getOptionValue(PublisherParametersConstants.REPOSITORY_OPTION_NAME)));
		IQueryResult<IInstallableUnit> query = repository.query(QueryUtil.createIUAnyQuery(), new NullProgressMonitor());
		P2Repository repo = (P2Repository) processingContext.getVar("repo");
		for (IInstallableUnit unit : query) {
			Artifact artifact = new Artifact(unit.getId(), unit.getVersion().toString(), (String)unit.getProperty(IInstallableUnit.PROP_NAME), (String)unit.getProperty(IInstallableUnit.PROP_DESCRIPTION));
			repo.addArtifact(artifact);
		}
		return processingContext;
	}
	
}
