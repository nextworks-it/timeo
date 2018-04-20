package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import it.nextworks.nfvmano.libs.common.enums.ResponseCode;

/**
 * This interface models the interaction between the SDN controller and the NFVO and 
 * it is used for asynchronous notifications or responses to the NFVO.  
 * It must be implemented by the NFVO core and invoked by the SDN controller plugin.
 * 
 * @author nextworks
 *
 */
public interface SdnControllerConsumerInterface {

	/**
	 * Method used to notify the NFVO about the result of an operation
	 * 
	 * @param operationId ID of the operation
	 * @param responseCode result of the operation
	 * @param errorMessage human readable error message
	 */
	public void notifySdnControllerOperationResult(String operationId, ResponseCode responseCode, String errorMessage);
	
}
