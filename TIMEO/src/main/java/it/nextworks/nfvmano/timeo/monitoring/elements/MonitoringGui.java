package it.nextworks.nfvmano.timeo.monitoring.elements;

/**
 * Element modelling a GUI for monitoring a network service
 * 
 * @author nextworks
 *
 */
public class MonitoringGui {
	
	private String guiId;
	private String url;

	public MonitoringGui() {
		//Default
	}
	
	/**
	 * Constructor
	 * 
	 * @param guiId ID of the GUI
	 * @param url URL where the GUI can be accessed
	 */
	public MonitoringGui(String guiId, String url) {
		this.guiId = guiId;
		this.url = url;
	}

	/**
	 * @return the guiId
	 */
	public String getGuiId() {
		return guiId;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	

}
