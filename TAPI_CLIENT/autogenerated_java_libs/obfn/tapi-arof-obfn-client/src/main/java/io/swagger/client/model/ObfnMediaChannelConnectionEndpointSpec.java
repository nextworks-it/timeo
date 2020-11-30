package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

public class ObfnMediaChannelConnectionEndpointSpec {

    @SerializedName("media-channel")
    private ObfnMediaChannel mediaChannel = null;


    public ObfnMediaChannelConnectionEndpointSpec() {
    }

    public ObfnMediaChannelConnectionEndpointSpec(ObfnMediaChannel mediaChannel) {
        this.mediaChannel = mediaChannel;
    }

    public ObfnMediaChannel getMediaChannel() {
        return mediaChannel;
    }
}
