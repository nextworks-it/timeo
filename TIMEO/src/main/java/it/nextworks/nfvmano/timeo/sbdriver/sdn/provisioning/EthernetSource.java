package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class EthernetSource {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("address")
    String address;

    @JsonCreator
    public EthernetSource(@JsonProperty("address") String address) {
        this.address = address;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }
}
