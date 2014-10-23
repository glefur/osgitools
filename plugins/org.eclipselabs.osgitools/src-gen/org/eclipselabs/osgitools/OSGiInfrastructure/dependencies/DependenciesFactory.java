/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage
 * @generated
 */
public interface DependenciesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DependenciesFactory eINSTANCE = org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
	DependenciesManager createDependenciesManager();

	/**
	 * Returns a new object of class '<em>Dependency Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Node</em>'.
	 * @generated
	 */
	DependencyNode createDependencyNode();

	/**
	 * Returns a new object of class '<em>Service Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Dependency</em>'.
	 * @generated
	 */
	ServiceDependency createServiceDependency();

	/**
	 * Returns a new object of class '<em>Dependency Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Path</em>'.
	 * @generated
	 */
	DependencyPath createDependencyPath();

	/**
	 * Returns a new object of class '<em>Hop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hop</em>'.
	 * @generated
	 */
	Hop createHop();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DependenciesPackage getDependenciesPackage();

} //DependenciesFactory
