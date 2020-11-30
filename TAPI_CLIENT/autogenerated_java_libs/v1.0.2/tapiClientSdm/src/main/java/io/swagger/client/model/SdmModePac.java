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
import io.swagger.client.model.MediaChannelPoolCapabilityPac;
import io.swagger.client.model.SpectrumBand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SdmModePac
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class SdmModePac {
  @SerializedName("supportable-spectrum")
  private List<SpectrumBand> supportableSpectrum = null;

  @SerializedName("available-spectrum")
  private List<SpectrumBand> availableSpectrum = null;

  @SerializedName("occupied-spectrum")
  private List<SpectrumBand> occupiedSpectrum = null;

  @SerializedName("mode-id")
  private String modeId = null;

  public SdmModePac supportableSpectrum(List<SpectrumBand> supportableSpectrum) {
    this.supportableSpectrum = supportableSpectrum;
    return this;
  }

  public SdmModePac addSupportableSpectrumItem(SpectrumBand supportableSpectrumItem) {
    if (this.supportableSpectrum == null) {
      this.supportableSpectrum = new ArrayList<SpectrumBand>();
    }
    this.supportableSpectrum.add(supportableSpectrumItem);
    return this;
  }

   /**
   * Get supportableSpectrum
   * @return supportableSpectrum
  **/
  @ApiModelProperty(value = "")
  public List<SpectrumBand> getSupportableSpectrum() {
    return supportableSpectrum;
  }

  public void setSupportableSpectrum(List<SpectrumBand> supportableSpectrum) {
    this.supportableSpectrum = supportableSpectrum;
  }

  public SdmModePac availableSpectrum(List<SpectrumBand> availableSpectrum) {
    this.availableSpectrum = availableSpectrum;
    return this;
  }

  public SdmModePac addAvailableSpectrumItem(SpectrumBand availableSpectrumItem) {
    if (this.availableSpectrum == null) {
      this.availableSpectrum = new ArrayList<SpectrumBand>();
    }
    this.availableSpectrum.add(availableSpectrumItem);
    return this;
  }

   /**
   * Get availableSpectrum
   * @return availableSpectrum
  **/
  @ApiModelProperty(value = "")
  public List<SpectrumBand> getAvailableSpectrum() {
    return availableSpectrum;
  }

  public void setAvailableSpectrum(List<SpectrumBand> availableSpectrum) {
    this.availableSpectrum = availableSpectrum;
  }

  public SdmModePac occupiedSpectrum(List<SpectrumBand> occupiedSpectrum) {
    this.occupiedSpectrum = occupiedSpectrum;
    return this;
  }

  public SdmModePac addOccupiedSpectrumItem(SpectrumBand occupiedSpectrumItem) {
    if (this.occupiedSpectrum == null) {
      this.occupiedSpectrum = new ArrayList<SpectrumBand>();
    }
    this.occupiedSpectrum.add(occupiedSpectrumItem);
    return this;
  }

   /**
   * Get occupiedSpectrum
   * @return occupiedSpectrum
  **/
  @ApiModelProperty(value = "")
  public List<SpectrumBand> getOccupiedSpectrum() {
    return occupiedSpectrum;
  }

  public void setOccupiedSpectrum(List<SpectrumBand> occupiedSpectrum) {
    this.occupiedSpectrum = occupiedSpectrum;
  }

  public SdmModePac modeId(String modeId) {
    this.modeId = modeId;
    return this;
  }

   /**
   * Get modeId
   * @return modeId
  **/
  @ApiModelProperty(value = "")
  public String getModeId() {
    return modeId;
  }

  public void setModeId(String modeId) {
    this.modeId = modeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SdmModePac sdmModePac = (SdmModePac) o;
    return Objects.equals(this.supportableSpectrum, sdmModePac.supportableSpectrum) &&
        Objects.equals(this.availableSpectrum, sdmModePac.availableSpectrum) &&
        Objects.equals(this.occupiedSpectrum, sdmModePac.occupiedSpectrum) &&
        Objects.equals(this.modeId, sdmModePac.modeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportableSpectrum, availableSpectrum, occupiedSpectrum, modeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SdmModePac {\n");
    
    sb.append("    supportableSpectrum: ").append(toIndentedString(supportableSpectrum)).append("\n");
    sb.append("    availableSpectrum: ").append(toIndentedString(availableSpectrum)).append("\n");
    sb.append("    occupiedSpectrum: ").append(toIndentedString(occupiedSpectrum)).append("\n");
    sb.append("    modeId: ").append(toIndentedString(modeId)).append("\n");
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

