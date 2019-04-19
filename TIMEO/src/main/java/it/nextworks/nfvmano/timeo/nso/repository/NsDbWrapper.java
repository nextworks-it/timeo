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
package it.nextworks.nfvmano.timeo.nso.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.PnfdInfo;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.enums.AddressType;
import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.NsLinkPort;
import it.nextworks.nfvmano.libs.records.nsinfo.NsVirtualLinkInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfExtCpInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.SapInfo;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PhysicalEquipmentPort;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;


@Service
public class NsDbWrapper {
	
	private static final Logger log = LoggerFactory.getLogger(NsDbWrapper.class);

	@Autowired
	NsInfoRepository nsInfoRepository;
	
	@Autowired
	NsLinkPortRepository nsLinkPortRepository;
	
	@Autowired
	NsVirtualLinkInfoRepository nsVirtualLinkInfoRepository;
	
	@Autowired
	PnfInfoRepository pnfInfoRepository;
	
	@Autowired
	VnffgInfoRepository VnffgInfoRepository;
	
	@Autowired
	NfpRepository nfpRepository;
	
	@Autowired
	SapInfoRepository sapInfoRepository;
	
	@Autowired
	InternalOperationRepository internalOperationRepository;
	
	public NsDbWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	//****************************** METHODS RELATED TO INTERNAL OPERATIONS ********************************************************
	
	public synchronized void createNewInternalOperation(String operationId, String nsInstanceId, String description) throws AlreadyExistingEntityException {
		log.debug("Storing new internal operation in DB");
		if (internalOperationRepository.findByOperationId(operationId).isPresent()) {
			throw new AlreadyExistingEntityException("Operation ID " + operationId + " already present. Impossible to store a new operation.");
		}
		InternalOperation operation = new InternalOperation(operationId, nsInstanceId, description);
		internalOperationRepository.saveAndFlush(operation);
		log.debug("Internal operation stored in DB");
	}
	
	public synchronized void updateInternalOperation(String operationId, OperationStatus status, String failureMessage) throws NotExistingEntityException {
		log.debug("Updating status and failure message of internal operation in DB");
		InternalOperation operation = readInternalOperation(operationId);
		operation.setStatus(status);
		operation.setFailureMessage(failureMessage);
		internalOperationRepository.saveAndFlush(operation);
		log.debug("Status and failure message of internal operation updated in DB");
	}
	
	public InternalOperation readInternalOperation(String operationId) throws NotExistingEntityException {
		log.debug("Retrieving internal operation from DB");
		Optional<InternalOperation> operationOpt = internalOperationRepository.findByOperationId(operationId);
		if (operationOpt.isPresent()) {
			return operationOpt.get();
		} else {
			log.error("Internal operation not found");
			throw new NotExistingEntityException("Operation ID " + operationId + " not available in DB.");
		}
	}
	
	//************************************* Methods related to PNF INFOs ***************************************************
	
	public synchronized String createPnfInfo(String nsInstanceId, PnfdInfo pnfdInfo, PnfInstance pnfInstance, String pnfName, String pnfProfileId) throws NotExistingEntityException {
		log.debug("Creating a new PNF info associated to PNF instance " + pnfInstance.getPnfInstanceId() + " and included in NS " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		log.debug("Creating new entry in DB.");
		List<PnfExtCpInfo> cpInfo = new ArrayList<>();
		List<PhysicalEquipmentPort> peps = pnfInstance.getPorts();
		for (PhysicalEquipmentPort p : peps) {
			String ipAddress = p.getAddresses().get(AddressType.IP_ADDRESS);
			String cpdId = p.getPortId();
			cpInfo.add(new PnfExtCpInfo(cpdId, ipAddress));
		}
		PnfInfo pnfInfo = new PnfInfo(nsInfo, pnfInstance.getPnfInstanceId(), pnfName, pnfdInfo.getPnfdId(), pnfdInfo.getPnfdInfoId(), pnfProfileId, cpInfo);
		pnfInfoRepository.saveAndFlush(pnfInfo);
		String pnfInfoId = pnfInfo.getId().toString();
		log.debug("Created PNF info entry with ID " + pnfInfoId);
		return pnfInfoId;
	}
	
	public PnfInfo getPnfInfo(String pnfInfoId) throws NotExistingEntityException {
		log.debug("Retrieving PNF " + pnfInfoId + " from DB.");
		Long id = Long.parseLong(pnfInfoId);
		Optional<PnfInfo> pnfInfoOpt = pnfInfoRepository.findById(id);
		if (pnfInfoOpt.isPresent()) return pnfInfoOpt.get();
		else {
			log.error("PNF info " + pnfInfoId + " not found");
			throw new NotExistingEntityException("PNF info " + pnfInfoId + " not found");
		}
	}
	
	public List<PnfInfo> getAllPnfInfo() {
		log.debug("Retrieving all PNF infos");
		return pnfInfoRepository.findAll();
	}
	
	public synchronized void deletePnfInfo(String pnfInfoId) throws NotExistingEntityException {
		log.debug("Deleting PNF info " + pnfInfoId + " from DB");
		PnfInfo pnfInfo = getPnfInfo(pnfInfoId);
		pnfInfoRepository.delete(pnfInfo);
	}
	
	//*************************************  Methods related to NS INFOs ***************************************************
	
	public synchronized String createNsInfo(String nsdInstanceId, Nsd nsd, String nsName, String nsDescription, String tenantId) {
		log.debug("Creating new NS info entry in DB.");
		NsInfo nsInfo = new NsInfo(null, nsName, nsDescription, nsdInstanceId, null, null, null, InstantiationState.NOT_INSTANTIATED, 
				null, null, tenantId, null);
		nsInfoRepository.saveAndFlush(nsInfo);
		String nsInstanceId = nsInfo.getId().toString();
		log.debug("Created NS info entry with ID " + nsInstanceId);
		nsInfo.setNsInstanceId(nsInstanceId);
		nsInfoRepository.saveAndFlush(nsInfo);
		return nsInstanceId;
	}
	
	public List<NsInfo> getAllNsInfo() {
		log.debug("Retrieving all NS infos");
		return nsInfoRepository.findAll();
	}
	
	public NsInfo getNsInfo(String nsInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving NS Info " + nsInstanceId + " from DB");
		Optional<NsInfo> nsInfoOpt = nsInfoRepository.findByNsInstanceId(nsInstanceId);
		if (nsInfoOpt.isPresent()) {
			return nsInfoOpt.get();
		} else {
			log.error("NS Info " + nsInstanceId + " not found");
			throw new NotExistingEntityException("NS Info " + nsInstanceId + " not found");
		}
	}
	
	public synchronized void deleteNsInfo(String nsInstanceId) throws NotExistingEntityException {
		log.debug("Deleting NS Info " + nsInstanceId + " from DB");
		Optional<NsInfo> nsInfoOpt = nsInfoRepository.findByNsInstanceId(nsInstanceId);
		if (nsInfoOpt.isPresent()) {
			nsInfoRepository.delete(nsInfoOpt.get());
		} else {
			log.error("NS Info " + nsInstanceId + " not found");
			throw new NotExistingEntityException("NS Info " + nsInstanceId + " not found");
		}
	}
	
	public synchronized void setNsInfoDeploymentFlavour(String nsInstanceId, String dfId) throws NotExistingEntityException {
		log.debug("Setting deployment flavour " + dfId + " for NS instance " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		nsInfo.setFlavourId(dfId);
		nsInfoRepository.saveAndFlush(nsInfo);
		log.debug("Deployment flavour set for NS instance " + nsInstanceId);
	}
	
	public synchronized void setNsInfoConfigurationParameters(String nsInstanceId, Map<String, String> configurationParameters) throws NotExistingEntityException {
		log.debug("Setting configuration parameters for NS instance " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		nsInfo.setConfigurationParameters(configurationParameters);
		nsInfoRepository.saveAndFlush(nsInfo);
		log.debug("Configuration parameters from user set for NS instance " + nsInstanceId);
	}
	
	public synchronized void addVnfInfoInNsInfo(String nsInstanceId, String vnfInfoId, int index, String vnfdId) throws NotExistingEntityException {
		log.debug("Adding VNF info " + vnfInfoId + " with index " + index + " to NS instance " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		nsInfo.addVnfInfo(vnfInfoId, index, vnfdId);
		nsInfoRepository.saveAndFlush(nsInfo);
		log.debug("VNF info added in NS instance");
	}
	
	public synchronized void removeVnfInfoInNsInfo(String nsInstanceId, String vnfInfoId) throws NotExistingEntityException {
		log.debug("Removing VNF info " + vnfInfoId + " to NS instance " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		nsInfo.removeVnfInfo(vnfInfoId);
		nsInfoRepository.saveAndFlush(nsInfo);
		log.debug("VNF info removed from NS instance");
	}
	
	public synchronized void setNsInfoInstantiationState(String nsInstanceId, InstantiationState instantiationState) throws NotExistingEntityException {
		log.debug("Setting instantiation state for NS instance " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		nsInfo.setNsState(instantiationState);
		nsInfoRepository.saveAndFlush(nsInfo);
		log.debug("Instantiation state set");
	}
	
	public synchronized void setNsInfoMonitoringUrl(String nsInstanceId, String monitoringUrl) throws NotExistingEntityException {
		log.debug("Setting monitoring URL for NS instance " + nsInstanceId);
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		nsInfo.setMonitoringDashboardUrl(monitoringUrl);
		nsInfoRepository.saveAndFlush(nsInfo);
		log.debug("Monitoring URL set");
	}
	
	//*************************************  Methods related to NS Virtual Link INFOs ***************************************************
	
	public synchronized void createNsVirtualLinkInfo(String nsInstanceId, String nsVldId, ResourceHandle resourceHandle, int segmentId) 
			throws NotExistingEntityException, AlreadyExistingEntityException {
		log.debug("Creating new NS VL info entry in DB.");
		String resourceId = resourceHandle.getResourceId();
		if (nsVirtualLinkInfoRepository.findByResourceId(resourceId).isPresent()) 
			throw new AlreadyExistingEntityException("NS VL Instance with resource ID " + resourceId + " already existing in DB. Impossible to create a new one");
		if (nsVirtualLinkInfoRepository.findByNsInfoNsInstanceIdAndNsVirtualLinkDescId(nsInstanceId, nsVldId).isPresent())
			throw new AlreadyExistingEntityException("NS VL Instance with VLD ID " + nsVldId + " already existing in DB for NS " + nsInstanceId + ". Impossible to create a new one");
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		List<ResourceHandle> rhList = new ArrayList<>();
		rhList.add(resourceHandle);
		NsVirtualLinkInfo vlInfo = new NsVirtualLinkInfo(nsInfo, resourceId, nsVldId, resourceId, rhList, segmentId);
		nsVirtualLinkInfoRepository.saveAndFlush(vlInfo);
		log.debug("New NS VL info created in DB.");
	}
	
	public synchronized void setNsVirtualLinkInfoResourceStatus(String resourceId, VimResourceStatus status) throws NotExistingEntityException {
		log.debug("Setting status " + status.toString() + " for NS VL with resource ID " + resourceId);
		NsVirtualLinkInfo vl = getNsVirtualLinkInfo(resourceId);
		vl.setStatus(status);
		nsVirtualLinkInfoRepository.saveAndFlush(vl);
		log.debug("Set status " + status.toString() + " for NS VL with resource ID " + resourceId);
	}
	
	public NsVirtualLinkInfo getNsVirtualLinkInfo(String nsInstanceId, String nsVldId) throws NotExistingEntityException {
		log.debug("Searching NS VL info with VLD ID " + nsVldId + " for NS instance " + nsInstanceId);
		Optional<NsVirtualLinkInfo> infoOpt = nsVirtualLinkInfoRepository.findByNsInfoNsInstanceIdAndNsVirtualLinkDescId(nsInstanceId, nsVldId);
		if (infoOpt.isPresent()) {
			return infoOpt.get();
		} else {
			throw new NotExistingEntityException("NS VL info with VLD ID " + nsVldId + " not existing in DB for NS instance " + nsInstanceId);
		}
	}
	
	public NsVirtualLinkInfo getNsVirtualLinkInfo(String resourceId) throws NotExistingEntityException {
		log.debug("Searching NS VL info with resource ID " + resourceId);
		Optional<NsVirtualLinkInfo> infoOpt = nsVirtualLinkInfoRepository.findByResourceId(resourceId);
		if (infoOpt.isPresent()) {
			return infoOpt.get();
		} else {
			throw new NotExistingEntityException("NS VL info with resource ID " + resourceId + " not existing in DB");
		}
	}
	
	public List<NsVirtualLinkInfo> getNsVirtualLinkInfos(String nsInstanceId) throws NotExistingEntityException {
		List<NsVirtualLinkInfo> vls = nsVirtualLinkInfoRepository.findByNsInfoNsInstanceId(nsInstanceId);
		if ((vls == null) || (vls.isEmpty())) throw new NotExistingEntityException("NS virtual links for NS " + nsInstanceId + " not found in DB");
		return vls;
	}
	
	public synchronized void setNsVirtualLinkSubnet(String networkResourceId, String subnetId) throws NotExistingEntityException {
		log.debug("Setting subnet " + subnetId + " in NS VL with resource ID " + networkResourceId);
		NsVirtualLinkInfo vl = getNsVirtualLinkInfo(networkResourceId);
		vl.setSubnetId(subnetId);
		nsVirtualLinkInfoRepository.saveAndFlush(vl);
		log.debug("Subnet set.");
	}
	
	public synchronized void setNsVirtualLinkSubnetStatus(String resourceId, String subnetId, VimResourceStatus status) throws NotExistingEntityException {
		log.debug("Setting subnet " + subnetId + " in NS VL with resource ID " + resourceId);
		NsVirtualLinkInfo vl = getNsVirtualLinkInfo(resourceId);
		vl.setSubnetId(subnetId);
		vl.setSubnetStatus(status);
		nsVirtualLinkInfoRepository.saveAndFlush(vl);
		log.debug("Subnet set.");
	}
	
	public boolean isAllNsVirtualLinkInStatus(String nsInstanceId, VimResourceStatus status) {
		log.debug("Verifying if all the NS VLs associated to NS " + nsInstanceId + " are in status " + status.toString());
		List<NsVirtualLinkInfo> vls = nsVirtualLinkInfoRepository.findByNsInfoNsInstanceId(nsInstanceId);
		for (NsVirtualLinkInfo vl : vls) {
			if (vl.getStatus() != status) return false;
		}
		return true;
	}
	
	public boolean isAllNsVirtualLinkSubnetInStatus(String nsInstanceId, VimResourceStatus status) {
		log.debug("Verifying if all the subnets of the NS VLs associated to NS " + nsInstanceId + " are in status " + status.toString());
		List<NsVirtualLinkInfo> vls = nsVirtualLinkInfoRepository.findByNsInfoNsInstanceId(nsInstanceId);
		for (NsVirtualLinkInfo vl : vls) {
			if (vl.getSubnetStatus() != status) return false;
		}
		return true;
	}
	
	public synchronized void deleteNsVirtualLinkInfo(String nsInstanceId, String nsVldId) throws NotExistingEntityException {
		log.debug("Removing NS Virtual Link " + nsVldId + " in NS instance " + nsInstanceId + " from DB");
		NsVirtualLinkInfo vl = getNsVirtualLinkInfo(nsInstanceId, nsVldId); 
		nsVirtualLinkInfoRepository.delete(vl);
		log.debug("Removed NS Virtual Link " + nsVldId + " in NS instance " + nsInstanceId + " from DB");
	}
	
	//*************************************  Methods related to NS User Access Info *********************************************
	
	public synchronized void addUserAccessInfo(String nsInstanceId, String sapdId, String vnfdId, String vnfId, String vnfExtCpdId, String address) throws NotExistingEntityException {
		log.debug("Creating User Access Info for NS " + nsInstanceId + ". SAPD ID: " + sapdId + " - VNFD ID: " + vnfdId  + " - VNF ID: " + vnfId + " - VNF EXT CPD: " + vnfExtCpdId + " - IP: " + address);
		SapInfo sapInfo = getSapInfo(nsInstanceId, sapdId);
		sapInfo.addUserAccessInfo(sapdId, vnfdId, vnfId, vnfExtCpdId, address);
		sapInfoRepository.saveAndFlush(sapInfo);
		log.debug("User access info added in DB.");
	}
	
	private SapInfo getSapInfo(String nsInstanceId, String sapdId) throws NotExistingEntityException {
		Optional<SapInfo> sapInfoOpt = sapInfoRepository.findByNsInfoNsInstanceIdAndSapdId(nsInstanceId, sapdId);
		if (sapInfoOpt.isPresent()) return sapInfoOpt.get();
		else throw new NotExistingEntityException("SAP info for SAPD " + sapdId + " not available for NS instance " + nsInstanceId);
	}
	
	//*************************************  Methods related to NS Link Ports ***************************************************
	
	public synchronized void createNsLinkPort(String nsInstanceId, String nsVldId, String cpId, ResourceHandle resourceHandle, boolean isSap, String portName) 
			throws NotExistingEntityException, AlreadyExistingEntityException {
		log.debug("Creating NS link port for connection point " + cpId + " in virtual link " + nsVldId);
		if (nsLinkPortRepository.findByVlInfoNsInfoNsInstanceIdAndResourceHandleResourceId(nsInstanceId, resourceHandle.getResourceId()).isPresent()) {
			throw new AlreadyExistingEntityException("NS link port " + resourceHandle.getResourceId() + " already existing in DB");
		}
		NsVirtualLinkInfo vl = getNsVirtualLinkInfo(nsInstanceId, nsVldId);
		NsLinkPort port = new NsLinkPort(vl, resourceHandle, cpId, isSap);
		nsLinkPortRepository.saveAndFlush(port);
		log.debug("NS link port created.");
		NsInfo nsInfo = getNsInfo(nsInstanceId);
		SapInfo sapInfo = new SapInfo(nsInfo, resourceHandle.getResourceId(), cpId, portName, portName, null,  null);
		sapInfoRepository.saveAndFlush(sapInfo);
		log.debug("SAP Info added in DB");
	}
	
	public synchronized void removeNsLinkPort(String nsInstanceId, String resourceId) throws NotExistingEntityException {
		log.debug("Removing NS link port " + resourceId + " from NS instance " + nsInstanceId);
		NsLinkPort port = getNsLinkPort(nsInstanceId, resourceId);
		nsLinkPortRepository.delete(port);
		log.debug("NS link port removed.");
		
		Optional<SapInfo> sapInfo = sapInfoRepository.findBySapInstanceId(resourceId);
		if (sapInfo.isPresent()) {
			sapInfoRepository.delete(sapInfo.get());
			log.debug("SAP Info removed from DB");
		}
	}
	
	public NsLinkPort getNsLinkPort(String nsInstanceId, String resourceId) throws NotExistingEntityException {
		log.debug("Retrieving NS link port " + resourceId + " for NS instance " + nsInstanceId);
		Optional<NsLinkPort> nsLinkPortOpt = nsLinkPortRepository.findByVlInfoNsInfoNsInstanceIdAndResourceHandleResourceId(nsInstanceId, resourceId);
		if (nsLinkPortOpt.isPresent()) {
			return nsLinkPortOpt.get();
		} else throw new NotExistingEntityException("NS link port " + resourceId + " not existing in internal db");
	}
	
	public synchronized void setNsLinkPortStatus (String nsInstanceId, String resourceId, VimResourceStatus status) throws NotExistingEntityException {
		log.debug("Updating status for NS link port " + resourceId);
		NsLinkPort port = getNsLinkPort(nsInstanceId, resourceId);
		port.setStatus(status);
		nsLinkPortRepository.saveAndFlush(port);
		log.debug("Updated status for NS link port " + resourceId);
	}
	
	public boolean isAllNsLinkPortsInStatus(String nsInstanceId, VimResourceStatus status) {
		log.debug("Verifying if all the NS link ports in NS " + nsInstanceId + " are in status " + status.toString());
		List<NsLinkPort> ports = nsLinkPortRepository.findByVlInfoNsInfoNsInstanceId(nsInstanceId);
		for (NsLinkPort p : ports) {
			if (p.getStatus() != status) return false;
		}
		return true;
	}
	
	public List<NsLinkPort> getNsLinkPort(String nsInstanceId) {
		log.debug("Retrieving all the NS linlk ports in NS " + nsInstanceId);
		return nsLinkPortRepository.findByVlInfoNsInfoNsInstanceId(nsInstanceId);
	}
}
