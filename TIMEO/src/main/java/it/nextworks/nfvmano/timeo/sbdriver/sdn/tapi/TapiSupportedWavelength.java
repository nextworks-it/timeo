package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

public class TapiSupportedWavelength {

    private float upperFrequency;
    private float lowerFrequency;
    private TapiFrequencyConstraint tapiFrequencyConstraint;

    public TapiSupportedWavelength(float upperFrequency, float lowerFrequency, TapiFrequencyConstraint tapiFrequencyConstraint) {
        this.upperFrequency = upperFrequency;
        this.lowerFrequency = lowerFrequency;
        this.tapiFrequencyConstraint = tapiFrequencyConstraint;
    }

    public float getUpperFrequency() {
        return upperFrequency;
    }

    public float getLowerFrequency() {
        return lowerFrequency;
    }

    public TapiFrequencyConstraint getTapiFrequencyConstraint() {
        return tapiFrequencyConstraint;
    }
}
