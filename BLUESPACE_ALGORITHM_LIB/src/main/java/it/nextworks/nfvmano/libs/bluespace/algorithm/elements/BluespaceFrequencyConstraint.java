package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class BluespaceFrequencyConstraint {

    private String adjustmentGranularity;
    private String gridType;

    public BluespaceFrequencyConstraint(){

    }
    public BluespaceFrequencyConstraint(String adjustmentGranularity, String gridType) {
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
