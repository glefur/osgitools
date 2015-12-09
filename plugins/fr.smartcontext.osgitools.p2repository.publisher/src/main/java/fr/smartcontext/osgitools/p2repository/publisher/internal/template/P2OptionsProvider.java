/*******************************************************************************
 * Copyright (c) 2015 Goulwen Le Fur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package fr.smartcontext.osgitools.p2repository.publisher.internal.template;

import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import fr.smartcontext.osgitools.p2repository.publisher.PublisherParametersConstants;
import fr.smartcontext.yatte.context.cli.DefaultOptionsProvider;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class P2OptionsProvider extends DefaultOptionsProvider {

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.context.cli.DefaultOptionsProvider#getOptions()
	 */
	@Override
	public Options getOptions() {
		Options options = super.getOptions();
		OptionBuilder.withLongOpt(PublisherParametersConstants.AGENT_OPTION_LONG_NAME);
		OptionBuilder.withDescription(PublisherParametersConstants.AGENT_OPTION_DESCRIPTION);
		OptionBuilder.hasArg();
		OptionBuilder.withArgName(PublisherParametersConstants.AGENT_OPTION_ARGUMENT_NAME);
		OptionBuilder.isRequired();
		options.addOption(OptionBuilder.create(PublisherParametersConstants.AGENT_OPTION_NAME));

		OptionBuilder.withLongOpt(PublisherParametersConstants.REPOSITORY_OPTION_LONG_NAME);
		OptionBuilder.withDescription(PublisherParametersConstants.REPOSITORY_OPTION_DESCRIPTION);
		OptionBuilder.hasArg();
		OptionBuilder.withArgName(PublisherParametersConstants.REPOSITORY_OPTION_ARGUMENT_NAME);
		OptionBuilder.isRequired();
		options.addOption(OptionBuilder.create(PublisherParametersConstants.REPOSITORY_OPTION_NAME));
		return options;
	}

}
