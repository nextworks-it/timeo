package it.nextworks.nfvmano.timeo.sbdriver.vim.emma;

/**
 * Static parameters to model power consumption in servers for each power state. 
 * 
 * @author nextworks
 *
 */
public class PowerStateParameters {

	private int idleHost;
	private int idleVm;
	private int activeVm;
	private int trafficVm;
	
	public PowerStateParameters(int idleHost, int idleVm, int trafficVm, int activeVm) {
		this.idleHost = idleHost;
		this.idleVm = idleVm;
		this.trafficVm = trafficVm;
		this.activeVm = activeVm;
	}

	/**
	 * @return the idleHost
	 */
	public int getIdleHost() {
		return idleHost;
	}

	/**
	 * @return the idleVm
	 */
	public int getIdleVm() {
		return idleVm;
	}

	/**
	 * @return the activeVm
	 */
	public int getActiveVm() {
		return activeVm;
	}

	public int getTrafficVm(){
		return trafficVm;
	}
}
