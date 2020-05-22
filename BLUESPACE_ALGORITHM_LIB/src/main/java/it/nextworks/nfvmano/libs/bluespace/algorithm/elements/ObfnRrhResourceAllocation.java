package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class ObfnRrhResourceAllocation {


    private String rrhId;

    //Added here for completeness
    private boolean powerUp;
    private boolean sleepMode;

    private int txGain;
    private int rxGain;

    public ObfnRrhResourceAllocation() {
    }

    public ObfnRrhResourceAllocation(String rrhId, boolean powerUp, boolean sleepMode, int txGain, int rxGain) {
        this.rrhId = rrhId;
        this.powerUp = powerUp;
        this.sleepMode = sleepMode;
        this.txGain = txGain;
        this.rxGain = rxGain;
    }

    public String getRrhId() {
        return rrhId;
    }

    public boolean isPowerUp() {
        return powerUp;
    }

    public boolean isSleepMode() {
        return sleepMode;
    }

    public int getTxGain() {
        return txGain;
    }

    public int getRxGain() {
        return rxGain;
    }
}

