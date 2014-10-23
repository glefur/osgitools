/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getVia <em>Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getHop()
 * @model
 * @generated
 */
public interface Hop extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(DynamicComponent)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getHop_From()
	 * @model required="true"
	 * @generated
	 */
	DynamicComponent getFrom();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(DynamicComponent value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(DynamicComponent)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getHop_To()
	 * @model required="true"
	 * @generated
	 */
	DynamicComponent getTo();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(DynamicComponent value);

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
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getHop_Via()
	 * @model required="true"
	 * @generated
	 */
	Service getVia();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getVia <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Via</em>' reference.
	 * @see #getVia()
	 * @generated
	 */
	void setVia(Service value);

} // Hop
