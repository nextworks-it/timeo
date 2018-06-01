/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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
