package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;

public class TerminateVnfMessage extends AllocationMessage {

	@JsonProperty("request")
	private TerminateNsRequest request;
	
	@JsonProperty("operationId")
	String operationId;
	
	@JsonCreator
	public TerminateVnfMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") TerminateNsRequest request) {
		this.type = AllocationMessageType.REMOVE_VNF;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public TerminateNsRequest getRequest() {
		return request;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
