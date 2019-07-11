/*
 * tapi-arof API
 * tapi-arof API generated from tapi-arof.yang
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
import io.swagger.client.model.ConnectionRef;
import java.io.IOException;

/**
 * SwitchControlRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:13:03.153+02:00")
public class SwitchControlRef {
  @SerializedName("connection-uuid")
  private String connectionUuid = null;

  @SerializedName("switch-control-uuid")
  private String switchControlUuid = null;

  public SwitchControlRef connectionUuid(String connectionUuid) {
    this.connectionUuid = connectionUuid;
    return this;
  }

   /**
   * Get connectionUuid
   * @return connectionUuid
  **/
  @ApiModelProperty(value = "")
  public String getConnectionUuid() {
    return connectionUuid;
  }

  public void setConnectionUuid(String connectionUuid) {
    this.connectionUuid = connectionUuid;
  }

  public SwitchControlRef switchControlUuid(String switchControlUuid) {
    this.switchControlUuid = switchControlUuid;
    return this;
  }

   /**
   * Get switchControlUuid
   * @return switchControlUuid
  **/
  @ApiModelProperty(value = "")
  public String getSwitchControlUuid() {
    return switchControlUuid;
  }

  public void setSwitchControlUuid(String switchControlUuid) {
    this.switchControlUuid = switchControlUuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SwitchControlRef switchControlRef = (SwitchControlRef) o;
    return Objects.equals(this.connectionUuid, switchControlRef.connectionUuid) &&
        Objects.equals(this.switchControlUuid, switchControlRef.switchControlUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectionUuid, switchControlUuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SwitchControlRef {\n");
    
    sb.append("    connectionUuid: ").append(toIndentedString(connectionUuid)).append("\n");
    sb.append("    switchControlUuid: ").append(toIndentedString(switchControlUuid)).append("\n");
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

