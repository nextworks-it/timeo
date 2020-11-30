package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

/**
 * This class models a server in blueSPACE infrastructure, its available and occupied resources.
 * 
 * @author nextworks
 *
 */
public class PhysicalServer {

	private String serverId;
	
	//total availability and characteristics
	private int totalCpu;
	private int totalMemory;	//in GB
	private int totalStorage;	//in GB
	private int totalNetwork;	//in MB
	private int totalGpu;
	private String cpuLevel;
	private String gpuLevel;
	
	//occupied resources
	private int usedCpu;
	private int usedMemory;		//in GB
	private int usedStorage;	//in GB
	private int usedNetwork;	//in MB
	private int usedGpu;
	
	public PhysicalServer() { }
	
	

	/**
	 * Constructor
	 * 
	 * @param serverId ID of the physical server
	 * @param totalCpu total number of CPU available at the server 
	 * @param totalMemory total memory available at the server
	 * @param totalStorage total storage available at the server
	 * @param totalNetwork total bw available at the server network interface
	 * @param totalGpu total number of GPU available at the server
	 * @param cpuLevel constraints of the CPU at the server
	 * @param gpuLevel constraints of the GPU at the server
	 * @param usedCpu total number of CPUs used on the server
	 * @param usedMemory total amount of memory used on the server 
	 * @param usedStorage total amount of storage used on the server
	 * @param usedNetwork total amount of bw used at the server network interface
	 * @param usedGpu total number of GPUs used on the server
	 */
	public PhysicalServer(String serverId, int totalCpu, int totalMemory, int totalStorage, int totalNetwork,
			int totalGpu, String cpuLevel, String gpuLevel, int usedCpu, int usedMemory, int usedStorage,
			int usedNetwork, int usedGpu) {
		super();
		this.serverId = serverId;
		this.totalCpu = totalCpu;
		this.totalMemory = totalMemory;
		this.totalStorage = totalStorage;
		this.totalNetwork = totalNetwork;
		this.totalGpu = totalGpu;
		this.cpuLevel = cpuLevel;
		this.gpuLevel = gpuLevel;
		this.usedCpu = usedCpu;
		this.usedMemory = usedMemory;
		this.usedStorage = usedStorage;
		this.usedNetwork = usedNetwork;
		this.usedGpu = usedGpu;
	}



	/**
	 * @return the serverId
	 */
	public String getServerId() {
		return serverId;
	}

	/**
	 * @return the totalCpu
	 */
	public int getTotalCpu() {
		return totalCpu;
	}

	/**
	 * @return the totalMemory
	 */
	public int getTotalMemory() {
		return totalMemory;
	}

	/**
	 * @return the totalStorage
	 */
	public int getTotalStorage() {
		return totalStorage;
	}

	/**
	 * @return the totalNetwork
	 */
	public int getTotalNetwork() {
		return totalNetwork;
	}

	/**
	 * @return the totalGpu
	 */
	public int getTotalGpu() {
		return totalGpu;
	}

	/**
	 * @return the cpuLevel
	 */
	public String getCpuLevel() {
		return cpuLevel;
	}

	/**
	 * @return the gpuLevel
	 */
	public String getGpuLevel() {
		return gpuLevel;
	}

	/**
	 * @return the usedCpu
	 */
	public int getUsedCpu() {
		return usedCpu;
	}

	/**
	 * @return the usedMemory
	 */
	public int getUsedMemory() {
		return usedMemory;
	}

	/**
	 * @return the usedStorage
	 */
	public int getUsedStorage() {
		return usedStorage;
	}

	/**
	 * @return the usedNetwork
	 */
	public int getUsedNetwork() {
		return usedNetwork;
	}

	/**
	 * @return the usedGpu
	 */
	public int getUsedGpu() {
		return usedGpu;
	}
	
	

}
