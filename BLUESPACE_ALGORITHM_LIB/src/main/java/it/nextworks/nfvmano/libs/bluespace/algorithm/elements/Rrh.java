package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * This class models a Remote Radio Head PNF.
 * 
 * @author nextworks
 *
 */
public class Rrh {
	
	private String rrhId;
	private List<RrhBeam> beams = new ArrayList<RrhBeam>();

	public Rrh() {	}
	
	/**
	 * Constructor
	 * 
	 * @param rrhId unique ID of the RRH
	 * @param beams list of beams in the RRH
	 */
	public Rrh(String rrhId,
			List<RrhBeam> beams) {
		this.rrhId = rrhId;
		if (beams != null) this.beams = beams;
	}

	/**
	 * @return the rrhId
	 */
	public String getRrhId() {
		return rrhId;
	}

	/**
	 * @return the beams
	 */
	public List<RrhBeam> getBeams() {
		return beams;
	}
	
	

}
