/**
 */
package org.eclipselabs.osgitools.OSGiInfrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.osgitools.OSGiInfrastructure.LINKING_POLICY;
import org.eclipselabs.osgitools.OSGiInfrastructure.OSGiInfrastructurePackage;
import org.eclipselabs.osgitools.OSGiInfrastructure.Service;
import org.eclipselabs.osgitools.OSGiInfrastructure.ServiceRequirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl#getPolicy <em>Policy</em>}</li>
 *   <li>{@link org.eclipselabs.osgitools.OSGiInfrastructure.impl.ServiceRequirementImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceRequirementImpl extends EObjectImpl implements ServiceRequirement {
	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final String CARDINALITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected String cardinality = CARDINALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPolicy() <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final LINKING_POLICY POLICY_EDEFAULT = LINKING_POLICY.STATIC;

	/**
	 * The cached value of the '{@link #getPolicy() <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected LINKING_POLICY policy = POLICY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected Service reference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OSGiInfrastructurePackage.Literals.SERVICE_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinality(String newCardinality) {
		String oldCardinality = cardinality;
		cardinality = newCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OSGiInfrastructurePackage.SERVICE_REQUIREMENT__CARDINALITY, oldCardinality, cardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LINKING_POLICY getPolicy() {
		return policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicy(LINKING_POLICY newPolicy) {
		LINKING_POLICY oldPolicy = policy;
		policy = newPolicy == null ? POLICY_EDEFAULT : newPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OSGiInfrastructurePackage.SERVICE_REQUIREMENT__POLICY, oldPolicy, policy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (Service)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OSGiInfrastructurePackage.SERVICE_REQUIREMENT__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(Service newReference) {
		Service oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OSGiInfrastructurePackage.SERVICE_REQUIREMENT__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__CARDINALITY:
				return getCardinality();
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__POLICY:
				return getPolicy();
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
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
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__CARDINALITY:
				setCardinality((String)newValue);
				return;
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__POLICY:
				setPolicy((LINKING_POLICY)newValue);
				return;
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__REFERENCE:
				setReference((Service)newValue);
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
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__CARDINALITY:
				setCardinality(CARDINALITY_EDEFAULT);
				return;
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__POLICY:
				setPolicy(POLICY_EDEFAULT);
				return;
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__REFERENCE:
				setReference((Service)null);
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
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__CARDINALITY:
				return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__POLICY:
				return policy != POLICY_EDEFAULT;
			case OSGiInfrastructurePackage.SERVICE_REQUIREMENT__REFERENCE:
				return reference != null;
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
		result.append(" (cardinality: ");
		result.append(cardinality);
		result.append(", policy: ");
		result.append(policy);
		result.append(')');
		return result.toString();
	}

} //ServiceRequirementImpl
