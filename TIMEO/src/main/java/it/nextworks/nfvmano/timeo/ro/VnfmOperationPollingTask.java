package it.nextworks.nfvmano.timeo.ro;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.vnfm.Vnfm;

/**
 * Class that implements the task to send polling requests
 * to the VIM in order to detect changes in the status
 * of the resources.
 * 
 * @author nextworks
 *
 */
public class VnfmOperationPollingTask implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(VnfmOperationPollingTask.class);
	
	private VnfmOperationPollingManager pollingManager;

	public VnfmOperationPollingTask(VnfmOperationPollingManager pollingManager) {
		this.pollingManager = pollingManager;
	}
	
	@Override
	public void run() {
		log.debug("Running VNFM operation polling task");
		Map<String, PolledOperation> polledOperations = pollingManager.getPolledOperationsCopy();
		List<String> verifiedOperationIds = new ArrayList<>();
		synchronized (polledOperations) {
			for (Map.Entry<String, PolledOperation> e : polledOperations.entrySet()) {
				PolledOperation operation = e.getValue();
				OperationStatus expectedStatus = operation.getExpectedStatus();
				switch (expectedStatus) {
				case SUCCESSFULLY_DONE: {
					if (checkOperationSuccessfulResult(operation)) verifiedOperationIds.add(operation.getOperationId());
					break;
				}

				default: {
					log.error("Expected status not supported for polled VNFM operation");
					break;
				}
				}
			}
		}
		for (String opId : verifiedOperationIds) {
			pollingManager.removeOperation(opId);
			log.debug("Operation " + opId + " removed from polling processing.");
		}
		log.debug("VNFM polling task terminated");
	}
	
	private boolean checkOperationSuccessfulResult(PolledOperation operation) {
		String operationId = operation.getOperationId();
		log.debug("Check status for operation " + operationId);
		Vnfm vnfm = operation.getVnfm();
		try {
			OperationStatus operationStatus = vnfm.getOperationStatus(operationId);
			if (operationStatus.equals(OperationStatus.SUCCESSFULLY_DONE)) {
				log.debug("Successful operation - sending notification");
				operation.getListener().notifyVnfmOperationResult(operationId, operation.getVnfId(), operationStatus);
				log.debug("Notification sent");
				return true;
			} else if (operationStatus.equals(OperationStatus.FAILED)) {
				log.debug("Failed operation - sending notification");
				operation.getListener().notifyVnfmOperationResult(operationId, operation.getVnfId(), operationStatus);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Operation still under processing - continuing polling.");
				return false;
			}
		} catch (MethodNotImplementedException e) {
			log.error(e.getMessage());
		} catch (NotExistingEntityException e) {
			log.error(e.getMessage());
		} catch (FailedOperationException e) {
			log.error(e.getMessage());
		} catch (MalformattedElementException e) {
			log.error(e.getMessage());
		}
		return false;
	}
	
		

}
