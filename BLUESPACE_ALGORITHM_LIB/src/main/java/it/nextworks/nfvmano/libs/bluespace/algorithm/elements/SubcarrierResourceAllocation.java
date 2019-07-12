package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class models the resource allocation at the RRHs level
 * 
 * @author nextworks
 *
 */
public class SubcarrierResourceAllocation {

	//key: rrh ID, key: beam ID, key: subchannel ID, value: list of subcarrierIds
	Map<String, Map<String , Map<String, List<String>>>> subcarrierResourceAllocation = new HashMap<String, Map<String,Map<String,List<String>>>>();
	
	public SubcarrierResourceAllocation() {	}
	
	public SubcarrierResourceAllocation(Map<String, Map<String , Map<String, List<String>>>> subcarrierResourceAllocation) {
		if (subcarrierResourceAllocation != null) this.subcarrierResourceAllocation = subcarrierResourceAllocation;
	}

	/**
	 * @return the subcarrierResourceAllocation
	 */
	public Map<String, Map<String, Map<String, List<String>>>> getSubcarrierResourceAllocation() {
		return subcarrierResourceAllocation;
	}
	
	

}
