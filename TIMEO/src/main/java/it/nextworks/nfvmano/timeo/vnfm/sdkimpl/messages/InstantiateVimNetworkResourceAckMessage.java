package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;


public class InstantiateVimNetworkResourceAckMessage extends VnfmMessage {
	
	@JsonProperty("notification")
	private AllocateNetworkResponse notification;

	@JsonCreator
	public InstantiateVimNetworkResourceAckMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("notification") AllocateNetworkResponse notification) {
		this.type = VnfmMessageType.INSTANTIATE_VIM_NETWORK_RESOURCE_ACK;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.notification = notification;
	}

	/**
	 * @return the notification
	 */
	public AllocateNetworkResponse getNotification() {
		return notification;
	}

	

	
	
}
