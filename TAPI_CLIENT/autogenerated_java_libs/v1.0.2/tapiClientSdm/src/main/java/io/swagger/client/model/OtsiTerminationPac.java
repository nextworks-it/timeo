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
import io.swagger.client.model.ApplicationIdentifier;
import io.swagger.client.model.CentralFrequency;
import io.swagger.client.model.LaserPropertiesPac;
import io.swagger.client.model.PowerPropertiesPac;
import io.swagger.client.model.SpectrumBand;
import java.io.IOException;

/**
 * Provides status information only.
 */
@ApiModel(description = "Provides status information only.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class OtsiTerminationPac {
  @SerializedName("laser-properties")
  private LaserPropertiesPac laserProperties = null;

  @SerializedName("selected-spectrum")
  private SpectrumBand selectedSpectrum = null;

  @SerializedName("selected-application-identifier")
  private ApplicationIdentifier selectedApplicationIdentifier = null;

  @SerializedName("received-power")
  private PowerPropertiesPac receivedPower = null;

  @SerializedName("selected-central-frequency")
  private CentralFrequency selectedCentralFrequency = null;

  @SerializedName("selected-modulation")
  private String selectedModulation = null;

  @SerializedName("transmited-power")
  private PowerPropertiesPac transmitedPower = null;

  public OtsiTerminationPac laserProperties(LaserPropertiesPac laserProperties) {
    this.laserProperties = laserProperties;
    return this;
  }

   /**
   * Laser properties.
   * @return laserProperties
  **/
  @ApiModelProperty(value = "Laser properties.")
  public LaserPropertiesPac getLaserProperties() {
    return laserProperties;
  }

  public void setLaserProperties(LaserPropertiesPac laserProperties) {
    this.laserProperties = laserProperties;
  }

  public OtsiTerminationPac selectedSpectrum(SpectrumBand selectedSpectrum) {
    this.selectedSpectrum = selectedSpectrum;
    return this;
  }

   /**
   * Get selectedSpectrum
   * @return selectedSpectrum
  **/
  @ApiModelProperty(value = "")
  public SpectrumBand getSelectedSpectrum() {
    return selectedSpectrum;
  }

  public void setSelectedSpectrum(SpectrumBand selectedSpectrum) {
    this.selectedSpectrum = selectedSpectrum;
  }

  public OtsiTerminationPac selectedApplicationIdentifier(ApplicationIdentifier selectedApplicationIdentifier) {
    this.selectedApplicationIdentifier = selectedApplicationIdentifier;
    return this;
  }

   /**
   * This attribute indicates the selected Application Identifier that is used by the OCh trail termination function. The syntax of ApplicationIdentifier is a pair {ApplicationIdentifierType, PrintableString}. The value of ApplicationIdentifierType is either STANDARD or PROPRIETARY. The value of PrintableString represents the standard application code as defined in the ITU-T Recommendations or a vendor-specific proprietary code. If the ApplicationIdentifierType is STANDARD the value of PrintableString represents a standard application code as defined in the ITU-T Recommendations. If the ApplicationIdentifierType is PROPRIETARY, the first six characters of the PrintableString must contain the Hexadecimal representation of an OUI assigned to the vendor whose implementation generated the Application Identifier; the remaining octets of the PrintableString are unspecified. The value of this attribute of an object instance has to be one of the values identified in the attribute SupportableApplicationIdentifierList of the same object instance. The values and value ranges of the optical interface parameters of a standard application code must be consistent with those values specified in the ITU-T Recommendation for that application code.
   * @return selectedApplicationIdentifier
  **/
  @ApiModelProperty(value = "This attribute indicates the selected Application Identifier that is used by the OCh trail termination function. The syntax of ApplicationIdentifier is a pair {ApplicationIdentifierType, PrintableString}. The value of ApplicationIdentifierType is either STANDARD or PROPRIETARY. The value of PrintableString represents the standard application code as defined in the ITU-T Recommendations or a vendor-specific proprietary code. If the ApplicationIdentifierType is STANDARD the value of PrintableString represents a standard application code as defined in the ITU-T Recommendations. If the ApplicationIdentifierType is PROPRIETARY, the first six characters of the PrintableString must contain the Hexadecimal representation of an OUI assigned to the vendor whose implementation generated the Application Identifier; the remaining octets of the PrintableString are unspecified. The value of this attribute of an object instance has to be one of the values identified in the attribute SupportableApplicationIdentifierList of the same object instance. The values and value ranges of the optical interface parameters of a standard application code must be consistent with those values specified in the ITU-T Recommendation for that application code.")
  public ApplicationIdentifier getSelectedApplicationIdentifier() {
    return selectedApplicationIdentifier;
  }

  public void setSelectedApplicationIdentifier(ApplicationIdentifier selectedApplicationIdentifier) {
    this.selectedApplicationIdentifier = selectedApplicationIdentifier;
  }

  public OtsiTerminationPac receivedPower(PowerPropertiesPac receivedPower) {
    this.receivedPower = receivedPower;
    return this;
  }

   /**
   * Get receivedPower
   * @return receivedPower
  **/
  @ApiModelProperty(value = "")
  public PowerPropertiesPac getReceivedPower() {
    return receivedPower;
  }

  public void setReceivedPower(PowerPropertiesPac receivedPower) {
    this.receivedPower = receivedPower;
  }

  public OtsiTerminationPac selectedCentralFrequency(CentralFrequency selectedCentralFrequency) {
    this.selectedCentralFrequency = selectedCentralFrequency;
    return this;
  }

   /**
   * Get selectedCentralFrequency
   * @return selectedCentralFrequency
  **/
  @ApiModelProperty(value = "")
  public CentralFrequency getSelectedCentralFrequency() {
    return selectedCentralFrequency;
  }

  public void setSelectedCentralFrequency(CentralFrequency selectedCentralFrequency) {
    this.selectedCentralFrequency = selectedCentralFrequency;
  }

  public OtsiTerminationPac selectedModulation(String selectedModulation) {
    this.selectedModulation = selectedModulation;
    return this;
  }

   /**
   * This parameter defines the modulation used at the source
   * @return selectedModulation
  **/
  @ApiModelProperty(value = "This parameter defines the modulation used at the source")
  public String getSelectedModulation() {
    return selectedModulation;
  }

  public void setSelectedModulation(String selectedModulation) {
    this.selectedModulation = selectedModulation;
  }

  public OtsiTerminationPac transmitedPower(PowerPropertiesPac transmitedPower) {
    this.transmitedPower = transmitedPower;
    return this;
  }

   /**
   * Measured power at the Transmitter.
   * @return transmitedPower
  **/
  @ApiModelProperty(value = "Measured power at the Transmitter.")
  public PowerPropertiesPac getTransmitedPower() {
    return transmitedPower;
  }

  public void setTransmitedPower(PowerPropertiesPac transmitedPower) {
    this.transmitedPower = transmitedPower;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtsiTerminationPac otsiTerminationPac = (OtsiTerminationPac) o;
    return Objects.equals(this.laserProperties, otsiTerminationPac.laserProperties) &&
        Objects.equals(this.selectedSpectrum, otsiTerminationPac.selectedSpectrum) &&
        Objects.equals(this.selectedApplicationIdentifier, otsiTerminationPac.selectedApplicationIdentifier) &&
        Objects.equals(this.receivedPower, otsiTerminationPac.receivedPower) &&
        Objects.equals(this.selectedCentralFrequency, otsiTerminationPac.selectedCentralFrequency) &&
        Objects.equals(this.selectedModulation, otsiTerminationPac.selectedModulation) &&
        Objects.equals(this.transmitedPower, otsiTerminationPac.transmitedPower);
  }

  @Override
  public int hashCode() {
    return Objects.hash(laserProperties, selectedSpectrum, selectedApplicationIdentifier, receivedPower, selectedCentralFrequency, selectedModulation, transmitedPower);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtsiTerminationPac {\n");
    
    sb.append("    laserProperties: ").append(toIndentedString(laserProperties)).append("\n");
    sb.append("    selectedSpectrum: ").append(toIndentedString(selectedSpectrum)).append("\n");
    sb.append("    selectedApplicationIdentifier: ").append(toIndentedString(selectedApplicationIdentifier)).append("\n");
    sb.append("    receivedPower: ").append(toIndentedString(receivedPower)).append("\n");
    sb.append("    selectedCentralFrequency: ").append(toIndentedString(selectedCentralFrequency)).append("\n");
    sb.append("    selectedModulation: ").append(toIndentedString(selectedModulation)).append("\n");
    sb.append("    transmitedPower: ").append(toIndentedString(transmitedPower)).append("\n");
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
