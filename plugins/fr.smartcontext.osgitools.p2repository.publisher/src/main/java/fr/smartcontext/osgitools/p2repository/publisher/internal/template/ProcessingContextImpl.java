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

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import fr.smartcontext.osgitools.p2repository.publisher.template.ProcessingContext;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class ProcessingContextImpl implements ProcessingContext {
	
	private BundleContext bundleContext;
	private Map<String, Object> variables;

	public ProcessingContextImpl(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
		variables = new HashMap<>();
	}

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.osgitools.p2repository.publisher.template.ProcessingContext#getBundleContext()
	 */
	@Override
	public BundleContext getBundleContext() {
		return bundleContext;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.osgitools.p2repository.publisher.template.ProcessingContext#getVar(java.lang.String)
	 */
	@Override
	public Object getVar(String name) {
		return variables.get(name);
	}

	public void setVar(String name, Object value) {
		variables.put(name, value);
	}
	
}
