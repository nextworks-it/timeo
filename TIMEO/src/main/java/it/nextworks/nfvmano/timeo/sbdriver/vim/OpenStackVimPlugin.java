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
package it.nextworks.nfvmano.timeo.sbdriver.vim;

import it.nextworks.nfvmano.libs.common.enums.AffinityType;
import it.nextworks.nfvmano.libs.common.enums.ComputeOperation;
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
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.AffinityConstraint;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualComputeQuota;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualStorageQuota;
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
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorageData;
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
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.Cidr;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.FloatingIp;
import it.nextworks.nfvmano.timeo.sbdriver.vim.emma.HostPowerStaticInfo;
import it.nextworks.nfvmano.timeo.sbdriver.vim.emma.PowerStateParameters;
import it.nextworks.nfvmano.timeo.sbdriver.vim.repositories.VimRepoWrapper;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.ComputeNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperRestClient;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VirtualMachineType;

import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.core.transport.Config;
import org.openstack4j.model.identity.v3.Token;
import org.openstack4j.model.image.Image;
import org.openstack4j.model.network.AttachInterfaceType;
import org.openstack4j.model.network.IP;
import org.openstack4j.model.network.IPVersionType;
import org.openstack4j.model.network.NetFloatingIP;
import org.openstack4j.model.network.Network;
import org.openstack4j.model.network.Port;
import org.openstack4j.model.network.Router;
import org.openstack4j.model.network.RouterInterface;
import org.openstack4j.model.network.State;
import org.openstack4j.model.network.Subnet;
import org.openstack4j.model.network.options.PortListOptions;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Action;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.FloatingIP;
import org.openstack4j.model.compute.QuotaSet;
import org.openstack4j.model.compute.RebootType;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.Server.Status;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.compute.builder.ServerCreateBuilder;
import org.openstack4j.model.compute.ext.AvailabilityZone;
import org.openstack4j.model.compute.ext.Hypervisor;
import org.openstack4j.model.compute.ext.AvailabilityZone.NovaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 
 * @author Elian Kraja: e.kraja@nextworks.it
 *
 */
public class OpenStackVimPlugin extends VimPlugin {

	private static final Logger log = LoggerFactory.getLogger(OpenStackVimPlugin.class);

	private Token token;

	private int openstackTimeout = 5000;
	
	private VimRepoWrapper vimRepoWrapper;

	/** CIDR repository for the given VIM */
	//private CidrRepository cidrRepository;

	//private FloatingIpRepository floatingRepository;

	public OpenStackVimPlugin(Vim vim,
			VimRepoWrapper vimRepoWrapper) {
		super(VimType.OPENSTACK, vim);
		this.vimRepoWrapper = vimRepoWrapper;
//		this.cidrRepository = cidrRepository;
//		this.floatingRepository = floatingRepository;
//		if (cidrRepository == null)
//			log.error("CIDRRepository is NULL");
//		if (floatingRepository == null)
//			log.error("FloatingRepository is NULL");
		defineCIDRs();
	}
	
	

	@Override
	public AllocateNetworkResponse allocateVirtualisedNetworkResource(AllocateNetworkRequest request) 
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		log.info("Entering allocateVirtualisedNetworkResource with NetworkResourceType: "
				+ request.getNetworkResourceType().toString());

		/** Client Object */
		OSClientV3 os = null;
		/** Response object. NULL IF errors occurred */
		AllocateNetworkResponse allocatedNetwork = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			log.debug("Authenticating using generated token");
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		Map<String, String> metadata = new HashMap<>();
		switch (request.getNetworkResourceType()) {
		case NETWORK: {
			log.debug("Creating network named: " + request.getNetworkResourceName());
			Network network = null;
			try {
				// IF PHYSNET IS DEFINED, USE IT
				if(this.vim.getPhysnet() != null && this.vim.getPhysnet() != ""){
					network = os.networking().network()
							.create(Builders.network().name(request.getNetworkResourceName()).adminStateUp(true).physicalNetwork(this.vim.getPhysnet()).networkType(this.vim.getNetType()).build());
				} else {
				// IF PHYSNET IS NOT DEFINED, USE THE DEFAULT ONE
					network = os.networking().network()
							.create(Builders.network().name(request.getNetworkResourceName()).adminStateUp(true).build());					
				}
			} catch (Exception e) {
				log.error("An error occurred during network creation: " + e.getMessage());
				throw new FailedOperationException("An error occurred during network creation" + e.getMessage());
			}
			NetworkSegmentType type = NetworkSegmentType.LOCAL;
			switch (network.getNetworkType()) {
			case LOCAL:
				type = NetworkSegmentType.LOCAL;
				break;
			case GRE:
				type = NetworkSegmentType.GRE;
				break;
			case VLAN:
				type = NetworkSegmentType.VLAN;
				break;
			case VXLAN:
				type = NetworkSegmentType.VXLAN;
				break;
			case FLAT:
				type = NetworkSegmentType.L3_VPN;
				break;
			}
			VirtualNetwork virtualNetwork = new VirtualNetwork(network.getId(), // networkResourceId
					network.getName(), // networkResourceName
					network.getSubnets(), // subnet
					new ArrayList<>(), // networkPort
					0, // bandwidth
					type, // netType
					network.getProviderSegID(), // segmentType
					new ArrayList<>(), // networkQoS
					network.isShared(), // isShared
					null, // sharingCriteria
					null, // zoneId
					(network.getStatus().toString().equals("ACTIVE") ? OperationalState.ENABLED
							: OperationalState.DISABLED), // OperationalState
					metadata // metadata
			);
			allocatedNetwork = new AllocateNetworkResponse(virtualNetwork, null, null);
			break;
		}
		case SUBNET:
			log.debug("Creating subnet named: " + request.getNetworkResourceName() + " on network: "
					+ request.getTypeSubnetData().getNetworkId());

			Network net = null;
			try {
				log.debug("Trying to get network information");
				net = os.networking().network().get(request.getTypeSubnetData().getNetworkId());
			} catch (Exception e) {
				log.error("An error occurred when gathering network information: " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred when gathering network information: " + e.getMessage());
			}
			if (net == null) {
				log.error("Network " + request.getTypeSubnetData().getNetworkId() + " does not exists");
				throw new FailedOperationException(
						"Network " + request.getTypeSubnetData().getNetworkId() + " does not exists");
			}
			log.debug("Trying to get subnet information");
			List<? extends String> subnetList = net.getSubnets();
			for (String sub : subnetList) {
				if (sub.equalsIgnoreCase(request.getNetworkResourceName())) {
					log.error("Subnet already created in network " + net.getId());
					throw new FailedOperationException("Subnet already created in network " + net.getId());
				}
			}
			Subnet subnet = null;
			IPVersionType ipVersion = (request.getTypeSubnetData().getIpVersion() == IpVersion.IPv6) ? IPVersionType.V6
					: IPVersionType.V4;
			try {
				List<Cidr> cidrList = vimRepoWrapper.retrieveCidr(this.vim.getVimId());
				if (cidrList.size() == 0) {
					log.error("No more subnets are available for this VIM");
					throw new FailedOperationException("No more subnets are available for this VIM");
				}
				Cidr cidr = cidrList.get(0);
				try {
					subnet = os.networking().subnet()
							.create(Builders.subnet().name(request.getNetworkResourceName())
									.networkId(request.getTypeSubnetData().getNetworkId())
									.enableDHCP(request.getTypeSubnetData().isDhcpEnabled()).cidr(cidr.getCidr())
									.ipVersion(ipVersion).build());
					log.debug("Subnet created: " + subnet.getId());
					cidr.setFree(false);
					vimRepoWrapper.storeCidr(cidr);
				} catch (Exception e) {
					log.error("An error occurred during subnet creation: " + e.getMessage());
					cidr.setFree(true);
					vimRepoWrapper.storeCidr(cidr);
					throw new FailedOperationException("An error occurred during subnet creation: " + e.getMessage());
				}
				IpVersion ipVer = (subnet.getIpVersion() == IPVersionType.V4 ? IpVersion.IPv4 : IpVersion.IPv6);
				NetworkSubnet netSubnet = new NetworkSubnet(subnet.getId(), // resourceId;
						subnet.getNetworkId(), // networkId;
						ipVer, // ipVersion
						subnet.getGateway(), // gatewayIp
						cidr.getCidr(),		// cidr
						subnet.isDHCPEnabled(), // isDhcpEnabled
						new ArrayList<>(),	//addressPool
						OperationalState.ENABLED, 							// operationalState;
						metadata // metadata;
				);
				allocatedNetwork = new AllocateNetworkResponse(null, netSubnet, null);
			} catch (NotExistingEntityException e) {
				log.error("An error occurred when gathering cidr list from database: " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred when gathering cidr list from database: " + e.getMessage());
			} 
			break;
			
		case PORT:
			log.debug("Creating port named: " + request.getNetworkResourceName() + " on network: "
					+ request.getTypeNetworkPortData().getNetworkId());
			String routerID = null;

			if (request.getMetadata() != null) {
				routerID = request.getMetadata().get("ROUTER_ID");
				if (routerID != null) {
					// Check if router exists
					try {
						os.networking().router().get(routerID);
					} catch (Exception e) {
						log.error("An error occurred trying to identify the router: " + e.getMessage());
						throw new FailedOperationException(
								"An error occurred trying to identify the router: " + e.getMessage());
					}
				}
			}
			log.debug("Trying to get network information");
			Network network = null;
			try {
				log.debug("Gathering information on network: " + request.getTypeNetworkPortData().getNetworkId());
				network = os.networking().network().get(request.getTypeNetworkPortData().getNetworkId());
			} catch (Exception e) {
				log.error("An error occurred gathering network information: " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred gathering network information: " + e.getMessage());
			}
			if (network == null) {
				log.error("Network " + request.getTypeNetworkPortData().getNetworkId() + " does not exists");
				throw new FailedOperationException(
						"Network " + request.getTypeNetworkPortData().getNetworkId() + " does not exists");
			}
			log.debug("Trying to get subnet information");
			List<? extends Subnet> subnets = network.getNeutronSubnets();
			if (subnets == null || subnets.isEmpty()) {
				log.error("Network " + request.getTypeNetworkPortData().getNetworkId()
						+ " has no subnets. Port cannot be created");
				throw new FailedOperationException("Network " + request.getTypeNetworkPortData().getNetworkId()
						+ " has no subnets. Port cannot be created");
			}
			Port port = null;
			/*
			 * If the port requested has to be attached to a router, attach will be done by using the subnet of the given network to have the correct ip address as default gateway.
			 * Forcing Fixed IP is possible in Openstack, but network administrators only can.
			 */
			if (routerID != null){
				//LOCATE SUBNET FROM NETWORK DATA
				Network foundNetwork = os.networking().network().get(request.getTypeNetworkPortData().getNetworkId());
				String foundSubnet = "";
				List<String> listaSubet = foundNetwork.getSubnets();
				for(String sub : listaSubet){
					foundSubnet = sub;
					break;
				}
				try{
					log.debug("Attaching port  to router " + routerID);
					RouterInterface routerIf = os.networking().router().attachInterface(routerID, AttachInterfaceType.SUBNET, foundSubnet);
					port = os.networking().port().get(routerIf.getPortId());
				} catch(Exception e){
					log.error("An error occurred during attach of port on router " + routerID + ": " + e.getMessage());
					throw new FailedOperationException("An error occurred during attach of port on router " + routerID + ": " + e.getMessage());
				}
				
			} else {
				try {
					port = os.networking().port().create(Builders.port().name(request.getNetworkResourceName())
							.networkId(request.getTypeNetworkPortData().getNetworkId()).build());
					log.debug("Created port " + port.getId() + " on network " + request.getTypeNetworkPortData().getNetworkId());
				} catch (Exception e) {
					log.error("An error occurred during port creation: " + e.getMessage());
					throw new FailedOperationException("An error occurred during port creation: " + e.getMessage());
				}
			}
			metadata = new HashMap<>();
			for (IP ip : port.getFixedIps()){
				metadata.put("IP_ADDRESS", ip.getIpAddress());
				break;
			}
			metadata.put("MAC_ADDRESS", port.getMacAddress());
			String floatingIP = request.getMetadata().get("FLOATING_IP");
			if (floatingIP != null && floatingIP.equalsIgnoreCase("TRUE")) {
				log.debug("Port must be associated to a floating IP");
				Router router = null;
				try {
					router = os.networking().router().get(this.vim.getDefaultExternalRouterId());
					log.debug("Router found: " + router.getId());
				} catch (Exception e) {
					log.error("An error occurred retrieving router information: " + e.getMessage());
					os.networking().port().delete(port.getId());
					throw new FailedOperationException(
							"An error occurred retrieving router information: " + e.getMessage());
				}
				Network externalNetwork = null;
				try {
					externalNetwork = os.networking().network().get(this.vim.getDefaultExternalNetworkId());
					log.debug("External network found: " + externalNetwork.getName());
				} catch (Exception e) {
					log.error("An error occurred retrieving external network information: " + e.getMessage());
					// Cancelling created port
					os.networking().port().delete(port.getId());
					throw new FailedOperationException(
							"An error occurred retrieving external network information: " + e.getMessage());
				}
				if (router != null && externalNetwork != null) {
					log.debug("Router: " + router.getName() + " - External Network: " + externalNetwork.getName() );
					List<String> pools = null;
					FloatingIP floating = null;
					try {
						pools = os.compute().floatingIps().getPoolNames();
						log.debug("Finding pool names for floating ips");
					} catch (Exception e) {
						log.error("An error occurred locating pool name: " + e.getMessage());
						os.networking().port().delete(port.getId());
						throw new FailedOperationException("An error occurred locating pool name: " + e.getMessage());
					}
					try {
						for (String pool : pools) {
							log.debug("Analyzing pool: " + pool);
							floating = os.compute().floatingIps().allocateIP(pool);
							if (floating != null) {
								log.debug("Floating IP created: " + floating.getFloatingIpAddress());
								break;
							}
						}
					} catch (Exception e) {
						log.error("An error occurred creating Floating IP: " + e.getMessage());
						os.networking().port().delete(port.getId());
						throw new FailedOperationException("An error occurred creating Floating IP: " + e.getMessage());
					}
					if (floating != null) {
						try {
							NetFloatingIP netFloating = os.networking().floatingip().get(floating.getId());
							log.debug("FloatingFromCompute: " + floating.getId() + " - FloatingFromNetwork: " + netFloating.getId());
							os.networking().floatingip().associateToPort(netFloating.getId(), port.getId());
						} catch (Exception e) {
							log.error("An error occurred during association of floating IP " + floating.getId()
									+ " with port " + port.getId() + ": " + e.getMessage());
							os.networking().floatingip().delete(floating.getId());
							os.networking().port().delete(port.getId());
							throw new FailedOperationException("An error occurred during association of floating IP "
									+ floating.getId() + " with port " + port.getId() + ": " + e.getMessage());
						}
						try {
							vimRepoWrapper.storeFloatingIp(this.vim.getVimId(), port.getId(), floating.getId());
							metadata.put("FLOATING_IP_ADDRESS", floating.getFloatingIpAddress());
						} catch (Exception e) {
							log.error("An error occurred saving floating data in DB: " + e.getMessage());
							os.networking().floatingip().delete(floating.getId());
							os.networking().port().delete(port.getId());
							throw new FailedOperationException(
									"An error occurred saving floating data in DB: " + e.getMessage());
						}
					}

				}

			}

			VirtualNetworkPort vNetPort = new VirtualNetworkPort(port.getId(), // resourceId
					port.getNetworkId(), // networkId;
					port.getDeviceId(), // attachedResourceId;
					null, // portType;
					network.getProviderSegID(), // segmentId;
					0, // bandwidth;
					(port.getState() == State.ACTIVE) ? OperationalState.ENABLED : OperationalState.DISABLED, // operationalState;
					metadata // metadata;
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

	@Override
	public QueryNetworkResponse queryVirtualisedNetworkResource(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		VimResourceType type = VimResourceType.NETWORK;
		String resourceID = null;
		QueryNetworkResponse queryResponse = null;
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		if (request.getFilter().getParameters().get("RESOURCE_TYPE").equalsIgnoreCase("NETWORK"))
			type = VimResourceType.NETWORK;
		else if (request.getFilter().getParameters().get("RESOURCE_TYPE").equalsIgnoreCase("SUBNET"))
			type = VimResourceType.SUBNET;
		else if (request.getFilter().getParameters().get("RESOURCE_TYPE").equalsIgnoreCase("PORT"))
			type = VimResourceType.PORT;
		else {
			log.error("VimResourceType not allowed for this method");
			throw new FailedOperationException("VitResourceType not allowed for this method");
		}
		resourceID = request.getFilter().getParameters().get("RESOURCE_ID");
		if (resourceID == null) {
			log.error("ResourceID is null. No operation can be executed");
			throw new FailedOperationException("ResourceID is null. No operation can be executed");
		}
		switch (type) {
		case NETWORK:
			log.info("Query on network: " + resourceID);
			Network network = null;
			try {
				network = os.networking().network().get(resourceID);
			} catch (Exception e) {
				log.error("An error occurred gathering network information");
				throw new FailedOperationException("An error occurred gathering network information");
			}
			if (network != null) {
				NetworkSegmentType netType = NetworkSegmentType.LOCAL;
				switch (network.getNetworkType()) {
				case LOCAL:
					netType = NetworkSegmentType.LOCAL;
					break;
				case GRE:
					netType = NetworkSegmentType.GRE;
					break;
				case VLAN:
					netType = NetworkSegmentType.VLAN;
					break;
				case VXLAN:
					netType = NetworkSegmentType.VXLAN;
					break;
				case FLAT:
					netType = NetworkSegmentType.L3_VPN;
					break;
				}
				Map<String, String> metadata = new HashMap<>();

				switch (network.getStatus()) {
				case ACTIVE:
				case DOWN:
				case PENDING_UPDATE:
					metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
					break;
				case BUILD:
				case PENDING_CREATE:
					metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATING.toString());
					break;
				case ERROR:
				case UNRECOGNIZED:
					metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.FAILED.toString());
					break;
				case PENDING_DELETE:
					metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.TERMINATING.toString());
					break;
				}

				List<VirtualNetworkPort> virtualPorts = listPortsFromNetwork(network.getId());
				VirtualNetwork virtualNetwork = new VirtualNetwork(network.getId(), // networkResourceId
						network.getName(), // networkResourceName
						network.getSubnets(), // subnet
						virtualPorts, // VirtualNetworkPort networkPort
						0, // bandwidth
						netType, // netType
						network.getProviderSegID(), // segmentType
						new ArrayList<>(), // networkQoS
						network.isShared(), // isShared
						null, // sharingCriteria
						null, // zoneId
						(network.getStatus().toString().equals("ACTIVE") ? OperationalState.ENABLED
								: OperationalState.DISABLED), // OperationalState
						metadata // metadata
				);
				List<VirtualNetwork> networkList = new ArrayList<>();
				networkList.add(virtualNetwork);
				queryResponse = new QueryNetworkResponse(networkList, null, null);
			} else {
				log.error("Network with id " + resourceID + " doesn't exist");
				throw new NotExistingEntityException("Network with id " + resourceID + " doesn't exist");
			}
			break;
		case SUBNET:
			log.info("Query on subnet: " + resourceID);
			Subnet subnet = null;
			List<NetworkSubnet> subnetList = new ArrayList<>();
			try {
				subnet = os.networking().subnet().get(resourceID);
				if (subnet != null) {
					Map<String, String> metadata = new HashMap<>();
					metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
					OperationalState state = OperationalState.ENABLED;
					IpVersion ipVersion = (subnet.getIpVersion() == IPVersionType.V6) ? IpVersion.IPv6 : IpVersion.IPv4;
					NetworkSubnet subnetData = new NetworkSubnet(subnet.getId(), // resourceId,
							subnet.getNetworkId(), // networkId,
							ipVersion, // ipVersion,
							subnet.getGateway(), // gatewayIp,
							subnet.getCidr(),	// cidr
							subnet.isDHCPEnabled(), // isDhcpEnabled,
							new ArrayList<String>(), // addressPool
							state, // operationalState,
							metadata); // metadata
					subnetList.add(subnetData);
				} else {
					log.error("No subnet is present with ID: " + resourceID);
					throw new FailedOperationException("No subnet is present with ID: " + resourceID);
				}
			} catch (Exception e) {
				log.error("An error occurred when gathering subnet information: " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred when gathering subnet information: " + e.getMessage());
			}
			queryResponse = new QueryNetworkResponse(null, subnetList, null);
			break;
		case PORT:
			log.info("Query on port: " + resourceID);
			Port port = null;
			List<VirtualNetworkPort> portList = new ArrayList<>();
			try {
				port = os.networking().port().get(resourceID);
				if (port != null) {
					Map<String, String> metadata = new HashMap<>();
					for (IP ip : port.getFixedIps()){
						metadata.put("IP_ADDRESS", ip.getIpAddress());
						break;
					}
					metadata.put("MAC_ADDRESS", port.getMacAddress());
					try {
						FloatingIp floatingIp = vimRepoWrapper.retrieveFloatingIpByPortId(port.getId());
						if (floatingIp != null) {
							NetFloatingIP floating = null;
							try {
								floating = os.networking().floatingip().get(floatingIp.getFloatingId());
							} catch (Exception e) {
								log.error("An error occurred gathering floating ip data on VIM: " + e.getMessage());
								throw new FailedOperationException(
										"An error occurred gathering floating ip data on VIM: " + e.getMessage());
							}
							if (floating != null) {
								metadata.put("FLOATING_IP_ADDRESS", floating.getFloatingIpAddress());
							}
						}
					} catch (Exception e) {
						log.error("An error occurred gathering information on DB: " + e.getMessage());
						throw new FailedOperationException(
								"An error occurred gathering information on DB: " + e.getMessage());
					}
					switch (port.getState()) {
					case ACTIVE:
					case DOWN:
					case PENDING_UPDATE:
						metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
						break;
					case BUILD:
					case PENDING_CREATE:
						metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATING.toString());
						break;
					case ERROR:
					case UNRECOGNIZED:
						metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.FAILED.toString());
						break;
					case PENDING_DELETE:
						metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.TERMINATING.toString());
						break;
					}
					OperationalState state = (port.getState() == State.ACTIVE) ? OperationalState.ENABLED
							: OperationalState.DISABLED;
					VirtualNetworkPort virtualPortData = new VirtualNetworkPort(port.getId(), // resourceId,
							port.getNetworkId(), // networkId,
							port.getDeviceId(), // attachedResourceId,
							null, // portType,
							os.networking().network().get(port.getNetworkId()).getProviderSegID(), // segmentId 
							0, // bandwidth,
							state, // operationalState,
							metadata // metadata
					);
					portList.add(virtualPortData);
				} else {
					log.error("No port is present with ID: " + resourceID);
				}
			} catch (Exception e) {
				log.error("An error occurred when gathering port information: " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred when gathering port information: " + e.getMessage());
			}
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
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		if (request != null) {
			Iterator<Map.Entry<String, NetworkResourceType>> iterator = request.getNetworkResourceId().entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, NetworkResourceType> map = (Map.Entry<String, NetworkResourceType>) iterator.next();
				switch (map.getValue()) {
				case NETWORK:
					try {
						ActionResponse response = os.networking().network().delete(map.getKey());
						if(response.getCode() == 200){
							log.debug("Network removed successfully: " + map.getKey());
						} else {
							log.error("Network remove failed with error: "+ response.getFault() +". Id: " + map.getKey());
						}
						networkResourceId.add(map.getKey());
					} catch (Exception e) {
						log.error("An error occurred during network termination: " + e.getMessage());
					}
					break;
				case SUBNET:
					try {
						Subnet subnet = os.networking().subnet().get(map.getKey());
						ActionResponse response = os.networking().subnet().delete(map.getKey());
						if(response.getCode() == 200){
							log.debug("Subnet removed successfully: " + map.getKey());
						} else {
							log.error("Subnet remove failed with error: "+ response.getFault() +". Id: " + map.getKey());
						}
						networkResourceId.add(map.getKey());
						vimRepoWrapper.setCidrFree(this.vim.getVimId(), subnet.getCidr());
					} catch (Exception e) {
						log.error("An error occurred during subnet termination: " + e.getMessage());
					}
					break;
				case PORT:
					try {
						FloatingIp floatingIp = vimRepoWrapper.retrieveFloatingIpByPortId(map.getKey());
						ActionResponse response = null;
						if (floatingIp != null) {
							try {
								// DISASSIOCATE
								// TODO TO better understand if parameter is
								// port id or floating id
								os.networking().floatingip().disassociateFromPort(floatingIp.getFloatingId());
								// REMOVE
								os.networking().floatingip().delete(floatingIp.getFloatingId());
								vimRepoWrapper.removeFloatingIp(map.getKey());
							} catch (Exception e) {
								log.error("An error occurred terminating floating IP: " + e.getMessage());
							}
						}
						//TRY TO DETACH FROM ROUTER
						try{
							os.networking().router().detachInterface(this.vim.getDefaultExternalRouterId(), null, map.getKey());
							log.debug("Removing port " + map.getKey() + " from the router " + this.vim.getDefaultExternalRouterId());
						} catch(Exception e1){
							response = os.networking().port().delete(map.getKey());
							if(response.getCode() == 200){
								log.debug("Port removed successfully: " + map.getKey());
							} else {
								log.error("Port remove failed with error: "+ response.getFault() +". Id: " + map.getKey());
							}
						}
						networkResourceId.add(map.getKey());
					} catch (Exception e) {
						log.error("An error occurred during port termination: " + e.getMessage());
					}

					break;
				default:
					break;
				}
			}
			return new TerminateNetworkResponse(networkResourceId);
		} else {
			log.error("Nothing to do ... Request map is null");
			throw new FailedOperationException("Nothing to do ... Request map is null");
		}
	}

	@Override
	public UpdateNetworkResponse updateVirtualisedNetworkResource(UpdateNetworkRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		// UpdateNetworkResponse updateResponse = null;
		// OSClientV3 os = null;
		//
		// if (token == null || token.getExpires().compareTo(new Date()) < 0) {
		// log.debug("Token has expired, generating a new one");
		// try {
		// this.authenticateVim();
		// } catch (Exception e) {
		// log.error("An error occurred during authentication: " +
		// e.getMessage());
		// throw new FailedOperationException("An error occurred during
		// authentication: " + e.getMessage());
		// }
		// }
		// try {
		// os = OSFactory.clientFromToken(token,
		// Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		// } catch (Exception e) {
		// log.error("An error occurred during openstack authentication: " +
		// e.getMessage());
		// throw new FailedOperationException("An error occurred during
		// authentication" + e.getMessage());
		// }
		//
		// if (request.getUpdateNetworkData() != null) {
		// VirtualNetworkData updatedNetwork = request.getUpdateNetworkData();
		// try {
		// Network network =
		// os.networking().network().get(request.getNetworkResourceId());
		// if (network == null) {
		// log.error("Network ID " + request.getNetworkResourceId() + " does not
		// exist on VIM");
		// throw new FailedOperationException(
		// "Network ID " + request.getNetworkResourceId() + " does not exist on
		// VIM");
		// }
		// /*
		// * Only name, adminStatus and shared can be modified by the
		// * openstack4j plugin. Only shared parameter is present in
		// * VirtualNetworkData.
		// */
		// NetworkUpdate netUpdate =
		// Builders.networkUpdate().shared(updatedNetwork.isShared()).build();
		// os.networking().network().update(request.getNetworkResourceId(),
		// netUpdate);
		// } catch (Exception e) {
		// log.error("An error occurred during update Network phase: " +
		// e.getMessage());
		// throw new FailedOperationException("An error occurred during update
		// Network phase: " + e.getMessage());
		// }
		//
		// } else if (request.getUpdateSubnetData() != null) {
		// NetworkSubnetData updatedSubnet = request.getUpdateSubnetData();
		// try {
		// Subnet subnet =
		// os.networking().subnet().get(request.getNetworkResourceId());
		// if (subnet == null) {
		// log.error("Subnet ID " + request.getNetworkResourceId() + " does not
		// exist on VIM");
		// throw new FailedOperationException(
		// "Subnet ID " + request.getNetworkResourceId() + " does not exist on
		// VIM");
		// }
		// IPVersionType ipVersion = (updatedSubnet.getIpVersion() ==
		// IpVersion.IPv4) ? IPVersionType.V4
		// : IPVersionType.V6;
		// os.networking().subnet().update(subnet.toBuilder().networkId(updatedSubnet.getNetworkId())
		// .gateway(updatedSubnet.getGatewayIp()).ipVersion(ipVersion).build());
		// } catch (Exception e) {
		// log.error("An error occurred during update Subnet phase: " +
		// e.getMessage());
		// throw new FailedOperationException("An error occurred during update
		// Subnet phase: " + e.getMessage());
		// }
		// } else if (request.getUpdateNetworkPort() != null) {
		// VirtualNetworkPortData updatedPort = request.getUpdateNetworkPort();
		// try {
		// Port port =
		// os.networking().port().get(request.getNetworkResourceId());
		// if (port == null) {
		// log.error("Port ID " + request.getNetworkResourceId() + " does not
		// exist on VIM");
		// throw new FailedOperationException(
		// "Port ID " + request.getNetworkResourceId() + " does not exist on
		// VIM");
		// }
		// } catch (Exception e) {
		// log.error("An error occurred during update port phase: " +
		// e.getMessage());
		// throw new FailedOperationException("An error occurred during update
		// port phase: " + e.getMessage());
		// }
		// } else {
		// log.error("All data is null. Operation cannot be executed");
		// throw new FailedOperationException("All data is null. Operation
		// cannot be executed");
		// }
		//
		// return updateResponse;
		throw new MethodNotImplementedException();
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

	/**
	 * This method execute an identification to the VIM, generates a Token that
	 * will be used during VIM operations
	 */
	private void authenticateVim() throws FailedOperationException {
		Identifier identifier = Identifier.byName(this.vim.getDomain());
		// project scoped authentication
		OSClientV3 os = null;
		try {
			os = OSFactory.builderV3().endpoint(this.vim.getUrl())
					.credentials(this.vim.getUsername(), this.vim.getPassword(), identifier)
					.scopeToProject(Identifier.byId(this.vim.getTenant())).authenticate();
			token = os.getToken();
		} catch (Exception e) {
			log.error("An error occured during authentication: " + e.getMessage());
			throw new FailedOperationException("An error occured during authentication: " + e.getMessage());
		}

	}

	/**
	 * The method performs the generation of a list of CIDRs
	 *
	 */
	private void defineCIDRs() {
		List<Cidr> cidrList = null;
		try {
			cidrList = vimRepoWrapper.retrieveCidr(vim.getVimId());
			if (cidrList == null || cidrList.size() == 0) {
				for (int i = 0; i < 256; i++) {
					Cidr cidr = new Cidr("192.168." + i + ".0/24", this.vim.getVimId(), true);
					vimRepoWrapper.storeCidr(cidr);
				}
			}
		} catch (Exception e) {
			log.error("An error occurred during creation of the cidrs: " + e.getMessage());
		}
	}

	/**
	 * @param networkID
	 * @return
	 * @throws FailedOperationException
	 */
	private ArrayList<VirtualNetworkPort> listPortsFromNetwork(String networkID) throws FailedOperationException {
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		PortListOptions plo = null;
		List<? extends Port> ports = null;
		try {
			plo = PortListOptions.create().networkId(networkID);
			ports = os.networking().port().list(plo);
		} catch (Exception e) {
			log.error("An error occurred when retrieving port list: " + e.getMessage());
			throw new FailedOperationException("An error occurred when retrieving port list: " + e.getMessage());
		}
		ArrayList<VirtualNetworkPort> listPorts = new ArrayList<VirtualNetworkPort>();
		for (Port port : ports) {
			Map<String, String> metadata = new HashMap<>();
			try {
				FloatingIp floatingIp = vimRepoWrapper.retrieveFloatingIpByPortId(port.getId());
				if (floatingIp != null) {
					NetFloatingIP floating = null;
					try {
						floating = os.networking().floatingip().get(floatingIp.getFloatingId());
					} catch (Exception e) {
						log.error("An error occurred gathering floating ip data on VIM: " + e.getMessage());
						throw new FailedOperationException(
								"An error occurred gathering floating ip data on VIM: " + e.getMessage());
					}
					if (floating != null) {
						metadata.put("FLOATING_IP_ADDRESS", floating.getFloatingIpAddress());
					}
				}
			} catch (Exception e) {
				log.error("An error occurred gathering information on DB: " + e.getMessage());
				throw new FailedOperationException("An error occurred gathering information on DB: " + e.getMessage());
			}
			OperationalState state = (port.getState() == State.ACTIVE) ? OperationalState.ENABLED
					: OperationalState.DISABLED;
			VirtualNetworkPort virtualPort = new VirtualNetworkPort(port.getId(), // resourceId
					port.getNetworkId(), // networkId
					port.getDeviceId(), // attachedResourceId
					null, // portType
					os.networking().network().get(port.getNetworkId()).getProviderSegID(), // segmentId
					0, // bandwidth
					state, // operationalState
					metadata // metadata
			);
			listPorts.add(virtualPort);
		}
		return listPorts;
	}

	/**
	 * 
	 * @param virtualComputeFlavor
	 * @return
	 * @throws FailedOperationException
	 */
	private String getFlavour(VirtualComputeFlavour virtualComputeFlavor) throws FailedOperationException {
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		List<? extends Flavor> flavors = null;
		try {
			flavors = os.compute().flavors().list();
		} catch (Exception e) {
			log.error("An error occurred during list flavors: " + e.getMessage());
			throw new FailedOperationException("An error occurred during list flavors: " + e.getMessage());
		}
		int size = 0;
		for (VirtualStorageData vStorage : virtualComputeFlavor.getStorageAttributes())
			size += vStorage.getSizeOfStorage();
		if (flavors != null && !flavors.isEmpty()) {
			for (Flavor flavor : flavors) {
				if (flavor.getVcpus() != virtualComputeFlavor.getVirtualCpu().getNumVirtualCpu())
					continue;
				if (flavor.getRam() != virtualComputeFlavor.getVirtualMemory().getVirtualMemSize()*1024)
					continue;
				if (flavor.getDisk() != size)
					continue;

				return flavor.getId();
			}
		}
		Flavor flavor = null;
		try {
			flavor = os.compute().flavors()
					.create(Builders.flavor().isPublic(false).name(virtualComputeFlavor.getFlavourId()).disk(size)
							.ram(virtualComputeFlavor.getVirtualMemory().getVirtualMemSize()*1024)
							.vcpus(virtualComputeFlavor.getVirtualCpu().getNumVirtualCpu()).build());
			return flavor.getId();
		} catch (Exception e) {
			log.error("An error occurred during flavor creation: " + e.getMessage());
			throw new FailedOperationException("An error occurred during flavor creation: " + e.getMessage());
		}

	}

	/**
	 * 
	 * @param id
	 *            Server ID
	 * @param status
	 *            Expected server status
	 * @return computeData Contains all info regarding the server
	 * @throws FailedOperationException
	 */
	private VirtualCompute getComputeData(String id, ComputeOperation status)
			throws FailedOperationException, MethodNotImplementedException {
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		Server server = null;
		try {
			server = os.compute().servers().get(id);
		} catch (Exception e) {
			log.error("An error occurred retrieving server " + id + " : " + e.getMessage());
			throw new FailedOperationException("An error occurred retrieving server " + id + " : " + e.getMessage());
		}
		if (server != null) {
			OperationalState state = null;
			// If status is null, means that data is required during an
			// CreateComputeResource or QueryComputeResource operations. Status
			// not null is used in case of OperateComputeResource operations
			if (status == null) {
				state = (server.getStatus() == Status.ERROR || server.getStatus() == Status.UNKNOWN
						|| server.getStatus() == Status.UNRECOGNIZED) ? OperationalState.DISABLED
								: OperationalState.ENABLED;
			} else {
				switch (status) {
				case CREATE_SNAPSHOT:
					// TODO: what to return in this case?
					log.error("The method is not implemented for the CREATE_SNAPSHOT operation");
					throw new MethodNotImplementedException(
							"The method is not implemented for the CREATE_SNAPSHOT operation");

				case DELETE_SNAPSHOT:
					// TODO: what to return in this case?
					log.error("The method is not implemented for the DELETE_SNAPSHOT operation");
					throw new MethodNotImplementedException(
							"The method is not implemented for the DELETE_SNAPSHOT operation");

				case PAUSE:
					state = (server.getStatus() == Status.PAUSED || server.getStatus() == Status.ACTIVE)
							? OperationalState.ENABLED : OperationalState.DISABLED;
					break;

				case REBOOT:
					state = (server.getStatus() == Status.REBOOT || server.getStatus() == Status.ACTIVE
							|| server.getStatus() == Status.HARD_REBOOT) ? OperationalState.ENABLED
									: OperationalState.DISABLED;
					break;

				case RESUME:
					state = (server.getStatus() == Status.ACTIVE || server.getStatus() == Status.SUSPENDED)
							? OperationalState.ENABLED : OperationalState.DISABLED;
					break;

				case START:
					state = (server.getStatus() == Status.ACTIVE || server.getStatus() == Status.STOPPED)
							? OperationalState.ENABLED : OperationalState.DISABLED;
					break;

				case STOP:
					state = (server.getStatus() == Status.ACTIVE || server.getStatus() == Status.STOPPED)
							? OperationalState.ENABLED : OperationalState.DISABLED;
					break;

				case SUSPEND:
					state = (server.getStatus() == Status.ACTIVE || server.getStatus() == Status.SUSPENDED)
							? OperationalState.ENABLED : OperationalState.DISABLED;
					break;

				case UNPAUSE:
					state = (server.getStatus() == Status.PAUSED || server.getStatus() == Status.ACTIVE)
							? OperationalState.ENABLED : OperationalState.DISABLED;
					break;

				}
			}
			Map<String, String> metadata = new HashMap<>();
			switch (server.getStatus()) {
			case ACTIVE:
			case HARD_REBOOT:
			case PAUSED:
			case REBOOT:
			case SHUTOFF:
			case STOPPED:
			case SUSPENDED:
				metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATED.toString());
				break;
			case BUILD:
				metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.INSTANTIATING.toString());
				break;
			case DELETED:
				metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.TERMINATED.toString());
				break;
			case ERROR:
			case UNKNOWN:
			case UNRECOGNIZED:
				metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.FAILED.toString());
				break;
			case MIGRATING:
			case REBUILD:
			case PASSWORD:
			case RESIZE:
			case REVERT_RESIZE:
			case SHELVED:
			case SHELVED_OFFLOADED:
			case VERIFY_RESIZE:
				break;
			}

			VirtualMemory virtualRam = new VirtualMemory(server.getFlavor().getRam(), null, false);
			VirtualCpu virtualCpu = new VirtualCpu(null, server.getFlavor().getVcpus(), 0, null,
					new VirtualCpuPinning());
			ArrayList<VirtualStorage> virtualStorages = new ArrayList<VirtualStorage>();
			VirtualStorage storage = new VirtualStorage(null, null, null, null, server.getFlavor().getDisk(), false,
					null, null, null, OperationalState.ENABLED, new HashMap<>());
			virtualStorages.add(storage);
			ArrayList<VirtualNetworkInterface> interfaces = new ArrayList<VirtualNetworkInterface>();
			List<? extends Port> ports = null;
			try {
				ports = os.networking().port().list();
			} catch (Exception e) {
				log.error("An error occurred gathering ports list: " + e.getMessage());
				throw new FailedOperationException("An error occurred gathering ports list: " + e.getMessage());
			}
			for (Port port : ports) {
				if (server.getId().equals(port.getDeviceId())) {
					Map<String, String> portMetadata = new HashMap<>();
					Set<? extends IP> ips = port.getFixedIps();
					List<String> ipAddresses = new ArrayList<>();
					for (IP address : ips) {
						ipAddresses.add(address.getIpAddress());
					}
					try {
						FloatingIp floatingIp = vimRepoWrapper.retrieveFloatingIpByPortId(port.getId());
						if (floatingIp != null) {
							NetFloatingIP floating = null;
							try {
								floating = os.networking().floatingip().get(floatingIp.getFloatingId());
							} catch (Exception e) {
								log.error("An error occurred gathering floating ip data on VIM: " + e.getMessage());
								throw new FailedOperationException(
										"An error occurred gathering floating ip data on VIM: " + e.getMessage());
							}
							if (floating != null) {
								portMetadata.put("FLOATING_IP_ADDRESS", floating.getFloatingIpAddress());
							}
						}
					} catch (Exception e) {
						log.error("An error occurred gathering information on DB: " + e.getMessage());
						throw new FailedOperationException(
								"An error occurred gathering information on DB: " + e.getMessage());
					}

					VirtualNetworkInterface porta = new VirtualNetworkInterface(port.getId(), port.getDeviceId(),
							port.getNetworkId(), port.getId(), ipAddresses, null, new ArrayList<String>(),
							port.getMacAddress(), 0, new ArrayList<String>(),
							(port.getState() == State.ACTIVE) ? OperationalState.ENABLED : OperationalState.DISABLED,
							portMetadata);
					interfaces.add(porta);
				}
			}

			VirtualCompute computeData = new VirtualCompute(server.getId(), // computeId,
					server.getName(), // computeName,
					server.getFlavorId(), // flavourId,
					new ArrayList<>(), // accelerationCapability,
					virtualCpu, // virtualCpu,
					virtualRam, // virtualMemory,
					interfaces, // virtualNetworkInterface,
					virtualStorages, // virtualDisks,
					server.getImageId(), // vcImageId,
					server.getAvailabilityZone(), // zoneId,
					server.getHostId(), // hostId,
					state, // operationalState,
					metadata // metadata
			);
			return computeData;
		} else {
			return new VirtualCompute();
		}
	}
	
	//Important note: this method creates the VCF only in the internal DB, but not in OpenStack. 
	//The VCF is created in OpenStack only during the VM instantiation.
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
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		
		String virtualComputeFlavourId = request.getComputeFlavourId();
		VirtualComputeFlavour virtualComputeFlavour = null;
		
		try {
			virtualComputeFlavour = vimRepoWrapper.retrieveVirtualComputeFlavour(virtualComputeFlavourId);
		} catch (NotExistingEntityException e) {
			log.error("Unable to find virtual compute flavour. Impossible to instantiate VM.");
			throw new FailedOperationException("Unable to find virtual compute flavour. Impossible to instantiate VM.");
		}
		
		
//		List<? extends Server> listaServers = null;
//		try {
//			listaServers = os.compute().servers().list();
//		} catch (Exception e) {
//			log.error("An error occurred retrieving servers list: " + e.getMessage());
//			throw new FailedOperationException("An error occurred retrieving servers list: " + e.getMessage());
//		}
//		
//		int count = 0;
//		for (Server server : listaServers) {
//			if (server.getName().equals(request.getComputeName())) {
//				count = 0;				
//				List<VirtualNetworkInterfaceData> listaVirtualNetInterfaces = virtualComputeFlavour.getVirtualNetworkInterface();
//				for (VirtualNetworkInterfaceData vNic : listaVirtualNetInterfaces) {
//					String netName = null;
//					try {
//						netName = os.networking().network().get(vNic.getNetworkId()).getName();
//					} catch (Exception e) {
//						log.error("An error occurred gathering network name: " + e.getMessage());
//						throw new FailedOperationException(
//								"An error occurred gathering network name: " + e.getMessage());
//					}
//					List<? extends Address> listaAddresses = server.getAddresses().getAddresses(netName);
//					for (Address addr : listaAddresses) {
//						for (String address : vNic.getIpAddress()) {
//							if (addr.getAddr().equals(address)) {
//								count++;
//								break;
//							}
//						}
//					}
//				}
//			}
//		}
//		if (count == virtualComputeFlavour.getVirtualNetworkInterface().size()) {
//			log.error("VM already instantiated");
//			throw new FailedOperationException("VM already instantiated");
//		}

		String flavorID = getFlavour(virtualComputeFlavour);
		if (flavorID == null) {
			log.error("An error occurred during flavor creation");
			throw new FailedOperationException("An error occurred during flavor creation");
		}

		List<? extends Image> images = null;
		try {
			images = os.images().list();
		} catch (Exception e) {
			log.error("An error occurred gathering Image list: " + e.getMessage());
			throw new FailedOperationException("An error occurred gathering Image list: " + e.getMessage());
		}
		String image_id = null;
		for (Image image : images) {
			if (image.getName().equals(request.getVcImageId())) {
				image_id = image.getId();
			}
		}

		if (image_id == null) {
			log.error("Image " + request.getVcImageId() + " not found");
			throw new FailedOperationException("Image " + request.getVcImageId() + " not found");
		}
		String availabilityZone = null;
		if ( request.getMetadata() != null ) {
			String zoneId = request.getMetadata().get("ZONE_ID");
			String hostId = request.getMetadata().get("HOST_ID");
			if (zoneId != null) {
				availabilityZone = zoneId;
			}
			if (zoneId != null && hostId != null) {
				availabilityZone = availabilityZone.concat(":");
				availabilityZone = availabilityZone.concat(hostId);
			}
		}
		ServerCreate sc = null;
		Server server = null;
		try {
			ServerCreateBuilder serverCreateBuilder = null;
			if (availabilityZone == null) {
				serverCreateBuilder = Builders.server().name(request.getComputeName()).flavor(flavorID).image(image_id);
			} else {
				log.debug("VNF " + request.getComputeName() +" is being instantiated at: " + availabilityZone );
				serverCreateBuilder = Builders.server().name(request.getComputeName()).flavor(flavorID).image(image_id)
						.availabilityZone(availabilityZone);
			}
			// IF KEYPAIR IS DEFINED IN THE VIM, USE IT, OTHERWISE NONE WILL BE USED
			if (this.vim.getKeyPair() != null && this.vim.getKeyPair() != ""){
				serverCreateBuilder.keypairName(this.vim.getKeyPair());
			}
			for (int i = 0; i < virtualComputeFlavour.getVirtualNetworkInterface().size(); i++) {
				log.debug("Adding port: "
						+ virtualComputeFlavour.getVirtualNetworkInterface().get(i).getNetworkPortId());
				serverCreateBuilder.addNetworkPort(virtualComputeFlavour.getVirtualNetworkInterface().get(i).getNetworkPortId());
			}
			if (request.getAffinityConstraint() != null) {
				log.debug("Found affinity constraints");
				for (AffinityConstraint constraint : request.getAffinityConstraint()) {
					if (constraint.getType() == AffinityType.AFFINITY) {
						log.debug("Affinity ResourceGroup : " + constraint.getAffinityAntiAffinityResourceGroup());
						serverCreateBuilder.addSchedulerHint("group", constraint.getAffinityAntiAffinityResourceGroup());
					} 
					else if (constraint.getType() == AffinityType.ANTI_AFFINITY) {
						for (String affinity : constraint.getAffinityAntiAffinityResourceList().getResource()) {
							log.debug("Antiaffinity ResourceGroup : " + constraint.getAffinityAntiAffinityResourceGroup()
									+ " ------ resource: " + affinity);
							serverCreateBuilder.addSchedulerHint(constraint.getAffinityAntiAffinityResourceGroup(),
									affinity);
						}
					}
				}
			}
			
			if (request.getMetadata() != null) {
				log.debug("Metadata is not null");
				String cloudInit = request.getMetadata().get("CLOUD_INIT_SCRIPT");
				if (cloudInit != null && cloudInit != "") {
					log.debug("Cloud init script is found");
					serverCreateBuilder.userData(Base64.getEncoder().encodeToString(cloudInit.getBytes()))
							.configDrive(true);
				}
			}
			sc = serverCreateBuilder.build();
			server = os.compute().servers().boot(sc);
		} catch (Exception e) {
			log.error("An error occurred during VM creation: " + e.getMessage());
			throw new FailedOperationException("An error occurred during VM creation: " + e.getMessage());
		}

		VirtualCompute computeData = null;
		try {
			computeData = getComputeData(server.getId(), null);
		} catch (Exception e) {
			log.error("An error occurred retrieving server data: " + e.getMessage());
			throw new FailedOperationException("An error occurred retrieving server data: " + e.getMessage());
		}
		response = new AllocateComputeResponse(computeData);
		return response;
	}

	@Override
	public QueryComputeResponse queryVirtualisedComputeResource(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		QueryComputeResponse response = null;
		List<VirtualCompute> computes = new ArrayList<>();
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}

		String type = request.getFilter().getParameters().get("RESOURCE_TYPE");
		String id = request.getFilter().getParameters().get("RESOURCE_ID");

		if (type.equalsIgnoreCase("VM")) {
			Server server = null;
			try {
				server = os.compute().servers().get(id);
			} catch (Exception e) {
				log.error("An error occurred gathering VM data from the VIM: " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred gathering VM data from the VIM: " + e.getMessage());
			}
			if (server == null) {
				//TODO Mark as terminated the instance
				Map<String, String> metadata = new HashMap<>();
				metadata.put("VIM_RESOURCE_STATUS", VimResourceStatus.TERMINATED.toString());
				VirtualCompute compute = new VirtualCompute(id, null, null, null, null, null, null, null, null, null, null, OperationalState.DISABLED, metadata);
				log.debug("VM id " + id + " marked as terminated");
				computes.add(compute);
			} else {
				VirtualCompute compute = null;
				try {
					compute = getComputeData(server.getId(), null);
					computes.add(compute);
				} catch (Exception e) {
					log.error("An error occurred retrieving server data" + e.getMessage());
					throw new FailedOperationException("An error occurred retrieving server data" + e.getMessage());
				}
			}
		} else {
			log.error("Resource TYpe is not a VM. RESOURCE_TYPE: " + type);
			throw new FailedOperationException("Resource TYpe is not a VM. RESOURCE_TYPE: " + type);
		}
		response = new QueryComputeResponse(computes);
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
		List<String> terminatedIds = new ArrayList<>();
		TerminateComputeResponse response = new TerminateComputeResponse(terminatedIds);
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		for (String id : request.getComputeId()) {
			try {
				os.compute().servers().delete(id);
				log.debug("Terminating server with ID: " + id);
				terminatedIds.add(id);
			} catch (Exception e) {
				log.error("An error occurred during VM termination: " + e.getMessage());
			}
		}
		return response;
	}

	@Override
	public OperateComputeResponse operateVirtualisedComputeResource(OperateComputeRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		VirtualCompute computeData = null;
		Map<String, String> computeExtraData = new HashMap<>();
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		ActionResponse actionResponse = null;
		switch (request.getComputeOperation()) {

		case CREATE_SNAPSHOT:
			String imageId = null;
			try {
				imageId = os.compute().servers().createSnapshot(request.getComputeId(), "Snapshot");
				// In this case a snapshot is created. The snap ID is added to
				// the computeExtraData
				computeExtraData.put("SNAPSHOT_ID", imageId);
			} catch (Exception e) {
				log.error("An error occurred during CREATE_SNAPSHOT operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during CREATE_SNAPSHOT operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			// TODO what to return in this case?
			break;

		case DELETE_SNAPSHOT:
			try {
				actionResponse = os.compute().servers().delete(request.getComputeId());
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during DELETE_SNAPSHOT operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during DELETE_SNAPSHOT operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during DELETE_SNAPSHOT operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during DELETE_SNAPSHOT operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			// TODO what to return in this case?
			break;

		case PAUSE:
			try {
				actionResponse = os.compute().servers().action(request.getComputeId(), Action.PAUSE);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during PAUSE operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during PAUSE operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during PAUSE operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during PAUSE operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			break;

		case REBOOT:
			try {
				actionResponse = os.compute().servers().reboot(request.getComputeId(), RebootType.SOFT);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during REBOOT operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during REBOOT operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during REBOOT operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during REBOOT operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			break;

		case START:
			try {
				actionResponse = os.compute().servers().action(request.getComputeId(), Action.START);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during START operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during START operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during START operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during START operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			break;

		case STOP:
			try {
				actionResponse = os.compute().servers().action(request.getComputeId(), Action.STOP);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during STOP operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during STOP operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error(
						"An error occurred during STOP operation on " + request.getComputeId() + ": " + e.getMessage());
				throw new FailedOperationException(
						"An error occurred during STOP operation on " + request.getComputeId() + ": " + e.getMessage());
			}
			break;

		case SUSPEND:
			try {
				actionResponse = os.compute().servers().action(request.getComputeId(), Action.SUSPEND);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during SUSPEND operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during SUSPEND operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during SUSPEND operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during SUSPEND operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			break;

		case RESUME:
			try {
				actionResponse = os.compute().servers().action(request.getComputeId(), Action.RESUME);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during RESUME operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during RESUME operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during RESUME operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during RESUME operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			break;

		case UNPAUSE:
			try {
				actionResponse = os.compute().servers().action(request.getComputeId(), Action.UNPAUSE);
				if (!actionResponse.isSuccess()) {
					log.error("An error occurred during UNPAUSE operation on " + request.getComputeId());
					throw new FailedOperationException(
							"An error occurred during UNPAUSE operation on " + request.getComputeId());
				}
			} catch (Exception e) {
				log.error("An error occurred during UNPAUSE operation on " + request.getComputeId() + ": "
						+ e.getMessage());
				throw new FailedOperationException("An error occurred during UNPAUSE operation on "
						+ request.getComputeId() + ": " + e.getMessage());
			}
			break;

		}
		computeData = getComputeData(request.getComputeId(), request.getComputeOperation());
		OperateComputeResponse response = new OperateComputeResponse(computeData, computeExtraData);
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
		int vCpus = 0;
		int vRam = 0;
		Map<String, String> filteringParams = new HashMap<>();
		List<VirtualComputeQuota> quotas = new ArrayList<>();
		QueryComputeResourceQuotaResponse response = new QueryComputeResourceQuotaResponse(quotas);
		QuotaSet quota = null;
		List<? extends Server> serverList = null;
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		try{
			quota = os.compute().quotaSets().get(this.vim.getTenant());
		} catch(Exception e){
			log.error("An error occurred gathering quotas for tenant " + this.vim.getTenant() + ": " + e.getMessage());
			throw new FailedOperationException("An error occurred gathering quotas for tenant " + this.vim.getTenant() + ": " + e.getMessage());
		}
		//TODO: Check if ownerId is a valid filter
		filteringParams.put("ownerId", this.vim.getTenant());
		try{
			serverList = os.compute().servers().list(filteringParams);
		} catch (Exception e) {
			log.error("An error occurred gathering instances list for tenant " + this.vim.getTenant() + ": " + e.getMessage());
			throw new FailedOperationException("An error occurred gathering instances list for tenant " + this.vim.getTenant() + ": " + e.getMessage());
		}
		for(Server server  :serverList){
			Flavor flavor = os.compute().flavors().get(server.getFlavorId());
			vCpus += flavor.getVcpus();
			vRam += flavor.getRam();
		}
		VirtualComputeQuota vQuota = new VirtualComputeQuota(
				this.vim.getTenant(), 
				quota.getCores() - vCpus, 
				quota.getInstances() - serverList.size(), 
				quota.getRam() - vRam
			);
		quotas.add(vQuota);
		
		List<? extends Hypervisor> hypervisors = os.compute().hypervisors().list();
		for(Hypervisor hypervisor: hypervisors){
			int localMemory = hypervisor.getLocalMemory();
			int localCPU = hypervisor.getVirtualCPU();
			String localHostname = hypervisor.getHypervisorHostname();
			for(Server server : serverList){
				if(server.getHost().equals(localHostname)){
					Flavor flavor = os.compute().flavors().get(server.getFlavorId());
					localMemory -= flavor.getRam();
					localCPU -= flavor.getVcpus();
				}
			}
			VirtualComputeQuota computeQuota = new VirtualComputeQuota(
					localHostname,
					localCPU,
					-1,
					localMemory
				);
			quotas.add(computeQuota);
		}
		return response;
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
		List<VirtualStorageQuota> queryResult = new ArrayList<>();
		QueryStorageResourceQuotaResponse response = new QueryStorageResourceQuotaResponse(queryResult);
		int vStorage = 0;
		Map<String, String> filteringParams = new HashMap<>();
		QuotaSet quota = null;
		List<? extends Server> serverList = null;
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		try{
			quota = os.compute().quotaSets().get(this.vim.getTenant());
		} catch(Exception e){
			log.error("An error occurred gathering quotas for tenant " + this.vim.getTenant() + ": " + e.getMessage());
			throw new FailedOperationException("An error occurred gathering quotas for tenant " + this.vim.getTenant() + ": " + e.getMessage());
		}
		//TODO: Check if ownerId is a valid filter
		filteringParams.put("ownerId", this.vim.getTenant());
		try{
			serverList = os.compute().servers().list(filteringParams);
		} catch (Exception e) {
			log.error("An error occurred gathering instances list for tenant " + this.vim.getTenant() + ": " + e.getMessage());
			throw new FailedOperationException("An error occurred gathering instances list for tenant " + this.vim.getTenant() + ": " + e.getMessage());
		}
		for(Server server  :serverList){
			Flavor flavor = os.compute().flavors().get(server.getFlavorId());
			vStorage += flavor.getDisk();
			vStorage += flavor.getEphemeral();
			vStorage += (flavor.getSwap()/1024);
		}
		VirtualStorageQuota vStorageQuota = new VirtualStorageQuota(
					this.vim.getTenant(), 
					quota.getGigabytes() - vStorage,
					0, 
					0
				);
		queryResult.add(vStorageQuota);
		
		List<? extends Hypervisor> hypervisors = os.compute().hypervisors().list();
		for(Hypervisor hypervisor: hypervisors){
			int localDisk = hypervisor.getLocalDisk();
			String localHostname = hypervisor.getHypervisorHostname();
			for(Server server : serverList){
				if(server.getHost().equals(localHostname)){
					Flavor flavor = os.compute().flavors().get(server.getFlavorId());
					localDisk -= (flavor.getDisk() + flavor.getEphemeral() + flavor.getSwap()/1024);
				}
			}
			VirtualStorageQuota storageQuota = new VirtualStorageQuota(
					localHostname, 
					localDisk, 
					0, 
					0);
			queryResult.add(storageQuota);
		}
		return response;
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
		
		VimWrapperRestClient wrapperOs = new VimWrapperRestClient(this.vim.getWrapperIp(), this.vim.getWrapperPort());
		log.debug("WrapperIP: " + this.vim.getWrapperIp());
		
		try {
			Iterator<Entry<String, PowerState>> it = powerStates.entrySet().iterator();
			while (it.hasNext()) {
		        Map.Entry<String, PowerState> pair = (Map.Entry<String, PowerState>)it.next();
		        log.debug("Changing state to " +pair.getKey()+ " in " + pair.getValue());
		        wrapperOs.modifyPowerState(pair.getKey(), pair.getValue());
		    }
		} catch(FailedOperationException e1){
			log.error("An error occurred changing powerstate to compute node: " + e1.getMessage());			
			throw new FailedOperationException("An error occurred changing powerstate to compute node: " + e1.getMessage());			
		} catch(RemoteEntityFailureException e2){
			log.error("An error occurred changing powerstate to compute node: " + e2.getMessage());			
			throw new FailedOperationException("An error occurred changing powerstate to compute node: " + e2.getMessage());			
		}
	}
	
	@Override
	public Map<String, PowerState> getPowerState(List<String> hostIds) throws MethodNotImplementedException {
		
		VimWrapperRestClient wrapperOs = new VimWrapperRestClient(this.vim.getWrapperIp(), this.vim.getWrapperPort());
		Map<String, PowerState> powerStates = new HashMap<>();
		try{
			ArrayList<ComputeNode> computeNodesList = wrapperOs.getComputeNodes();
			for (ComputeNode compute : computeNodesList){
				for(String computeName: hostIds){
					if(computeName.equalsIgnoreCase(compute.getName()))
						powerStates.put(compute.getName(), compute.getPower_state());
				}
			}
		} catch(FailedOperationException e1){
			log.error("An error occurred gathering compute nodes list: " + e1.getMessage());
		} catch(RemoteEntityFailureException e2){
			log.error("An error occurred gathering compute nodes list: " + e2.getMessage());			
		}
		Iterator<Entry<String, PowerState>> it = powerStates.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry<String, PowerState> pair = (Map.Entry<String, PowerState>)it.next();
	        log.debug("ComputeNode: " + pair.getKey() + " - " + "StatePower: " + pair.getValue()) ;
	    }
		return powerStates;
	}
	
	@Override
	public List<HostPowerStaticInfo> getPowerStateInfo() throws MethodNotImplementedException {
		VimWrapperRestClient wrapperOs = new VimWrapperRestClient(this.vim.getWrapperIp(), this.vim.getWrapperPort());
		List<HostPowerStaticInfo> powerInfos = new ArrayList<>();
		List<ComputeNode> computeNodes = null;
		List<PowerState> supportedPowerState = new ArrayList<>();
		supportedPowerState.add(PowerState.POWER_ON);
		supportedPowerState.add(PowerState.POWER_OFF);
		PowerStateParameters powerOff = new PowerStateParameters(0, 0, 0,0);
		try {
			computeNodes = wrapperOs.getComputeNodes();
			for (ComputeNode compute : computeNodes){
				Map<PowerState, PowerStateParameters> powerStateparameters = new HashMap<>();
				List<VirtualMachineType> vmTypes = wrapperOs.getVirtualMachineTypes(compute.getName());
				PowerStateParameters powerOn = null;
				if(vmTypes.isEmpty()){
					powerOn = new PowerStateParameters((int)compute.getIdle_pc(), 0, 0, 0);
				} else {
					VirtualMachineType type = vmTypes.get(0);
					powerOn = new PowerStateParameters((int)compute.getIdle_pc(), type.getIdle_pc(), type.getTraffic_pc(), type.getFull_pc());
				}
				powerStateparameters.put(PowerState.POWER_OFF, powerOff);
				powerStateparameters.put(PowerState.POWER_ON, powerOn);
				String zoneId = getAvailabilityZone(compute.getName());
				HostPowerStaticInfo host = new HostPowerStaticInfo(compute.getName(), zoneId, compute.getMac_address(), false, supportedPowerState, powerStateparameters);
				powerInfos.add(host);
			}
		} catch(FailedOperationException e1){
			log.error("An error occurred gathering compute nodes list: " + e1.getMessage());
		} catch(RemoteEntityFailureException e2){
			log.error("An error occurred gathering compute nodes list: " + e2.getMessage());			
		} 
		return powerInfos;
	}
	
	@Override
	public List<HostPowerStaticInfo> getPowerStateInfo(List<String> hostIds) throws MethodNotImplementedException {
		VimWrapperRestClient wrapperOs = new VimWrapperRestClient(this.vim.getWrapperIp(), this.vim.getWrapperPort());
		List<HostPowerStaticInfo> powerInfos = new ArrayList<>();
		List<ComputeNode> computeNodes = null;
		List<PowerState> supportedPowerState = new ArrayList<>();
		supportedPowerState.add(PowerState.POWER_ON);
		supportedPowerState.add(PowerState.POWER_OFF);
		PowerStateParameters powerOff = new PowerStateParameters(0, 0, 0, 0);
		
		try{
			computeNodes = wrapperOs.getComputeNodes();
			for (ComputeNode compute : computeNodes){
				for(String hostId : hostIds){
					if(hostId.equalsIgnoreCase(compute.getName())){
						Map<PowerState, PowerStateParameters> powerStateparameters = new HashMap<>();
						List<VirtualMachineType> vmTypes = wrapperOs.getVirtualMachineTypes(compute.getName());
						PowerStateParameters powerOn = null;
						if(vmTypes.isEmpty()){
							powerOn = new PowerStateParameters((int)compute.getIdle_pc(), 0, 0, 0);
						} else {
							VirtualMachineType type = vmTypes.get(0);
							powerOn = new PowerStateParameters((int)compute.getIdle_pc(), type.getIdle_pc(), type.getTraffic_pc(), type.getFull_pc());
						}
						powerStateparameters.put(PowerState.POWER_OFF, powerOff);
						powerStateparameters.put(PowerState.POWER_ON, powerOn);
						String zoneId = getAvailabilityZone(hostId);
						HostPowerStaticInfo host = new HostPowerStaticInfo(compute.getName(), zoneId, compute.getMac_address(), false, supportedPowerState, powerStateparameters);
						powerInfos.add(host);
					}
				}
			}
		} catch(FailedOperationException e1){
			log.error("An error occurred gathering compute nodes list: " + e1.getMessage());
		} catch(RemoteEntityFailureException e2){
			log.error("An error occurred gathering compute nodes list: " + e2.getMessage());			
		} 
		return powerInfos;
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
	
	private String getAvailabilityZone(String hypervisor) throws FailedOperationException{
		OSClientV3 os = null;
		if (token == null || token.getExpires().compareTo(new Date()) < 0) {
			log.debug("Token has expired, generating a new one");
			try {
				this.authenticateVim();
			} catch (Exception e) {
				log.error("An error occurred during authentication: " + e.getMessage());
				throw new FailedOperationException("An error occurred during authentication: " + e.getMessage());
			}
		}
		try {
			os = OSFactory.clientFromToken(token,
					Config.newConfig().withSSLVerificationDisabled().withConnectionTimeout(openstackTimeout));
		} catch (Exception e) {
			log.error("An error occurred during openstack authentication: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication" + e.getMessage());
		}
		try{
			List<? extends AvailabilityZone> zones = os.compute().zones().list(true);
			for(AvailabilityZone zone: zones){
				Map<String, Map<String, ? extends NovaService>> hostsList = zone.getHosts();
				for(Map.Entry<String, Map<String, ? extends NovaService>> entry: hostsList.entrySet()){
					if(entry.getKey().contains(hypervisor))
						return zone.getZoneName();
				}
				
			}
		} catch(Exception e){
			log.error("An error occurred gathering quotas for tenant " + this.vim.getTenant() + ": " + e.getMessage());
			throw new FailedOperationException("An error occurred gathering quotas for tenant " + this.vim.getTenant() + ": " + e.getMessage());
		}
		return null;
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
