package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class Connection {

    @JsonProperty("connectionId")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String connectionId;

    @JsonProperty("connectionStatus")
    String connectionStatus;

    @JsonProperty("tenantId")
    String tenantId;

    @JsonProperty("connectionSource")
    PathRequestSource source;

    @JsonProperty("connectionDestination")
    List<PathRequestDestination> destination;

    @JsonProperty("computedPath")
    ComputedPath computedPath;

    @JsonProperty("priority")
    int priority;

    @JsonCreator
    public Connection(@JsonProperty("connectionId") String connectionId,
                      @JsonProperty("tenantId") String tenantId,
                      @JsonProperty("conncetionSource") PathRequestSource source,
                      @JsonProperty("connectionDestination") List<PathRequestDestination> destination,
                      @JsonProperty("computedPath") ComputedPath computedPath) {
        this.connectionId = connectionId;
        this.connectionStatus = "CS_COMPUTED";
        this.tenantId = tenantId;
        this.source = source;
        this.destination = destination;
        this.computedPath = computedPath;
        for (ComputedStep step : computedPath.getComputedStep()) {
            if (step.getOrder() == 0) {
                this.priority = step.getStepQueue();
            }
        }
    }

    @JsonProperty("connectionId")
    public String getConnectionId() {
        return connectionId;
    }

    @JsonProperty("connectionStatus")
    public String getConnectionStatus() {
        return connectionStatus;
    }

    @JsonProperty("tenantId")
    public String getTenantId() {
        return tenantId;
    }

    @JsonProperty("connectionSource")
    public PathRequestSource getSource() {
        return source;
    }

    @JsonProperty("connectionDestination")
    public List<PathRequestDestination> getDestination() {
        return destination;
    }

    @JsonProperty("computedPath")
    public ComputedPath getComputedPath() {
        return computedPath;
    }
}
