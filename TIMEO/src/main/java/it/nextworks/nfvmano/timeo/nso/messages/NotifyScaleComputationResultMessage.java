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

import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.NsScaleSchedulingSolution;

public class NotifyScaleComputationResultMessage extends EngineMessage {

	@JsonProperty("solution")
	NsScaleSchedulingSolution solution;
	
	@JsonCreator
	public NotifyScaleComputationResultMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId, 
			@JsonProperty("solution") NsScaleSchedulingSolution solution) {
		this.type = EngineMessageType.NOTIFY_SCALE_COMPUTATION_RESULT;
		this.nsInstanceId = nsInstanceId;
		this.solution = solution;
		this.operationId = operationId;
	}

	/**
	 * @return the solution
	 */
	public NsScaleSchedulingSolution getSolution() {
		return solution;
	}
	
	

}
