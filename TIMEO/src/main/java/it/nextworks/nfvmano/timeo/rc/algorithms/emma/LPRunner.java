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
package it.nextworks.nfvmano.timeo.rc.algorithms.emma;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;
import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.TrafficCoefficientParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.VMSize;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Marco Capitani on 11/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class LPRunner {

    private static final Logger log = LoggerFactory.getLogger(LPRunner.class);

    private static final double DEFAULT_MAX_UPPER_BOUND = 1E9;
    private static final double DEFAULT_COMPUTATIONAL_CAPACITY = 1E11;

    private NetworkTopology topology;
    private List<String> vms;
    private Map<String, VMSize> sizes;
    private Map<LogicalLinkParameters, Double> logLinks;
    private Map<TrafficCoefficientParameters, Double> coefficients;
    private Map<String, TopologyNode> sourceNodes;

    private List<TopologyNode> edgeNodes;
    private List<TopologyNode> coreNodes;
    private Map<TopologyNode, Set<String>> vmsPerNode;
    private Map<String, TopologyNode> vmPlacement;

    private Map<Integer, Variable> variableMap = new HashMap<>();
    private Map<Variable, Integer> invVarMap = new HashMap<>();

    LPRunner(NetworkTopology topology, List<String> vms, Map<String, VMSize> sizes,
             Map<LogicalLinkParameters, Double> logLinks, Map<TrafficCoefficientParameters, Double> coefficients,
             List<TopologyNode> sourceNodes, Map<String, TopologyNode> vmPlacement){
        this.sizes = sizes;
        this.vms = vms;
        this.coefficients = coefficients;
        this.sourceNodes = sourceNodes.stream().collect(Collectors.toMap((n) -> n.nodeId, Function.identity()));
        this.topology = topology;
        this.logLinks = logLinks;
        this.vmsPerNode = new HashMap<>();
        this.vmPlacement = new HashMap<>();
        vmPlacement.forEach(this::placeVm);
        edgeNodes = topology.nodes.stream().filter(
                (n) -> n.vCPUs == 0 || n.hddSize == 0 || n.memory == 0
        ).collect(Collectors.toList());
        coreNodes = topology.nodes.stream().filter(
                (n) -> !edgeNodes.contains(n)
        ).collect(Collectors.toList());
        for (TopologyNode source : sourceNodes) {
            if (!edgeNodes.contains(source)) {
                throw new IllegalArgumentException(String.format(
                        "Declared source node %s not in edge nodes.", source
                ));
            }
        }
        for (Map.Entry<TopologyNode, Set<String>> entry : vmsPerNode.entrySet()) {
            if (!entry.getKey().isOn()) {
                throw new IllegalStateException(String.format(
                        "Vms %s instantiated on node %s, which is off.",
                        entry.getValue(), entry.getKey()
                ));
            }
            List<VMSize> sizesList = entry.getValue().stream().map(sizes::get).collect(Collectors.toList());
            VMSize currentSize = VMSize.sum(sizesList);
            if (!currentSize.fitsIn(entry.getKey())) {
                throw new IllegalArgumentException(String.format(
                        "Unacceptable placement provided. Node %s overloaded with %s.",
                        entry.getKey(), entry.getValue()
                ));
            }
        }
    }

    RunnerSolution algorithmRun(boolean nodesUnlocked, boolean modelIsComplete)
            throws OptimizationFailedException {
        log.debug("Starting LP iteration.");
        int N = generateVariableMap(nodesUnlocked, modelIsComplete);

        double[] c = generateC(N);

        double[][] eqConstr = generateConstraints(N, modelIsComplete);
        double[][] A = new double[eqConstr.length][N];
        double[] b = new double[eqConstr.length];
        splitConstr(eqConstr, A, b);

        double[][] ineqConstr = generateIneqConstraints(N, nodesUnlocked, modelIsComplete);
        double[][] G = new double[ineqConstr.length][N];
        double[] h = new double[ineqConstr.length];
        splitConstr(ineqConstr, G, h);

        double[] ub = generateUb(N);

        double[] lb = generateLb(N);

//        log.info(
//                "Calling solver with nodes {}unlocked and model {}complete:\n" +
//                        "varMap = {}\n" +
//                        "c = {}\n" +
//                        "A = {}\n" +
//                        "b = {}\n" +
//                        "G = {}\n" +
//                        "h = {}\n" +
//                        "lb = {}\n" +
//                        "ub = {}\n",
//                nodesUnlocked ? "" : "not ",
//                modelIsComplete ? "" : "not ",
//                variableMap, c, A, b, G, h, lb, ub
//        );

        Solver solver = new JOctaveSolver(c, A, b, ub, lb, G, h);
        double[] sol = solver.solve();
        log.debug("LP iteration completed successfully.");
        if (log.isDebugEnabled()) {
            if (nodesUnlocked) {
                List<Map.Entry<NodeConfiguration, Double>> confs =
                        RunnerSolution.convertMap(variableMap, NodeConfiguration.class)
                                .map((e) -> new AbstractMap.SimpleEntry<>(e.getValue(), sol[e.getKey()]))
                                .collect(Collectors.toList());
//                log.info("Node configurations: {}.", confs);
            } else if (!modelIsComplete) {
                List<Map.Entry<VmInstantiation, Double>> confs =
                        RunnerSolution.convertMap(variableMap, VmInstantiation.class)
                                .map((e) -> new AbstractMap.SimpleEntry<>(e.getValue(), sol[e.getKey()]))
                                .collect(Collectors.toList());
//                log.info("VM instantiations: {}.", confs);
                if (confs.isEmpty()) {
                    throw new IllegalStateException("");
                }
            } else {
                List<Map.Entry<Flow, Double>> confs =
                        RunnerSolution.convertMap(variableMap, Flow.class)
                                .map((e) -> new AbstractMap.SimpleEntry<>(e.getValue(), sol[e.getKey()]))
                                .collect(Collectors.toList());
//                log.info("Flows: {}.", confs);
            }
            Map<Object, Object> solutionMap = variableMap.entrySet().stream()
                    .map((e) -> new AbstractMap.SimpleEntry<>(e.getValue(), sol[e.getKey()]))
                    .sorted(Comparator.comparing(AbstractMap.SimpleEntry::toString))
                    .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
//            log.info("Solution: {}", solutionMap);
        }
        return new RunnerSolution(variableMap, sol, vmPlacement, sourceNodes, nodesUnlocked, modelIsComplete);
    }

    private void placeVm(String vm, TopologyNode node) {
        vmsPerNode.putIfAbsent(node, new HashSet<>());
        vmsPerNode.get(node).add(vm);
        vmPlacement.put(vm, node);
    }

    private void splitConstr(double[][] constr, double[][] matrix, double[] vector) {
        int rows = constr.length;
        int columns = constr[0].length - 1;
        if (rows != matrix.length) {
            throw new IllegalArgumentException("Input matrix must have same row number as out matrix");
        }
        if (columns != (matrix[0].length)) {
            throw new IllegalArgumentException("Input matrix must have one column more than out matrix");
        }
        for (int i = 0; i < rows; i++) {
            System.arraycopy(constr[i], 0, matrix[i], 0, columns);
            vector[i] = constr[i][columns];
        }
    }


    /**
     * Generates the variables for the LP problem, initialising the varMap and invVarMap
     * @param nodesUnlocked if True, the problem will be optimized while also turning on the nodes.
     * @return the number of variables of the LP problem.
     */
    private int generateVariableMap(boolean nodesUnlocked, boolean modelIsComplete) {
        int variableIndex = 0;
        for (LogicalLinkParameters parameters : logLinks.keySet()) {

            TopologyNode sourceNode = topology.fetchNodeById(parameters.sourceNodeId);
            String prevVm = null != parameters.previousVMId ? parameters.previousVMId : parameters.nextVMId;
            String nextVm = parameters.nextVMId;

            // TODO filter links if nodes are not unlocked.
            for (TopologyLink link : topology.links) {
                Flow flowVar = new Flow(link, sourceNode, prevVm, nextVm);
                variableMap.put(variableIndex, flowVar);
                invVarMap.put(flowVar, variableIndex);
                variableIndex++;
            }

            for (TopologyNode actualNode : coreNodes) {
                TransitingTraffic transitVar = new TransitingTraffic(actualNode, sourceNode, prevVm, nextVm);
                variableMap.put(variableIndex, transitVar);
                invVarMap.put(transitVar, variableIndex);
                variableIndex++;

                ProcessedTraffic processedVar = new ProcessedTraffic(actualNode, sourceNode, prevVm, nextVm);
                variableMap.put(variableIndex, processedVar);
                invVarMap.put(processedVar, variableIndex);
                variableIndex++;

            }
        }
        if (!modelIsComplete) {
            for (Map.Entry<String, TopologyNode> entry : vmPlacement.entrySet()) {
                TopologyNode node = entry.getValue();
                String vm = entry.getKey();
                VmInstantiation instantiationVar = new VmInstantiation(node, vm);
                variableMap.put(variableIndex, instantiationVar);
                invVarMap.put(instantiationVar, variableIndex);
                variableIndex++;
            }
            for (String vm : vms) {
                for (TopologyNode node : coreNodes) {
                    if (node.equals(vmPlacement.get(vm))) {
                        continue;
                    }
                    List<VMSize> sizesList = vmsPerNode.getOrDefault(node, Collections.emptySet()).stream()
                            .map(sizes::get)
                            .collect(Collectors.toList());
                    VMSize currentSize = VMSize.sum(sizesList);
                    if (sizes.get(vm).sum(currentSize).fitsIn(node)) {
                        VmInstantiation instantiationVar = new VmInstantiation(node, vm);
                        variableMap.put(variableIndex, instantiationVar);
                        invVarMap.put(instantiationVar, variableIndex);
                        variableIndex++;
                    }
                }
            }
        }
        if (nodesUnlocked) {
            for (TopologyNode node : topology.nodes) {
                if (!node.isOn()) {
                    NodeConfiguration nodeConVar = new NodeConfiguration(node);
                    variableMap.put(variableIndex, nodeConVar);
                    invVarMap.put(nodeConVar, variableIndex);
                    variableIndex++;
                }
            }
        }
        return variableIndex;
    }

    private double[] generateC(int N) {
        double[] c = new double[N];
        for (int i = 0; i < N; i++) {
            Variable var = variableMap.get(i);
            if (var instanceof Flow) {
                Flow flow = (Flow) var;
                c[i] = flow.link.power;
            }
            else if (var instanceof VmInstantiation) {
                VmInstantiation vmIn = (VmInstantiation) var;
                c[i] = vmIn.node.getIdleVM();
            }
            else if (var instanceof NodeConfiguration) {
                NodeConfiguration nodeConf = (NodeConfiguration) var;
                c[i] = nodeConf.node.idle;
            }
            else if (var instanceof TransitingTraffic) {
                c[i] = 1E-9;
            }
            else if (var instanceof ProcessedTraffic) {
                c[i] = topology.processing;
            }
            else {
                throw new IllegalStateException(String.format("Unexpected variable: %s", var.getClass().toString()));
            }
        }
        return c;
    }

    private double[] generateLb(int N) {
        double[] lb = new double[N];
        for (int i = 0; i < N; i++) {
            Variable var = variableMap.get(i);
            if (var instanceof Flow) {
                lb[i] = 0;
            }
            else if (var instanceof VmInstantiation) {
                lb[i] = 0;
            }
            else if (var instanceof NodeConfiguration) {
                lb[i] = 0;
            }
            else if (var instanceof TransitingTraffic) {
                lb[i] = 0;
            }
            else if (var instanceof ProcessedTraffic) {
                lb[i] = 0;
            }
            else {
                throw new IllegalStateException(String.format("Unexpected variable: %s", var.getClass().toString()));
            }
        }
        return lb;
    }

    private double[] generateUb(int N) {
        double[] ub = new double[N];
        for (int i = 0; i < N; i++) {
            Variable var = variableMap.get(i);
            if (var instanceof Flow) {
                ub[i] = DEFAULT_MAX_UPPER_BOUND;
            }
            else if (var instanceof VmInstantiation) {
                ub[i] = 1.00001;
            }
            else if (var instanceof NodeConfiguration) {
                ub[i] = 1.00001;
            }
            else if (var instanceof TransitingTraffic) {
                ub[i] = DEFAULT_COMPUTATIONAL_CAPACITY;
            }
            else if (var instanceof ProcessedTraffic) {
                ub[i] = DEFAULT_COMPUTATIONAL_CAPACITY;
            }
            else {
                throw new IllegalStateException(String.format("Unexpected variable: %s", var.getClass().toString()));
            }
        }
        return ub;
    }

    private double[][] generateConstraints(int N, boolean modelIsComplete) {
        int constrNo = (logLinks.size() * coreNodes.size() * 2);
        constrNo = constrNo + (logLinks.size() * edgeNodes.size());
        constrNo = constrNo + (vmPlacement.size() * coreNodes.size());
        double[][] constr = new double[constrNo][N+1];
        int row = 0;
        if (!modelIsComplete) {
            // Set to 1 all of the DELTA corresponding to instantiated VMs,
            // set to 0 the DELTAS of those vms on other nodes
            for (Map.Entry<String, TopologyNode> entry : vmPlacement.entrySet()) {
                for (TopologyNode node : coreNodes) {
                    if (node.equals(entry.getValue())) {
                        constr[row][N] = 1;

                        int instantiationIndex = invVarMap.get(new VmInstantiation(node, entry.getKey()));
                        constr[row][instantiationIndex] = 1;

                        row++;
//                        log.info("Fixed DELTA({}, {}) at 1.", node, entry.getKey());
                    } else {
                        int instantiationIndex =
                                invVarMap.getOrDefault(new VmInstantiation(node, entry.getKey()), -1);
                        if (instantiationIndex != -1) {
                            constr[row][instantiationIndex] = 1;
                            constr[row][N] = 0;
                            row++;
                        }
                    }
                }
            }
        }

        for (LogicalLinkParameters parameters : logLinks.keySet()) {

            TopologyNode entryNode = topology.fetchNodeById(parameters.sourceNodeId);
            String prevVm = null != parameters.previousVMId ? parameters.previousVMId : parameters.nextVMId;
            String nextVm = parameters.nextVMId;

            for (TopologyNode node : coreNodes) {

                // Incoming traffic constraint
                // incoming - processed - transiting = 0
                constr[row][N] = 0;

                int transIndex = invVarMap.get(new TransitingTraffic(node, entryNode, prevVm, nextVm));
                constr[row][transIndex] = -1;

                int processIndex = invVarMap.get(new ProcessedTraffic(node, entryNode, prevVm, nextVm));
                constr[row][processIndex] = -1;

                for (TopologyLink link : topology.links) {
                    if (link.destination.equals(node)) {
                        int incomingIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));
                        constr[row][incomingIndex] = 1;
                    }
                }

                row++;

                // Outgoing traffic constraint
                // outgoing - transiting - coefficient * processed = 0

                constr[row][N] = 0;

                // Transiting flow addendum
                constr[row][transIndex] = -1; // Same as before

                // outgoing flow addenda
                for (TopologyLink link : topology.links) {
                    if (link.source.equals(node)) {
                        int outgoingIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));
                        constr[row][outgoingIndex] = 1;
                    }
                }

                // processed traffic addenda
                for (String otherVm : vms) {
                    String parametersVm = null;
                    if (!otherVm.equals(prevVm)) {
                        parametersVm = otherVm;
                    }
                    if (logLinks.containsKey(new LogicalLinkParameters(entryNode.nodeId, parametersVm, prevVm))) {
                        int outProcessIndex = invVarMap.get(new ProcessedTraffic(node, entryNode, otherVm, prevVm));
                        constr[row][outProcessIndex] = -coefficients.getOrDefault(
                                new TrafficCoefficientParameters(otherVm, prevVm, nextVm), 0D);
                    }
                }
                row++;
            }
            for (TopologyNode eNode : edgeNodes) {
                // Logical-physical flow constraint
                // outgoing(e) - incoming(e) = Logical entry-flow
                if (null == parameters.previousVMId && eNode.equals(entryNode)) {
                    constr[row][N] = logLinks.get(parameters);
                } else {
                    // Here logical entry-flow is 0 (either the logical flow is not an entry flow,
                    // or the source is not the node under exam)
                    constr[row][N] = 0;
                }
                for (TopologyLink link : topology.links) {
                    if (link.source.equals(eNode)) {
                        int flowIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));
                        constr[row][flowIndex] = 1;
                    }
                    if (link.destination.equals(eNode)) {
                        int flowIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));
                        constr[row][flowIndex] = -1;
                    }
                }
                row++;
            }
        }
        if (!(row == constrNo)) {
            double[][] temp = new double[row][N+1];
            System.arraycopy(constr, 0, temp, 0, row);
            constr = temp;
        }
        return constr;
    }

    private double[][] generateIneqConstraints(int N, boolean nodesUnlocked, boolean modelIsComplete) {
        int constrNo = (2 * topology.links.size() * logLinks.size()) + (coreNodes.size() * vms.size())
                + (coreNodes.size() * sourceNodes.size() * vms.size() * vms.size())
                + (coreNodes.size() * 3);
        double[][] constr = new double[constrNo][N + 1];

        int row = 0;

        for (TopologyLink link : topology.links) {
            // Link capacity constraint
            // link flow - capacity*sourceConf < 0
            // link flow - capacity*destinationConf < 0

            for (LogicalLinkParameters parameters : logLinks.keySet()) {

                TopologyNode entryNode = topology.fetchNodeById(parameters.sourceNodeId);
                String prevVm = null != parameters.previousVMId ? parameters.previousVMId : parameters.nextVMId;
                String nextVm = parameters.nextVMId;

                if (nodesUnlocked) {

                    int flowIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));

                    // sourceConf
                    int sourceIndex = invVarMap.getOrDefault(new NodeConfiguration(link.source), -1);

                    // destination Conf
                    int destIndex = invVarMap.getOrDefault(new NodeConfiguration(link.destination), -1);

                    constr[row][flowIndex] = 1;

                    if (sourceIndex == -1) {
                        if (destIndex != -1) {
                            constr[row][N] = 0;
                            constr[row][destIndex] = -link.bandwidth;
                            row++;
                        } else {
                            constr[row][N] = link.bandwidth;
                            row++;
                        }
                    } else {
                        constr[row][N] = 0;
                        constr[row][sourceIndex] = -link.bandwidth;
                        row++;
                        if (destIndex != -1) {
                            constr[row][flowIndex] = 1;
                            constr[row][N] = 0;
                            constr[row][destIndex] = -link.bandwidth;
                            row++;
                        }
                    }
                }
                // nodes are NOT unlocked
                else if (!link.source.isOn() || !link.destination.isOn()) {
                    // Must be zero!
                    constr[row][N] = 0;

                    int flowIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));
                    constr[row][flowIndex] = 1;

                    row++;

                } else {
                    // TODO capacity might have to be determined from the state in the future
                    constr[row][N] = link.bandwidth;

                    // link flow addenda
                    int flowIndex = invVarMap.get(new Flow(link, entryNode, prevVm, nextVm));
                    constr[row][flowIndex] = 1;

                    row++;
                }
            }
        }

        for (TopologyNode node : coreNodes) {
            int confIndex = invVarMap.getOrDefault(new NodeConfiguration(node), -1);
            // VM size vs node capabilities
            // Sum of instantiated vms cpu < node cpu
            // (and similarly)

            if (!modelIsComplete) {
                boolean vmAvailable = false;
                for (String vm : vms) {
                    int instanceIndex = invVarMap.getOrDefault(new VmInstantiation(node, vm), -1);
                    if (instanceIndex != -1) {
                        constr[row][instanceIndex] = sizes.get(vm).vCPUs;
                        constr[row + 1][instanceIndex] = sizes.get(vm).memory;
                        constr[row + 2][instanceIndex] = sizes.get(vm).hddSize;
                        vmAvailable = true;
                    }
                }

                if (vmAvailable) {
                    if (confIndex != -1) {
                        constr[row][confIndex] = -node.vCPUs;
                        constr[row + 1][confIndex] = -node.memory;
                        constr[row + 2][confIndex] = -node.hddSize;
                        constr[row][N] = 0;
                        constr[row + 1][N] = 0;
                        constr[row + 2][N] = 0;
                    } else {
                        constr[row][N] = node.vCPUs;
                        constr[row + 1][N] = node.memory;
                        constr[row + 2][N] = node.hddSize;
                    }

                    row = row + 3;
                }
            }

            for (String vm : vms) {
                // Instantiation <-> conf constraint
                // VmInstantiation - nodeConf < 0
                int instanceIndex = invVarMap.getOrDefault(new VmInstantiation(node, vm), -1);
                if (instanceIndex != -1) {

                    constr[row][instanceIndex] = 1;

                    if (nodesUnlocked) {
                        if (confIndex != -1) {
                            constr[row][N] = 0;
                            constr[row][confIndex] = -1;
                        } else {
                            constr[row][N] = 1;
                        }
                    } else if (!node.isOn()) {
                        constr[row][N] = 0;
                    } else {
                        constr[row][N] = 1;
                    }

                    row++;
                }

                for (TopologyNode entryNode : sourceNodes.values()) {
                    for (String otherVm : vms) {
                        String parametersVm = null;
                        if (!otherVm.equals(vm)) {
                            parametersVm = otherVm;
                        }
                        if (logLinks.containsKey(new LogicalLinkParameters(entryNode.nodeId, parametersVm, vm))) {

                            // processing <-> VM instantiation constraint
                            // processed - computational*instantiation < 0
                            int processIndex = invVarMap.get(new ProcessedTraffic(node, entryNode, otherVm, vm));
                            constr[row][N] = 0;
                            constr[row][processIndex] = 1;
                            if (instanceIndex != -1) {
                                constr[row][instanceIndex] = -DEFAULT_COMPUTATIONAL_CAPACITY;
                            } else if (node.equals(vmPlacement.get(vm))) {
                                constr[row][N] = DEFAULT_COMPUTATIONAL_CAPACITY;
                            }

                            row++;

                        }
                    }
                }
            }
        }
        if (!(row == constrNo)) {
            double[][] temp = new double[row][N+1];
            System.arraycopy(constr, 0, temp, 0, row);
            constr = temp;
        }
        return constr;
    }
}
