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
package it.nextworks.nfvmano.timeo.ro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.QueryVnfResponse;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfExtCpInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.SapInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfExtCpInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfcResourceInfo;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualNetworkInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.QueryComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.QueryNetworkResponse;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathEndPoint;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.vnfm.Vnfm;

public class ResourceAllocationUtilities {

	private static final Logger log = LoggerFactory.getLogger(ResourceAllocationUtilities.class);

	//Key: VNF Instance ID; Value: VNFM
	private Map<String, Vnfm> vnfmMap = new HashMap<>();

	//Key: VNF Instance ID; Value: VNFD
	private Map<String, Vnfd> vnfdMap = new HashMap<>();
	
	private VimPlugin defaultVimPlugin;
	
	private Vnfm vnfm;
	
	
	//TODO: this is to be fixed - it could be related to NS? to be passed as parameter in VNF request?
	private static final String domainName = "vEPC.net";

	
	public ResourceAllocationUtilities(Map<String, Vnfm> vnfmMap, Map<String, Vnfd> vnfdMap, VimPlugin defaultVimPlugin, Vnfm vnfm) {	
		this.vnfmMap = vnfmMap;
		this.vnfdMap = vnfdMap;
		this.defaultVimPlugin = defaultVimPlugin;
		this.vnfm = vnfm;
		
	}
	
	public Map<String, String> buildConfigurationData(List<String> configurableProperties, Map<String, String> userConfigurationData, List<PnfInfo> pnfInfo) throws Exception {
		Map<String,String> configuration = new HashMap<String, String>();
		for (String configParam : configurableProperties) {
			//format example: 
			//vnf.<vnfd_id>.vdu.<vdu_id>.intcp.<extcp>.address
			//vnf.<vnfd_id>.vdu.<vdu_id>.hostname
			//vnf.<vnfd_id>.vdu.<vdu_id>.domainname
			//vnf.<vnfd_id>.vdu.<vdu_id>.extcp.<expcp>.floating
			//pnf.<pnfd_id>.cp.<cp_id>.address
			//uservnf.<vnfd_id>.vdu.<vdu_id>.domainname	--> this is used for parameters set by the user
			if (configParam.startsWith("uservnf")) {
				log.debug("The configuration parameter " + configParam + " shoud have been provided by the user in the instantiation request.");
				if (userConfigurationData.containsKey(configParam)) {
					configuration.put(configParam, userConfigurationData.get(configParam));
					log.debug("The configuration parameter " + configParam + " has been found: " + userConfigurationData.get(configParam));
				} else {
					log.error("The configuration parameter " + configParam + " has not been found in the parameters provided by the user. Skipping.");
				}
			} else if(configParam.startsWith("vnf")){
				String [] splits = configParam.split("\\.");
				if (splits.length == 5) {
					log.debug("Configuration parameter related to a VNF VDU.");
					String vnfdId = splits[1];
					String vduId = splits[3];
					if (splits[4].equals("hostname")) {
						try {
							configuration.put(configParam, readParameter(ConfigParameterType.HOSTNAME, vnfdId, vduId, null));
						} catch (Exception e) {
							log.error("Unable to get hostname. Skipping.");
						}
					} else if (splits[4].equals("domainname")) {
						try {
							configuration.put(configParam, readParameter(ConfigParameterType.DOMAINNAME, vnfdId, vduId, null));
						} catch (Exception e) {
							log.error("Unable to get domain name. Skipping.");
						}
					}
				} else if (splits.length == 7) {
					log.debug("Configuration parameter related to an element of a VNF VDU.");
					String vnfdId = splits[1];
					String vduId = splits[3];
					if ((splits[4].equals("intcp")) && (splits[6].equals("address"))) {
						try {
							configuration.put(configParam, readParameter(ConfigParameterType.INTERNAL_CP_IP_ADDRESS, vnfdId, vduId, splits[5]));
						} catch (Exception e) {
							log.error("Unable to get CP address. Skipping.");
						}
					} else if ((splits[4].equals("extcp")) && (splits[6].equals("floating"))) {
						try {
							configuration.put(configParam, readParameter(ConfigParameterType.FLOATING, vnfdId, vduId, splits[5]));
						} catch (Exception e) {
							log.error("Unable to get CP address. Skipping.");
						}
					} else {
						log.error("Unacceptable config parameter: " + splits[4]);
					}
				} else {
					log.error("Unacceptable config parameter format.");
					throw new Exception("Unacceptable config parameter format.");
				}
			}else if(configParam.startsWith("pnf")){
				String [] splits = configParam.split("\\.");
				if(splits.length==5 && splits[2].equals("cp")) {
					String pnfdId = splits[1];
					String cpId = splits[4];
					String pnfAddress = getPnfCpAddress(pnfdId, cpId, pnfInfo);
					configuration.put(configParam, pnfAddress);
				}else throw new Exception("Unacceptable config parameter format.");
			} else {
				log.error("Unacceptable config parameter format.");
				throw new Exception("Unacceptable config parameter format.");
			}
		}
		return configuration;
	}
	
	private String readParameter(ConfigParameterType parameterType, String vnfdId, String vduId, String cpdId) 
			throws FailedOperationException, NotExistingEntityException, Exception {
		switch (parameterType) {
		case HOSTNAME: {
			return getHostnameFromVnfConfigurableProperties(vnfdId, vduId);
		}
		
		case DOMAINNAME: {
			return domainName;
		}

		case INTERNAL_CP_IP_ADDRESS: {
			if ((vnfdId == null) || (cpdId == null)) throw new FailedOperationException("Missing parameters");
			log.debug("Reading internal cp address");
			String vnfInstanceId = getVnfInstanceIdFromVnfdId(vnfdId);
			String ipAddress = getIpAddressFromVnfcCp(vnfInstanceId, vduId, cpdId);
			return ipAddress;
		}

		case EXTERNAL_CP_IP_ADDRESS: {
			throw new FailedOperationException("External connection point parameter not yet supported");
		}
		
		case FLOATING: {
			if ((vnfdId == null) || (cpdId == null)) throw new FailedOperationException("Missing parameters");
			log.debug("Reading floating IP address associated to external CPD " + cpdId);
			String vnfInstanceId = getVnfInstanceIdFromVnfdId(vnfdId);
			String floatingIp = getFloatingForExternalCp(vnfInstanceId, cpdId);
			return floatingIp;
		}

		default: {
			log.error("Unsupported configuration parameter.");
			throw new FailedOperationException("Unsupported configuration parameter.");
		}
		}
	}
	
	public String getHostnameFromVnfConfigurableProperties(String vnfdId, String vduId) throws Exception {
		//The hostname is read from the VNF info configurable parameters. It is set during the initialization phase.
		String vnfInstanceId = getVnfInstanceIdFromVnfdId(vnfdId);
		QueryVnfResponse r = vnfm.queryVnf(new GeneralizedQueryRequest(Utilities.buildVnfInfoFilter(vnfInstanceId), new ArrayList<>()));
		Map<String, String> vnfConfigProperties = r.getVnfInfo().get(0).getVnfConfigurableProperty();
		String hostname = vnfConfigProperties.get("vnf." + vnfdId + ".vdu." + vduId + ".hostname");
		log.debug("Hostname for VNFD " + vnfdId + " and VDU " + vduId + ": " + hostname);
		return hostname;
	}
	
	public String getMacAddressFromNetworkPathEndPoint(NetworkPathEndPoint ep, NsInfo nsInfo) throws Exception {
		log.debug("Getting MAC address from network end point");
		switch (ep.getEndPointType()) {
		case VNFC_CP: {
			return getMacAddressFromVnfcCp(ep.getVnfdId(), ep.getVnfIndex(), ep.getVnfcId(), ep.getVnfcIndex(), ep.getCpdId(), nsInfo);
		}
			
		case NS_SAP: {
			return getMacAddressFromNsSap(ep.getCpdId(), nsInfo);
		}

		default: {
			log.error("Unmanaged network path end point");
			throw new NotExistingEntityException("MAC not found - Unmanaged network path end point");
		}
		}
	}
	
	public String getFloatingForExternalCp(String vnfInstanceId, String extCpdId) throws Exception {
		log.debug("Getting Floating IP associated to external connection point " + extCpdId + " in VNF " + vnfInstanceId);
		
		log.debug("Invoking VNFM to get info about VNF instance resources.");
		Vnfm vnfm = vnfmMap.get(vnfInstanceId);
		QueryVnfResponse vnfQueryResponse = vnfm.queryVnf(new GeneralizedQueryRequest(Utilities.buildVnfInfoFilter(vnfInstanceId), new ArrayList<>()));
		
		VnfExtCpInfo extCp = vnfQueryResponse.getVnfInfo().get(0).getInstantiatedVnfInfo().getExtCpFromCpdId(extCpdId);
		String portId = extCp.getCpInstanceId();
		log.debug("Port ID: " + portId);
		
		GeneralizedQueryRequest request = new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(VimResourceType.PORT, portId), null);
		QueryNetworkResponse networkResponse = defaultVimPlugin.queryVirtualisedNetworkResource(request);
		String floatingIp = Utilities.readFloatingIpAddressFromMetadata(networkResponse.getNetworkPortData().get(0).getMetadata());
		log.debug("Floating IP: " + floatingIp);
		
		return floatingIp;
	}
	
	private VirtualNetworkInterface getVnicForInternalCp(String vnfInstanceId, String vduId, String cpdId) throws Exception {
		log.debug("Getting VNIC associated to internal connection point " + cpdId + " in VNF " + vnfInstanceId);
		Vnfd vnfd = vnfdMap.get(vnfInstanceId);
		String vnfExtCpd = vnfd.getExternalConnectionPointAssociatedToInternalConnectionPoint(cpdId).getCpdId();
		log.debug("External connection point descriptor ID: " + vnfExtCpd);
		
		log.debug("Invoking VNFM to get info about VNF instance resources.");
		Vnfm vnfm = vnfmMap.get(vnfInstanceId);
		QueryVnfResponse vnfQueryResponse = vnfm.queryVnf(new GeneralizedQueryRequest(Utilities.buildVnfInfoFilter(vnfInstanceId), new ArrayList<>()));
		
		List<VnfcResourceInfo> vnfc =  vnfQueryResponse.getVnfInfo().get(0).getInstantiatedVnfInfo().getVnfcResourceInfoFromVduId(vduId);
		String vmId = vnfc.get(0).getVnfcInstanceId();
		log.debug("VM ID: " + vmId);
		VnfExtCpInfo extCp = vnfQueryResponse.getVnfInfo().get(0).getInstantiatedVnfInfo().getExtCpFromCpdId(vnfExtCpd);
		String portId = extCp.getCpInstanceId();
		log.debug("Port ID: " + portId);
		String vimId = vnfc.get(0).getComputeResource().getVimId();
		log.debug("VIM ID for source node: " + vimId);

		//Note! At the moment the default VIM plugin is used.
		log.debug("Invoking VIMs to get info about VNF instances cloud resources.");
		QueryComputeResponse computeResponse = defaultVimPlugin.queryVirtualisedComputeResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(VimResourceType.VM, vmId), null));
		VirtualCompute virtualCompute = computeResponse.getVirtualCompute().get(0);
		VirtualNetworkInterface vnic = virtualCompute.getVirtualNetworkInterface(portId);

		return vnic;
	}
	
	private String getIpAddressFromVnfcCp(String vnfInstanceId, String vduId, String cpdId) throws Exception {
		log.debug("Getting IP address from VNFC connection point. \n VNF instance ID: " + vnfInstanceId + " \n VDU ID: " + vduId + " \n CPD ID: " + cpdId);
		VirtualNetworkInterface vnic = getVnicForInternalCp(vnfInstanceId, vduId, cpdId);
		String ipAddress = vnic.getIpAddress().get(0);
		log.debug("IP address: " + ipAddress);
		return ipAddress;
	}
	
	private String getMacAddressFromVnfcCp(String vnfdId, int vnfIndex,	String vnfcId, int vnfcIndex, String cpdId, NsInfo nsInfo) throws Exception {
		log.debug("Getting MAC address from VNFC connection point. \n VNFD ID: " + vnfdId + " \n VNF Index: " + vnfIndex + " \n VNFC ID: " + vnfcId + " \n " + vnfcIndex + " \n CPD ID: " + cpdId);
		String vnfInstanceId = nsInfo.getVnfInfoIdFromVnfdIdAndVnfIndex(vnfdId, vnfIndex);
		log.debug("VNF instance: " + vnfInstanceId);
		VirtualNetworkInterface vnic = getVnicForInternalCp(vnfInstanceId, vnfcId, cpdId);
		String mac = vnic.getMacAddress();
		log.debug("MAC address: " + mac);
		return mac;
	}
	
	private String getMacAddressFromNsSap(String sapdId, NsInfo nsInfo) throws Exception {
		log.debug("Getting MAC address from VNFC connection point. \n SAPD ID: " + sapdId);
		
		SapInfo sapInfo = nsInfo.getSapInfoFromSapdId(sapdId);
		String sapInstanceId = sapInfo.getSapInstanceId();
		log.debug("Port ID for SAP instance: " + sapInstanceId);
		
		GeneralizedQueryRequest request = new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(VimResourceType.PORT, sapInstanceId), null);
		QueryNetworkResponse networkResponse = defaultVimPlugin.queryVirtualisedNetworkResource(request);
		String macAddress = Utilities.readMacAddressFromMetadata(networkResponse.getNetworkPortData().get(0).getMetadata());
		log.debug("MAC address: " + macAddress);
		
		return macAddress;
	}

	
	private String getVnfInstanceIdFromVnfdId(String vnfdId) throws NotExistingEntityException {
		//Note! Here we are assuming that a single VNF is created for the given VNFD - otherwise there is no way to discriminate the right one.
		for (Map.Entry<String, Vnfd> e : vnfdMap.entrySet()) {
			if (e.getValue().getVnfdId().equals(vnfdId)) {
				log.debug("VNF instance: " + e.getKey());
				return e.getKey();
			}
		}
		throw new NotExistingEntityException("VNF instance with VNFD ID " + vnfdId + " not found");
	}
	
	private String getPnfCpAddress(String pnfdId, String cpId, List<PnfInfo> pnfInfo) throws FailedOperationException {
		
		for(PnfInfo current : pnfInfo) {
			if(current.getPnfdId().equals(pnfdId)) {
				for(PnfExtCpInfo currentCp : current.getCpInfo()) {
					if (currentCp.getCpdId().equals(cpId)) {
						return currentCp.getAddress();
					}
				}
			}
			
		}
		throw new FailedOperationException();
	}

}
