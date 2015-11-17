package fr.smartcontext.osgitools.p2repository.publisher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Paths;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import fr.smartcontext.osgitools.p2repository.publisher.internal.data.Artifact;
import fr.smartcontext.osgitools.p2repository.publisher.internal.data.P2Repository;
import fr.smartcontext.osgitools.p2repository.publisher.internal.template.ProcessingContextImpl;
import fr.smartcontext.osgitools.p2repository.publisher.p2.P2Service;
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
		ServiceReference<P2Service> p2ServiceRef = applicationBundle.getBundleContext().getServiceReference(P2Service.class);
		P2Service p2Service = applicationBundle.getBundleContext().getService(p2ServiceRef);
		IProvisioningAgent p2Agent = p2Service.setupAgent(applicationBundle.getBundleContext(), new URI("file:/home/glefur/Perso/Softwares/eclipses/mars-osgi-jee/p2/"));
		IMetadataRepository repository = p2Service.loadRepository(p2Agent, new URI("file:/home/glefur/Perso/repositories/glefur.github.io/p2/p2CoJaL/0.9.1/repository"));
		IQueryResult<IInstallableUnit> query = repository.query(QueryUtil.createIUAnyQuery(), new NullProgressMonitor());

		P2Repository repo = new P2Repository("p2CoJaL", "0.9.1");
		
		for (IInstallableUnit unit : query) {
			Artifact artifact = new Artifact(unit.getId(), unit.getVersion().toString(), (String)unit.getProperty(IInstallableUnit.PROP_NAME), (String)unit.getProperty(IInstallableUnit.PROP_DESCRIPTION));
			repo.addArtifact(artifact);
		}
		
		ServiceReference<TemplateProcessor> templateProcessorRef = applicationBundle.getBundleContext().getServiceReference(TemplateProcessor.class);
		TemplateProcessor templateProcessor = applicationBundle.getBundleContext().getService(templateProcessorRef);
		
		PrintWriter fos = new PrintWriter(new FileOutputStream(new File("/home/glefur/Perso/repositories/glefur.github.io/repo.html")));

		ProcessingContextImpl processingContext = new ProcessingContextImpl(applicationBundle.getBundleContext());
		processingContext.setVar("repo", repo);
		
		templateProcessor.process(Paths.get("/home/glefur/Perso/repositories/glefur.github.io/template.gtp"), processingContext, fos);
		
		fos.close();
		return IApplication.EXIT_OK;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
