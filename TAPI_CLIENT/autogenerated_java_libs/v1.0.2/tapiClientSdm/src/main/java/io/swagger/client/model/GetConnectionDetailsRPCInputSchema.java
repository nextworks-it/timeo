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
 * GetConnectionDetailsRPCInputSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class GetConnectionDetailsRPCInputSchema {
  @SerializedName("connection-id-or-name")
  private String connectionIdOrName = null;

  public GetConnectionDetailsRPCInputSchema connectionIdOrName(String connectionIdOrName) {
    this.connectionIdOrName = connectionIdOrName;
    return this;
  }

   /**
   * Get connectionIdOrName
   * @return connectionIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getConnectionIdOrName() {
    return connectionIdOrName;
  }

  public void setConnectionIdOrName(String connectionIdOrName) {
    this.connectionIdOrName = connectionIdOrName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetConnectionDetailsRPCInputSchema getConnectionDetailsRPCInputSchema = (GetConnectionDetailsRPCInputSchema) o;
    return Objects.equals(this.connectionIdOrName, getConnectionDetailsRPCInputSchema.connectionIdOrName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectionIdOrName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConnectionDetailsRPCInputSchema {\n");
    
    sb.append("    connectionIdOrName: ").append(toIndentedString(connectionIdOrName)).append("\n");
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

