package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import cern.jet.math.IntFunctions;
import com.google.common.base.Functions;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.algorithms.ComputationSolution;
import it.nextworks.nfvmano.timeo.rc.algorithms.Formatter;
import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.TrafficCoefficientParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.VMSize;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Marco Capitani on 26/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class DijkstraFormatter extends Formatter {

    private static final Logger log = LoggerFactory.getLogger(DijkstraFormatter.class);

    public DijkstraFormatter(NetworkTopology topology,
                             List<String> vms,
                             Map<String, VMSize> sizes,
                             Map<LogicalLinkParameters, Double> logLinks,
                             Map<TrafficCoefficientParameters, Double> coefficients,
                             List<TopologyNode> sourceNodes,
                             Map<String, TopologyNode> vmPlacement, 
                             String operationID) {
        super(topology, vms, sizes, logLinks, coefficients, sourceNodes, new HashMap<>(vmPlacement), operationID);
        log.debug("Formatter initialization completed.");
    }

    private NetConfiguration extractStartingConfiguration() {
        Map<TopologyNode, Integer> powerStates = new HashMap<>();
        for (TopologyNode node : topology.nodes) {
            powerStates.put(node, (node.isOn()) ? 1 : 0);
        }
        for (String vm : vms) {
            //noinspection unchecked
            vmPlacement.putIfAbsent(
                    vm,
                    null
            );
        }
        return new NetConfiguration(powerStates, vmPlacement, vms, sizes);
    }

    private DirectedSparseGraph<TopologyNode, TopologyLink> makeTopologyGraph() {
        DirectedSparseGraph<TopologyNode, TopologyLink> g = new DirectedSparseGraph<>();
        for (TopologyNode node : topology.nodes) {
            g.addVertex(node);
        }
        for (TopologyLink link : topology.links) {
            g.addEdge(link, link.source, link.destination);
        }
        return g;
    }

    private Graph<Node, Link> makeGraph() {
        Graph<TopologyNode, TopologyLink> topologyGraph = makeTopologyGraph();
        return new LazyGraph(topologyGraph, logLinks.keySet());
    }

    Map<LogicalLinkParameters, List<Link>> internalSolve() throws OptimizationFailedException {
        DijkstraSolverSequential solver = new DijkstraSolverSequential(
                extractStartingConfiguration(),
                makeGraph(),
                logLinks,
                topology);
        log.debug("Starting path computation.");
        return solver.seqDijkstra();
    }

    @Override
    public ComputationSolution solve() throws ResourceAllocationSolutionNotFound {
        Map<LogicalLinkParameters, List<Link>> sol;
        try {
            sol = internalSolve();
        } catch (OptimizationFailedException e) {
            throw new ResourceAllocationSolutionNotFound(e);
        }
        // Collect config changes
        Map<ConfLink.ConfLinkType, List<ConfLink>> configLinks = sol.values().stream()
                .flatMap(Collection::stream)
                .filter(lnk -> lnk.type() == LinkType.CONFIGURATION)
                .map(lnk -> ((CLink) lnk).link)
                .collect(Collectors.groupingBy(cLink -> cLink.linkType));
        List<ConfLink.StateChangeLink> stateChangeLinks =
                configLinks.get(ConfLink.ConfLinkType.NODE_STATE_CHANGE).stream()
                        .map(lnk -> (ConfLink.StateChangeLink) lnk)
                        .collect(Collectors.toList());
        List<ConfLink.VMInstantiationLink> vmLink =
                configLinks.get(ConfLink.ConfLinkType.VM_INSTANTIATION).stream()
                        .map(lnk -> (ConfLink.VMInstantiationLink) lnk)
                        .collect(Collectors.toList());
        List<ConfLink.TrafficProcessingLink> processingLink =
                configLinks.get(ConfLink.ConfLinkType.TRAFFIC_PROCESSING).stream()
                        .map(lnk -> (ConfLink.TrafficProcessingLink) lnk)
                        .collect(Collectors.toList());

        // Generate node conf (i.e. turn on actions) and vm instantiations
        Map<TopologyNode, Integer> nodeConfs = stateChangeLinks.stream()
                .collect(Collectors.toMap(lnk -> lnk.node, lnk -> lnk.newState));
        Map<String, TopologyNode> instantiations = vmLink.stream()
                .collect(Collectors.toMap(lnk -> lnk.vmInstantiated, lnk -> lnk.node));

        // Generate paths
        Set<ComputationSolution.VMPath> paths = new HashSet<>();
        for (Map.Entry<LogicalLinkParameters, List<Link>> entry : sol.entrySet()) {
            LogicalLinkParameters lLink = entry.getKey();
            String actualSource = lLink.previousVMId != null ? lLink.previousVMId: lLink.sourceNodeId;
            TopologyNode sourceNode = instantiations.get(actualSource);
            TopologyNode destNode = instantiations.get(lLink.nextVMId);

            List<TopologyLink> path = entry.getValue().stream()
                    .filter(lnk -> lnk.type() == LinkType.TOPOLOGY)
                    .map(lnk -> ((TLink) lnk).link)
                    .collect(Collectors.toList());
            paths.add(new ComputationSolution.VMPath(
                    lLink.sourceNodeId,
                    actualSource,
                    lLink.nextVMId,
                    path,
                    sourceNode,
                    destNode
            ));
        }

        return new ComputationSolution(
                nodeConfs,
                instantiations,
                paths
        );
    }

    static class Node {
        TopologyNode node;
        NetConfiguration conf;
        LogicalLinkParameters endpointOf = null;

        Node(TopologyNode node, NetConfiguration conf) {
            this.node = node;
            this.conf = conf;
        }

        Node(Node base) {
            this(base.node, base.conf);
        }

        boolean isCandidateEndpoint(LogicalLinkParameters logLink) {
            return conf.isVmInstantiated(logLink.nextVMId, node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node1 = (Node) o;

            return node.equals(node1.node)
                    && conf.equals(node1.conf)
                    && (endpointOf != null ? endpointOf.equals(node1.endpointOf) : node1.endpointOf == null);
        }

        @Override
        public int hashCode() {
            int result = node.hashCode();
            result = 31 * result + conf.hashCode();
            result = 31 * result + (endpointOf != null ? endpointOf.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return String.format("MainNode[Node: %s, Conf: %s%s]",
                    node,
                    conf,
                    endpointOf != null ? ", endpoint of: " + endpointOf.toString() : ""
            );
        }
    }

    enum LinkType {
        TOPOLOGY,
        CONFIGURATION
    }

    interface Link {

        LinkType type();

        double weight(double traffic);

    }

    static class TLink implements Link {

        TopologyLink link;
        NetConfiguration conf;

        TLink(TopologyLink link, NetConfiguration conf) {
            this.link = link;
            this.conf = conf;
        }

        @Override
        public LinkType type() {
            return LinkType.TOPOLOGY;
        }

        @Override
        public double weight(double traffic) {
            if (!link.source.isOn() || !link.destination.isOn()) {
                return Double.POSITIVE_INFINITY;
            }
            return link.power * traffic;
        }

        @Override
        public String toString() {
            return String.format("MainLink[type: %s, topology link: %s]", type(), link);
        }
    }

    static class CLink implements Link {

        ConfLink link;
        TopologyNode node;

        CLink(ConfLink link, TopologyNode node) {
            this.link = link;
            this.node = node;
        }

        @Override
        public LinkType type() {
            return LinkType.CONFIGURATION;
        }

        @Override
        public double weight(double traffic) {
            return link.weight(traffic);
        }

        @Override
        public String toString() {
            return String.format("MainLink[type: %s, conf link: %s]", type(), link);
        }
    }
}
