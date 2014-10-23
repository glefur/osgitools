/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesFactory
 * @model kind="package"
 * @generated
 */
public interface DependenciesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dependencies";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/osgitools/infrastructure/dependencies/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "osgi-dependencies";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DependenciesPackage eINSTANCE = org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesManagerImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getDependenciesManager()
	 * @generated
	 */
	int DEPENDENCIES_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCIES_MANAGER__PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCIES_MANAGER__NODES = 1;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCIES_MANAGER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getDependencyNode()
	 * @generated
	 */
	int DEPENDENCY_NODE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__DEPENDENCIES = 1;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__COMPLETE = 2;

	/**
	 * The number of structural features of the '<em>Dependency Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.ServiceDependencyImpl <em>Service Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.ServiceDependencyImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getServiceDependency()
	 * @generated
	 */
	int SERVICE_DEPENDENCY = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY__VIA = 1;

	/**
	 * The number of structural features of the '<em>Service Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl <em>Dependency Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getDependencyPath()
	 * @generated
	 */
	int DEPENDENCY_PATH = 3;

	/**
	 * The feature id for the '<em><b>Hops</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_PATH__HOPS = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_PATH__FROM = 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_PATH__TO = 2;

	/**
	 * The feature id for the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_PATH__CYCLE = 3;

	/**
	 * The number of structural features of the '<em>Dependency Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_PATH_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.HopImpl <em>Hop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.HopImpl
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getHop()
	 * @generated
	 */
	int HOP = 4;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOP__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOP__TO = 1;

	/**
	 * The feature id for the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOP__VIA = 2;

	/**
	 * The number of structural features of the '<em>Hop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOP_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager
	 * @generated
	 */
	EClass getDependenciesManager();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager#getProject()
	 * @see #getDependenciesManager()
	 * @generated
	 */
	EReference getDependenciesManager_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nodes</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager#getNodes()
	 * @see #getDependenciesManager()
	 * @generated
	 */
	EAttribute getDependenciesManager_Nodes();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Node</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode
	 * @generated
	 */
	EClass getDependencyNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode#getSource()
	 * @see #getDependencyNode()
	 * @generated
	 */
	EReference getDependencyNode_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode#getDependencies()
	 * @see #getDependencyNode()
	 * @generated
	 */
	EReference getDependencyNode_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode#isComplete <em>Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode#isComplete()
	 * @see #getDependencyNode()
	 * @generated
	 */
	EAttribute getDependencyNode_Complete();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency <em>Service Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Dependency</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency
	 * @generated
	 */
	EClass getServiceDependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getTarget()
	 * @see #getServiceDependency()
	 * @generated
	 */
	EReference getServiceDependency_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getVia <em>Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Via</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency#getVia()
	 * @see #getServiceDependency()
	 * @generated
	 */
	EReference getServiceDependency_Via();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath <em>Dependency Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Path</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath
	 * @generated
	 */
	EClass getDependencyPath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getHops <em>Hops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hops</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getHops()
	 * @see #getDependencyPath()
	 * @generated
	 */
	EReference getDependencyPath_Hops();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getFrom()
	 * @see #getDependencyPath()
	 * @generated
	 */
	EReference getDependencyPath_From();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#getTo()
	 * @see #getDependencyPath()
	 * @generated
	 */
	EReference getDependencyPath_To();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#isCycle <em>Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cycle</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath#isCycle()
	 * @see #getDependencyPath()
	 * @generated
	 */
	EAttribute getDependencyPath_Cycle();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop <em>Hop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hop</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop
	 * @generated
	 */
	EClass getHop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getFrom()
	 * @see #getHop()
	 * @generated
	 */
	EReference getHop_From();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getTo()
	 * @see #getHop()
	 * @generated
	 */
	EReference getHop_To();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getVia <em>Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Via</em>'.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop#getVia()
	 * @see #getHop()
	 * @generated
	 */
	EReference getHop_Via();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DependenciesFactory getDependenciesFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesManagerImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getDependenciesManager()
		 * @generated
		 */
		EClass DEPENDENCIES_MANAGER = eINSTANCE.getDependenciesManager();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCIES_MANAGER__PROJECT = eINSTANCE.getDependenciesManager_Project();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCIES_MANAGER__NODES = eINSTANCE.getDependenciesManager_Nodes();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getDependencyNode()
		 * @generated
		 */
		EClass DEPENDENCY_NODE = eINSTANCE.getDependencyNode();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_NODE__SOURCE = eINSTANCE.getDependencyNode_Source();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_NODE__DEPENDENCIES = eINSTANCE.getDependencyNode_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_NODE__COMPLETE = eINSTANCE.getDependencyNode_Complete();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.ServiceDependencyImpl <em>Service Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.ServiceDependencyImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getServiceDependency()
		 * @generated
		 */
		EClass SERVICE_DEPENDENCY = eINSTANCE.getServiceDependency();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_DEPENDENCY__TARGET = eINSTANCE.getServiceDependency_Target();

		/**
		 * The meta object literal for the '<em><b>Via</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_DEPENDENCY__VIA = eINSTANCE.getServiceDependency_Via();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl <em>Dependency Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getDependencyPath()
		 * @generated
		 */
		EClass DEPENDENCY_PATH = eINSTANCE.getDependencyPath();

		/**
		 * The meta object literal for the '<em><b>Hops</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_PATH__HOPS = eINSTANCE.getDependencyPath_Hops();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_PATH__FROM = eINSTANCE.getDependencyPath_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_PATH__TO = eINSTANCE.getDependencyPath_To();

		/**
		 * The meta object literal for the '<em><b>Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_PATH__CYCLE = eINSTANCE.getDependencyPath_Cycle();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.HopImpl <em>Hop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.HopImpl
		 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl#getHop()
		 * @generated
		 */
		EClass HOP = eINSTANCE.getHop();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOP__FROM = eINSTANCE.getHop_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOP__TO = eINSTANCE.getHop_To();

		/**
		 * The meta object literal for the '<em><b>Via</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOP__VIA = eINSTANCE.getHop_Via();

	}

} //DependenciesPackage
