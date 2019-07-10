package it.nextworks.nfvmano.libs.bluespace.algorithm.messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.GeographicalArea;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.Rrh;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.ServiceRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;

public class BluespaceAlgorithmAllocationRequest {

	//to be read from the request
	private List<ServiceRequest> serviceRequests = new ArrayList<ServiceRequest>();
	
	//static info from the RRH beams information
	private List<GeographicalArea> geographicalAreas = new ArrayList<GeographicalArea>();
	
	//static info - check with Eulambia and AIT about the values
	private Map<TransmissionMode, Double> datarate = new HashMap<TransmissionMode, Double>();
	
	private List<Rrh> rrhs = new ArrayList<Rrh>();
	
	
	public BluespaceAlgorithmAllocationRequest() {	}
	
	/**
	 * Constructors
	 * 
	 * @param serviceRequests description of requested services
	 * @param geographicalAreas abstract definition of geographical areas available in the environment 
	 * @param datarate definition of the datarate for each transmission mode
	 * @param rrhs list of RRHs available in the NFVI
	 */
	public BluespaceAlgorithmAllocationRequest(List<ServiceRequest> serviceRequests,
			List<GeographicalArea> geographicalAreas,
			Map<TransmissionMode, Double> datarate,
			List<Rrh> rrhs) {
		if (serviceRequests != null) this.serviceRequests = serviceRequests;
		if (geographicalAreas != null) this.geographicalAreas = geographicalAreas;
		if (datarate != null) this.datarate = datarate;
		if (rrhs != null) this.rrhs = rrhs;
	}

	/**
	 * @return the serviceRequests
	 */
	public List<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	/**
	 * @return the geographicalAreas
	 */
	public List<GeographicalArea> getGeographicalAreas() {
		return geographicalAreas;
	}

	/**
	 * @return the datarate
	 */
	public Map<TransmissionMode, Double> getDatarate() {
		return datarate;
	}

	/**
	 * @return the rrhs
	 */
	public List<Rrh> getRrhs() {
		return rrhs;
	}
	
	

}
