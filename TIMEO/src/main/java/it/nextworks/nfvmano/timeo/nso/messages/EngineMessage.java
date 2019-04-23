/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.nso.messages;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Abstract message sent to the NFVO engine
 * 
 * @author nextworks
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "msgType")
@JsonSubTypes({
	@Type(value = InstantiateNsRequestMessage.class, 	name = "INSTANTIATE_REQUEST"),
	@Type(value = TerminateNsRequestMessage.class, 	name = "TERMINATE_REQUEST"),
	@Type(value = ScaleNsRequestMessage.class, 	name = "SCALE_REQUEST"),
	@Type(value = NotifyComputationResultMessage.class, 	name = "NOTIFY_COMPUTATION"),
	@Type(value = NotifyComputationReleaseMessage.class, 	name = "NOTIFY_COMPUTATION_RELEASE"),
	@Type(value = NotifyAllocationResultMessage.class, 	name = "NOTIFY_ALLOCATION"),
})
public abstract class EngineMessage {

	@JsonProperty("type")
	EngineMessageType type;
	
	@JsonProperty("nsInstanceId")
	String nsInstanceId;
	
	@JsonProperty("operationId")
	String operationId;

	/**
	 * @return the type
	 */
	public EngineMessageType getType() {
		return type;
	}

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
