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
import io.swagger.client.model.ConnectionEndPoint;
import io.swagger.client.model.ConnectivityServiceEndPointRef;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.OwnedNodeEdgePointRef;
import io.swagger.client.model.SdmTerminationPac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConnectionEndPointSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class ConnectionEndPointSchema {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

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
   * The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
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

  @SerializedName("client-node-edge-point")
  private List<OwnedNodeEdgePointRef> clientNodeEdgePoint = null;

  /**
   * Gets or Sets layerProtocolName
   */
  @JsonAdapter(LayerProtocolNameEnum.Adapter.class)
  public enum LayerProtocolNameEnum {
    OTSIA("OTSiA"),
    
    OCH("OCH"),
    
    OTU("OTU"),
    
    ODU("ODU"),
    
    ETH("ETH"),
    
    ETY("ETY"),
    
    SDM("SDM"),
    
    DSR("DSR");

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

  @SerializedName("connectivity-service-end-point")
  private ConnectivityServiceEndPointRef connectivityServiceEndPoint = null;

  /**
   * The orientation of defined flow at the EndPoint.
   */
  @JsonAdapter(ConnectionPortDirectionEnum.Adapter.class)
  public enum ConnectionPortDirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    INPUT("INPUT"),
    
    OUTPUT("OUTPUT"),
    
    UNIDENTIFIED_OR_UNKNOWN("UNIDENTIFIED_OR_UNKNOWN");

    private String value;

    ConnectionPortDirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ConnectionPortDirectionEnum fromValue(String text) {
      for (ConnectionPortDirectionEnum b : ConnectionPortDirectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ConnectionPortDirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ConnectionPortDirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ConnectionPortDirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ConnectionPortDirectionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("connection-port-direction")
  private ConnectionPortDirectionEnum connectionPortDirection = null;

  @SerializedName("parent-node-edge-point")
  private List<OwnedNodeEdgePointRef> parentNodeEdgePoint = null;

  /**
   * Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function. 
   */
  @JsonAdapter(ConnectionPortRoleEnum.Adapter.class)
  public enum ConnectionPortRoleEnum {
    SYMMETRIC("SYMMETRIC"),
    
    ROOT("ROOT"),
    
    LEAF("LEAF"),
    
    TRUNK("TRUNK"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    ConnectionPortRoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ConnectionPortRoleEnum fromValue(String text) {
      for (ConnectionPortRoleEnum b : ConnectionPortRoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ConnectionPortRoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ConnectionPortRoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ConnectionPortRoleEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ConnectionPortRoleEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("connection-port-role")
  private ConnectionPortRoleEnum connectionPortRole = null;

  @SerializedName("connection-end-point_uuid")
  private String connectionEndPointUuid = null;

  @SerializedName("sdm-termination")
  private SdmTerminationPac sdmTermination = null;

  public ConnectionEndPointSchema uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6
   * @return uuid
  **/
  @ApiModelProperty(value = "UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-' + '[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ConnectionEndPointSchema name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public ConnectionEndPointSchema addNameItem(NameAndValue nameItem) {
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

  public ConnectionEndPointSchema lifecycleState(LifecycleStateEnum lifecycleState) {
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

  public ConnectionEndPointSchema operationalState(OperationalStateEnum operationalState) {
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

  public ConnectionEndPointSchema terminationState(TerminationStateEnum terminationState) {
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

  public ConnectionEndPointSchema terminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
    return this;
  }

   /**
   * The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
   * @return terminationDirection
  **/
  @ApiModelProperty(value = "The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows")
  public TerminationDirectionEnum getTerminationDirection() {
    return terminationDirection;
  }

  public void setTerminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
  }

  public ConnectionEndPointSchema clientNodeEdgePoint(List<OwnedNodeEdgePointRef> clientNodeEdgePoint) {
    this.clientNodeEdgePoint = clientNodeEdgePoint;
    return this;
  }

  public ConnectionEndPointSchema addClientNodeEdgePointItem(OwnedNodeEdgePointRef clientNodeEdgePointItem) {
    if (this.clientNodeEdgePoint == null) {
      this.clientNodeEdgePoint = new ArrayList<OwnedNodeEdgePointRef>();
    }
    this.clientNodeEdgePoint.add(clientNodeEdgePointItem);
    return this;
  }

   /**
   * Get clientNodeEdgePoint
   * @return clientNodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<OwnedNodeEdgePointRef> getClientNodeEdgePoint() {
    return clientNodeEdgePoint;
  }

  public void setClientNodeEdgePoint(List<OwnedNodeEdgePointRef> clientNodeEdgePoint) {
    this.clientNodeEdgePoint = clientNodeEdgePoint;
  }

  public ConnectionEndPointSchema layerProtocolName(LayerProtocolNameEnum layerProtocolName) {
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

  public ConnectionEndPointSchema connectivityServiceEndPoint(ConnectivityServiceEndPointRef connectivityServiceEndPoint) {
    this.connectivityServiceEndPoint = connectivityServiceEndPoint;
    return this;
  }

   /**
   * Get connectivityServiceEndPoint
   * @return connectivityServiceEndPoint
  **/
  @ApiModelProperty(value = "")
  public ConnectivityServiceEndPointRef getConnectivityServiceEndPoint() {
    return connectivityServiceEndPoint;
  }

  public void setConnectivityServiceEndPoint(ConnectivityServiceEndPointRef connectivityServiceEndPoint) {
    this.connectivityServiceEndPoint = connectivityServiceEndPoint;
  }

  public ConnectionEndPointSchema connectionPortDirection(ConnectionPortDirectionEnum connectionPortDirection) {
    this.connectionPortDirection = connectionPortDirection;
    return this;
  }

   /**
   * The orientation of defined flow at the EndPoint.
   * @return connectionPortDirection
  **/
  @ApiModelProperty(value = "The orientation of defined flow at the EndPoint.")
  public ConnectionPortDirectionEnum getConnectionPortDirection() {
    return connectionPortDirection;
  }

  public void setConnectionPortDirection(ConnectionPortDirectionEnum connectionPortDirection) {
    this.connectionPortDirection = connectionPortDirection;
  }

  public ConnectionEndPointSchema parentNodeEdgePoint(List<OwnedNodeEdgePointRef> parentNodeEdgePoint) {
    this.parentNodeEdgePoint = parentNodeEdgePoint;
    return this;
  }

  public ConnectionEndPointSchema addParentNodeEdgePointItem(OwnedNodeEdgePointRef parentNodeEdgePointItem) {
    if (this.parentNodeEdgePoint == null) {
      this.parentNodeEdgePoint = new ArrayList<OwnedNodeEdgePointRef>();
    }
    this.parentNodeEdgePoint.add(parentNodeEdgePointItem);
    return this;
  }

   /**
   * Get parentNodeEdgePoint
   * @return parentNodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<OwnedNodeEdgePointRef> getParentNodeEdgePoint() {
    return parentNodeEdgePoint;
  }

  public void setParentNodeEdgePoint(List<OwnedNodeEdgePointRef> parentNodeEdgePoint) {
    this.parentNodeEdgePoint = parentNodeEdgePoint;
  }

  public ConnectionEndPointSchema connectionPortRole(ConnectionPortRoleEnum connectionPortRole) {
    this.connectionPortRole = connectionPortRole;
    return this;
  }

   /**
   * Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function. 
   * @return connectionPortRole
  **/
  @ApiModelProperty(value = "Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function. ")
  public ConnectionPortRoleEnum getConnectionPortRole() {
    return connectionPortRole;
  }

  public void setConnectionPortRole(ConnectionPortRoleEnum connectionPortRole) {
    this.connectionPortRole = connectionPortRole;
  }

  public ConnectionEndPointSchema connectionEndPointUuid(String connectionEndPointUuid) {
    this.connectionEndPointUuid = connectionEndPointUuid;
    return this;
  }

   /**
   * UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6
   * @return connectionEndPointUuid
  **/
  @ApiModelProperty(value = "UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-' + '[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
  public String getConnectionEndPointUuid() {
    return connectionEndPointUuid;
  }

  public void setConnectionEndPointUuid(String connectionEndPointUuid) {
    this.connectionEndPointUuid = connectionEndPointUuid;
  }

  public ConnectionEndPointSchema sdmTermination(SdmTerminationPac sdmTermination) {
    this.sdmTermination = sdmTermination;
    return this;
  }

   /**
   * Get sdmTermination
   * @return sdmTermination
  **/
  @ApiModelProperty(value = "")
  public SdmTerminationPac getSdmTermination() {
    return sdmTermination;
  }

  public void setSdmTermination(SdmTerminationPac sdmTermination) {
    this.sdmTermination = sdmTermination;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionEndPointSchema connectionEndPointSchema = (ConnectionEndPointSchema) o;
    return Objects.equals(this.uuid, connectionEndPointSchema.uuid) &&
        Objects.equals(this.name, connectionEndPointSchema.name) &&
        Objects.equals(this.lifecycleState, connectionEndPointSchema.lifecycleState) &&
        Objects.equals(this.operationalState, connectionEndPointSchema.operationalState) &&
        Objects.equals(this.terminationState, connectionEndPointSchema.terminationState) &&
        Objects.equals(this.terminationDirection, connectionEndPointSchema.terminationDirection) &&
        Objects.equals(this.clientNodeEdgePoint, connectionEndPointSchema.clientNodeEdgePoint) &&
        Objects.equals(this.layerProtocolName, connectionEndPointSchema.layerProtocolName) &&
        Objects.equals(this.connectivityServiceEndPoint, connectionEndPointSchema.connectivityServiceEndPoint) &&
        Objects.equals(this.connectionPortDirection, connectionEndPointSchema.connectionPortDirection) &&
        Objects.equals(this.parentNodeEdgePoint, connectionEndPointSchema.parentNodeEdgePoint) &&
        Objects.equals(this.connectionPortRole, connectionEndPointSchema.connectionPortRole) &&
        Objects.equals(this.connectionEndPointUuid, connectionEndPointSchema.connectionEndPointUuid) &&
        Objects.equals(this.sdmTermination, connectionEndPointSchema.sdmTermination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, lifecycleState, operationalState, terminationState, terminationDirection, clientNodeEdgePoint, layerProtocolName, connectivityServiceEndPoint, connectionPortDirection, parentNodeEdgePoint, connectionPortRole, connectionEndPointUuid, sdmTermination);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionEndPointSchema {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    terminationState: ").append(toIndentedString(terminationState)).append("\n");
    sb.append("    terminationDirection: ").append(toIndentedString(terminationDirection)).append("\n");
    sb.append("    clientNodeEdgePoint: ").append(toIndentedString(clientNodeEdgePoint)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    connectivityServiceEndPoint: ").append(toIndentedString(connectivityServiceEndPoint)).append("\n");
    sb.append("    connectionPortDirection: ").append(toIndentedString(connectionPortDirection)).append("\n");
    sb.append("    parentNodeEdgePoint: ").append(toIndentedString(parentNodeEdgePoint)).append("\n");
    sb.append("    connectionPortRole: ").append(toIndentedString(connectionPortRole)).append("\n");
    sb.append("    connectionEndPointUuid: ").append(toIndentedString(connectionEndPointUuid)).append("\n");
    sb.append("    sdmTermination: ").append(toIndentedString(sdmTermination)).append("\n");
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

