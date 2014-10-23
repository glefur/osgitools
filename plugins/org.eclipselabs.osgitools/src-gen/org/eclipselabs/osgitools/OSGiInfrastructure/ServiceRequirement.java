/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getPolicy <em>Policy</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getServiceRequirement()
 * @model
 * @generated
 */
public interface ServiceRequirement extends EObject {
	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(String)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getServiceRequirement_Cardinality()
	 * @model required="true"
	 * @generated
	 */
	String getCardinality();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(String value);

	/**
	 * Returns the value of the '<em><b>Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy</em>' attribute.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY
	 * @see #setPolicy(LINKING_POLICY)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getServiceRequirement_Policy()
	 * @model
	 * @generated
	 */
	LINKING_POLICY getPolicy();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy</em>' attribute.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY
	 * @see #getPolicy()
	 * @generated
	 */
	void setPolicy(LINKING_POLICY value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(Service)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getServiceRequirement_Reference()
	 * @model required="true"
	 * @generated
	 */
	Service getReference();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Service value);

} // ServiceRequirement
