package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class State {

    @JsonProperty("blocked")
    public boolean blocked;

    @JsonProperty("live")
    public boolean live;

    @JsonProperty("link-down")
    public boolean linkDown;

}