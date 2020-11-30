package it.nextworks.nfvmano.timeo.nso.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;

public class ScaleNsRequestMessage extends EngineMessage {

	@JsonProperty("request")
	private ScaleNsRequest request;
	
	@JsonCreator
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId ID of the NS instance to be scaled
	 * @param operationId ID of the lifecycle operation
	 * @param request scaling request
	 */
	public ScaleNsRequestMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
		@JsonProperty("operationId") String operationId,
		@JsonProperty("request") ScaleNsRequest request)  {
		this.type = EngineMessageType.SCALE_NS_REQUEST;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public ScaleNsRequest getRequest() {
		return request;
	}

}
