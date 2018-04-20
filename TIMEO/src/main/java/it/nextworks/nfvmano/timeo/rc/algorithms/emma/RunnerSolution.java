package it.nextworks.nfvmano.timeo.rc.algorithms.emma;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;
import it.nextworks.nfvmano.timeo.rc.algorithms.ComputationSolution;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 11/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class RunnerSolution {

    Map<TopologyNode, Double> nodeConfs = new HashMap<>();
    Map<Map.Entry<String, TopologyNode>, Double> instantiations = new HashMap<>();
    Map<String, ComputationSolution.VMPath> paths = new HashMap<>();

    private Map<String, TopologyNode> vmPlacement;
    private Map<String, TopologyNode> sourceNodes;

    private double[] solution;

    private double confSum = 0;
    private double instSum = 0;

    RunnerSolution(Map<Integer, Variable> varMap, double[] solution,
                   Map<String, TopologyNode> vmPlacement,
                   Map<String, TopologyNode> sourceNodes,
                   boolean nodesUnlocked, boolean modelIsComplete)
            throws OptimizationFailedException {
        this.solution = solution;
        this.vmPlacement = vmPlacement;
        this.sourceNodes = sourceNodes;
        if (nodesUnlocked) {
            parseConfs(varMap);
        } else if (!modelIsComplete) {
            parseInstantiations(varMap);
        } else {
            parseFlows(varMap);
        }
        postConstruct();
    }

    private void parseFlows(Map<Integer, Variable> varMap) {
        convertMap(varMap, Flow.class)
                .forEach(this::parseFlow);
    }

    private void parseConfs(Map<Integer, Variable> varMap) {
        convertMap(varMap, NodeConfiguration.class)
                .forEach(this::parseConf);
    }

    private void parseInstantiations(Map<Integer, Variable> varMap) {
        convertMap(varMap, VmInstantiation.class)
                .forEach(this::parseInstantiation);
    }

    static <T> Stream<Map.Entry<Integer, T>> convertMap(Map<Integer, Variable> varMap, Class<T> tClass) {
        return varMap.entrySet().stream()
                .filter((e) -> tClass.equals(e.getValue().getClass()))
                .map((e) -> new AbstractMap.SimpleEntry<>(
                        e.getKey(),
                        tClass.cast(e.getValue()))
                );
    }

    private void parseFlow(Map.Entry<Integer, Flow> flowEntry) {
        Flow flow = flowEntry.getValue();
        int index = flowEntry.getKey();
        if (solution[index] > 1E-4)
        addToPath(flow.sourceNode.nodeId, flow.previousVM, flow.nextVM, flow.link);
    }

    private void parseConf(Map.Entry<Integer, NodeConfiguration> confEntry) {
        int index = confEntry.getKey();
        NodeConfiguration conf = confEntry.getValue();
        nodeConfs.put(conf.node, solution[index]);
        confSum = confSum + solution[index];
    }

    private void parseInstantiation(Map.Entry<Integer, VmInstantiation> instantiationEntry) {
        int index = instantiationEntry.getKey();
        VmInstantiation inst = instantiationEntry.getValue();
        if (!vmPlacement.containsKey(inst.vm)) {
            instantiations.put(new AbstractMap.SimpleEntry<>(inst.vm, inst.node), solution[index]);
            instSum = instSum + solution[index];
        } // else it was placed already, so nothing to do here.
    }

    private void addToPath(String entryNode, String source, String destination, TopologyLink link) {
        String actualSource;
        TopologyNode sourceNode;
        if (!source.equals(destination)) {
            actualSource = source;
            sourceNode = vmPlacement.get(actualSource);
        } else {
            actualSource = entryNode;
            sourceNode = sourceNodes.get(actualSource);
        }
        if (null == vmPlacement.get(destination)) throw new NullPointerException(destination + "; " + vmPlacement.toString());
        String key = actualSource + "->" + destination;
        ComputationSolution.VMPath path = paths.computeIfAbsent(key,
                (k) -> new ComputationSolution.VMPath(
                        entryNode, source, destination, new ArrayList<>(),
                        sourceNode, vmPlacement.get(destination)
                )
        );
        path.path.add(link);
    }

    private void postConstruct() throws OptimizationFailedException {
        if (!nodeConfs.isEmpty()) {
            if (confSum <= 0) {
                throw new OptimizationFailedException("Got all zero node configurations.");
            }
            double coefficient = 1 / confSum;
            for (TopologyNode node : nodeConfs.keySet()) {
                nodeConfs.put(node, nodeConfs.get(node) * coefficient);
            }
        }
        if (!instantiations.isEmpty()) {
            if (instSum <= 0) {
                throw new IllegalStateException("Got all zero instantiations.");
            }
            double coefficient = 1 / instSum;
            for (Map.Entry<String, TopologyNode> entry : instantiations.keySet()) {
                instantiations.put(entry, instantiations.get(entry) * coefficient);
            }
        }
        if (!paths.isEmpty()) {
            for (ComputationSolution.VMPath vmPath : paths.values()) {
                vmPath.sort();
            }
        }
    }
}
