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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.osgitools.OSGiInfrastructure.Bundle;
import org.eclipselabs.osgitools.OSGiInfrastructure.DynamicComponent;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.Project;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl#getBundles <em>Bundles</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ProjectImpl#getAllComponents <em>All Components</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends EObjectImpl implements Project {
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
	 * The cached value of the '{@link #getBundles() <em>Bundles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundles()
	 * @generated
	 * @ordered
	 */
	protected EList<Bundle> bundles;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OSGiInfrastructurePackage.Literals.PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OSGiInfrastructurePackage.PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bundle> getBundles() {
		if (bundles == null) {
			bundles = new EObjectContainmentEList<Bundle>(Bundle.class, this, OSGiInfrastructurePackage.PROJECT__BUNDLES);
		}
		return bundles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<Service>(Service.class, this, OSGiInfrastructurePackage.PROJECT__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public EList<DynamicComponent> getAllComponents() {
		EList<DynamicComponent> result = new BasicEList<DynamicComponent>();
		for (Bundle bundle : getBundles()) {
			for (DynamicComponent dynamicComponent : bundle.getComponents()) {
				result.add(dynamicComponent);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLF
	 */
	public Service getService(String serviceName) {
		if (serviceName != null) {
			for (Service service : getServices()) {
				if (serviceName.equals(service.getName())) {
					return service;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated GLFs
	 */
	public EList<DynamicComponent> getProviders(Service service) {
		EList<DynamicComponent> result = new BasicEList<DynamicComponent>();
		for (DynamicComponent dynamicComponent : getAllComponents()) {
			if (dynamicComponent.getProvides().contains(service)) {
				result.add(dynamicComponent);
			}
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
			case OSGiInfrastructurePackage.PROJECT__BUNDLES:
				return ((InternalEList<?>)getBundles()).basicRemove(otherEnd, msgs);
			case OSGiInfrastructurePackage.PROJECT__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
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
			case OSGiInfrastructurePackage.PROJECT__NAME:
				return getName();
			case OSGiInfrastructurePackage.PROJECT__BUNDLES:
				return getBundles();
			case OSGiInfrastructurePackage.PROJECT__SERVICES:
				return getServices();
			case OSGiInfrastructurePackage.PROJECT__ALL_COMPONENTS:
				return getAllComponents();
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
			case OSGiInfrastructurePackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case OSGiInfrastructurePackage.PROJECT__BUNDLES:
				getBundles().clear();
				getBundles().addAll((Collection<? extends Bundle>)newValue);
				return;
			case OSGiInfrastructurePackage.PROJECT__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
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
			case OSGiInfrastructurePackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OSGiInfrastructurePackage.PROJECT__BUNDLES:
				getBundles().clear();
				return;
			case OSGiInfrastructurePackage.PROJECT__SERVICES:
				getServices().clear();
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
			case OSGiInfrastructurePackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OSGiInfrastructurePackage.PROJECT__BUNDLES:
				return bundles != null && !bundles.isEmpty();
			case OSGiInfrastructurePackage.PROJECT__SERVICES:
				return services != null && !services.isEmpty();
			case OSGiInfrastructurePackage.PROJECT__ALL_COMPONENTS:
				return !getAllComponents().isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
