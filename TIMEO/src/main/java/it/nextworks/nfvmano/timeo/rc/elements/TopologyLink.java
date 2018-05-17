package it.nextworks.nfvmano.timeo.rc.elements;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class TopologyLink {

    public String linkId;
    public TopologyNode source;
    public TopologyNode destination;
    public TopologyCp sourceCp;
    public TopologyCp destinationCp;

    public double power; // in W/Kb

    public int bandwidth; // in Kb/sec; current bw only.

    public TopologyLink(String linkId,
                        TopologyNode source, TopologyNode destination,
                        TopologyCp sourceCp, TopologyCp destinationCp,
                        double power, int bandwidth) {
        if (source == null) {
            throw new IllegalArgumentException("Source Id must not be null.");
        }
        if (destination == null) {
            throw new IllegalArgumentException("Destination Id must not be null.");
        }
        this.linkId = linkId;
        this.source = source;
        this.destination = destination;
        this.power = power;
        this.bandwidth = bandwidth;
        this.sourceCp = sourceCp;
        this.destinationCp = destinationCp;
    }

    public TopologyNode opposite(TopologyNode node) {
        if (node.equals(source)) {
            return destination;
        } else if (node.equals(destination)) {
            return source;
        } else {
            throw new IllegalArgumentException(
                    String.format(
                            "Node %s not present in link %s",
                            node, this
                    )
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopologyLink link = (TopologyLink) o;

        return source.equals(link.source)
                && destination.equals(link.destination);
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + destination.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Link(%s -> %s)", source, destination);
    }
}
