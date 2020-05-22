package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

public class SupportedWavelength {

    @SerializedName("upper-frequency")
    private long upperFrequency;

    @SerializedName("lower-frequency")
    private long lowerFrequency;


    @SerializedName("frequency-constraint")
    private FrequencyConstraint frequencyConstraint;

    public long getUpperFrequency() {
        return upperFrequency;
    }

    public void setUpperFrequency(long upperFrequency) {
        this.upperFrequency = upperFrequency;
    }

    public long getLowerFrequency() {
        return lowerFrequency;
    }

    public void setLowerFrequency(long lowerFrequency) {
        this.lowerFrequency = lowerFrequency;
    }

    public FrequencyConstraint getFrequencyConstraint() {
        return frequencyConstraint;
    }

    public void setFrequencyConstraint(FrequencyConstraint frequencyConstraint) {
        this.frequencyConstraint = frequencyConstraint;
    }
}
