package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class model a resource allocation response for a given service.
 * 
 * @author nextworks
 *
 */
public class ServiceResponse {

	private String serviceId;
	
	//key: ID of the geographical area; value: resource allocation in RRHs
	private Map<String, SubcarrierResourceAllocation> rrhResourceAllocation = new HashMap<String, SubcarrierResourceAllocation>();
	
	//list of lightpaths between RRHs and BBUs
	private List<LightPath> lightpaths = new ArrayList<LightPath>();
	
	//key: ID of the VM in service; value: ID of the server where the VM must be allocated
	private Map<String, String> vmAllocation = new HashMap<String, String>();
	
	//key: ID of the server; Value: List of ID of the BBUs corresponding to the MEC server
	private Map<String, List<String>> mecToBbuMapping = new HashMap<String, List<String>>();
	
	public ServiceResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param serviceId ID of the service
	 * @param rrhResourceAllocation details of radio resource allocation
	 * @param lightpaths details of optical resource allocation in the fronthaul
	 * @param vmAllocation details about the allocation of the VMs on the available servers
	 * @param mecToBbuMapping details about the mapping between the MEC servers and the corresponding BBUs
	 * 
	 */
	public ServiceResponse(String serviceId, 
			Map<String, SubcarrierResourceAllocation> rrhResourceAllocation,
			List<LightPath> lightpaths,
			Map<String, String> vmAllocation,
			Map<String, List<String>> mecToBbuMapping) {
		this.serviceId = serviceId;
		if (rrhResourceAllocation != null) this.rrhResourceAllocation = rrhResourceAllocation;
		if (lightpaths != null) this.lightpaths = lightpaths;
		if (vmAllocation != null) this.vmAllocation = vmAllocation;
		if (mecToBbuMapping != null) this.mecToBbuMapping = mecToBbuMapping;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @return the rrhResourceAllocation
	 */
	public Map<String, SubcarrierResourceAllocation> getRrhResourceAllocation() {
		return rrhResourceAllocation;
	}

	/**
	 * @return the lightpaths
	 */
	public List<LightPath> getLightpaths() {
		return lightpaths;
	}

	/**
	 * @return the vmAllocation
	 */
	public Map<String, String> getVmAllocation() {
		return vmAllocation;
	}

	/**
	 * @return the mecToBbuMapping
	 */
	public Map<String, List<String>> getMecToBbuMapping() {
		return mecToBbuMapping;
	}
	
	

}
