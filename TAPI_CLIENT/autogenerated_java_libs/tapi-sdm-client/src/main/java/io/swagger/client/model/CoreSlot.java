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
import io.swagger.client.model.FrequencySlot;
import io.swagger.client.model.OtsiPoolPac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CoreSlot
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class CoreSlot {
  @SerializedName("available-frequency-slot")
  private List<FrequencySlot> availableFrequencySlot = null;

  @SerializedName("occupied-frequency-slot")
  private List<FrequencySlot> occupiedFrequencySlot = null;

  @SerializedName("core-id")
  private String coreId = null;

  public CoreSlot availableFrequencySlot(List<FrequencySlot> availableFrequencySlot) {
    this.availableFrequencySlot = availableFrequencySlot;
    return this;
  }

  public CoreSlot addAvailableFrequencySlotItem(FrequencySlot availableFrequencySlotItem) {
    if (this.availableFrequencySlot == null) {
      this.availableFrequencySlot = new ArrayList<FrequencySlot>();
    }
    this.availableFrequencySlot.add(availableFrequencySlotItem);
    return this;
  }

   /**
   * Get availableFrequencySlot
   * @return availableFrequencySlot
  **/
  @ApiModelProperty(value = "")
  public List<FrequencySlot> getAvailableFrequencySlot() {
    return availableFrequencySlot;
  }

  public void setAvailableFrequencySlot(List<FrequencySlot> availableFrequencySlot) {
    this.availableFrequencySlot = availableFrequencySlot;
  }

  public CoreSlot occupiedFrequencySlot(List<FrequencySlot> occupiedFrequencySlot) {
    this.occupiedFrequencySlot = occupiedFrequencySlot;
    return this;
  }

  public CoreSlot addOccupiedFrequencySlotItem(FrequencySlot occupiedFrequencySlotItem) {
    if (this.occupiedFrequencySlot == null) {
      this.occupiedFrequencySlot = new ArrayList<FrequencySlot>();
    }
    this.occupiedFrequencySlot.add(occupiedFrequencySlotItem);
    return this;
  }

   /**
   * Get occupiedFrequencySlot
   * @return occupiedFrequencySlot
  **/
  @ApiModelProperty(value = "")
  public List<FrequencySlot> getOccupiedFrequencySlot() {
    return occupiedFrequencySlot;
  }

  public void setOccupiedFrequencySlot(List<FrequencySlot> occupiedFrequencySlot) {
    this.occupiedFrequencySlot = occupiedFrequencySlot;
  }

  public CoreSlot coreId(String coreId) {
    this.coreId = coreId;
    return this;
  }

   /**
   * Get coreId
   * @return coreId
  **/
  @ApiModelProperty(value = "")
  public String getCoreId() {
    return coreId;
  }

  public void setCoreId(String coreId) {
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
    CoreSlot coreSlot = (CoreSlot) o;
    return Objects.equals(this.availableFrequencySlot, coreSlot.availableFrequencySlot) &&
        Objects.equals(this.occupiedFrequencySlot, coreSlot.occupiedFrequencySlot) &&
        Objects.equals(this.coreId, coreSlot.coreId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableFrequencySlot, occupiedFrequencySlot, coreId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoreSlot {\n");
    
    sb.append("    availableFrequencySlot: ").append(toIndentedString(availableFrequencySlot)).append("\n");
    sb.append("    occupiedFrequencySlot: ").append(toIndentedString(occupiedFrequencySlot)).append("\n");
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
