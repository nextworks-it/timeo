/**
 * tapi-topology API
 * tapi-topology API generated from tapi-topology@2018-12-10.yang
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
import io.swagger.client.model.NodeRef;


/**
 * NodeRuleGroupRef
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-08T14:35:49.260+02:00")
public class NodeRuleGroupRef   {
  @SerializedName("node-rule-group-uuid")
  private String nodeRuleGroupUuid = null;

  public NodeRuleGroupRef nodeRuleGroupUuid(String nodeRuleGroupUuid) {
    this.nodeRuleGroupUuid = nodeRuleGroupUuid;
    return this;
  }

   /**
   * Get nodeRuleGroupUuid
   * @return nodeRuleGroupUuid
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getNodeRuleGroupUuid() {
    return nodeRuleGroupUuid;
  }

  public void setNodeRuleGroupUuid(String nodeRuleGroupUuid) {
    this.nodeRuleGroupUuid = nodeRuleGroupUuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeRuleGroupRef nodeRuleGroupRef = (NodeRuleGroupRef) o;
    return Objects.equals(this.nodeRuleGroupUuid, nodeRuleGroupRef.nodeRuleGroupUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeRuleGroupUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeRuleGroupRef {\n");
    
    sb.append("    nodeRuleGroupUuid: ").append(toIndentedString(nodeRuleGroupUuid)).append("\n");
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

