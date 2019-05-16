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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.*;

/**
 * This information element models the operations computed by
 * a resource allocation algorithm for the scaling of a given NS instance.
 * 
 *
 * @author nextworks
 *
 */
@Entity
public class NsScaleSchedulingSolution {

	

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

	private String nsInstanceId;

	@OneToOne
	private NsResourceSchedulingSolution postScaleResourceSolution;

	//Contains the resources to be allocated by the scaling
	@OneToOne(fetch=FetchType.EAGER, mappedBy="nsSSS", cascade=CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ScaleNsResourceAllocation scaleNsResourceAllocation;

	//The vnf instance ids to be dealloacted by the scaling procedure
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> vnfInstanceDeallocation = new ArrayList<>();


	//The pnf instance ids to be dealloacted by the scaling procedure
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> pnfInstanceDeallocation = new ArrayList<>();

	//The network path ids to be dealloacted by the scaling procedure
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> networkPathsToDeallocate = new ArrayList<>();

	//The network nodes to be deactivate by the powermanager after the scaling procedure
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> networkNodesToBeDeactivated = new ArrayList<>();


	//The compute nodes to be deactivate by the powermanager after the scaling procedure
	//Key: hostID; Value: vimID
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String,String> computeNodesToBeDeactivated = new HashMap<>();

	private boolean solutionFound;

	public NsScaleSchedulingSolution() {
		//JPA only
	}

	/**
	 *
	 * @param nsInstanceId the instance associated with this scaling solution
	 * @param vnfInstanceDeallocation vnfInstance ids to be terminated by this scaling operation
	 * @param pnfInstanceDeallocation pnfInstance ids to be terminated by this scaling operation
	 * @param networkPathsToDeallocate newtorkPath ids to be deallocated
	 * @param networkNodesToBeDeactivated networkNodes to be deactivated by this scaling operation
	 * @param computeNodesToBeDeactivated computeNodes to be deactivated by this scaling operation
	 * @param solutionFound	determines if a proper scaling solution was found or not
	 */
	public NsScaleSchedulingSolution(String nsInstanceId,
									 List<String> vnfInstanceDeallocation,
									 List<String> pnfInstanceDeallocation,
									 List<String> networkPathsToDeallocate,
									 List<String> networkNodesToBeDeactivated,
									 Map<String, String> computeNodesToBeDeactivated,
									 ScaleNsResourceAllocation scaleNsResourceAllocation,
									 boolean solutionFound) {
		this.nsInstanceId = nsInstanceId;
		if (vnfInstanceDeallocation != null) this.vnfInstanceDeallocation = vnfInstanceDeallocation;
		if (pnfInstanceDeallocation != null) this.pnfInstanceDeallocation = pnfInstanceDeallocation;
		if (networkPathsToDeallocate != null) this.networkPathsToDeallocate = networkPathsToDeallocate;
		if (networkNodesToBeDeactivated != null) this.networkNodesToBeDeactivated = networkNodesToBeDeactivated;
		if (computeNodesToBeDeactivated != null) this.computeNodesToBeDeactivated = computeNodesToBeDeactivated;
		if (scaleNsResourceAllocation!=null) this.scaleNsResourceAllocation=scaleNsResourceAllocation;
		this.solutionFound = solutionFound;
	}

	public NsScaleSchedulingSolution(String nsInstanceId) {
		//JPA only
		this.solutionFound=false;
	}


	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	
	/**
	 * 
	 * @return wether a scaling solution was found or not
	 */
	public boolean isSolutionFound() {
		return solutionFound;
	}

	/**
	 * 
	 * @return the resource reservation solution after the scaling
	 */
	public NsResourceSchedulingSolution getPostScaleResourceSolution() {
		return postScaleResourceSolution;
	}

	
	/**
	 * 
	 * @return the resource differential reservation solution after the scaling
	 */
	public ScaleNsResourceAllocation getScaleNsResourceAllocation() {
		return scaleNsResourceAllocation;
	}

	/**
	 * @param postScaleResourceSolution the postScaleResourceSolution to set
	 */
	public void setPostScaleResourceSolution(NsResourceSchedulingSolution postScaleResourceSolution) {
		this.postScaleResourceSolution = postScaleResourceSolution;
	}
	
	
	/**
	 * @return the vnfInstanceDeallocation
	 */
	public List<String> getVnfInstanceDeallocation() {
		return vnfInstanceDeallocation;
	}

	/**
	 * @return the networkNodesToBeDeactivated
	 */
	public List<String> getNetworkNodesToBeDeactivated() {
		return networkNodesToBeDeactivated;
	}

	/**
	 * @return the computeNodesToBeDeactivated
	 */
	public Map<String, String> getComputeNodesToBeDeactivated() {
		return computeNodesToBeDeactivated;
	}
	


	

}
