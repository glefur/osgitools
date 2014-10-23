/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyNode;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.ServiceDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.ServiceDependencyImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.ServiceDependencyImpl#getVia <em>Via</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceDependencyImpl extends EObjectImpl implements ServiceDependency {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected DependencyNode target;

	/**
	 * The cached value of the '{@link #getVia() <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVia()
	 * @generated
	 * @ordered
	 */
	protected Service via;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependenciesPackage.Literals.SERVICE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (DependencyNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependenciesPackage.SERVICE_DEPENDENCY__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(DependencyNode newTarget) {
		DependencyNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependenciesPackage.SERVICE_DEPENDENCY__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getVia() {
		if (via != null && via.eIsProxy()) {
			InternalEObject oldVia = (InternalEObject)via;
			via = (Service)eResolveProxy(oldVia);
			if (via != oldVia) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependenciesPackage.SERVICE_DEPENDENCY__VIA, oldVia, via));
			}
		}
		return via;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service basicGetVia() {
		return via;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVia(Service newVia) {
		Service oldVia = via;
		via = newVia;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependenciesPackage.SERVICE_DEPENDENCY__VIA, oldVia, via));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DependenciesPackage.SERVICE_DEPENDENCY__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case DependenciesPackage.SERVICE_DEPENDENCY__VIA:
				if (resolve) return getVia();
				return basicGetVia();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DependenciesPackage.SERVICE_DEPENDENCY__TARGET:
				setTarget((DependencyNode)newValue);
				return;
			case DependenciesPackage.SERVICE_DEPENDENCY__VIA:
				setVia((Service)newValue);
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
			case DependenciesPackage.SERVICE_DEPENDENCY__TARGET:
				setTarget((DependencyNode)null);
				return;
			case DependenciesPackage.SERVICE_DEPENDENCY__VIA:
				setVia((Service)null);
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
			case DependenciesPackage.SERVICE_DEPENDENCY__TARGET:
				return target != null;
			case DependenciesPackage.SERVICE_DEPENDENCY__VIA:
				return via != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("--[");
		builder.append(getVia().getName());
		builder.append("]-->");
		builder.append(getTarget().getSource().getName());
		return super.toString();
	}

} //ServiceDependencyImpl
