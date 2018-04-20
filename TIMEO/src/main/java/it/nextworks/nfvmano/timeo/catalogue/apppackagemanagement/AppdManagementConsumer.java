package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement;

import it.nextworks.nfvmano.libs.catalogues.interfaces.MecAppPackageManagementConsumerInterface;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.AppPackageOnBoardingNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.AppPackageStateChangeNotification;
import it.nextworks.nfvmano.timeo.common.ConsumerType;

/**
 * Abstract class which represents a consumer for MEC app package management notifications.
 * It must be extended by specific types of consumers which implements the actual
 * interaction with the external entities to be notified.
 * 
 * @author nextworks
 *
 */
public abstract class AppdManagementConsumer implements MecAppPackageManagementConsumerInterface {

	protected ConsumerType type;
	
	public AppdManagementConsumer() { }
	
	public AppdManagementConsumer(ConsumerType type) {
		this.type = type;
	}

	@Override
	public void notify(AppPackageOnBoardingNotification notification) {	}

	@Override
	public void notify(AppPackageStateChangeNotification notification) { }

	/**
	 * @return the type
	 */
	public ConsumerType getType() {
		return type;
	}
	
	

}
