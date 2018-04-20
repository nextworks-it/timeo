package it.nextworks.nfvmano.timeo.rc.algorithms.emma;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.algorithms.ComputationSolution;
import it.nextworks.nfvmano.timeo.rc.algorithms.Formatter;
import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.TrafficCoefficientParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.VMSize;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Marco Capitani on 19/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class LPFormatter extends Formatter {

    private static final Logger log = LoggerFactory.getLogger(LPFormatter.class);

    private ProblemState prevState = null;
    private ProblemState state;

    private ComputationSolution solution = null;

    private RunnerSolution lastSol = null;

    private OptimizationFailedException exception = null;

    private NetworkTopology currentTopology;
    private Map<String, TopologyNode> currentVmPlacement;
    private Map<String, TopologyNode> previousVmPlacement;
    private Map<TopologyNode, Integer> nodeConfs = new HashMap<>();
    private Map<String, TopologyNode> instantiations = new HashMap<>();

    public LPFormatter(NetworkTopology topology,
                List<String> vms,
                Map<String, VMSize> sizes,
                Map<LogicalLinkParameters, Double> logLinks,
                Map<TrafficCoefficientParameters, Double> coefficients,
                List<TopologyNode> sourceNodes,
                Map<String, TopologyNode> vmPlacement,
                String operationID) {
        super(topology, vms, sizes, logLinks, coefficients, sourceNodes, vmPlacement, operationID);
        for (TopologyNode node : topology.nodes) {
            TopologyLink loopbackLink = new TopologyLink(
                    "lo:" + node.nodeId,
                    node,
                    node,
                    null,
                    null,
                    0.1, 1000000000
            );
            topology.links.add(loopbackLink);
            TopologyCp loopbackInterface = new TopologyCp(node, loopbackLink, loopbackLink,
                    "lo:" + node.nodeId, "lo:" + node.nodeId);
            node.cps.add(loopbackInterface);
            loopbackLink.sourceCp = loopbackInterface;
            loopbackLink.destinationCp = loopbackInterface;
        }
        this.currentVmPlacement = new HashMap<>(vmPlacement);
        if (currentVmPlacement.keySet().containsAll(vms)) {
            this.state = ProblemState.INITIAL_TRY_VMS;
        } else {
            this.state = ProblemState.INITIAL_ASSIGN_VMS;
        }
        this.currentTopology = clone(topology);
    }

    private static NetworkTopology clone(NetworkTopology topology) {
        List<TopologyNode> nodes = new ArrayList<>();
        List<TopologyLink> links  = new ArrayList<>();
        HashMap<String, TopologyNode> nodeId2Node = new HashMap<>();
        HashMap<String, TopologyLink> linkId2Link = new HashMap<>();
        for (TopologyNode node : topology.nodes) {
            TopologyNode newNode = node.getCloneNoCps();
            nodes.add(newNode);
            nodeId2Node.put(newNode.nodeId, newNode);
        }
        for (TopologyLink link : topology.links) {
            TopologyLink newLink = new TopologyLink(
                    link.linkId,
                    nodeId2Node.get(link.source.nodeId),
                    nodeId2Node.get(link.destination.nodeId),
                    null,
                    null,
                    link.power,
                    link.bandwidth);
            links.add(newLink);
            linkId2Link.put(newLink.toString(), newLink);
        }
        for (TopologyNode node : topology.nodes) {
            for (TopologyCp cp : node.cps) {
                TopologyCp newCp = new TopologyCp(cp.node, cp.outgoingLink, cp.incomingLink, cp.address, cp.cpId);
                nodeId2Node.get(node.nodeId).cps.add(newCp);
                if (cp.outgoingLink != null) {
                    linkId2Link.get(cp.outgoingLink.toString()).sourceCp = newCp;
                }
                if (cp.incomingLink != null) {
                    linkId2Link.get(cp.incomingLink.toString()).destinationCp = newCp;
                }
            }
        }
        NetworkTopology output = new NetworkTopology(nodes, links);
        output.processing = topology.processing;
        return output;
    }

    @Override
    public ComputationSolution solve() throws ResourceAllocationSolutionNotFound {
        log.info("Starting processing of request {}.", operationID);
        while(!state.equals(ProblemState.SOLVED)) {
            LPRunner runner;
            log.debug("Request {}: node confs {}; VM map {}.", operationID, nodeConfs, currentVmPlacement);
            switch (state) {
                case INITIAL_ASSIGN_VMS:
                    // Node states are given, let's find the vm placement
                    runner = makeRunner();
                    try {
                        lastSol = runner.algorithmRun(false, false);
                        afterInitialAssignVm();
                    } catch (OptimizationFailedException e) {
                        // If we can't solve it, we have to relax the nodes
                        transitionToAssignNodes();
                    }
                    break;
                case INITIAL_TRY_VMS:
                    // Current configuration is complete,
                    // Let's see if the problem can be solved.
                    runner = makeRunner();
                    try {
                        lastSol = runner.algorithmRun(false, true);
                        transitionToSolved();
                    } catch (OptimizationFailedException e) {
                        // If we can't solve it, then we have to relax the nodes.
                        transitionToAssignNodes();
                    }
                    break;
                case ASSIGN_NODES:
                    // We have to find out the nodes
                    runner = makeRunner();
                    try {
                        lastSol = runner.algorithmRun(true, false);
                        afterAssignNodes();
                    } catch (OptimizationFailedException e) {
                        if (e.getMessage().equals("Got all zero node configurations.")) {
                            restoreVmPlacement();
                        } else {
                            transitionToFailed(e);
                        }
                    }
                    break;
                case NEW_CONF_ASSIGN_VMS:
                    // Nodes are give, find vms
                    runner = makeRunner();
                    try {
                        lastSol = runner.algorithmRun(false, false);
                        afterNewConfAssignVM();
                    } catch (OptimizationFailedException e) {
                        backToAssignNodes(e);
                    }
                    break;
                case NEW_CONF_TRY_VMS:
                    runner = makeRunner();
                    try {
                        lastSol = runner.algorithmRun(false, true);
                        transitionToSolved();
                    } catch (OptimizationFailedException e) {
                        backToAssignNodes(e);
                    }
                    break;
                case FAILED:
                    log.error("Cannot compute solution: not enough resources.");
                    log.debug("Failure details: {}. Cause: ", this.dump(), exception);
                    throw new ResourceAllocationSolutionNotFound("Not enough resources.", exception);
                default:
                    throw new IllegalStateException("Unexpected state: " + state.toString() + ".");
            }
        }
        log.info("Solution found.");
        return solution;
    }

    private LPRunner makeRunner() {
        return new LPRunner(
                currentTopology,
                vms,
                sizes,
                logLinks,
                coefficients,
                sourceNodes,
                currentVmPlacement
        );
    }

    private void restoreVmPlacement() {
        currentVmPlacement = new HashMap<>(previousVmPlacement);
        updateState(ProblemState.ASSIGN_NODES);
        // Not resetting the vm placement, in order to force the algo to turn on more nodes
        log.debug("Request {}: got all zero configuration.", operationID);
        log.debug("Restoring VM placement in order to force the algorithm to turn on more nodes.");
    }

    private void afterInitialAssignVm() {
        double random = Math.random();
        for (Map.Entry<Map.Entry<String, TopologyNode>, Double> entry : lastSol.instantiations.entrySet()) {
            random = random - entry.getValue();
            if (random < 0) {
                String vm = entry.getKey().getKey();
                TopologyNode node = entry.getKey().getValue();
                currentVmPlacement.put(vm, node);
                instantiations.put(vm, node);
                log.debug("Request {}: allocated VM {} on node {}.", operationID, vm, node);
                break;
            }
        }
        if (random > 0 ) {
            throw new IllegalStateException("Random choice failed.");
        }
        if (currentVmPlacement.keySet().containsAll(vms)) {
            updateState(ProblemState.INITIAL_TRY_VMS);
        }
    }

    private void transitionToSolved() {
        solution = new ComputationSolution(
                nodeConfs,
                instantiations,
                new HashSet<>(lastSol.paths.values())
        );
        updateState(ProblemState.SOLVED);
        log.info("Request {} computed successfully.", operationID);
        log.debug("Paths: {}.", lastSol.paths);
    }

    private void transitionToAssignNodes() {
        // Reset configurations and instantiations.
        instantiations.clear();
        backToAssignNodes(new OptimizationFailedException("All nodes already turned on, not enough resources."));
    }

    private void transitionToFailed(OptimizationFailedException e) {
        exception = e;
        updateState(ProblemState.FAILED);
        log.debug("Request {}: failed. Cause: ", operationID, e);
    }

    private void afterNewConfAssignVM() {
        double random = Math.random();
        for (Map.Entry<Map.Entry<String, TopologyNode>, Double> entry : lastSol.instantiations.entrySet()) {
            random = random - entry.getValue();
            if (random < 0) {
                String vm = entry.getKey().getKey();
                TopologyNode node = entry.getKey().getValue();
                currentVmPlacement.put(vm, node);
                instantiations.put(vm, node);
                log.debug("Request {}: allocated VM {} on node {}.", operationID, vm, node);
                break;
            }
        }
        if (random > 0 ) {
            throw new IllegalStateException("Random choice failed.");
        }
        if (currentVmPlacement.keySet().containsAll(vms)) {
            updateState(ProblemState.NEW_CONF_TRY_VMS);
        }
    }

    private void afterAssignNodes() {
        double random = Math.random();
        for (Map.Entry<TopologyNode, Double> entry : lastSol.nodeConfs.entrySet()) {
            random = random - entry.getValue();
            if (random < 0) {
                TopologyNode node = entry.getKey();
                TopologyNode topoNode;
                try {
                    //noinspection ConstantConditions
                    topoNode =
                            currentTopology.nodes.stream().filter((n) -> n.equals(node)).findAny().get();
                } catch (NoSuchElementException e) {
                    throw new IllegalStateException(String.format(
                            "Node %s is being configured, but is not in the topology.",
                            node
                    ));
                }
                topoNode.turnOn();
                nodeConfs.put(topoNode, 1);
                log.debug("Request {}: turning on node {}.", operationID, node);
                break;
            }
        }
        if (random > 0 ) {
            throw new IllegalStateException("Random choice failed.");
        }
        updateState(ProblemState.NEW_CONF_ASSIGN_VMS);
    }

    private void backToAssignNodes(OptimizationFailedException e) {
        previousVmPlacement = new HashMap<>(currentVmPlacement);
        boolean noMoreNodes = true;
        Iterator<TopologyNode> iterator = currentTopology.nodes.iterator();
        while (noMoreNodes && iterator.hasNext()) {
            TopologyNode node = iterator.next();
            noMoreNodes = node.isOn();
        }
        if (noMoreNodes) {
            transitionToFailed(e);
            return;
        }
        currentVmPlacement = new HashMap<>(vmPlacement);
        updateState(ProblemState.ASSIGN_NODES);
        log.debug("Request {}: current configuration not feasible. " +
                "Returning to node configuration phase.", operationID);
    }

    private String dump() {
        return String.format(
                "State prior to failure: %s",
                prevState.toString()
        );
    }

    private void updateState(ProblemState newState) {
        prevState = state;
        state = newState;
    }

    private enum ProblemState {
        INITIAL_ASSIGN_VMS,
        INITIAL_TRY_VMS,
        ASSIGN_NODES,
        NEW_CONF_ASSIGN_VMS,
        NEW_CONF_TRY_VMS,
        SOLVED,
        FAILED
    }
}
