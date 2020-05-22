package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.List;

/**
 * This class model a lightpath
 * 
 * @author nextworks
 *
 */
public class LightPath {

	private String rrhId;
	private String bbuId;
	private List<LightpathHop> hops;
	
	public LightPath() { }
	
	/**
	 * Constructors
	 * 
	 * @param rrhId ID of the RRH at the edge of the path
	 * @param bbuId ID of the bbu at the edge of the path
	 * @param hops specification of optical resources to be allocated on the lightpath
	 *
	 */
	public LightPath(String rrhId, 
			String bbuId,
			List<LightpathHop> hops
					) {
		this.rrhId = rrhId;

		this.bbuId = bbuId;
		if (hops != null) this.hops = hops;
	}

	/**
	 * @return the hops
	 */
	public List<LightpathHop> getHops() {
		return hops;
	}

	/**
	 * @return the rrhId
	 */
	public String getRrhId() {
		return rrhId;
	}



	/**
	 * @return the bbuId
	 */
	public String getBbuId() {
		return bbuId;
	}


}
