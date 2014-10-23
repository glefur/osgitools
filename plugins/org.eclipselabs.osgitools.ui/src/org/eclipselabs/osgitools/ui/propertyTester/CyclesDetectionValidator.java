/**
 * 
 */
package org.eclipselabs.osgitools.ui.propertyTester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author glefur
 *
 */
public class CyclesDetectionValidator extends PropertyTester {

	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		Object firstSelection = ((StructuredSelection)receiver).getFirstElement();
		return firstSelection instanceof IFile && "osgi".equals(((IFile)firstSelection).getFileExtension());
	}

}
