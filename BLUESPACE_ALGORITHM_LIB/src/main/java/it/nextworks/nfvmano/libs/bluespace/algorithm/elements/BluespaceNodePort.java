package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.PortType;

/**
 * This class models a port of a blueSPACE device and its interconnection.
 * 
 * @author nextworks
 *
 */
public class BluespaceNodePort {

	private String portId;
	private PortType portType;
	private String neighbourNodeId;
	private String neighbourPortId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private BluespaceObfnCpSpec obfnCpSpec;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<BluespaceNodePortCore> cores = new ArrayList<BluespaceNodePortCore>();
	
	public BluespaceNodePort() { }
	
	/**
	 * Constructor
	 * 
	 * 
	 * @param portId ID of the port, unique within the node
	 * @param portType type of port, i.e. ingress or egress
	 * @param neighbourNodeId ID of the neighbour node connected to the port
	 * @param neighbourPortId ID of the port of the neighbour node connected to the given port
	 * @param cores list of cores available in the port
	 *              @param obfnCpSpec parameters of the obfn port
	 */
	public BluespaceNodePort(String portId,
			PortType portType,
			String neighbourNodeId,
			String neighbourPortId,
			List<BluespaceNodePortCore> cores,
							 BluespaceObfnCpSpec obfnCpSpec) {
		this.portId = portId;
		this.portType = portType;
		this.neighbourNodeId = neighbourNodeId;
		this.neighbourPortId = neighbourPortId;
		if (cores != null) this.cores = cores;
		this.obfnCpSpec= obfnCpSpec;
	}

	public BluespaceObfnCpSpec getObfnCpSpec() {
		return obfnCpSpec;
	}

	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}

	/**
	 * @return the portType
	 */
	public PortType getPortType() {
		return portType;
	}

	/**
	 * @return the neighbourNodeId
	 */
	public String getNeighbourNodeId() {
		return neighbourNodeId;
	}

	/**
	 * @return the neighbourPortId
	 */
	public String getNeighbourPortId() {
		return neighbourPortId;
	}

	/**
	 * @return the cores
	 */
	public List<BluespaceNodePortCore> getCores() {
		return cores;
	}
	
	

}
