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
package it.nextworks.nfvmano.timeo.sbdriver.sdn.emma;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;


/**
 * Created by Marco Capitani on 25/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class NodeConfiguration {

    @JsonProperty("node-id")
    public String nodeId;

    private ODLPowerState powerState;

    @JsonProperty("power-state")
    public String getPowerState() {
        return powerState.toJson();
    }

    public NodeConfiguration() {

    }

    public NodeConfiguration(String nodeId, ODLPowerState powerState) {
        this.nodeId = nodeId;
        this.powerState = powerState;
    }

    public NodeConfiguration(String nodeId, PowerState powerState) {
        this.nodeId = nodeId;
        switch (powerState) {
            case POWER_ON:
                this.powerState = ODLPowerState.HighPower;
                break;
            case POWER_OFF:
                this.powerState = ODLPowerState.Off;
                break;
            case SLEEPING:
                this.powerState = ODLPowerState.Ready;
                break;
            case LOW_POWER:
                this.powerState = ODLPowerState.LowPower;
                break;
            case MEDIUM_POWER:
                this.powerState = ODLPowerState.MediumPower;
                break;
            case HIGH_POWER:
                this.powerState = ODLPowerState.HighPower;
                break;
            default:
                throw new IllegalStateException(String.format("Not implemented powerState %s", powerState));
        }

    }

}
