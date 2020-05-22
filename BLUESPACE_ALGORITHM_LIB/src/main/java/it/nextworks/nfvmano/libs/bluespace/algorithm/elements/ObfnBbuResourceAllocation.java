package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class ObfnBbuResourceAllocation {

    private String bbuId;
    private int operationMode;

    private int subcarriersNumber;
    private int pilotSpacing;
    private int modulationScheme;
    private long intermediateFrequency;

    public ObfnBbuResourceAllocation(String bbuId, int operationMode, int subcarriersNumber, int pilotSpacing, int modulationScheme, long intermediateFrequency) {
        this.bbuId = bbuId;
        this.operationMode = operationMode;
        this.subcarriersNumber = subcarriersNumber;
        this.pilotSpacing = pilotSpacing;
        this.modulationScheme = modulationScheme;
        this.intermediateFrequency = intermediateFrequency;
    }

    public String getBbuId() {
        return bbuId;
    }

    public int getOperationMode() {
        return operationMode;
    }

    public int getSubcarriersNumber() {
        return subcarriersNumber;
    }

    public long getIntermediateFrequency() {
        return intermediateFrequency;
    }

    public int getPilotSpacing() {
        return pilotSpacing;
    }

    public int getModulationScheme() {
        return modulationScheme;
    }


}
