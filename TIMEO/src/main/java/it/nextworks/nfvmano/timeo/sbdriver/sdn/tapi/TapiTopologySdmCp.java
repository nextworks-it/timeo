package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
//import io.swagger.client.model.SdmPoolCapabilityPac;

public class TapiTopologySdmCp extends TapiTopologyCp {

	//private SdmPoolCapabilityPac sdmPoolPac;
	
	public TapiTopologySdmCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink, String address,
			String cpId, String cpdId) {
		super(node, outgoingLink, incomingLink, address, cpId, cpdId);
		this.layerProtocol = LayerProtocol.SDM;
	}

	public TapiTopologySdmCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink, String address,
			String cpId) {
		super(node, outgoingLink, incomingLink, address, cpId);
		this.layerProtocol = LayerProtocol.SDM;
	}

//	/**
//	 * @return the sdmPoolPac
//	 */
//	public SdmPoolCapabilityPac getSdmPoolPac() {
//		return sdmPoolPac;
//	}
//
//	/**
//	 * @param sdmPoolPac the sdmPoolPac to set
//	 */
//	public void setSdmPoolPac(SdmPoolCapabilityPac sdmPoolPac) {
//		this.sdmPoolPac = sdmPoolPac;
//	}
	
	

}
