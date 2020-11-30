package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

public class SupportedWavelength {

    @SerializedName("upper-frequency")
    private float upperFrequency;

    @SerializedName("lower-frequency")
    private float lowerFrequency;


    @SerializedName("frequency-constraint")
    private FrequencyConstraint frequencyConstraint;

    public float getUpperFrequency() {
        return upperFrequency;
    }

    public void setUpperFrequency(float upperFrequency) {
        this.upperFrequency = upperFrequency;
    }

    public float getLowerFrequency() {
        return lowerFrequency;
    }

    public void setLowerFrequency(float lowerFrequency) {
        this.lowerFrequency = lowerFrequency;
    }

    public FrequencyConstraint getFrequencyConstraint() {
        return frequencyConstraint;
    }

    public void setFrequencyConstraint(FrequencyConstraint frequencyConstraint) {
        this.frequencyConstraint = frequencyConstraint;
    }
}
