package it.nextworks.nfvmano.timeo.vnfm.pnfm;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to create a PNF identifier
 * 
 * @author nextworks
 *
 */
public class CreatePnfIdentifierRequest implements InterfaceMessage {

	private String pnfdId;
	private String pnfdVersion;
	private String name;
	private String description;
	private String pnfInstanceId;		//the ID of the physical equipment, as specified by the administrator
	private String nsInstanceId; 		//the ID of the NS this PNF is associated to
	private String pnfProfileId;
	
	public CreatePnfIdentifierRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param pnfdId ID of the PNF descriptor
	 * @param pnfdVersion version of the PNF descriptor
	 * @param name name of the PNF
	 * @param description description of the PNF
	 * @param pnfInstanceId ID of the physical equipment which implements the PNF, as specified by the administrator
	 * @param nsInstanceId ID of the NS instance this PNF is associated to
	 * @param pnfProfileId ID of the PNF profile
	 */
	public CreatePnfIdentifierRequest(String pnfdId,
			String pnfdVersion,
			String name,
			String description,
			String pnfInstanceId,
			String nsInstanceId,
			String pnfProfileId) { 
		this.pnfdId = pnfdId;
		this.pnfdVersion = pnfdVersion;
		this.pnfInstanceId = pnfInstanceId;
		this.description = description;
		this.name = name;
		this.nsInstanceId = nsInstanceId;
		this.pnfProfileId = pnfProfileId;
	}
	
	

	/**
	 * @return the pnfdId
	 */
	public String getPnfdId() {
		return pnfdId;
	}

	
	
	/**
	 * @return the pnfdVersion
	 */
	public String getPnfdVersion() {
		return pnfdVersion;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the pnfInstanceId
	 */
	public String getPnfInstanceId() {
		return pnfInstanceId;
	}
	
	

	/**
	 * @return the pnfProfileId
	 */
	public String getPnfProfileId() {
		return pnfProfileId;
	}

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (pnfdId == null) throw new MalformattedElementException("Create PNF ID request without PNFD ID.");
		if (pnfdVersion == null) throw new MalformattedElementException("Create PNF ID request without PNFD version.");
		if (pnfInstanceId == null) throw new MalformattedElementException("Create PNF ID request without PNF instance ID.");
		if (nsInstanceId == null) throw new MalformattedElementException("Create PNF ID request without NS ID.");
	}

}
