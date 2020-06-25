package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class ObfnResourceAllocation {

    private String obfnId;
    private int beamId;
    private int beamOffsetX;
    private int beamOffsetY;
    private int beamWidth;
    private float centralFrenquency;

    public ObfnResourceAllocation() {
    }

    private int beamAngle;



    public ObfnResourceAllocation(String obfnId, int beamId, int beamOffsetX, int beamOffsetY, int beamWidth, int beamAngle, float centralFrenquency) {
        this.obfnId = obfnId;
        this.beamId = beamId;
        this.beamOffsetX = beamOffsetX;
        this.beamWidth = beamWidth;
        this.beamAngle = beamAngle;
        this.beamOffsetY = beamOffsetY;
        this.centralFrenquency =centralFrenquency;
    }


    public float getCentralFrenquency() {
        return centralFrenquency;
    }

    public String getObfnId() {
        return obfnId;
    }

    public int getBeamId() {
        return beamId;
    }

    public int getBeamOffsetX() {
        return beamOffsetX;
    }

    public int getBeamWidth() {
        return beamWidth;
    }

    public int getBeamOffsetY() {
        return beamOffsetY;
    }

    public int getBeamAngle() {
        return beamAngle;
    }
}
