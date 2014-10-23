/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getHops <em>Hops</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#isCycle <em>Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getDependencyPath()
 * @model
 * @generated
 */
public interface DependencyPath extends EObject {
	/**
	 * Returns the value of the '<em><b>Hops</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hops</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hops</em>' containment reference list.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getDependencyPath_Hops()
	 * @model containment="true"
	 * @generated
	 */
	EList<Hop> getHops();

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getDependencyPath_From()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	DynamicComponent getFrom();

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getDependencyPath_To()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	DynamicComponent getTo();

	/**
	 * Returns the value of the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cycle</em>' attribute.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#getDependencyPath_Cycle()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isCycle();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" componentRequired="true"
	 * @generated
	 */
	boolean includes(DynamicComponent component);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" componentRequired="true"
	 * @generated
	 */
	Hop followingHop(DynamicComponent component);

} // DependencyPath
