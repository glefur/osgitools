/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyNodeImpl#isComplete <em>Complete</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyNodeImpl extends EObjectImpl implements DependencyNode {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected DynamicComponent source;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceDependency> dependencies;

	/**
	 * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected boolean complete = COMPLETE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependenciesPackage.Literals.DEPENDENCY_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicComponent getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (DynamicComponent)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependenciesPackage.DEPENDENCY_NODE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicComponent basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(DynamicComponent newSource) {
		DynamicComponent oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependenciesPackage.DEPENDENCY_NODE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<ServiceDependency>(ServiceDependency.class, this, DependenciesPackage.DEPENDENCY_NODE__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplete(boolean newComplete) {
		boolean oldComplete = complete;
		complete = newComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependenciesPackage.DEPENDENCY_NODE__COMPLETE, oldComplete, complete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependenciesPackage.DEPENDENCY_NODE__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependenciesPackage.DEPENDENCY_NODE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case DependenciesPackage.DEPENDENCY_NODE__DEPENDENCIES:
				return getDependencies();
			case DependenciesPackage.DEPENDENCY_NODE__COMPLETE:
				return isComplete();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DependenciesPackage.DEPENDENCY_NODE__SOURCE:
				setSource((DynamicComponent)newValue);
				return;
			case DependenciesPackage.DEPENDENCY_NODE__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends ServiceDependency>)newValue);
				return;
			case DependenciesPackage.DEPENDENCY_NODE__COMPLETE:
				setComplete((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DependenciesPackage.DEPENDENCY_NODE__SOURCE:
				setSource((DynamicComponent)null);
				return;
			case DependenciesPackage.DEPENDENCY_NODE__DEPENDENCIES:
				getDependencies().clear();
				return;
			case DependenciesPackage.DEPENDENCY_NODE__COMPLETE:
				setComplete(COMPLETE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DependenciesPackage.DEPENDENCY_NODE__SOURCE:
				return source != null;
			case DependenciesPackage.DEPENDENCY_NODE__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case DependenciesPackage.DEPENDENCY_NODE__COMPLETE:
				return complete != COMPLETE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (complete: ");
		result.append(complete);
		result.append(')');
		return result.toString();
	}

} //DependencyNodeImpl
