/*******************************************************************************
 * Copyright (c) 2015 Goulwen Le Fur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package fr.smartcontext.osgitools.p2repository.publisher.internal.p2;

import java.net.URI;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fr.smartcontext.osgitools.p2repository.publisher.p2.P2Service;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class P2ServiceImpl implements P2Service {

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.p2.P2Service#setupAgent(java.net.URI)
	 */
	@Override
	public IProvisioningAgent setupAgent(BundleContext bundleContext, URI location) throws ProvisionException {
		IProvisioningAgent result = null;
		@SuppressWarnings("unchecked")
		ServiceReference<IProvisioningAgentProvider> providerRef = (ServiceReference<IProvisioningAgentProvider>) bundleContext.getServiceReference(IProvisioningAgentProvider.SERVICE_NAME);
		if (providerRef == null) {
			throw new RuntimeException("No provisioning agent provider is available"); //$NON-NLS-1$
		}
		IProvisioningAgentProvider provider = bundleContext.getService(providerRef);
		if (provider == null) {
			throw new RuntimeException("No provisioning agent provider is available"); //$NON-NLS-1$
		}
		// obtain agent for currently running system
		result = provider.createAgent(location);
		// When you're done, make sure you 'unget' the service.
		// Activator.getContext().ungetService(providerRef);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.p2.P2Service#loadRepository(org.eclipse.equinox.p2.core.IProvisioningAgent, java.net.URI)
	 */
	@Override
	public IMetadataRepository loadRepository(IProvisioningAgent agent, URI repositoryLocation) throws ProvisionException, OperationCanceledException {
		IMetadataRepositoryManager manager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
		IMetadataRepository repository = manager.loadRepository(repositoryLocation, new NullProgressMonitor());
		return repository;
	}

}
