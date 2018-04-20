package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class OFresource {

    @JsonProperty("in-port")
    String inPort;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vlan-match")
    VlanMatch vlanMatch;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ethernet-match")
    EthernetMatch ethernetMatch;

    @JsonCreator
    public OFresource(@JsonProperty("in-port") String inPort,
                      @JsonProperty("vlan-match") VlanMatch vlanMatch,
                      @JsonProperty("ethernet-match") EthernetMatch ethernetMatch) {
        this.inPort = inPort;
        if (null != vlanMatch) this.vlanMatch = vlanMatch;
        if (null != ethernetMatch) this.ethernetMatch = ethernetMatch;
    }

    @JsonProperty("in-port")
    public String getInPort() {
        return inPort;
    }

    @JsonProperty("vlan-match")
    public VlanMatch getVlanMatch() {
        return vlanMatch;
    }

    @JsonProperty("ethernet-match")
    public EthernetMatch getEthernetMatch() {
        return ethernetMatch;
    }
}
