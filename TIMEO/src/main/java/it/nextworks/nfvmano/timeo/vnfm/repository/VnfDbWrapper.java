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
package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.elements.MonitoringParameter;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.elements.ScaleInfo;
import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.enums.OperativeState;
import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VimConnectionInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.ExtLinkPort;
import it.nextworks.nfvmano.libs.records.vnfinfo.ExtVirtualLinkInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.InstantiatedVnfInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VirtualLinkResourceInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfExtCpInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfcResourceInfo;


/**
 * Service which manages the DBs related to the VNF instances.
 * 
 * @author nextworks
 *
 */
@Service
public class VnfDbWrapper {

	private static final Logger log = LoggerFactory.getLogger(VnfDbWrapper.class);
	
	@Autowired
	private VnfInfoRepository vnfInfoRepository;
	
	@Autowired
	private VnfmInternalOperationRepository vnfmInternalOperationRepository;
	
	@Autowired
	private InstantiatedVnfInfoRepository instantiatedVnfInfoRepository;
	
	@Autowired
	private ExtVirtualLinkInfoRepository extVirtualLinkInfoRepository;
	
//	@Autowired
//	private VnfLinkPortRepository vnfLinkPortRepository;
	
	@Autowired
	private ExtLinkPortRepository extLinkPortRepository;
	
	@Autowired
	private VnfExtCpInfoRepository vnfExtCpInfoRepository;
	
	@Autowired
	private VnfcResourceInfoRepository vnfcResourceInfoRepository;
	
	@Autowired
	private VirtualLinkResourceInfoRepository virtualLinkResourceInfoRepository;
	
	public VnfDbWrapper() {	}
	
	/**************** Methods for VNF info ***********************************/
	
	public synchronized String createVnfInfo(String vnfInstanceName, String vnfInstanceDescription, String vnfdId, String vnfProvider,
			String vnfProductName, String vnfSoftwareVersion, String vnfdVersion, String onboardedVnfPkgInfoId, Map<String, String> vnfConfigurableProperty, 
			Map<String, String> metadata) {
		log.debug("Creating new VNF info entry in DB.");
		VnfInfo vnfInfoTarget = new VnfInfo(null, 
				vnfInstanceName, 
				vnfInstanceDescription, 
				vnfdId, 
				vnfProvider, 
				vnfProductName, 
				vnfSoftwareVersion, 
				vnfdVersion, 
				onboardedVnfPkgInfoId, 
				vnfConfigurableProperty,
				new ArrayList<VimConnectionInfo>(),	//vimConnectionInfo
				InstantiationState.NOT_INSTANTIATED, metadata,
				new HashMap<String,String>());	//extension
		vnfInfoRepository.saveAndFlush(vnfInfoTarget);
		String vnfInstanceId = vnfInfoTarget.getId().toString();
		log.debug("Created VNF info entry with ID " + vnfInstanceId);
		vnfInfoTarget.setVnfInstanceId(vnfInstanceId);
		vnfInfoRepository.saveAndFlush(vnfInfoTarget);
		return vnfInstanceId;
	}
	
	public VnfInfo getVnfInfo(String vnfInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving VNF Info " + vnfInstanceId + " from DB");
		Optional<VnfInfo> vnfInfoOpt = vnfInfoRepository.findByVnfInstanceId(vnfInstanceId);
		if (vnfInfoOpt.isPresent()) {
			return vnfInfoOpt.get();
		} else {
			log.error("VNF Info " + vnfInstanceId + " not found");
			throw new NotExistingEntityException("VNF Info " + vnfInstanceId + " not found");
		}
	}
	
	public List<VnfInfo> getAllVnfInfo() {
		log.debug("Retrieving all VNF info from DB");
		return vnfInfoRepository.findAll();
	}
	
	public synchronized void setVnfInfoInstantiationState (String vnfInstanceId, InstantiationState instantiationState) throws NotExistingEntityException {
		log.debug("Setting instantiation state for VNF info " + vnfInstanceId);
		VnfInfo vnfInfo = getVnfInfo(vnfInstanceId);
		vnfInfo.setInstantiationState(instantiationState);
		vnfInfoRepository.saveAndFlush(vnfInfo);
		log.debug("Set instantiation state for VNF info " + vnfInstanceId);
	}
	
	public synchronized void deleteVnfInfo(String vnfInstanceId) throws NotExistingEntityException {
		log.debug("Deleting VNF Info " + vnfInstanceId + " from DB");
		Optional<VnfInfo> vnfInfoOpt = vnfInfoRepository.findByVnfInstanceId(vnfInstanceId);
		if (vnfInfoOpt.isPresent()) {
			vnfInfoRepository.delete(vnfInfoOpt.get());
		} else {
			log.error("VNF Info " + vnfInstanceId + " not found");
			throw new NotExistingEntityException("VNF Info " + vnfInstanceId + " not found");
		}
	}

	//****************************** METHODS RELATED TO INSTANTIATED VNF INFO ********************************************************
	
	public synchronized void createInstantiatedVnfInfo(String vnfInstanceId, String flavourId, List<ScaleInfo> scaleStatus, 
			List<MonitoringParameter> monitoringParameter, String localizationLanguage,	List<VimConnectionInfo> vimInfo,
			List<ExtVirtualLinkInfo> extVirtualLinkInfo) 
			throws NotExistingEntityException, AlreadyExistingEntityException {
		log.debug("Creating instantiated VNF info for VNF instance ID " + vnfInstanceId);
		Optional<InstantiatedVnfInfo> vnfInfoOpt = instantiatedVnfInfoRepository.findByVnfInfoVnfInstanceId(vnfInstanceId);
		if (vnfInfoOpt.isPresent()) throw new AlreadyExistingEntityException("Instantiated VNF info for VNF instance ID " + vnfInstanceId + " already in DB");
		VnfInfo vnfInfo = getVnfInfo(vnfInstanceId);
		InstantiatedVnfInfo iVnfInfo = new InstantiatedVnfInfo(vnfInfo, flavourId, OperativeState.STOPPED, 
				scaleStatus, monitoringParameter, localizationLanguage);
		instantiatedVnfInfoRepository.saveAndFlush(iVnfInfo);
		log.debug("Instantiated VNF info added to DB");
		//TODO: store VIM info
		for (ExtVirtualLinkInfo vl: extVirtualLinkInfo) {
			ExtVirtualLinkInfo vlTarget = new ExtVirtualLinkInfo(iVnfInfo, vl.getExtVirtualLinkId(), 
					new ResourceHandle(vl.getResourceHandle().getVimId(), vl.getResourceHandle().getResourceProviderId(), vl.getResourceHandle().getResourceId()));
			extVirtualLinkInfoRepository.saveAndFlush(vlTarget);
			log.debug("External virtual link info for virtual link " + vl.getExtVirtualLinkId() + " added in DB.");
		}
				
	}
	
	public InstantiatedVnfInfo getInstantiatedVnfInfo(String vnfInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving instantiated VNF info for VNF instance ID " + vnfInstanceId);
		Optional<InstantiatedVnfInfo> vnfInfoOpt = instantiatedVnfInfoRepository.findByVnfInfoVnfInstanceId(vnfInstanceId);
		if (vnfInfoOpt.isPresent()) return vnfInfoOpt.get();
		else {
			log.error("Instantiated VNF info for VNF instance ID " + vnfInstanceId + " not found");
			throw new NotExistingEntityException("Instantiated VNF info for VNF instance ID " + vnfInstanceId + " not found");
		}
	}
	
	public synchronized void deleteInstantiatedVnfInfo(String vnfInstanceId) throws NotExistingEntityException {
		log.debug("Deleting instantiated VNF Info " + vnfInstanceId + " from DB");
		Optional<InstantiatedVnfInfo> vnfInfoOpt = instantiatedVnfInfoRepository.findByVnfInfoVnfInstanceId(vnfInstanceId);
		if (vnfInfoOpt.isPresent()) {
			instantiatedVnfInfoRepository.delete(vnfInfoOpt.get());
		} else {
			log.error("Instantiated VNF Info " + vnfInstanceId + " not found");
			throw new NotExistingEntityException("Instantiated VNF Info " + vnfInstanceId + " not found");
		}
	}
	
	public synchronized void updateInstantiatedVnfInfoStatus(String vnfInstanceId, OperativeState vnfState) throws NotExistingEntityException {
		log.debug("Updating status for instantiated VNF info " + vnfInstanceId);
		InstantiatedVnfInfo iVnfInfo = getInstantiatedVnfInfo(vnfInstanceId);
		iVnfInfo.setVnfState(vnfState);
		instantiatedVnfInfoRepository.saveAndFlush(iVnfInfo);
		log.debug("Updated status for instantiated VNF info " + vnfInstanceId);
	}

	
	//****************************** METHODS RELATED TO VNF INTERNAL OPERATIONS ********************************************************

	public synchronized void createNewVnfmInternalOperation(String operationId, String vnfId, String description) throws AlreadyExistingEntityException {
		log.debug("Storing new VNFM internal operation in DB");
		if (vnfmInternalOperationRepository.findByOperationId(operationId).isPresent()) {
			throw new AlreadyExistingEntityException("Operation ID " + operationId + " already present. Impossible to store a new operation.");
		}
		VnfmInternalOperation operation = new VnfmInternalOperation(operationId, vnfId, description);
		vnfmInternalOperationRepository.saveAndFlush(operation);
		log.debug("Internal operation stored in DB");
	}

	public synchronized void updateVnfmInternalOperation(String operationId, OperationStatus status, String failureMessage) throws NotExistingEntityException {
		log.debug("Updating status and failure message of VNFM internal operation in DB");
		VnfmInternalOperation operation = readVnfmInternalOperation(operationId);
		operation.setStatus(status);
		operation.setFailureMessage(failureMessage);
		vnfmInternalOperationRepository.saveAndFlush(operation);
		log.debug("Status and failure message of VNFM internal operation updated in DB");
	}

	public VnfmInternalOperation readVnfmInternalOperation(String operationId) throws NotExistingEntityException {
		log.debug("Retrieving VNFM internal operation from DB");
		Optional<VnfmInternalOperation> operationOpt = vnfmInternalOperationRepository.findByOperationId(operationId);
		if (operationOpt.isPresent()) {
			return operationOpt.get();
		} else {
			log.error("VNFM internal operation not found");
			throw new NotExistingEntityException("VNFM operation ID " + operationId + " not available in DB.");
		}
	}
	
	//****************************** METHODS RELATED TO VNF ports ********************************************************

	public synchronized void addVnfLinkPort(String vnfInstanceId, String extVirtualLinkId, String vnfExternalCpId, ResourceHandle portRh)
	 throws NotExistingEntityException {
		log.debug("Adding VNF link port to external VL info");
		Optional<ExtVirtualLinkInfo> extVlInfoOpt = extVirtualLinkInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndExtVirtualLinkId(vnfInstanceId, extVirtualLinkId);
		if (extVlInfoOpt.isPresent()) {
			ExtLinkPort vlp = new ExtLinkPort(extVlInfoOpt.get(),
					portRh.getResourceId(),
					new ResourceHandle(portRh.getVimId(), portRh.getResourceProviderId(), portRh.getResourceId()), 
					vnfExternalCpId);
			extLinkPortRepository.saveAndFlush(vlp);
		} else throw new NotExistingEntityException("External VL info for VL " + extVirtualLinkId + " not existing for VNF " + vnfInstanceId);	
	}
	
	//****************************** METHODS RELATED TO External CP info ********************************************************
	
	public VnfExtCpInfo getVnfExtCpInfoFromCpdId(String vnfInstanceId, String cpdId) throws NotExistingEntityException {
		log.debug("Retrieving VNF external connection point with cpd ID " + cpdId + " for VNF " + vnfInstanceId);
		Optional<VnfExtCpInfo> vnfExtCpInfoOpt = vnfExtCpInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndCpdId(vnfInstanceId, cpdId);
		if (vnfExtCpInfoOpt.isPresent()) {
			return vnfExtCpInfoOpt.get();
		} else throw new NotExistingEntityException("VNF external connection point with cpd ID " + cpdId + " for VNF " + vnfInstanceId + " not found");
	}
	
	public VnfExtCpInfo getVnfExtCpInfoFromResourceId(String vnfInstanceId, String portResourceId) throws NotExistingEntityException {
		log.debug("Retrieving VNF external connection point with cp instance ID " + portResourceId + " for VNF " + vnfInstanceId);
		Optional<VnfExtCpInfo> vnfExtCpInfoOpt = vnfExtCpInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndCpInstanceId(vnfInstanceId, portResourceId);
		if (vnfExtCpInfoOpt.isPresent()) {
			return vnfExtCpInfoOpt.get();
		} else throw new NotExistingEntityException("VNF external connection point with cp instance ID " + portResourceId + " for VNF " + vnfInstanceId + " not found");
	}
	
	public List<VnfExtCpInfo> getAllVnfExtCpInfo(String vnfInstanceId) {
		return vnfExtCpInfoRepository.findByIVnfInfoVnfInfoVnfInstanceId(vnfInstanceId);
	}
	
	public synchronized void addVnfExtCpInfo(String vnfInstanceId, String cpInstanceId, String cpdId) throws NotExistingEntityException {
		log.debug("Adding VNF external connection point info");
		InstantiatedVnfInfo iVnfInfo = getInstantiatedVnfInfo(vnfInstanceId);
		VnfExtCpInfo vnfExtCpInfo = new VnfExtCpInfo(iVnfInfo, cpInstanceId, cpdId, null);
		vnfExtCpInfoRepository.saveAndFlush(vnfExtCpInfo);
		log.debug("VNF external connection point added");
	}
	
	public synchronized void addAddressToVnfExtCp(String vnfInstanceId, String cpInstanceId, String address) throws NotExistingEntityException {
		log.debug("Adding address to VNF external connection point " + cpInstanceId + " in VNF " + vnfInstanceId);
		VnfExtCpInfo cp = getVnfExtCpInfoFromResourceId(vnfInstanceId, cpInstanceId);
		cp.addAddress(address);
		vnfExtCpInfoRepository.saveAndFlush(cp);
		log.debug("Address added to the VNF external connection point");
	}
	
	public synchronized void setStatusForVnfExtCp(String vnfInstanceId, String cpInstanceId, VimResourceStatus status) throws NotExistingEntityException {
		log.debug("Setting status for VNF external connection point " + cpInstanceId + " in VNF " + vnfInstanceId);
		VnfExtCpInfo cp = getVnfExtCpInfoFromResourceId(vnfInstanceId, cpInstanceId);
		cp.setVimResourceStatus(status);;
		vnfExtCpInfoRepository.saveAndFlush(cp);
		log.debug("Set status for the VNF external connection point");
	}
	
	public boolean isAllExtCpInStatus(String vnfInstanceId, VimResourceStatus status) {
		log.debug("Verifying if all the external connection points in VNF " + vnfInstanceId + " are in status " + status.toString());
		List<VnfExtCpInfo> cps = getAllVnfExtCpInfo(vnfInstanceId);
		for (VnfExtCpInfo cp : cps) {
			if (cp.getVimResourceStatus() != status) return false;
		}
		return true;
	}
	
	//****************************** METHODS RELATED TO VNFC info ********************************************************
	
	public VnfcResourceInfo getVnfcInfoFromResourceId(String vnfInstanceId, String resourceId) throws NotExistingEntityException {
		log.debug("Retrieving VNFC with resource ID " + resourceId + " for VNF " + vnfInstanceId);
		Optional<VnfcResourceInfo> vnfcInfoOpt = vnfcResourceInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndVnfcInstanceId(vnfInstanceId, resourceId);
		if (vnfcInfoOpt.isPresent()) {
			return vnfcInfoOpt.get();
		} else throw new NotExistingEntityException("VNFC with resource ID " + resourceId + " for VNF " + vnfInstanceId + " not found");
	}
	
	public List<VnfcResourceInfo> getVnfcInfoFromVduId(String vnfInstanceId, String vduId) throws NotExistingEntityException {
		log.debug("Retrieving VNFCs with VDU ID " + vduId + " for VNF " + vnfInstanceId);
		return vnfcResourceInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndVduId(vnfInstanceId, vduId);
	}
	
	public List<VnfcResourceInfo> getAllVnfcInfo(String vnfInstanceId) {
		log.debug("Retrieving all VNFCs for VNF " + vnfInstanceId);
		return vnfcResourceInfoRepository.findByIVnfInfoVnfInfoVnfInstanceId(vnfInstanceId);
	}
	
	public synchronized void addVnfcInfo(String vnfInstanceId, String vduId, String resourceId, String vimId, String providerId, String hostname) throws NotExistingEntityException {
		log.debug("Adding VNFC info");
		InstantiatedVnfInfo iVnfInfo = getInstantiatedVnfInfo(vnfInstanceId);
		VnfcResourceInfo vnfc = new VnfcResourceInfo(iVnfInfo, 
				resourceId, 
				vduId, 
				new ResourceHandle(vimId, providerId, resourceId), 
				null,		//storageResourceId
				null, 		//reservationId
				null);		//metadata
		vnfc.setHostname(hostname);
		vnfcResourceInfoRepository.saveAndFlush(vnfc);
		log.debug("VNFC added");
	}
	
	public synchronized void setStatusForVnfc(String vnfInstanceId, String vnfcInstanceId, VimResourceStatus status) throws NotExistingEntityException {
		log.debug("Setting status for VNFC " + vnfcInstanceId + " in VNF " + vnfInstanceId);
		VnfcResourceInfo vnfc = getVnfcInfoFromResourceId(vnfInstanceId, vnfcInstanceId);
		vnfc.setStatus(status);
		vnfcResourceInfoRepository.saveAndFlush(vnfc);
		log.debug("Set status for the VNFC");
	}
	
	public synchronized void setHostIdForVnfc(String vnfInstanceId, String vnfcInstanceId, String hostId) throws NotExistingEntityException {
		log.debug("Setting host ID for VNFC " + vnfcInstanceId + " in VNF " + vnfInstanceId);
		VnfcResourceInfo vnfc = getVnfcInfoFromResourceId(vnfInstanceId, vnfcInstanceId);
		vnfc.setHostId(hostId);;
		vnfcResourceInfoRepository.saveAndFlush(vnfc);
		log.debug("Set host ID for the VNFC");
	}
	
	public boolean isAllVnfcInStatus(String vnfInstanceId, VimResourceStatus status) {
		log.debug("Verifying if all the VNFCs in VNF " + vnfInstanceId + " are in status " + status.toString());
		List<VnfcResourceInfo> vnfcs = getAllVnfcInfo(vnfInstanceId);
		for (VnfcResourceInfo vnfc : vnfcs) {
			if (vnfc.getStatus() != status) return false;
		}
		return true;
	}
	
	//****************************** METHODS RELATED TO VNF info configurable parameters **********************************************
	
	public void setHostnameInVnfInfoConfigParameters(String vnfInstanceId, String vnfdId, String vduId, String hostname) throws NotExistingEntityException {
		log.debug("Adding hostname in VNF info configurable parameters");
		String parameterType = "vnf." + vnfdId + ".vdu." + vduId + ".hostname";
		addGenericConfigParameterToVnfInfo(vnfInstanceId, parameterType, hostname);
	}
	
	public synchronized void addGenericConfigParameterToVnfInfo(String vnfInstanceId, String parameterType, String parameterValue) throws NotExistingEntityException {
		log.debug("Adding configurable parameter " + parameterType + " with value " + parameterValue + " for VNF instance " + vnfInstanceId);
		VnfInfo vnfInfo = getVnfInfo(vnfInstanceId);
		vnfInfo.addConfigurableParameter(parameterType, parameterValue);
		vnfInfoRepository.saveAndFlush(vnfInfo);
		log.debug("Configurable parameter added");
	}
	
	//****************************** METHODS RELATED TO VNF virtual links info ********************************************************
	
	public VirtualLinkResourceInfo getVirtualLinkInfoFromResourceId(String vnfInstanceId, String resourceId) throws NotExistingEntityException {
		log.debug("Retrieving virtual link with resource ID " + resourceId + " for VNF " + vnfInstanceId);
		Optional<VirtualLinkResourceInfo> virtualLinkInfoOpt = virtualLinkResourceInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndVirtualLinkInstanceId(vnfInstanceId, resourceId);
		if (virtualLinkInfoOpt.isPresent()) {
			return virtualLinkInfoOpt.get();
		} else throw new NotExistingEntityException("Virtual link with resource ID " + resourceId + " for VNF " + vnfInstanceId + " not found");
	}
	
	public VirtualLinkResourceInfo getVirtualLinkInfoFromVldId(String vnfInstanceId, String vldId) throws NotExistingEntityException {
		log.debug("Retrieving virtual link with VLD ID " + vldId + " for VNF " + vnfInstanceId);
		Optional<VirtualLinkResourceInfo> virtualLinkInfoOpt = virtualLinkResourceInfoRepository.findByIVnfInfoVnfInfoVnfInstanceIdAndVirtualLinkDescId(vnfInstanceId, vldId);
		if (virtualLinkInfoOpt.isPresent()) {
			return virtualLinkInfoOpt.get();
		} else throw new NotExistingEntityException("Virtual link with VLD ID " + vldId + " for VNF " + vnfInstanceId + " not found");
	}
	
	public List<VirtualLinkResourceInfo> getAllVirtualLinkInfo(String vnfInstanceId) {
		log.debug("Retrieving all virtual links for VNF " + vnfInstanceId);
		return virtualLinkResourceInfoRepository.findByIVnfInfoVnfInfoVnfInstanceId(vnfInstanceId);
	}
	
	public synchronized void addVirtualLinkInfo(String vnfInstanceId, String vldId, String resourceId, String vimId, String providerId) throws NotExistingEntityException {
		log.debug("Adding virtual link info");
		InstantiatedVnfInfo iVnfInfo = getInstantiatedVnfInfo(vnfInstanceId);
		VirtualLinkResourceInfo vl = new VirtualLinkResourceInfo(iVnfInfo, 
				resourceId, 
				vldId, 
				new ResourceHandle(vimId, providerId, resourceId),
				null,	//reservationId
				null);	//metadata
		virtualLinkResourceInfoRepository.saveAndFlush(vl);
		log.debug("Virtual link added");
	}
	
	public synchronized void setStatusForVirtualLink(String vnfInstanceId, String vlInstanceId, VimResourceStatus status) throws NotExistingEntityException {
		log.debug("Setting status for Virtual Link " + vlInstanceId + " in VNF " + vnfInstanceId);
		VirtualLinkResourceInfo vl = getVirtualLinkInfoFromResourceId(vnfInstanceId, vlInstanceId);
		vl.setStatus(status);
		virtualLinkResourceInfoRepository.saveAndFlush(vl);
		log.debug("Set status for the Virtual Link");
	}
}
