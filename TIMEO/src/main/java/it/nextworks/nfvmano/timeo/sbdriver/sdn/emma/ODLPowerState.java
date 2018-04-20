package it.nextworks.nfvmano.timeo.sbdriver.sdn.emma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Marco Capitani on 25/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public enum ODLPowerState {

    Off(0),

    Ready(1),

    LowPower(2),

    MediumPower(3),

    HighPower(4);

    public String toJson() {
        switch (value) {
            case 0:
                return "off";
            case 1:
                return "ready";
            case 2:
                return "low-power";
            case 3:
                return "medium-power";
            case 4:
                return "high-power";
            default:
                throw new IllegalStateException(String.format("Not implemented toJson for state %s.", name()));
        }
    }

    ODLPowerState(int value) {
        this.value = value;
    }

    int value;

    private static final Map<Integer, ODLPowerState> VALUE_MAP;

    static {
        HashMap<Integer, ODLPowerState> temp = new HashMap<>();
        for (ODLPowerState state : ODLPowerState.values()) {
            temp.put(state.value, state);
        }
        VALUE_MAP = temp;
    }

    public static ODLPowerState getForValue(int i) {
        return VALUE_MAP.get(i);
    }
}
