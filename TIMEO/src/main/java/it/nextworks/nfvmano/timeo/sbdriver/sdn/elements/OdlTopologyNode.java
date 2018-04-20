package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
     * Created by Marco Capitani on 22/06/17.
     *
     * @author Marco Capitani(m.capitani AT nextworks.it)
     */

public class OdlTopologyNode {

    @JsonProperty("host-tracker-service:addresses")
    public List<Addresses> addresses;

    @JsonProperty("host-tracker-service:attachment-points")
    public List<AttachmentPoints> attachmentPoints;

    @JsonProperty("host-tracker-service:id")
    public String id;

    @JsonProperty("statemanager:oper-state")
    public String operState;

    @JsonProperty("statemanager:config-state")
    public String configState;

    @JsonProperty("opendaylight-topology-inventory:inventory-node-ref")
    public String inventoryNodeRef;

    @JsonProperty("node-id")
    public String nodeId;

    @JsonProperty("termination-point")
    public List<TerminationPoint> terminationPoint;

    @JsonProperty("statemanager:ip-address")
    public String ipAddress;

}