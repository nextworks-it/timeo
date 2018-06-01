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
package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;

public class TerminateVnfMessage extends AllocationMessage {

	@JsonProperty("request")
	private TerminateNsRequest request;
	
	@JsonProperty("operationId")
	String operationId;
	
	@JsonCreator
	public TerminateVnfMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") TerminateNsRequest request) {
		this.type = AllocationMessageType.REMOVE_VNF;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public TerminateNsRequest getRequest() {
		return request;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
