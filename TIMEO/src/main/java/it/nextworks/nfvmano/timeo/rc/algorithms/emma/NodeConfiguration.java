package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class NodeConfiguration implements Variable {
    TopologyNode node;

    NodeConfiguration(TopologyNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Node Id must not be null.");
        }
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeConfiguration that = (NodeConfiguration) o;

        return node.equals(that.node);
    }

    @Override
    public int hashCode() {
        return node.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Y(%s)", node);
    }
}
