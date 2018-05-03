package it.nextworks.nfvmano.timeo.rc.elements;





import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class TopologyNode {

    public String nodeId;

    public int hddSize; // in GB
    public int memory; // in GB
    public int vCPUs;

    public String zoneId;
    public String vimName;

    public double idle; // in W
    private Map<String, Double> idleVM = new HashMap<>(); // TODO should become a mapping flavor -> PC

    private Map<String, Double> processing = new HashMap<>(); // in W/Kb TODO should become a mapping flavor -> PC

    //private Set<PowerState> availablePowerStates;

    public PowerState powerState;

    public Set<TopologyCp> cps;

    public TopologyNode(String nodeId, Set<TopologyCp> cps,
                        int hddSize, int memory, int vCPUs,
                        double idle,
                        double idleVM, PowerState powerState,
                        String zoneId, String vimName) {
        if (nodeId == null) {
            throw new IllegalArgumentException("Node Id must not be null.");
        }
        this.nodeId = nodeId;
        this.hddSize = hddSize;
        this.memory = memory;
        this.vCPUs = vCPUs;
        this.idle = idle;
        this.setIdleVM(idleVM);
        this.powerState = powerState;
        this.cps = cps;
        this.zoneId = zoneId;
        //this.availablePowerStates = new HashSet<>(Arrays.asList(PowerState.values()));
        this.vimName = vimName;
    }

    public TopologyNode(String nodeId, Set<TopologyCp> cps,
                        double idle, PowerState powerState) {
        this(nodeId, cps, 0, 0, 0, idle, 0, powerState, null, null);
    }


    public TopologyNode(String nodeId, Set<TopologyCp> cps) {
        this(nodeId, cps, 0, 0, 0, 0, 0, PowerState.HIGH_POWER, null, null);
        //this.availablePowerStates = Collections.emptySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopologyNode node = (TopologyNode) o;

        return nodeId.equals(node.nodeId);
    }

    @Override
    public int hashCode() {
        return nodeId.hashCode();
    }

    @Override
    public String toString() {
        return nodeId;
    }

    public boolean isOn() {
        return !powerState.equals(PowerState.POWER_OFF) && !powerState.equals(PowerState.SLEEPING);
    }

    public TopologyNode getCloneNoCps() {
        return new TopologyNode(
                this.nodeId, new HashSet<>(), this.hddSize, this.memory, this.vCPUs,
                this.idle, this.getIdleVM(), this.powerState, this.zoneId, this.vimName
        );
    }

    public void turnOn() {
        powerState = PowerState.HIGH_POWER;
    }

    public double getIdleVM() {
        return idleVM.get("VM");
    }

    public double getProcessing() {
        return processing.get("VM");
    }

    public void setProcessing(Map<String, Double> processing) {
        this.processing.putAll(processing);
    }

    public void setIdleVM(Map<String, Double> idleVM) {
        this.idleVM.putAll(idleVM);
    }

    public void setProcessing(double processing) {
        this.processing.put("VM", processing);
    }

    public void setIdleVM(double idleVM) {
        this.idleVM.put("VM", idleVM);
    }
}
