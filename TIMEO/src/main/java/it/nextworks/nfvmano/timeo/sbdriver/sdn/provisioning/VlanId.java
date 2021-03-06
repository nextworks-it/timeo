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
public class VlanId {

    @JsonProperty("vlan-id")
    int vlanId;

    @JsonProperty("vlan-id-present")
    boolean vlanIdpresent;

    @JsonCreator
    public VlanId(@JsonProperty("vlan-id") int vlanId,
                  @JsonProperty("vlan-id-present") boolean vlanIdpresent) {
        this.vlanId = vlanId;
        this.vlanIdpresent = vlanIdpresent;
    }

    @JsonProperty("vlan-id")
    public int getVlanId() {
        return vlanId;
    }

    @JsonProperty("vlan-id-present")
    public boolean isVlanIdpresent() {
        return vlanIdpresent;
    }
}
