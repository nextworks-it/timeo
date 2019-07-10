/*
 * tapi-photonic-media API
 * tapi-photonic-media API generated from tapi-photonic-media@2018-12-10.yang
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
import io.swagger.client.model.MediaChannelPoolCapabilityPac;
import java.io.IOException;

/**
 * MediaChannelNodeEdgePointSpec
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class MediaChannelNodeEdgePointSpec {
  @SerializedName("mc-pool")
  private MediaChannelPoolCapabilityPac mcPool = null;

  public MediaChannelNodeEdgePointSpec mcPool(MediaChannelPoolCapabilityPac mcPool) {
    this.mcPool = mcPool;
    return this;
  }

   /**
   * Get mcPool
   * @return mcPool
  **/
  @ApiModelProperty(value = "")
  public MediaChannelPoolCapabilityPac getMcPool() {
    return mcPool;
  }

  public void setMcPool(MediaChannelPoolCapabilityPac mcPool) {
    this.mcPool = mcPool;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaChannelNodeEdgePointSpec mediaChannelNodeEdgePointSpec = (MediaChannelNodeEdgePointSpec) o;
    return Objects.equals(this.mcPool, mediaChannelNodeEdgePointSpec.mcPool);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mcPool);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaChannelNodeEdgePointSpec {\n");
    
    sb.append("    mcPool: ").append(toIndentedString(mcPool)).append("\n");
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

