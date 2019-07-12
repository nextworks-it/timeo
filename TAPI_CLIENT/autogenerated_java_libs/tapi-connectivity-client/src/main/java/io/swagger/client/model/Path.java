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
import io.swagger.client.model.LinkRef;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.ResourceSpec;
import io.swagger.client.model.RoutingConstraint;
import java.util.ArrayList;
import java.util.List;


/**
 * Path is described by an ordered list of TE Links. A TE Link is defined by a pair of Node/NodeEdgePoint IDs. A Connection is realized by concatenating link resources (associated with a Link) and the lower-level connections (cross-connections) in the different nodes
 */
@ApiModel(description = "Path is described by an ordered list of TE Links. A TE Link is defined by a pair of Node/NodeEdgePoint IDs. A Connection is realized by concatenating link resources (associated with a Link) and the lower-level connections (cross-connections) in the different nodes")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-07T14:24:55.849+02:00")
public class Path   {
  @SerializedName("routing-constraint")
  private RoutingConstraint routingConstraint = null;

  /**
   * Gets or Sets direction
   */
  public enum DirectionEnum {
    @SerializedName("BIDIRECTIONAL")
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    @SerializedName("UNIDIRECTIONAL")
    UNIDIRECTIONAL("UNIDIRECTIONAL"),
    
    @SerializedName("UNDEFINED_OR_UNKNOWN")
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

    private String value;

    DirectionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("direction")
  private DirectionEnum direction = null;

  /**
   * Gets or Sets layerProtocolName
   */
  public enum LayerProtocolNameEnum {
    @SerializedName("ODU")
    ODU("ODU"),
    
    @SerializedName("ETH")
    ETH("ETH"),
    
    @SerializedName("DSR")
    DSR("DSR"),
    
    @SerializedName("PHOTONIC_MEDIA")
    PHOTONIC_MEDIA("PHOTONIC_MEDIA");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("layer-protocol-name")
  private LayerProtocolNameEnum layerProtocolName = null;

  @SerializedName("link")
  private List<LinkRef> link = new ArrayList<LinkRef>();

  public Path routingConstraint(RoutingConstraint routingConstraint) {
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

  public Path direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * Get direction
   * @return direction
  **/
  @ApiModelProperty(example = "null", value = "")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public Path layerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(example = "null", value = "")
  public LayerProtocolNameEnum getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public Path link(List<LinkRef> link) {
    this.link = link;
    return this;
  }

  public Path addLinkItem(LinkRef linkItem) {
    this.link.add(linkItem);
    return this;
  }

   /**
   * Get link
   * @return link
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<LinkRef> getLink() {
    return link;
  }

  public void setLink(List<LinkRef> link) {
    this.link = link;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Path path = (Path) o;
    return Objects.equals(this.routingConstraint, path.routingConstraint) &&
        Objects.equals(this.direction, path.direction) &&
        Objects.equals(this.layerProtocolName, path.layerProtocolName) &&
        Objects.equals(this.link, path.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routingConstraint, direction, layerProtocolName, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Path {\n");
    
    sb.append("    routingConstraint: ").append(toIndentedString(routingConstraint)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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
