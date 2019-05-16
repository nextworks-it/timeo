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
package it.nextworks.nfvmano.timeo.rc.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.NsScaleSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.PnfAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.ScaleVnfResourceAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;


@Service
public class ResourceComputationDbWrapper {

	private static final Logger log = LoggerFactory.getLogger(ResourceComputationDbWrapper.class);

	@Autowired
	NetworkPathRepository networkPathRepository;

	@Autowired
	NsResourceSchedulingSolutionRepository nsResourceSchedulingSolutionRepository;
	
	@Autowired
	NsScaleSchedulingSolutionRepository nsScaleSchedulingSolutionRepository;

		
	@Autowired
	ScaleVnfResourceAllocationRepository scaleVnfResourceAllocationRepository;

	@Autowired
	VnfResourceAllocationRepository vnfResourceAllocationRepository;

	@Autowired
	NetworkPathHopRepository networkPathHopRepository;
	
	@Autowired
	PnfAllocationRepository pnfAllocationRepository;
	
	public ResourceComputationDbWrapper() {	}

	public synchronized void addNewNsScaleSchedulingSolution(NsScaleSchedulingSolution input) throws NotExistingEntityException, AlreadyExistingEntityException {
		log.debug("Storing new NS scale scheduling solution in DB");
		
		List<VnfResourceAllocation> overallVnfds = new ArrayList<>();
		ArrayList<String> addedVnfds = new ArrayList<>();
		NsResourceSchedulingSolution currentSolution = getNsResourceSchedulingSolution(input.getNsInstanceId());
		for(ScaleVnfResourceAllocation vnfRA : input.getDiffScaleResourceSolution().getVnfResourceAllocation() ){
			overallVnfds.add(vnfRA.getVnfResourceAllocation());
			addedVnfds.add(vnfRA.getVnfdId());

		}
		for(VnfResourceAllocation vnfRA : currentSolution.getVnfResourceAllocation()){
			if(!addedVnfds.contains(vnfRA.getVnfdId())){
				overallVnfds.add(vnfRA);
			}
		}
		//TODO: implement PNF, networkPaths, comuteNodes, NetworkNodes deallocation
		List<PnfAllocation> overallPnfs = currentSolution.getPnfAllocation();
		List<NetworkPath> overallNetworkPaths = currentSolution.getNetworkPaths();
		Map<String,String> overallComputeNodes = currentSolution.getComputeNodesToBeActivated();
		List<String> overallNetworkNodes = currentSolution.getNetworkNodesToBeActivated();
		this.removeNsResourceSchedulingSolution(input.getNsInstanceId());
		this.addNewNsResourceSchedulingSolution(new NsResourceSchedulingSolution
				(input.getNsInstanceId(),
						overallVnfds,
						overallPnfs,
						overallNetworkPaths,
						input.isSolutionFound(),
						overallNetworkNodes,
						overallComputeNodes));

		input.setPostScaleResourceSolution(this.getNsResourceSchedulingSolution(input.getNsInstanceId()));
		nsScaleSchedulingSolutionRepository.saveAndFlush(input);


	}

	public synchronized void addNewNsResourceSchedulingSolution(NsResourceSchedulingSolution input) throws AlreadyExistingEntityException {
		log.debug("Storing new NS resource scheduling solution in DB");
		if (nsResourceSchedulingSolutionRepository.findByNsInstanceId(input.getNsInstanceId()).isPresent()) {
			log.error("An NS resource scheduling solution for NS instance " + input.getNsInstanceId() + " is already present in DB. Impossible to store a new one");
			throw new AlreadyExistingEntityException();
		} else {
			NsResourceSchedulingSolution output = new NsResourceSchedulingSolution(input.getNsInstanceId(), input.isSolutionFound(), 
					input.getNetworkNodesToBeActivated(), input.getComputeNodesToBeActivated());
			nsResourceSchedulingSolutionRepository.saveAndFlush(output);
			List<VnfResourceAllocation> vras = input.getVnfResourceAllocation();
			for (VnfResourceAllocation vra: vras) {
				VnfResourceAllocation targetVra = new VnfResourceAllocation(output, vra.getVnfdId(), vra.getVnfIndex(), vra.getVduId(),
						vra.getVduIndex(), vra.getVimId(), vra.getZoneId(), vra.getHostId());
				vnfResourceAllocationRepository.saveAndFlush(targetVra);
			}
			List<PnfAllocation> pas = input.getPnfAllocation();
			for (PnfAllocation pa : pas) {
				PnfAllocation targetPa = new PnfAllocation(output, pa.getPnfdId(), pa.getPnfdVersion(), pa.getIndex(), pa.getPnfInstanceId(), pa.getPnfProfileId(), pa.getParameters());
				pnfAllocationRepository.saveAndFlush(targetPa);
			}
			List<NetworkPath> nps = input.getNetworkPaths();
			for (NetworkPath np : nps) {
				NetworkPath targetNp = new NetworkPath(output, np.getNetworkPathId(), np.getEndPoints(), np.getNsVirtualLinkDescriptorId(), np.isBackup());
				networkPathRepository.saveAndFlush(targetNp);
				List<NetworkPathHop> hops = np.getHops();
				for (NetworkPathHop hop : hops) {
					NetworkPathHop targetHop = new NetworkPathHop(targetNp, hop.getHopNumber(), hop.getNodeId(), hop.getIngressPortId(),
							hop.getEgressPortId(), hop.getIncomingLinkId(), hop.getOutgoingLinkId(), hop.getHopQueue(), hop.isFirst(), hop.isLast());
					networkPathHopRepository.saveAndFlush(targetHop);
				}
			}
			log.debug("NS resource scheduling solution for NS instance " + input.getNsInstanceId() + " saved in DB");
		}
	}
	
	public NsResourceSchedulingSolution getNsResourceSchedulingSolution(String nsInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving NS resource scheduling solution from DB");
		Optional<NsResourceSchedulingSolution> solOpt = nsResourceSchedulingSolutionRepository.findByNsInstanceId(nsInstanceId);
		if (solOpt.isPresent()) {
			return solOpt.get(); 
		} else {
			throw new NotExistingEntityException("NS resource scheduling solution not found for NS instance " + nsInstanceId);
		}
	}
	
	public List<NsResourceSchedulingSolution> getAllNsResourceSchedulingSolutions() {
		log.debug("Retrieving all NS resource scheduling solution from DB");
		return nsResourceSchedulingSolutionRepository.findAll();
	}
	
	public synchronized void removeNsResourceSchedulingSolution(String nsInstanceId) throws NotExistingEntityException {
		log.debug("Removing NS resource scheduling solution from DB");
		NsResourceSchedulingSolution solution = getNsResourceSchedulingSolution(nsInstanceId);
		nsResourceSchedulingSolutionRepository.delete(solution);
		log.debug("NS resource scheduling solution removed from DB");
	}
	
	/**
	 * Retrieve a VNF resource allocation solution
	 * 
	 * @param nsInstanceId ID of the NS instance
	 * @param vnfdId 		ID of the VNFD associated to the given VNF
	 * @param index			Index of the VNF to be instantiated
	 * @return				the VNF resource allocation solution, if available
	 * @throws NotExistingEntityException	if the solution is not found
	 */
	public List<VnfResourceAllocation> getVnfResourceAllocation(String nsInstanceId, String vnfdId, int index) throws NotExistingEntityException {
		log.debug("Retrieving VNF resource allocation solution from DB");
		List<VnfResourceAllocation> res = vnfResourceAllocationRepository.findByNsRssNsInstanceIdAndVnfdIdAndVnfIndex(nsInstanceId, vnfdId, index);
		if ((res == null) || (res.isEmpty())) {
			log.error("VNF resource allocation solution for NS instance " + nsInstanceId + ", VNFD ID " + vnfdId + " and index " + index + " not found");
			throw new NotExistingEntityException("Solution not found.");
		} else return res;
	}
	
	/**
	 * Retrieve a PNF allocation solution
	 * 
	 * @param nsInstanceId ID of the NS instance
	 * @return the list of PNFs to be used for that NS instance
	 */
	public List<PnfAllocation> getPnfAllocation(String nsInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving PNF allocation solution from DB");
		return pnfAllocationRepository.findByNsRssNsInstanceId(nsInstanceId);
	}
	
	/**
	 * Retrieve the list of VNF allocation solution which are using a given compute node (identified by VIM ID and HOST ID), excepting the 
	 * ones related to a given NS instance ID
	 * 
	 * @param nsInstanceId ID of the NS to be excluded from the selection
	 * @param vimId ID of the VIM where the VNF are allocated
	 * @param hostId ID of the host where the VNF are allocated
	 * @return
	 */
	public List<VnfResourceAllocation> getRemainingVnfAllocationsOnHost(String nsInstanceId, String vimId, String hostId) {
		return vnfResourceAllocationRepository.findByNsRssNsInstanceIdNotAndVimIdAndHostId(nsInstanceId, vimId, hostId);
	}
	
	/**
	 * Retrieves the list of network path hops on a given network node but not associated to network paths belonging to a given NS instance ID
	 * 
	 * @param nsInstanceId ID of the NS to be excluded from the selection
	 * @param networkNodeId ID of the given network node
	 * @return
	 */
	public List<NetworkPathHop> getRemainingPathHopInUse(String nsInstanceId, String networkNodeId) {
		return networkPathHopRepository.findByNpNsRssNsInstanceIdNotAndNodeId(nsInstanceId, networkNodeId);
	}

}
