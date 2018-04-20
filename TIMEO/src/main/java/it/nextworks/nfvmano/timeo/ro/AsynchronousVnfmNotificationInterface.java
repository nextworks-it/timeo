package it.nextworks.nfvmano.timeo.ro;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;

public interface AsynchronousVnfmNotificationInterface {

	public void notifyVnfmOperationResult(String operationId, String vnfId, OperationStatus operationStatus);
	
}
