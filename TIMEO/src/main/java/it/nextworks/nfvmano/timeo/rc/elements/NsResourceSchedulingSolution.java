package it.nextworks.nfvmano.timeo.rc.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This information element models the resources computed by 
 * a resource allocation algorithm for the instantiation of a given NS.
 * 
 * Some algorithms may be able to compute just a subset of resources, 
 * i.e. only the computing ones. 
 * 
 * @author nextworks
 *
 */
@Entity
public class NsResourceSchedulingSolution {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	private String nsInstanceId;
	
	@OneToMany(mappedBy = "nsRss", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
	
	@OneToMany(mappedBy = "nsRss", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<NetworkPath> networkPaths = new ArrayList<>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> networkNodesToBeActivated = new ArrayList<>();
	
	//Key: hostID; Value: vimID
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String,String> computeNodesToBeActivated = new HashMap<>();
	
	private boolean solutionFound;
	
	public NsResourceSchedulingSolution() {
		//JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId	ID of the NS instance this resource allocation is associated to
	 * @param solutionFound true if a suitable resource allocation solution has been found
	 */
	public NsResourceSchedulingSolution(String nsInstanceId,
			boolean solutionFound) {
		this.nsInstanceId = nsInstanceId;
		this.solutionFound = solutionFound;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId	ID of the NS instance this resource allocation is associated to
	 * @param vnfResourceAllocation information about the allocation of computing resources for the VNFs
	 * @param networkPaths information about the allocation of network resources for the NS virtual links
	 * @param solutionFound true if a suitable resource allocation solution has been found
	 */
	public NsResourceSchedulingSolution(String nsInstanceId,
			List<VnfResourceAllocation> vnfResourceAllocation,
			List<NetworkPath> networkPaths,
			boolean solutionFound) {
		this.nsInstanceId = nsInstanceId;
		if (vnfResourceAllocation != null) this.vnfResourceAllocation = vnfResourceAllocation;
		if (networkPaths != null) this.networkPaths = networkPaths;
		this.solutionFound = solutionFound;
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId	ID of the NS instance this resource allocation is associated to
	 * @param vnfResourceAllocation information about the allocation of computing resources for the VNFs
	 * @param networkPaths information about the allocation of network resources for the NS virtual links
	 * @param solutionFound true if a suitable resource allocation solution has been found
	 * @param networkNodesToBeActivated network nodes to be activated
	 * @param computeNodesToBeActivated compute nodes to be activated
	 */
	public NsResourceSchedulingSolution(String nsInstanceId,
			List<VnfResourceAllocation> vnfResourceAllocation,
			List<NetworkPath> networkPaths,
			boolean solutionFound,
			List<String> networkNodesToBeActivated,
			Map<String,String> computeNodesToBeActivated) {
		this.nsInstanceId = nsInstanceId;
		if (vnfResourceAllocation != null) this.vnfResourceAllocation = vnfResourceAllocation;
		if (networkPaths != null) this.networkPaths = networkPaths;
		this.solutionFound = solutionFound;
		if (networkNodesToBeActivated != null) this.networkNodesToBeActivated = networkNodesToBeActivated;
		if (computeNodesToBeActivated != null) this.computeNodesToBeActivated = computeNodesToBeActivated;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId	ID of the NS instance this resource allocation is associated to
	 * @param networkNodesToBeActivated network nodes to be activated
	 * @param computeNodesToBeActivated compute nodes to be activated
	 */
	public NsResourceSchedulingSolution(String nsInstanceId,
			boolean solutionFound,
			List<String> networkNodesToBeActivated,
			Map<String,String> computeNodesToBeActivated) {
		this.nsInstanceId = nsInstanceId;
		this.solutionFound = solutionFound;
		if (networkNodesToBeActivated != null) this.networkNodesToBeActivated = networkNodesToBeActivated;
		if (computeNodesToBeActivated != null) this.computeNodesToBeActivated = computeNodesToBeActivated;
	}

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	/**
	 * @return the vnfResourceAllocation
	 */
	public List<VnfResourceAllocation> getVnfResourceAllocation() {
		return vnfResourceAllocation;
	}

	/**
	 * @return the networkPaths
	 */
	public List<NetworkPath> getNetworkPaths() {
		return networkPaths;
	}

	/**
	 * @return the solutionFound
	 */
	public boolean isSolutionFound() {
		return solutionFound;
	}
	
	
	
	/**
	 * @return the networkNodesToBeActivated
	 */
	public List<String> getNetworkNodesToBeActivated() {
		return networkNodesToBeActivated;
	}

	/**
	 * @return the computeNodesToBeActivated
	 */
	public Map<String,String> getComputeNodesToBeActivated() {
		return computeNodesToBeActivated;
	}
	
	
	@JsonIgnore
	public Map<String,String> getAllComputeNodes() {
		Map<String,String> computeNodes = new HashMap<String, String>();
		for (VnfResourceAllocation x : vnfResourceAllocation) {
			String vimId = x.getVimId();
			String hostId = x.getHostId();
			computeNodes.put(hostId, vimId);
		}
		return computeNodes;
	}
	
	@JsonIgnore
	public Set<String> getAllNetworkNodes() {
		Set<String> networkNodes = new HashSet<>();
		for (NetworkPath np : networkPaths) {
			List<NetworkPathHop> hops = np.getHops();
			for (NetworkPathHop hop : hops) {
				networkNodes.add(hop.getNodeId());
			}
		}
		return networkNodes;
	}

	/**
	 * Returns all the VNF resource allocation for a given VNFD ID
	 * 
	 * @param vnfdId
	 * @return
	 */
	public List<VnfResourceAllocation> getVnfResourceAllocationForVnfd(String vnfdId) {
		List<VnfResourceAllocation> result = new ArrayList<>();
		for (VnfResourceAllocation vra : vnfResourceAllocation) {
			if (vra.getVnfdId().equals(vnfdId)) result.add(vra);
		}
		return result;
	}
	

}
