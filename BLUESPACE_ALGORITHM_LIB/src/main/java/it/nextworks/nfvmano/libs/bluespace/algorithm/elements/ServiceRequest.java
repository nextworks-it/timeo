package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

import java.util.ArrayList;
import java.util.List;

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
	
	public ServiceRequest() { }
	
	public ServiceRequest(String serviceId,
			List<String> serviceAreaId,
			TransmissionMode transmissionMode) { 
		this.serviceId = serviceId;
		if (serviceAreaId != null) this.serviceAreaId = serviceAreaId;
		this.transmissionMode = transmissionMode;
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

}
