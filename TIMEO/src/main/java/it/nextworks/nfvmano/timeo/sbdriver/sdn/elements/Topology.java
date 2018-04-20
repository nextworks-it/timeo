package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
     * Created by Marco Capitani on 22/06/17.
     *
     * @author Marco Capitani(m.capitani AT nextworks.it)
     */

public class Topology {

    @JsonProperty("node")
    public List<OdlTopologyNode> node;

    @JsonProperty("link")
    public List<Link> link;

    @JsonProperty("topology-id")
    public String topologyId;

}