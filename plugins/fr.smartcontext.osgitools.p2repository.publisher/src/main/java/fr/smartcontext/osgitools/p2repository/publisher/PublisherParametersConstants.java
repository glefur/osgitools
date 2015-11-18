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
package fr.smartcontext.osgitools.p2repository.publisher;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public interface PublisherParametersConstants {

	String AGENT_OPTION_NAME = "a";
	String AGENT_OPTION_LONG_NAME = "p2-agent";
	String AGENT_OPTION_DESCRIPTION = "Path of p2 agent to use for browsing the repository";
	String AGENT_OPTION_ARGUMENT_NAME = "agent";

	String REPOSITORY_OPTION_NAME = "r";
	String REPOSITORY_OPTION_LONG_NAME = "p2-repository";
	String REPOSITORY_OPTION_DESCRIPTION = "Path of p2 repository to publish";
	String REPOSITORY_OPTION_ARGUMENT_NAME = "repo";
}
