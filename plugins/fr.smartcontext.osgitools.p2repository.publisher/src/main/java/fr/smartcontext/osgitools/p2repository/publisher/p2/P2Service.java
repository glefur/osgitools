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
package fr.smartcontext.osgitools.p2repository.publisher.p2;

import java.net.URI;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public interface P2Service {

	IProvisioningAgent setupAgent(BundleContext bundleContext, final URI location) throws ProvisionException;

	IMetadataRepository loadRepository(IProvisioningAgent agent, URI repositoryLocation) throws ProvisionException, OperationCanceledException;
}
