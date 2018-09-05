package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import io.swagger.client.model.SdmPoolPac;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

public class TapiTopologySdmCp extends TapiTopologyCp {

	private SdmPoolPac sdmPoolPac;
	
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

	/**
	 * @return the sdmPoolPac
	 */
	public SdmPoolPac getSdmPoolPac() {
		return sdmPoolPac;
	}

	/**
	 * @param sdmPoolPac the sdmPoolPac to set
	 */
	public void setSdmPoolPac(SdmPoolPac sdmPoolPac) {
		this.sdmPoolPac = sdmPoolPac;
	}
	
	

}
