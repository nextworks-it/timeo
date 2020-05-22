package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceNodeType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceSwitchingType;

/**
 * This class models a node in the blueSPACE NFVI
 * 
 * @author nextworks
 *
 */
public class BluespaceNode {
	
	private String nodeId;
	private BluespaceNodeType nodeType;
	private BluespaceSwitchingType switchingType;
	
	private List<BluespaceNodePort> ports = new ArrayList<BluespaceNodePort>();
	
	//the following two parameters are valid only for BBU nodes
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String connectedRrhId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String connectedRrhBeamId;

	public BluespaceNode() { }
	
	/**
	 * Constructor
	 * 
	 * @param nodeId unique ID of the node
	 * @param nodeType type of the node
	 * @param switchingType switching type supported by the node
	 * @param ports ports available in the node
	 */
	public BluespaceNode(String nodeId,
			BluespaceNodeType nodeType,
			BluespaceSwitchingType switchingType,
			List<BluespaceNodePort> ports) {
		this.nodeId = nodeId;
		this.nodeType = nodeType;
		this.switchingType = switchingType;
		if (ports != null) this.ports = ports;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nodeId unique ID of the node
	 * @param nodeType type of the node
	 * @param switchingType switching type supported by the node
	 * @param ports ports available in the node
	 * @param connectedRrhBeamId ID of the beam of the RRH connected to the BBU
	 * @param connectedRrhId ID of the RRH connected to the BBU
	 */
	public BluespaceNode(String nodeId,
			BluespaceNodeType nodeType,
			BluespaceSwitchingType switchingType,
			List<BluespaceNodePort> ports,
			String connectedRrhId,
			String connectedRrhBeamId) {
		this.nodeId = nodeId;
		this.nodeType = nodeType;
		this.switchingType = switchingType;
		if (ports != null) this.ports = ports;
		this.connectedRrhBeamId = connectedRrhBeamId;
		this.connectedRrhId = connectedRrhId;
	}

	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}

	/**
	 * @return the nodeType
	 */
	public BluespaceNodeType getNodeType() {
		return nodeType;
	}

	/**
	 * @return the switchingType
	 */
	public BluespaceSwitchingType getSwitchingType() {
		return switchingType;
	}

	/**
	 * @return the ports
	 */
	public List<BluespaceNodePort> getPorts() {
		return ports;
	}

	/**
	 * @return the connectedRrhId
	 */
	public String getConnectedRrhId() {
		return connectedRrhId;
	}

	/**
	 * @return the connectedRrhBeamId
	 */
	public String getConnectedRrhBeamId() {
		return connectedRrhBeamId;
	}
	
	

}
