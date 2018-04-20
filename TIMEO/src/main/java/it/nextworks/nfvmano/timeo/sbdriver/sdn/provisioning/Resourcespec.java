package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class Resourcespec {

    @JsonProperty("OF_resource")
    OFresource oFresource;

    @JsonCreator
    public Resourcespec(@JsonProperty("OF_resource") OFresource oFresource) {
        this.oFresource = oFresource;
    }

    @JsonProperty("OF_resource")
    public OFresource getoFresource() {
        return oFresource;
    }
}
