package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

/**
 * This class models a geographical area 
 * 
 * @author nextworks
 *
 */
public class GeographicalArea {
	
	private String areaId;

	public GeographicalArea() {	}
	
	/**
	 * Constructor
	 * 
	 * @param areaId unique ID of the area
	 */
	public GeographicalArea(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return the areaId
	 */
	public String getAreaId() {
		return areaId;
	}
	
	

}
