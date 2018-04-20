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

import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

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
public class VimResourcePollingManager implements SchedulingConfigurer  {
	
	private static final Logger log = LoggerFactory.getLogger(VimResourcePollingManager.class);
	
	@Value("${timeo.vim.polling}")
	private int vimPollingPeriod;
	
	//map of polled resources. The key is the resource ID. The value provides the info to poll the resource.
	private Map<String, PolledResource> polledResources = new HashMap<>();
	
	
	public VimResourcePollingManager() {
		log.debug("Initializing VIM resources polling manager");
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
				new VimPollingTask(this),
				new Trigger() {
					
					@Override
					public Date nextExecutionTime(TriggerContext triggerContext) {
						Calendar nextExecutionTime = new GregorianCalendar();
						Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
						nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
						nextExecutionTime.add(Calendar.SECOND, vimPollingPeriod);
						return nextExecutionTime.getTime();
					}
				});
	}
	
	/**
	 * Adds a new VIM resource in the list of resources to be polled
	 * 
	 * @param resourceType type of VIM resource to be polled
	 * @param expectedStatus expected status of the resource - when the resource reaches this status the listener is notified
	 * @param resourceId ID of the VIM resource to be polled
	 * @param vimPlugin VIM plugin to be used for polling the resource
	 * @param listener entity to be notified when the resource reaches the expected status
	 */
	public synchronized void addResource(VimResourceType resourceType, VimResourceStatus expectedStatus, String resourceId, 
			VimPlugin vimPlugin, AsynchronousVimNotificationInterface listener) {
		PolledResource resource = new PolledResource(resourceId, resourceType, expectedStatus, vimPlugin, listener);
		this.polledResources.put(resourceId, resource);
		log.debug("Added resource " + resourceId + " to the list of resources in polling. Expected status: " + expectedStatus.toString());
	}
	
	/**
	 * Removes a resource with the given resource ID from the list of resources to be polled
	 * 
	 * @param resourceId ID the VIM resource to be removed from the list
	 */
	public synchronized void removeResource(String resourceId) {
		this.polledResources.remove(resourceId);
		log.debug("Resource " + resourceId + " removed from the list of resources to be polled");
	}


	/**
	 * @return the polledResources
	 */
	public Map<String, PolledResource> getPolledResources() {
		return polledResources;
	}
	
	/**
	 * @return a copy of the polledResources
	 */
	public synchronized Map<String, PolledResource> getPolledResourcesCopy() {
		Map<String, PolledResource> copy = new HashMap<>();
		for (Map.Entry<String, PolledResource> e : polledResources.entrySet()) {
			copy.put(e.getKey(), e.getValue());
		}
		return copy;
	}
	
	

}
