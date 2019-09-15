package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import io.swagger.client.model.ArofConnectionEndPointSpec;
import io.swagger.client.model.ArofServiceInterfacePointSpec;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

public class TapiTopologyArofCp extends TapiTopologyCp {

	ArofConnectionEndPointSpec arofSpec;

	//TODO AROF: The new API seems to model the CEP as ServiceInterfacePoints
	private ArofServiceInterfacePointSpec arofServiceInterfacePointSpec;
	
	public TapiTopologyArofCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink, String address,
			String cpId, String cpdId) {
		super(node, outgoingLink, incomingLink, address, cpId, cpdId);
		this.layerProtocol = LayerProtocol.AROF;
	}
	
	public TapiTopologyArofCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink, String address,
			String cpId) {
		super(node, outgoingLink, incomingLink, address, cpId);
		this.layerProtocol = LayerProtocol.AROF;
	}

	/**
	 * @return the arofSpec
	 */
	public ArofConnectionEndPointSpec getArofSpec() {
		return arofSpec;
	}

	/**
	 * @param arofSpec the arofSpec to set
	 */
	public void setArofSpec(ArofConnectionEndPointSpec arofSpec) {
		this.arofSpec = arofSpec;
	}


	public ArofServiceInterfacePointSpec getArofServiceInterfacePointSpec() {
		return arofServiceInterfacePointSpec;
	}

	public void setArofServiceInterfacePointSpec(ArofServiceInterfacePointSpec arofServiceInterfacePointSpec) {
		this.arofServiceInterfacePointSpec = arofServiceInterfacePointSpec;
	}
}
