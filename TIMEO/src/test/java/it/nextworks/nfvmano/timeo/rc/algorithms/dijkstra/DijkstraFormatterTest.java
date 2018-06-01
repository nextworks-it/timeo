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

import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.common.exception.OptimizationFailedException;
import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.TrafficCoefficientParameters;
import it.nextworks.nfvmano.timeo.rc.algorithms.VMSize;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Marco Capitani on 20/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class DijkstraFormatterTest {

    private TopologyNode makeXPFE(String nodeId, double idle, int state) {
        PowerState pState;
        if (state == 1) {
            pState = PowerState.HIGH_POWER;
        } else {
            pState = PowerState.SLEEPING;
        }
        return new TopologyNode(nodeId, new HashSet<>(), idle, pState);
    }

    private TopologyNode makeXPU(String nodeId, double idle, double idleVM, int state) {
        PowerState pState;
        if (state == 1) {
            pState = PowerState.HIGH_POWER;
        } else {
            pState = PowerState.SLEEPING;
        }
        TopologyNode node = new TopologyNode(nodeId, new HashSet<>(), 50, 16, 2, idle, idleVM, pState, "zone1", nodeId);
        node.setProcessing(5*idleVM);
        return node;
    }

    private TopologyNode makeXPU(String nodeId, double idle, double idleVM, int state,
                                 int hddSize, int memory, int vCPUs) {
        return makeXPU(nodeId, idle, idleVM, state, hddSize, memory, vCPUs, 5*idleVM);
    }

    private TopologyNode makeXPU(String nodeId, double idle, double idleVM, int state,
                                 int hddSize, int memory, int vCPUs, double processing) {
        PowerState pState;
        if (state == 1) {
            pState = PowerState.HIGH_POWER;
        } else {
            pState = PowerState.SLEEPING;
        }
        TopologyNode node = new TopologyNode(nodeId, new HashSet<>(), hddSize, memory, vCPUs, idle, idleVM, pState, "zone1", nodeId);
        node.setProcessing(processing);
        return node;
    }

    private Iterator<String> id = Stream.iterate("0", ((s) -> String.valueOf(Integer.parseInt(s) + 1))).iterator();

    private void addDuplexLink(List<TopologyLink> links, TopologyNode node1, TopologyNode node2, double power, int bw) {
        links.add(new TopologyLink(id.next(), node1, node2, null, null, power, bw));
        links.add(new TopologyLink(id.next(), node2, node1, null, null, power, bw));
    }

    @Test
    public void testMinimal() throws Exception {

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPU("a", 5, 4, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        nodes.add(a);
        nodes.add(x);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, x, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Collections.singletonList("VM1"),
                Collections.singletonMap("VM1", new VMSize(1, 4, 10)),
                logLinks,
                Collections.emptyMap(),
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testMinimal2EP() throws Exception {

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPU("a", 5, 4, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        nodes.add(a);
        nodes.add(x);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, x, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("x", null, "VM2"), 1D);

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2"),
                sizes,
                logLinks,
                coefficients,
                Arrays.asList(a, x),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testMinimalChain() throws Exception {

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPU("a", 5, 4, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        nodes.add(a);
        nodes.add(x);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, x, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("a", "VM1", "VM2"), 1D);

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
        coefficients.put(new TrafficCoefficientParameters("VM1", "VM1", "VM2"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2"),
                sizes,
                logLinks,
                coefficients,
                Arrays.asList(a, x),
                Collections.emptyMap(),
                "TEST");

        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testMinimalSplitChain() throws Exception {

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPU("a", 5, 4, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        nodes.add(a);
        nodes.add(x);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, x, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("a", "VM1", "VM2"), 1D);

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(2, 16, 10));
        sizes.put("VM2", new VMSize(2, 16, 10));

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
        coefficients.put(new TrafficCoefficientParameters("VM1", "VM1", "VM2"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2"),
                sizes,
                logLinks,
                coefficients,
                Arrays.asList(a, x),
                Collections.emptyMap(),
                "TEST");

        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testSimple() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode b = makeXPFE("b", 5, 1);
        TopologyNode c = makeXPFE("c", 5, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        TopologyNode y = makeXPU("y", 5, 4, 1);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(x);
        nodes.add(y);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, b, 5, 1000);
        addDuplexLink(links, b, c, 5, 1000);
        addDuplexLink(links, b, x, 5, 1000);
        addDuplexLink(links, c, y, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1"),
                sizes,
                logLinks,
                coefficients,
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");

        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testMultiVM() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode b = makeXPFE("b", 5, 1);
        TopologyNode c = makeXPFE("c", 5, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        TopologyNode y = makeXPU("y", 5, 4, 1);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(x);
        nodes.add(y);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, b, 5, 1000);
        addDuplexLink(links, b, c, 5, 1000);
        addDuplexLink(links, b, x, 5, 1000);
        addDuplexLink(links, c, y, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("a", "VM1", "VM2"), 1D);

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM2"), 1D
        );
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM2", "VM1"), 0D
        );

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2"),
                sizes,
                logLinks,
                coefficients,
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testMultiEP() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode b = makeXPFE("b", 5, 1);
        TopologyNode c = makeXPFE("c", 5, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        TopologyNode y = makeXPU("y", 5, 4, 1);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(x);
        nodes.add(y);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, b, 5, 1000);
        addDuplexLink(links, b, c, 5, 1000);
        addDuplexLink(links, b, x, 5, 1000);
        addDuplexLink(links, c, y, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("c", null, "VM2"), 1D);

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2"),
                sizes,
                logLinks,
                coefficients,
                Arrays.asList(a, c),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testMedium() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode n1 = makeXPFE("1", 5, 1);
        TopologyNode n2 = makeXPFE("2", 5, 1);
        TopologyNode n3 = makeXPFE("3", 5, 1);
        TopologyNode n4 = makeXPFE("4", 5, 1);
        TopologyNode n5 = makeXPFE("5", 5, 1);
        TopologyNode n6 = makeXPFE("6", 5, 1);
        TopologyNode x1 = makeXPU("x1", 5, 3, 1);
        TopologyNode x2 = makeXPU("x2", 5, 4, 1);
        TopologyNode x3 = makeXPU("x3", 5, 4, 1);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(x1);
        nodes.add(x2);
        nodes.add(x3);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, n1, n2, 5, 1000);
        addDuplexLink(links, n1, n3, 5, 1000);
        addDuplexLink(links, n3, n4, 5, 1000);
        addDuplexLink(links, n3, n5, 5, 1000);
        addDuplexLink(links, n5, n6, 5, 1000);
        addDuplexLink(links, n2, n5, 5, 1000);
        addDuplexLink(links, n6, x1, 5, 1000);
        addDuplexLink(links, n2, x2, 5, 1000);
        addDuplexLink(links, n6, x3, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("1", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("1", "VM1", "VM2"), 1D);
        logLinks.put(new LogicalLinkParameters("1", "VM1", "VM3"), 1D);

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM2"), 1D
        );
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM3"), 1D
        );

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));
        sizes.put("VM3", new VMSize(1, 4, 10));

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2", "VM3"),
                sizes,
                logLinks,
                coefficients,
                Collections.singletonList(n1),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test(expected = OptimizationFailedException.class)
    public void testNoPath() throws Exception {

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        nodes.add(a);
        nodes.add(x);

        List<TopologyLink> links = new ArrayList<>();
        links.add(new TopologyLink(id.next(), x, a, null, null, 5, 1000));

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Collections.singletonList("VM1"),
                Collections.singletonMap("VM1", new VMSize(1, 4, 10)),
                logLinks,
                Collections.emptyMap(),
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testBigger() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode n1 = makeXPFE("1", 5, 1);
        TopologyNode n2 = makeXPFE("2", 5, 1);
        TopologyNode n3 = makeXPFE("3", 5, 1);
        TopologyNode n4 = makeXPFE("4", 5, 1);
        TopologyNode n5 = makeXPFE("5", 5, 1);
        TopologyNode n6 = makeXPFE("6", 5, 1);
        TopologyNode n7 = makeXPFE("7", 5, 1);
        TopologyNode n8 = makeXPFE("8", 5, 1);
        TopologyNode n9 = makeXPFE("9", 5, 1);
        TopologyNode n10 = makeXPFE("10", 5, 1);
        TopologyNode n11 = makeXPFE("11", 5, 1);
        TopologyNode n12 = makeXPFE("12", 5, 1);
        TopologyNode n13 = makeXPFE("13", 5, 1);
        TopologyNode n14 = makeXPFE("14", 5, 1);
        TopologyNode n15 = makeXPFE("15", 5, 1);
        TopologyNode x1 = makeXPU("x1", 5, 3, 1);
        TopologyNode x2 = makeXPU("x2", 5, 4, 1);
        TopologyNode x3 = makeXPU("x3", 5, 4, 1);
        TopologyNode x4 = makeXPU("x4", 5, 4, 1);
        TopologyNode x5 = makeXPU("x5", 5, 4, 1);
        TopologyNode x6 = makeXPU("x6", 5, 4, 1);
        TopologyNode x7 = makeXPU("x7", 5, 4, 1);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(n7);
        nodes.add(n8);
        nodes.add(n9);
        nodes.add(n10);
        nodes.add(n11);
        nodes.add(n12);
        nodes.add(n13);
        nodes.add(n14);
        nodes.add(n15);
        nodes.add(x1);
        nodes.add(x2);
        nodes.add(x3);
        nodes.add(x4);
        nodes.add(x5);
        nodes.add(x6);
        nodes.add(x7);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, n1, n2, 5, 1000);
        addDuplexLink(links, n1, n3, 5, 1000);
        addDuplexLink(links, n1, n4, 5, 1000);
        addDuplexLink(links, n4, n5, 5, 1000);
        addDuplexLink(links, n4, n6, 5, 1000);
        addDuplexLink(links, n6, n7, 5, 1000);
        addDuplexLink(links, n6, n8, 5, 1000);
        addDuplexLink(links, n2, n5, 5, 1000);
        addDuplexLink(links, n5, n8, 5, 1000);
        addDuplexLink(links, n3, n7, 5, 1000);
        addDuplexLink(links, n5, n10, 5, 1000);
        addDuplexLink(links, n8, n9, 5, 1000);
        addDuplexLink(links, n8, n10, 5, 1000);
        addDuplexLink(links, n10, n11, 5, 1000);
        addDuplexLink(links, n10, n12, 5, 1000);
        addDuplexLink(links, n3, n11, 5, 1000);
        addDuplexLink(links, n9, n12, 5, 1000);
        addDuplexLink(links, n12, n13, 5, 1000);
        addDuplexLink(links, n12, n14, 5, 1000);
        addDuplexLink(links, n11, n15, 5, 1000);
        addDuplexLink(links, n1, x1, 5, 1000);
        addDuplexLink(links, x1, n1, 5, 1000);
        addDuplexLink(links, n2, x2, 5, 1000);
        addDuplexLink(links, x2, n2, 5, 1000);
        addDuplexLink(links, n6, x3, 5, 1000);
        addDuplexLink(links, x3, n6, 5, 1000);
        addDuplexLink(links, n4, x5, 5, 1000);
        addDuplexLink(links, x5, n4, 5, 1000);
        addDuplexLink(links, n5, x6, 5, 1000);
        addDuplexLink(links, x6, n5, 5, 1000);
        addDuplexLink(links, n7, x7, 5, 1000);
        addDuplexLink(links, x7, n7, 5, 1000);
        addDuplexLink(links, n9, x4, 5, 1000);
        addDuplexLink(links, x4, n9, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("15", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("15", "VM1", "VM2"), 1D);
        logLinks.put(new LogicalLinkParameters("15", "VM1", "VM3"), 1D);

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM2"), 1D
        );
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM3"), 1D
        );

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));
        sizes.put("VM3", new VMSize(1, 4, 10));

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2", "VM3"),
                sizes,
                logLinks,
                coefficients,
                Collections.singletonList(n15),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testBiggerMoreVm() throws Exception {

        // TODO: slow or looping?
        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode n1 = makeXPFE("1", 5, 1);
        TopologyNode n2 = makeXPFE("2", 5, 1);
        TopologyNode n3 = makeXPFE("3", 5, 1);
        TopologyNode n4 = makeXPFE("4", 5, 1);
        TopologyNode n5 = makeXPFE("5", 5, 1);
        TopologyNode n6 = makeXPFE("6", 5, 1);
        TopologyNode n7 = makeXPFE("7", 5, 1);
        TopologyNode n8 = makeXPFE("8", 5, 1);
        TopologyNode n9 = makeXPFE("9", 5, 1);
        TopologyNode n10 = makeXPFE("10", 5, 1);
        TopologyNode n11 = makeXPFE("11", 5, 1);
        TopologyNode n12 = makeXPFE("12", 5, 1);
        TopologyNode n13 = makeXPFE("13", 5, 1);
        TopologyNode n14 = makeXPFE("14", 5, 1);
        TopologyNode n15 = makeXPFE("15", 5, 1);
        TopologyNode x1 = makeXPU("x1", 5, 3, 1);
        TopologyNode x2 = makeXPU("x2", 5, 4, 1);
        TopologyNode x3 = makeXPU("x3", 5, 4, 1);
        TopologyNode x4 = makeXPU("x4", 5, 4, 1);
        TopologyNode x5 = makeXPU("x5", 5, 4, 1);
        TopologyNode x6 = makeXPU("x6", 5, 4, 1);
        TopologyNode x7 = makeXPU("x7", 5, 4, 1);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(n7);
        nodes.add(n8);
        nodes.add(n9);
        nodes.add(n10);
        nodes.add(n11);
        nodes.add(n12);
        nodes.add(n13);
        nodes.add(n14);
        nodes.add(n15);
        nodes.add(x1);
        nodes.add(x2);
        nodes.add(x3);
        nodes.add(x4);
        nodes.add(x5);
        nodes.add(x6);
        nodes.add(x7);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, n1, n2, 5, 1000);
        addDuplexLink(links, n1, n3, 5, 1000);
        addDuplexLink(links, n1, n4, 5, 1000);
        addDuplexLink(links, n4, n5, 5, 1000);
        addDuplexLink(links, n4, n6, 5, 1000);
        addDuplexLink(links, n6, n7, 5, 1000);
        addDuplexLink(links, n6, n8, 5, 1000);
        addDuplexLink(links, n2, n5, 5, 1000);
        addDuplexLink(links, n5, n8, 5, 1000);
        addDuplexLink(links, n3, n7, 5, 1000);
        addDuplexLink(links, n5, n10, 5, 1000);
        addDuplexLink(links, n8, n9, 5, 1000);
        addDuplexLink(links, n8, n10, 5, 1000);
        addDuplexLink(links, n10, n11, 5, 1000);
        addDuplexLink(links, n10, n12, 5, 1000);
        addDuplexLink(links, n3, n11, 5, 1000);
        addDuplexLink(links, n9, n12, 5, 1000);
        addDuplexLink(links, n12, n13, 5, 1000);
        addDuplexLink(links, n12, n14, 5, 1000);
        addDuplexLink(links, n11, n15, 5, 1000);
        addDuplexLink(links, n1, x1, 5, 1000);
        addDuplexLink(links, x1, n1, 5, 1000);
        addDuplexLink(links, n2, x2, 5, 1000);
        addDuplexLink(links, x2, n2, 5, 1000);
        addDuplexLink(links, n6, x3, 5, 1000);
        addDuplexLink(links, x3, n6, 5, 1000);
        addDuplexLink(links, n4, x5, 5, 1000);
        addDuplexLink(links, x5, n4, 5, 1000);
        addDuplexLink(links, n5, x6, 5, 1000);
        addDuplexLink(links, x6, n5, 5, 1000);
        addDuplexLink(links, n7, x7, 5, 1000);
        addDuplexLink(links, x7, n7, 5, 1000);
        addDuplexLink(links, n9, x4, 5, 1000);
        addDuplexLink(links, x4, n9, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("15", null, "VM1"), 1D);
        logLinks.put(new LogicalLinkParameters("15", "VM1", "VM2"), 1D);
        logLinks.put(new LogicalLinkParameters("15", "VM1", "VM3"), 1D);
        logLinks.put(new LogicalLinkParameters("15", "VM2", "VM4"), 1D);
        logLinks.put(new LogicalLinkParameters("15", "VM3", "VM4"), 1D);
        //logLinks.put(new LogicalLinkParameters("15", "VM4", "VM5"), 6D);
        // TODO check validation

        Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM2"), 1D
        );
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM1", "VM3"), 1D
        );
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM2", "VM4"), 1D
        );
        coefficients.put(new TrafficCoefficientParameters(
                "VM1", "VM3", "VM4"), 1D
        );
//        coefficients.put(new TrafficCoefficientParameters(
//                "VM3", "VM4", "VM5"), 3D
//        );

        Map<String, VMSize> sizes = new HashMap<>();
        sizes.put("VM1", new VMSize(1, 4, 10));
        sizes.put("VM2", new VMSize(1, 4, 10));
        sizes.put("VM3", new VMSize(1, 4, 10));
        sizes.put("VM4", new VMSize(1, 4, 10));
        //sizes.put("VM5", new VMSize(1, 4, 10));

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Arrays.asList("VM1", "VM2", "VM3", "VM4"),//, "VM5"),
                sizes,
                logLinks,
                coefficients,
                Collections.singletonList(n15),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testTooMuchIdleVM() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode b = makeXPFE("b", 5, 1);
        TopologyNode c = makeXPFE("c", 5, 1);
        TopologyNode x = makeXPU("x", 5, 12, 1);
        TopologyNode y = makeXPU("y", 5, 4, 1);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(x);
        nodes.add(y);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, b, 50, 1000);
        addDuplexLink(links, b, c, 1, 1000);
        addDuplexLink(links, b, x, 50, 1000);
        addDuplexLink(links, c, y, 50, 1000);
        addDuplexLink(links, x, b, 50, 1000);
        addDuplexLink(links, y, c, 50, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Collections.singletonList("VM1"),
                Collections.singletonMap("VM1", new VMSize(1, 4, 10)),
                logLinks,
                Collections.emptyMap(),
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testTooMuchLinkPower() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode b = makeXPFE("b", 5, 1);
        TopologyNode c = makeXPFE("c", 5, 1);
        TopologyNode x = makeXPU("x", 5, 3, 1);
        TopologyNode y = makeXPU("y", 5, 3, 1);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(x);
        nodes.add(y);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, b, 5, 1000);
        addDuplexLink(links, b, c, 5, 1000);
        addDuplexLink(links, b, x, 50, 1000);
        addDuplexLink(links, c, y, 5, 1000);
        addDuplexLink(links, x, b, 5, 1000);
        addDuplexLink(links, y, c, 5, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Collections.singletonList("VM1"),
                Collections.singletonMap("VM1", new VMSize(1, 4, 10)),
                logLinks,
                Collections.emptyMap(),
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void testNotEnoughCapabilities() throws Exception {

        /*
         *          x
         *          |
         *  a   -   b   -   c
         *                  |
         *                  y
         */

        List<TopologyNode> nodes = new ArrayList<>();
        TopologyNode a = makeXPFE("a", 5, 1);
        TopologyNode b = makeXPFE("b", 5, 1);
        TopologyNode c = makeXPFE("c", 5, 1);
        TopologyNode x = makeXPU("x", 5, 12, 1, 50, 4, 1);
        TopologyNode y = makeXPU("y", 5, 4, 1);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(x);
        nodes.add(y);

        List<TopologyLink> links = new ArrayList<>();
        addDuplexLink(links, a, b, 50, 1000);
        addDuplexLink(links, b, c, 1, 1000);
        addDuplexLink(links, b, x, 50, 1000);
        addDuplexLink(links, c, y, 50, 1000);
        addDuplexLink(links, x, b, 50, 1000);
        addDuplexLink(links, y, c, 50, 1000);

        NetworkTopology topology = new NetworkTopology(nodes, links);

        Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
        logLinks.put(new LogicalLinkParameters("a", null, "VM1"), 1D);

        DijkstraFormatter formatter = new DijkstraFormatter(
                topology,
                Collections.singletonList("VM1"),
                Collections.singletonMap("VM1", new VMSize(2, 8, 10)),
                logLinks,
                Collections.emptyMap(),
                Collections.singletonList(a),
                Collections.emptyMap(),
                "TEST");
        System.out.println(formatter.internalSolve());
    }

    @Test
    public void performanceTest() throws Exception {
        int tries = 100;
        for (int i = 0; i < 10; i++) {
            testBiggerMoreVm();
        }
        Instant start = Instant.now();
        for (int i = 0; i < tries; i++) {
            testBiggerMoreVm();
        }
        Instant end = Instant.now();

        Duration time = Duration.between(start, end);

        System.out.printf("Timing result: %s tries, total time: %s, average time: %s",
                tries, time.toMillis(), time.toMillis() / 100
        );
    }
}
