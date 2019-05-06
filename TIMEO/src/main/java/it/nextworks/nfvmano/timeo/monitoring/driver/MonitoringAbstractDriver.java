package it.nextworks.nfvmano.timeo.monitoring.driver;

import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementProviderInterface;
import it.nextworks.nfvmano.timeo.monitoring.interfaces.MonitoringElaborationInterface;
import it.nextworks.nfvmano.timeo.monitoring.interfaces.MonitoringGuiManagementInterface;

/**
 * This is an abstract class that must be extended by a specific monitoring driver to provide access to a monitoring platform.
 * 
 * @author nextworks
 *
 */
public abstract class MonitoringAbstractDriver implements PerformanceManagementProviderInterface,
		MonitoringElaborationInterface, MonitoringGuiManagementInterface {

	private MonitoringDriverType driverType;
	protected String monitoringPlatformUrl;
	
	/**
	 * Constructor
	 * 
	 * @param driverType type of monitoring driver
	 * @param monitoringPlatformUrl URL to reach the monitoring platform
	 */
	public MonitoringAbstractDriver(MonitoringDriverType driverType,
			String monitoringPlatformUrl) {
		this.driverType = driverType;
		this.monitoringPlatformUrl = monitoringPlatformUrl;
	}

	/**
	 * @return the driverType
	 */
	public MonitoringDriverType getDriverType() {
		return driverType;
	}

	/**
	 * @return the monitoringPlatformUrl
	 */
	public String getMonitoringPlatformUrl() {
		return monitoringPlatformUrl;
	}
	
	
}
