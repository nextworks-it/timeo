package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

public class CentralFrequency {

    @SerializedName("central-frequency")
    private float centralFrequency;

    @SerializedName("frequency-constraint")
    private FrequencyConstraint frequencyConstraint;

    public float getCentralFrequency() {
        return centralFrequency;
    }

    public void setCentralFrequency(float centralFrequency) {
        this.centralFrequency = centralFrequency;
    }

    public FrequencyConstraint getFrequencyConstraint() {
        return frequencyConstraint;
    }

    public void setFrequencyConstraint(FrequencyConstraint frequencyConstraint) {
        this.frequencyConstraint = frequencyConstraint;
    }
}
