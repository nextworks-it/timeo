package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.ArrayList;
import java.util.List;

import io.swagger.client.model.Capacity;
import io.swagger.client.model.LatencyCharacteristic;
import io.swagger.client.model.Link;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * This class models a generalized link as in TAPI topologies.
 * In particular, it may provide information about available capacity,
 * total potential capacity, latency characteristics, direction and 
 * protocol layers.
 * 
 * 
 * @author nextworks
 *
 */
public class TapiTopologyLink extends TopologyLink {
	
	private Capacity availableCapacity = null;
	
	private Capacity totalPotentialCapacity = null;
	
	private List<LatencyCharacteristic> latencyCharacteristic = new ArrayList<>();
	
	private List<LayerProtocol> layerProtocol = new ArrayList<>();
	
	private Link.DirectionEnum direction = Link.DirectionEnum.UNDEFINED_OR_UNKNOWN;

	public TapiTopologyLink(String linkId,
            TopologyNode source, TopologyNode destination,
            TopologyCp sourceCp, TopologyCp destinationCp) {
		super(linkId, source, destination, sourceCp, destinationCp, 0D, 0);
	}

	/**
	 * @return the availableCapacity
	 */
	public Capacity getAvailableCapacity() {
		return availableCapacity;
	}

	/**
	 * @param availableCapacity the availableCapacity to set
	 */
	public void setAvailableCapacity(Capacity availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	/**
	 * @return the totalPotentialCapacity
	 */
	public Capacity getTotalPotentialCapacity() {
		return totalPotentialCapacity;
	}

	/**
	 * @param totalPotentialCapacity the totalPotentialCapacity to set
	 */
	public void setTotalPotentialCapacity(Capacity totalPotentialCapacity) {
		this.totalPotentialCapacity = totalPotentialCapacity;
	}

	/**
	 * @return the latencyCharacteristic
	 */
	public List<LatencyCharacteristic> getLatencyCharacteristic() {
		return latencyCharacteristic;
	}

	/**
	 * @param latencyCharacteristic the latencyCharacteristic to set
	 */
	public void setLatencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
		this.latencyCharacteristic = latencyCharacteristic;
	}

	/**
	 * @return the layerProtocol
	 */
	public List<LayerProtocol> getLayerProtocol() {
		return layerProtocol;
	}

	/**
	 * @param layerProtocol the layerProtocol to set
	 */
	public void setLayerProtocol(List<LayerProtocol> layerProtocol) {
		this.layerProtocol = layerProtocol;
	}

	/**
	 * @return the direction
	 */
	public Link.DirectionEnum getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Link.DirectionEnum direction) {
		this.direction = direction;
	}
	
	

}
