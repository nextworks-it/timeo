package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement;

import it.nextworks.nfvmano.libs.catalogues.interfaces.NsdManagementConsumerInterface;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.NsdChangeNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.NsdOnBoardingNotification;
import it.nextworks.nfvmano.timeo.common.ConsumerType;

/**
 * Abstract class which represents a consumer for NSD management notifications.
 * It must be extended by specific types of consumers which implements the actual
 * interaction with the external entities to be notified.
 * 
 * @author nextworks
 *
 */
public abstract class NsdManagementConsumer implements NsdManagementConsumerInterface {

	protected ConsumerType type;
	
	public NsdManagementConsumer() { }
	
	/**
	 * Constructor
	 * 
	 * @param type type of the consumer; it specifies the kind of interaction with the external entities
	 */
	public NsdManagementConsumer(ConsumerType type) {
		this.type = type;
	}

	@Override
	public void notify(NsdOnBoardingNotification notification) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notify(NsdChangeNotification notification) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the type
	 */
	public ConsumerType getType() {
		return type;
	}
	
	

}
