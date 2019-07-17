package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.RrhBeam;

/**
 * This class models PNF metadata used in blueSPACE
 * 
 * @author nextworks
 *
 */
public class BlueSpacePnfMetadata {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<RrhBeam> rrhBeams = new ArrayList<>();
	
	public BlueSpacePnfMetadata() {	}

}
