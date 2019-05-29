package it.nextworks.nfvmano.timeo.monitoring.interfaces;

import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.monitoring.elements.MonitoringGui;
import it.nextworks.nfvmano.timeo.tenant.Tenant;

/**
 * Interface used for creation and management of GUIs to monitor Network Service instances
 * 
 * 
 * @author nextworks
 *
 */
public interface MonitoringGuiManagementInterface {

	/**
	 * This method creates a new GUI for monitoring a NS instance and returns its information.
	 * 
	 * @param pmJobIds ID of the Perfomance Monitoring jobs associated to the parameters to be visualized in the GUI
	 * @param tenant tenant which will have access to the GUI
	 * @param metadata metadata to provide further info for the dashboard
	 * @return information about the GUI and how to access it
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws NotExistingEntityException if the PM jobs or the tenant do not exist
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the parameters are mal formatted
	 */
	public MonitoringGui buildMonitoringGui(List<String> pmJobIds, Tenant tenant, Map<String, String> metadata)
		throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException;
	
	/**
	 * This method removes a GUI with the given ID
	 * 
	 * @param guiId ID of the GUI to be removed
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws NotExistingEntityException if the GUI does not exist
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the GUI ID is not valid 
	 */
	public void removeMonitoringGui(String guiId)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException; 
	
}
