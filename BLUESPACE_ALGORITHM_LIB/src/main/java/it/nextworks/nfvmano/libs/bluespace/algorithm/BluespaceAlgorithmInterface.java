package it.nextworks.nfvmano.libs.bluespace.algorithm;

import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

public interface BluespaceAlgorithmInterface {

	/**
	 * Method to compute the allocation of resources in blueSPACE
	 * 
	 * @param request the resource allocation request
	 * @return the resource allocation response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws NotExistingEntityException if some elements of the request do not exist
	 * @throws FailedOperationException if no solution is found
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public BluespaceAlgorithmAllocationResponse computeAllocation(BluespaceAlgorithmAllocationRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException;
}
