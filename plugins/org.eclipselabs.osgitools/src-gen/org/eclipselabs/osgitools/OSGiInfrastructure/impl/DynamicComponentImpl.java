/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;
import org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl#getProvides <em>Provides</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.DynamicComponentImpl#getRequiredServices <em>Required Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicComponentImpl extends EObjectImpl implements DynamicComponent {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected String implementation = IMPLEMENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProvides() <em>Provides</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvides()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> provides;

	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceRequirement> requires;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OSGiInfrastructurePackage.Literals.DYNAMIC_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OSGiInfrastructurePackage.DYNAMIC_COMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(String newImplementation) {
		String oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OSGiInfrastructurePackage.DYNAMIC_COMPONENT__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getProvides() {
		if (provides == null) {
			provides = new EObjectResolvingEList<Service>(Service.class, this, OSGiInfrastructurePackage.DYNAMIC_COMPONENT__PROVIDES);
		}
		return provides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceRequirement> getRequires() {
		if (requires == null) {
			requires = new EObjectContainmentEList<ServiceRequirement>(ServiceRequirement.class, this, OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public EList<Service> getRequiredServices() {
		EList<Service> result = new BasicEList<Service>();
		for (ServiceRequirement serviceRequirement : getRequires()) {
			result.add(serviceRequirement.getReference());
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRES:
				return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
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
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__NAME:
				return getName();
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__IMPLEMENTATION:
				return getImplementation();
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__PROVIDES:
				return getProvides();
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRES:
				return getRequires();
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRED_SERVICES:
				return getRequiredServices();
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
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__NAME:
				setName((String)newValue);
				return;
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__IMPLEMENTATION:
				setImplementation((String)newValue);
				return;
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__PROVIDES:
				getProvides().clear();
				getProvides().addAll((Collection<? extends Service>)newValue);
				return;
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends ServiceRequirement>)newValue);
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
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__PROVIDES:
				getProvides().clear();
				return;
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRES:
				getRequires().clear();
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
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__PROVIDES:
				return provides != null && !provides.isEmpty();
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRES:
				return requires != null && !requires.isEmpty();
			case OSGiInfrastructurePackage.DYNAMIC_COMPONENT__REQUIRED_SERVICES:
				return !getRequiredServices().isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", implementation: ");
		result.append(implementation);
		result.append(')');
		return result.toString();
	}

} //DynamicComponentImpl
