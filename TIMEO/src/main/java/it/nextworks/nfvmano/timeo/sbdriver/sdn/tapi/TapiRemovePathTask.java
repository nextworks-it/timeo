package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerConsumerInterface;

/**
 * This task is a TAPI consumer that interacts with the SDN controller
 * (i.e. the TAPI provider) to remove one or more paths. When the task 
 * is finished, a notification is sent to the original requester, 
 * provided as input in the consumer field. 
 * 
 * @author nextworks
 *
 */
public class TapiRemovePathTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(TapiRemovePathTask.class);
	
	private String operationId;
	private DefaultApi api;
	private SdnControllerConsumerInterface consumer;
	private List<String> networkPathIds = new ArrayList<>();
	
	/**
	 * Constructor
	 * 
	 * @param operationId ID of the delete operation
	 * @param api Handler to interact with the TAPI provider
	 * @param consumer Entity to be notified about the result of the operation
	 * @param networkPathIds ID of the paths to be removed
	 */
	public TapiRemovePathTask(String operationId,
			DefaultApi api,
			SdnControllerConsumerInterface consumer,
			List<String> networkPathIds) {
		this.operationId = operationId;
		this.api = api;
		this.consumer = consumer;
		if (networkPathIds != null) this.networkPathIds = networkPathIds;
	}

	@Override
	public void run() {
		log.debug("Executing thread to remove network paths through TAPI connectivity service");
		for (String pathId : networkPathIds) {
			log.debug("Removing connection with ID " + pathId);
			try {
				api.createDeleteConnectivityServiceById(pathId);
				log.debug("Removed connection with ID " + pathId);
			} catch (ApiException e) {
				log.debug("Got API exception while removing connection " + pathId + ": " + e.getMessage());
				consumer.notifySdnControllerOperationResult(operationId, ResponseCode.FAILED_GENERIC, "Got API exception while removing connection " + pathId);
				return;
			}
		}
		consumer.notifySdnControllerOperationResult(operationId, ResponseCode.OK, null);
	}

}
