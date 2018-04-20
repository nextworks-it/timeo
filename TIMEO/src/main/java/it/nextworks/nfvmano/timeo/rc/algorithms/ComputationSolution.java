package it.nextworks.nfvmano.timeo.rc.algorithms;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Marco Capitani on 11/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class ComputationSolution {

    public Map<TopologyNode, Integer> nodeConfs;
    public Map<String, TopologyNode> instantiations;
    public Set<VMPath> paths;

    public ComputationSolution(Map<TopologyNode, Integer> nodeConfs,
                        Map<String, TopologyNode> instantiations,
                        Set<VMPath> paths) {
        this.nodeConfs = nodeConfs;
        this.instantiations = instantiations;
        this.paths = paths;
    }

    public String toString() {
        return String.format(
                "New confs: %s. Instantiations: %s. Paths: %s",
                nodeConfs,
                instantiations,
                paths
        );
    }

    public static class VMPath {
        public String entryNode;
        public String source; // VM or SAP ID
        public String destination; // VM or SAP ID
        public List<TopologyLink> path;

        private TopologyNode sourceNode;
        private TopologyNode destinationNode;

        public VMPath(String entryNode, String source, String destination, List<TopologyLink> path,
                      TopologyNode sourceNode, TopologyNode destinationNode) {
            this.entryNode = entryNode;
            this.source = source;
            this.destination = destination;
            this.path = path;
            this.sourceNode = sourceNode;
            this.destinationNode = destinationNode;
        }

        public String toString() {
            return String.format(
                    "(%s, %s -> %s) path: %s",
                    entryNode, source, destination, path
            );
        }

        public void sort() {
            VMPathSorter sorter = new VMPathSorter(path, sourceNode, destinationNode);
            path = sorter.sort();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            VMPath vmPath = (VMPath) o;

            return entryNode.equals(vmPath.entryNode)
                    && source.equals(vmPath.source)
                    && destination.equals(vmPath.destination);
        }

        @Override
        public int hashCode() {
            int result = entryNode.hashCode();
            result = 31 * result + source.hashCode();
            result = 31 * result + destination.hashCode();
            return result;
        }
    }

    private static class VMPathSorter {

        private static final Logger log = LoggerFactory.getLogger(VMPathSorter.class);

        private LinkedList<TopologyLink> headList = new LinkedList<>();
        private LinkedList<TopologyLink> tailList = new LinkedList<>();

        private Map<TopologyNode, LinkedList<TopologyLink>> partialByHead = new HashMap<>();
        private Map<TopologyNode, LinkedList<TopologyLink>> partialByTail = new HashMap<>();

        private List<TopologyLink> startingList;
        private List<TopologyLink> inputList;

        private TopologyNode source;
        private TopologyNode destination;

        private VMPathSorter(List<TopologyLink> inputList, TopologyNode source, TopologyNode destination) {
            startingList = inputList;
            this.inputList = new ArrayList<>(startingList);
            this.source = source;
            this.destination = destination;
        }

        private List<TopologyLink> sort() {
            try {
                Iterator<TopologyLink> iterator = inputList.iterator();
                while (iterator.hasNext()) {
                    TopologyLink link = iterator.next();
                    iterator.remove();
                    boolean placed = addToHeadList(link);
                    if (!placed) {
                        placed = addToTailList(link);
                    }
                    if (!placed) {
                        placed = addToHeadPartial(link);
                    }
                    if (!placed) {
                        placed = addToTailPartial(link);
                    }
                    if (!placed) {
                        addNewPartial(link);
                    }
                    boolean stateChanged = true;
                    while (stateChanged) {
                        stateChanged = checkState();
                    }
                }
                tryFinish();
                return headList;
            } catch (IllegalStateException e) {
                log.warn("{} branches.", this);
                log.debug("Exception details: ", e);
                Graph<String, TopologyLink> branchingPath = new DirectedSparseGraph<>();
                startingList.forEach(
                        (l) -> {
                            branchingPath.addVertex(l.source.nodeId);
                            branchingPath.addVertex(l.destination.nodeId);
                            branchingPath.addEdge(l, l.source.nodeId, l.destination.nodeId);
                        });
                DijkstraShortestPath<String, TopologyLink> dsp = new DijkstraShortestPath<>(branchingPath);
                try {
                    return dsp.getPath(source.nodeId, destination.nodeId);
                } catch (Exception dspExc) {
                    throw new IllegalStateException(
                            String.format("Botched path %s. Status:\n%s", this, dump()),
                            dspExc
                    );
                }
            }
        }

        private boolean addToHeadPartial(TopologyLink link) {
            return prependToPartial(link, link.destination);
        }

        private boolean addToTailPartial(TopologyLink link) {
            return appendToPartial(link, link.source);
        }

        private boolean addToTailList(TopologyLink link) {
            if (link.destination.equals(destination)) {
                if (tailList.isEmpty()) {
                    tailList.addFirst(link);
                    return true;
                } else {
                    throw new IllegalStateException(String.format(
                            "Path between %s and %s contains same-destination links %s and %s",
                            source, destination, tailList.getLast(), link
                    ));
                }
            }
            if (!tailList.isEmpty() && link.destination.equals(tailList.getFirst().source)) {
                tailList.addFirst(link);
                return true;
            }
            // else
            return false;
        }

        private boolean addToHeadList(TopologyLink link) {
            if (link.source.equals(source)) {
                if (headList.isEmpty()) {
                    headList.addLast(link);
                    return true;
                } else {
                    throw new IllegalStateException(String.format(
                            "Path between %s and %s contains same-source links %s and %s",
                            source, destination, headList.getFirst(), link
                    ));
                }
            }
            if (!headList.isEmpty() && link.source.equals(headList.getLast().destination)) {
                headList.addLast(link);
                return true;
            }
            // else
            return false;
        }

        private void addNewPartial(TopologyLink link) {
            LinkedList<TopologyLink> newPartial = new LinkedList<>(Collections.singletonList(link));
            TopologyNode source = newPartial.getFirst().source;
            TopologyNode destination = newPartial.getLast().destination;
            LinkedList<TopologyLink> put1 =
                    partialByTail.put(destination, newPartial);
            if (put1 != null) {
                throw new IllegalStateException(String.format(
                        "Path between %s and %s contains same-destination links %s and %s",
                        source, destination, newPartial.getLast(), put1.getLast()
                ));
            }
            LinkedList<TopologyLink> put2 =
                    partialByHead.put(source, newPartial);
            if (put2 != null) {
                throw new IllegalStateException(String.format(
                        "Path between %s and %s contains same-source links %s and %s",
                        source, destination, newPartial.getFirst(), put2.getFirst()
                ));
            }
        }

        private boolean checkState() {
            boolean stateChanged = false;
            Iterator<Map.Entry<TopologyNode, LinkedList<TopologyLink>>> iterator = partialByHead.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<TopologyNode, LinkedList<TopologyLink>> entry = iterator.next();
                TopologyNode head = entry.getKey();
                LinkedList<TopologyLink> partial = entry.getValue();
                if (!headList.isEmpty() && headList.getLast().destination.equals(head)) {
                    iterator.remove();
                    partialByTail.remove(partial.getLast().destination, partial);
                    headList.addAll(partial);
                    stateChanged = true;
                }
                if (partialByTail.containsKey(head)) {
                    iterator.remove();
                    partialByTail.remove(partial.getLast().destination, partial);
                    appendToPartial(partial, head);
                    stateChanged = true;
                }
            }
            if (!tailList.isEmpty() && !headList.isEmpty()
                    && tailList.getFirst().source.equals(headList.getLast().destination)) {
                headList.addAll(tailList);
                tailList.clear();
                tryFinish();
                stateChanged = false;
                // We return false because we don't need to check the state anymore.
            }
            return stateChanged;
        }

        private boolean appendToPartial(LinkedList<TopologyLink> list, TopologyNode tailOfPartial) {
            LinkedList<TopologyLink> partial = partialByTail.remove(tailOfPartial);
            if (null == partial) {
                return false;
            }
            partial.addAll(list);
            LinkedList<TopologyLink> put = partialByTail.put(partial.getLast().destination, partial);
            if (null != put) {
                throw new IllegalStateException(String.format(
                        "Path between %s and %s contains same-destination links %s and %s",
                        source, destination, partial.getLast(), put.getLast()
                ));
            }
            return true;
        }

        private boolean prependToPartial(LinkedList<TopologyLink> list, TopologyNode headOfPartial) {
            LinkedList<TopologyLink> partial = partialByHead.remove(headOfPartial);
            if (null == partial) {
                return false;
            }
            Iterator<TopologyLink> iterator = list.descendingIterator();
            while (iterator.hasNext()) {
                TopologyLink current = iterator.next();
                partial.addFirst(current);
            }
            LinkedList<TopologyLink> put = partialByHead.put(partial.getFirst().source, partial);
            if (null != put) {
                throw new IllegalStateException(String.format(
                        "Path between %s and %s contains same-source links %s and %s",
                        source, destination, partial.getFirst(), put.getFirst()
                ));
            }
            return true;
        }

        private boolean appendToPartial(TopologyLink link, TopologyNode tailOfPartial) {
            return appendToPartial(new LinkedList<>(Collections.singletonList(link)), tailOfPartial);
        }

        private boolean prependToPartial(TopologyLink link, TopologyNode headOfPartial) {
            return prependToPartial(new LinkedList<>(Collections.singletonList(link)), headOfPartial);
        }

        private void tryFinish() {
            if (!inputList.isEmpty()
                    || !partialByHead.isEmpty()
                    || !partialByTail.isEmpty()
                    || !tailList.isEmpty()) {
                throw new IllegalStateException(String.format(
                        "Path found, but some links are unused. Path: %s. Sorter status:\n%s.",
                        this, dump()
                ));
            }
            if (headList.isEmpty() || !headList.getLast().destination.equals(destination)) {
                throw new IllegalStateException(String.format(
                        "Path %s not complete. Sorter status:\n%s", this, dump()
                ));
            }
        }

        public String toString() {
            return String.format(
                    "Path [(%s -> %s), links: %s]", source, destination, headList
            );
        }

        private String dump() {
            return String.format(
                    "Input: %s.\nHead: %s.\nTail: %s.\npHead: %s.\npTail: %s.\n",
                    inputList, headList, tailList, partialByHead, partialByTail
            );
        }
    }
}
