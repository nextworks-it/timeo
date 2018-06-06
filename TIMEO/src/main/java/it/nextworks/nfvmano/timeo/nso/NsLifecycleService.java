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
package it.nextworks.nfvmano.timeo.nso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.NsLcmConsumerInterface;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.NsLcmProviderInterface;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.CreateNsIdentifierRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.HealNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.QueryNsResponse;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.UpdateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.UpdateNsResponse;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.NsdManagementService;
import it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories.InternalNsdInfo;
import it.nextworks.nfvmano.timeo.nso.repository.InternalOperation;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.tenant.Tenant;
import it.nextworks.nfvmano.timeo.tenant.TenantManagementService;


/**
 * This service manages the external requests for NS lifecycle management.
 * It interacts with the internal repositories of NS instances for synchronous 
 * actions and sends messages to the engine for asynchronous actions.
 * 
 * Its methods are invoked by the NsLifecycleManagementController class.
 * 
 * @author nextworks
 *
 */
@Service
public class NsLifecycleService implements NsLcmProviderInterface {

	private static final Logger log = LoggerFactory.getLogger(NsLifecycleService.class);
	
	@Autowired
	NsDbWrapper nsDbWrapper;
	
	@Autowired
	NsdManagementService nsdManagement;
	
	@Autowired
	NsManagementEngine nsManagementEngine;
	
	@Autowired
	TenantManagementService tenantManagementService;
	
	public NsLifecycleService() {	}

	@Override
	public String createNsIdentifier(CreateNsIdentifierRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		//TODO: check - here we assume the NSD ID refers to the NSD INFO ID. Otherwise, in case of NSD ID, it should provide also the NSD version.
		String nsdId = request.getNsdId();
		String nsName = request.getNsName();
		String nsDescription = request.getNsDescription();
		String tenantId = request.getTenantId();
		//TODO: tenant management to be done with policies on permitted actions
		
		log.debug("Received create NS ID request: NSD ID - " + nsdId + "; NS NAME - " + nsName + "; NS Description: " + nsDescription + "; Tenant ID: " + tenantId);
		request.isValid();
		InternalNsdInfo iNsdInfo = nsdManagement.findNsdInfo(nsdId);
		Tenant tenant = tenantManagementService.getTenant(tenantId);
		if (tenant != null) log.debug("Tenant found");
		
		if (iNsdInfo.canBeInstantiated()) {
			Nsd nsd = nsdManagement.findNsd(iNsdInfo);
			String nsIdentifier = this.nsDbWrapper.createNsInfo(nsdId, nsd, nsName, nsDescription, tenantId);
			nsdManagement.notifyNsInstanceCreation(nsdId, nsIdentifier);
			log.debug("Successfully created NS Identifier " + nsIdentifier);
			nsManagementEngine.initNewNsManager(nsIdentifier);
			tenantManagementService.addNsInstanceToTenant(tenantId, nsIdentifier);
			return nsIdentifier;			
		} else {
			log.debug("The NS cannot be instantiated due to the status of the NSD");
			throw new FailedOperationException("NS instantiation failed. Wrong status of the NSD");
		}
	}
	
	@Override
	public String instantiateNs(InstantiateNsRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received instantiate NS request");
		String operationId = nsManagementEngine.instantiateNetworkService(request);
		return operationId;
	}
	
	@Override
	public String scaleNs(ScaleNsRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received scale NS request");
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	@Override
	public UpdateNsResponse updateNs(UpdateNsRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received update NS request");
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	@Override
	public QueryNsResponse queryNs(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received query NS request");

		//At the moment the only filter accepted are:
		//1. NS Instance ID
		//No attribute selector is supported at the moment
		
		Filter filter = request.getFilter();
		List<String> attributeSelector = request.getAttributeSelector();
		
		List<NsInfo> queryNsResult = new ArrayList<>();
		
		if ((attributeSelector == null) || (attributeSelector.isEmpty())) {
			Map<String,String> fp = filter.getParameters();
			if (fp.size() == 0) {
				List<NsInfo> nsInfos = nsDbWrapper.getAllNsInfo();
				queryNsResult.addAll(nsInfos);
				return new QueryNsResponse(ResponseCode.OK, queryNsResult);
			} else if (fp.size()==1 && fp.containsKey("NS_ID")) {
				String nsInstanceId = fp.get("NS_ID");
				NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
				queryNsResult.add(nsInfo);
				return new QueryNsResponse(ResponseCode.OK, queryNsResult);
			} else {
				log.error("Received query NS with not supported filter.");
				return new QueryNsResponse(ResponseCode.FAILED_GENERIC, null);
			}
		} else {
			log.error("Received query NS with attribute selector. Not supported at the moment.");
			return new QueryNsResponse(ResponseCode.FAILED_GENERIC, null);
		}
	}
	
	@Override
	public String terminateNs(TerminateNsRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received terminate NS request");
		String operationId = nsManagementEngine.terminateNetworkService(request);
		return operationId;
	}
	
	@Override
	public void deleteNsIdentifier(String nsInstanceIdentifier) throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException {
		log.debug("Received delete NS Identifier request for NS instance " + nsInstanceIdentifier);
		NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceIdentifier);
		if (nsInfo.getNsState() == InstantiationState.INSTANTIATED) {
			log.error("NS " + nsInstanceIdentifier + " is in instantiated state. Impossible to delete.");
			throw new FailedOperationException("NS " + nsInstanceIdentifier + " is in instantiated state. Impossible to delete.");
		}
		String tenantId = nsInfo.getTenantId();
		nsDbWrapper.deleteNsInfo(nsInstanceIdentifier);
		nsdManagement.notifyNsInstanceDeletion(nsInfo.getNsdId(), nsInstanceIdentifier);
		tenantManagementService.removeNsInstanceFromTenant(tenantId, nsInstanceIdentifier);
		log.debug("NS instance " + nsInstanceIdentifier + " removed.");
	}
	
	@Override
	public String healNs(HealNsRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received heal NS Identifier request");
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	@Override
	public OperationStatus getOperationStatus(String operationId) throws MethodNotImplementedException, NotExistingEntityException {
		log.debug("Received get operation status request for operation " + operationId);
		InternalOperation internalOperation = nsDbWrapper.readInternalOperation(operationId);
		return internalOperation.getStatus();
	}
	
	public String subscribeNsLcmEvents(SubscribeRequest request, NsLcmConsumerInterface consumer) 
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		log.debug("Received NS LCM subscribe request");
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	public void unsubscribeNsLcmEvents(String subscriptionId) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		log.debug("Received NS LCM unsubscribe request");
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	public void queryNsSubscription(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Received query NS LCM subscription request");
		//TODO:
		throw new MethodNotImplementedException();
	}
}
