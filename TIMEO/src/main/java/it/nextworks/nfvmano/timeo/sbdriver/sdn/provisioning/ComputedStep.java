package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class ComputedStep {

    @JsonProperty("order")
    int order;

    @JsonProperty("node-id")
    String nodeId;

    @JsonProperty("ingress")
    String ingress;

    @JsonProperty("egress")
    String egress;

    @JsonProperty("incoming-link")
    String incomingLink;

    @JsonProperty("outgoing-link")
    String outgoingLink;

    @JsonProperty("step-queue")
    int stepQueue;

    @JsonProperty("first")
    boolean first;

    @JsonProperty("last")
    boolean last;


    public ComputedStep(@JsonProperty("order") int order,
                        @JsonProperty("node-id") String nodeId,
                        @JsonProperty("ingress") String ingress,
                        @JsonProperty("egress") String egress,
                        @JsonProperty("incoming-link") String incomingLink,
                        @JsonProperty("outgoing-link") String outgoingLink,
                        @JsonProperty("step-queue") int stepQueue,
                        @JsonProperty("first") boolean first,
                        @JsonProperty("last") boolean last) {
        this.order = order;
        this.nodeId = nodeId;
        this.ingress = ingress;
        this.egress = egress;
        this.incomingLink = incomingLink;
        this.outgoingLink = outgoingLink;
        this.stepQueue = stepQueue;
        this.first = first;
        this.last = last;
    }

    @JsonProperty("order")
    public int getOrder() {
        return order;
    }

    @JsonProperty("node-id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("ingress")
    public String getIngress() {
        return ingress;
    }

    @JsonProperty("egress")
    public String getEgress() {
        return egress;
    }

    @JsonProperty("incoming-link")
    public String getIncomingLink() {
        return incomingLink;
    }

    @JsonProperty("outgoing-link")
    public String getOutgoingLink() {
        return outgoingLink;
    }

    @JsonProperty("step-queue")
    public int getStepQueue() {
        return stepQueue;
    }

    @JsonProperty("first")
    public boolean isFirst() {
        return first;
    }

    @JsonProperty("last")
    public boolean isLast() {
        return last;
    }
}
