package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import it.nextworks.nfvmano.libs.common.elements.QoS;
import it.nextworks.nfvmano.libs.common.enums.AddressType;
import it.nextworks.nfvmano.libs.common.enums.IpVersion;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.enums.ServiceAvailabilityLevel;
import it.nextworks.nfvmano.libs.descriptors.common.elements.AddressData;
import it.nextworks.nfvmano.libs.descriptors.common.elements.ConnectivityType;
import it.nextworks.nfvmano.libs.descriptors.common.elements.LinkBitrateRequirements;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkDf;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.Dependencies;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsDf;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsLevel;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsToLevelMapping;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkConnectivity;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkDesc;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.PnfProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.Sapd;
import it.nextworks.nfvmano.libs.descriptors.nsd.SecurityParameters;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfToLevelMapping;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Marco Capitani on 29/01/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class TestNsds {

    private AddressData makeAddressData(boolean floatingIp, boolean management) {
        return new AddressData(
                AddressType.IP_ADDRESS,
                false,
                floatingIp,
                management,
                IpVersion.IPv4,
                1
        );
    }

    private Sapd makeSapd(
            String cpdId,
            String description,
            boolean floatingIp,
            boolean management,
            String virtualLinkId,
            String subCpdId
    ) {
        return new Sapd(
                null,
                cpdId,
                LayerProtocol.IPV4,
                null,
                description,
                Collections.singletonList(
                        makeAddressData(floatingIp, management)
                ),
                false,
                virtualLinkId,
                subCpdId
        );
    }

    private NsVirtualLinkDesc makeVld(Map.Entry<String, String> entry) {
        return makeVld(entry.getKey(), entry.getValue());
    }

    private NsVirtualLinkDesc makeVld(String vldId, String description) {
        NsVirtualLinkDesc out = new NsVirtualLinkDesc(
                null,
                vldId,
                "Nextworks",
                "0.1",
                new ConnectivityType(
                        LayerProtocol.IPV4,
                        null
                ),
                Collections.emptyList(),
                description,
                null
        );
        out.addDeploymentFlavour(
                new VirtualLinkDf(
                        out,
                        vldId + "_vldf",
                        new QoS(0, 0, 0, 0),
                        ServiceAvailabilityLevel.LEVEL_1
                )
        );
        return out;
    }

    private static final List<Class<?>> ADMISSABLE_TYPES = Arrays.asList(
            VnfProfile.class,
            PnfProfile.class,
            NsProfile.class
    );

    private NsVirtualLinkConnectivity makeVlConn(String vlId, List<String> cpIds, Class<?> type) {
        if (!ADMISSABLE_TYPES.contains(type)) {
            throw new IllegalArgumentException(String.format(
                    "Not admissable type: %s",
                    type.getSimpleName()
            ));
        }
        if (type.equals(VnfProfile.class)) {
            return new NsVirtualLinkConnectivity(
                    (VnfProfile) null,
                    vlId + "_profile",
                    cpIds
            );
        } else if (type.equals(PnfProfile.class)) {
            return new NsVirtualLinkConnectivity(
                    (PnfProfile) null,
                    vlId + "_profile",
                    cpIds
            );
        } else if (type.equals(NsProfile.class)) {
            return new NsVirtualLinkConnectivity(
                    (NsProfile) null,
                    vlId + "_profile",
                    cpIds
            );
        } else {
            throw new IllegalStateException("Should not happen");
        }
    }

    private NsProfile makeNsProfile(String nsdId, int minInst, int maxInst, Map<String, List<String>> nsMapping) {
        return new NsProfile(
                null,
                nsdId + "_profile",
                nsdId,
                nsdId + "_df",
                nsdId + "_il",
                minInst,
                maxInst,
                Collections.emptyList(),
                nsMapping.entrySet()
                        .stream()
                        .map(e -> makeVlConn(e.getKey(), e.getValue(), NsProfile.class))
                        .collect(Collectors.toList())
        );
    }

    private VnfProfile makeVnfProfile(String vnfdId, int minInst, int maxInst, Map<String, List<String>> vlMapping) {
        return new VnfProfile(
                null,
                vnfdId + "_profile",
                vnfdId,
                vnfdId + "_df",
                vnfdId + "_il",
                minInst,
                maxInst,
                Collections.emptyList(),
                Collections.emptyList(),
                vlMapping.entrySet()
                        .stream()
                        .map(e -> makeVlConn(e.getKey(), e.getValue(), VnfProfile.class))
                        .collect(Collectors.toList())
        );
    }

    private VnfProfile makeVnfProfile(String vnfdId, int maxInst, Map<String, List<String>> vlMapping) {
        return makeVnfProfile(
                vnfdId,
                1,
                maxInst,
                vlMapping
        );
    }

    private VnfProfile makeVnfProfile(String vnfdId, Map<String, List<String>> vlMapping) {
        return makeVnfProfile(
                vnfdId,
                1,
                1,
                vlMapping
        );
    }

    private Map<String, List<String>> makeVlMapping(String... vlId2cpId) {
        Map<String, List<String>> out = new HashMap<>();
        for (String entry : vlId2cpId) {
            String[] split = entry.split("->");
            if (split.length != 2) {
                throw new IllegalArgumentException(String.format("Illegal entry %s", entry));
            }
            out.put(split[0], Collections.singletonList(split[1]));
        }
        return out;
    }

    private VirtualLinkProfile makeVLProfile(String vldId) {
        return new VirtualLinkProfile(
                (NsDf) null,
                vldId + "_profile",
                vldId,
                vldId + "_vldf",
                Collections.emptyList(),
                Collections.emptyList(),
                new LinkBitrateRequirements(
                        "1", "1"
                ),
                new LinkBitrateRequirements(
                        "1", "1"
                )
        );
    }

    private NsLevel makeNsLevel(
            String nsdId,
            String description,
            Map<String, Integer> vnfMapping,
            Map<String, Integer> nsMapping
    ) {
        return new NsLevel(
                (NsDf) null,
                nsdId + "_il",
                description,
                vnfMapping.entrySet()
                        .stream()
                        .map(e -> new VnfToLevelMapping(
                                e.getKey() + "_profile",
                                e.getValue()
                        ))
                        .collect(Collectors.toList()),
                nsMapping.entrySet()
                        .stream()
                        .map(e -> new NsToLevelMapping(
                                e.getKey() + "_profile",
                                e.getValue()
                        ))
                        .collect(Collectors.toList())
        );
    }

    private NsDf makeNsDf(
            String nsdId,
            Map<String, Integer> vnfMapping,
            Map<String, Integer> nsMapping,
            List<VnfProfile> vnfProfiles,
            List<NsProfile> nsProfiles,
            Collection<String> vldIds,
            List<Dependencies> dependencies
    ) {
        return new NsDf(
                null,
                nsdId + "_df",
                nsdId + "_df",
                vnfProfiles,
                Collections.emptyList(),
                vldIds.stream().map(this::makeVLProfile).collect(Collectors.toList()),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.singletonList(
                        makeNsLevel(
                                nsdId,
                                nsdId + " instantiation level",
                                vnfMapping,
                                nsMapping
                        )
                ),
                nsdId + "_il",
                nsProfiles,
                dependencies
        );
    }

    @Test
    public void testEHealthVEPC() throws Exception {
        String nsdId = "eHealth-vEPC";
        String nsdVersion = "0.1";
        List<String> vnfs = Arrays.asList("MME_VNF", "HSS_VNF", "S-GW_VNF", "P-GW_VNF");
        Map<String, Integer> vnfMapping = vnfs.stream().collect(Collectors.toMap(Function.identity(), _p -> 1));
        vnfMapping.put("S-GW_VNF", 3);
        List<VnfProfile> vnfProfiles = Arrays.asList(
                makeVnfProfile(
                        "MME_VNF",
                        makeVlMapping(
                                "s1c_s1u_vepc_vl->mme_s1c_extcp",
                                "s6a_vepc_vl->mme_s6a_extcp",
                                "s11_vepc_vl->mme_s11_extcp",
                                "mgt_vepc_vl->mme_mgt_extcp"
                        )
                ),
                makeVnfProfile(
                        "HSS_VNF",
                        makeVlMapping(
                                "mgt_vepc_vl->hss_mgt_extcp",
                                "s6a_vepc_vl->hss_s6a_extcp"
                        )
                ),
                makeVnfProfile(
                        "P-GW_VNF",
                        makeVlMapping(
                                "sgi_vepc_vl->pgw_sgi_extcp",
                                "s5_vepc_vl->pgw_s5_extcp",
                                "mgt_vepc_vl->pgw_mgt_extcp"
                        )
                ),
                makeVnfProfile(
                        "S-GW_VNF",
                        64,
                        makeVlMapping(
                                "s1c_s1u_vepc_vl->sgw_s1c_extcp",
                                "s11_vepc_vl->sgw_s11_extcp",
                                "s5_vepc_vl->sgw_s5_extcp",
                                "mgt_vepc_vl->sgw_mgt_extcp"
                        )
                )
        );
        Map<String, String> vlds = new HashMap<>();
        vlds.put("s1c_s1u_vepc_vl", "s1c/u vLink");
        vlds.put("sgi_vepc_vl", "sgi vLink");
        vlds.put("s5_vepc_vl", "s5 vLink");
        vlds.put("s11_vepc_vl", "s11 vLink");
        vlds.put("s6a_vepc_vl", "s6a vLink");
        vlds.put("mgt_vepc_vl", "Management vLink");

        Nsd nsd = new Nsd(
                nsdId,
                "UC3M-Nextworks",
                nsdVersion,
                "vEPC for eHealth",
                nsdId + "_" + nsdVersion,
                Collections.emptyList(),
                vnfs,
                Collections.emptyList(),
                Arrays.asList(
                        makeSapd(
                                "s1c_s1u_vepc_sap",
                                "Radio SAP",
                                false,
                                false,
                                "s1c_s1u_vepc_vl",
                                null
                        ),
                        makeSapd(
                                "sgi_vepc_sap",
                                "SGI SAP",
                                false,
                                false,
                                "sgi_vepc_vl",
                                null
                        ),
                        makeSapd(
                                "s5_vepc_sap",
                                "S5 SAP",
                                false,
                                false,
                                "s5_vepc_vl",
                                null
                        ),
                        makeSapd(
                                "mgt_vepc_sap",
                                "SGI SAP",
                                true,
                                true,
                                "mgt_vepc_vl",
                                null
                        )
                ),
                vlds.entrySet().stream().map(this::makeVld).collect(Collectors.toList()),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.singletonList(
                        makeNsDf(
                                nsdId,
                                vnfMapping,
                                Collections.emptyMap(),
                                vnfProfiles,
                                Collections.emptyList(),
                                vlds.keySet(),
                                Collections.emptyList()
                        )
                ),
                new SecurityParameters(
                        "SIGNATURE",
                        "ALGORITHM",
                        "CERTIFICATE"
                )
        );
        nsd.isValid();
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(nsd));
    }

    @Test
    public void testEHealthBE() throws Exception {
        String nsdId = "eHealth-BE";
        String nsdVersion = "0.1";
        List<String> vnfs = Arrays.asList("LB_VNF", "SERVER_VNF");
        Map<String, Integer> vnfMapping = vnfs.stream().collect(Collectors.toMap(Function.identity(), _p -> 1));
        List<VnfProfile> vnfProfiles = Arrays.asList(
                makeVnfProfile(
                        "LB_VNF",
                        makeVlMapping(
                                "data_ehealth_mon_be_vl->lb_data_extcp",
                                "mgt_ehealth_mon_be_vl->lb_mgt_extcp"
                        )
                ),
                makeVnfProfile(
                        "SERVER_VNF",
                        makeVlMapping(
                                "data_ehealth_mon_be_vl->central_data_extcp",
                                "mgt_ehealth_mon_be_vl->central_mgt_extcp"
                        )
                )
        );
        Map<String, String> vlds = new HashMap<>();
        vlds.put("data_ehealth_mon_be_vl", "data vLink");
        vlds.put("mgt_ehealth_mon_be_vl", "mgt vLink");
        Nsd nsd = new Nsd(
                nsdId,
                "UC3M-Nextworks",
                nsdVersion,
                "Monitoring backend for eHealth",
                nsdId + "_" + nsdVersion,
                Collections.emptyList(),
                vnfs,
                Collections.emptyList(),
                Arrays.asList(
                        makeSapd(
                                "data_ehealth_mon_be_sap",
                                "Data SAP",
                                false,
                                false,
                                "data_ehealth_mon_be_vl",
                                null
                        ),
                        makeSapd(
                                "mgt_ehealth_mon_be_sap",
                                "Mgt SAP",
                                true,
                                true,
                                "mgt_ehealth_mon_be_vl",
                                null
                        )
                ),
                vlds.entrySet().stream().map(this::makeVld).collect(Collectors.toList()),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.singletonList(
                        makeNsDf(
                                nsdId,
                                vnfMapping,
                                Collections.emptyMap(),
                                vnfProfiles,
                                Collections.emptyList(),
                                vlds.keySet(),
                                Collections.emptyList()
                        )
                ),
                new SecurityParameters(
                        "SIGNATURE",
                        "ALGORITHM",
                        "CERTIFICATE"
                )
        );
        nsd.isValid();
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(nsd));
    }

    @Test
    public void testEHealthEdge() throws Exception {
        String nsdId = "eHealth-EDGE";
        String nsdVersion = "0.1";
        List<String> vnfs = Arrays.asList("E-SERVER_VNF", "E-PGW_VNF");
        Map<String, Integer> vnfMapping = vnfs.stream().collect(Collectors.toMap(Function.identity(), _p -> 1));
        List<VnfProfile> vnfProfiles = Arrays.asList(
                makeVnfProfile(
                        "E-PGW_VNF",
                        makeVlMapping(
                                "sgi_ehealth_emergency_edge_vl->e_pgw_sgi_extcp",
                                "s5_ehealth_emergency_edge_vl->e_pgw_s5_extcp",
                                "mgt_ehealth_emergency_edge_vl->e_pgw_mgt_extcp"
                        )
                ),
                makeVnfProfile(
                        "E-SERVER_VNF",
                        makeVlMapping(
                                "sgi_ehealth_emergency_edge_vl->e_server_sgi_extcp",
                                "mgt_ehealth_emergency_edge_vl->e_server_mgt_extcp"
                        )
                )
        );
        Map<String, String> vlds = new HashMap<>();
        vlds.put("sgi_ehealth_emergency_edge_vl", "sgi vLink");
        vlds.put("s5_ehealth_emergency_edge_vl", "s5 vLink");
        vlds.put("mgt_ehealth_emergency_edge_vl", "mgt vLink");
        Nsd nsd = new Nsd(
                nsdId,
                "UC3M-Nextworks",
                nsdVersion,
                "Edge components for emergency eHealth monitoring",
                nsdId + "_" + nsdVersion,
                Collections.emptyList(),
                vnfs,
                Collections.emptyList(),
                Arrays.asList(
                        makeSapd(
                                "sgi_ehealth_emergency_edge_sap",
                                "SGI SAP",
                                false,
                                false,
                                "sgi_ehealth_emergency_edge_vl",
                                null
                        ),
                        makeSapd(
                                "s5_ehealth_emergency_edge_sap",
                                "S5 SAP",
                                false,
                                false,
                                "s5_ehealth_emergency_edge_vl",
                                null
                        ),
                        makeSapd(
                                "mgt_ehealth_emergency_edge_sap",
                                "Mgt SAP",
                                true,
                                true,
                                "mgt_ehealth_emergency_edge_vl",
                                null
                        )
                ),
                vlds.entrySet().stream().map(this::makeVld).collect(Collectors.toList()),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.singletonList(
                        makeNsDf(
                                nsdId,
                                vnfMapping,
                                Collections.emptyMap(),
                                vnfProfiles,
                                Collections.emptyList(),
                                vlds.keySet(),
                                Collections.emptyList()
                        )
                ),
                new SecurityParameters(
                        "SIGNATURE",
                        "ALGORITHM",
                        "CERTIFICATE"
                )
        );
        nsd.isValid();
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(nsd));
    }

    @Test
    public void testEHealthStandard() throws Exception {
        String nsdId = "eHealth-Mon-NS";
        String nsdVersion = "0.1";
        List<String> nss = Arrays.asList("eHealth-BE", "eHealth-vEPC");
        Map<String, Integer> nsMapping = nss.stream().collect(Collectors.toMap(Function.identity(), _p -> 1));
        List<NsProfile> nsProfiles = Arrays.asList(
                makeNsProfile(
                        "eHealth-BE",
                        1,
                        1,
                        makeVlMapping(
                                "data_eHealth_mon_vl->data_ehealth_mon_be_sap",
                                "mgt_eHealth_mon_vl->mgt_ehealth_mon_be_sap"
                        )
                ),
                makeNsProfile(
                        "eHealth-vEPC",
                        1,
                        1,
                        makeVlMapping(
                                "data_eHealth_mon_vl->sgi_vepc_sap",
                                "mgt_eHealth_mon_vl->mgt_vepc_sap"
                        )
                )
        );
        Map<String, String> vlds = new HashMap<>();
        vlds.put("data_ehealth_mon_vl", "data vLink");
        vlds.put("mgt_ehealth_mon_vl", "mgt vLink");
        Nsd nsd = new Nsd(
                nsdId,
                "UC3M-Nextworks",
                nsdVersion,
                "eHealth Monitoring service",
                nsdId + "_" + nsdVersion,
                nss,
                Collections.emptyList(),
                Collections.emptyList(),
                Arrays.asList(
                        makeSapd(
                                "sgi_ehealth_mon_sap",
                                "Data SAP",
                                false,
                                false,
                                "data_ehealth_mon_vl",
                                null
                        ),
                        makeSapd(
                                "s5_ehealth_mon_sap",
                                "Data SAP",
                                false,
                                false,
                                null,
                                "s5_vepc_sap"
                        ),
                        makeSapd(
                                "s1c_s1u_ehealth_mon_sap",
                                "Data SAP",
                                false,
                                false,
                                null,
                                "s1c_s1u_vepc_sap"
                        ),
                        makeSapd(
                                "mgt_ehealth_mon_sap",
                                "Mgt SAP",
                                true,
                                true,
                                "mgt_ehealth_mon_vl",
                                null
                        )
                ),
                vlds.entrySet().stream().map(this::makeVld).collect(Collectors.toList()),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.singletonList(
                        makeNsDf(
                                nsdId,
                                Collections.emptyMap(),
                                nsMapping,
                                Collections.emptyList(),
                                nsProfiles,
                                vlds.keySet(),
                                Collections.emptyList()
                        )
                ),
                new SecurityParameters(
                        "SIGNATURE",
                        "ALGORITHM",
                        "CERTIFICATE"
                )
        );
        nsd.isValid();
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(nsd));
    }

    @Test
    public void testEHealthEmergency() throws Exception {
        String nsdId = "eHealth-emergency-NS";
        String nsdVersion = "0.1";
        List<String> nss = Arrays.asList("eHealth-Mon-NS", "eHealth-EDGE");
        Map<String, Integer> nsMapping = nss.stream().collect(Collectors.toMap(Function.identity(), _p -> 1));
        List<NsProfile> nsProfiles = Arrays.asList(
                makeNsProfile(
                        "eHealth-Mon-NS",
                        1,
                        1,
                        makeVlMapping(
                                "s5_ehealth_emergency_vl->s5_ehealth_mon_sap",
                                "sgi_ehealth_emergency_vl->sgi_ehealth_mon_sap",
                                "mgt_ehealth_emergency_vl->mgt_ehealth_mon_sap"
                        )
                ),
                makeNsProfile(
                        "eHealth-EDGE",
                        1,
                        1,
                        makeVlMapping(
                                "s5_ehealth_emergency_vl->s5_ehealth_emergency_edge_sap",
                                "sgi_ehealth_emergency_vl->sgi_ehealth_emergency_edge_sap",
                                "mgt_ehealth_emergency_vl->mgt_ehealth_emergency_edge_sap"
                        )
                )
        );
        Map<String, String> vlds = new HashMap<>();
        vlds.put("s5_ehealth_emergency_vl", "s5 vLink");
        vlds.put("sgi_ehealth_emergency_vl", "sgi vLink");
        vlds.put("mgt_ehealth_emergency_vl", "mgt vLink");
        Nsd nsd = new Nsd(
                nsdId,
                "UC3M-Nextworks",
                nsdVersion,
                "eHealth emergency monitoring service",
                nsdId + "_" + nsdVersion,
                nss,
                Collections.emptyList(),
                Collections.emptyList(),
                Arrays.asList(
                        makeSapd(
                                "s1c_s1u_ehealth_emergency_sap",
                                "Radio SAP",
                                false,
                                false,
                                null,
                                "s1c_s1u_ehealth_mon_sap"
                        ),
                        makeSapd(
                                "mgt_ehealth_emergency_sap",
                                "Mgt SAP",
                                true,
                                true,
                                "mgt_ehealth_mon_vl",
                                null
                        )
                ),
                vlds.entrySet().stream().map(this::makeVld).collect(Collectors.toList()),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.singletonList(
                        makeNsDf(
                                nsdId,
                                Collections.emptyMap(),
                                nsMapping,
                                Collections.emptyList(),
                                nsProfiles,
                                vlds.keySet(),
                                Collections.emptyList()
                        )
                ),
                new SecurityParameters(
                        "SIGNATURE",
                        "ALGORITHM",
                        "CERTIFICATE"
                )
        );
        nsd.isValid();
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(nsd));
    }
}
