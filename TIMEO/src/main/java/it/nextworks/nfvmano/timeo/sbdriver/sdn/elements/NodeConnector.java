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