package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class NodeConnector {

    @JsonProperty("flow-node-inventory:maximum-speed")
    public long maximumSpeed;

    @JsonProperty("flow-node-inventory:port-number")
    public String portNumber;

    @JsonProperty("flow-node-inventory:state")
    public State state;

    @JsonProperty("opendaylight-port-statistics:flow-capable-node-connector-statistics")
    public FlowCapableNodeConnectorStatistics flowCapableNodeConnectorStatistics;

    @JsonProperty("flow-node-inventory:name")
    public String name;

    @JsonProperty("flow-node-inventory:advertised-features")
    public String advertisedFeatures;

    @JsonProperty("flow-node-inventory:current-speed")
    public long currentSpeed;

    @JsonProperty("flow-node-inventory:current-feature")
    public String currentFeature;

    @JsonProperty("flow-node-inventory:configuration")
    public String configuration;

    @JsonProperty("flow-node-inventory:supported")
    public String supported;

    @JsonProperty("flow-node-inventory:peer-features")
    public String peerFeatures;

    @JsonProperty("id")
    public String id;

    @JsonProperty("flow-node-inventory:hardware-address")
    public String hardwareAddress;

}