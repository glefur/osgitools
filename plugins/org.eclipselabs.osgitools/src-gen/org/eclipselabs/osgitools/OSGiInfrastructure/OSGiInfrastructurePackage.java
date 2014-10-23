/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface OSGiInfrastructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "OSGiInfrastructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/osgitools/infrastructure/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "osgi-infra";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OSGiInfrastructurePackage eINSTANCE = org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Bundles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__BUNDLES = 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SERVICES = 2;

	/**
	 * The feature id for the '<em><b>All Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ALL_COMPONENTS = 3;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.BundleImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 1;

	/**
	 * The feature id for the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__SYMBOLIC_NAME = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__COMPONENTS = 2;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl <em>Dynamic Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getDynamicComponent()
	 * @generated
	 */
	int DYNAMIC_COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_COMPONENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_COMPONENT__IMPLEMENTATION = 1;

	/**
	 * The feature id for the '<em><b>Provides</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_COMPONENT__PROVIDES = 2;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_COMPONENT__REQUIRES = 3;

	/**
	 * The feature id for the '<em><b>Required Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_COMPONENT__REQUIRED_SERVICES = 4;

	/**
	 * The number of structural features of the '<em>Dynamic Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_COMPONENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl <em>Service Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getServiceRequirement()
	 * @generated
	 */
	int SERVICE_REQUIREMENT = 4;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REQUIREMENT__CARDINALITY = 0;

	/**
	 * The feature id for the '<em><b>Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REQUIREMENT__POLICY = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REQUIREMENT__REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Service Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REQUIREMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY <em>LINKING POLICY</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getLINKING_POLICY()
	 * @generated
	 */
	int LINKING_POLICY = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Project#getBundles <em>Bundles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundles</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Project#getBundles()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Bundles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Project#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Project#getServices()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Services();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Project#getAllComponents <em>All Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Components</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Project#getAllComponents()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_AllComponents();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getSymbolicName <em>Symbolic Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbolic Name</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getSymbolicName()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_SymbolicName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getVersion()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Bundle#getComponents()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_Components();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent <em>Dynamic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Component</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent
	 * @generated
	 */
	EClass getDynamicComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getName()
	 * @see #getDynamicComponent()
	 * @generated
	 */
	EAttribute getDynamicComponent_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getImplementation()
	 * @see #getDynamicComponent()
	 * @generated
	 */
	EAttribute getDynamicComponent_Implementation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getProvides <em>Provides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provides</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getProvides()
	 * @see #getDynamicComponent()
	 * @generated
	 */
	EReference getDynamicComponent_Provides();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requires</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getRequires()
	 * @see #getDynamicComponent()
	 * @generated
	 */
	EReference getDynamicComponent_Requires();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getRequiredServices <em>Required Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Services</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent#getRequiredServices()
	 * @see #getDynamicComponent()
	 * @generated
	 */
	EReference getDynamicComponent_RequiredServices();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement <em>Service Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Requirement</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement
	 * @generated
	 */
	EClass getServiceRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getCardinality()
	 * @see #getServiceRequirement()
	 * @generated
	 */
	EAttribute getServiceRequirement_Cardinality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getPolicy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getPolicy()
	 * @see #getServiceRequirement()
	 * @generated
	 */
	EAttribute getServiceRequirement_Policy();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement#getReference()
	 * @see #getServiceRequirement()
	 * @generated
	 */
	EReference getServiceRequirement_Reference();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY <em>LINKING POLICY</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>LINKING POLICY</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY
	 * @generated
	 */
	EEnum getLINKING_POLICY();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OSGiInfrastructureFactory getOSGiInfrastructureFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Bundles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__BUNDLES = eINSTANCE.getProject_Bundles();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__SERVICES = eINSTANCE.getProject_Services();

		/**
		 * The meta object literal for the '<em><b>All Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__ALL_COMPONENTS = eINSTANCE.getProject_AllComponents();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.BundleImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Symbolic Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__SYMBOLIC_NAME = eINSTANCE.getBundle_SymbolicName();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__VERSION = eINSTANCE.getBundle_Version();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__COMPONENTS = eINSTANCE.getBundle_Components();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl <em>Dynamic Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getDynamicComponent()
		 * @generated
		 */
		EClass DYNAMIC_COMPONENT = eINSTANCE.getDynamicComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_COMPONENT__NAME = eINSTANCE.getDynamicComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_COMPONENT__IMPLEMENTATION = eINSTANCE.getDynamicComponent_Implementation();

		/**
		 * The meta object literal for the '<em><b>Provides</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_COMPONENT__PROVIDES = eINSTANCE.getDynamicComponent_Provides();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_COMPONENT__REQUIRES = eINSTANCE.getDynamicComponent_Requires();

		/**
		 * The meta object literal for the '<em><b>Required Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_COMPONENT__REQUIRED_SERVICES = eINSTANCE.getDynamicComponent_RequiredServices();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl <em>Service Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getServiceRequirement()
		 * @generated
		 */
		EClass SERVICE_REQUIREMENT = eINSTANCE.getServiceRequirement();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_REQUIREMENT__CARDINALITY = eINSTANCE.getServiceRequirement_Cardinality();

		/**
		 * The meta object literal for the '<em><b>Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_REQUIREMENT__POLICY = eINSTANCE.getServiceRequirement_Policy();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_REQUIREMENT__REFERENCE = eINSTANCE.getServiceRequirement_Reference();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY <em>LINKING POLICY</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl#getLINKING_POLICY()
		 * @generated
		 */
		EEnum LINKING_POLICY = eINSTANCE.getLINKING_POLICY();

	}

} //OSGiInfrastructurePackage
