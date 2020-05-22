package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

public class TapiObfnCpSpec {

    private int supportedLowerAngle;
    private int supportedUpperAngle;
    private int supportedMinWidth;
    private int supportedMaxwidth;
    private int supportedBeams;
    private TapiSupportedWavelength tapiSupportedWavelength;

    public TapiObfnCpSpec(int supportedLowerAngle, int supportedUpperAngle, int supportedMinWidth, int supportedMaxwidth, int supportedBeams, TapiSupportedWavelength tapiSupportedWavelength) {
        this.supportedLowerAngle = supportedLowerAngle;
        this.supportedUpperAngle = supportedUpperAngle;
        this.supportedMinWidth = supportedMinWidth;
        this.supportedMaxwidth = supportedMaxwidth;
        this.supportedBeams = supportedBeams;
        this.tapiSupportedWavelength = tapiSupportedWavelength;
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

    public TapiSupportedWavelength getTapiSupportedWavelength() {
        return tapiSupportedWavelength;
    }
}
