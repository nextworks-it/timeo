package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.List;

public class BluespaceNodePortCore {
	
	private String coreId;
	private int totalWavelenghts;
	
	private List<String> occupiedWavelengths = new ArrayList<String>();

	public BluespaceNodePortCore() { }
	
	/**
	 * Constructor
	 * 
	 * @param coreId ID of the core, unique within the port
	 * @param totalWavelengths total number of wavelengts in the given core 
	 */
	public BluespaceNodePortCore(String coreId,
			int totalWavelengths,
			List<String> occupiedWavelengths) { 
		this.coreId = coreId;
		this.totalWavelenghts = totalWavelengths;
		if (occupiedWavelengths != null) this.occupiedWavelengths = occupiedWavelengths;
	}

	/**
	 * @return the coreId
	 */
	public String getCoreId() {
		return coreId;
	}

	/**
	 * @return the totalWavelenghts
	 */
	public int getTotalWavelenghts() {
		return totalWavelenghts;
	}

	/**
	 * @return the occupiedWavelengths
	 */
	public List<String> getOccupiedWavelengths() {
		return occupiedWavelengths;
	}
	
	

}
