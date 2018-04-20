package it.nextworks.nfvmano.timeo.rc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;

public class ComputationReleaseMessage extends ComputationMessage {

	@JsonProperty("request")
	TerminateNsRequest request;
	
	@JsonCreator
	public ComputationReleaseMessage(@JsonProperty("operationId") String operationId, 
			@JsonProperty("request") TerminateNsRequest request) {
		this.type = ComputationMessageType.RELEASE;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public TerminateNsRequest getRequest() {
		return request;
	}
	
	

}
