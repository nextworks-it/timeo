package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class OdlInvNodes {

    @JsonProperty("node")
    public List<OdlInvNode> node;

}