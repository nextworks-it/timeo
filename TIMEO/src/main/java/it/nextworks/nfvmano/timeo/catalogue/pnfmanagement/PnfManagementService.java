package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement;

import java.util.*;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.StringMetadata;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PhysicalEquipmentPort;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfType;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.repositories.PhysicalEquipmentPortRepository;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.repositories.PnfInstanceMetadataRepository;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.repositories.PnfInstanceRepository;
import org.springframework.web.client.RestTemplate;

/**
 * This service allows to add, remove and retrieve PNF instances into the catalogue.
 * This should be management actions done by the system admin.
 * This service is invoked by the PnfManagementController, which exposes the REST API. 
 * 
 * @author nextworks
 *
 */
@Service
public class PnfManagementService {

	private static final Logger log = LoggerFactory.getLogger(PnfManagementService.class);
	
	@Autowired
	private PnfInstanceRepository pnfInstanceRepository;

	@Autowired
	private PhysicalEquipmentPortRepository physicalEquipmentPortRepository;
	
	@Autowired
	private PnfInstanceMetadataRepository pnfInstanceMetadataRepository;

	@Autowired
	private TaskExecutor taskExecutor;
	//Map pnfInstanceId - RestClient to retrieve configuration information.
	//TODO: Revise pnfLcm to NsResourceAllocationManager relationship
	private Map<String, RestVnfDriver> pnfInstanceToRestClient = new HashMap();



	public PnfManagementService() {	}
	
	/**
	 * This method returns the list of all the PNF instances available in the catalogue.
	 * 
	 * @return the list of all the PNF instances
	 */
	public List<PnfInstance> getAllPnfInstances() {
		return pnfInstanceRepository.findAll();
	}
	
	/**
	 * This method returns the PNF instance with a given ID.
	 * 
	 * @param pnfInstanceId ID of the PNF instance
	 * @return the PNF instance with the given ID
	 * @throws NotExistingEntityException if a PNF instance with the given ID does not exist in DB
	 */
	public PnfInstance getPnfInstance(String pnfInstanceId) throws NotExistingEntityException {

		Optional<PnfInstance> pnfOpt = pnfInstanceRepository.findByPnfInstanceId(pnfInstanceId);
		if(pnfOpt.isPresent()){

			return pnfOpt.get();
		}else throw new NotExistingEntityException("PNF instance with ID " + pnfInstanceId + " not available in DB.");
	}
	
	/**
	 * This method returns the list of PNF instances with a given PNFD
	 * 
	 * @param pnfdId ID of the PNF descriptor of the PNF instances to be returned
	 * @return the list of PNF instances with the given PNFD
	 */
	public List<PnfInstance> getPnfInstancesFromPnfd(String pnfdId) {
		return pnfInstanceRepository.findByPnfdId(pnfdId);
	}
	
	/**
	 * This method returns the list of PNF instances of a given type
	 * 
	 * @param pnfType type of the PNFs to be returned
	 * @return the list of PNF instances with the given type
	 */
	public List<PnfInstance> getPnfInstancedFromType(PnfType pnfType) {
		return pnfInstanceRepository.findByPnfType(pnfType);
	}
	
	/**
	 * This method creates a new PNF instance
	 * 
	 * @param pnfInstance PNF instance to be created
	 * @throws AlreadyExistingEntityException if a PNF instance with the same PNF ID is already present in DB. 
	 * @throws MalformattedElementException if the PNF instance element is malformatted
	 */
	public synchronized void addPnfInstance(PnfInstance pnfInstance) throws AlreadyExistingEntityException, MalformattedElementException {
		pnfInstance.isValid();
		if (pnfInstanceRepository.findByPnfInstanceId(pnfInstance.getPnfInstanceId()).isPresent()) 
			throw new AlreadyExistingEntityException("PNF instance with ID " + pnfInstance.getPnfInstanceId() + " already present in DB. Impossible to create a new one.");
		log.debug("Adding PNF instance with ID " + pnfInstance.getPnfInstanceId() + " in DB.");
		
		PnfInstance target = new PnfInstance(pnfInstance.getPnfInstanceId(), pnfInstance.getPnfdId(), pnfInstance.getPnfdVersion(), pnfInstance.getDescription(), pnfInstance.getLocation(), pnfInstance.getPnfType());
		pnfInstanceRepository.saveAndFlush(target);
		log.debug("PNF instance with ID " + pnfInstance.getPnfInstanceId() + " saved in DB.");
		
		List<PhysicalEquipmentPort> ports = pnfInstance.getPorts();
		for (PhysicalEquipmentPort p : ports) {
			PhysicalEquipmentPort targetPort = new PhysicalEquipmentPort(target, p.getPortId(), p.getAddresses(), p.isManagement(), p.getServiceInterfacePointId());
			physicalEquipmentPortRepository.saveAndFlush(targetPort);
			log.debug("Port " + p.getPortId() + " added to PNF " + pnfInstance.getPnfInstanceId() + " in DB.");
		}
		
		/*List<PnfInstanceMetadata> metadata = pnfInstance.getPnfInstanceMetadata();
		for (PnfInstanceMetadata data : metadata) {
			PnfInstanceMetadata newData = data.setPnfInstance(target);
			pnfInstanceMetadataRepository.saveAndFlush(newData);
			
		}*/
		log.debug("PNF instance creation done.");
	}

	/**
	 * This method removes a PNF instance with a given ID
	 * 
	 * @param pnfInstanceId ID of the PNF instance to be removed
	 * @throws NotExistingEntityException if a PNF instance with the given ID is not present in DB.
	 */
	public synchronized void deletePnfInstance(String pnfInstanceId) throws NotExistingEntityException {
		log.debug("Removing PNF instance with ID " + pnfInstanceId + " from DB.");
		PnfInstance pnfInstance = getPnfInstance(pnfInstanceId);
		pnfInstanceRepository.delete(pnfInstance);
		log.debug("PNF instance with ID " + pnfInstanceId + " removed from DB.");
	}


	public List<IndicatorInformation> getPnfInstanceIndicators(String pnfInstanceId){
		Optional<PnfInstance> pnfOpt = pnfInstanceRepository.findByPnfInstanceId(pnfInstanceId);
		if(pnfOpt.isPresent()) {
			RestVnfDriver restVnfDriver;
			PnfInstance pnfInstance = pnfOpt.get();
			if (pnfInstanceToRestClient.containsKey(pnfInstanceId)) {
				restVnfDriver = pnfInstanceToRestClient.get(pnfInstanceId);
			} else {
				restVnfDriver = new RestVnfDriver(pnfInstanceId, pnfInstance.getManagementIpAddress(), pnfInstance.getManagementPort(), new RestTemplate(), taskExecutor);
				pnfInstanceToRestClient.put(pnfInstanceId, restVnfDriver);
			}
			List<IndicatorInformation> result;
			try {
				result = restVnfDriver.getIndicatorValue(new GeneralizedQueryRequest(null, null)).getIndicatorInformation();
				return result;
			} catch (FailedOperationException e) {
				log.error("Error retrieving PnfInstance Indicators:" + pnfInstanceId);
				log.error(e.getMessage());
				log.error(e.getStackTrace().toString());
				return new ArrayList<>();
			}
		}else return new ArrayList<>();
	}

	private void updatePnfInstanceIndicators(String pnfInstanceId){
		log.debug("Could not find PnfInstance");
		Optional<PnfInstance> pnfOpt = pnfInstanceRepository.findByPnfInstanceId(pnfInstanceId);
		if(pnfOpt.isPresent()){
			List<IndicatorInformation>  indicatorInformations = getPnfInstanceIndicators(pnfInstanceId);
			List<PnfInstanceMetadata> metadata = new ArrayList<>();
			PnfInstance pInstance = pnfOpt.get();
			for(IndicatorInformation ii : indicatorInformations){
				metadata.add(new StringMetadata(pnfOpt.get(), ii.getIndicatorName(), ii.getIndicatorValue()));
			}
			pInstance.setPnfInstanceMetadata(metadata);
			pnfInstanceRepository.saveAndFlush(pInstance);
		}else{
			log.debug("Could not find PnfInstance with id:"+pnfInstanceId);
		}




	}
}
