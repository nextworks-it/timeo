package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

public class CentralFrequency {

    @SerializedName("central-frequency")
    private long centralFrequency;

    @SerializedName("frequency-constraint")
    private FrequencyConstraint frequencyConstraint;

    public long getCentralFrequency() {
        return centralFrequency;
    }

    public void setCentralFrequency(long centralFrequency) {
        this.centralFrequency = centralFrequency;
    }

    public FrequencyConstraint getFrequencyConstraint() {
        return frequencyConstraint;
    }

    public void setFrequencyConstraint(FrequencyConstraint frequencyConstraint) {
        this.frequencyConstraint = frequencyConstraint;
    }
}
