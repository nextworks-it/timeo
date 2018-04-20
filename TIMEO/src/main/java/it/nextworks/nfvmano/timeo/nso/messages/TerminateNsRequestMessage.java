package it.nextworks.nfvmano.timeo.nso.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;

/**
 * Internal message sent to an NS Manager to request the termination of an existing NS instance
 * 
 * @author nextworks
 *
 */
public class TerminateNsRequestMessage extends EngineMessage {

	@JsonProperty("request")
	private TerminateNsRequest request;
	
	public TerminateNsRequestMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") TerminateNsRequest request) {
		this.type = EngineMessageType.TERMINATE_NS_REQUEST;
		this.operationId = operationId;
		this.nsInstanceId = nsInstanceId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public TerminateNsRequest getRequest() {
		return request;
	}
	
	

}
