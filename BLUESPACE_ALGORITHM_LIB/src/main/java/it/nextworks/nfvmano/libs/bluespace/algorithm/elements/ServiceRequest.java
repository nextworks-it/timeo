package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;

/**
 * This class models a request for a service associated to a given type of communication 
 * and to be provided in a number of geographical areas
 * 
 * @author nextworks
 *
 */
public class ServiceRequest {

	private String serviceId;
	private List<String> serviceAreaId = new ArrayList<String>();
	private TransmissionMode transmissionMode;
	
	//Key: ID of the VM; Value: characteristics of the VM
	private Map<String, VmRequirements> vmRequirements = new HashMap<String, VmRequirements>();
	
	public ServiceRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param serviceId ID of the service
	 * @param serviceAreaId ID of the geographical areas where the service must be provided
	 * @param transmissionMode transmission mode for the service
	 * @param vmRequirements computational requirements for the service
	 */
	public ServiceRequest(String serviceId,
			List<String> serviceAreaId,
			TransmissionMode transmissionMode,
			Map<String, VmRequirements> vmRequirements) { 
		this.serviceId = serviceId;
		if (serviceAreaId != null) this.serviceAreaId = serviceAreaId;
		this.transmissionMode = transmissionMode;
		if (vmRequirements != null) this.vmRequirements = vmRequirements;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @return the serviceAreaId
	 */
	public List<String> getServiceAreaId() {
		return serviceAreaId;
	}

	/**
	 * @return the transmissionMode
	 */
	public TransmissionMode getTransmissionMode() {
		return transmissionMode;
	}

	/**
	 * @return the vmRequirements
	 */
	public Map<String, VmRequirements> getVmRequirements() {
		return vmRequirements;
	}

	
	
}
