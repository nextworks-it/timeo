package io.swagger.client.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

//This class was added to match the original content sent by CTTC
//after some discussions it seems it is not necessary
public class DeleteConnectivityServiceRPCInputRequest {

	 @SerializedName("tapi-connectivity:input")
	 private DeleteConnectivityServiceRPCInputSchema deleteConnectivityServiceRPCInputSchema = null;

	/**
	 * @return the deleteConnectivityServiceRPCInputSchema
	 */
	public DeleteConnectivityServiceRPCInputSchema getCreateConnectivityServiceRPCInputSchema() {
		return deleteConnectivityServiceRPCInputSchema;
	}

	/**
	 * @param deleteConnectivityServiceRPCInputSchema the createConnectivityServiceRPCInputSchema to set
	 */
	public void setCreateConnectivityServiceRPCInputSchema(
			DeleteConnectivityServiceRPCInputSchema deleteConnectivityServiceRPCInputSchema) {
		this.deleteConnectivityServiceRPCInputSchema = deleteConnectivityServiceRPCInputSchema;
	}
	 
	 
	 
}
