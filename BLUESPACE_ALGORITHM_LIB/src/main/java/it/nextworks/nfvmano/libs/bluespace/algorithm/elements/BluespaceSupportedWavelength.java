package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class BluespaceSupportedWavelength {

    private long upperFrequency;
    private long lowerFrequency;
    private BluespaceFrequencyConstraint bluespaceFrequencyConstraint;

    public BluespaceSupportedWavelength(){

    }
    public BluespaceSupportedWavelength(long upperFrequency, long lowerFrequency, BluespaceFrequencyConstraint bluespaceFrequencyConstraint) {
        this.upperFrequency = upperFrequency;
        this.lowerFrequency = lowerFrequency;
        this.bluespaceFrequencyConstraint = bluespaceFrequencyConstraint;
    }

    public long getUpperFrequency() {
        return upperFrequency;
    }

    public long getLowerFrequency() {
        return lowerFrequency;
    }

    public BluespaceFrequencyConstraint getBluespaceFrequencyConstraint() {
        return bluespaceFrequencyConstraint;
    }
}
