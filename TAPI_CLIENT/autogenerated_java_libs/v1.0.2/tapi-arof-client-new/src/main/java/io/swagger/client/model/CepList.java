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
import io.swagger.client.model.ConnectionEndPoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CepList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:13:03.153+02:00")
public class CepList {
	
	//TODO: Modified this
  @SerializedName("connection-end-point")
  private List<ConnectionEndPointSchema> connectionEndPoint = null;
  //private List<ConnectionEndPoint> connectionEndPoint = null;
  
  public CepList connectionEndPoint(List<ConnectionEndPointSchema> connectionEndPoint) {
    this.connectionEndPoint = connectionEndPoint;
    return this;
  }

  public CepList addConnectionEndPointItem(ConnectionEndPointSchema connectionEndPointItem) {
    if (this.connectionEndPoint == null) {
      this.connectionEndPoint = new ArrayList<ConnectionEndPointSchema>();
    }
    this.connectionEndPoint.add(connectionEndPointItem);
    return this;
  }

   /**
   * Get connectionEndPoint
   * @return connectionEndPoint
  **/
  @ApiModelProperty(value = "")
  public List<ConnectionEndPointSchema> getConnectionEndPoint() {
    return connectionEndPoint;
  }

  public void setConnectionEndPoint(List<ConnectionEndPointSchema> connectionEndPoint) {
    this.connectionEndPoint = connectionEndPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CepList cepList = (CepList) o;
    return Objects.equals(this.connectionEndPoint, cepList.connectionEndPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectionEndPoint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CepList {\n");
    
    sb.append("    connectionEndPoint: ").append(toIndentedString(connectionEndPoint)).append("\n");
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

