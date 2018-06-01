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

import java.util.List;

/**
     * Created by Marco Capitani on 22/06/17.
     *
     * @author Marco Capitani(m.capitani AT nextworks.it)
     */

public class OdlTopologyNode {

    @JsonProperty("host-tracker-service:addresses")
    public List<Addresses> addresses;

    @JsonProperty("host-tracker-service:attachment-points")
    public List<AttachmentPoints> attachmentPoints;

    @JsonProperty("host-tracker-service:id")
    public String id;

    @JsonProperty("statemanager:oper-state")
    public String operState;

    @JsonProperty("statemanager:config-state")
    public String configState;

    @JsonProperty("opendaylight-topology-inventory:inventory-node-ref")
    public String inventoryNodeRef;

    @JsonProperty("node-id")
    public String nodeId;

    @JsonProperty("termination-point")
    public List<TerminationPoint> terminationPoint;

    @JsonProperty("statemanager:ip-address")
    public String ipAddress;

}