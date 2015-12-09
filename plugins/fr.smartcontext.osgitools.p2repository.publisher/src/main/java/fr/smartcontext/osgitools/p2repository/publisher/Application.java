
package fr.smartcontext.osgitools.p2repository.publisher;

import java.util.List;

import org.osgi.framework.BundleContext;

import fr.smartcontext.osgitools.p2repository.publisher.internal.template.ContextInitializeImpl;
import fr.smartcontext.osgitools.p2repository.publisher.internal.template.P2OptionsProvider;
import fr.smartcontext.yatte.application.YatteApplication;
import fr.smartcontext.yatte.context.cli.CLIOptionsProvider;
import fr.smartcontext.yatte.engine.context.ContextInitializer;

/**
 * This class controls all aspects of the application's execution
 */
public class Application extends YatteApplication {

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.application.YatteApplication#applicationName()
	 */
	@Override
	protected String applicationName() {
		return "p2repoPublisher";
	}

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.yatte.application.YatteApplication#prepareGeneration(org.osgi.framework.BundleContext, java.util.List)
	 */
	@Override
	protected void prepareGeneration(BundleContext bundleContext, List<String> parameters) {
		bundleContext.registerService(CLIOptionsProvider.class, new P2OptionsProvider(), null);
		bundleContext.registerService(ContextInitializer.class, new ContextInitializeImpl(), null);		
	}
	
	
}
