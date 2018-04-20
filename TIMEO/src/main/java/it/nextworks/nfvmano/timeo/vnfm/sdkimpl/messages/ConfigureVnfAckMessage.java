package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;


public class ConfigureVnfAckMessage extends VnfmMessage {
	
	@JsonProperty("notification")
	private SetConfigurationResponse notification;
	
	@JsonProperty("result")
	private OperationStatus result;

	@JsonCreator
	public ConfigureVnfAckMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("notification") SetConfigurationResponse notification,
			@JsonProperty("result") OperationStatus result) {
		this.type = VnfmMessageType.CONFIGURE_VNF_ACK;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.notification = notification;
		this.result = result;
	}

	/**
	 * @return the notification
	 */
	public SetConfigurationResponse getNotification() {
		return notification;
	}

	/**
	 * @return the result
	 */
	public OperationStatus getResult() {
		return result;
	}

	

	
	
}
