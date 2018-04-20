package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class Duration {

    @JsonProperty("second")
    public long second;

    @JsonProperty("nanosecond")
    public long nanosecond;

}