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

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

/**
 * This class manages external requests related to the EMMA tenants. 
 * 
 * @author nextworks
 *
 */
@Service
public class TenantManagementService {
	
	private static final Logger log = LoggerFactory.getLogger(TenantManagementService.class);
	
	@Autowired
	private TenantRepository tenantRepository;

	public TenantManagementService() {}
	
	public synchronized void createTenant(String username, String password) throws AlreadyExistingEntityException {
		log.debug("Creating new tenant with tenant ID " + username);
		try {
			Tenant old = getTenant(username);
			log.error("Tenant with tenant ID " + username + " already found in DB. Impossible to create a new one.");
			throw new AlreadyExistingEntityException("Tenant with tenant ID " + username + " already found in DB. Impossible to create a new one.");
		} catch (NotExistingEntityException e) {
			Tenant target = new Tenant(username, password);
			tenantRepository.saveAndFlush(target);
		}
	}
	
	public Tenant getTenant(String tenantId) throws NotExistingEntityException {
		log.debug("Retrieving tenant with tenant ID " + tenantId);
		Optional<Tenant> tenantOpt = tenantRepository.findByTenantId(tenantId);
		if (tenantOpt.isPresent()) {
			return tenantOpt.get();
		} else {
			log.debug("Tenant with tenant ID " + tenantId + " not found");
			throw new NotExistingEntityException("Tenant with tenant ID " + tenantId + " not found");
		}
	}
	
	public List<Tenant> getTenants() {
		log.debug("Retrieving all tenants");
		return tenantRepository.findAll();
	}
	
	public synchronized void removeTenant(String tenantId) throws NotExistingEntityException {
		log.debug("Removing tenant with tenant ID " + tenantId);
		Tenant target = getTenant(tenantId);
		tenantRepository.delete(target);
		log.debug("Tenant with tenant ID " + tenantId + " removed from DB.");
	}
	
	public synchronized void updatePassword(String tenantId, String oldPassword, String newPassword) throws NotExistingEntityException, FailedOperationException {
		log.debug("Updating password for tenant " + tenantId);
		Tenant target = getTenant(tenantId);
		if (target.getPassword() != oldPassword) {
			log.error("Old password mismatch. Cannot update the password");
			throw new FailedOperationException("Old password mismatch. Cannot update the password");
		}
		target.setPassword(newPassword);
		tenantRepository.saveAndFlush(target);
		log.debug("Password updated");
	}
	
	public synchronized void addNsInstanceToTenant(String tenantId, String nsInstanceId) throws NotExistingEntityException {
		log.debug("Adding NS instance " + nsInstanceId + " to tenant " + tenantId);
		Tenant target = getTenant(tenantId);
		target.addNs(nsInstanceId);
		tenantRepository.saveAndFlush(target);
		log.debug("NS instance " + nsInstanceId + " added to tenant " + tenantId);
	}
	
	public synchronized void removeNsInstanceFromTenant(String tenantId, String nsInstanceId) throws NotExistingEntityException {
		log.debug("Removing NS instance " + nsInstanceId + " from tenant " + tenantId);
		Tenant target = getTenant(tenantId);
		target.removeNs(nsInstanceId);
		tenantRepository.saveAndFlush(target);
		log.debug("NS instance " + nsInstanceId + " removed from tenant " + tenantId);
	}

}
