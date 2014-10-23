/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage
 * @generated
 */
public class DependenciesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DependenciesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenciesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DependenciesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependenciesSwitch<Adapter> modelSwitch =
		new DependenciesSwitch<Adapter>() {
			@Override
			public Adapter caseDependenciesManager(DependenciesManager object) {
				return createDependenciesManagerAdapter();
			}
			@Override
			public Adapter caseDependencyNode(DependencyNode object) {
				return createDependencyNodeAdapter();
			}
			@Override
			public Adapter caseServiceDependency(ServiceDependency object) {
				return createServiceDependencyAdapter();
			}
			@Override
			public Adapter caseDependencyPath(DependencyPath object) {
				return createDependencyPathAdapter();
			}
			@Override
			public Adapter caseHop(Hop object) {
				return createHopAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesManager
	 * @generated
	 */
	public Adapter createDependenciesManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode
	 * @generated
	 */
	public Adapter createDependencyNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency <em>Service Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency
	 * @generated
	 */
	public Adapter createServiceDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath <em>Dependency Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath
	 * @generated
	 */
	public Adapter createDependencyPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop <em>Hop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop
	 * @generated
	 */
	public Adapter createHopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DependenciesAdapterFactory
