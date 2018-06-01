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