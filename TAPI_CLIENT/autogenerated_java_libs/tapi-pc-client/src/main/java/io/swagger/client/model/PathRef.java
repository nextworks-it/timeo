/*
 * tapi-path-computation API
 * tapi-path-computation API generated from tapi-path-computation@2018-03-07.yang
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
 * PathRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:54:55.433+02:00")
public class PathRef {
  @SerializedName("path-id")
  private String pathId = null;

  public PathRef pathId(String pathId) {
    this.pathId = pathId;
    return this;
  }

   /**
   * Get pathId
   * @return pathId
  **/
  @ApiModelProperty(value = "")
  public String getPathId() {
    return pathId;
  }

  public void setPathId(String pathId) {
    this.pathId = pathId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PathRef pathRef = (PathRef) o;
    return Objects.equals(this.pathId, pathRef.pathId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pathId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PathRef {\n");
    
    sb.append("    pathId: ").append(toIndentedString(pathId)).append("\n");
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

