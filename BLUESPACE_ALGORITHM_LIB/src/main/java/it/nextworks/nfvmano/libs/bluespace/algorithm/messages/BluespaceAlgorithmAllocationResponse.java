package it.nextworks.nfvmano.libs.bluespace.algorithm.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.ServiceResponse;

/**
 * This class models the output of the blueSPACE resource allocation algorithm
 * 
 * @author nextworks
 *
 */
public class BluespaceAlgorithmAllocationResponse {

	private List<ServiceResponse> serviceResponses = new ArrayList<ServiceResponse>();
	
	public BluespaceAlgorithmAllocationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param serviceResponses resource allocation result for each service
	 */
	public BluespaceAlgorithmAllocationResponse(List<ServiceResponse> serviceResponses) {	
		if (serviceResponses != null) this.serviceResponses = serviceResponses;
	}

	/**
	 * @return the serviceResponses
	 */
	public List<ServiceResponse> getServiceResponses() {
		return serviceResponses;
	}
	
	public boolean hasSuccessfulResponse() {
		if ((serviceResponses != null ) && (serviceResponses.size() >= 1)) return true;
		else return false;
	}

}
