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
import io.swagger.client.model.AvailabletransceiverCoreid;
import io.swagger.client.model.AvailabletransceiverModeid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CoreModeRefSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class CoreModeRefSchema {
  @SerializedName("mode-id")
  private List<AvailabletransceiverModeid> modeId = null;

  @SerializedName("core_mode_ref")
  private String coreModeRef = null;

  @SerializedName("core-id")
  private List<AvailabletransceiverCoreid> coreId = null;

  public CoreModeRefSchema modeId(List<AvailabletransceiverModeid> modeId) {
    this.modeId = modeId;
    return this;
  }

  public CoreModeRefSchema addModeIdItem(AvailabletransceiverModeid modeIdItem) {
    if (this.modeId == null) {
      this.modeId = new ArrayList<AvailabletransceiverModeid>();
    }
    this.modeId.add(modeIdItem);
    return this;
  }

   /**
   * Get modeId
   * @return modeId
  **/
  @ApiModelProperty(value = "")
  public List<AvailabletransceiverModeid> getModeId() {
    return modeId;
  }

  public void setModeId(List<AvailabletransceiverModeid> modeId) {
    this.modeId = modeId;
  }

  public CoreModeRefSchema coreModeRef(String coreModeRef) {
    this.coreModeRef = coreModeRef;
    return this;
  }

   /**
   * Get coreModeRef
   * @return coreModeRef
  **/
  @ApiModelProperty(value = "")
  public String getCoreModeRef() {
    return coreModeRef;
  }

  public void setCoreModeRef(String coreModeRef) {
    this.coreModeRef = coreModeRef;
  }

  public CoreModeRefSchema coreId(List<AvailabletransceiverCoreid> coreId) {
    this.coreId = coreId;
    return this;
  }

  public CoreModeRefSchema addCoreIdItem(AvailabletransceiverCoreid coreIdItem) {
    if (this.coreId == null) {
      this.coreId = new ArrayList<AvailabletransceiverCoreid>();
    }
    this.coreId.add(coreIdItem);
    return this;
  }

   /**
   * Get coreId
   * @return coreId
  **/
  @ApiModelProperty(value = "")
  public List<AvailabletransceiverCoreid> getCoreId() {
    return coreId;
  }

  public void setCoreId(List<AvailabletransceiverCoreid> coreId) {
    this.coreId = coreId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoreModeRefSchema coreModeRefSchema = (CoreModeRefSchema) o;
    return Objects.equals(this.modeId, coreModeRefSchema.modeId) &&
        Objects.equals(this.coreModeRef, coreModeRefSchema.coreModeRef) &&
        Objects.equals(this.coreId, coreModeRefSchema.coreId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modeId, coreModeRef, coreId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoreModeRefSchema {\n");
    
    sb.append("    modeId: ").append(toIndentedString(modeId)).append("\n");
    sb.append("    coreModeRef: ").append(toIndentedString(coreModeRef)).append("\n");
    sb.append("    coreId: ").append(toIndentedString(coreId)).append("\n");
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
