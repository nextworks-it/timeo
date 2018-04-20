package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ModifyVnfInformationRequest;



public class ConfigureVnfRequestMessage extends VnfmMessage {
	
	@JsonProperty("request")
	private ModifyVnfInformationRequest request;

	@JsonCreator
	public ConfigureVnfRequestMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") ModifyVnfInformationRequest request) {
		this.type = VnfmMessageType.CONFIGURE_VNF;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public ModifyVnfInformationRequest getRequest() {
		return request;
	}

	
	
}
