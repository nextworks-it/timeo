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
package it.nextworks.nfvmano.timeo.rc.algorithms;


import it.nextworks.nfvmano.timeo.rc.elements.NetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathEndPoint;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco Capitani on 19/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class SolutionParser {

    private static final Logger log = LoggerFactory.getLogger(SolutionParser.class);

    private ComputationSolution solution;
    private List<VnfResourceAllocation> vnfResourceAllocations = new ArrayList<>();
    private List<NetworkPath> networkPaths = new ArrayList<>();

    private List<String> networkNodesToBeActivated = new ArrayList<>();
    private Map<String,String> computeNodesToBeActivated = new HashMap<>();

    private String vimId;
    private String requestId;
    private Map<String, VirtualMachine> vms;
    private Map<String, String> sap2vldId;

    public SolutionParser(ComputationSolution solution,
                          Map<String, VirtualMachine> vms,
                          Map<String, String> sap2vldId,
                          String requestId,
                          String vimId) {
        this.solution = solution;
        this.vimId = vimId;
        this.vms = vms;
        this.requestId = requestId;
        this.sap2vldId = sap2vldId;
    }

    public SolutionParser(ComputationSolution solution,
                          Map<String, VirtualMachine> vms,
                          Map<String, String> sapMap,
                          String requestId) {
        this(solution, vms, sapMap, requestId, "OpenStack_local");
    }

    public NsResourceSchedulingSolution buildSolution() {
        solution.nodeConfs.forEach(this::parseConfiguration);
        solution.instantiations.forEach(this::parseInstantiation);
        solution.paths.forEach(this::parsePath);
        return new NsResourceSchedulingSolution(
            requestId,
                vnfResourceAllocations,
                networkPaths,
                true,
                networkNodesToBeActivated,
                computeNodesToBeActivated
        );
    }

    private void parseConfiguration(TopologyNode node, Integer newState) {
        if (newState != 0) {
            if (node.vCPUs == 0 || node.memory == 0 || node.hddSize == 0) {
                networkNodesToBeActivated.add(node.nodeId);
            } else {
                computeNodesToBeActivated.put(node.vimName, vimId);
            }
        }
    }

    private void parseInstantiation(String vmId, TopologyNode node) {
        if (sap2vldId.containsKey(vmId)) {
            // We should not return instantiations for SAPs
            return;
        }
        VirtualMachine vm = vms.get(vmId);
        vnfResourceAllocations.add(new VnfResourceAllocation(
                null,
                vm.getVnfd().getVnfdId(),
                vm.getVnfIndex(),
                vm.getVduId(),
                vm.getVduIndex(),
                vimId,
                node.zoneId,
                node.vimName
        ));
    }

    private NetworkPathEndPoint makeEndPoint(String endpointId, String cpdId) {
        if (vms.containsKey(endpointId)) {
            VirtualMachine vm = vms.get(endpointId);
            return new NetworkPathEndPoint(
                    vm.getVnfd().getVnfdId(),
                    vm.getVnfIndex(),
                    vm.getVduId(),
                    vm.getVduIndex(),
                    cpdId
            );
        } else {
            return new NetworkPathEndPoint(endpointId, sap2vldId.get(endpointId));
        }
    }

    private NetworkPathEndPoint makeSapEndPoint(String sapId, String vldId) {
        return new NetworkPathEndPoint(sapId, vldId);
    }

    private void parsePath(ComputationSolution.VMPath path) {
        if (path.source.equals("FakeEntryPoint")) {
            return;
        }
        List<TopologyLink> links = path.path;

        List<NetworkPathHop> nphs = new ArrayList<>();
        TopologyLink previous = null;
        int hopNumber = 0;
        Iterator<TopologyLink> iterator = links.iterator();
        while (iterator.hasNext()) {
            TopologyLink link = iterator.next();
            if (null == previous) {
                // The hops are the spaces between links, hence
                // the first link is not parsed by itself, but used to initialize the loop by setting previous.
                previous = link;
                continue;
            }
            boolean first = hopNumber == 0;
            boolean last = !iterator.hasNext();
            nphs.add(new NetworkPathHop(
                    null,
                    hopNumber,
                    link.source.nodeId,
                    previous.destinationCp.cpId,
                    link.sourceCp.cpId,
                    previous.linkId,
                    link.linkId,
                    0,
                    first,
                    last,
                    null,
                    null
            ));
            hopNumber++;
            previous = link;
        }

        if (nphs.isEmpty()) {
            // No path to instantiate, so skip.
            return;
        }
        if (nphs.size() == 1 && nphs.get(0).getIngressPortId().equals(nphs.get(0).getEgressPortId())) {
            // "reflected" path, so skip.
            return;
        }

        VirtualMachine srcVm = vms.get(path.source);
        VirtualMachine dstVm = vms.get(path.destination);
        List<String> vLinks = srcVm.getNeighbour(path.destination);
        for (String vLink : vLinks) {
            String srcCpd = srcVm.getIntCpdFromVLink(vLink);
            NetworkPathEndPoint src = makeEndPoint(path.source, srcCpd);
            List<NetworkPathEndPoint> npes = new ArrayList<>();
            npes.add(src);

            String dstCpd;
            if (dstVm != null) { // It's a real VM
                dstCpd = dstVm.getIntCpdFromVLink(vLink);

                NetworkPathEndPoint dest = makeEndPoint(path.destination, dstCpd);
                npes.add(dest);
            } else { // It's a SAP
                NetworkPathEndPoint dest = makeSapEndPoint(path.destination, vLink);
                npes.add(dest);
            }

            String npId = String.format(
                    "NetPath_%s-%s_req_%s_vLink_%s",
                    path.source, path.destination,
                    requestId,
                    vLink
            );
            NetworkPath networkPath = new NetworkPath(
                    null,
                    npId,
                    npes,
                    nphs,
                    vLink,
                    false
            );
            networkPaths.add(networkPath);
        }
    }
}
