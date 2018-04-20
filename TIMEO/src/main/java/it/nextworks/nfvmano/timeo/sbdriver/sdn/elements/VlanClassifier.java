package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class VlanClassifier extends Classifier {

    private String srcMac;
    private String dstMac;
    private int vlanId;

    /**
     * Constructor
     *
     * @param srcMac source MAC address
     * @param dstMac destination MAC address
     * @param vlanId VLAN ID
     */
    public VlanClassifier(String srcMac, String dstMac, int vlanId) {
        super(TrafficClassifierType.VLAN_CLASSIFIER);
        this.srcMac = srcMac;
        this.dstMac = dstMac;
        this.vlanId = vlanId;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public String getDstMac() {
        return dstMac;
    }

    public int getVlanId() {
        return vlanId;
    }
}
