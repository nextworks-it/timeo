package it.nextworks.nfvmano.timeo.vnfm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.ro.ResourceAllocationManager;

@RestController
@CrossOrigin
@RequestMapping("/nfvo/vnfmLcm")
public class VnfmLcmController {

	private static final Logger log = LoggerFactory.getLogger(VnfmLcmController.class);
	
	@Autowired
	ResourceAllocationManager resourceAllocationManager;
	
	@Autowired 
	VnfmHandler vnfmHandler;
	
	public VnfmLcmController() { }

	@RequestMapping(value = "/ns/{nsInstanceId}/vnf/{vnfInstanceId}", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveVnfInfo(@PathVariable String nsInstanceId, @PathVariable String vnfInstanceId) {
		log.debug("Received query for VNF " + vnfInstanceId + " belonging to NS instance " + nsInstanceId);
		try {
			
			Vnfm vnfm = resourceAllocationManager.getVnfmForVnfInstance(nsInstanceId, vnfInstanceId);
			VnfInfo vnfInfo = vnfm.queryVnf(new GeneralizedQueryRequest(Utilities.buildVnfInfoFilter(vnfInstanceId), new ArrayList<>())).getVnfInfo().get(0);
			return new ResponseEntity<VnfInfo>(vnfInfo, HttpStatus.OK);
			
		} catch (NotExistingEntityException e) {
			log.error("Unable to retrieve VNF info: " + e.getMessage());
			return new ResponseEntity<String>("Unable to retrieve VNF info: " + e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error("Unable to retrieve VNF info: general exception");
			return new ResponseEntity<String>("Unable to retrieve VNF info: general exception", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/nss/vnfs", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveAllVnfInfos() {
		log.debug("Received query for all the VNFs.");
		List<VnfInfo> vnfInfos = new ArrayList<>();
		Map<String, Vnfm> vnfms = vnfmHandler.getVnfms();
		log.debug("Retrieved VNFMs");
		try {
			for (Map.Entry<String, Vnfm> vnfm : vnfms.entrySet()) {
				log.debug("Retrieving VNFs from VNFM " + vnfm.getKey());
				List<VnfInfo> vnfInfo = vnfm.getValue().queryVnf(new GeneralizedQueryRequest(new Filter(), new ArrayList<>())).getVnfInfo();
				vnfInfos.addAll(vnfInfo);
				log.debug("Added " + vnfInfo.size() + " VNFs.");
			}
			log.debug("Retrieved VNFs from all the VNFMs.");
			return new ResponseEntity<List<VnfInfo>>(vnfInfos, HttpStatus.OK);
		}
		catch (Exception e) {
			log.debug("Error while retrieving list of VNFs: " + e.getMessage());
			return new ResponseEntity<String>("Unable to retrieve VNF info: general exception", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
