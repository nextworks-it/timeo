package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class VlanId {

    @JsonProperty("vlan-id")
    int vlanId;

    @JsonProperty("vlan-id-present")
    boolean vlanIdpresent;

    @JsonCreator
    public VlanId(@JsonProperty("vlan-id") int vlanId,
                  @JsonProperty("vlan-id-present") boolean vlanIdpresent) {
        this.vlanId = vlanId;
        this.vlanIdpresent = vlanIdpresent;
    }

    @JsonProperty("vlan-id")
    public int getVlanId() {
        return vlanId;
    }

    @JsonProperty("vlan-id-present")
    public boolean isVlanIdpresent() {
        return vlanIdpresent;
    }
}
