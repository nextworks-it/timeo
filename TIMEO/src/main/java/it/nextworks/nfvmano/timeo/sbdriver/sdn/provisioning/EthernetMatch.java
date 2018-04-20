package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class EthernetMatch {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ethernet-source")
    EthernetSource ethernetSource;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ethernet-destination")
    EthernetDestination ethernetDestination;

    @JsonCreator
    public EthernetMatch(@JsonProperty("ethernet-source") EthernetSource ethernetSource,
                         @JsonProperty("ethernet-destination") EthernetDestination ethernetDestination) {
        if (null != ethernetSource) this.ethernetSource = ethernetSource;
        if (null != ethernetDestination) this.ethernetDestination = ethernetDestination;
    }

    @JsonProperty("ethernet-source")
    public EthernetSource getEthernetSource() {
        return ethernetSource;
    }

    @JsonProperty("ethernet-destination")
    public EthernetDestination getEthernetDestination() {
        return ethernetDestination;
    }
}
