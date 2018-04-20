package it.nextworks.nfvmano.timeo.rc.algorithms;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class LogicalLinkParameters {

    public String sourceNodeId;
    public String previousVMId; // Might be null, for traffic not yet processed.
    public String nextVMId;

    public LogicalLinkParameters(String sourceNodeId, String previousVMId, String nextVMId) {
        if (null == sourceNodeId) {
            throw new IllegalArgumentException("Source node must not be null.");
        }
        if (null == nextVMId) {
            throw new IllegalArgumentException("Next VM must not be null.");
        }
        this.sourceNodeId = sourceNodeId;
        this.previousVMId = previousVMId;
        this.nextVMId = nextVMId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogicalLinkParameters that = (LogicalLinkParameters) o;

        return sourceNodeId.equals(that.sourceNodeId)
                && (previousVMId != null ? previousVMId.equals(that.previousVMId) : that.previousVMId == null)
                && nextVMId.equals(that.nextVMId);
    }

    @Override
    public int hashCode() {
        int result = sourceNodeId.hashCode();
        result = 31 * result + (previousVMId != null ? previousVMId.hashCode() : 0);
        result = 31 * result + nextVMId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("LogicalLink[source: %s, prevVM: %s, nextVM: %s]",
                sourceNodeId, previousVMId, nextVMId);
    }
}
