package it.nextworks.nfvmano.timeo.sbdriver.sdn.emma;



import java.util.Map;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;

/**
 * Created by Marco Capitani on 24/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class SetNodesStateRequest {

    private Map<String, PowerState> states;

    public SetNodesStateRequest(Map<String, PowerState> states) {
        this.states = states;
    }

    public SetNodesStateInput buildInput() {
        return new SetNodesStateInput(states);
    }
}
