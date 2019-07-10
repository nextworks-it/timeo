package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;

/**
 * This class models a subchannel within a beam
 * 
 * @author nextworks
 *
 */
public class Subchannel {
	
	private String subchannelId;
	
	//available in BBU info - same for every channel, in every beam, in every RRH
	private int subcarriers;
	
	//available in BBU info - same for every channel, in every beam, in every RRH
	private float subcarrierSpacing;	//default: 240 kHz
	
	//this should be made available in RRH monitoring info - to be checked with Eulambia
	private boolean occupied;
	
	//valid only if occupied is true
	//this should be made available in RRH monitoring info - to be checked with Eulambia
	private TransmissionMode transmissionMode;
	
	//Optional parameter - in blueSPACE it will be computed by the algorithm
	//Key: rrh ID; Key: beam ID; Value: List of IDs of the subchannel within that <RRH; beam> pair that interfere with the given subchannel
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, Map<String, List<String>>> interferedSubchannels = new HashMap<String, Map<String,List<String>>>();
	

	public Subchannel() {	}
	
	/**
	 * Constructor
	 * 
	 * @param subchannelId ID of the subchannel, unique within the beam
	 * @param subcarriers number of subcarriers within the subchannel
	 * @param subcarrierSpacing spacing of the subcarrier in kHz
	 * @param occupied true if the subchannel is already in use
	 * @param transmissionMode active transmission mode, valid only if occupied is true
	 * @param interferedSubchannels interfered subchannel - optional parameter
	 */
	public Subchannel(String subchannelId, int subcarriers, float subcarrierSpacing,
			boolean occupied, TransmissionMode transmissionMode,
			Map<String, Map<String, List<String>>> interferedSubchannels) {
		this.subchannelId = subchannelId;
		this.subcarriers = subcarriers;
		if (subcarrierSpacing != 0)
			this.subcarrierSpacing = subcarrierSpacing;
		else this.subcarrierSpacing = 240f;
		this.occupied = occupied;
		this.transmissionMode = transmissionMode;
		if (interferedSubchannels != null) this.interferedSubchannels = interferedSubchannels;
	}

	/**
	 * @return the subchannelId
	 */
	public String getSubchannelId() {
		return subchannelId;
	}

	/**
	 * @return the subcarriers
	 */
	public int getSubcarriers() {
		return subcarriers;
	}

	/**
	 * @return the subcarrierSpacing
	 */
	public float getSubcarrierSpacing() {
		return subcarrierSpacing;
	}

	/**
	 * @return the occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * @return the transmissionMode
	 */
	public TransmissionMode getTransmissionMode() {
		return transmissionMode;
	}

	/**
	 * @return the interferedSubchannels
	 */
	public Map<String, Map<String, List<String>>> getInterferedSubchannels() {
		return interferedSubchannels;
	}
	
	

}
