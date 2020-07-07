package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

public class ObfnMediaChannel {

    @SerializedName("occupied-spectrum")
    private SpectrumBand occupiedSpectrum = null;

    public ObfnMediaChannel() {

    }

    public ObfnMediaChannel(SpectrumBand occupiedSpectrum) {
        this.occupiedSpectrum = occupiedSpectrum;
    }

    public SpectrumBand getOccupiedSpectrum() {
        return occupiedSpectrum;
    }
}
