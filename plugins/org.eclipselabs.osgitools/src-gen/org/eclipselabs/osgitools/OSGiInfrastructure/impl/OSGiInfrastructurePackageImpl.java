/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.osgitools.OSGiInfrastructure.Bundle;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructureFactory;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;
import org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependenciesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OSGiInfrastructurePackageImpl extends EPackageImpl implements OSGiInfrastructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linkinG_POLICYEEnum = null;

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
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OSGiInfrastructurePackageImpl() {
		super(eNS_URI, OSGiInfrastructureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OSGiInfrastructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OSGiInfrastructurePackage init() {
		if (isInited) return (OSGiInfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage(OSGiInfrastructurePackage.eNS_URI);

		// Obtain or create and register package
		OSGiInfrastructurePackageImpl theOSGiInfrastructurePackage = (OSGiInfrastructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OSGiInfrastructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OSGiInfrastructurePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DependenciesPackageImpl theDependenciesPackage = (DependenciesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DependenciesPackage.eNS_URI) instanceof DependenciesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DependenciesPackage.eNS_URI) : DependenciesPackage.eINSTANCE);

		// Create package meta-data objects
		theOSGiInfrastructurePackage.createPackageContents();
		theDependenciesPackage.createPackageContents();

		// Initialize created meta-data
		theOSGiInfrastructurePackage.initializePackageContents();
		theDependenciesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOSGiInfrastructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OSGiInfrastructurePackage.eNS_URI, theOSGiInfrastructurePackage);
		return theOSGiInfrastructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Bundles() {
		return (EReference)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Services() {
		return (EReference)projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_AllComponents() {
		return (EReference)projectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundle() {
		return bundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_SymbolicName() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundle_Version() {
		return (EAttribute)bundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundle_Components() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicComponent() {
		return dynamicComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicComponent_Name() {
		return (EAttribute)dynamicComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicComponent_Implementation() {
		return (EAttribute)dynamicComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicComponent_Provides() {
		return (EReference)dynamicComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicComponent_Requires() {
		return (EReference)dynamicComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicComponent_RequiredServices() {
		return (EReference)dynamicComponentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Name() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceRequirement() {
		return serviceRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRequirement_Cardinality() {
		return (EAttribute)serviceRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRequirement_Policy() {
		return (EAttribute)serviceRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceRequirement_Reference() {
		return (EReference)serviceRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLINKING_POLICY() {
		return linkinG_POLICYEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSGiInfrastructureFactory getOSGiInfrastructureFactory() {
		return (OSGiInfrastructureFactory)getEFactoryInstance();
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
		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEReference(projectEClass, PROJECT__BUNDLES);
		createEReference(projectEClass, PROJECT__SERVICES);
		createEReference(projectEClass, PROJECT__ALL_COMPONENTS);

		bundleEClass = createEClass(BUNDLE);
		createEAttribute(bundleEClass, BUNDLE__SYMBOLIC_NAME);
		createEAttribute(bundleEClass, BUNDLE__VERSION);
		createEReference(bundleEClass, BUNDLE__COMPONENTS);

		dynamicComponentEClass = createEClass(DYNAMIC_COMPONENT);
		createEAttribute(dynamicComponentEClass, DYNAMIC_COMPONENT__NAME);
		createEAttribute(dynamicComponentEClass, DYNAMIC_COMPONENT__IMPLEMENTATION);
		createEReference(dynamicComponentEClass, DYNAMIC_COMPONENT__PROVIDES);
		createEReference(dynamicComponentEClass, DYNAMIC_COMPONENT__REQUIRES);
		createEReference(dynamicComponentEClass, DYNAMIC_COMPONENT__REQUIRED_SERVICES);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__NAME);

		serviceRequirementEClass = createEClass(SERVICE_REQUIREMENT);
		createEAttribute(serviceRequirementEClass, SERVICE_REQUIREMENT__CARDINALITY);
		createEAttribute(serviceRequirementEClass, SERVICE_REQUIREMENT__POLICY);
		createEReference(serviceRequirementEClass, SERVICE_REQUIREMENT__REFERENCE);

		// Create enums
		linkinG_POLICYEEnum = createEEnum(LINKING_POLICY);
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
		DependenciesPackage theDependenciesPackage = (DependenciesPackage)EPackage.Registry.INSTANCE.getEPackage(DependenciesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDependenciesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Bundles(), this.getBundle(), null, "bundles", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Services(), this.getService(), null, "services", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_AllComponents(), this.getDynamicComponent(), null, "allComponents", null, 0, -1, Project.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(projectEClass, this.getService(), "getService", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "serviceName", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(projectEClass, this.getDynamicComponent(), "getProviders", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getService(), "service", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBundle_SymbolicName(), ecorePackage.getEString(), "symbolicName", null, 1, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBundle_Version(), ecorePackage.getEString(), "version", null, 1, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBundle_Components(), this.getDynamicComponent(), null, "components", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicComponentEClass, DynamicComponent.class, "DynamicComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicComponent_Name(), ecorePackage.getEString(), "name", null, 1, 1, DynamicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDynamicComponent_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, DynamicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicComponent_Provides(), this.getService(), null, "provides", null, 0, -1, DynamicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicComponent_Requires(), this.getServiceRequirement(), null, "requires", null, 0, -1, DynamicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicComponent_RequiredServices(), this.getService(), null, "requiredServices", null, 0, -1, DynamicComponent.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Name(), ecorePackage.getEString(), "name", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceRequirementEClass, ServiceRequirement.class, "ServiceRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceRequirement_Cardinality(), ecorePackage.getEString(), "cardinality", null, 1, 1, ServiceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceRequirement_Policy(), this.getLINKING_POLICY(), "policy", null, 0, 1, ServiceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceRequirement_Reference(), this.getService(), null, "reference", null, 1, 1, ServiceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(linkinG_POLICYEEnum, org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY.class, "LINKING_POLICY");
		addEEnumLiteral(linkinG_POLICYEEnum, org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY.STATIC);
		addEEnumLiteral(linkinG_POLICYEEnum, org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY.DYNAMIC);

		// Create resource
		createResource(eNS_URI);
	}

} //OSGiInfrastructurePackageImpl
