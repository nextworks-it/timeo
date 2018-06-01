/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.tenant;

import java.util.ArrayList;
import java.util.List;

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

/**
 * This class implements the REST APIs for the tenant management
 * service of the NFVO.
 * 
 * @author nextworks
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/nfvo/tenantManagement")
public class TenantManagementController {
	
	private static final Logger log = LoggerFactory.getLogger(TenantManagementController.class);
	
	@Autowired
	TenantManagementService tenantManagementService;

	public TenantManagementController() {}
	
	@RequestMapping(value = "/tenant", method = RequestMethod.POST)
	public ResponseEntity<?> createTenant(@RequestBody Tenant tenant) {
		log.debug("Received request to add tenant");
		try {
			tenant.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		try {
			tenantManagementService.createTenant(tenant.getUserName(), tenant.getPassword());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (AlreadyExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTenant(@PathVariable String tenantId) {
		log.debug("Received request to delete tenant " + tenantId);
		try {
			tenantManagementService.removeTenant(tenantId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.GET)
	public ResponseEntity<?> getTenant(@PathVariable String tenantId) {
		log.debug("Received request to retrieve details for tenant " + tenantId);
		try {
			Tenant result = tenantManagementService.getTenant(tenantId);
			//This is to avoid returning the password in clear
			result.setPassword(null);
			return new ResponseEntity<Tenant>(result, HttpStatus.OK);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/tenants", method = RequestMethod.GET)
	public ResponseEntity<?> getTenants() {
		log.debug("Received request to retrieve details for all tenants");
		try {
			List<Tenant> result = new ArrayList<>();
			List<Tenant> tenants = tenantManagementService.getTenants();
			for (Tenant t : tenants) {
				t.setPassword(null);
				result.add(t);
			}
			return new ResponseEntity<List<Tenant>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
