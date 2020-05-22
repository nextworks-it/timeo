package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

public class TapiFrequencyConstraint {

    private String adjustmentGranularity;
    private String gridType;

    public TapiFrequencyConstraint(String adjustmentGranularity, String gridType) {
        this.adjustmentGranularity = adjustmentGranularity;
        this.gridType = gridType;
    }

    public String getAdjustmentGranularity() {
        return adjustmentGranularity;
    }

    public String getGridType() {
        return gridType;
    }
}
