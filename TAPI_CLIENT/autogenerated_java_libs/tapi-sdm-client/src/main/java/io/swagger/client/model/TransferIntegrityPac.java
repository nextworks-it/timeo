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
 * Transfer intergrity characteristic covers expected/specified/acceptable characteristic of degradation of the transfered signal. It includes all aspects of possible degradation of signal content as well as any damage of any form to the total TopologicalEntity and to the carried signals. Note that the statement is of total impact to the TopologicalEntity so any partial usage of the TopologicalEntity (e.g. a signal that does not use full capacity) will only suffer its portion of the impact.
 */
@ApiModel(description = "Transfer intergrity characteristic covers expected/specified/acceptable characteristic of degradation of the transfered signal. It includes all aspects of possible degradation of signal content as well as any damage of any form to the total TopologicalEntity and to the carried signals. Note that the statement is of total impact to the TopologicalEntity so any partial usage of the TopologicalEntity (e.g. a signal that does not use full capacity) will only suffer its portion of the impact.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class TransferIntegrityPac {
  @SerializedName("error-characteristic")
  private String errorCharacteristic = null;

  @SerializedName("unavailable-time-characteristic")
  private String unavailableTimeCharacteristic = null;

  @SerializedName("loss-characteristic")
  private String lossCharacteristic = null;

  @SerializedName("delivery-order-characteristic")
  private String deliveryOrderCharacteristic = null;

  @SerializedName("server-integrity-process-characteristic")
  private String serverIntegrityProcessCharacteristic = null;

  @SerializedName("repeat-delivery-characteristic")
  private String repeatDeliveryCharacteristic = null;

  public TransferIntegrityPac errorCharacteristic(String errorCharacteristic) {
    this.errorCharacteristic = errorCharacteristic;
    return this;
  }

   /**
   * Describes the degree to which the signal propagated can be errored.  Applies to TDM systems as the errored signal will be propagated and not packet as errored packets will be discarded.
   * @return errorCharacteristic
  **/
  @ApiModelProperty(value = "Describes the degree to which the signal propagated can be errored.  Applies to TDM systems as the errored signal will be propagated and not packet as errored packets will be discarded.")
  public String getErrorCharacteristic() {
    return errorCharacteristic;
  }

  public void setErrorCharacteristic(String errorCharacteristic) {
    this.errorCharacteristic = errorCharacteristic;
  }

  public TransferIntegrityPac unavailableTimeCharacteristic(String unavailableTimeCharacteristic) {
    this.unavailableTimeCharacteristic = unavailableTimeCharacteristic;
    return this;
  }

   /**
   * Describes the duration for which there may be no valid signal propagated.
   * @return unavailableTimeCharacteristic
  **/
  @ApiModelProperty(value = "Describes the duration for which there may be no valid signal propagated.")
  public String getUnavailableTimeCharacteristic() {
    return unavailableTimeCharacteristic;
  }

  public void setUnavailableTimeCharacteristic(String unavailableTimeCharacteristic) {
    this.unavailableTimeCharacteristic = unavailableTimeCharacteristic;
  }

  public TransferIntegrityPac lossCharacteristic(String lossCharacteristic) {
    this.lossCharacteristic = lossCharacteristic;
    return this;
  }

   /**
   * Describes the acceptable characteristic of lost packets where loss may result from discard due to errors or overflow. Applies to packet systems and not TDM (as for TDM errored signals are propagated unless grossly errored and overflow/underflow turns into timing slips).
   * @return lossCharacteristic
  **/
  @ApiModelProperty(value = "Describes the acceptable characteristic of lost packets where loss may result from discard due to errors or overflow. Applies to packet systems and not TDM (as for TDM errored signals are propagated unless grossly errored and overflow/underflow turns into timing slips).")
  public String getLossCharacteristic() {
    return lossCharacteristic;
  }

  public void setLossCharacteristic(String lossCharacteristic) {
    this.lossCharacteristic = lossCharacteristic;
  }

  public TransferIntegrityPac deliveryOrderCharacteristic(String deliveryOrderCharacteristic) {
    this.deliveryOrderCharacteristic = deliveryOrderCharacteristic;
    return this;
  }

   /**
   * Describes the degree to which packets will be delivered out of sequence. Does not apply to TDM as the TDM protocols maintain strict order.
   * @return deliveryOrderCharacteristic
  **/
  @ApiModelProperty(value = "Describes the degree to which packets will be delivered out of sequence. Does not apply to TDM as the TDM protocols maintain strict order.")
  public String getDeliveryOrderCharacteristic() {
    return deliveryOrderCharacteristic;
  }

  public void setDeliveryOrderCharacteristic(String deliveryOrderCharacteristic) {
    this.deliveryOrderCharacteristic = deliveryOrderCharacteristic;
  }

  public TransferIntegrityPac serverIntegrityProcessCharacteristic(String serverIntegrityProcessCharacteristic) {
    this.serverIntegrityProcessCharacteristic = serverIntegrityProcessCharacteristic;
    return this;
  }

   /**
   * Describes the effect of any server integrity enhancement process on the characteristics of the TopologicalEntity.
   * @return serverIntegrityProcessCharacteristic
  **/
  @ApiModelProperty(value = "Describes the effect of any server integrity enhancement process on the characteristics of the TopologicalEntity.")
  public String getServerIntegrityProcessCharacteristic() {
    return serverIntegrityProcessCharacteristic;
  }

  public void setServerIntegrityProcessCharacteristic(String serverIntegrityProcessCharacteristic) {
    this.serverIntegrityProcessCharacteristic = serverIntegrityProcessCharacteristic;
  }

  public TransferIntegrityPac repeatDeliveryCharacteristic(String repeatDeliveryCharacteristic) {
    this.repeatDeliveryCharacteristic = repeatDeliveryCharacteristic;
    return this;
  }

   /**
   * Primarily applies to packet systems where a packet may be delivered more than once (in fault recovery for example).  It can also apply to TDM where several frames may be received twice due to switching in a system with a large differential propagation delay.
   * @return repeatDeliveryCharacteristic
  **/
  @ApiModelProperty(value = "Primarily applies to packet systems where a packet may be delivered more than once (in fault recovery for example).  It can also apply to TDM where several frames may be received twice due to switching in a system with a large differential propagation delay.")
  public String getRepeatDeliveryCharacteristic() {
    return repeatDeliveryCharacteristic;
  }

  public void setRepeatDeliveryCharacteristic(String repeatDeliveryCharacteristic) {
    this.repeatDeliveryCharacteristic = repeatDeliveryCharacteristic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferIntegrityPac transferIntegrityPac = (TransferIntegrityPac) o;
    return Objects.equals(this.errorCharacteristic, transferIntegrityPac.errorCharacteristic) &&
        Objects.equals(this.unavailableTimeCharacteristic, transferIntegrityPac.unavailableTimeCharacteristic) &&
        Objects.equals(this.lossCharacteristic, transferIntegrityPac.lossCharacteristic) &&
        Objects.equals(this.deliveryOrderCharacteristic, transferIntegrityPac.deliveryOrderCharacteristic) &&
        Objects.equals(this.serverIntegrityProcessCharacteristic, transferIntegrityPac.serverIntegrityProcessCharacteristic) &&
        Objects.equals(this.repeatDeliveryCharacteristic, transferIntegrityPac.repeatDeliveryCharacteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCharacteristic, unavailableTimeCharacteristic, lossCharacteristic, deliveryOrderCharacteristic, serverIntegrityProcessCharacteristic, repeatDeliveryCharacteristic);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferIntegrityPac {\n");
    
    sb.append("    errorCharacteristic: ").append(toIndentedString(errorCharacteristic)).append("\n");
    sb.append("    unavailableTimeCharacteristic: ").append(toIndentedString(unavailableTimeCharacteristic)).append("\n");
    sb.append("    lossCharacteristic: ").append(toIndentedString(lossCharacteristic)).append("\n");
    sb.append("    deliveryOrderCharacteristic: ").append(toIndentedString(deliveryOrderCharacteristic)).append("\n");
    sb.append("    serverIntegrityProcessCharacteristic: ").append(toIndentedString(serverIntegrityProcessCharacteristic)).append("\n");
    sb.append("    repeatDeliveryCharacteristic: ").append(toIndentedString(repeatDeliveryCharacteristic)).append("\n");
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
