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
package it.nextworks.nfvmano.timeo.rc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;



/**
 * Abstract message sent to the Resource Scheduling Manager
 * 
 * @author nextworks
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "msgType")
@JsonSubTypes({
	@Type(value = ComputationReserveMessage.class, 	name = "RESERVE"),
	@Type(value = ComputationReleaseMessage.class, 	name = "RELEASE"),
	@Type(value = ComputationReleaseMessage.class, 	name = "SCALE"),
})
public abstract class ComputationMessage {

	@JsonProperty("type")
	ComputationMessageType type;
	
	@JsonProperty("operationId")
	String operationId;

	/**
	 * @return the type
	 */
	public ComputationMessageType getType() {
		return type;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
