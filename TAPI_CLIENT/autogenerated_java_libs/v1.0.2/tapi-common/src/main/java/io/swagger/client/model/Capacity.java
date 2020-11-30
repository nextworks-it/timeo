/*
 * tapi-common API
 * tapi-common API generated from tapi-common@2018-12-10.yang
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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.BandwidthProfile;
import io.swagger.client.model.CapacityValue;
import java.io.IOException;

/**
 * Information on capacity of a particular TopologicalEntity.
 */
@ApiModel(description = "Information on capacity of a particular TopologicalEntity.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-12T16:06:31.513+02:00")
public class Capacity {
  @SerializedName("bandwidth-profile")
  private BandwidthProfile bandwidthProfile = null;

  @SerializedName("total-size")
  private CapacityValue totalSize = null;

  public Capacity bandwidthProfile(BandwidthProfile bandwidthProfile) {
    this.bandwidthProfile = bandwidthProfile;
    return this;
  }

   /**
   * Get bandwidthProfile
   * @return bandwidthProfile
  **/
  @ApiModelProperty(value = "")
  public BandwidthProfile getBandwidthProfile() {
    return bandwidthProfile;
  }

  public void setBandwidthProfile(BandwidthProfile bandwidthProfile) {
    this.bandwidthProfile = bandwidthProfile;
  }

  public Capacity totalSize(CapacityValue totalSize) {
    this.totalSize = totalSize;
    return this;
  }

   /**
   * Total capacity of the TopologicalEntity in MB/s. In case of bandwidthProfile, this is expected to same as the committedInformationRate.
   * @return totalSize
  **/
  @ApiModelProperty(value = "Total capacity of the TopologicalEntity in MB/s. In case of bandwidthProfile, this is expected to same as the committedInformationRate.")
  public CapacityValue getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(CapacityValue totalSize) {
    this.totalSize = totalSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Capacity capacity = (Capacity) o;
    return Objects.equals(this.bandwidthProfile, capacity.bandwidthProfile) &&
        Objects.equals(this.totalSize, capacity.totalSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bandwidthProfile, totalSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Capacity {\n");
    
    sb.append("    bandwidthProfile: ").append(toIndentedString(bandwidthProfile)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
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

