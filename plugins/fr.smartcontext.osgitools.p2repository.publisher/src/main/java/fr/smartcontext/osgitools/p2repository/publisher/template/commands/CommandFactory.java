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

package fr.smartcontext.osgitools.p2repository.publisher.template.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import fr.smartcontext.osgitools.p2repository.publisher.internal.template.TemplateProcessorImpl;
import fr.smartcontext.osgitools.p2repository.publisher.internal.template.commands.GenFeatureCommand;
import fr.smartcontext.osgitools.p2repository.publisher.internal.template.commands.GenServiceCommand;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class CommandFactory {
	
	
	public Command createCommand(String directive) {
		String commandStr = directive.substring(TemplateProcessorImpl.DIRECTIVE_PREFIX.length(), directive.length() - TemplateProcessorImpl.DIRECTIVE_SUFFIX.length());
		StringTokenizer str = new StringTokenizer(commandStr, " ");
		String type = str.nextToken();
		Map<String, String> parameters = new HashMap<>();
		while (str.hasMoreTokens()) {
			String nextToken = str.nextToken();
			parameters.put(nextToken.substring(0, nextToken.indexOf('=')), nextToken.substring(nextToken.indexOf('=') + 1));
		}
		Command result = null;
		switch (type) {
			case "feature":
				result = new GenFeatureCommand(parameters);
				break;
			case "service":
				result = new GenServiceCommand(parameters);
				break;
		}
		return result;
	}

}
