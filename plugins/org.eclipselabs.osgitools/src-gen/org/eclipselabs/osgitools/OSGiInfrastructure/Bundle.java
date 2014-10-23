/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getSymbolicName <em>Symbolic Name</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getBundle()
 * @model
 * @generated
 */
public interface Bundle extends EObject {
	/**
	 * Returns the value of the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbolic Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbolic Name</em>' attribute.
	 * @see #setSymbolicName(String)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getBundle_SymbolicName()
	 * @model required="true"
	 * @generated
	 */
	String getSymbolicName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getSymbolicName <em>Symbolic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbolic Name</em>' attribute.
	 * @see #getSymbolicName()
	 * @generated
	 */
	void setSymbolicName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getBundle_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getBundle_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<DynamicComponent> getComponents();

} // Bundle
