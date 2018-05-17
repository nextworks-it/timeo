package it.nextworks.nfvmano.timeo.rc.algorithms;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra.DijkstraFormatter;
import it.nextworks.nfvmano.timeo.rc.algorithms.emma.LPFormatter;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.Vim;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperComputeNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperFlavors;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperPlugin;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Created by Marco Capitani on 19/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class RequestParserTest {

    private RequestParser parser;

    private Vnfd eNB;
    private Vnfd mme;
    private Vnfd hss;
    private Vnfd gw;

    private Nsd vEPC;

    private Formatter formatter;

    public static class WrappedNsd {
        public Nsd nsd;
    }

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

            vEPC = mapper.readValue(vEPCString, WrappedNsd.class).nsd;
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

    @Before
    public void setup() throws Exception {
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

        Map<Vnfd, Map<String, String>> vnfds = new HashMap<>();
        vnfds.put(mme, makeVnfDataMap("mme", "df_mme", "1", "il_mme"));
        vnfds.put(eNB, makeVnfDataMap("oaisim", "df_oaisim", "1", "il_oaisim"));
        vnfds.put(hss, makeVnfDataMap("hss", "df_hss", "1", "il_hss"));
        vnfds.put(gw, makeVnfDataMap("spgw", "df_spgw", "1", "il_spgw"));

        VimWrapperPlugin wrapper = mock(VimWrapperPlugin.class);

        List<WrapperComputeNode> computeList = Collections.emptyList();

        when(wrapper.getComputeDataForAlgorithm()).thenReturn(computeList);

        parser = new RequestParser(
                request,
                sdn,
                vimPlugin,
                vEPC,
                vnfds,
                wrapper
        );
    }

    private TopologyNode makeXPU(String id) {
        return new TopologyNode(
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
    }

    private TopologyNode makeXPFE(String id) {
        return new TopologyNode(
                id,
                new HashSet<>(),
                55,
                PowerState.SLEEPING
        );
    }

    @Test
    public void makeFormatter() throws Exception {
        formatter = parser.makeFormatter(DijkstraFormatter::new);

        System.out.println("Topology: " + parser.networkTopology.toString());
        System.out.println("Sizes: " + parser.sizes.toString());
        System.out.println("LogLinks: " + parser.logLinks.toString());
        System.out.println("Coeffs: " + parser.coefficients.toString());
        System.out.println("Placement: " + parser.vmPlacement.toString());
    }

    @Test
    public void run() throws Exception {
        makeFormatter();
        System.out.println(formatter.solve());
    }

    @Test
    public void testWrapperInput() {

        List<WrapperComputeNode> computeList = new ArrayList<>();

        List<WrapperFlavors> flavors1 = new ArrayList<>();
        WrapperFlavors flavorVM1 = new WrapperFlavors();
        flavorVM1.id = "VM";
        flavorVM1.idlePc = 3.3;
        flavorVM1.trafficPc = 4.1;
        flavors1.add(flavorVM1);

        WrapperComputeNode compute1 = new WrapperComputeNode();
        compute1.hostId = "compute1";
        compute1.idlePc = 2.9;
        compute1.vCpu = 8;
        compute1.vDisk = 512;
        compute1.vRam = 128;
        compute1.mac = "5e:0d:4a:f4:54:64";
        compute1.zoneId = "zone1";
        compute1.powerState = PowerState.SLEEPING;
        compute1.flavors = flavors1;
        computeList.add(compute1);

        List<WrapperFlavors> flavors2 = new ArrayList<>(flavors1);
        List<WrapperFlavors> flavors3 = new ArrayList<>(flavors1);
        List<WrapperFlavors> flavors4 = new ArrayList<>(flavors1);

        WrapperFlavors flavorExtra4 = new WrapperFlavors();
        flavorVM1.id = "extra";
        flavorVM1.idlePc = 6.3;
        flavorVM1.trafficPc = 12.1;
        flavors4.add(flavorExtra4);

        WrapperComputeNode compute2 = new WrapperComputeNode();
        compute2.hostId = "compute2";
        compute2.idlePc = 2.6;
        compute2.vCpu = 4;
        compute2.vDisk = 256;
        compute2.vRam = 64;
        compute2.mac = "96:e4:07:8c:be:fb";
        compute2.zoneId = "zone1";
        compute2.powerState = PowerState.SLEEPING;
        compute2.flavors = flavors2;
        computeList.add(compute2);

        WrapperComputeNode compute3 = new WrapperComputeNode();
        compute3.hostId = "compute3";
        compute3.idlePc = 4.0;
        compute3.vCpu = 12;
        compute3.vDisk = 1024;
        compute3.vRam = 128;
        compute3.mac = "26:8b:de:0d:98:76";
        compute3.zoneId = "zone2";
        compute3.powerState = PowerState.MEDIUM_POWER;
        compute3.flavors = flavors3;
        computeList.add(compute3);

        WrapperComputeNode compute4 = new WrapperComputeNode();
        compute4.hostId = "compute4";
        compute4.idlePc = 3.2;
        compute4.vCpu = 6;
        compute4.vDisk = 256;
        compute4.vRam = 32;
        compute4.mac = "fe:7e:dc:20:35:8c";
        compute4.zoneId = "zone2";
        compute4.powerState = PowerState.HIGH_POWER;
        compute4.flavors = flavors4;
        computeList.add(compute4);

        // TODO
    }
}