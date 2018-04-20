package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class VlanMatch {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vlan-id")
    VlanId vlanId;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("vlan-pcp")
    int vlanPcp;

    @JsonCreator
    public VlanMatch(@JsonProperty("vlan-id") VlanId vlanId,
                     @JsonProperty("vlan-pcp") int vlanPcp) {
        this.vlanId = vlanId;
        this.vlanPcp = vlanPcp;
    }

    @JsonProperty("vlan-id")
    public VlanId getVlanId() {
        return vlanId;
    }

    @JsonProperty("vlan-pcp")
    public int getVlanPcp() {
        return vlanPcp;
    }
}
