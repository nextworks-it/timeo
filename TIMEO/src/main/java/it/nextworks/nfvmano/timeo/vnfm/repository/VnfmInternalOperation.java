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
package it.nextworks.nfvmano.timeo.vnfm.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;

@Entity
public class VnfmInternalOperation {

	@Id
    @GeneratedValue
    private Long id;
	
	private String operationId;
	private OperationStatus status;
	private String failureMessage;
	private String vnfId;
	private String description;
	
	public VnfmInternalOperation() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param operationId ID of the operation
	 * @param vnfId ID of the VNF the operation is referring to
	 * @param description human readable description of the operation
	 */
	public VnfmInternalOperation(String operationId,
			String vnfId,
			String description) {
		this.operationId = operationId;
		this.status = OperationStatus.PROCESSING;
		this.vnfId = vnfId;
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public OperationStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OperationStatus status) {
		this.status = status;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * @return the failureMessage
	 */
	public String getFailureMessage() {
		return failureMessage;
	}

	/**
	 * @param failureMessage the failureMessage to set
	 */
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	/**
	 * @return the vnfId
	 */
	public String getVnfId() {
		return vnfId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	
}
