/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getProvides <em>Provides</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getRequiredServices <em>Required Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getDynamicComponent()
 * @model
 * @generated
 */
public interface DynamicComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getDynamicComponent_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getDynamicComponent_Implementation()
	 * @model required="true"
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Provides</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.osgitools.OSGiInfrastructure.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides</em>' reference list.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getDynamicComponent_Provides()
	 * @model
	 * @generated
	 */
	EList<Service> getProvides();

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' containment reference list.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getDynamicComponent_Requires()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServiceRequirement> getRequires();

	/**
	 * Returns the value of the '<em><b>Required Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.osgitools.OSGiInfrastructure.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Services</em>' reference list.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#getDynamicComponent_RequiredServices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Service> getRequiredServices();

} // DynamicComponent
