package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;

public class VnfmOperationAckMessage extends AllocationMessage {

	@JsonProperty("operationId")
	private String operationId;
	
	@JsonProperty("vnfId")
	private String vnfId;
	
	@JsonProperty("operationStatus")
	private OperationStatus operationStatus;
	
	public VnfmOperationAckMessage() { }
	
	@JsonCreator
	public VnfmOperationAckMessage(@JsonProperty("operationId") String operationId,
			@JsonProperty("vnfId") String vnfId,
			@JsonProperty("operationStatus") OperationStatus operationStatus) { 
		this.type = AllocationMessageType.VNFM_OPERATION_ACK;
		this.operationId = operationId;
		this.vnfId = vnfId;
		this.operationStatus = operationStatus;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * @return the vnfId
	 */
	public String getVnfId() {
		return vnfId;
	}

	/**
	 * @return the operationStatus
	 */
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	
	

}
