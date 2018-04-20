package it.nextworks.nfvmano.timeo.vnfm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.NfvoConstants;
import it.nextworks.nfvmano.timeo.ro.VimResourcePollingManager;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriversManager;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfDbWrapper;

/**
 * Internal component of the NFVO which handles the VNFMs instances
 * 
 * 
 * @author nextworks
 *
 */
@Service
public class VnfmHandler {

	private static final Logger log = LoggerFactory.getLogger(VnfmHandler.class);
	
	private Map<String, Vnfm> vnfms = new HashMap<>();
	
	@Value("${timeo.defaultVnfmType}")
	private String defaultVnfmType;
	
	@Value("${spring.rabbitmq.host}")
	private String rabbitHost;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	@Qualifier(NfvoConstants.vnfmQueueExchange)
	TopicExchange messageExchange;
	
	@Autowired
	private VnfmInfoRepository vnfmInfoRepository;
	
	@Autowired
	private VnfDbWrapper vnfDbWrapper;
	
	@Autowired
	private VnfPackageManagementService vnfPackageManagementService;
	
	@Autowired
	private VimResourcePollingManager vimResourcePollingManager;
	
	@Autowired
	private SbDriversManager sbDriversManager;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	public VnfmHandler() { }
	
	/**
	 * Initializes all the VNFMs stored in the DB.
	 * 
	 */
	@PostConstruct
	public void initVnfms() {
		log.debug("Initializing VNFM");
		List<VnfmInfo> vnfmInfos = vnfmInfoRepository.findAll();
		for (VnfmInfo vi : vnfmInfos) {
			try {
				addVnfm(vi);
			} catch (MalformattedElementException e) {
				log.warn("Malformed VNFM: " + e.getMessage() + ". Skipping.");
				continue;
			}
		}
		log.debug("VNFMs initialized");
	}
	
	/**
	 * Add a new VNFM in the VNFM handler.
	 * 
	 * @param vnfmInfo description of the VNFM to be instantiated
	 * @throws MalformattedElementException if the VNFM description is not acceptable
	 */
	public void addVnfm(VnfmInfo vnfmInfo) throws MalformattedElementException {
		Vnfm vnfm = instantiateVnfm(vnfmInfo);
		vnfms.put(vnfm.getName(), vnfm);
		log.debug("Loaded VNFM " + vnfm.getName());
	}
	
	/**
	 * Remove a VNFM from the VNFM handler
	 * 
	 * @param vnfmName name of the VNFM to be removed
	 * @throws NotExistingEntityException if the VNFM is not present in the VNFM handler
	 */
	public void removeVnfm(String vnfmName) throws NotExistingEntityException {
		if (vnfms.containsKey(vnfmName)) {
			vnfms.remove(vnfmName);
			log.debug("Removed VNFM " + vnfmName);
		} else throw new NotExistingEntityException("VNFM " + vnfmName + " not found");
	}
	
	/**
	 * Returns the default VNFM
	 * 
	 * @return the default VNFM
	 * @throws NotExistingEntityException if the default VNFM is not existing
	 */
	public Vnfm getDefaultVnfm() throws NotExistingEntityException {
		log.debug("Searching for default VNFM.");
		List<VnfmInfo> vnfmInfos = new ArrayList<>();
		if (defaultVnfmType.equals("SDK")) {
			vnfmInfos = vnfmInfoRepository.findByType(VnfmType.SDK);
		} else if (defaultVnfmType.equals("REST")) {
			vnfmInfos = vnfmInfoRepository.findByType(VnfmType.REST);
		} else {
			throw new NotExistingEntityException("Unacceptable default VNFM type.");
		}
		if ((vnfmInfos == null) || (vnfmInfos.isEmpty())) {
			throw new NotExistingEntityException("No VNFMs found in DB");
		}
		String vnfmName = vnfmInfos.get(0).getName();
		log.debug("Default VNFM: " + vnfmName);
		return getVnfm(vnfmName);
	}
	
	/**
	 * Returns the VNFM with the given name
	 * 
	 * @param vnfmName name of the VNFM to be returned
	 * @return the VNFM with the given name
	 * @throws NotExistingEntityException if the VNFM is not present in the VNFM handler
	 */
	public Vnfm getVnfm(String vnfmName) throws NotExistingEntityException {
		log.debug("Searching for VNFM " + vnfmName);
		if (vnfms.containsKey(vnfmName)) {
			return vnfms.get(vnfmName);
		} else throw new NotExistingEntityException("VNFM " + vnfmName + " not found");
	}
	
	private Vnfm instantiateVnfm(VnfmInfo vnfmInfo) throws MalformattedElementException {
		if (vnfmInfo.getType().equals(VnfmType.SDK)) {
			return new SdkVnfm(vnfmInfo, vnfDbWrapper, vnfPackageManagementService, vimResourcePollingManager, sbDriversManager, 
					rabbitHost, rabbitTemplate, messageExchange, taskExecutor);
		} if (vnfmInfo.getType().equals(VnfmType.REST)) {
			throw new MalformattedElementException("At the moment REST VNFM type is not supported. Skipping.");
		} else {
			throw new MalformattedElementException("Unsupported VNFM type. Skipping.");
		}
	}

	/**
	 * @return the vnfms
	 */
	public Map<String, Vnfm> getVnfms() {
		return vnfms;
	}

}
