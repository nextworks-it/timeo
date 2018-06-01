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
package it.nextworks.nfvmano.timeo.ro;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.timeo.vnfm.Vnfm;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

/**
 * Class that manages the periodical polling of VIM resources
 * 
 * @author nextworks
 *
 */
@EnableScheduling
@Service
public class VnfmOperationPollingManager implements SchedulingConfigurer  {
	
	private static final Logger log = LoggerFactory.getLogger(VnfmOperationPollingManager.class);
	
	@Value("${timeo.vnfm.polling}")
	private int vnfmPollingPeriod;
	
	//map of polled operation. The key is the resource ID. The value provides the info to poll the resource.
	private Map<String, PolledOperation> polledOperations = new HashMap<>();
	
	
	public VnfmOperationPollingManager() {
		log.debug("Initializing VNFM operations polling manager");
	}
	
	
	/**
	 * 
	 * @return the executor of the VIM polling thread task
	 */
	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newSingleThreadScheduledExecutor();
	}

	/**
	 * Method to trigger the periodical polling task. 
	 * The period is configured in the application property file.
	 * 
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		taskRegistrar.addTriggerTask(
				new VnfmOperationPollingTask(this),
				new Trigger() {
					
					@Override
					public Date nextExecutionTime(TriggerContext triggerContext) {
						Calendar nextExecutionTime = new GregorianCalendar();
						Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
						nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
						nextExecutionTime.add(Calendar.SECOND, vnfmPollingPeriod);
						return nextExecutionTime.getTime();
					}
				});
	}
	
	
	/**
	 * Adds a new VNFM operation in the list of the operations to be polled
	 * 
	 * @param operationId ID of the VNFM operation to be polled
	 * @param expectedStatus expected status of the operation - when the operation reaches this status the listener is notified
	 * @param vnfId ID of the VNF the operation refers to
	 * @param vnfm VNFM to be used for polling the resource
	 * @param listener entity to be notified when the resource reaches the expected status
	 */
	public synchronized void addOperation(String operationId, OperationStatus expectedStatus, String vnfId, Vnfm vnfm, NsResourceAllocationManager listener) {
		PolledOperation operation = new PolledOperation(operationId, expectedStatus, vnfId, vnfm, listener);
		this.polledOperations.put(operationId, operation);
		log.debug("Added operation " + operationId + " to the list of VNFM operations in polling. Expected status: " + expectedStatus.toString());
	}
	
	/**
	 * Removes an operation with the given ID from the list of operations to be polled
	 * 
	 * @param operationId ID the VNFM operation to be removed from the list
	 */
	public synchronized void removeOperation(String operationId) {
		this.polledOperations.remove(operationId);
		log.debug("Operation " + operationId + " removed from the list of VNFM operations to be polled");
	}


	/**
	 * @return the polledOperations
	 */
	public Map<String, PolledOperation> getPolledOperations() {
		return polledOperations;
	}
	
	/**
	 * @return a copy of the polledOperations
	 */
	public synchronized Map<String, PolledOperation> getPolledOperationsCopy() {
		Map<String, PolledOperation> copy = new HashMap<>();
		for (Map.Entry<String, PolledOperation> e : polledOperations.entrySet()) {
			copy.put(e.getKey(), e.getValue());
		}
		return copy;
	}


	
	
	

}
