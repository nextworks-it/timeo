package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra.DijkstraFormatter.Link;
import it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra.DijkstraFormatter.Node;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marco Capitani on 12/05/18.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class LazyGraph implements Graph<Node,Link> {

    private static void mne() {
        throw new RuntimeException(new MethodNotImplementedException());
    }

    private Graph<TopologyNode, TopologyLink> topologyGraph;
    private Collection<LogicalLinkParameters> logLinks;

    LazyGraph(Graph<TopologyNode, TopologyLink> topologyGraph,
                     Collection<LogicalLinkParameters> logLinks) {
        this.topologyGraph = topologyGraph;
        this.logLinks = logLinks;
    }

    @Override
    public Collection<Link> getInEdges(Node node) {
        mne();
        return null;
    }

    @Override
    public Collection<Link> getOutEdges(Node node) {
        if (node.endpointOf != null) {
            return Collections.emptyList();
        }
        NetConfiguration conf = node.conf;
        TopologyNode topologyNode = node.node;
        List<Link> output = new ArrayList<>();
        List<TopologyNode> neighbours = new ArrayList<>();
        for (TopologyLink link : topologyGraph.getOutEdges(topologyNode)) {
            output.add(new DijkstraFormatter.TLink(link, conf));
            neighbours.add(link.opposite(topologyNode));
        }

        // Turn on neighbours
        for (TopologyNode neighbour : neighbours) {
            if (conf.getState(neighbour) == 0) {
                output.add(new DijkstraFormatter.CLink(
                        new ConfLink.StateChangeLink(
                                neighbour, 1,
                                conf,
                                conf.andSet(neighbour, 1)
                        ),
                        topologyNode
                ));
            }
        }

        // Instantiate on current node
        for (String vm : conf.getVms()) {
            if (conf.getCompute(vm) == null && conf.fits(vm, topologyNode)) {
                output.add(new DijkstraFormatter.CLink(
                        new ConfLink.VMInstantiationLink(
                                topologyNode, vm,
                                conf,
                                conf.andInstantiate(topologyNode, vm)
                        ),
                        topologyNode
                ));
            }
        }

        // Process on vm on current node
        for (LogicalLinkParameters logLink : logLinks) {
            if (node.isCandidateEndpoint(logLink)) {
                DijkstraFormatter.Node candidate = new DijkstraFormatter.Node(node);
                candidate.endpointOf = logLink;
                output.add(new DijkstraFormatter.CLink(
                        new ConfLink.TrafficProcessingLink(
                                candidate.node,
                                logLink.nextVMId,
                                node.conf,
                                candidate.conf,
                                logLink
                        ),
                        topologyNode
                ));
            }
        }

        return output;
    }

    @Override
    public Collection<Node> getPredecessors(Node node) {
        mne();
        return null;
    }

    @Override
    public Collection<Node> getSuccessors(Node node) {
        return getOutEdges(node).stream()
                .map(l -> getOpposite(node, l))
                .collect(Collectors.toSet());
    }

    @Override
    public int inDegree(Node node) {
        mne();
        return 0;
    }

    @Override
    public int outDegree(Node node) {
        return getOutEdges(node).size();
    }

    @Override
    public boolean isPredecessor(Node node, Node v1) {
        mne();
        return false;
    }

    @Override
    public boolean isSuccessor(Node node, Node v1) {
        return getSuccessors(node).contains(v1);
    }

    @Override
    public int getPredecessorCount(Node node) {
        mne();
        return 0;
    }

    @Override
    public int getSuccessorCount(Node node) {
        return getSuccessors(node).size();
    }

    @Override
    public Node getSource(Link link) {
        switch (link.type()) {
            case TOPOLOGY:
                TopologyLink tLink = ((DijkstraFormatter.TLink) link).link;
                return new Node(tLink.source, ((DijkstraFormatter.TLink) link).conf);
            case CONFIGURATION:
                ConfLink cLink = ((DijkstraFormatter.CLink) link).link;
                return new Node(((DijkstraFormatter.CLink) link).node, cLink.source);
            default:
                throw new IllegalArgumentException(String.format("Unknown link type %s", link.type()));
        }
    }

    @Override
    public Node getDest(Link link) {
        return getOpposite(getSource(link), link);
    }

    @Override
    public boolean isSource(Node node, Link link) {
        return node.equals(getSource(link));
    }

    @Override
    public boolean isDest(Node node, Link link) {
        return node.equals(getDest(link));
    }

    @Override
    public boolean addEdge(Link link, Node node, Node v1) {
        mne();
        return false;
    }

    @Override
    public boolean addEdge(Link link, Node node, Node v1, EdgeType edgeType) {
        mne();
        return false;
    }

    @Override
    public Pair<Node> getEndpoints(Link link) {
        return new Pair<>(getSource(link), getDest(link));
    }

    @Override
    public Node getOpposite(Node node, Link link) {
        switch (link.type()) {
            case TOPOLOGY:
                TopologyLink tLink = ((DijkstraFormatter.TLink) link).link;
                if (tLink.source.equals(node.node)) {
                    Node opp = new Node(node);
                    opp.node = tLink.destination;
                    return opp;
                } else if (tLink.destination.equals(node.node)) {
                    Node opp = new Node(node);
                    opp.node = tLink.source;
                    return opp;
                } else {
                    throw new IllegalArgumentException(String.format("%s is not an endpoint of %s", node, link));
                }
            case CONFIGURATION:
                ConfLink cLink = ((DijkstraFormatter.CLink) link).link;
                if (!node.conf.equals(cLink.source)) {
                    throw new IllegalArgumentException(String.format("node %s is not src of %s", node, link));
                }
                Node opp = new Node(node);
                NetConfiguration conf = node.conf;
                switch (cLink.linkType) {
                    case VM_INSTANTIATION:
                        ConfLink.VMInstantiationLink vmLink = (ConfLink.VMInstantiationLink) cLink;
                        opp.conf = conf.andInstantiate(vmLink.node, vmLink.vmInstantiated);
                        break;
                    case NODE_STATE_CHANGE:
                        ConfLink.StateChangeLink stateLink = (ConfLink.StateChangeLink) cLink;
                        opp.conf = conf.andSet(stateLink.node, stateLink.newState);
                        break;
                    case TRAFFIC_PROCESSING:
                        if (node.endpointOf != null) {
                            opp.endpointOf = null;
                        } else {
                            ConfLink.TrafficProcessingLink trafficLink = (ConfLink.TrafficProcessingLink) cLink;
                            opp.endpointOf = trafficLink.logLink;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(String.format("Unknown conf link type %s", cLink.linkType));
                }
                return opp;
            default:
                throw new IllegalArgumentException(String.format("Unknown link type %s", link.type()));
        }
    }

    @Override
    public Collection<Link> getEdges() {
        mne();
        return null;
    }

    @Override
    public Collection<Node> getVertices() {
        mne();
        return null;
    }

    @Override
    public boolean containsVertex(Node node) {
        mne();
        return false;
    }

    @Override
    public boolean containsEdge(Link link) {
        mne();
        return false;
    }

    @Override
    public int getEdgeCount() {
        mne();
        return 0;
    }

    @Override
    public int getVertexCount() {
        mne();
        return 0;
    }

    @Override
    public Collection<Node> getNeighbors(Node node) {
        mne();
        return null;
    }

    @Override
    public Collection<Link> getIncidentEdges(Node node) {
        mne();
        return null;
    }

    @Override
    public Collection<Node> getIncidentVertices(Link link) {
        return getEndpoints(link);
    }

    @Override
    public Link findEdge(Node node, Node v1) {
        mne();
        return null;
    }

    @Override
    public Collection<Link> findEdgeSet(Node node, Node v1) {
        mne();
        return null;
    }

    @Override
    public boolean addVertex(Node node) {
        mne();
        return false;
    }

    @Override
    public boolean addEdge(Link link, Collection<? extends Node> collection) {
        mne();
        return false;
    }

    @Override
    public boolean addEdge(Link link, Collection<? extends Node> collection, EdgeType edgeType) {
        mne();
        return false;
    }

    @Override
    public boolean removeVertex(Node node) {
        mne();
        return false;
    }

    @Override
    public boolean removeEdge(Link link) {
        mne();
        return false;
    }

    @Override
    public boolean isNeighbor(Node node, Node v1) {
        mne();
        return false;
    }

    @Override
    public boolean isIncident(Node node, Link link) {
        return getEndpoints(link).contains(node);
    }

    @Override
    public int degree(Node node) {
        mne();
        return 0;
    }

    @Override
    public int getNeighborCount(Node node) {
        mne();
        return 0;
    }

    @Override
    public int getIncidentCount(Link link) {
        return 2;
    }

    @Override
    public EdgeType getEdgeType(Link link) {
        return EdgeType.DIRECTED;
    }

    @Override
    public EdgeType getDefaultEdgeType() {
        return EdgeType.DIRECTED;
    }

    @Override
    public Collection<Link> getEdges(EdgeType edgeType) {
        mne();
        return null;
    }

    @Override
    public int getEdgeCount(EdgeType edgeType) {
        mne();
        return 0;
    }
}