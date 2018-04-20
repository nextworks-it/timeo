package it.nextworks.nfvmano.timeo.nso.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessageType;

public class NotifyAllocationResultMessage extends EngineMessage {

	private boolean successful;
	
	@JsonProperty("allocationType")
	private AllocationMessageType allocationType;
	
	@JsonCreator
	public NotifyAllocationResultMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("successful") boolean isSuccessful,
			@JsonProperty("allocationType") AllocationMessageType allocationType) {
		this.type = EngineMessageType.NOTIFY_ALLOCATION_RESULT;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.successful = isSuccessful;
		this.allocationType = allocationType;
	}

	/**
	 * @return the isSuccessful
	 */
	@JsonProperty("successful")
	public boolean isSuccessful() {
		return successful;
	}

	/**
	 * @return the allocationType
	 */
	public AllocationMessageType getAllocationType() {
		return allocationType;
	}
	
}
