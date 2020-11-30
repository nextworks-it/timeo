package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

/**
 * This class models an hop in a light-path
 * 
 * @author nextworks
 *
 */
public class LightpathHop {

	private String nodeId;
	private String inputPortId;
	private String outputPortId;
	private String obfnId;
	//private String wavelengthId;


	public LightpathHop() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nodeId ID of the optical node
	 * @param inputPortId ID of the input port (SIP)
	 * @param outputPortId ID of the output port (SIP)
	 *
	 */
	public LightpathHop(String nodeId,
			String inputPortId,
			String outputPortId,
			String obfnId) {
		this.nodeId = nodeId;
		this.inputPortId = inputPortId;
		this.outputPortId = outputPortId;
		//this.wavelengthId = wavelengthId;
		this.obfnId = obfnId;
	}

	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}

	public String getObfnId() {
		return obfnId;
	}

	/**
	 * @return the InputPortId
	 */
	public String getInputPortId() {
		return inputPortId;
	}


	public String getOutputPortId() {
		return outputPortId;
	}
}
