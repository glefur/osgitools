/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesFactory;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency;
import org.eclipselabs.osgitools.OSGiInfrastructure.impl.OSGiInfrastructurePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DependenciesPackageImpl extends EPackageImpl implements DependenciesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependenciesManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hopEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DependenciesPackageImpl() {
		super(eNS_URI, DependenciesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DependenciesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DependenciesPackage init() {
		if (isInited) return (DependenciesPackage)EPackage.Registry.INSTANCE.getEPackage(DependenciesPackage.eNS_URI);

		// Obtain or create and register package
		DependenciesPackageImpl theDependenciesPackage = (DependenciesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DependenciesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DependenciesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		OSGiInfrastructurePackageImpl theOSGiInfrastructurePackage = (OSGiInfrastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OSGiInfrastructurePackage.eNS_URI) instanceof OSGiInfrastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OSGiInfrastructurePackage.eNS_URI) : OSGiInfrastructurePackage.eINSTANCE);

		// Create package meta-data objects
		theDependenciesPackage.createPackageContents();
		theOSGiInfrastructurePackage.createPackageContents();

		// Initialize created meta-data
		theDependenciesPackage.initializePackageContents();
		theOSGiInfrastructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDependenciesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DependenciesPackage.eNS_URI, theDependenciesPackage);
		return theDependenciesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependenciesManager() {
		return dependenciesManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependenciesManager_Project() {
		return (EReference)dependenciesManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependenciesManager_Nodes() {
		return (EAttribute)dependenciesManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyNode() {
		return dependencyNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyNode_Source() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyNode_Dependencies() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyNode_Complete() {
		return (EAttribute)dependencyNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceDependency() {
		return serviceDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceDependency_Target() {
		return (EReference)serviceDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceDependency_Via() {
		return (EReference)serviceDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyPath() {
		return dependencyPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyPath_Hops() {
		return (EReference)dependencyPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyPath_From() {
		return (EReference)dependencyPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyPath_To() {
		return (EReference)dependencyPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyPath_Cycle() {
		return (EAttribute)dependencyPathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHop() {
		return hopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHop_From() {
		return (EReference)hopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHop_To() {
		return (EReference)hopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHop_Via() {
		return (EReference)hopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesFactory getDependenciesFactory() {
		return (DependenciesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dependenciesManagerEClass = createEClass(DEPENDENCIES_MANAGER);
		createEReference(dependenciesManagerEClass, DEPENDENCIES_MANAGER__PROJECT);
		createEAttribute(dependenciesManagerEClass, DEPENDENCIES_MANAGER__NODES);

		dependencyNodeEClass = createEClass(DEPENDENCY_NODE);
		createEReference(dependencyNodeEClass, DEPENDENCY_NODE__SOURCE);
		createEReference(dependencyNodeEClass, DEPENDENCY_NODE__DEPENDENCIES);
		createEAttribute(dependencyNodeEClass, DEPENDENCY_NODE__COMPLETE);

		serviceDependencyEClass = createEClass(SERVICE_DEPENDENCY);
		createEReference(serviceDependencyEClass, SERVICE_DEPENDENCY__TARGET);
		createEReference(serviceDependencyEClass, SERVICE_DEPENDENCY__VIA);

		dependencyPathEClass = createEClass(DEPENDENCY_PATH);
		createEReference(dependencyPathEClass, DEPENDENCY_PATH__HOPS);
		createEReference(dependencyPathEClass, DEPENDENCY_PATH__FROM);
		createEReference(dependencyPathEClass, DEPENDENCY_PATH__TO);
		createEAttribute(dependencyPathEClass, DEPENDENCY_PATH__CYCLE);

		hopEClass = createEClass(HOP);
		createEReference(hopEClass, HOP__FROM);
		createEReference(hopEClass, HOP__TO);
		createEReference(hopEClass, HOP__VIA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		OSGiInfrastructurePackage theOSGiInfrastructurePackage = (OSGiInfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(OSGiInfrastructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(dependenciesManagerEClass, DependenciesManager.class, "DependenciesManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependenciesManager_Project(), theOSGiInfrastructurePackage.getProject(), null, "project", null, 1, 1, DependenciesManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(theOSGiInfrastructurePackage.getDynamicComponent());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getDependencyNode());
		g1.getETypeArguments().add(g2);
		initEAttribute(getDependenciesManager_Nodes(), g1, "nodes", null, 1, 1, DependenciesManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyNodeEClass, DependencyNode.class, "DependencyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyNode_Source(), theOSGiInfrastructurePackage.getDynamicComponent(), null, "source", null, 1, 1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyNode_Dependencies(), this.getServiceDependency(), null, "dependencies", null, 0, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependencyNode_Complete(), ecorePackage.getEBoolean(), "complete", "false", 0, 1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceDependencyEClass, ServiceDependency.class, "ServiceDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceDependency_Target(), this.getDependencyNode(), null, "target", null, 1, 1, ServiceDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceDependency_Via(), theOSGiInfrastructurePackage.getService(), null, "via", null, 1, 1, ServiceDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyPathEClass, DependencyPath.class, "DependencyPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyPath_Hops(), this.getHop(), null, "hops", null, 0, -1, DependencyPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyPath_From(), theOSGiInfrastructurePackage.getDynamicComponent(), null, "from", null, 1, 1, DependencyPath.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyPath_To(), theOSGiInfrastructurePackage.getDynamicComponent(), null, "to", null, 1, 1, DependencyPath.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependencyPath_Cycle(), ecorePackage.getEBoolean(), "cycle", null, 0, 1, DependencyPath.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(dependencyPathEClass, ecorePackage.getEBoolean(), "includes", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOSGiInfrastructurePackage.getDynamicComponent(), "component", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dependencyPathEClass, this.getHop(), "followingHop", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theOSGiInfrastructurePackage.getDynamicComponent(), "component", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hopEClass, Hop.class, "Hop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHop_From(), theOSGiInfrastructurePackage.getDynamicComponent(), null, "from", null, 1, 1, Hop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHop_To(), theOSGiInfrastructurePackage.getDynamicComponent(), null, "to", null, 1, 1, Hop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHop_Via(), theOSGiInfrastructurePackage.getService(), null, "via", null, 1, 1, Hop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //DependenciesPackageImpl
