package it.nextworks.nfvmano.timeo.rc.elements;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This information element models the resources computed by the allocation 
 * algorithms for the instantiation of a given VNF. 
 * Note: At the moment only VMs are considered, not internal VLs.
 * 
 * @author nextworks
 *
 */
@Entity
public class VnfResourceAllocation {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private NsResourceSchedulingSolution nsRss;
	
	//input
	private String vnfdId;	//VNFD of the VNF
	private int vnfIndex;	//index of the VNF within the NS
	private String vduId;	//ID of the VNFC within the VNF
	private int vduIndex;	//index of the VNFC within the VNF
	
	//output
	private String vimId;
	private String zoneId;
	private String hostId;
	
	public VnfResourceAllocation() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsRss			NS resource scheduling solution this VNF allocation belongs to
	 * @param vnfdId		ID of the VNFD the target VM is related to
	 * @param vnfIndex		index of the VNF within the NS
	 * @param vduId			ID of the VDU within the VNFD that will run on the target VM
	 * @param vduIndex		Index of the VDU within the VNF instance that will run on the target VM
	 * @param vimId			ID of the VIM where the VM must be placed
	 * @param zoneId		ID of the zone where the VM must be placed, within the given VIM
	 * @param hostId		ID of the host where the VM must be placed, within the given VIM
	 */
	public VnfResourceAllocation(NsResourceSchedulingSolution nsRss,
			String vnfdId,
			int vnfIndex,
			String vduId,
			int vduIndex,
			String vimId,
			String zoneId,
			String hostId) {
		this.nsRss = nsRss;
		this.vnfdId = vnfdId;
		this.vnfIndex = vnfIndex;
		this.vduId = vduId;
		this.vduIndex = vduIndex;
		this.vimId = vimId;
		this.zoneId = zoneId;
		this.hostId = hostId;
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
	 * @return the vduId
	 */
	public String getVduId() {
		return vduId;
	}

	/**
	 * @return the vduIndex
	 */
	public int getVduIndex() {
		return vduIndex;
	}

	/**
	 * @return the vimId
	 */
	public String getVimId() {
		return vimId;
	}

	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}

	/**
	 * @return the hostId
	 */
	public String getHostId() {
		return hostId;
	}
	
	

}
