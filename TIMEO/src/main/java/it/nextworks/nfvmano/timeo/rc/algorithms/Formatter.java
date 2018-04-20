package it.nextworks.nfvmano.timeo.rc.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.*;

/**
 * Created by Marco Capitani on 26/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public abstract class Formatter {

    private static final Logger log = LoggerFactory.getLogger(Formatter.class);

    protected NetworkTopology topology;
    protected List<String> vms;
    protected Map<String, VMSize> sizes;
    protected Map<LogicalLinkParameters, Double> logLinks;
    protected Map<TrafficCoefficientParameters, Double> coefficients;
    protected List<TopologyNode> sourceNodes;
    protected Map<String, TopologyNode> vmPlacement;
    protected String operationID;

    public Formatter(NetworkTopology topology,
                     List<String> vms,
                     Map<String, VMSize> sizes,
                     Map<LogicalLinkParameters, Double> logLinks,
                     Map<TrafficCoefficientParameters, Double> coefficients,
                     List<TopologyNode> sourceNodes,
                     Map<String, TopologyNode> vmPlacement,
                     String operationID) {
        this.sizes = sizes;
        this.vms = vms;
        this.coefficients = coefficients;
        this.sourceNodes = sourceNodes;
        this.topology = topology;
        this.logLinks = logLinks;
        this.vmPlacement = vmPlacement;
        this.operationID = operationID;
        log.debug("Instantiated solver for request {}.", operationID);
        log.debug("Parameters:\n" +
                        "Topology: {}\n" +
                        "Vms: {}\n" +
                        "Sizes: {}\n" +
                        "Loglinks: {}\n" +
                        "Coeffs: {}\n" +
                        "Placement: {}\n" +
                        "Source nodes: {}",
                topology, vms, sizes, logLinks, coefficients, vmPlacement, sourceNodes);
        validateInput();
        // TODO might want to migrate to coefficient-based graph generation instead of validation
    }

    public abstract ComputationSolution solve() throws ResourceAllocationSolutionNotFound;

    private void validateInput() {
        Set<String> sizesKeys = new HashSet<>(sizes.keySet());
        for (String vm : vms) {
            if (!sizesKeys.remove(vm)) {
                throw new IllegalArgumentException(String.format("VM %s size unspecified", vm));
            }
        }
        if (!sizesKeys.isEmpty()) {
            throw new IllegalArgumentException(String.format("Extra sizes specified for vms %s", sizesKeys));
        }
        for (Map.Entry<String, TopologyNode> entry : vmPlacement.entrySet()) {
            if (!vms.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format(
                        "Vm named %s placed on node %s, but not declared. Vm list: %s.",
                        entry.getKey(), entry.getValue(), vms)
                );
            }
            if (!topology.nodes.contains(entry.getValue())) {
                throw new IllegalArgumentException(String.format(
                        "Vm named %s placed on node %s, but node is not in topology. Nodes list: %s.",
                        entry.getKey(), entry.getValue(), topology.nodes)
                );
            }
        }
        for (Map.Entry<LogicalLinkParameters, Double> entry : logLinks.entrySet()) {
            LogicalLinkParameters parameter = entry.getKey();
            Double value = entry.getValue();
            if (parameter.nextVMId.equals(parameter.previousVMId)) {
                throw new IllegalArgumentException(String.format(
                        "There cannot be logical links between a VM and itself. " +
                                "Found with source node %s and VM %s.",
                        parameter.sourceNodeId, parameter.previousVMId
                ));
            }
            if (value < 0) {
                throw new IllegalArgumentException(String.format(
                        "Log link for entry %s, previous VM %s and next %s is less than zero.",
                        parameter.sourceNodeId, parameter.previousVMId, parameter.nextVMId
                ));
            }
            if (null == parameter.previousVMId) {
                // Nothing to check.
                continue;
            }
            Double total = value;
            String nodeId = parameter.sourceNodeId;
            String previousVM = parameter.previousVMId;
            String nextVM = parameter.nextVMId;
            log.debug("Parsing ({}, {}, {})", nodeId, previousVM, nextVM);
            log.info("Total: {}.", total);
            total = total - (
                    logLinks.getOrDefault(
                            new LogicalLinkParameters(nodeId, null, previousVM), 0D)
                            * coefficients.getOrDefault(
                            new TrafficCoefficientParameters(previousVM, previousVM, nextVM), 0D)
            );
            log.info("Subtracted entry flows. Total: {}.", total);
            for (String otherVm : vms) {
                total = total - (
                        logLinks.getOrDefault(
                                new LogicalLinkParameters(nodeId, otherVm, previousVM), 0D)
                                * coefficients.getOrDefault(
                                new TrafficCoefficientParameters(otherVm, previousVM, nextVM), 0D)
                );
                log.info("Subtracted flow ({}, {}, {}) multiplied by ({}, {}, {}). Total: {}.",
                        nodeId, otherVm, previousVM, otherVm, previousVM, nextVM, total);
            }
            if (total > 0.0000001 || total < -0.0000001) {
                throw new IllegalArgumentException(
                        String.format("Logical links and coefficient do not agree. Flow conservation for " +
                                        "node %s, previousVM %s and next %s off by %s.",
                                nodeId, previousVM, nextVM, total));
            }
        }
    }



    @FunctionalInterface
    public interface FormatterSupplier {

        Formatter makeFormatter(NetworkTopology topology,
                                List<String> vms,
                                Map<String, VMSize> sizes,
                                Map<LogicalLinkParameters, Double> logLinks,
                                Map<TrafficCoefficientParameters, Double> coefficients,
                                List<TopologyNode> sourceNodes,
                                Map<String, TopologyNode> vmPlacement,
                                String operationID);
    }
}
