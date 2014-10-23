/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependenciesPackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.DependencyPath;
import org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.Hop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl#getHops <em>Hops</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.dependencies.impl.DependencyPathImpl#isCycle <em>Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyPathImpl extends EObjectImpl implements DependencyPath {
	/**
	 * The cached value of the '{@link #getHops() <em>Hops</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHops()
	 * @generated
	 * @ordered
	 */
	protected EList<Hop> hops;

	/**
	 * The default value of the '{@link #isCycle() <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCycle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CYCLE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependenciesPackage.Literals.DEPENDENCY_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hop> getHops() {
		if (hops == null) {
			hops = new EObjectContainmentEList<Hop>(Hop.class, this, DependenciesPackage.DEPENDENCY_PATH__HOPS);
		}
		return hops;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicComponent getFrom() {
		DynamicComponent from = basicGetFrom();
		return from != null && from.eIsProxy() ? (DynamicComponent)eResolveProxy((InternalEObject)from) : from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public DynamicComponent basicGetFrom() {
		if (getHops().isEmpty()) {
			return null;
		} else {
			return getHops().get(0).getFrom();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicComponent getTo() {
		DynamicComponent to = basicGetTo();
		return to != null && to.eIsProxy() ? (DynamicComponent)eResolveProxy((InternalEObject)to) : to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public DynamicComponent basicGetTo() {
		if (getHops().isEmpty()) {
			return null;
		} else {
			return getHops().get(getHops().size() - 1).getTo();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public boolean isCycle() {
		return getFrom() == getTo();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public boolean includes(DynamicComponent component) {
		if (getHops().isEmpty()) {
			return false;
		} else {
			for (Hop hop : getHops()) {
				if (hop.getFrom() == component) {
					return true;
				}
			}
			if (getHops().get(getHops().size() - 1).getTo() == component) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public Hop followingHop(DynamicComponent component) {
		if (getHops().isEmpty()) {
			return null;
		} else {
			for (Hop hop : getHops()) {
				if (hop.getFrom() == component) {
					return hop;
				}
			}
			if (getHops().get(getHops().size() - 1).getTo() == component && isCycle()) {
				return getHops().get(0);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DependenciesPackage.DEPENDENCY_PATH__HOPS:
				return ((InternalEList<?>)getHops()).basicRemove(otherEnd, msgs);
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
			case DependenciesPackage.DEPENDENCY_PATH__HOPS:
				return getHops();
			case DependenciesPackage.DEPENDENCY_PATH__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case DependenciesPackage.DEPENDENCY_PATH__TO:
				if (resolve) return getTo();
				return basicGetTo();
			case DependenciesPackage.DEPENDENCY_PATH__CYCLE:
				return isCycle();
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
			case DependenciesPackage.DEPENDENCY_PATH__HOPS:
				getHops().clear();
				getHops().addAll((Collection<? extends Hop>)newValue);
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
			case DependenciesPackage.DEPENDENCY_PATH__HOPS:
				getHops().clear();
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
			case DependenciesPackage.DEPENDENCY_PATH__HOPS:
				return hops != null && !hops.isEmpty();
			case DependenciesPackage.DEPENDENCY_PATH__FROM:
				return basicGetFrom() != null;
			case DependenciesPackage.DEPENDENCY_PATH__TO:
				return basicGetTo() != null;
			case DependenciesPackage.DEPENDENCY_PATH__CYCLE:
				return isCycle() != CYCLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DependencyPath) {
			DependencyPath zeOther = (DependencyPath) obj;
			if (getHops().size() != zeOther.getHops().size()) {
				return false;
			} else {
				return comparePath(this, zeOther);
			}
		}
		return false;
	}
	
	private boolean comparePath(DependencyPath path1, DependencyPath path2) {
		if (path1.isCycle() != path2.isCycle()) {
			return false;
		} else {
			if (path2.includes(path1.getFrom())) {
				for (Hop hop : path1.getHops()) {
					Hop secondHop = path2.followingHop(hop.getFrom());
					if (!hop.equals(secondHop)) {
						return false;
					} 
				}
				return true;
			} else {
				return false;
			}
		}
	}

} //DependencyPathImpl
