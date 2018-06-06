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
package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import it.nextworks.nfvmano.libs.common.enums.ResponseCode;

/**
 * This interface models the interaction between the SDN controller and the NFVO and 
 * it is used for asynchronous notifications or responses to the NFVO.  
 * It must be implemented by the NFVO core and invoked by the SDN controller plugin.
 * 
 * @author nextworks
 *
 */
public interface SdnControllerConsumerInterface {

	/**
	 * Method used to notify the NFVO about the result of an operation
	 * 
	 * @param operationId ID of the operation
	 * @param responseCode result of the operation
	 * @param errorMessage human readable error message
	 */
	public void notifySdnControllerOperationResult(String operationId, ResponseCode responseCode, String errorMessage);
	
}
