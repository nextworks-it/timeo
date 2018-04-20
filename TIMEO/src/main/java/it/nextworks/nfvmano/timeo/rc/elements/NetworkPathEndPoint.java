package it.nextworks.nfvmano.timeo.rc.elements;

import javax.persistence.Embeddable;

@Embeddable
public class NetworkPathEndPoint {

	private EndPointType endPointType;
	
	private String vnfdId;	
	private int vnfIndex;	
	private String vnfcId;	
	private int vnfcIndex;	
	
	private String cpdId;
	
	private String vldId;
	
	public NetworkPathEndPoint() {
		// JPA only
	}
	
	/**
	 * Constructor for a network path end point for a VNFC connection point
	 * 
	 * @param vnfdId VNFD of the VNF
	 * @param vnfIndex index of the VNF within the NS
	 * @param vnfcId ID of the VNFC within the VNF
	 * @param vnfcIndex index of the VNFC within the VNF
	 * @param cpdId ID of the connection point within the VNFC
	 */
	public NetworkPathEndPoint(String vnfdId, 
			int vnfIndex,
			String vnfcId,
			int vnfcIndex,
			String cpdId) {
		this.endPointType = EndPointType.VNFC_CP;
		this.vnfdId = vnfdId;
		this.vnfIndex = vnfIndex;
		this.vnfcId = vnfcId;
		this.vnfcIndex = vnfcIndex;
		this.cpdId = cpdId;
	}
	
	/***
	 * Constructor for a network path end point for an NS SAP
	 * 
	 * @param sapId ID of the SAP in the NSD
	 * @param vldId ID of the descriptor of the VL the SAP is attached to
	 */
	public NetworkPathEndPoint(String sapId, String vldId) {
		this.endPointType = EndPointType.NS_SAP;
		this.cpdId = sapId;
		this.vldId = vldId;
	}

	/**
	 * @return the endPointType
	 */
	public EndPointType getEndPointType() {
		return endPointType;
	}

	/**
	 * @return the vnfdId
	 */
	public String getVnfdId() {
		return vnfdId;
	}

	/**
	 * @return the vnfIndex
	 */
	public int getVnfIndex() {
		return vnfIndex;
	}

	/**
	 * @return the vnfcId
	 */
	public String getVnfcId() {
		return vnfcId;
	}

	/**
	 * @return the vnfcIndex
	 */
	public int getVnfcIndex() {
		return vnfcIndex;
	}

	/**
	 * @return the cpdId
	 */
	public String getCpdId() {
		return cpdId;
	}

	/**
	 * @return the vldId
	 */
	public String getVldId() {
		return vldId;
	}
	
	
	
	

}
