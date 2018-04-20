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

