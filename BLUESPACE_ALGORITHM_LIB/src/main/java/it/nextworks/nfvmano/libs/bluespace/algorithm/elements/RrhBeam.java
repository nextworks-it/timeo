package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class models a beam of an RRH.
 * 
 * @author nextworks
 *
 */
public class RrhBeam {

	private String beamId;	//unique within an RRH
	
	//the following three parameters should be static for the RRH and should be made available from the agent
	//To be checked with Eulambia
	private float bandwidth;		//default: 760.32f
	private List<Subchannel> subchannels = new ArrayList<Subchannel>();
	private GeographicalArea geographicalArea;
	
	//Optional parameter - in blueSPACE it will be computed by the algorithm
	//Key: rrh ID; Value: List of IDs of the beams within that RRH that interfere with the given beam
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, List<String>> interferedBeams = new HashMap<String, List<String>>();
	
	//always false, not used
	private boolean transitiveInterference;
	
	
	public RrhBeam() {	}
	
	/**
	 * Constructor
	 * 
	 * @param beamId ID of the beam, unique within the RRH
	 * @param bandwidth bw of the beam in MHz
	 * @param subchannels description of the subchannels in the beam
	 * @param geographicalArea area covered by the beam (in blueSPACE a beam is narrow enough to cover a single area)
	 * @param transitiveInterference used to model the type of interference
	 */
	public RrhBeam(String beamId, float bandwidth, List<Subchannel> subchannels,
			GeographicalArea geographicalArea, Map<String, List<String>> interferedBeams,
			boolean transitiveInterference) {
		this.beamId = beamId;
		if (bandwidth != 0)
			this.bandwidth = bandwidth;
		else this.bandwidth = 760.32f;
		this.subchannels = subchannels;
		this.geographicalArea = geographicalArea;
		if (interferedBeams != null) this.interferedBeams = interferedBeams;
		this.transitiveInterference = transitiveInterference;
	}

	/**
	 * @return the beamId
	 */
	public String getBeamId() {
		return beamId;
	}

	/**
	 * @return the bandwidth
	 */
	public float getBandwidth() {
		return bandwidth;
	}

	/**
	 * @return the subchannels
	 */
	public List<Subchannel> getSubchannels() {
		return subchannels;
	}

	/**
	 * @return the geographicalArea
	 */
	public GeographicalArea getGeographicalArea() {
		return geographicalArea;
	}

	/**
	 * @return the interferedBeams
	 */
	public Map<String, List<String>> getInterferedBeams() {
		return interferedBeams;
	}

	/**
	 * @return the transitiveInterference
	 */
	public boolean isTransitiveInterference() {
		return transitiveInterference;
	}
	
	

}
