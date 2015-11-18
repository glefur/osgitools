
package fr.smartcontext.osgitools.p2repository.publisher;

import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import fr.smartcontext.yatte.application.YatteApplication;

/**
 * This class controls all aspects of the application's execution
 */
public class Application extends YatteApplication {

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.application.YatteApplication#initOptions()
	 */
	@Override
	protected Options initOptions() {
		Options options = super.initOptions();

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
