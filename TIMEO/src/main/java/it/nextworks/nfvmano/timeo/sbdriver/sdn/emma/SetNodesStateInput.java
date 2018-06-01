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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco Capitani on 25/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class SetNodesStateInput {

    public Input input;

    public SetNodesStateInput() {

    }

    public SetNodesStateInput(Input input) {
        this.input = input;
    }

    public SetNodesStateInput(Map<String, PowerState> states) {
        this.input = new Input(states);
    }

    public static class Input {

        @JsonProperty("node-configuration")
        public List<NodeConfiguration> nodeConfiguration;

        public Input() {

        }

        public Input(List<NodeConfiguration> nodeConfiguration) {
            this.nodeConfiguration = nodeConfiguration;

        }

        public Input(Map<String, PowerState> states) {
            nodeConfiguration = new ArrayList<>();
            states.forEach((n, s) ->
                    nodeConfiguration.add(new NodeConfiguration(n, s))
            );
        }
    }
}

