package it.nextworks.nfvmano.timeo.monitoring.interfaces;

import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

public interface MonitoringElaborationInterface {

	/**
	 * This method creates a new Performance Monitoring job related to a composite metric,
	 * which requires the elaboration of more atomic monitoring data collected through others
	 * monitoring jobs.
	 * 
	 * @param rule Rule to compute the value of the composite metric, including a number of variable parameters
	 * @param inputParameters The parameters that must be used to compute the composite metric. The key is the variable in the rule; the value is the ID of an existing PM job used to measure the value of the variable
	 * @param collectionPeriod The periodicity at which the performance data is collected and computed
	 * @param reportingPeriod The periodicity at which the performance data is reported
	 * @return the ID of the created performance job
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 * @throws NotExistingEntityException if one or more of the PM jobs in the input parameters does not exist
	 */
	public String createPmJobForAggregationRule(String rule, 
			Map<String, String> inputParameters, 
			int collectionPeriod, 
			int reportingPeriod)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException, NotExistingEntityException;
	
	/**
	 * This method deletes a set of Performance Monitoring jobs related to composite metrics.
	 * 
	 * @param pmJobIds IDs of the performance monitoring jobs to be deleted
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 * @throws NotExistingEntityException if one or more of the PM jobs to be removed does not exist
	 */
	public void deletePmJobForAggregationRule(List<String> pmJobIds)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException, NotExistingEntityException;
	
}
