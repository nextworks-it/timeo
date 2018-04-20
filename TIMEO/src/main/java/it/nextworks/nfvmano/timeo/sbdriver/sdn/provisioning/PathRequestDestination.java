package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class PathRequestDestination {

    @JsonProperty("node-id")
    String nodeId;

    @JsonProperty("mac-address")
    String macAddress;

    @JsonProperty("resourcespec")
    Resourcespec resourcespec;

    @JsonCreator
    public PathRequestDestination(@JsonProperty("node-id") String nodeId,
                             @JsonProperty("mac-address") String macAddress,
                                  @JsonProperty("resourcespec") Resourcespec resourcespec) {
        this.nodeId = nodeId;
        this.macAddress = macAddress;
        this.resourcespec = resourcespec;
    }

    @JsonProperty("node-id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("mac-address")
    public String getMacAddress() {
        return macAddress;
    }

    @JsonProperty("resourcespec")
    public Resourcespec getResourcespec() {
        return resourcespec;
    }
}
