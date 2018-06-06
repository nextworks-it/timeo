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
package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import edu.uci.ics.jung.graph.Graph;
import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;
import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Marco Capitani on 28/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class DijkstraSolverSequential {

    private static final Logger log = LoggerFactory.getLogger(DijkstraSolverSequential.class);

    // TODO if VM can be provided as already instantiated, one must check that source and dest are not the same node.

    private NetConfiguration startingConf;
    private Graph<DijkstraFormatter.Node, DijkstraFormatter.Link> g;
    private Map<LogicalLinkParameters, Double> logLinks;
    private NetworkTopology topology;

    DijkstraSolverSequential(NetConfiguration startingConf,
                             Graph<DijkstraFormatter.Node, DijkstraFormatter.Link> g,
                             Map<LogicalLinkParameters, Double> logLinks,
                             NetworkTopology topology) {
        this.startingConf = startingConf;
        this.g = g;
        this.logLinks = logLinks;
        this.topology = topology;
    }

    Map<LogicalLinkParameters, List<DijkstraFormatter.Link>> seqDijkstra()
            throws OptimizationFailedException {

        Map<LogicalLinkParameters, List<DijkstraFormatter.Link>> output = new HashMap<>();

        Map<Map.Entry<String, String>, TopologyNode> reached = new HashMap<>();

        HashMap<LogicalLinkParameters, Double> decrementingLogLinks = new HashMap<>(logLinks);

        NetConfiguration currentConfiguration = startingConf;

        while (!decrementingLogLinks.isEmpty()) {
            Iterator<Map.Entry<LogicalLinkParameters, Double>> iterator = decrementingLogLinks.entrySet().iterator();
            log.debug("Number of logical links to compute: {}.", decrementingLogLinks.size());
            while (iterator.hasNext()) {
                Map.Entry<LogicalLinkParameters, Double> entry = iterator.next();
                LogicalLinkParameters logLink = entry.getKey();
                List<DijkstraFormatter.Link> path = null;
                if (null == logLink.previousVMId) {
                    log.debug("Computing logical link: {}.", logLink);
                    log.debug("With starting configuration: {}.", currentConfiguration);
                    TopologyNode sourceNode = topology.fetchNodeById(logLink.sourceNodeId);
                    DijkstraFormatter.Node source = new DijkstraFormatter.Node(sourceNode, currentConfiguration);
                    path = dijkstra(source, logLink);
                    iterator.remove();
                } else {
                    AbstractMap.SimpleEntry<String, String> startingPoint = new AbstractMap.SimpleEntry<>(
                            logLink.sourceNodeId,
                            logLink.previousVMId
                    );
                    if (reached.containsKey(startingPoint)) {
                        log.debug("Computing logical link: {}.", logLink);
                        log.debug("With starting configuration: {}.", currentConfiguration);
                        TopologyNode sourceNode = reached.get(startingPoint);
                        DijkstraFormatter.Node source = new DijkstraFormatter.Node(sourceNode, currentConfiguration);
                        path = dijkstra(source, logLink);
                        iterator.remove();
                    }
                }
                if (null != path) {
                    output.put(logLink, path);
                    DijkstraFormatter.Node lastNode = g.getDest(path.get(path.size() - 1));
                    log.debug("Computed logical link: {}.", entry.getKey());
                    reached.put(
                            new AbstractMap.SimpleEntry<>(logLink.sourceNodeId, logLink.nextVMId),
                            lastNode.node
                    );
                    currentConfiguration = lastNode.conf;
                    log.debug("Current conf: {}", currentConfiguration);
                    log.debug("inv map: {}", currentConfiguration.getInvVmMap());
                }
            }
        }

        return output;
    }

    private List<DijkstraFormatter.Link> makePath(Map<DijkstraFormatter.Node, DijkstraFormatter.Link> predecessors,
                                                  DijkstraFormatter.Node dest) {

        LinkedList<DijkstraFormatter.Link> output = new LinkedList<>();
        DijkstraFormatter.Link current = predecessors.get(dest);
        while (current != null) {
            output.addFirst(current);
            DijkstraFormatter.Node previous = g.getSource(current);
            current = predecessors.get(previous);
        }
        return output;
    }

    private List<DijkstraFormatter.Link> dijkstra(DijkstraFormatter.Node source,
                                                  LogicalLinkParameters logLink)
            throws OptimizationFailedException {
        double traffic = logLinks.get(logLink);
        Map<DijkstraFormatter.Node, Double> finals = new HashMap<>();
        MapByValue<DijkstraFormatter.Node, Double> estimates = new MapByValue<>();
        Map<DijkstraFormatter.Node, DijkstraFormatter.Link> predecessors = new HashMap<>();
        estimates.put(source, 0D);
        while (!estimates.isEmpty()) {
            if (log.isDebugEnabled()) {
                if (finals.size() % 50 == 0) {
                    log.debug("Finals size: {}. Estimates size: {}.",
                            finals.size(),
                            estimates.size());
                }
            }
            Map.Entry<DijkstraFormatter.Node, Double> entry = estimates.poll();

            // If it is a candidate endpoint of our link, we are done:
            if (entry.getKey().endpointOf != null && entry.getKey().endpointOf.equals(logLink)) {
                List<DijkstraFormatter.Link> path = makePath(predecessors, entry.getKey());
                log.debug("DIJKSTRA REPORT: Finals size: {}. Estimates size: {}. " +
                        "Path size: {}",
                        finals.size(), estimates.size(), path.size());
                return path;
            }

            // else finalize it:
            finals.put(entry.getKey(), entry.getValue());

            // main piece:
            for (DijkstraFormatter.Link link : g.getOutEdges(entry.getKey())) {
                DijkstraFormatter.Node potential = g.getDest(link);
                double newWeight = entry.getValue() + link.weight(traffic);
                if (finals.keySet().contains(potential)) {
                    if (finals.get(potential) > newWeight) {
                        throw new OptimizationFailedException("The graph contains negative-weighted edges!");
                    }
                    // else: as expected. Nothing to do here.
                }
                else if ((!estimates.keySet().contains(potential))
                        || (estimates.get(potential) > newWeight)) {
                    estimates.put(potential, newWeight);
                    predecessors.put(potential, link);
                }
            }
        }
        // We searched the whole (connected component of) the graph without getting to a destination.
        throw new OptimizationFailedException("Path not found!");
    }
}
