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
package it.nextworks.nfvmano.timeo.rc.algorithms;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra.DijkstraAlgorithm;
import it.nextworks.nfvmano.timeo.rc.algorithms.emma.EmmaNetCompAlgorithm;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.Vim;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperPlugin;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Marco Capitani on 23/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
@Ignore
public class IntegrationTest {

    private Vnfd eNB;
    private Vnfd mme;
    private Vnfd hss;
    private Vnfd gw;

    private Nsd vEPC;

    private Vnfd spr1;
    private Vnfd spr21;
    private Vnfd spr22;
    private Vnfd ws;

    private Nsd cdn;

    private static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(
                    Paths.get("", "test", "descriptors", "0.1", path)),
                    StandardCharsets.UTF_8
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String readCDNFile(String path) {
        try {
            return new String(Files.readAllBytes(
                    Paths.get("", "test", "descriptors", "EuCNC_2018", path)),
                    StandardCharsets.UTF_8
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String eNBString = readFile("OAISIM_VNFD.json");
        String mmeString = readFile("MME_VNFD.json");
        String hssString = readFile("HSS_VNFD.json");
        String gwString = readFile("SPGW_VNFD.json");

        String vEPCString = readFile("vEPC_NSD.json");

        try {
            eNB = mapper.readValue(eNBString, Vnfd.class);
            mme = mapper.readValue(mmeString, Vnfd.class);
            hss = mapper.readValue(hssString, Vnfd.class);
            gw = mapper.readValue(gwString, Vnfd.class);

            vEPC = mapper.readValue(vEPCString, RequestParserTest.WrappedNsd.class).nsd;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // GET CDN DESC
        mapper = new ObjectMapper();

        String spr1String = readCDNFile("CDN_SPR1_VNFD.json");
        String spr21String = readCDNFile("CDN_SPR21_VNFD.json");
        String spr22String = readCDNFile("CDN_SPR22_VNFD.json");
        String wsString = readCDNFile("CDN_WEBSERVER_VNFD.json");

        String vCDNString = readCDNFile("CDN_all_NSD.json");

        try {
            spr1 = mapper.readValue(spr1String, Vnfd.class);
            spr21 = mapper.readValue(spr21String, Vnfd.class);
            spr22 = mapper.readValue(spr22String, Vnfd.class);
            ws = mapper.readValue(wsString, Vnfd.class);

            cdn = mapper.readValue(vCDNString, RequestParserTest.WrappedNsd.class).nsd;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> makeVnfDataMap(String vnfdId,
                                               String vnfFlavourId,
                                               String instances,
                                               String vnfInstantiationLevel) {
        HashMap<String, String> vnfdDetail = new HashMap<>();
        vnfdDetail.put("VNFD_ID", vnfdId);
        vnfdDetail.put("VNF_DF_ID", vnfFlavourId);
        vnfdDetail.put("VNF_INSTANCES", instances);
        vnfdDetail.put("VNF_INSTANTIATION_LEVEL", vnfInstantiationLevel);
        return vnfdDetail;
    }

    private TopologyNode makeXPU(String id) {
        TopologyNode node = new TopologyNode(
                id,
                new HashSet<>(),
                50,
                8,
                4,
                65,
                10,
                PowerState.SLEEPING,
                "zone1",
                id
        );
        node.setProcessing(10 * 5);
        return node;
    }

    private TopologyNode makeXPFE(String id) {
        TopologyNode node = new TopologyNode(
                id,
                new HashSet<>(),
                55,
                PowerState.SLEEPING
        );
        node.setProcessing(1000.0);
        return node;
    }

    @Test
    public void runDijkstraTest() throws Exception {

        DijkstraAlgorithm algo = new DijkstraAlgorithm();

        InstantiateNsRequest request = mock(InstantiateNsRequest.class);
        when(request.getNsInstanceId()).thenReturn("TEST");
        when(request.getFlavourId()).thenReturn("df_vEPC");

        NetworkTopology topology = new NetworkTopology(new ArrayList<>(), new ArrayList<>());
        TopologyNode s1 = makeXPU("S1");
        TopologyNode s2 = makeXPU("S2");
        TopologyNode s3 = makeXPU("S3");
        TopologyNode l1 = makeXPFE("L1");
        TopologyNode l2 = makeXPFE("L2");
        TopologyNode l3 = makeXPFE("L3");
        TopologyNode mgmt = new TopologyNode("mgmt", new HashSet<>());
        mgmt.setProcessing(10000.0);
        topology.addNode(s1);
        topology.addNode(s2);
        topology.addNode(s3);
        topology.addNode(l1);
        topology.addNode(l2);
        topology.addNode(l3);
        topology.addNode(mgmt);
        topology.addLink("s1->l1", s1, l1, "10.0.1.1", "s1:1", "10.100.1.1", "l1:1", 5, 1000);
        topology.addLink("s2->l2", s2, l2, "10.0.2.1", "s2:1", "10.100.2.2", "l2:2", 5, 1000);
        topology.addLink("s3->l3", s3, l3, "10.0.3.1", "s3:1", "10.100.3.3", "l3:3", 5, 1000);
        topology.addLink("l1->l2", l1, l2, "10.100.1.2", "l1:2", "10.100.2.1", "l2:1", 5, 1000);
        topology.addLink("l1->l3", l1, l3, "10.100.1.3", "l1:3", "10.100.3.1", "l3:1", 5, 1000);
        topology.addLink("l2->l3", l2, l3, "10.100.2.3", "l2:3", "10.100.3.2", "l3:2", 5, 1000);
        topology.addLink("s1->mgmt", s1, mgmt, "192.168.100.100", "s1:4", "192.168.100.1", "mgmt:1", 5, 1000);

        SdnControllerPlugin sdn = mock(SdnControllerPlugin.class);
        when(sdn.getNetworkTopology()).thenReturn(topology);

        Vim vim = mock(Vim.class);
        when(vim.getNetworkNodeMacAddress()).thenReturn("192.168.100.1");

        VimPlugin vimPlugin = mock(VimPlugin.class);
        when(vimPlugin.getVim()).thenReturn(vim);

        VimWrapperPlugin wrapper = mock(VimWrapperPlugin.class);
        when(wrapper.getComputeDataForAlgorithm()).thenReturn(Collections.emptyList());

        Map<Vnfd, Map<String, String>> vnfds = new HashMap<>();
        vnfds.put(mme, makeVnfDataMap("mme", "df_mme", "1", "il_mme"));
        vnfds.put(eNB, makeVnfDataMap("oaisim", "df_oaisim", "1", "il_oaisim"));
        vnfds.put(hss, makeVnfDataMap("hss", "df_hss", "1", "il_hss"));
        vnfds.put(gw, makeVnfDataMap("spgw", "df_spgw", "1", "il_spgw"));

        NsResourceSchedulingSolution sol = algo.computeNsResourceAllocationSolution(
                request,
                vEPC,
                vnfds,
                vimPlugin,
                sdn,
                wrapper
        );

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String solAsStr = mapper.writeValueAsString(sol);
        System.out.println(solAsStr);
    }

    @Test
    public void DijkstraCDNTest() throws Exception {

        DijkstraAlgorithm algo = new DijkstraAlgorithm();

        InstantiateNsRequest request = mock(InstantiateNsRequest.class);
        when(request.getNsInstanceId()).thenReturn("TEST");
        when(request.getFlavourId()).thenReturn("df_vCDN");
        when(request.getNsInstantiationLevelId()).thenReturn("il_vCDN_big");

        NetworkTopology topology = new NetworkTopology(new ArrayList<>(), new ArrayList<>());
        TopologyNode s1 = makeXPU("S1");
        TopologyNode s2 = makeXPU("S2");
        TopologyNode s3 = makeXPU("S3");
        TopologyNode l1 = makeXPFE("L1");
        TopologyNode l2 = makeXPFE("L2");
        TopologyNode l3 = makeXPFE("L3");
        TopologyNode mgmt = new TopologyNode("mgmt", new HashSet<>());
        mgmt.setProcessing(10000.0);
        topology.addNode(s1);
        topology.addNode(s2);
        topology.addNode(s3);
        topology.addNode(l1);
        topology.addNode(l2);
        topology.addNode(l3);
        topology.addNode(mgmt);
        topology.addLink("s1->l1", s1, l1, "10.0.1.1", "s1:1", "10.100.1.1", "l1:1", 5, 1000);
        topology.addLink("s2->l2", s2, l2, "10.0.2.1", "s2:1", "10.100.2.2", "l2:2", 5, 1000);
        topology.addLink("s3->l3", s3, l3, "10.0.3.1", "s3:1", "10.100.3.3", "l3:3", 5, 1000);
        topology.addLink("l1->l2", l1, l2, "10.100.1.2", "l1:2", "10.100.2.1", "l2:1", 5, 1000);
        topology.addLink("l1->l3", l1, l3, "10.100.1.3", "l1:3", "10.100.3.1", "l3:1", 5, 1000);
        topology.addLink("l2->l3", l2, l3, "10.100.2.3", "l2:3", "10.100.3.2", "l3:2", 5, 1000);
        topology.addLink("s1->mgmt", s1, mgmt, "192.168.100.100", "s1:4", "192.168.100.1", "mgmt:1", 5, 1000);

        SdnControllerPlugin sdn = mock(SdnControllerPlugin.class);
        when(sdn.getNetworkTopology()).thenReturn(topology);

        Vim vim = mock(Vim.class);
        when(vim.getNetworkNodeMacAddress()).thenReturn("192.168.100.1");

        VimPlugin vimPlugin = mock(VimPlugin.class);
        when(vimPlugin.getVim()).thenReturn(vim);

        VimWrapperPlugin wrapper = mock(VimWrapperPlugin.class);
        when(wrapper.getComputeDataForAlgorithm()).thenReturn(Collections.emptyList());

        Map<Vnfd, Map<String, String>> vnfds = new HashMap<>();
        vnfds.put(spr1, makeVnfDataMap("spr1", "df_spr1", "1", "il_spr1"));
        vnfds.put(spr21, makeVnfDataMap("spr21", "df_spr21", "1", "il_spr21"));
        vnfds.put(spr22, makeVnfDataMap("spr22", "df_spr22", "1", "il_spr22"));
        vnfds.put(ws, makeVnfDataMap("webserver", "df_webserver", "1", "il_webserver"));

        NsResourceSchedulingSolution sol = algo.computeNsResourceAllocationSolution(
                request,
                cdn,
                vnfds,
                vimPlugin,
                sdn,
                wrapper
        );

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String solAsStr = mapper.writeValueAsString(sol);
        System.out.println(solAsStr);
    }

    //@Test
    public void runEmmaTest() throws Exception {

        EmmaNetCompAlgorithm algo = new EmmaNetCompAlgorithm();

        InstantiateNsRequest request = mock(InstantiateNsRequest.class);
        when(request.getNsInstanceId()).thenReturn("TEST");
        when(request.getFlavourId()).thenReturn("df_vEPC");

        NetworkTopology topology = new NetworkTopology(new ArrayList<>(), new ArrayList<>());
        TopologyNode s1 = makeXPU("S1");
        TopologyNode s2 = makeXPU("S2");
        TopologyNode s3 = makeXPU("S3");
        TopologyNode l1 = makeXPFE("L1");
        TopologyNode l2 = makeXPFE("L2");
        TopologyNode l3 = makeXPFE("L3");
        TopologyNode mgmt = new TopologyNode("mgmt", new HashSet<>());
        mgmt.setProcessing(10000.0);
        topology.addNode(s1);
        topology.addNode(s2);
        topology.addNode(s3);
        topology.addNode(l1);
        topology.addNode(l2);
        topology.addNode(l3);
        topology.addNode(mgmt);
        topology.addLink("s1->l1", s1, l1, "10.0.1.1", "s1:1", "10.100.1.1", "l1:1", 5, 1000);
        topology.addLink("s2->l2", s2, l2, "10.0.2.1", "s2:1", "10.100.2.2", "l2:2", 5, 1000);
        topology.addLink("s3->l3", s3, l3, "10.0.3.1", "s3:1", "10.100.3.3", "l3:3", 5, 1000);
        topology.addLink("l1->l2", l1, l2, "10.100.1.2", "l1:2", "10.100.2.1", "l2:1", 5, 1000);
        topology.addLink("l1->l3", l1, l3, "10.100.1.3", "l1:3", "10.100.3.1", "l3:1", 5, 1000);
        topology.addLink("l2->l3", l2, l3, "10.100.2.3", "l2:3", "10.100.3.2", "l3:2", 5, 1000);
        topology.addLink("s1->mgmt", s1, mgmt, "192.168.100.100", "s1:4", "192.168.100.1", "mgmt:1", 5, 1000);

        SdnControllerPlugin sdn = mock(SdnControllerPlugin.class);
        when(sdn.getNetworkTopology()).thenReturn(topology);

        Vim vim = mock(Vim.class);
        when(vim.getNetworkNodeMacAddress()).thenReturn("192.168.100.1");

        VimPlugin vimPlugin = mock(VimPlugin.class);
        when(vimPlugin.getVim()).thenReturn(vim);

        VimWrapperPlugin wrapper = mock(VimWrapperPlugin.class);
        when(wrapper.getComputeDataForAlgorithm()).thenReturn(Collections.emptyList());

        Map<Vnfd, Map<String, String>> vnfds = new HashMap<>();
        vnfds.put(mme, makeVnfDataMap("mme", "df_mme", "1", "il_mme"));
        vnfds.put(eNB, makeVnfDataMap("oaisim", "df_oaisim", "1", "il_oaisim"));
        vnfds.put(hss, makeVnfDataMap("hss", "df_hss", "1", "il_hss"));
        vnfds.put(gw, makeVnfDataMap("spgw", "df_spgw", "1", "il_spgw"));

        NsResourceSchedulingSolution sol = algo.computeNsResourceAllocationSolution(
                request,
                vEPC,
                vnfds,
                vimPlugin,
                sdn,
                wrapper
        );

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String solAsStr = mapper.writeValueAsString(sol);
        System.out.println(solAsStr);
    }
}
