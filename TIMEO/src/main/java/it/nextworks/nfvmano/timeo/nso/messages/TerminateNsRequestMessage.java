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

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;

/**
 * Internal message sent to an NS Manager to request the termination of an existing NS instance
 * 
 * @author nextworks
 *
 */
public class TerminateNsRequestMessage extends EngineMessage {

	@JsonProperty("request")
	private TerminateNsRequest request;
	
	public TerminateNsRequestMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") TerminateNsRequest request) {
		this.type = EngineMessageType.TERMINATE_NS_REQUEST;
		this.operationId = operationId;
		this.nsInstanceId = nsInstanceId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public TerminateNsRequest getRequest() {
		return request;
	}
	
	

}
