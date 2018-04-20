package it.nextworks.nfvmano.timeo.rc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.repositories.ResourceComputationDbWrapper;
import it.nextworks.nfvmano.timeo.tenant.Tenant;
import it.nextworks.nfvmano.timeo.tenant.TenantManagementService;

/**
 * This class offers REST APIs to retrieve scheduling solutions 
 * from the internal DBs.
 * 
 * @author nextworks
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/nfvo/resourceComputation")
public class ResourceSchedulingController {
	
	private static final Logger log = LoggerFactory.getLogger(ResourceSchedulingController.class);
	
	@Autowired
	ResourceComputationDbWrapper resourceComputationDbWrapper;
	
	@Autowired
	TenantManagementService tenantManagementService;

	public ResourceSchedulingController() {	}
	
	@RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.GET)
	public ResponseEntity<?> getNsSolutionsPerTenant(@PathVariable String tenantId) {
		log.debug("Received request to retrieve the details of NS solutions for tenant " + tenantId);
		List<NsResourceSchedulingSolution> result = new ArrayList<>();
		try {
			Tenant tenant = tenantManagementService.getTenant(tenantId);
			Set<String> nsInstances = tenant.getNsId();
			for (String nsId : nsInstances) {
				NsResourceSchedulingSolution solution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsId);
				result.add(solution);
			}
			return new ResponseEntity<List<NsResourceSchedulingSolution>>(result, HttpStatus.OK);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/ns/{nsId}", method = RequestMethod.GET)
	public ResponseEntity<?> getNsSolution(@PathVariable String nsId) {
		log.debug("Received request to retrieve the details of resource allocation solutions for NS " + nsId);
		try {
			NsResourceSchedulingSolution solution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsId);
			return new ResponseEntity<NsResourceSchedulingSolution>(solution, HttpStatus.OK);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/nss", method = RequestMethod.GET)
	public ResponseEntity<?> getAllNsSolutions() {
		log.debug("Received request to retrieve the details of all the NS solutions in DB.");
		List<NsResourceSchedulingSolution> result = resourceComputationDbWrapper.getAllNsResourceSchedulingSolutions();
		if ((result == null) || (result.isEmpty())) {
			return new ResponseEntity<String>("No solutions found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<NsResourceSchedulingSolution>>(result, HttpStatus.OK);
	}

}
