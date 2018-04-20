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
    private List<String> vms;
    private Map<String, VMSize> sizes;

    NetConfiguration(Map<TopologyNode, Integer> powerStates,
                     Map<String, TopologyNode> vmMap,
                     List<String> vms,
                     Map<String, VMSize> sizes) {
        this.powerStates = powerStates;
        this.vmMap = vmMap;
        this.vms = vms;
        this.sizes = sizes;
        this.invVmMap = new HashMap<>();
        for (Map.Entry<String, TopologyNode> entry: this.vmMap.entrySet()) {
            if (entry.getValue() != null) {
                invVmMap.putIfAbsent(entry.getValue(), new ArrayList<>());
                invVmMap.get(entry.getValue()).add(entry.getKey());
            }
        }
        for (Map.Entry<TopologyNode, List<String>> entry : invVmMap.entrySet()) {
            VMSize totalSize = VMSize.sum(
                    entry.getValue().stream().map(
                            sizes::get
                    ).toArray(VMSize[]::new));
            if (!totalSize.fitsIn(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format("Overloaded node %s. VMs: %s.", entry.getKey(), entry.getValue())
                );
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

    private NetConfiguration andSet(TopologyNode node, int state) {
        HashMap<TopologyNode, Integer> newStates = new HashMap<>(powerStates);
        newStates.put(node, state);
        return new NetConfiguration(
                newStates,
                new HashMap<>(vmMap),
                vms,
                sizes
        );
    }

    private NetConfiguration andInstantiate(TopologyNode node, String vm) {
        HashMap<String, TopologyNode> newMap = new HashMap<>(vmMap);
        newMap.put(vm, node);
        return new NetConfiguration(
                new HashMap<>(powerStates),
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
                    VMSize neededSize = VMSize.sum(
                            invVmMap.getOrDefault(node, Collections.emptyList()).stream().map(
                                    sizes::get
                            ).toArray(VMSize[]::new))
                            .sum(sizes.get(vm));
                    if (!neededSize.fitsIn(node)) {
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
                if (prev / 10 < processed.size() / 10) {
                    log.info("Processed configuration node number {}.", (processed.size() / 10) * 10);
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
