package it.nextworks.nfvmano.timeo.nso.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;

/**
 * Internal message sent to an NS Manager to request the instantiation of a new NS
 * 
 * @author nextworks
 *
 */
public class InstantiateNsRequestMessage extends EngineMessage {

	@JsonProperty("request")
	private InstantiateNsRequest request;
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId	ID of the NS Instance to be instantiated
	 * @param operationId	ID of operation associated to the NS instantiation procedure
	 * @param request		Request with the details of the NS instance instantiation
	 */
	@JsonCreator
	public InstantiateNsRequestMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") InstantiateNsRequest request) {
		this.type = EngineMessageType.INSTANTIATE_NS_REQUEST;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public InstantiateNsRequest getRequest() {
		return request;
	}
	
	

}
