package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class GroupFeatures {

    @JsonProperty("actions")
    public List<Long> actions;

    @JsonProperty("group-types-supported")
    public List<String> groupTypesSupported;

    @JsonProperty("max-groups")
    public List<Long> maxGroups;

    @JsonProperty("group-capabilities-supported")
    public List<String> groupCapabilitiesSupported;

}