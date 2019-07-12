package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

/**
 * This class models an hop in a light-path
 * 
 * @author nextworks
 *
 */
public class LightpathHop {

	private String nodeId;
	private String portId;
	private String coreId;
	private String wavelengthId;
	
	public LightpathHop() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nodeId ID of the optical node
	 * @param portId ID of the port
	 * @param coreId ID of the core within the port
	 * @param wavelengthId ID of the wavelength within the core
	 */
	public LightpathHop(String nodeId,
			String portId, 
			String coreId,
			String wavelengthId) {
		this.nodeId = nodeId;
		this.portId = portId;
		this.coreId = coreId;
		this.wavelengthId = wavelengthId;
	}

	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}

	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}

	/**
	 * @return the coreId
	 */
	public String getCoreId() {
		return coreId;
	}

	/**
	 * @return the wavelengthId
	 */
	public String getWavelengthId() {
		return wavelengthId;
	}

	
	
}
