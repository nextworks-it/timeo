package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.TerminateVnfRequest;

public class TerminateVnfRequestMessage extends VnfmMessage {
	
	@JsonProperty("request")
	private TerminateVnfRequest request;

	@JsonCreator
	public TerminateVnfRequestMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") TerminateVnfRequest request) {
		this.type = VnfmMessageType.TERMINATE_VNF;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public TerminateVnfRequest getRequest() {
		return request;
	}

	
	
}
