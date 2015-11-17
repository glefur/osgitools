package fr.smartcontext.osgitools.p2repository.publisher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import fr.smartcontext.osgitools.p2repository.publisher.template.ContextInitializer;
import fr.smartcontext.osgitools.p2repository.publisher.template.ProcessingContext;
import fr.smartcontext.osgitools.p2repository.publisher.template.TemplateProcessor;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private Bundle applicationBundle;

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		applicationBundle = FrameworkUtil.getBundle(Application.class);
		BundleContext bundleContext = applicationBundle.getBundleContext();
		
		Map<String, String> applicationParameters = prepareParams(context);
		
		ServiceReference<ContextInitializer> ciRef = bundleContext.getServiceReference(ContextInitializer.class);
		ContextInitializer contextInitializer = bundleContext.getService(ciRef);
		
		ProcessingContext processingContext = contextInitializer.initContext(bundleContext, applicationParameters);
		
		ServiceReference<TemplateProcessor> templateProcessorRef = bundleContext.getServiceReference(TemplateProcessor.class);
		TemplateProcessor templateProcessor = bundleContext.getService(templateProcessorRef);
		
		PrintWriter fos = new PrintWriter(new FileOutputStream(new File("/home/glefur/Perso/repositories/glefur.github.io/repo.html")));

		
		templateProcessor.process(Paths.get("/home/glefur/Perso/repositories/glefur.github.io/template.gtp"), processingContext, fos);
		
		fos.close();
		return IApplication.EXIT_OK;
	}

	/**
	 * @param context
	 * @return
	 */
	private Map<String, String> prepareParams(IApplicationContext context) {
		Map<String, String> applicationParameters = new HashMap<>();
		String[] params = (String[]) context.getArguments().get("application.args");
		for (String param : params) {
			if (param.indexOf('=') > 0) {
				applicationParameters.put(param.substring(0, param.indexOf('=')), param.substring(param.indexOf('=') + 1));
			}
		}
		return applicationParameters;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
