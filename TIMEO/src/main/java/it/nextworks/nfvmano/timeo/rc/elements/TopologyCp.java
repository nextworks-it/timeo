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
package it.nextworks.nfvmano.timeo.rc.elements;

/**
 * Created by Marco Capitani on 17/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class TopologyCp {

    public TopologyNode node;
    public TopologyLink outgoingLink;
    public TopologyLink incomingLink;
    public String cpId;
    public String address;
    public String cpdId;

    public TopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                      String address, String cpId, String cpdId) {
        this.node = node;
        this.outgoingLink = outgoingLink;
        this.incomingLink = incomingLink;
        this.address = address;
        this.cpId = cpId;
        this.cpdId = cpdId;
    }

    public TopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                      String address, String cpId) {
        this.node = node;
        this.outgoingLink = outgoingLink;
        this.incomingLink = incomingLink;
        this.address = address;
        this.cpId = cpId;
        this.cpdId = null;
    }
}
