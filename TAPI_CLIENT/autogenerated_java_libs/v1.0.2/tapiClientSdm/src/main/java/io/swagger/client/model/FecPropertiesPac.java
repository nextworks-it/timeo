/*
 * tapi-sdm API
 * tapi-sdm API generated from tapi-sdm.yang
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
import java.io.IOException;

/**
 * FecPropertiesPac
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class FecPropertiesPac {
  @SerializedName("uncorrectable-bytes")
  private String uncorrectableBytes = null;

  @SerializedName("corrected-bits")
  private String correctedBits = null;

  @SerializedName("uncorrectable-bits")
  private String uncorrectableBits = null;

  @SerializedName("pre-fec-ber")
  private String preFecBer = null;

  @SerializedName("post-fec-ber")
  private String postFecBer = null;

  @SerializedName("corrected-bytes")
  private String correctedBytes = null;

  public FecPropertiesPac uncorrectableBytes(String uncorrectableBytes) {
    this.uncorrectableBytes = uncorrectableBytes;
    return this;
  }

   /**
   * Bytes that could not be corrected by FEC
   * @return uncorrectableBytes
  **/
  @ApiModelProperty(value = "Bytes that could not be corrected by FEC")
  public String getUncorrectableBytes() {
    return uncorrectableBytes;
  }

  public void setUncorrectableBytes(String uncorrectableBytes) {
    this.uncorrectableBytes = uncorrectableBytes;
  }

  public FecPropertiesPac correctedBits(String correctedBits) {
    this.correctedBits = correctedBits;
    return this;
  }

   /**
   * Bits corrected between those that were received corrupted
   * @return correctedBits
  **/
  @ApiModelProperty(value = "Bits corrected between those that were received corrupted")
  public String getCorrectedBits() {
    return correctedBits;
  }

  public void setCorrectedBits(String correctedBits) {
    this.correctedBits = correctedBits;
  }

  public FecPropertiesPac uncorrectableBits(String uncorrectableBits) {
    this.uncorrectableBits = uncorrectableBits;
    return this;
  }

   /**
   * Bits that could not be corrected by FEC
   * @return uncorrectableBits
  **/
  @ApiModelProperty(value = "Bits that could not be corrected by FEC")
  public String getUncorrectableBits() {
    return uncorrectableBits;
  }

  public void setUncorrectableBits(String uncorrectableBits) {
    this.uncorrectableBits = uncorrectableBits;
  }

  public FecPropertiesPac preFecBer(String preFecBer) {
    this.preFecBer = preFecBer;
    return this;
  }

   /**
   * counter: bit error rate before correction by FEC
   * @return preFecBer
  **/
  @ApiModelProperty(value = "counter: bit error rate before correction by FEC")
  public String getPreFecBer() {
    return preFecBer;
  }

  public void setPreFecBer(String preFecBer) {
    this.preFecBer = preFecBer;
  }

  public FecPropertiesPac postFecBer(String postFecBer) {
    this.postFecBer = postFecBer;
    return this;
  }

   /**
   * counter: bit error rate after correction by FEC
   * @return postFecBer
  **/
  @ApiModelProperty(value = "counter: bit error rate after correction by FEC")
  public String getPostFecBer() {
    return postFecBer;
  }

  public void setPostFecBer(String postFecBer) {
    this.postFecBer = postFecBer;
  }

  public FecPropertiesPac correctedBytes(String correctedBytes) {
    this.correctedBytes = correctedBytes;
    return this;
  }

   /**
   * Bytes corrected between those that were received corrupted
   * @return correctedBytes
  **/
  @ApiModelProperty(value = "Bytes corrected between those that were received corrupted")
  public String getCorrectedBytes() {
    return correctedBytes;
  }

  public void setCorrectedBytes(String correctedBytes) {
    this.correctedBytes = correctedBytes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FecPropertiesPac fecPropertiesPac = (FecPropertiesPac) o;
    return Objects.equals(this.uncorrectableBytes, fecPropertiesPac.uncorrectableBytes) &&
        Objects.equals(this.correctedBits, fecPropertiesPac.correctedBits) &&
        Objects.equals(this.uncorrectableBits, fecPropertiesPac.uncorrectableBits) &&
        Objects.equals(this.preFecBer, fecPropertiesPac.preFecBer) &&
        Objects.equals(this.postFecBer, fecPropertiesPac.postFecBer) &&
        Objects.equals(this.correctedBytes, fecPropertiesPac.correctedBytes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uncorrectableBytes, correctedBits, uncorrectableBits, preFecBer, postFecBer, correctedBytes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FecPropertiesPac {\n");
    
    sb.append("    uncorrectableBytes: ").append(toIndentedString(uncorrectableBytes)).append("\n");
    sb.append("    correctedBits: ").append(toIndentedString(correctedBits)).append("\n");
    sb.append("    uncorrectableBits: ").append(toIndentedString(uncorrectableBits)).append("\n");
    sb.append("    preFecBer: ").append(toIndentedString(preFecBer)).append("\n");
    sb.append("    postFecBer: ").append(toIndentedString(postFecBer)).append("\n");
    sb.append("    correctedBytes: ").append(toIndentedString(correctedBytes)).append("\n");
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
