package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class VmInstantiation implements Variable {
    TopologyNode node;
    String vm;

    VmInstantiation(TopologyNode node, String vm) {
        if (node == null) {
            throw new IllegalArgumentException("Node Id must not be null.");
        }
        if (vm == null) {
            throw new IllegalArgumentException("Vm id must not be null.");
        }
        this.node = node;
        this.vm = vm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VmInstantiation that = (VmInstantiation) o;

        return node.equals(that.node) && vm.equals(that.vm);
    }

    @Override
    public int hashCode() {
        int result = node.hashCode();
        result = 31 * result + vm.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("DELTA(%s, %s)", node, vm);
    }
}
