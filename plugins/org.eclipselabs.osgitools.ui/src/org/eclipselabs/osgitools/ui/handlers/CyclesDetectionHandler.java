package org.eclipselabs.osgitools.ui.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;
import org.eclipselabs.osgitools.internal.services.OSGiServiceImpl;
import org.eclipselabs.osgitools.services.OSGiService;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CyclesDetectionHandler extends AbstractHandler {

	private OSGiService osgiService;

	/**
	 * The constructor.
	 */
	public CyclesDetectionHandler() {
		osgiService = new OSGiServiceImpl();
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		StructuredSelection currentSelection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		if (!currentSelection.isEmpty()) {
			Object firstElement = currentSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				URI createPlatformResourceURI = URI.createPlatformResourceURI(((IFile) firstElement).getFullPath().toOSString(),false);
				ResourceSet rset = new ResourceSetImpl();
				Resource resource = rset.getResource(createPlatformResourceURI, true);
				if (resource.getContents() != null 
						&& !resource.getContents().isEmpty()
						&& resource.getContents().get(0) instanceof Project) {
					Project project = (Project) resource.getContents().get(0);
					try {
						DependenciesManager dependenciesManager = osgiService.createDependenciesManager(project);
						Collection<DependencyPath> cycles = osgiService.getCycles(dependenciesManager);
						if (cycles.isEmpty()) {
							System.out.println("No cycle found");
						} else {
							for (DependencyPath dependencyPath : cycles) {
								StringBuilder builder = new StringBuilder("Cycle: ");
								builder.append(dependencyPath.getHops().get(0).getFrom().getName());
								for (Hop hop : dependencyPath.getHops()) {
									builder.append(" --[");
									builder.append(hop.getVia().getName());
									builder.append("]--> ");
									builder.append(hop.getTo().getName());
								}
								System.out.println(builder.toString());
							}
						}
						MessageDialog.openInformation(window.getShell(), "OSGi Tools", "Infrastructure model generated");
					} catch (Exception e) {
						MessageDialog.openError(window.getShell(), "Oops", "An error occured. " + e);
					}
				}
			}
		}
		return null;
	}
}
