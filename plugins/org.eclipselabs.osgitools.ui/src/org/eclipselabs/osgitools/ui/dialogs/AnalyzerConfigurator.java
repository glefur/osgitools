/**
 * 
 */
package org.eclipselabs.osgitools.ui.dialogs;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * @author glefur
 *
 */
public class AnalyzerConfigurator {

	private String name = null;
	private String containerPath = null;

	public Resource getModelResource(ResourceSet resourceSet) {
		if (containerPath == null) {
			configure();
		}
		URI uri = URI.createPlatformResourceURI(containerPath + "/" + name + ".osgi", true);
		return resourceSet.createResource(uri);
	}

	public String getModelName() {
		if (name == null) {
			configure();
		}
		return name;
	}
	
	public void configure() {
		ConfigurationDialog dialog = new ConfigurationDialog(new Shell());
		if (dialog.open() == Window.OK) {
			name = dialog.getName();
			containerPath = dialog.getContainerPath();
		}
	}
	
	private final class ConfigurationDialog extends Dialog {
		
		private String name;
		private String containerPath;
		
		public ConfigurationDialog(Shell parentShell) {
			super(parentShell);
		}	

		public String getName() {
			return name;
		}

		public String getContainerPath() {
			return containerPath;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite container = new Composite(parent, SWT.NONE);
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			container.setLayout(new GridLayout(3, false));
			Label nameLabel = new Label(container, SWT.NONE);
			nameLabel.setText("Name:");
			final Text nameText = new Text(container, SWT.BORDER);
			nameText.setMessage("Enter here a name for the conversion");
			GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
			nameData.horizontalSpan = 2;
			nameText.setLayoutData(nameData);
			nameText.addModifyListener(new ModifyListener() {
				
				@Override
				public void modifyText(ModifyEvent e) {
					name = nameText.getText();
				}
			});
			new Label(container, SWT.NONE);
			Label locationLabel = new Label(container, SWT.NONE);
			locationLabel.setText("Location:");
			final Text location = new Text(container, SWT.BORDER);
			location.setMessage("You must define a location where to generate the model.");
			nameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			Button locationBrowsing = new Button(container, SWT.PUSH);
			locationBrowsing.setText("...");
			locationBrowsing.addSelectionListener(new SelectionAdapter() {

				/* (non-Javadoc)
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(SelectionEvent e) {
					ContainerSelectionDialog containerDialog = new ContainerSelectionDialog(ConfigurationDialog.this.getShell(), ResourcesPlugin.getWorkspace().getRoot(), true, "Please choose the destination folder for the generated model:");
					if (containerDialog.open() == Window.OK) {
						Object[] result = containerDialog.getResult();
						if (result.length > 0 && result[0] instanceof IPath) {
							String path = ((IPath)result[0]).toOSString();
							location.setText(path);
							containerPath = path;
						}
					}
				}
				
				
			});
			
			return container;
		}
	}
}
