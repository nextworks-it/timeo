package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class BluespaceSupportedWavelength {

    private float upperFrequency;
    private float lowerFrequency;
    private BluespaceFrequencyConstraint bluespaceFrequencyConstraint;

    public BluespaceSupportedWavelength(){

    }
    public BluespaceSupportedWavelength(float upperFrequency, float lowerFrequency, BluespaceFrequencyConstraint bluespaceFrequencyConstraint) {
        this.upperFrequency = upperFrequency;
        this.lowerFrequency = lowerFrequency;
        this.bluespaceFrequencyConstraint = bluespaceFrequencyConstraint;
    }

    public float getUpperFrequency() {
        return upperFrequency;
    }

    public float getLowerFrequency() {
        return lowerFrequency;
    }

    public BluespaceFrequencyConstraint getBluespaceFrequencyConstraint() {
        return bluespaceFrequencyConstraint;
    }
}
