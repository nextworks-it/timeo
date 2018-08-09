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
import io.swagger.client.model.AdminStatePac;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityPac;
import io.swagger.client.model.CostCharacteristic;
import io.swagger.client.model.LatencyCharacteristic;
import io.swagger.client.model.LayerProtocolTransitionPac;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.OwnedNodeEdgePointRef;
import io.swagger.client.model.ResilienceType;
import io.swagger.client.model.ResourceSpec;
import io.swagger.client.model.RiskCharacteristic;
import io.swagger.client.model.RiskParameterPac;
import io.swagger.client.model.TransferCostPac;
import io.swagger.client.model.TransferIntegrityPac;
import io.swagger.client.model.TransferTimingPac;
import io.swagger.client.model.ValidationMechanism;
import io.swagger.client.model.ValidationPac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Link object class models effective adjacency between two or more ForwardingDomains (FD). 
 */
@ApiModel(description = "The Link object class models effective adjacency between two or more ForwardingDomains (FD). ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:54:55.433+02:00")
public class Link {
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

  @SerializedName("available-capacity")
  private Capacity availableCapacity = null;

  @SerializedName("total-potential-capacity")
  private Capacity totalPotentialCapacity = null;

  @SerializedName("cost-characteristic")
  private List<CostCharacteristic> costCharacteristic = null;

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

  @SerializedName("latency-characteristic")
  private List<LatencyCharacteristic> latencyCharacteristic = null;

  @SerializedName("risk-characteristic")
  private List<RiskCharacteristic> riskCharacteristic = null;

  @SerializedName("validation-mechanism")
  private List<ValidationMechanism> validationMechanism = null;

  @SerializedName("transitioned-layer-protocol-name")
  private List<String> transitionedLayerProtocolName = null;

  @SerializedName("node-edge-point")
  private List<OwnedNodeEdgePointRef> nodeEdgePoint = null;

  @SerializedName("direction")
  private String direction = null;

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
  private List<LayerProtocolNameEnum> layerProtocolName = null;

  @SerializedName("resilience-type")
  private ResilienceType resilienceType = null;

  public Link uuid(String uuid) {
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

  public Link name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public Link addNameItem(NameAndValue nameItem) {
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

  public Link administrativeState(AdministrativeStateEnum administrativeState) {
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

  public Link lifecycleState(LifecycleStateEnum lifecycleState) {
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

  public Link operationalState(OperationalStateEnum operationalState) {
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

  public Link availableCapacity(Capacity availableCapacity) {
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

  public Link totalPotentialCapacity(Capacity totalPotentialCapacity) {
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

  public Link costCharacteristic(List<CostCharacteristic> costCharacteristic) {
    this.costCharacteristic = costCharacteristic;
    return this;
  }

  public Link addCostCharacteristicItem(CostCharacteristic costCharacteristicItem) {
    if (this.costCharacteristic == null) {
      this.costCharacteristic = new ArrayList<CostCharacteristic>();
    }
    this.costCharacteristic.add(costCharacteristicItem);
    return this;
  }

   /**
   * The list of costs where each cost relates to some aspect of the TopologicalEntity.
   * @return costCharacteristic
  **/
  @ApiModelProperty(value = "The list of costs where each cost relates to some aspect of the TopologicalEntity.")
  public List<CostCharacteristic> getCostCharacteristic() {
    return costCharacteristic;
  }

  public void setCostCharacteristic(List<CostCharacteristic> costCharacteristic) {
    this.costCharacteristic = costCharacteristic;
  }

  public Link errorCharacteristic(String errorCharacteristic) {
    this.errorCharacteristic = errorCharacteristic;
    return this;
  }

   /**
   * Describes the degree to which the signal propagated can be errored. Applies to TDM systems as the errored signal will be propagated and not packet as errored packets will be discarded.
   * @return errorCharacteristic
  **/
  @ApiModelProperty(value = "Describes the degree to which the signal propagated can be errored. Applies to TDM systems as the errored signal will be propagated and not packet as errored packets will be discarded.")
  public String getErrorCharacteristic() {
    return errorCharacteristic;
  }

  public void setErrorCharacteristic(String errorCharacteristic) {
    this.errorCharacteristic = errorCharacteristic;
  }

  public Link unavailableTimeCharacteristic(String unavailableTimeCharacteristic) {
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

  public Link lossCharacteristic(String lossCharacteristic) {
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

  public Link deliveryOrderCharacteristic(String deliveryOrderCharacteristic) {
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

  public Link serverIntegrityProcessCharacteristic(String serverIntegrityProcessCharacteristic) {
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

  public Link repeatDeliveryCharacteristic(String repeatDeliveryCharacteristic) {
    this.repeatDeliveryCharacteristic = repeatDeliveryCharacteristic;
    return this;
  }

   /**
   * Primarily applies to packet systems where a packet may be delivered more than once (in fault recovery for example). It can also apply to TDM where several frames may be received twice due to switching in a system with a large differential propagation delay.
   * @return repeatDeliveryCharacteristic
  **/
  @ApiModelProperty(value = "Primarily applies to packet systems where a packet may be delivered more than once (in fault recovery for example). It can also apply to TDM where several frames may be received twice due to switching in a system with a large differential propagation delay.")
  public String getRepeatDeliveryCharacteristic() {
    return repeatDeliveryCharacteristic;
  }

  public void setRepeatDeliveryCharacteristic(String repeatDeliveryCharacteristic) {
    this.repeatDeliveryCharacteristic = repeatDeliveryCharacteristic;
  }

  public Link latencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
    this.latencyCharacteristic = latencyCharacteristic;
    return this;
  }

  public Link addLatencyCharacteristicItem(LatencyCharacteristic latencyCharacteristicItem) {
    if (this.latencyCharacteristic == null) {
      this.latencyCharacteristic = new ArrayList<LatencyCharacteristic>();
    }
    this.latencyCharacteristic.add(latencyCharacteristicItem);
    return this;
  }

   /**
   * The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic.
   * @return latencyCharacteristic
  **/
  @ApiModelProperty(value = "The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic.")
  public List<LatencyCharacteristic> getLatencyCharacteristic() {
    return latencyCharacteristic;
  }

  public void setLatencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
    this.latencyCharacteristic = latencyCharacteristic;
  }

  public Link riskCharacteristic(List<RiskCharacteristic> riskCharacteristic) {
    this.riskCharacteristic = riskCharacteristic;
    return this;
  }

  public Link addRiskCharacteristicItem(RiskCharacteristic riskCharacteristicItem) {
    if (this.riskCharacteristic == null) {
      this.riskCharacteristic = new ArrayList<RiskCharacteristic>();
    }
    this.riskCharacteristic.add(riskCharacteristicItem);
    return this;
  }

   /**
   * A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration.
   * @return riskCharacteristic
  **/
  @ApiModelProperty(value = "A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration.")
  public List<RiskCharacteristic> getRiskCharacteristic() {
    return riskCharacteristic;
  }

  public void setRiskCharacteristic(List<RiskCharacteristic> riskCharacteristic) {
    this.riskCharacteristic = riskCharacteristic;
  }

  public Link validationMechanism(List<ValidationMechanism> validationMechanism) {
    this.validationMechanism = validationMechanism;
    return this;
  }

  public Link addValidationMechanismItem(ValidationMechanism validationMechanismItem) {
    if (this.validationMechanism == null) {
      this.validationMechanism = new ArrayList<ValidationMechanism>();
    }
    this.validationMechanism.add(validationMechanismItem);
    return this;
  }

   /**
   * Provides details of the specific validation mechanism(s) used to confirm the presence of an intended topologicalEntity.
   * @return validationMechanism
  **/
  @ApiModelProperty(value = "Provides details of the specific validation mechanism(s) used to confirm the presence of an intended topologicalEntity.")
  public List<ValidationMechanism> getValidationMechanism() {
    return validationMechanism;
  }

  public void setValidationMechanism(List<ValidationMechanism> validationMechanism) {
    this.validationMechanism = validationMechanism;
  }

  public Link transitionedLayerProtocolName(List<String> transitionedLayerProtocolName) {
    this.transitionedLayerProtocolName = transitionedLayerProtocolName;
    return this;
  }

  public Link addTransitionedLayerProtocolNameItem(String transitionedLayerProtocolNameItem) {
    if (this.transitionedLayerProtocolName == null) {
      this.transitionedLayerProtocolName = new ArrayList<String>();
    }
    this.transitionedLayerProtocolName.add(transitionedLayerProtocolNameItem);
    return this;
  }

   /**
   * Get transitionedLayerProtocolName
   * @return transitionedLayerProtocolName
  **/
  @ApiModelProperty(value = "")
  public List<String> getTransitionedLayerProtocolName() {
    return transitionedLayerProtocolName;
  }

  public void setTransitionedLayerProtocolName(List<String> transitionedLayerProtocolName) {
    this.transitionedLayerProtocolName = transitionedLayerProtocolName;
  }

  public Link nodeEdgePoint(List<OwnedNodeEdgePointRef> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

  public Link addNodeEdgePointItem(OwnedNodeEdgePointRef nodeEdgePointItem) {
    if (this.nodeEdgePoint == null) {
      this.nodeEdgePoint = new ArrayList<OwnedNodeEdgePointRef>();
    }
    this.nodeEdgePoint.add(nodeEdgePointItem);
    return this;
  }

   /**
   * Get nodeEdgePoint
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<OwnedNodeEdgePointRef> getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(List<OwnedNodeEdgePointRef> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
  }

  public Link direction(String direction) {
    this.direction = direction;
    return this;
  }

   /**
   * The directionality of the Link. Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL). Is not present in more complex cases.
   * @return direction
  **/
  @ApiModelProperty(value = "The directionality of the Link. Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL). Is not present in more complex cases.")
  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public Link layerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

  public Link addLayerProtocolNameItem(LayerProtocolNameEnum layerProtocolNameItem) {
    if (this.layerProtocolName == null) {
      this.layerProtocolName = new ArrayList<LayerProtocolNameEnum>();
    }
    this.layerProtocolName.add(layerProtocolNameItem);
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(value = "")
  public List<LayerProtocolNameEnum> getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public Link resilienceType(ResilienceType resilienceType) {
    this.resilienceType = resilienceType;
    return this;
  }

   /**
   * Get resilienceType
   * @return resilienceType
  **/
  @ApiModelProperty(value = "")
  public ResilienceType getResilienceType() {
    return resilienceType;
  }

  public void setResilienceType(ResilienceType resilienceType) {
    this.resilienceType = resilienceType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Link link = (Link) o;
    return Objects.equals(this.uuid, link.uuid) &&
        Objects.equals(this.name, link.name) &&
        Objects.equals(this.administrativeState, link.administrativeState) &&
        Objects.equals(this.lifecycleState, link.lifecycleState) &&
        Objects.equals(this.operationalState, link.operationalState) &&
        Objects.equals(this.availableCapacity, link.availableCapacity) &&
        Objects.equals(this.totalPotentialCapacity, link.totalPotentialCapacity) &&
        Objects.equals(this.costCharacteristic, link.costCharacteristic) &&
        Objects.equals(this.errorCharacteristic, link.errorCharacteristic) &&
        Objects.equals(this.unavailableTimeCharacteristic, link.unavailableTimeCharacteristic) &&
        Objects.equals(this.lossCharacteristic, link.lossCharacteristic) &&
        Objects.equals(this.deliveryOrderCharacteristic, link.deliveryOrderCharacteristic) &&
        Objects.equals(this.serverIntegrityProcessCharacteristic, link.serverIntegrityProcessCharacteristic) &&
        Objects.equals(this.repeatDeliveryCharacteristic, link.repeatDeliveryCharacteristic) &&
        Objects.equals(this.latencyCharacteristic, link.latencyCharacteristic) &&
        Objects.equals(this.riskCharacteristic, link.riskCharacteristic) &&
        Objects.equals(this.validationMechanism, link.validationMechanism) &&
        Objects.equals(this.transitionedLayerProtocolName, link.transitionedLayerProtocolName) &&
        Objects.equals(this.nodeEdgePoint, link.nodeEdgePoint) &&
        Objects.equals(this.direction, link.direction) &&
        Objects.equals(this.layerProtocolName, link.layerProtocolName) &&
        Objects.equals(this.resilienceType, link.resilienceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, administrativeState, lifecycleState, operationalState, availableCapacity, totalPotentialCapacity, costCharacteristic, errorCharacteristic, unavailableTimeCharacteristic, lossCharacteristic, deliveryOrderCharacteristic, serverIntegrityProcessCharacteristic, repeatDeliveryCharacteristic, latencyCharacteristic, riskCharacteristic, validationMechanism, transitionedLayerProtocolName, nodeEdgePoint, direction, layerProtocolName, resilienceType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Link {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
    sb.append("    totalPotentialCapacity: ").append(toIndentedString(totalPotentialCapacity)).append("\n");
    sb.append("    costCharacteristic: ").append(toIndentedString(costCharacteristic)).append("\n");
    sb.append("    errorCharacteristic: ").append(toIndentedString(errorCharacteristic)).append("\n");
    sb.append("    unavailableTimeCharacteristic: ").append(toIndentedString(unavailableTimeCharacteristic)).append("\n");
    sb.append("    lossCharacteristic: ").append(toIndentedString(lossCharacteristic)).append("\n");
    sb.append("    deliveryOrderCharacteristic: ").append(toIndentedString(deliveryOrderCharacteristic)).append("\n");
    sb.append("    serverIntegrityProcessCharacteristic: ").append(toIndentedString(serverIntegrityProcessCharacteristic)).append("\n");
    sb.append("    repeatDeliveryCharacteristic: ").append(toIndentedString(repeatDeliveryCharacteristic)).append("\n");
    sb.append("    latencyCharacteristic: ").append(toIndentedString(latencyCharacteristic)).append("\n");
    sb.append("    riskCharacteristic: ").append(toIndentedString(riskCharacteristic)).append("\n");
    sb.append("    validationMechanism: ").append(toIndentedString(validationMechanism)).append("\n");
    sb.append("    transitionedLayerProtocolName: ").append(toIndentedString(transitionedLayerProtocolName)).append("\n");
    sb.append("    nodeEdgePoint: ").append(toIndentedString(nodeEdgePoint)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    resilienceType: ").append(toIndentedString(resilienceType)).append("\n");
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
