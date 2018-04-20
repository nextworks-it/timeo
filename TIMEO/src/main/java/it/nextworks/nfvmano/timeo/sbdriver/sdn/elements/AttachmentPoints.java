package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by Marco Capitani on 22/06/17.
     *
     * @author Marco Capitani(m.capitani AT nextworks.it)
     */

public class AttachmentPoints {

    @JsonProperty("corresponding-tp")
    public String correspondingTp;

    @JsonProperty("active")
    public boolean active;

    @JsonProperty("tp-id")
    public String tpId;

}