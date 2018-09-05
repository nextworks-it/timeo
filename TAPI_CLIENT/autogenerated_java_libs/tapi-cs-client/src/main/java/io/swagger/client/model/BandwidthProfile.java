/*
 * tapi-connectivity API
 * tapi-connectivity API generated from tapi-connectivity@2018-03-07.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.CapacityValue;
import java.io.IOException;

/**
 * BandwidthProfile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:54:22.249+02:00")
public class BandwidthProfile {
  @SerializedName("color-aware")
  private Boolean colorAware = null;

  /**
   * Gets or Sets bwProfileType
   */
  @JsonAdapter(BwProfileTypeEnum.Adapter.class)
  public enum BwProfileTypeEnum {
    MEF_10_X("MEF_10.x"),
    
    RFC_2697("RFC_2697"),
    
    RFC_2698("RFC_2698"),
    
    RFC_4115("RFC_4115");

    private String value;

    BwProfileTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BwProfileTypeEnum fromValue(String text) {
      for (BwProfileTypeEnum b : BwProfileTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<BwProfileTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BwProfileTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BwProfileTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return BwProfileTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("bw-profile-type")
  private BwProfileTypeEnum bwProfileType = null;

  @SerializedName("peak-information-rate")
  private CapacityValue peakInformationRate = null;

  @SerializedName("coupling-flag")
  private Boolean couplingFlag = null;

  @SerializedName("committed-information-rate")
  private CapacityValue committedInformationRate = null;

  @SerializedName("committed-burst-size")
  private CapacityValue committedBurstSize = null;

  @SerializedName("peak-burst-size")
  private CapacityValue peakBurstSize = null;

  public BandwidthProfile colorAware(Boolean colorAware) {
    this.colorAware = colorAware;
    return this;
  }

   /**
   * Get colorAware
   * @return colorAware
  **/
  @ApiModelProperty(value = "")
  public Boolean isColorAware() {
    return colorAware;
  }

  public void setColorAware(Boolean colorAware) {
    this.colorAware = colorAware;
  }

  public BandwidthProfile bwProfileType(BwProfileTypeEnum bwProfileType) {
    this.bwProfileType = bwProfileType;
    return this;
  }

   /**
   * Get bwProfileType
   * @return bwProfileType
  **/
  @ApiModelProperty(value = "")
  public BwProfileTypeEnum getBwProfileType() {
    return bwProfileType;
  }

  public void setBwProfileType(BwProfileTypeEnum bwProfileType) {
    this.bwProfileType = bwProfileType;
  }

  public BandwidthProfile peakInformationRate(CapacityValue peakInformationRate) {
    this.peakInformationRate = peakInformationRate;
    return this;
  }

   /**
   * Get peakInformationRate
   * @return peakInformationRate
  **/
  @ApiModelProperty(value = "")
  public CapacityValue getPeakInformationRate() {
    return peakInformationRate;
  }

  public void setPeakInformationRate(CapacityValue peakInformationRate) {
    this.peakInformationRate = peakInformationRate;
  }

  public BandwidthProfile couplingFlag(Boolean couplingFlag) {
    this.couplingFlag = couplingFlag;
    return this;
  }

   /**
   * Get couplingFlag
   * @return couplingFlag
  **/
  @ApiModelProperty(value = "")
  public Boolean isCouplingFlag() {
    return couplingFlag;
  }

  public void setCouplingFlag(Boolean couplingFlag) {
    this.couplingFlag = couplingFlag;
  }

  public BandwidthProfile committedInformationRate(CapacityValue committedInformationRate) {
    this.committedInformationRate = committedInformationRate;
    return this;
  }

   /**
   * Get committedInformationRate
   * @return committedInformationRate
  **/
  @ApiModelProperty(value = "")
  public CapacityValue getCommittedInformationRate() {
    return committedInformationRate;
  }

  public void setCommittedInformationRate(CapacityValue committedInformationRate) {
    this.committedInformationRate = committedInformationRate;
  }

  public BandwidthProfile committedBurstSize(CapacityValue committedBurstSize) {
    this.committedBurstSize = committedBurstSize;
    return this;
  }

   /**
   * Get committedBurstSize
   * @return committedBurstSize
  **/
  @ApiModelProperty(value = "")
  public CapacityValue getCommittedBurstSize() {
    return committedBurstSize;
  }

  public void setCommittedBurstSize(CapacityValue committedBurstSize) {
    this.committedBurstSize = committedBurstSize;
  }

  public BandwidthProfile peakBurstSize(CapacityValue peakBurstSize) {
    this.peakBurstSize = peakBurstSize;
    return this;
  }

   /**
   * Get peakBurstSize
   * @return peakBurstSize
  **/
  @ApiModelProperty(value = "")
  public CapacityValue getPeakBurstSize() {
    return peakBurstSize;
  }

  public void setPeakBurstSize(CapacityValue peakBurstSize) {
    this.peakBurstSize = peakBurstSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BandwidthProfile bandwidthProfile = (BandwidthProfile) o;
    return Objects.equals(this.colorAware, bandwidthProfile.colorAware) &&
        Objects.equals(this.bwProfileType, bandwidthProfile.bwProfileType) &&
        Objects.equals(this.peakInformationRate, bandwidthProfile.peakInformationRate) &&
        Objects.equals(this.couplingFlag, bandwidthProfile.couplingFlag) &&
        Objects.equals(this.committedInformationRate, bandwidthProfile.committedInformationRate) &&
        Objects.equals(this.committedBurstSize, bandwidthProfile.committedBurstSize) &&
        Objects.equals(this.peakBurstSize, bandwidthProfile.peakBurstSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(colorAware, bwProfileType, peakInformationRate, couplingFlag, committedInformationRate, committedBurstSize, peakBurstSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BandwidthProfile {\n");
    
    sb.append("    colorAware: ").append(toIndentedString(colorAware)).append("\n");
    sb.append("    bwProfileType: ").append(toIndentedString(bwProfileType)).append("\n");
    sb.append("    peakInformationRate: ").append(toIndentedString(peakInformationRate)).append("\n");
    sb.append("    couplingFlag: ").append(toIndentedString(couplingFlag)).append("\n");
    sb.append("    committedInformationRate: ").append(toIndentedString(committedInformationRate)).append("\n");
    sb.append("    committedBurstSize: ").append(toIndentedString(committedBurstSize)).append("\n");
    sb.append("    peakBurstSize: ").append(toIndentedString(peakBurstSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

