package it.nextworks.nfvmano.timeo.rc.elements;

/**
 * Created by Marco Capitani on 17/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class TopologyCp {

    public TopologyNode node;
    public TopologyLink outgoingLink;
    public TopologyLink incomingLink;
    public String cpId;
    public String address;
    public String cpdId;

    public TopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                      String address, String cpId, String cpdId) {
        this.node = node;
        this.outgoingLink = outgoingLink;
        this.incomingLink = incomingLink;
        this.address = address;
        this.cpId = cpId;
        this.cpdId = cpdId;
    }

    public TopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                      String address, String cpId) {
        this.node = node;
        this.outgoingLink = outgoingLink;
        this.incomingLink = incomingLink;
        this.address = address;
        this.cpId = cpId;
        this.cpdId = null;
    }
}
