/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.rc.elements;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This information element models the resource allocation difference for a VNF 
 * due to a scaling procedure computation
 * 
 * @author nextworks
 *
 */
@Entity
public class ScaleVnfResourceAllocation {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private ScaleNsResourceAllocation sNSRA;
	
	//input
	private String vnfdId;	//VNFD of the VNF
	private int vnfIndex;	//index of the VNF within the NS
	private String vduId;	//ID of the VNFC within the VNF
	private int vduIndex;	//index of the VNFC within the VNF
	
	//output
	private String vimId;
	private String zoneId;
	private String hostId;
	
	public ScaleVnfResourceAllocation() {
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
	public ScaleVnfResourceAllocation(ScaleNsResourceAllocation diffNsRss,
			String vnfdId,
			int vnfIndex,
			String vduId,
			int vduIndex,
			String vimId,
			String zoneId,
			String hostId) {
		this.sNSRA = diffNsRss;
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
	
	
	/**
	 * @return the equivalent VnfResourceAllocation
	 */
	@JsonIgnore
	public VnfResourceAllocation getVnfResourceAllocation() {
		return new VnfResourceAllocation(null, this.vnfdId, this.vnfIndex, this.vduId,this.vduIndex, 
				this.vimId,this.zoneId, this.hostId);
		
	}
	
	

}
