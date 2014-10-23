/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesFactory;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DependenciesFactoryImpl extends EFactoryImpl implements DependenciesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DependenciesFactory init() {
		try {
			DependenciesFactory theDependenciesFactory = (DependenciesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/osgitools/infrastructure/dependencies/1.0"); 
			if (theDependenciesFactory != null) {
				return theDependenciesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DependenciesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DependenciesPackage.DEPENDENCIES_MANAGER: return createDependenciesManager();
			case DependenciesPackage.DEPENDENCY_NODE: return createDependencyNode();
			case DependenciesPackage.SERVICE_DEPENDENCY: return createServiceDependency();
			case DependenciesPackage.DEPENDENCY_PATH: return createDependencyPath();
			case DependenciesPackage.HOP: return createHop();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesManager createDependenciesManager() {
		DependenciesManagerImpl dependenciesManager = new DependenciesManagerImpl();
		return dependenciesManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyNode createDependencyNode() {
		DependencyNodeImpl dependencyNode = new DependencyNodeImpl();
		return dependencyNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDependency createServiceDependency() {
		ServiceDependencyImpl serviceDependency = new ServiceDependencyImpl();
		return serviceDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyPath createDependencyPath() {
		DependencyPathImpl dependencyPath = new DependencyPathImpl();
		return dependencyPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hop createHop() {
		HopImpl hop = new HopImpl();
		return hop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesPackage getDependenciesPackage() {
		return (DependenciesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DependenciesPackage getPackage() {
		return DependenciesPackage.eINSTANCE;
	}

} //DependenciesFactoryImpl
