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

import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessageType;

public class NotifyAllocationResultMessage extends EngineMessage {

	private boolean successful;
	
	@JsonProperty("allocationType")
	private AllocationMessageType allocationType;
	
	@JsonCreator
	public NotifyAllocationResultMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("successful") boolean isSuccessful,
			@JsonProperty("allocationType") AllocationMessageType allocationType) {
		this.type = EngineMessageType.NOTIFY_ALLOCATION_RESULT;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.successful = isSuccessful;
		this.allocationType = allocationType;
	}

	/**
	 * @return the isSuccessful
	 */
	@JsonProperty("successful")
	public boolean isSuccessful() {
		return successful;
	}

	/**
	 * @return the allocationType
	 */
	public AllocationMessageType getAllocationType() {
		return allocationType;
	}
	
}
