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
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnet;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetwork;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.QueryComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.QueryNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkResponse;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

/**
 * Class that implements the task to send polling requests
 * to the VIM in order to detect changes in the status
 * of the resources.
 * 
 * @author nextworks
 *
 */
public class VimPollingTask implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(VimPollingTask.class);
	
	private VimResourcePollingManager pollingManager;

	public VimPollingTask(VimResourcePollingManager pollingManager) {
		this.pollingManager = pollingManager;
	}
	
	@Override
	public void run() {
		log.debug("Running VIM polling task");
		Map<String, PolledResource> polledResources = pollingManager.getPolledResourcesCopy();
		List<String> verifiedResourceIds = new ArrayList<>();
		synchronized (polledResources) {
			for (Map.Entry<String, PolledResource> e : polledResources.entrySet()) {
				PolledResource resource = e.getValue();
				VimResourceStatus expectedStatus = resource.getExpectedStatus();
				switch (expectedStatus) {
				case INSTANTIATED: {
					if (checkResourceInstantiation(resource)) verifiedResourceIds.add(resource.getResourceId());
					break;
				}

				case TERMINATED: {
					log.debug("Trying to check termination on : " + resource.getResourceId());
					if (checkResourceTermination(resource)) 
						verifiedResourceIds.add(resource.getResourceId());
					break;
				}

				default: {
					log.error("Expected status not supported for polled VIM resource");
					break;
				}
				}
			}
		}
		for (String s : verifiedResourceIds) {
			pollingManager.removeResource(s);
			log.debug("Resource removed from polling processing.");
		}
		log.debug("VIM polling task terminated");
	}
	
	private boolean checkResourceInstantiation(PolledResource resource) {
		String resourceId = resource.getResourceId();
		VimResourceType type = resource.resourceType;
		log.debug("Check status for " + type.toString() + " resource " + resourceId + " in instantiation mode");
		VimPlugin  vp = resource.getVimPlugin();
		try {
		switch (type) {
		case NETWORK: {
			
			QueryNetworkResponse response = vp.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(type, resourceId), null));
			VirtualNetwork vNet = response.getNetworkData().get(0);
			VimResourceStatus status = Utilities.readResourceStatusFromMetadata(vNet.getMetadata());
			if ((status.equals(VimResourceStatus.INSTANTIATED) || (status.equals(VimResourceStatus.FAILED)))) {
				log.debug("Resource in stable status - sending notification");
				AllocateNetworkResponse notification = new AllocateNetworkResponse(vNet, null, null);
				resource.getListener().notify(notification);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Resource still in unstable status - continuing polling.");
				return false;
			}
		}
		
		case SUBNET: {

			QueryNetworkResponse response = vp.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(type, resourceId), null));
			NetworkSubnet subnet = response.getSubnetData().get(0);
			VimResourceStatus status = Utilities.readResourceStatusFromMetadata(subnet.getMetadata());
			if ((status.equals(VimResourceStatus.INSTANTIATED) || (status.equals(VimResourceStatus.FAILED)))) {
				log.debug("Resource in stable status - sending notification");
				AllocateNetworkResponse notification = new AllocateNetworkResponse(null, subnet, null);
				resource.getListener().notify(notification);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Resource still in unstable status - continuing polling.");
				return false;
			}
		}

		case PORT: {

			QueryNetworkResponse response = vp.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(type, resourceId), null));
			VirtualNetworkPort port = response.getNetworkPortData().get(0);
			VimResourceStatus status = Utilities.readResourceStatusFromMetadata(port.getMetadata());
			if ((status.equals(VimResourceStatus.INSTANTIATED) || (status.equals(VimResourceStatus.FAILED)))) {
				log.debug("Resource in stable status - sending notification");
				AllocateNetworkResponse notification = new AllocateNetworkResponse(null, null, port);
				resource.getListener().notify(notification);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Resource still in unstable status - continuing polling.");
				return false;
			}
		}

		case VM: {
			
			QueryComputeResponse response = vp.queryVirtualisedComputeResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(type, resourceId), null));
			VirtualCompute vm = response.getVirtualCompute().get(0);
			VimResourceStatus status = Utilities.readResourceStatusFromMetadata(vm.getMetadata());
			if ((status.equals(VimResourceStatus.INSTANTIATED) || (status.equals(VimResourceStatus.FAILED)))) {
				log.debug("Resource in stable status - sending notification");
				AllocateComputeResponse notification = new AllocateComputeResponse(vm);
				resource.getListener().notify(notification);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Resource still in unstable status - continuing polling.");
				return false;
			}
		}
		
		default:
			log.error("Type not supported for polled VIM resource");
			break;
		}
		} catch (MethodNotImplementedException | MalformattedElementException | NotExistingEntityException | FailedOperationException e) {
			log.error(e.getMessage());
		} catch (NullPointerException e) {
			log.error(e.getMessage());
		}
		return false;
	}
	
	private boolean checkResourceTermination(PolledResource resource) {
		String resourceId = resource.getResourceId();
		VimResourceType type = resource.resourceType;
		log.debug("Check status for " + type.toString() + " resource " + resourceId + " in termination mode");
		VimPlugin  vp = resource.getVimPlugin();
		try {
		switch (type) {
			case NETWORK:
			case SUBNET:
			case PORT: {
			
			QueryNetworkResponse response = vp.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(type, resourceId), null));
			VirtualNetwork vNet = response.getNetworkData().get(0);
			VimResourceStatus status = Utilities.readResourceStatusFromMetadata(vNet.getMetadata());
			if ((status.equals(VimResourceStatus.TERMINATED) || (status.equals(VimResourceStatus.FAILED)))) {
				log.debug("Resource in stable status - sending notification");
				List<String> networkResourceId = new ArrayList<>();
				networkResourceId.add(resourceId);
				TerminateNetworkResponse notification = new TerminateNetworkResponse(networkResourceId);
				resource.getListener().notify(notification);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Resource still in unstable status - continuing polling.");
				return false;
			}
		}
		
		case VM: {
			
			QueryComputeResponse response = vp.queryVirtualisedComputeResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(type, resourceId), null));
			VirtualCompute vm = response.getVirtualCompute().get(0);
			VimResourceStatus status = Utilities.readResourceStatusFromMetadata(vm.getMetadata());
			log.debug("Got status: " + status.toString());
			if ((status.equals(VimResourceStatus.TERMINATED) || (status.equals(VimResourceStatus.FAILED)))) {
				log.debug("Resource in stable status - sending notification");
				List<String> computeId = new ArrayList<>();
				computeId.add(resourceId);
				TerminateComputeResponse notification = new TerminateComputeResponse(computeId);
				resource.getListener().notify(notification);
				log.debug("Notification sent");
				return true;
			} else {
				log.debug("Resource still in unstable status - continuing polling.");
				return false;
			}
		}
		
		default:
			log.error("Type not supported for polled VIM resource");
			break;
		}
		} catch (MethodNotImplementedException | MalformattedElementException | NotExistingEntityException | FailedOperationException e) {
			log.error(e.getMessage());
		} catch (NullPointerException e) {
			log.error(e.getMessage());
		}
		return false;
	}
	

}
