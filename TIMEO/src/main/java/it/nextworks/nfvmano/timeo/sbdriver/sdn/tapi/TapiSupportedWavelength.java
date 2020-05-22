package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

public class TapiSupportedWavelength {

    private long upperFrequency;
    private long lowerFrequency;
    private TapiFrequencyConstraint tapiFrequencyConstraint;

    public TapiSupportedWavelength(long upperFrequency, long lowerFrequency, TapiFrequencyConstraint tapiFrequencyConstraint) {
        this.upperFrequency = upperFrequency;
        this.lowerFrequency = lowerFrequency;
        this.tapiFrequencyConstraint = tapiFrequencyConstraint;
    }

    public long getUpperFrequency() {
        return upperFrequency;
    }

    public long getLowerFrequency() {
        return lowerFrequency;
    }

    public TapiFrequencyConstraint getTapiFrequencyConstraint() {
        return tapiFrequencyConstraint;
    }
}
