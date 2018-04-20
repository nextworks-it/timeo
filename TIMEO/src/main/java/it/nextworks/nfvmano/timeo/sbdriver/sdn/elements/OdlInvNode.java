package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class OdlInvNode {

    @JsonProperty("opendaylight-meter-statistics:meter-features")
    public MeterFeatures meterFeatures;

    @JsonProperty("flow-node-inventory:ip-address")
    public String ipAddress;

    @JsonProperty("flow-node-inventory:table")
    public List<Table> table;

    @JsonProperty("flow-node-inventory:hardware")
    public String hardware;

    @JsonProperty("opendaylight-group-statistics:group-features")
    public GroupFeatures groupFeatures;

    @JsonProperty("flow-node-inventory:manufacturer")
    public String manufacturer;

    @JsonProperty("flow-node-inventory:switch-features")
    public SwitchFeatures switchFeatures;

    @JsonProperty("flow-node-inventory:software")
    public String software;

    @JsonProperty("flow-node-inventory:description")
    public String description;

    @JsonProperty("node-connector")
    public List<NodeConnector> nodeConnector;

    @JsonProperty("id")
    public String id;

    @JsonProperty("flow-node-inventory:serial-number")
    public String serialNumber;

}