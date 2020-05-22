package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

public class BluespaceObfnCpSpec {

    private int supportedLowerAngle;
    private int supportedUpperAngle;
    private int supportedMinWidth;
    private int supportedMaxwidth;
    private int supportedBeams;
    private BluespaceSupportedWavelength bluespaceSupportedWavelength;

    public BluespaceObfnCpSpec(){

    }

    public BluespaceObfnCpSpec(int supportedLowerAngle, int supportedUpperAngle, int supportedMinWidth, int supportedMaxwidth, int supportedBeams, BluespaceSupportedWavelength bluespaceSupportedWavelength) {
        this.supportedLowerAngle = supportedLowerAngle;
        this.supportedUpperAngle = supportedUpperAngle;
        this.supportedMinWidth = supportedMinWidth;
        this.supportedMaxwidth = supportedMaxwidth;
        this.supportedBeams = supportedBeams;
        this.bluespaceSupportedWavelength = bluespaceSupportedWavelength;
    }

    public int getSupportedLowerAngle() {
        return supportedLowerAngle;
    }

    public int getSupportedUpperAngle() {
        return supportedUpperAngle;
    }

    public int getSupportedMinWidth() {
        return supportedMinWidth;
    }

    public int getSupportedMaxwidth() {
        return supportedMaxwidth;
    }

    public int getSupportedBeams() {
        return supportedBeams;
    }

    public BluespaceSupportedWavelength getBluespaceSupportedWavelength() {
        return bluespaceSupportedWavelength;
    }
}
