/*
 * tapi-photonic-media API
 * tapi-photonic-media API generated from tapi-photonic-media@2018-12-10.yang
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
import io.swagger.client.model.Capacity;
import io.swagger.client.model.MediaChannelNodeEdgePointSpec;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NodeEdgePoint;
import io.swagger.client.model.NodeEdgePointRef;
import io.swagger.client.model.ServiceInterfacePointRef;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * NodeEdgePointSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class NodeEdgePointSchema {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  /**
   * Gets or Sets administrativeState
   */
  @JsonAdapter(AdministrativeStateEnum.Adapter.class)
  public enum AdministrativeStateEnum {
    LOCKED("LOCKED"),
    
    UNLOCKED("UNLOCKED");

    private String value;

    AdministrativeStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AdministrativeStateEnum fromValue(String text) {
      for (AdministrativeStateEnum b : AdministrativeStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<AdministrativeStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AdministrativeStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AdministrativeStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return AdministrativeStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("administrative-state")
  private AdministrativeStateEnum administrativeState = null;

  /**
   * Gets or Sets lifecycleState
   */
  @JsonAdapter(LifecycleStateEnum.Adapter.class)
  public enum LifecycleStateEnum {
    PLANNED("PLANNED"),
    
    POTENTIAL_AVAILABLE("POTENTIAL_AVAILABLE"),
    
    POTENTIAL_BUSY("POTENTIAL_BUSY"),
    
    INSTALLED("INSTALLED"),
    
    PENDING_REMOVAL("PENDING_REMOVAL");

    private String value;

    LifecycleStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LifecycleStateEnum fromValue(String text) {
      for (LifecycleStateEnum b : LifecycleStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LifecycleStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LifecycleStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LifecycleStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LifecycleStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("lifecycle-state")
  private LifecycleStateEnum lifecycleState = null;

  /**
   * Gets or Sets operationalState
   */
  @JsonAdapter(OperationalStateEnum.Adapter.class)
  public enum OperationalStateEnum {
    DISABLED("DISABLED"),
    
    ENABLED("ENABLED");

    private String value;

    OperationalStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OperationalStateEnum fromValue(String text) {
      for (OperationalStateEnum b : OperationalStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OperationalStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OperationalStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OperationalStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OperationalStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("operational-state")
  private OperationalStateEnum operationalState = null;

  /**
   * Indicates whether the layer is terminated and if so how.
   */
  @JsonAdapter(TerminationStateEnum.Adapter.class)
  public enum TerminationStateEnum {
    LP_CAN_NEVER_TERMINATE("LP_CAN_NEVER_TERMINATE"),
    
    LT_NOT_TERMINATED("LT_NOT_TERMINATED"),
    
    TERMINATED_SERVER_TO_CLIENT_FLOW("TERMINATED_SERVER_TO_CLIENT_FLOW"),
    
    TERMINATED_CLIENT_TO_SERVER_FLOW("TERMINATED_CLIENT_TO_SERVER_FLOW"),
    
    TERMINATED_BIDIRECTIONAL("TERMINATED_BIDIRECTIONAL"),
    
    LT_PERMENANTLY_TERMINATED("LT_PERMENANTLY_TERMINATED"),
    
    TERMINATION_STATE_UNKNOWN("TERMINATION_STATE_UNKNOWN");

    private String value;

    TerminationStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TerminationStateEnum fromValue(String text) {
      for (TerminationStateEnum b : TerminationStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TerminationStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TerminationStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TerminationStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TerminationStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("termination-state")
  private TerminationStateEnum terminationState = null;

  /**
   * The overall directionality of the LP. - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
   */
  @JsonAdapter(TerminationDirectionEnum.Adapter.class)
  public enum TerminationDirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    SINK("SINK"),
    
    SOURCE("SOURCE"),
    
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

    private String value;

    TerminationDirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TerminationDirectionEnum fromValue(String text) {
      for (TerminationDirectionEnum b : TerminationDirectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TerminationDirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TerminationDirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TerminationDirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TerminationDirectionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("termination-direction")
  private TerminationDirectionEnum terminationDirection = null;

  @SerializedName("available-capacity")
  private Capacity availableCapacity = null;

  @SerializedName("total-potential-capacity")
  private Capacity totalPotentialCapacity = null;

  /**
   * Gets or Sets layerProtocolName
   */
  @JsonAdapter(LayerProtocolNameEnum.Adapter.class)
  public enum LayerProtocolNameEnum {
    ODU("ODU"),
    
    ETH("ETH"),
    
    DSR("DSR"),
    
    PHOTONIC_MEDIA("PHOTONIC_MEDIA");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LayerProtocolNameEnum fromValue(String text) {
      for (LayerProtocolNameEnum b : LayerProtocolNameEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LayerProtocolNameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LayerProtocolNameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LayerProtocolNameEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LayerProtocolNameEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("layer-protocol-name")
  private LayerProtocolNameEnum layerProtocolName = null;

  @SerializedName("mapped-service-interface-point")
  private List<ServiceInterfacePointRef> mappedServiceInterfacePoint = null;

  @SerializedName("supported-cep-layer-protocol-qualifier")
  private List<String> supportedCepLayerProtocolQualifier = null;

  /**
   * The orientation of defined flow at the LinkEnd.
   */
  @JsonAdapter(LinkPortDirectionEnum.Adapter.class)
  public enum LinkPortDirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    INPUT("INPUT"),
    
    OUTPUT("OUTPUT"),
    
    UNIDENTIFIED_OR_UNKNOWN("UNIDENTIFIED_OR_UNKNOWN");

    private String value;

    LinkPortDirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LinkPortDirectionEnum fromValue(String text) {
      for (LinkPortDirectionEnum b : LinkPortDirectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LinkPortDirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LinkPortDirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LinkPortDirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LinkPortDirectionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("link-port-direction")
  private LinkPortDirectionEnum linkPortDirection = null;

  @SerializedName("aggregated-node-edge-point")
  private List<NodeEdgePointRef> aggregatedNodeEdgePoint = null;

  /**
   * Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. 
   */
  @JsonAdapter(LinkPortRoleEnum.Adapter.class)
  public enum LinkPortRoleEnum {
    SYMMETRIC("SYMMETRIC"),
    
    ROOT("ROOT"),
    
    LEAF("LEAF"),
    
    TRUNK("TRUNK"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    LinkPortRoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LinkPortRoleEnum fromValue(String text) {
      for (LinkPortRoleEnum b : LinkPortRoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LinkPortRoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LinkPortRoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LinkPortRoleEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LinkPortRoleEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("link-port-role")
  private LinkPortRoleEnum linkPortRole = null;

  @SerializedName("media-channel-node-edge-point-spec")
  private MediaChannelNodeEdgePointSpec mediaChannelNodeEdgePointSpec = null;

  public NodeEdgePointSchema uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12} Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6
   * @return uuid
  **/
  @ApiModelProperty(value = "UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-' + '[0-9a-fA-F]{4}-[0-9a-fA-F]{12} Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public NodeEdgePointSchema name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public NodeEdgePointSchema addNameItem(NameAndValue nameItem) {
    if (this.name == null) {
      this.name = new ArrayList<NameAndValue>();
    }
    this.name.add(nameItem);
    return this;
  }

   /**
   * List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity.
   * @return name
  **/
  @ApiModelProperty(value = "List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity.")
  public List<NameAndValue> getName() {
    return name;
  }

  public void setName(List<NameAndValue> name) {
    this.name = name;
  }

  public NodeEdgePointSchema administrativeState(AdministrativeStateEnum administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

   /**
   * Get administrativeState
   * @return administrativeState
  **/
  @ApiModelProperty(value = "")
  public AdministrativeStateEnum getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(AdministrativeStateEnum administrativeState) {
    this.administrativeState = administrativeState;
  }

  public NodeEdgePointSchema lifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
    return this;
  }

   /**
   * Get lifecycleState
   * @return lifecycleState
  **/
  @ApiModelProperty(value = "")
  public LifecycleStateEnum getLifecycleState() {
    return lifecycleState;
  }

  public void setLifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
  }

  public NodeEdgePointSchema operationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
    return this;
  }

   /**
   * Get operationalState
   * @return operationalState
  **/
  @ApiModelProperty(value = "")
  public OperationalStateEnum getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
  }

  public NodeEdgePointSchema terminationState(TerminationStateEnum terminationState) {
    this.terminationState = terminationState;
    return this;
  }

   /**
   * Indicates whether the layer is terminated and if so how.
   * @return terminationState
  **/
  @ApiModelProperty(value = "Indicates whether the layer is terminated and if so how.")
  public TerminationStateEnum getTerminationState() {
    return terminationState;
  }

  public void setTerminationState(TerminationStateEnum terminationState) {
    this.terminationState = terminationState;
  }

  public NodeEdgePointSchema terminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
    return this;
  }

   /**
   * The overall directionality of the LP. - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
   * @return terminationDirection
  **/
  @ApiModelProperty(value = "The overall directionality of the LP. - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows")
  public TerminationDirectionEnum getTerminationDirection() {
    return terminationDirection;
  }

  public void setTerminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
  }

  public NodeEdgePointSchema availableCapacity(Capacity availableCapacity) {
    this.availableCapacity = availableCapacity;
    return this;
  }

   /**
   * Capacity available to be assigned.
   * @return availableCapacity
  **/
  @ApiModelProperty(value = "Capacity available to be assigned.")
  public Capacity getAvailableCapacity() {
    return availableCapacity;
  }

  public void setAvailableCapacity(Capacity availableCapacity) {
    this.availableCapacity = availableCapacity;
  }

  public NodeEdgePointSchema totalPotentialCapacity(Capacity totalPotentialCapacity) {
    this.totalPotentialCapacity = totalPotentialCapacity;
    return this;
  }

   /**
   * An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken.
   * @return totalPotentialCapacity
  **/
  @ApiModelProperty(value = "An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken.")
  public Capacity getTotalPotentialCapacity() {
    return totalPotentialCapacity;
  }

  public void setTotalPotentialCapacity(Capacity totalPotentialCapacity) {
    this.totalPotentialCapacity = totalPotentialCapacity;
  }

  public NodeEdgePointSchema layerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(value = "")
  public LayerProtocolNameEnum getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public NodeEdgePointSchema mappedServiceInterfacePoint(List<ServiceInterfacePointRef> mappedServiceInterfacePoint) {
    this.mappedServiceInterfacePoint = mappedServiceInterfacePoint;
    return this;
  }

  public NodeEdgePointSchema addMappedServiceInterfacePointItem(ServiceInterfacePointRef mappedServiceInterfacePointItem) {
    if (this.mappedServiceInterfacePoint == null) {
      this.mappedServiceInterfacePoint = new ArrayList<ServiceInterfacePointRef>();
    }
    this.mappedServiceInterfacePoint.add(mappedServiceInterfacePointItem);
    return this;
  }

   /**
   * NodeEdgePoint mapped to more than ServiceInterfacePoint (slicing/virtualizing) or a ServiceInterfacePoint mapped to more than one NodeEdgePoint (load balancing/Resilience) should be considered experimental
   * @return mappedServiceInterfacePoint
  **/
  @ApiModelProperty(value = "NodeEdgePoint mapped to more than ServiceInterfacePoint (slicing/virtualizing) or a ServiceInterfacePoint mapped to more than one NodeEdgePoint (load balancing/Resilience) should be considered experimental")
  public List<ServiceInterfacePointRef> getMappedServiceInterfacePoint() {
    return mappedServiceInterfacePoint;
  }

  public void setMappedServiceInterfacePoint(List<ServiceInterfacePointRef> mappedServiceInterfacePoint) {
    this.mappedServiceInterfacePoint = mappedServiceInterfacePoint;
  }

  public NodeEdgePointSchema supportedCepLayerProtocolQualifier(List<String> supportedCepLayerProtocolQualifier) {
    this.supportedCepLayerProtocolQualifier = supportedCepLayerProtocolQualifier;
    return this;
  }

  public NodeEdgePointSchema addSupportedCepLayerProtocolQualifierItem(String supportedCepLayerProtocolQualifierItem) {
    if (this.supportedCepLayerProtocolQualifier == null) {
      this.supportedCepLayerProtocolQualifier = new ArrayList<String>();
    }
    this.supportedCepLayerProtocolQualifier.add(supportedCepLayerProtocolQualifierItem);
    return this;
  }

   /**
   * Get supportedCepLayerProtocolQualifier
   * @return supportedCepLayerProtocolQualifier
  **/
  @ApiModelProperty(value = "")
  public List<String> getSupportedCepLayerProtocolQualifier() {
    return supportedCepLayerProtocolQualifier;
  }

  public void setSupportedCepLayerProtocolQualifier(List<String> supportedCepLayerProtocolQualifier) {
    this.supportedCepLayerProtocolQualifier = supportedCepLayerProtocolQualifier;
  }

  public NodeEdgePointSchema linkPortDirection(LinkPortDirectionEnum linkPortDirection) {
    this.linkPortDirection = linkPortDirection;
    return this;
  }

   /**
   * The orientation of defined flow at the LinkEnd.
   * @return linkPortDirection
  **/
  @ApiModelProperty(value = "The orientation of defined flow at the LinkEnd.")
  public LinkPortDirectionEnum getLinkPortDirection() {
    return linkPortDirection;
  }

  public void setLinkPortDirection(LinkPortDirectionEnum linkPortDirection) {
    this.linkPortDirection = linkPortDirection;
  }

  public NodeEdgePointSchema aggregatedNodeEdgePoint(List<NodeEdgePointRef> aggregatedNodeEdgePoint) {
    this.aggregatedNodeEdgePoint = aggregatedNodeEdgePoint;
    return this;
  }

  public NodeEdgePointSchema addAggregatedNodeEdgePointItem(NodeEdgePointRef aggregatedNodeEdgePointItem) {
    if (this.aggregatedNodeEdgePoint == null) {
      this.aggregatedNodeEdgePoint = new ArrayList<NodeEdgePointRef>();
    }
    this.aggregatedNodeEdgePoint.add(aggregatedNodeEdgePointItem);
    return this;
  }

   /**
   * Get aggregatedNodeEdgePoint
   * @return aggregatedNodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<NodeEdgePointRef> getAggregatedNodeEdgePoint() {
    return aggregatedNodeEdgePoint;
  }

  public void setAggregatedNodeEdgePoint(List<NodeEdgePointRef> aggregatedNodeEdgePoint) {
    this.aggregatedNodeEdgePoint = aggregatedNodeEdgePoint;
  }

  public NodeEdgePointSchema linkPortRole(LinkPortRoleEnum linkPortRole) {
    this.linkPortRole = linkPortRole;
    return this;
  }

   /**
   * Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. 
   * @return linkPortRole
  **/
  @ApiModelProperty(value = "Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. ")
  public LinkPortRoleEnum getLinkPortRole() {
    return linkPortRole;
  }

  public void setLinkPortRole(LinkPortRoleEnum linkPortRole) {
    this.linkPortRole = linkPortRole;
  }

  public NodeEdgePointSchema mediaChannelNodeEdgePointSpec(MediaChannelNodeEdgePointSpec mediaChannelNodeEdgePointSpec) {
    this.mediaChannelNodeEdgePointSpec = mediaChannelNodeEdgePointSpec;
    return this;
  }

   /**
   * Get mediaChannelNodeEdgePointSpec
   * @return mediaChannelNodeEdgePointSpec
  **/
  @ApiModelProperty(value = "")
  public MediaChannelNodeEdgePointSpec getMediaChannelNodeEdgePointSpec() {
    return mediaChannelNodeEdgePointSpec;
  }

  public void setMediaChannelNodeEdgePointSpec(MediaChannelNodeEdgePointSpec mediaChannelNodeEdgePointSpec) {
    this.mediaChannelNodeEdgePointSpec = mediaChannelNodeEdgePointSpec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeEdgePointSchema nodeEdgePointSchema = (NodeEdgePointSchema) o;
    return Objects.equals(this.uuid, nodeEdgePointSchema.uuid) &&
        Objects.equals(this.name, nodeEdgePointSchema.name) &&
        Objects.equals(this.administrativeState, nodeEdgePointSchema.administrativeState) &&
        Objects.equals(this.lifecycleState, nodeEdgePointSchema.lifecycleState) &&
        Objects.equals(this.operationalState, nodeEdgePointSchema.operationalState) &&
        Objects.equals(this.terminationState, nodeEdgePointSchema.terminationState) &&
        Objects.equals(this.terminationDirection, nodeEdgePointSchema.terminationDirection) &&
        Objects.equals(this.availableCapacity, nodeEdgePointSchema.availableCapacity) &&
        Objects.equals(this.totalPotentialCapacity, nodeEdgePointSchema.totalPotentialCapacity) &&
        Objects.equals(this.layerProtocolName, nodeEdgePointSchema.layerProtocolName) &&
        Objects.equals(this.mappedServiceInterfacePoint, nodeEdgePointSchema.mappedServiceInterfacePoint) &&
        Objects.equals(this.supportedCepLayerProtocolQualifier, nodeEdgePointSchema.supportedCepLayerProtocolQualifier) &&
        Objects.equals(this.linkPortDirection, nodeEdgePointSchema.linkPortDirection) &&
        Objects.equals(this.aggregatedNodeEdgePoint, nodeEdgePointSchema.aggregatedNodeEdgePoint) &&
        Objects.equals(this.linkPortRole, nodeEdgePointSchema.linkPortRole) &&
        Objects.equals(this.mediaChannelNodeEdgePointSpec, nodeEdgePointSchema.mediaChannelNodeEdgePointSpec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, administrativeState, lifecycleState, operationalState, terminationState, terminationDirection, availableCapacity, totalPotentialCapacity, layerProtocolName, mappedServiceInterfacePoint, supportedCepLayerProtocolQualifier, linkPortDirection, aggregatedNodeEdgePoint, linkPortRole, mediaChannelNodeEdgePointSpec);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeEdgePointSchema {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    terminationState: ").append(toIndentedString(terminationState)).append("\n");
    sb.append("    terminationDirection: ").append(toIndentedString(terminationDirection)).append("\n");
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
    sb.append("    totalPotentialCapacity: ").append(toIndentedString(totalPotentialCapacity)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    mappedServiceInterfacePoint: ").append(toIndentedString(mappedServiceInterfacePoint)).append("\n");
    sb.append("    supportedCepLayerProtocolQualifier: ").append(toIndentedString(supportedCepLayerProtocolQualifier)).append("\n");
    sb.append("    linkPortDirection: ").append(toIndentedString(linkPortDirection)).append("\n");
    sb.append("    aggregatedNodeEdgePoint: ").append(toIndentedString(aggregatedNodeEdgePoint)).append("\n");
    sb.append("    linkPortRole: ").append(toIndentedString(linkPortRole)).append("\n");
    sb.append("    mediaChannelNodeEdgePointSpec: ").append(toIndentedString(mediaChannelNodeEdgePointSpec)).append("\n");
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
