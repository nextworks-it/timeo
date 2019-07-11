package it.nextworks.nfvmano.bluespace.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.bluespace.algorithm.BluespaceAlgorithmInterface;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

/**
 * This class implements an example of blueSPACE algorithm
 * 
 * 
 * @author nextworks
 *
 */
@Service
public class BluespaceAlgorithmService implements BluespaceAlgorithmInterface {

	private static final Logger log = LoggerFactory.getLogger(BluespaceAlgorithmService.class);
	
	public BluespaceAlgorithmService() { }

	@Override
	public BluespaceAlgorithmAllocationResponse computeAllocation(BluespaceAlgorithmAllocationRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		log.debug("Processing request.");
		// TODO:
		throw new MethodNotImplementedException();
	}

}
