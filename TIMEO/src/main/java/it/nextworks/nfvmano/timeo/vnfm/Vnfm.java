package it.nextworks.nfvmano.timeo.vnfm;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.VnfLcmProviderInterface;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationProviderInterface;


public abstract class Vnfm implements VnfLcmProviderInterface,
	VnfConfigurationProviderInterface {

	private static final Logger log = LoggerFactory.getLogger(Vnfm.class);
	
	protected VnfmType type;
	protected VnfmInfo vnfmInfo;
	
	//String: VNF ID; OrVnfmNfvoAccess: NFVO to be contacted for granting, notifications etc.
	protected Map<String, OrVnfmNfvoAccess> nfvos = new HashMap<>();
	
	public Vnfm() {	}
	
	/**
	 * Constructor
	 * 
	 * @param type type of the VNFM
	 * 
	 */
	public Vnfm(VnfmType type, VnfmInfo vnfmInfo) {
		this.type = type;
		this.vnfmInfo = vnfmInfo;
	}

	/**
	 * @return the type
	 */
	public VnfmType getType() {
		return type;
	}

	/**
	 * @return the vnfmInfo
	 */
	public VnfmInfo getVnfmInfo() {
		return vnfmInfo;
	}
	
	/**
	 * 
	 * @return the name of the VNFM
	 */
	public String getName() {
		if (vnfmInfo != null) return vnfmInfo.getName();
		else return null;
	}
	
	/**
	 * Registers a new NFVO for the asynchronous interactions 
	 * needed for a given VNF instance
	 * 
	 * @param vnfId ID of the VNF instance
	 * @param nfvo NFVO to be contacted for the given VNF instance
	 */
	public void registerNfvo(String vnfId, OrVnfmNfvoAccess nfvo) {
		nfvos.put(vnfId, nfvo);
		log.debug("Registered NFVO for VNF " + vnfId);
	}

}
