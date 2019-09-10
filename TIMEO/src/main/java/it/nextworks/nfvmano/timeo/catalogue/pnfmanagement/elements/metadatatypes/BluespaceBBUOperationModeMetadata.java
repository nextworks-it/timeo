package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;
@Entity
@DiscriminatorValue("BluespaceBBUOperationMode")
public class BluespaceBBUOperationModeMetadata extends PnfInstanceMetadata {


	/*operation mode values
	 *M2=0
	 *M2E=1
	 *M3=2
	 *M4=3
	 *M4bS=4 
	 */

	private Integer operationModeValue;

	@JsonCreator
	public  BluespaceBBUOperationModeMetadata(
			@JsonProperty("pnfInstance")PnfInstance pnfInstance,
			@JsonProperty(value="name", required=true)String name, 
			@JsonProperty("value")int value) {
		super(pnfInstance, name, new Integer(value));

	}


	@Override
	public Integer getValue() {
		return operationModeValue;
	}

	@Override
	public void setValue(Serializable value) {
		if(value instanceof Integer) {
			operationModeValue=(Integer) value;
		}

	}

	@Override
	public PnfInstanceMetadata setPnfInstance(PnfInstance pnfInstance) {

		return new BluespaceBBUOperationModeMetadata(pnfInstance, this.getName(), this.getValue());
	}


	public int getNumerology() {
		if(operationModeValue==0) {

			return 2;
		}else if(operationModeValue==1) {
			return 2;
		}else if(operationModeValue==2) {
			return 3;
		}else if(operationModeValue==3) {
			return 4;
		}else if(operationModeValue==4) {
			return 4;
		}else {
			//TODO: error control
			return -1;
		}

	}

	public int getDfSubcarrierSpacing() {
		if(operationModeValue==0) {

			return 60;
		}else if(operationModeValue==1) {
			return 60;
		}else if(operationModeValue==2) {
			return 120;
		}else if(operationModeValue==3) {
			return 240;
		}else if(operationModeValue==4) {
			return 240;
		}else {
			//TODO: error control
			return -1;
		}
	}

	public int getNfFourierSamples() {
		if(operationModeValue==0) {

			return 4096;
		}else if(operationModeValue==1) {
			return 4096;
		}else if(operationModeValue==2) {
			return 4096;
		}else if(operationModeValue==3) {
			return 2048;
		}else if(operationModeValue==4) {
			return 4096;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public double getFsSamplingFrequency() {
		if(operationModeValue==0) {

			return 245.7;
		}else if(operationModeValue==1) {
			return 245.7;
		}else if(operationModeValue==2) {
			return 491.52;
		}else if(operationModeValue==3) {
			return 491.52;
		}else if(operationModeValue==4) {
			return 983.04;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public int getSlotsPerSubframe() {
		if(operationModeValue==0) {

			return 4;
		}else if(operationModeValue==1) {
			return 4;
		}else if(operationModeValue==2) {
			return 8;
		}else if(operationModeValue==3) {
			return 16;
		}else if(operationModeValue==4) {
			return 16;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public double getSlotDuration() {
		if(operationModeValue==0) {

			return 0.25;
		}else if(operationModeValue==1) {
			return 0.25;
		}else if(operationModeValue==2) {
			return 0.125;
		}else if(operationModeValue==3) {
			return 0.0625;
		}else if(operationModeValue==4) {
			return 0.0625;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public int getOFDMSymbolsPerSlot() {
		if(operationModeValue==0) {

			return 14;
		}else if(operationModeValue==1) {
			return 12;
		}else if(operationModeValue==2) {
			return 14;
		}else if(operationModeValue==3) {
			return 14;
		}else if(operationModeValue==4) {
			return 14;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public int getMaxNumOfSubcarriers() {
		if(operationModeValue==0) {

			return 3168;
		}else if(operationModeValue==1) {
			return 3168;
		}else if(operationModeValue==2) {
			return 3168;
		}else if(operationModeValue==3) {
			return 1584;
		}else if(operationModeValue==4) {
			return 3168;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public double getMaxBandwidth() {
		if(operationModeValue==0) {

			return 190.08;
		}else if(operationModeValue==1) {
			return 190.08;
		}else if(operationModeValue==2) {
			return 380.16;
		}else if(operationModeValue==3) {
			return 380.16;
		}else if(operationModeValue==4) {
			return 760.32;
		}else {
			//TODO: error control
			return -1;
		}
	}
	
	public double getMaxTheoreticalBitRate() {
		if(operationModeValue==0) {

			return 1419.3;
		}else if(operationModeValue==1) {
			return 1216.5;
		}else if(operationModeValue==2) {
			return 2838.5;
		}else if(operationModeValue==3) {
			return 2838.5;
		}else if(operationModeValue==4) {
			return 5677.1;
		}else {
			//TODO: error control
			return -1;
		}
	}

}
