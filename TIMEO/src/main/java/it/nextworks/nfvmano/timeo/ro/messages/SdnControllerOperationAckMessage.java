package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;

public class SdnControllerOperationAckMessage extends AllocationMessage {

	@JsonProperty("operationId")
	private String operationId;
	
	@JsonProperty("operationStatus")
	private OperationStatus operationStatus;
	
	public SdnControllerOperationAckMessage() {	}
	
	@JsonCreator
	public SdnControllerOperationAckMessage(@JsonProperty("operationId") String operationId,
			@JsonProperty("operationStatus") OperationStatus operationStatus) {	
		this.type = AllocationMessageType.SDN_CONTROLLER_ACK;
		this.operationId = operationId;
		this.operationStatus = operationStatus;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * @return the operationStatus
	 */
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	
	

}
