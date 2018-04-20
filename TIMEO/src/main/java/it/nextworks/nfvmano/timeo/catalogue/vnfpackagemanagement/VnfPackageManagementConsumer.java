package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement;

import it.nextworks.nfvmano.libs.catalogues.interfaces.VnfPackageManagementConsumerInterface;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.VnfPackageChangeNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.VnfPackageOnboardingNotification;
import it.nextworks.nfvmano.timeo.common.ConsumerType;

/**
 * Abstract class which represents a consumer for VNF package management notifications.
 * It must be extended by specific types of consumers which implements the actual
 * interaction with the external entities to be notified.
 * 
 * @author nextworks
 *
 */
public abstract class VnfPackageManagementConsumer implements VnfPackageManagementConsumerInterface {

	protected ConsumerType type;
	
	public VnfPackageManagementConsumer() {	}
	
	/**
	 * Constructor
	 * 
	 * @param type type of the consumer; it specifies the kind of interaction with the external entities
	 */
	public VnfPackageManagementConsumer(ConsumerType type) {
		this.type = type;
	}
	
	

	/**
	 * @return the type
	 */
	public ConsumerType getType() {
		return type;
	}

	@Override
	public void notify(VnfPackageChangeNotification notification) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notify(VnfPackageOnboardingNotification notification) {
		// TODO Auto-generated method stub

	}

}
