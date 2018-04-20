package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class Flow implements Variable {

    TopologyLink link;
    TopologyNode sourceNode;
    String previousVM;
    String nextVM;

    Flow(TopologyLink link, TopologyNode sourceNode, String previousVM, String nextVM) {
        if (link == null) {
            throw new IllegalArgumentException("Link must not be null.");
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
        this.link = link;
        this.sourceNode = sourceNode;
        this.previousVM = previousVM;
        this.nextVM = nextVM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flow flow = (Flow) o;

        return link.equals(flow.link)
                && sourceNode.equals(flow.sourceNode)
                && previousVM.equals(flow.previousVM)
                && nextVM.equals(flow.nextVM);
    }

    @Override
    public int hashCode() {
        int result = link.hashCode();
        result = 31 * result + sourceNode.hashCode();
        result = 31 * result + previousVM.hashCode();
        result = 31 * result + nextVM.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("TAU_%s (%s, %s, %s)", link, sourceNode, previousVM, nextVM);
    }
}
