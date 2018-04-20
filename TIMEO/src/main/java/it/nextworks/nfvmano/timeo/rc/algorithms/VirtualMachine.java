package it.nextworks.nfvmano.timeo.rc.algorithms;

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.AddressData;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduCpd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfExtCpd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Marco Capitani on 22/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class VirtualMachine {

    private String vduId;
    private int vduIndex;
    private Vnfd vnfd;
    private int vnfIndex;
    private Map<String, String> extCpdId2vldId = new HashMap<>();
    private Map<String, String> vldId2extCpdId = new HashMap<>();
    private Map<String, String> unboundExtCpds2IntCpds;
    private Map<String, String> vlink2IntCpd = new HashMap<>();
    private Set<String> floatingCpds = new HashSet<>();

    // value = vldId
    private Map<String, List<String>> neighbours = new HashMap<>();

    VirtualMachine(String vduId, int vduIndex, Vnfd vnfd, int vnfIndex)
            throws NotExistingEntityException {
        this.vduId = vduId;
        this.vnfd = vnfd;
        this.vduIndex = vduIndex;
        this.vnfIndex = vnfIndex;
        initialiseExtCpds();
        initialiseFloatingCpds();
    }

    private void initialiseFloatingCpds() {
        for (VnfExtCpd cpd : vnfd.getVnfExtCpd()) {
            if (cpd.getAddressData().stream().anyMatch(AddressData::isFloatingIpActivated)) {
                floatingCpds.add(cpd.getCpdId());
            }
        }
    }

    private void initialiseExtCpds() throws NotExistingEntityException {
        List<VduCpd> intCpds = vnfd.getVduFromId(vduId).getIntCpd();
        unboundExtCpds2IntCpds = new HashMap<>();
        for (VduCpd intCpd : intCpds) {
            unboundExtCpds2IntCpds.put(
                    vnfd.getExternalConnectionPointAssociatedToInternalConnectionPoint(intCpd.getCpdId()).getCpdId(),
                    intCpd.getCpdId()
            );
        }
    }

    private void addBinding(String cpdId, String vldId) {
        if (extCpdId2vldId.containsKey(cpdId)) {
            assert cpdId.equals(vldId2extCpdId.get(vldId)) : extCpdId2vldId.toString() + "\n" + vldId2extCpdId.toString() + "\nTesting: " + cpdId + "=" + vldId;
        } else {
            assert !vldId2extCpdId.containsKey(vldId) : extCpdId2vldId.toString() + "\n" + vldId2extCpdId.toString() + "\nTesting: " + cpdId + "=" + vldId;
            extCpdId2vldId.put(cpdId, vldId);
            vldId2extCpdId.put(vldId, cpdId);
            vlink2IntCpd.put(vldId, unboundExtCpds2IntCpds.get(cpdId));
        }
    }

    private List<String> isNeighbour(VirtualMachine other) {
        if (other.equals(this)) {
            return null;
        }
        Set<String> commonVls = new HashSet<>(vldId2extCpdId.keySet());
        commonVls.retainAll(other.vldId2extCpdId.keySet());

        // Remove all vLinks between VMs through floating IP cpd
        // N.B.: these are strictly VMs, so they are not SAPs
        commonVls.removeIf((vl) -> floatingCpds.contains(vldId2extCpdId.get(vl)));

        if (commonVls.isEmpty()) {
            return null;
        }

        return new ArrayList<>(commonVls);
    }

    void checkAndAddNeighbour(VirtualMachine other) {
        if (other.equals(this)) {
            return;
        }
        if (neighbours.containsKey(other.getId())) {
            return;
        }
        List<String> vldId = isNeighbour(other);
        if (null != vldId) {
            registerNeighbour(other, vldId);
            other.registerNeighbour(this, vldId);
        }
    }

    private void registerNeighbour(VirtualMachine other, List<String> vldId) {
        neighbours.put(other.getId(), vldId);
    }

    String getId() {
        return String.format("%s:%s_%s:%s", vnfd.getVnfdId(), vnfIndex, vduId, vduIndex);
    }

    /**
     * Parses the attachment map and adds all of the applicable bindings
     * @param cps2VMap a map with key = extCpId and value = vldId to which it is attached.
     */
    void addBindings(Map<String, String> cps2VMap) {
        for (Map.Entry<String, String> entry : cps2VMap.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException(
                        String.format("Map %s illegal, null elements.", cps2VMap)
                );
            }
            if (unboundExtCpds2IntCpds.containsKey(entry.getKey())) {
                addBinding(entry.getKey(), entry.getValue());
                unboundExtCpds2IntCpds.remove(entry.getKey());
            }
        }
    }

    boolean isAttachedTo(String vldId) {
        return vldId2extCpdId.containsKey(vldId);
    }

    Map<String, List<String>> getNeighbours() {
        return neighbours;
    }

    void addSap(String sapId, String vldId) {
        neighbours.putIfAbsent(sapId, new ArrayList<>());
        neighbours.get(sapId).add(vldId);
    }

    List<String> getNeighbour(String other) {
        return neighbours.getOrDefault(other, Collections.emptyList());
    }

    public String getVduId() {
        return vduId;
    }

    public int getVduIndex() {
        return vduIndex;
    }

    public Vnfd getVnfd() {
        return vnfd;
    }

    public int getVnfIndex() {
        return vnfIndex;
    }

    public String getIntCpdFromVLink(String vLinkId) {
        return vlink2IntCpd.get(vLinkId);
    }
}
