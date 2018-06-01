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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;

/**
 * Internal message sent to an NS Manager to request the instantiation of a new NS
 * 
 * @author nextworks
 *
 */
public class InstantiateNsRequestMessage extends EngineMessage {

	@JsonProperty("request")
	private InstantiateNsRequest request;
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId	ID of the NS Instance to be instantiated
	 * @param operationId	ID of operation associated to the NS instantiation procedure
	 * @param request		Request with the details of the NS instance instantiation
	 */
	@JsonCreator
	public InstantiateNsRequestMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") InstantiateNsRequest request) {
		this.type = EngineMessageType.INSTANTIATE_NS_REQUEST;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public InstantiateNsRequest getRequest() {
		return request;
	}
	
	

}
