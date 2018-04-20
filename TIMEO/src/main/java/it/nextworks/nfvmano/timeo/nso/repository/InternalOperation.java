package it.nextworks.nfvmano.timeo.nso.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;

@Entity
public class InternalOperation {

	@Id
    @GeneratedValue
    private Long id;
	
	private String operationId;
	private OperationStatus status;
	private String failureMessage;
	private String nsInstanceId;
	private String description;
	
	public InternalOperation() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param operationId ID of the operation
	 * @param nsInstanceId ID of the NS instance this operation refers to
	 * @param description human readable description of the operation
	 */
	public InternalOperation(String operationId, String nsInstanceId, String description) {
		this.operationId = operationId;
		this.status = OperationStatus.PROCESSING;
		this.nsInstanceId = nsInstanceId;
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
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	
}
