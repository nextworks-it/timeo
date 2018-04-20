package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class TransitingTraffic implements Variable {

    private TopologyNode sourceNode;
    private TopologyNode actualNode;
    private String previousVM;
    private String nextVM;

    TransitingTraffic(TopologyNode actualNode, TopologyNode sourceNode,
                      String previousVM, String nextVM) {
        if (actualNode == null) {
            throw new IllegalArgumentException("Actual Node must not be null.");
        }
        if (sourceNode == null) {
            throw new IllegalArgumentException("Source Node must not be null.");
        }
        if (previousVM == null) {
            throw new IllegalArgumentException("Previous VM must not be null.");
        }
        if (nextVM == null) {
            throw new IllegalArgumentException("Next VM must not be null.");
        }
        this.actualNode = actualNode;
        this.sourceNode = sourceNode;
        this.previousVM = previousVM;
        this.nextVM = nextVM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransitingTraffic that = (TransitingTraffic) o;

        return sourceNode.equals(that.sourceNode)
                && actualNode.equals(that.actualNode)
                && previousVM.equals(that.previousVM)
                && nextVM.equals(that.nextVM);
    }

    @Override
    public int hashCode() {
        int result = sourceNode.hashCode();
        result = 31 * result + actualNode.hashCode();
        result = 31 * result + previousVM.hashCode();
        result = 31 * result + nextVM.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("T_%s (%s, %s, %s)", actualNode, sourceNode, previousVM, nextVM);
    }
}
