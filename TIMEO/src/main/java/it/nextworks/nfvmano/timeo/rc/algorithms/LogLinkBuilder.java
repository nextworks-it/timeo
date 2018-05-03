package it.nextworks.nfvmano.timeo.rc.algorithms;


import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.LinkBitrateRequirements;
//import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkDf;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsLevel;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkConnectivity;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkDesc;
import it.nextworks.nfvmano.libs.descriptors.nsd.Sapd;
import it.nextworks.nfvmano.libs.descriptors.nsd.VirtualLinkToLevelMapping;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfProfile;
import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiationLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfDf;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Marco Capitani on 19/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class LogLinkBuilder {

    // Output data
    private Map<LogicalLinkParameters, Double> logLinks = new HashMap<>();
    private Map<TrafficCoefficientParameters, Double> coefficients = new HashMap<>();
    Map<String, VirtualMachine> vms = new HashMap<>();

    // Input data
    private Map<Vnfd, Map<String, String>> vnfds;
    private List<VnfProfile> vnfProfiles;
//    private List<NsVirtualLinkDesc> virtualLinkDesc;
    private List<VirtualLinkProfile> profiles;
    private List<Sapd> saps;
    private TopologyNode fep;
    private NsLevel nsLevel;

    // Working data
    private Map<String, List<LogicalLinkParameters>> vm2InLogLinks = new HashMap<>();
    private Map<String, List<LogicalLinkParameters>> vm2OutLogLinks = new HashMap<>();

    // Cache
//    private Map<String, VirtualLinkDf> vl2FlavourCache = null;

    LogLinkBuilder(Map<Vnfd, Map<String, String>> vnfds,
                   List<VnfProfile> vnfProfiles,
                   List<NsVirtualLinkDesc> virtualLinkDesc,
                   List<VirtualLinkProfile> profiles,
                   List<Sapd> saps,
                   TopologyNode fep,
                   NsLevel nsLevel) {
        this.vnfds = vnfds;
        this.vnfProfiles = vnfProfiles;
        //this.virtualLinkDesc = virtualLinkDesc;
        this.profiles = profiles;
        this.saps = saps;
        this.fep = fep;
        this.nsLevel = nsLevel;
    }

    Map<LogicalLinkParameters, Double> getLogLinks() {
        return logLinks;
    }

    Map<TrafficCoefficientParameters, Double> getCoefficients() {
        return coefficients;
    }

    /**
     * Build the vm list, adding all of the vdu as instances of the VirtualMachine class.
     * @param flavourId the desired vnf flavour
     * @param instantiationLevel the instantiation level
     * @throws NotExistingEntityException If the requested instantiation level is not found in the vnfd
     */
    private void buildVms(Vnfd vnfd, String flavourId, String instantiationLevel, int instances)
            throws NotExistingEntityException {
        VnfDf vnfDf = vnfd.getVnfDf(flavourId);
        InstantiationLevel il = vnfDf.getInstantiationLevel(instantiationLevel);
        // <instances vnfs> ...
        for (int i = 0; i < instances; i++) {
            // each containing each vdu
            for (VduLevel vduLevel : il.getVduLevel()) {
                String vduId = vduLevel.getVduId();
                for (int j = 0; j < vduLevel.getNumberOfInstances(); j++) {
                    VirtualMachine newVm = new VirtualMachine(vduId, j, vnfd, i);
                    vms.put(newVm.getId(), newVm);
                }
            }
        }
    }

    /**
     * Builds a map with key = vlProfileId and value = vldId
     * @return the map built
     */
    private Map<String, String> buildVlProfile2IdMap() {
        Map<String, String> output = new HashMap<>();
        for (VirtualLinkProfile profile : profiles) {
            output.put(profile.getVirtualLinkProfileId(), profile.getVirtualLinkDescId());
        }
        return output;
    }
    
    /**
     * Builds a map with key = vldId and value = bitrate-requirements
     * 
     * @return the map
     */
    private Map<String, LinkBitrateRequirements> buildVldId2BitrateMap() {
    	Map<String, String> vlProfile2VldIdMap = buildVlProfile2IdMap();
    	Map<String, LinkBitrateRequirements> output = new HashMap<>();
    	List<VirtualLinkToLevelMapping> vltlms = nsLevel.getVirtualLinkToLevelMapping();
    	for (VirtualLinkToLevelMapping vltlm : vltlms) {
    		String vlProfileId = vltlm.getVirtualLinkProfileId();
    		LinkBitrateRequirements br = vltlm.getBitRateRequirements();
    		String vldId = vlProfile2VldIdMap.get(vlProfileId);
    		output.put(vldId, br);
    	}
    	return output;
    }

    /**
     * Builds a map with key = vlFlavourId and value = vldId
     * @return the map built
     *
    private Map<String, String> buildId2FlavourMap() {
        Map<String, String> output = new HashMap<>();
        for (VirtualLinkProfile profile : profiles) {
            output.put(profile.getVirtualLinkDescId(), profile.getFlavourId());
        }
        return output;
    }
    */

    /**
     * Builds a map with key = extCpdId and value = vldId to which it is attached.
     * @return the built map
     */
    private Map<String, String> buildExtCpMap() throws NotExistingEntityException {
        Map<String, String> profile2Id = buildVlProfile2IdMap();
        Map<String, String> output = new HashMap<>();
        for (VnfProfile profile : vnfProfiles) {
            List<NsVirtualLinkConnectivity> vLinks = profile.getNsVirtualLinkConnectivity();
            for (NsVirtualLinkConnectivity vLink : vLinks) {
                String vldId = profile2Id.get(vLink.getVirtualLinkProfileId());
                if (vldId == null) {
                    throw new NotExistingEntityException(
                            String.format("Virtual link with profile %s not found.", vLink.getVirtualLinkProfileId())
                    );
                }
                List<String> extCpdIds = vLink.getCpdId();
                for (String extCpdId : extCpdIds) {
                    output.put(extCpdId, vldId);
                }
            }
        }
        return output;
    }

    private void bindVLinks() throws NotExistingEntityException {
        Map<String, String> extCpMap = buildExtCpMap();
        for (VirtualMachine vm : vms.values()) {
            vm.addBindings(extCpMap);
        }
    }

    private void linkVms() {
        for (VirtualMachine vm : vms.values()) {
            for (VirtualMachine vm2 : vms.values()) {
                vm.checkAndAddNeighbour(vm2);
            }
        }
    }

//    /**
//     * Builds a map with key = vldId and value = VL flavour
//     * @throws NotExistingEntityException if a flavour cannot be found.
//     */
//    private Map<String, VirtualLinkDf> buildVlFlavourMap() throws NotExistingEntityException {
//        if (vl2FlavourCache != null) {
//            return vl2FlavourCache;
//        }
//        Map<String, VirtualLinkDf> vl2Flavour = new HashMap<>();
//        Map<String, String> vl2Profile = buildId2FlavourMap();
//        for (NsVirtualLinkDesc vlD : virtualLinkDesc) {
//            Optional<VirtualLinkDf> vldf = vlD.getVirtualLinkDf().stream()
//                    .filter((flavour) -> flavour.getFlavourId().equals(vl2Profile.get(vlD.getVirtualLinkDescId())))
//                    .findAny();
//            if (!vldf.isPresent()) {
//                throw new NotExistingEntityException(String.format(
//                        "No flavour with ID %s in virtual link descriptor %s",
//                        vl2Profile.get(vlD.getVirtualLinkDescId()), vlD.getVirtualLinkDescId()
//                ));
//            }
//            vl2Flavour.put(vlD.getVirtualLinkDescId(), vldf.get());
//        }
//        vl2FlavourCache = vl2Flavour;
//        return vl2Flavour;
//    }

    private void buildLogLinks() throws NotExistingEntityException {
        // At last, start from a random VM and start building logical links
        // (And build the umpteenth maps, VM -> incoming log links
        // and VM -> outgoing log links)
        List<VirtualMachine> vmsToProcess = new LinkedList<>();
        Set<VirtualMachine> encounteredVms = new HashSet<>();
        vmsToProcess.add(vms.values().iterator().next());
        while (!vmsToProcess.isEmpty())  {
            VirtualMachine vm = vmsToProcess.remove(0);
            if (logLinks.isEmpty()) {
                // First VM, we take it as entry vm
                LogicalLinkParameters entryParameter =
                        new LogicalLinkParameters(fep.nodeId, null, vm.getId());
                logLinks.put(entryParameter, 10D);

                vm2InLogLinks.putIfAbsent(vm.getId(), new ArrayList<>());
                vm2InLogLinks.get(vm.getId()).add(entryParameter);
            }
            Map<String, Integer> outgoingFlows = fetchCommunicatingVnfs(vm);
            for (Map.Entry<String, Integer> entry : outgoingFlows.entrySet()) {

                LogicalLinkParameters incomingParameter =
                        new LogicalLinkParameters(fep.nodeId, entry.getKey(), vm.getId());

                if (logLinks.containsKey(incomingParameter)) {
                    assert logLinks.get(incomingParameter).equals((double) entry.getValue());
                    // No-op, already there.
                } else {
                    // Build parameter with logical link outgoing from current vnf
                    VirtualMachine destVm = vms.get(entry.getKey());
                    if (!encounteredVms.contains(destVm)){
                        vmsToProcess.add(destVm);
                        encounteredVms.add(destVm);
                    }
                    LogicalLinkParameters parameter =
                            new LogicalLinkParameters(fep.nodeId, vm.getId(), entry.getKey());
                    logLinks.put(parameter, (double) entry.getValue());

                    vm2InLogLinks.putIfAbsent(entry.getKey(), new ArrayList<>());
                    vm2InLogLinks.get(entry.getKey()).add(parameter);
                    vm2OutLogLinks.putIfAbsent(vm.getId(), new ArrayList<>());
                    vm2OutLogLinks.get(vm.getId()).add(parameter);
                }
            }
        }
    }

    private void addSaps() throws NotExistingEntityException {
        //Map<String, VirtualLinkDf> vl2Flavour = buildVlFlavourMap();
        Map<String, LinkBitrateRequirements> vld2bitrate = buildVldId2BitrateMap();
        for (Sapd sap : saps) {
            String vldId = sap.getNsVirtualLinkDescId();
            //VirtualLinkDf linkDf = vl2Flavour.get(vldId);
            vms.values().stream()
                    .filter((vm) -> vm.isAttachedTo(vldId))
                    .forEach((vm) -> {
                        LogicalLinkParameters parameter =
                                new LogicalLinkParameters(fep.nodeId, vm.getId(), sap.getCpdId());
                        logLinks.put(
                                parameter,
                                Double.parseDouble(vld2bitrate.get(vldId).getLeaf())
                        );
                        vm2OutLogLinks.putIfAbsent(vm.getId(), new ArrayList<>());
                        vm2OutLogLinks.get(vm.getId()).add(parameter);
                        vm.addSap(sap.getCpdId(), vldId);
                    });
        }
    }

    private void buildCoefficients() {
        // And build coefficients
        for (Map.Entry<String, List<LogicalLinkParameters>> entry : vm2OutLogLinks.entrySet()) {
            String vm = entry.getKey();
            List<LogicalLinkParameters> outLinks = entry.getValue();
            List<LogicalLinkParameters> inLinks = vm2InLogLinks.get(vm);
            int inDegree = inLinks.size();
            int outDegree = outLinks.size();
            int inIndex = 0;
            int outIndex = 0;
            while (outDegree % inDegree != 0 && outDegree > 0) {
                LogicalLinkParameters inLink = inLinks.get(inIndex);
                LogicalLinkParameters outLink = outLinks.get(outIndex);
                assert inLink.nextVMId.equals(outLink.previousVMId);
                double value = logLinks.get(outLink) / logLinks.get(inLink);
                String previous = inLink.previousVMId != null ? inLink.previousVMId : inLink.nextVMId;

                TrafficCoefficientParameters k
                        = new TrafficCoefficientParameters(previous, outLink.previousVMId, outLink.nextVMId);
                coefficients.put(k, value);
                inIndex++;
                inDegree--;
                outIndex++;
                outDegree--;
            }
            if (outDegree != 0) { // We are not done, we should work by batches.
                int batchSize = outDegree / inDegree;
                while (outDegree != 0) {
                    LogicalLinkParameters inLink = inLinks.get(inIndex);
                    double budget = logLinks.get(inLink);
                    for (int i = 0; i < batchSize; i++) {
                        LogicalLinkParameters outLink = outLinks.get(outIndex);
                        assert inLink.nextVMId.equals(outLink.previousVMId);
                        double value = logLinks.get(outLink) / budget;
                        String previous = inLink.previousVMId != null ? inLink.previousVMId : inLink.nextVMId;
                        TrafficCoefficientParameters k =
                                new TrafficCoefficientParameters(
                                        previous,
                                        outLink.previousVMId,
                                        outLink.nextVMId
                                );
                        coefficients.put(k, value);
                        outDegree--;
                        outIndex++;
                    }
                    inDegree--;
                    inIndex++;
                }
                assert inDegree == 0;
                // Ok, we are done.
            }
        }
    }

    void buildLinks() throws NotExistingEntityException {

        for (Map.Entry<Vnfd, Map<String, String>> entry : vnfds.entrySet()) {
            Vnfd vnfd = entry.getKey();
            String vnfFlavourId = entry.getValue().get("VNF_DF_ID");
            String vnfInstantiationLevel = entry.getValue().get("VNF_INSTANTIATION_LEVEL");
            int vnfInstances = Integer.parseInt(entry.getValue().get("VNF_INSTANCES"));
            buildVms(vnfd, vnfFlavourId, vnfInstantiationLevel, vnfInstances);
        }

        bindVLinks();

        linkVms();

        buildLogLinks();

        addSaps();

        buildCoefficients();
    }

    private Map<String, Integer> fetchCommunicatingVnfs(VirtualMachine vm) throws NotExistingEntityException {
        Map<String, Integer> output = new HashMap<>();
        //Map<String, VirtualLinkDf> flavourMap = buildVlFlavourMap();
        Map<String, LinkBitrateRequirements> vld2bitrate = buildVldId2BitrateMap();
        for (Map.Entry<String, List<String>> entry : vm.getNeighbours().entrySet()) {
            List<String> vldIds = entry.getValue();
            for (String vldId : vldIds) {
                //VirtualLinkDf flavour = flavourMap.get(vldId);
                int bandwidth = Integer.parseInt(vld2bitrate.get(vldId).getLeaf());
                output.merge(entry.getKey(), bandwidth, (a, b) -> a+b);
            }
        }
        return output;
    }

}
