package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;

/**
 * This controller implements the REST API to manage PNF instances.
 * The internal implementation of the service is handled through the PnfManagementService.
 * 
 * @author nextworks
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/nfvo/pnfInstanceManagement")
public class PnfManagementController {
	
	private static final Logger log = LoggerFactory.getLogger(PnfManagementController.class);
	
	@Autowired
	private PnfManagementService pnfManagementService;

	public PnfManagementController() {	}
	
	@RequestMapping(value = "/pnf", method = RequestMethod.POST)
	public ResponseEntity<?> onBoardNsd(@RequestBody PnfInstance pnfInstance) {
		log.debug("Received an on-board PNF instance request");
		try {
			pnfManagementService.addPnfInstance(pnfInstance);
			return new ResponseEntity<String>(pnfInstance.getPnfInstanceId(), HttpStatus.CREATED);
		} catch (AlreadyExistingEntityException e) {
			log.error("Error while onboarding PNF instance: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (MalformattedElementException e) {
			log.error("Error while onboarding PNF instance: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/pnf/{pnfInstanceId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removePnf(@PathVariable String pnfInstanceId) {
		log.debug("Received request to remove PNF instance with ID " + pnfInstanceId);
		try {
			pnfManagementService.deletePnfInstance(pnfInstanceId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(NotExistingEntityException e) {
			log.error("Error while removing PNF instance: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/pnf/query", method = RequestMethod.POST)
	public ResponseEntity<?> queryPnf(@RequestBody GeneralizedQueryRequest request) {
		log.debug("Received generalized PNF instance query.");
		try {
			request.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted query: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		Map<String, String> params = request.getFilter().getParameters();
		List<PnfInstance> pnfs = new ArrayList<>();
		if (params.containsKey("PNFD_ID")) {
			pnfs = pnfManagementService.getPnfInstancesFromPnfd(params.get("PNFD_ID"));
			return new ResponseEntity<List<PnfInstance>>(pnfs, HttpStatus.OK);
		} else if (params.containsKey("PNF_ID")) {
			try {
				PnfInstance pnf = pnfManagementService.getPnfInstance(params.get("PNF_ID"));
				pnfs.add(pnf);
				return new ResponseEntity<List<PnfInstance>>(pnfs, HttpStatus.OK);
			} catch(NotExistingEntityException e) {
				log.error("Error while retrieving PNF instance: " + e.getMessage());
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			}			
		} else {
			log.error("Malformatted query: unacceptable filter");
			return new ResponseEntity<String>("Malformatted query: unacceptable filter", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/pnf/{pnfInstanceId}", method = RequestMethod.GET)
	public ResponseEntity<?> querySpecificPnf(@PathVariable String pnfInstanceId) {
		log.debug("Received query for PNF instance with ID " + pnfInstanceId);
		try {
			return new ResponseEntity<PnfInstance>(pnfManagementService.getPnfInstance(pnfInstanceId), HttpStatus.OK);
		} catch(NotExistingEntityException e) {
			log.error("Error while retrieving PNF instance: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/pnfs", method = RequestMethod.GET)
	public ResponseEntity<?> queryAllPnf() {
		log.debug("Received query for all the PNF instances");
		return new ResponseEntity<List<PnfInstance>>(pnfManagementService.getAllPnfInstances(), HttpStatus.OK);
	}
 
}

