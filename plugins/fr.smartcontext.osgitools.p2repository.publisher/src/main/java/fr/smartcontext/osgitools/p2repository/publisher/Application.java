package fr.smartcontext.osgitools.p2repository.publisher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello RCP World!");
		String toto = "Ceci est un <!--gen: repo.name--> test";
		Pattern p = Pattern.compile("<!--gen: .*-->");
		Matcher matcher = p.matcher(toto);
		while (matcher.find()) {
			System.out.println("Directive: " + matcher.group());
		}
		return IApplication.EXIT_OK;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
