package io.swagger.client.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

//This class was added to match the original content sent by CTTC
//after some discussions it seems it is not necessary
public class CreateConnectivityServiceRPCInputRequest {

	 @SerializedName("tapi-connectivity:input")
	 private CreateConnectivityServiceRPCInputSchema createConnectivityServiceRPCInputSchema = null;

	/**
	 * @return the createConnectivityServiceRPCInputSchema
	 */
	public CreateConnectivityServiceRPCInputSchema getCreateConnectivityServiceRPCInputSchema() {
		return createConnectivityServiceRPCInputSchema;
	}

	/**
	 * @param createConnectivityServiceRPCInputSchema the createConnectivityServiceRPCInputSchema to set
	 */
	public void setCreateConnectivityServiceRPCInputSchema(
			CreateConnectivityServiceRPCInputSchema createConnectivityServiceRPCInputSchema) {
		this.createConnectivityServiceRPCInputSchema = createConnectivityServiceRPCInputSchema;
	}
	 
	 
	 
}
