/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getVia <em>Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getServiceDependency()
 * @model
 * @generated
 */
public interface ServiceDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(DependencyNode)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getServiceDependency_Target()
	 * @model required="true"
	 * @generated
	 */
	DependencyNode getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DependencyNode value);

	/**
	 * Returns the value of the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Via</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Via</em>' reference.
	 * @see #setVia(Service)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getServiceDependency_Via()
	 * @model required="true"
	 * @generated
	 */
	Service getVia();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getVia <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Via</em>' reference.
	 * @see #getVia()
	 * @generated
	 */
	void setVia(Service value);

} // ServiceDependency
