package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by Marco Capitani on 22/06/17.
     *
     * @author Marco Capitani(m.capitani AT nextworks.it)
     */

public class Link {

    @JsonProperty("destination")
    public Destination destination;

    @JsonProperty("source")
    public Source source;

    @JsonProperty("link-id")
    public String linkId;

}