package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

import java.util.*;

/**
 * Created by Marco Capitani on 28/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class NetConfGraph {
    private Graph<NetConfiguration, ConfLink> graph = new DirectedSparseGraph<>();
    private Map<Map.Entry<String, NetConfiguration>, List<ConfLink>> stateChanges = new HashMap<>();
    private Map<Map.Entry<String, NetConfiguration>, List<ConfLink>> vmInstantiations = new HashMap<>();
    private Map<Map.Entry<String, NetConfiguration>, List<ConfLink>> vmProcessing = new HashMap<>();

    NetConfGraph() {
    }

    void addVertex(NetConfiguration v) {
        graph.addVertex(v);
    }

    void addEdge(ConfLink e, NetConfiguration v1, NetConfiguration v2) {
        switch (e.linkType) {
            case NODE_STATE_CHANGE:
                stateChanges.putIfAbsent(new AbstractMap.SimpleEntry<>(e.node.nodeId, v1), new ArrayList<>());
                stateChanges.get(new AbstractMap.SimpleEntry<>(e.node.nodeId, v1)).add(e);
                break;
            case VM_INSTANTIATION:
                vmInstantiations.putIfAbsent(new AbstractMap.SimpleEntry<>(e.node.nodeId, v1), new ArrayList<>());
                vmInstantiations.get(new AbstractMap.SimpleEntry<>(e.node.nodeId, v1)).add(e);
                break;
            case TRAFFIC_PROCESSING:
                vmProcessing.putIfAbsent(new AbstractMap.SimpleEntry<>(e.node.nodeId, v1), new ArrayList<>());
                vmProcessing.get(new AbstractMap.SimpleEntry<>(e.node.nodeId, v1)).add(e);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unexpected link type: %s.", e.linkType));
        }
        graph.addEdge(e, v1, v2);
    }

    List<ConfLink> getChanges(String nodeId, NetConfiguration base) {
        if (!stateChanges.containsKey(new AbstractMap.SimpleEntry<>(nodeId, base))) {
            return Collections.emptyList();
        }
        return stateChanges.get(new AbstractMap.SimpleEntry<>(nodeId, base));
    }

    List<ConfLink> getInstantiations(String nodeId, NetConfiguration base) {
        if (!vmInstantiations.containsKey(new AbstractMap.SimpleEntry<>(nodeId, base))) {
            return Collections.emptyList();
        }
        return vmInstantiations.get(new AbstractMap.SimpleEntry<>(nodeId, base));
    }

    List<ConfLink> getProcessing(String nodeId, NetConfiguration base) {
        if (!vmProcessing.containsKey(new AbstractMap.SimpleEntry<>(nodeId, base))) {
            return Collections.emptyList();
        }
        return vmProcessing.get(new AbstractMap.SimpleEntry<>(nodeId, base));
    }

    Collection<NetConfiguration> getVertices() {
        return graph.getVertices();
    }

    NetConfiguration getDest(ConfLink e) {
        return e.destination;
    }

    Collection<ConfLink> getOutEdges(NetConfiguration v) {
        return graph.getOutEdges(v);
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
