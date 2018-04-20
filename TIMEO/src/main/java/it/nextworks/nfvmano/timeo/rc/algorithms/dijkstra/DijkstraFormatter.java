package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

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

/**
 * Created by Marco Capitani on 26/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class DijkstraFormatter extends Formatter {

    private static final Logger log = LoggerFactory.getLogger(DijkstraFormatter.class);

    DijkstraFormatter(NetworkTopology topology,
                             List<String> vms,
                             Map<String, VMSize> sizes,
                             Map<LogicalLinkParameters, Double> logLinks,
                             Map<TrafficCoefficientParameters, Double> coefficients,
                             List<TopologyNode> sourceNodes,
                             Map<String, TopologyNode> vmPlacement, 
                             String operationID) {
        super(topology, vms, sizes, logLinks, coefficients, sourceNodes, vmPlacement, operationID);
        log.debug("Formatter initialization completed.");
    }

    private NetConfiguration extractStartingConfiguration() {
        Map<TopologyNode, Integer> powerStates = new HashMap<>();
        Map<String, TopologyNode> vmMap = new HashMap<>();
        for (TopologyNode node : topology.nodes) {
            powerStates.put(node, (node.isOn()) ? 1 : 0);
        }
        for (String vm : vms) {
            vmMap.put(vm, null);
        }
        return new NetConfiguration(powerStates, vmMap, vms, sizes);
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
        NetConfiguration startingConf = extractStartingConfiguration();
        log.debug("Starting configuration is: {}.", startingConf);
        NetConfGraph confGraph = startingConf.makeConfigurationGraph();
        log.debug("Configuration graph is {}", confGraph);
        Graph<TopologyNode, TopologyLink> topologyGraph = makeTopologyGraph();
        log.info("Topology graph is {}", topologyGraph);

        Graph<Node, Link> g = new DirectedSparseGraph<>();
        LinkedList<Node> frontier = new LinkedList<>();
        for (TopologyNode topologyNode : topology.nodes) {
            for (NetConfiguration netConf : confGraph.getVertices()) {
                // We create all of the graph's vertices right away.
                // We will never add a vertex later, hence all errors will raise exceptions.
                Node node = new Node(topologyNode, netConf);
                g.addVertex(node);
                frontier.add(node);
            }
        }
        while (!frontier.isEmpty()) {
            Node current = frontier.removeFirst();
            List<TopologyNode> descendants = new ArrayList<>();
            for (TopologyLink topologyLink : topologyGraph.getOutEdges(current.node)) {
                descendants.add(topologyLink.destination);
                Node destNode = new Node(topologyLink.destination, current.conf);
                g.addEdge(new TLink(topologyLink),
                        current,
                        destNode
                );
            }
            for (TopologyNode descendant : descendants) {
                for (ConfLink confLink : confGraph.getChanges(descendant.nodeId, current.conf)) {
                        Node destNode = new Node(current.node, confGraph.getDest(confLink));
                        g.addEdge(new CLink(confLink),
                                current,
                                destNode
                        );
                    }

            }
            for (ConfLink confLink : confGraph.getInstantiations(current.node.nodeId, current.conf)) {
                    Node destNode = new Node(current.node, confGraph.getDest(confLink));
                    g.addEdge(new CLink(confLink),
                            current,
                            destNode
                    );
                }

            for (ConfLink confLink : confGraph.getProcessing(current.node.nodeId, current.conf)) {
                Node destNode = new Node(current.node, confGraph.getDest(confLink));
                g.addEdge(new CLink(confLink),
                        current,
                        destNode
                );
            }
        }
        log.debug("Main graph is {}", g);
        return g;
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
        //TODO
        return null;
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

    private static class TLink implements Link {

        private TopologyLink link;

        private TLink(TopologyLink link) {
            this.link = link;
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

        CLink(ConfLink link) {
            this.link = link;
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
