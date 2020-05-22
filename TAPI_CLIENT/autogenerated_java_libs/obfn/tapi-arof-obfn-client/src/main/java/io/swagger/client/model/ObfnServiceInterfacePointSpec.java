package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;


/**
 * Handmade class
 */
public class ObfnServiceInterfacePointSpec {

    @SerializedName("supported-wavelength")
    private SupportedWavelength supportedWavelength;

    @SerializedName("supported-lower-angle")
    private int supportedLowerAngle;

    @SerializedName("supported-upper-angle")
    private int supportedUpperAngle;

    @SerializedName("supported-min-width")
    private int supportedMinWidth;


    @SerializedName("supported-max-width")
    private int supportedMaxWidth;

    public int getSupportedMinWidth() {
        return supportedMinWidth;
    }

    public void setSupportedMinWidth(int supportedMinWidth) {
        this.supportedMinWidth = supportedMinWidth;
    }

    @SerializedName("supported-beams")
    private int supportedBeams;


    public SupportedWavelength getSupportedWavelength() {
        return supportedWavelength;
    }

    public void setSupportedWavelength(SupportedWavelength supportedWavelength) {
        this.supportedWavelength = supportedWavelength;
    }


    public int getSupportedLowerAngle() {
        return supportedLowerAngle;
    }

    public void setSupportedLowerAngle(int supportedLowerAngle) {
        this.supportedLowerAngle = supportedLowerAngle;
    }

    public int getSupportedUpperAngle() {
        return supportedUpperAngle;
    }

    public void setSupportedUpperAngle(int supportedUpperAngle) {
        this.supportedUpperAngle = supportedUpperAngle;
    }

    public int getSupportedBeams() {
        return supportedBeams;
    }

    public void setSupportedBeams(int supportedBeams) {
        this.supportedBeams = supportedBeams;
    }

    public int getSupportedMaxWidth() {
        return supportedMaxWidth;
    }

    public void setSupportedMaxWidth(int supportedMaxWidth) {
        this.supportedMaxWidth = supportedMaxWidth;
    }
}
