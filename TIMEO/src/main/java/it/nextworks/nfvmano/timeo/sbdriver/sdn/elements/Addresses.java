package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by Marco Capitani on 22/06/17.
     *
     * @author Marco Capitani(m.capitani AT nextworks.it)
     */

public class Addresses {

    @JsonProperty("first-seen")
    public long firstSeen;

    @JsonProperty("ip")
    public String ip;

    @JsonProperty("mac")
    public String mac;

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("last-seen")
    public long lastSeen;

}