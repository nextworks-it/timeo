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
