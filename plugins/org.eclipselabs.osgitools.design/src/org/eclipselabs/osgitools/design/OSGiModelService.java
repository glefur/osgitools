/**
 * 
 */
package org.eclipselabs.osgitools.design;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;

/**
 * @author glefur
 *
 */
public class OSGiModelService {

	
	public List<DynamicComponent> getDependsOn(DynamicComponent component) {
		List<DynamicComponent> result = new ArrayList<DynamicComponent>();
		for (Service service : component.getRequiredServices()) {
			Project proj = (Project) EcoreUtil.getRootContainer(component);
			result.addAll(proj.getProviders(service));
			
		}
		return result;
	}
	
}
