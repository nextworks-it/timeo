/**
 * tapi-connectivity API
 * tapi-connectivity API generated from tapi-connectivity@2018-12-10.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.PathObjectiveFunction;
import io.swagger.client.model.PathOptimizationConstraint;
import io.swagger.client.model.PathRef;
import io.swagger.client.model.PathServiceEndPoint;
import io.swagger.client.model.RoutingConstraint;
import io.swagger.client.model.ServiceSpec;
import io.swagger.client.model.TopologyConstraint;
import java.util.ArrayList;
import java.util.List;


/**
 * PathComputationService
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T12:42:21.668+02:00")
public class PathComputationService   {
  @SerializedName("topology-constraint")
  private TopologyConstraint topologyConstraint = null;

  @SerializedName("optimization-constraint")
  private PathOptimizationConstraint optimizationConstraint = null;

  @SerializedName("objective-function")
  private PathObjectiveFunction objectiveFunction = null;

  @SerializedName("end-point")
  private List<PathServiceEndPoint> endPoint = new ArrayList<PathServiceEndPoint>();

  @SerializedName("routing-constraint")
  private RoutingConstraint routingConstraint = null;

  @SerializedName("path")
  private List<PathRef> path = new ArrayList<PathRef>();

  public PathComputationService topologyConstraint(TopologyConstraint topologyConstraint) {
    this.topologyConstraint = topologyConstraint;
    return this;
  }

   /**
   * Get topologyConstraint
   * @return topologyConstraint
  **/
  @ApiModelProperty(example = "null", value = "")
  public TopologyConstraint getTopologyConstraint() {
    return topologyConstraint;
  }

  public void setTopologyConstraint(TopologyConstraint topologyConstraint) {
    this.topologyConstraint = topologyConstraint;
  }

  public PathComputationService optimizationConstraint(PathOptimizationConstraint optimizationConstraint) {
    this.optimizationConstraint = optimizationConstraint;
    return this;
  }

   /**
   * Get optimizationConstraint
   * @return optimizationConstraint
  **/
  @ApiModelProperty(example = "null", value = "")
  public PathOptimizationConstraint getOptimizationConstraint() {
    return optimizationConstraint;
  }

  public void setOptimizationConstraint(PathOptimizationConstraint optimizationConstraint) {
    this.optimizationConstraint = optimizationConstraint;
  }

  public PathComputationService objectiveFunction(PathObjectiveFunction objectiveFunction) {
    this.objectiveFunction = objectiveFunction;
    return this;
  }

   /**
   * Get objectiveFunction
   * @return objectiveFunction
  **/
  @ApiModelProperty(example = "null", value = "")
  public PathObjectiveFunction getObjectiveFunction() {
    return objectiveFunction;
  }

  public void setObjectiveFunction(PathObjectiveFunction objectiveFunction) {
    this.objectiveFunction = objectiveFunction;
  }

  public PathComputationService endPoint(List<PathServiceEndPoint> endPoint) {
    this.endPoint = endPoint;
    return this;
  }

  public PathComputationService addEndPointItem(PathServiceEndPoint endPointItem) {
    this.endPoint.add(endPointItem);
    return this;
  }

   /**
   * Get endPoint
   * @return endPoint
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<PathServiceEndPoint> getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(List<PathServiceEndPoint> endPoint) {
    this.endPoint = endPoint;
  }

  public PathComputationService routingConstraint(RoutingConstraint routingConstraint) {
    this.routingConstraint = routingConstraint;
    return this;
  }

   /**
   * Get routingConstraint
   * @return routingConstraint
  **/
  @ApiModelProperty(example = "null", value = "")
  public RoutingConstraint getRoutingConstraint() {
    return routingConstraint;
  }

  public void setRoutingConstraint(RoutingConstraint routingConstraint) {
    this.routingConstraint = routingConstraint;
  }

  public PathComputationService path(List<PathRef> path) {
    this.path = path;
    return this;
  }

  public PathComputationService addPathItem(PathRef pathItem) {
    this.path.add(pathItem);
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<PathRef> getPath() {
    return path;
  }

  public void setPath(List<PathRef> path) {
    this.path = path;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PathComputationService pathComputationService = (PathComputationService) o;
    return Objects.equals(this.topologyConstraint, pathComputationService.topologyConstraint) &&
        Objects.equals(this.optimizationConstraint, pathComputationService.optimizationConstraint) &&
        Objects.equals(this.objectiveFunction, pathComputationService.objectiveFunction) &&
        Objects.equals(this.endPoint, pathComputationService.endPoint) &&
        Objects.equals(this.routingConstraint, pathComputationService.routingConstraint) &&
        Objects.equals(this.path, pathComputationService.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyConstraint, optimizationConstraint, objectiveFunction, endPoint, routingConstraint, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PathComputationService {\n");
    
    sb.append("    topologyConstraint: ").append(toIndentedString(topologyConstraint)).append("\n");
    sb.append("    optimizationConstraint: ").append(toIndentedString(optimizationConstraint)).append("\n");
    sb.append("    objectiveFunction: ").append(toIndentedString(objectiveFunction)).append("\n");
    sb.append("    endPoint: ").append(toIndentedString(endPoint)).append("\n");
    sb.append("    routingConstraint: ").append(toIndentedString(routingConstraint)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

