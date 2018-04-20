package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

    /**
     * Created by json2java on 22/06/17.
     * json2java author: Marco Capitani (m.capitani AT nextworks DOT it)
     */

public class MeterFeatures {

    @JsonProperty("max_color")
    public long maxColor;

    @JsonProperty("max_meter")
    public long maxMeter;

    @JsonProperty("max_bands")
    public long maxBands;

}