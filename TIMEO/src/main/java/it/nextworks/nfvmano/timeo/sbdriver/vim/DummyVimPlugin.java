package it.nextworks.nfvmano.timeo.sbdriver.vim;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.enums.IpVersion;
import it.nextworks.nfvmano.libs.common.enums.NetworkResourceType;
import it.nextworks.nfvmano.libs.common.enums.NetworkSegmentType;
import it.nextworks.nfvmano.libs.common.enums.OperationalState;
import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualComputeResourceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourceQuotaManagementConsumerInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourcesCapacityManagementConsumerInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourcesInformationManagementConsumerInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCpu;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCpuPinning;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualMemory;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualNetworkInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnet;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetwork;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.ChangeNfpStateRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.ChangeNfpStateResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.CreateNfpRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.CreateNfpResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.DeleteNfpRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.DeleteNfpResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.QueryNfpResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.UpdateNfpRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp.UpdateNfpResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.CreateComputeResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.CreateComputeResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.CreateNetworkResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.CreateNetworkResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.CreateStorageResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.CreateStorageResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.QueryComputeResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.QueryNetworkResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.QueryStorageResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.TerminateResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.TerminateResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.UpdateComputeResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.UpdateComputeResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.UpdateNetworkResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.UpdateNetworkResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.UpdateStorageResourceQuotaRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.UpdateStorageResourceQuotaResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.CreateComputeFlavourRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.MigrateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.MigrateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.OperateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.OperateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.QueryComputeFlavourResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.QueryComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.QueryVirtualComputeResourceInfoResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.ScaleComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.ScaleComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.UpdateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.UpdateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.QueryNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.QueryVirtualNetworkResourceInfoResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.UpdateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.UpdateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.CreateResourceAffinityGroupRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.NfviPopInformationResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.QueryResourceCapacityRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.QueryResourceCapacityResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.QueryResourceZoneResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.SubscribeResourceCapacityNotificationsRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage.QueryVirtualStorageResourceInfoResponse;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.sbdriver.vim.emma.HostPowerStaticInfo;
import it.nextworks.nfvmano.timeo.sbdriver.vim.repositories.VimRepoWrapper;


/**
 * 
 * @author Elian Kraja: e.kraja@nextworks.it
 *
 */
public class DummyVimPlugin extends VimPlugin {

	private static final Logger log = LoggerFactory.getLogger(DummyVimPlugin.class);

	private int netIndex = 0;

	private int floatingIndex = 100;

	private VimRepoWrapper vimRepoWrapper;

	public DummyVimPlugin(Vim vim,
			VimRepoWrapper vimRepoWrapper) {
		super(VimType.DUMMY, vim);
		this.vimRepoWrapper = vimRepoWrapper;
	}

	@Override
	public AllocateNetworkResponse allocateVirtualisedNetworkResource(AllocateNetworkRequest request) 
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException { {

				AllocateNetworkResponse allocatedNetwork = null;
				switch (request.getNetworkResourceType()) {
				case NETWORK: {
					log.debug("Creating network named: " + request.getNetworkResourceName());
					List<String> subnets = new ArrayList<>();
					subnets.add("test_subnet");
					VirtualNetwork virtualNetwork = new VirtualNetwork(
							"test_network",													// networkResourceId
							request.getNetworkResourceName(),								// networkResourceName
							subnets,			 											// subnet
							new ArrayList<>(), 												// networkPort
							request.getTypeNetworkData().getBandwidth(),					// bandwidth
							request.getTypeNetworkData().getNetworkType(),					// netType
							request.getTypeNetworkData().getSegmentType(),					// segmentType
							request.getTypeNetworkData().getNetworkQoS(),					// networkQoS
							request.getTypeNetworkData().isShared(),						// isShared
							null, 															// sharingCriteria
							null, 															// zoneId
							OperationalState.ENABLED,			 							// OperationalState
							new HashMap<>()													// metadata
							);
					allocatedNetwork = new AllocateNetworkResponse(virtualNetwork, null, null);
					break;
				}
				case SUBNET:
					log.debug("Creating subnet named: " + request.getNetworkResourceName() );



					NetworkSubnet netSubnet = new NetworkSubnet(
							"test_subnet", 													// resourceId;
							request.getTypeSubnetData().getNetworkId(), 					// networkId;
							request.getTypeSubnetData().getIpVersion(),						// ipVersion
							"10.0." + (netIndex++) + ".1", 									// gatewayIp
							request.getTypeSubnetData().getCidr(),							// cidr
							request.getTypeSubnetData().isDhcpEnabled(),					// isDhcpEnabled
							new ArrayList<>(),												// address pool
							OperationalState.ENABLED, 										// operationalState;
							new HashMap<>() 												// metadata;
							);
					allocatedNetwork = new AllocateNetworkResponse(null, netSubnet, null);
					break;
				case PORT:
					log.debug("Creating port named: " + request.getNetworkResourceName());
					String floatingIp = null;
					if (request.getMetadata() != null) {
						floatingIp = request.getMetadata().get("FLOATING_IP");
					}
					log.debug("Trying to get network information");
					Map<String, String> metadata = new HashMap<>();
					if(floatingIp != null && floatingIp.equalsIgnoreCase("TRUE")){
						metadata.put("FLOATING_IP_ADDRESS", "138.132.105." + (floatingIndex++));
					}

					VirtualNetworkPort vNetPort = new VirtualNetworkPort(
							"test_port", 													// resourceId
							request.getTypeNetworkPortData().getNetworkId(), 				// networkId;
							"test_vm", 														// attachedResourceId;
							null, 															// portType;
							"147", 															// segmentId;
							0, 																// bandwidth;
							OperationalState.ENABLED, 										// operationalState;
							metadata 														// metadata;
							);
					allocatedNetwork = new AllocateNetworkResponse(null, null, vNetPort);
					break;
				default:
					log.error("NetworkResourceType unknown.");
					throw new FailedOperationException("NetworkResourceType unknown");
				}
				log.info("Leaving allocateVirtualisedNetworkResource with NetworkResourceType: "
						+ request.getNetworkResourceType().toString());
				return allocatedNetwork;
			}
	}

	@Override
	public QueryNetworkResponse queryVirtualisedNetworkResource(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		VimResourceType type = VimResourceType.NETWORK;
		String resourceID = null;
		QueryNetworkResponse queryResponse = null;

		if (request.getFilter().getParameters().get("RESOURCE_TYPE").equalsIgnoreCase("NETWORK"))
			type = VimResourceType.NETWORK;
		else if (request.getFilter().getParameters().get("RESOURCE_TYPE").equalsIgnoreCase("SUBNET"))
			type = VimResourceType.SUBNET;
		else if (request.getFilter().getParameters().get("RESOURCE_TYPE").equalsIgnoreCase("PORT"))
			type = VimResourceType.PORT;
		else {
			log.error("VimResourceType not allowed for this method");
			throw new FailedOperationException("VimResourceType not allowed for this method");
		}
		resourceID = request.getFilter().getParameters().get("RESOURCE_ID");
		if (resourceID == null) {
			log.error("ResourceID is null. No operation can be executed");
			throw new FailedOperationException("ResourceID is null. No operation can be executed");
		}
		switch (type) {
		case NETWORK:
			log.info("Query on network: " + resourceID);
			NetworkSegmentType netType = NetworkSegmentType.LOCAL;
			netType = NetworkSegmentType.VLAN;
			Map<String, String> metadata = new HashMap<>();
			Map<String, String> portMetadata = new HashMap<>();
			metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
			if(metadata.get("FLOATING_IP") != null && metadata.get("FLOATING_IP").equalsIgnoreCase("TRUE"))
				portMetadata.put("FLOATING_IP_ADDRESS", "138.132.105." + floatingIndex++);
			List<VirtualNetworkPort> virtualPorts = new ArrayList<>();
			VirtualNetworkPort port = new VirtualNetworkPort(
					"test_port",
					resourceID,
					"test_vm",
					"access",
					"147",
					0,
					OperationalState.ENABLED,
					portMetadata
					);
			virtualPorts.add(port);
			List<String> subnets = new ArrayList<>();
			subnets.add("test_subnet");
			VirtualNetwork virtualNetwork = new VirtualNetwork(
					resourceID, // networkResourceId
					"test_network", // networkResourceName
					subnets, // subnet
					virtualPorts, // VirtualNetworkPort networkPort
					0, // bandwidth
					netType, // netType
					"147", // segmentType
					new ArrayList<>(), // networkQoS
					false, // isShared
					null, // sharingCriteria
					null, // zoneId
					OperationalState.ENABLED, // OperationalState
					metadata // metadata
					);
			List<VirtualNetwork> networkList = new ArrayList<>();
			networkList.add(virtualNetwork);
			queryResponse = new QueryNetworkResponse(networkList, null, null);
			break;
		case SUBNET:
			log.info("Query on subnet: " + resourceID);
			List<NetworkSubnet> subnetList = new ArrayList<>();
			Map<String, String> subnetMetadata = new HashMap<>();
			subnetMetadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
			OperationalState state = OperationalState.ENABLED;
			IpVersion ipVersion = IpVersion.IPv4;
			NetworkSubnet subnetData = new NetworkSubnet(
					resourceID, // resourceId,
					"test_network", // networkId,
					ipVersion, // ipVersion,
					"10.0."+ (netIndex++) + ".1", // gatewayIp,
					null,		//CIDR
					true, // isDhcpEnabled,
					new ArrayList<>(),
					state, // operationalState,
					subnetMetadata); // metadata
			subnetList.add(subnetData);
			queryResponse = new QueryNetworkResponse(null, subnetList, null);
			break;
		case PORT:
			log.info("Query on port: " + resourceID);
			List<VirtualNetworkPort> portList = new ArrayList<>();
			Map<String, String> portData = new HashMap<>();
			String floatingIp = request.getFilter().getParameters().get("FLOATING_IP");
			if(floatingIp != null && floatingIp.equalsIgnoreCase("TRUE")){
				portData.put("FLOATING_IP_ADDRESS", "138.132.105." + (floatingIndex++));
			}
			portData.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
			VirtualNetworkPort virtualPortData = new VirtualNetworkPort(
					"test_port", // resourceId,
					"test_network", // networkId,
					"test_vm", // attachedResourceId,
					"access", // portType,
					"147", // segmentId,
					0, // bandwidth,
					OperationalState.ENABLED, // operationalState,
					portData // metadata
					);
			portList.add(virtualPortData);
			queryResponse = new QueryNetworkResponse(null, null, portList);
			break;
		default:
			log.error("VimResourceType not allowed in this method: " + type.toString());
			throw new FailedOperationException("VimResourceType not allowed in this method" + type.toString());
		}
		return queryResponse;
	}

	@Override
	public TerminateNetworkResponse terminateVirtualisedNetworkResource(TerminateNetworkRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		List<String> networkResourceId = new ArrayList<>();
		if (request != null) {
			Iterator<Map.Entry<String, NetworkResourceType>> iterator = request.getNetworkResourceId().entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, NetworkResourceType> map = (Map.Entry<String, NetworkResourceType>) iterator.next();
				switch (map.getValue()) {
				case NETWORK:
					log.debug("Terminated network: " + map.getKey());
					networkResourceId.add(map.getKey());
					break;
				case SUBNET:
					log.debug("Terminated subnet: " + map.getKey());
					networkResourceId.add(map.getKey());
					break;
				case PORT:
					log.debug("Terminated port: " + map.getKey());
					networkResourceId.add(map.getKey());
					break;
				default:
					break;
				}
			}
		}
		return new TerminateNetworkResponse(networkResourceId);
	}

	@Override
	public UpdateNetworkResponse updateVirtualisedNetworkResource(UpdateNetworkRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		throw new MethodNotImplementedException("Update network resource method not yet implemented");
	}

	@Override
	public String createVirtualisedNetworkResourceAffinityConstraintsGroup(CreateResourceAffinityGroupRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}

	@Override
	public String subscribeVirtualNetworkResourceChange(SubscribeRequest request, VirtualComputeResourceManagementConsumerInterface consumer) 
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		throw new MethodNotImplementedException();
		//TODO:
	}

	@Override
	public void unsubscribeVirtualNetworkResourceChange(String subscriptionId) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		throw new MethodNotImplementedException();
		//TODO:
	}

	@Override
	public String createComputeFlavour(CreateComputeFlavourRequest request) 
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		log.debug("Received request to create a new compute flavour");
		VirtualComputeFlavour vcf = request.getFlavour();
		if (vcf == null) {
			log.error("Received null virtual compute flavour. Error.");
			throw new MalformattedElementException("Received null virtual compute flavour. Error.");
		}
		try {
			String flavourId = vimRepoWrapper.storeVirtualComputeFlavour(vcf);
			log.debug("Virtual compute flavour created with ID " + flavourId);
			return flavourId;
		} catch (AlreadyExistingEntityException e) {
			throw new FailedOperationException("Virtual compute flavour already existing.");
		}
	}

	@Override
	public QueryComputeFlavourResponse queryComputeFlavour(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		log.debug("Received query for a virtual compute flavour");
		if (request.getFilter().getParameters().isEmpty()) {
			log.debug("Request for all the compute flavours");
			return new QueryComputeFlavourResponse(vimRepoWrapper.retrieveAllVirtualComputeFlavour());
		}
		String id = request.getFilter().getParameters().get("FLAVOUR_ID");
		log.debug("Received query for virtual compute flavour with ID " + id);
		if (id == null) {
			log.error("Received query compute flavour without flavour ID. Error.");
			throw new MalformattedElementException("Received query compute flavour without flavour ID. Error.");
		}
		List<VirtualComputeFlavour> vcfs = new ArrayList<>();
		VirtualComputeFlavour vcf = vimRepoWrapper.retrieveVirtualComputeFlavour(id);
		vcfs.add(vcf);
		return new QueryComputeFlavourResponse(vcfs);
	}

	@Override
	public void deleteComputeFlavour(String flavourId)
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		log.debug("Received request to delete a compute flavour");
		if (flavourId == null) throw new MalformattedElementException("Flavour ID is null");
		vimRepoWrapper.removeVirtualComputeFlavour(flavourId);
		log.debug("Compute flavour deleted.");
	}


	@Override
	public AllocateComputeResponse allocateVirtualisedComputeResource(AllocateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		AllocateComputeResponse response = null;

		List<VirtualNetworkInterface> netInterfaces = new ArrayList<>();

		List<VirtualStorage> virtualDisks = new ArrayList<>();

		VirtualCompute computeData = new VirtualCompute(
				"test_vm", 
				request.getComputeName(), 
				request.getComputeFlavourId(), 
				new ArrayList<>(), 
				new VirtualCpu("xxx", 2, 0, null, null), 
				new VirtualMemory(20, null, false), 
				netInterfaces, 
				virtualDisks, 
				"test_flavor", 
				null, 
				null, 
				OperationalState.ENABLED, 
				new HashMap<>());
		response = new AllocateComputeResponse(computeData);
		return response;
	}

	@Override
	public QueryComputeResponse queryVirtualisedComputeResource(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		QueryComputeResponse response = null;

		VirtualCpu vCpu = new VirtualCpu(
				null, 
				4, 
				0, 
				null, 
				new VirtualCpuPinning());
		VirtualMemory vRam = new VirtualMemory(
				4096, 
				null, 
				false);

		List<VirtualNetworkInterface> netInterfaces = new ArrayList<>();
		Map<String, String> metadata = new HashMap<>();
		if(request.getFilter().getParameters().get("FLOATING_IP") != null && request.getFilter().getParameters().get("FLOATING_IP").equalsIgnoreCase("TRUE"))
			metadata.put("FLOATING_IP_ADDRESS", "138.132.105." + floatingIndex++%256);
		List<String> ipAddresses = new ArrayList<>();
		ipAddresses.add("10.0." + netIndex + "." + (int)(Math.random()*100));
		VirtualNetworkInterface  vNet = new VirtualNetworkInterface(
				"test_vnic", 
				this.vim.getTenant(), 
				"test_network", 
				"test_vnic", 
				ipAddresses, 
				"access", 
				null, 
				"00:00:00:00:00:00", 
				0, 
				new ArrayList<>(), 
				OperationalState.ENABLED, 
				metadata);
		netInterfaces.add(vNet);
		List<VirtualStorage> virtualDisks = new ArrayList<>();
		VirtualStorage vStorage = new VirtualStorage(
				"test_image_id",
				"test_image_name", 
				null, 
				null, 
				40, 
				false, 
				this.vim.getTenant(), 
				null, 
				null, 
				OperationalState.ENABLED, 
				new HashMap<>());
		virtualDisks.add(vStorage);
		metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
		VirtualCompute computeData = new VirtualCompute(
				"test_vm", 
				"test_vm", 
				"test_flavor", 
				new ArrayList<>(), 
				vCpu, 
				vRam, 
				netInterfaces, 
				virtualDisks, 
				"test_flavor", 
				null, 
				null, 
				OperationalState.ENABLED, 
				metadata);
		List<VirtualCompute> computeList = new ArrayList<>();
		computeList.add(computeData);
		response = new QueryComputeResponse(computeList);
		return response;
	}

	@Override
	public UpdateComputeResponse updateVirtualisedComputeResource(UpdateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException{
		// TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public TerminateComputeResponse terminateVirtualisedComputeResource(TerminateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		List<String> computeIds = new ArrayList<>();
		TerminateComputeResponse response = new TerminateComputeResponse(computeIds);
		for (String computeId : request.getComputeId()){
			log.debug("Terminating Compute ID: " + computeId);
			computeIds.add(computeId);
		}
		return response;
	}

	@Override
	public OperateComputeResponse operateVirtualisedComputeResource(OperateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {

		OperateComputeResponse response = null;

		switch(request.getComputeOperation()){
		case CREATE_SNAPSHOT:
		case DELETE_SNAPSHOT:
			log.error("Method is not implemented for the requested operation");
			throw new MethodNotImplementedException();
		case PAUSE:
			log.debug("PAUSE operation executed in compute id: " + request.getComputeId());
			break; 
		case REBOOT:
			log.debug("REBOOT operation executed in compute id: " + request.getComputeId());
			break;
		case RESUME: 
			log.debug("RESUME operation executed in compute id: " + request.getComputeId());
			break;
		case START: 
			log.debug("START operation executed in compute id: " + request.getComputeId());
			break;
		case STOP: 
			log.debug("STOP operation executed in compute id: " + request.getComputeId());
			break;
		case SUSPEND:
			log.debug("SUSPEND operation executed in compute id: " + request.getComputeId());
			break;
		case UNPAUSE: 
			log.debug("UNPAUSE operation executed in compute id: " + request.getComputeId());
			break;
		}

		Map<String, String> computeOperationOutputData = new HashMap<>();
		VirtualCpu vCpu = new VirtualCpu(
				null, 
				4, 
				0, 
				null, 
				new VirtualCpuPinning());
		VirtualMemory vRam = new VirtualMemory(
				4096, 
				null, 
				false);
		List<VirtualNetworkInterface> netInterfaces = new ArrayList<>();
		Map<String, String> metadata = new HashMap<>();
		List<String> ipAddresses = new ArrayList<>();
		ipAddresses.add("10.0." + netIndex + "." + (int)(Math.random()*100));
		VirtualNetworkInterface  vNet = new VirtualNetworkInterface(
				"test_vnic", 
				this.vim.getTenant(), 
				"test_network", 
				"test_vnic", 
				ipAddresses, 
				"access", 
				null, 
				"00:00:00:00:00:00", 
				0, 
				new ArrayList<>(), 
				OperationalState.ENABLED, 
				metadata);
		netInterfaces.add(vNet);
		List<VirtualStorage> virtualDisks = new ArrayList<>();
		VirtualStorage vStorage = new VirtualStorage(
				"test_image_id",
				"test_image_name", 
				null, 
				null, 
				40, 
				false, 
				this.vim.getTenant(), 
				null, 
				null, 
				OperationalState.ENABLED, 
				new HashMap<>());
		virtualDisks.add(vStorage);
		VirtualCompute computeData = new VirtualCompute(
				"test_vm", 
				"test_vm", 
				"test_flavor", 
				new ArrayList<>(), 
				vCpu, 
				vRam, 
				netInterfaces, 
				virtualDisks, 
				"test_flavor", 
				null, 
				null, 
				OperationalState.ENABLED, 
				new HashMap<>());
		response = new OperateComputeResponse(computeData, computeOperationOutputData);
		return response;

	}

	@Override
	public ScaleComputeResponse scaleVirtualisedComputeResource(ScaleComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		// TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public MigrateComputeResponse migrateVirtualisedComputeResource(MigrateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		// TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public String createComputeResourceAffinityGroup(CreateResourceAffinityGroupRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		// TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public String subscribeVirtualComputeResourceChange(SubscribeRequest request, VirtualComputeResourceManagementConsumerInterface consumer) 
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public void unsubscribeVirtualComputeResourceChange(String subscriptionId) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public CreateComputeResourceQuotaResponse createComputeResourceQuota(CreateComputeResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryComputeResourceQuotaResponse queryComputeResourceQuota(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public UpdateComputeResourceQuotaResponse updateComputeResourceQuota(UpdateComputeResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public TerminateResourceQuotaResponse terminateComputeResourceQuota(TerminateResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public CreateNetworkResourceQuotaResponse createNetworkResourceQuota(CreateNetworkResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryNetworkResourceQuotaResponse queryNetworkResourceQuota(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public UpdateNetworkResourceQuotaResponse updateNetworkResourceQuota(UpdateNetworkResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public TerminateResourceQuotaResponse terminateNetworkResourceQuota(TerminateResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public CreateStorageResourceQuotaResponse createStorageResourceQuota(CreateStorageResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryStorageResourceQuotaResponse queryStorageResourceQuota(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public UpdateStorageResourceQuotaResponse updateStorageResourceQuota(UpdateStorageResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public TerminateResourceQuotaResponse terminateStorageResourceQuota(TerminateResourceQuotaRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public String subscribeVirtualResourceQuotaChange(SubscribeRequest request, VirtualisedResourceQuotaManagementConsumerInterface consumer)
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public void unsubscribeVirtualResourceQuotaChange(String subscriptionId) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException();
	}


	@Override
	public void setPowerState(Map<String, PowerState> powerStates) throws MethodNotImplementedException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public Map<String, PowerState> getPowerState(List<String> hostIds) throws MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public List<HostPowerStaticInfo> getPowerStateInfo() throws MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public List<HostPowerStaticInfo> getPowerStateInfo(List<String> hostIds) throws MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public String subscribeResourceInformationNotification(SubscribeRequest request, VirtualisedResourcesInformationManagementConsumerInterface consumer)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public void unsubscribeResourceInformationNotification(String subscriptionId) 
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryVirtualComputeResourceInfoResponse queryVirtualisedComputeResourceInformation(GeneralizedQueryRequest request)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryVirtualNetworkResourceInfoResponse queryVirtualisedNetworkResourceInformation(GeneralizedQueryRequest request)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryVirtualStorageResourceInfoResponse queryVirtualisedStorageResourceInformation(GeneralizedQueryRequest request)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryResourceCapacityResponse queryResourceCapacity(QueryResourceCapacityRequest request) 
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public String subscribeResourceCapacityNotification(SubscribeResourceCapacityNotificationsRequest request, VirtualisedResourcesCapacityManagementConsumerInterface consumer)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public void unsubscribeResourceCapacityNotification(String subscriptionId) 
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryResourceZoneResponse queryResourceZone(GeneralizedQueryRequest request)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public NfviPopInformationResponse queryNfviPopInformation(GeneralizedQueryRequest request)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public CreateNfpResponse createNfp(CreateNfpRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public QueryNfpResponse queryNfp(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public DeleteNfpResponse deleteNfp(DeleteNfpRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public ChangeNfpStateResponse changeNfpStatus(ChangeNfpStateRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public UpdateNfpResponse updateNfp (UpdateNfpRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		//TODO:
		throw new MethodNotImplementedException();
	}


}
