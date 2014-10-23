/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.osgitools.services;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface OSGiService {
	
	/**
	 * Creates a conceptual OSGi project representing the project in parameters.
	 * @param name Name to give to the created project.
	 * @param projects the project to process.
	 * @return the resulting {@link Project}.
	 * @throws Exception something gone wrong
	 */
	Project createProject(String name, Collection<IProject> projects) throws Exception;
	
	/**
	 * @param project
	 * @return
	 */
	DependenciesManager createDependenciesManager(Project project);
	
	/**
	 * Returns a collection of paths representing the dependency cycles of the given project.
	 * @param dependenciesManager the {@link DependenciesManager} to process.
	 * @return all the dependency cycles in the project. 
	 */
	Collection<DependencyPath> getCycles(DependenciesManager dependenciesManager);
	
}
