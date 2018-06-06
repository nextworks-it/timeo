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
package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.timeo.rc.algorithms.VMSize;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.*;

/**
 * Created by Marco Capitani on 28/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class NetConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DijkstraSolverSequential.class);

    private Map<TopologyNode, Integer> powerStates;
    private Map<String, TopologyNode> vmMap;
    private Map<TopologyNode, List<String>> invVmMap;
    private Map<TopologyNode, VMSize> usedResources;
    private List<String> vms;
    private Map<String, VMSize> sizes;

    List<String> getVms() {
        return vms;
    }

    Integer getState(TopologyNode node) {
        return powerStates.get(node);
    }

    TopologyNode getCompute(String vm) {
        return vmMap.get(vm);
    }

    private VMSize getUsedResources(TopologyNode node) {
        return usedResources.getOrDefault(node, VMSize.sum());
    }

    boolean fits(String vm, TopologyNode node) {
        return (getState(node) != 0 && getUsedResources(node).sum(sizes.get(vm)).fitsIn(node));
    }

    private void instantiate(String vm, TopologyNode node) {
        if (!sizes.containsKey(vm)) {
            throw new IllegalArgumentException(String.format("No vm named %s", vm));
        }
        VMSize newUsed = getUsedResources(node).sum(sizes.get(vm));
        if (!newUsed.fitsIn(node)) {
            throw new IllegalArgumentException(String.format(
                    "Vm %s size %s does not fit in node %s, used %s. VMs: %s.",
                    vm, sizes.get(vm),
                    node, usedResources.getOrDefault(node, VMSize.sum()),
                    invVmMap.getOrDefault(node, new ArrayList<>())
            ));
        }

        invVmMap.putIfAbsent(node, new ArrayList<>());
        invVmMap.get(node).add(vm);
        usedResources.put(node, newUsed);
    }

    NetConfiguration(Map<TopologyNode, Integer> powerStates,
                     Map<String, TopologyNode> vmMap,
                     List<String> vms,
                     Map<String, VMSize> sizes) {
        this.powerStates = powerStates;
        this.vmMap = vmMap;
        this.vms = vms;
        this.sizes = sizes;
        this.invVmMap = new HashMap<>();
        this.usedResources = new HashMap<>();
        for (Map.Entry<String, TopologyNode> entry: this.vmMap.entrySet()) {
            if (entry.getValue() != null) {
                instantiate(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
	 * @return the invVmMap
	 */
	public Map<TopologyNode, List<String>> getInvVmMap() {
		return invVmMap;
	}

	boolean isVmInstantiated(String vm, TopologyNode node) {
        return node.equals(vmMap.get(vm));
    }

    NetConfiguration andSet(TopologyNode node, int state) {
        HashMap<TopologyNode, Integer> newStates = new HashMap<>(powerStates);
        newStates.put(node, state);
        return new NetConfiguration(
                newStates,
                vmMap, // TODO maybe copy?
                vms,
                sizes
        );
    }

    NetConfiguration andInstantiate(TopologyNode node, String vm) {
        HashMap<String, TopologyNode> newMap = new HashMap<>(vmMap);
        newMap.put(vm, node);
        return new NetConfiguration(
                powerStates, // TODO maybe copy
                newMap,
                vms,
                sizes
        );
    }

    private List<NetConfiguration> addSteps(NetConfGraph graph, Set<NetConfiguration> toSkip) {
        List<NetConfiguration> output = new ArrayList<>();

        for (Map.Entry<TopologyNode, Integer> entry : powerStates.entrySet()) {
            if (entry.getValue() == 0) {
                NetConfiguration destConf = this.andSet(entry.getKey(), 1);
                if (!toSkip.contains(destConf)) {
                    graph.addVertex(destConf);
                    output.add(destConf);
                }
                graph.addEdge(
                        new ConfLink.StateChangeLink(entry.getKey(), 1, this, destConf),
                        this,
                        destConf
                );
            }
        }
        for (Map.Entry<String, TopologyNode> entry : vmMap.entrySet()) {
            if (entry.getValue() == null) {
                String vm = entry.getKey();
                for (Map.Entry<TopologyNode, Integer> nodeEntry : powerStates.entrySet()) {
                    if (nodeEntry.getValue() == 0) {
                        continue;
                    }

                    TopologyNode node = nodeEntry.getKey();
                    if (!fits(vm, node)) {
                        continue;
                    }

                    NetConfiguration destConf = this.andInstantiate(node, vm);
                    if (!toSkip.contains(destConf)) {
                        graph.addVertex(destConf);
                        output.add(destConf);
                    }
                    graph.addEdge(
                            new ConfLink.VMInstantiationLink(node, vm, this, destConf),
                            this,
                            destConf
                    );
                }
            }
        }
        return output;
    }

    NetConfGraph makeConfigurationGraph() {
        NetConfGraph g = new NetConfGraph();
        g.addVertex(this);
        LinkedHashSet<NetConfiguration> frontier = new LinkedHashSet<>();
        Set<NetConfiguration> processed = new HashSet<>();
        frontier.add(this);
        while (!frontier.isEmpty()) {
            int prev = processed.size();
            Iterator<NetConfiguration> iterator = frontier.iterator();
            NetConfiguration current = iterator.next();
            iterator.remove();
            processed.add(current);
            List<NetConfiguration> newConfs = current.addSteps(g, processed);
            frontier.addAll(newConfs);
            if (log.isDebugEnabled()) {
                if (prev / 100 < processed.size() / 100) {
                    log.debug("Processed configuration node number {}.", (processed.size() / 100) * 100);
                }
                if (processed.size() > 10000) {
                    log.error("Too many nodes");
                    for (NetConfiguration netConfiguration : processed) {
                        log.debug("{}", netConfiguration);
                    }
                    throw new RuntimeException();
                }
            }
        }
        return g;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetConfiguration that = (NetConfiguration) o;

        return powerStates.equals(that.powerStates)
                && vmMap.equals(that.vmMap)
                && vms.equals(that.vms);
    }

    @Override
    public int hashCode() {
        int result = powerStates.hashCode();
        result = 31 * result + vmMap.hashCode();
        result = 31 * result + vms.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Configuration[States: %s, vmMap: %s]", powerStates, vmMap);
    }
}
