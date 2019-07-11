package it.nextworks.nfvmano.libs.bluespace.algorithm.elements;

/**
 * This class models the resource requirements for a VM
 * representing a VDU within a VNF in the requested Network Service
 * 
 * @author nextworks
 *
 */
public class VmRequirements {

	private int vCpuNumber; 
	private int memory;		//in GB
	private int storage;	//in GB
	private int network;	//in MB
	private int vGpuNumber;
	private String cpuLevel;
	private String gpuLevel;
	
	public VmRequirements() { }

	/**
	 * Constructor
	 * 
	 * @param vCpuNumber required number of vCPU
	 * @param memory amount of required memory in GB
	 * @param storage amount of required storage in GB
	 * @param network required bandwidth
	 * @param vGpuNumber required number of vGPU
	 * @param cpuLevel additional constraint on the vCPU
	 * @param gpuLevel additional constraint on the vGPU
	 */
	public VmRequirements(int vCpuNumber, int memory, int storage, int network, int vGpuNumber, String cpuLevel,
			String gpuLevel) {
		super();
		this.vCpuNumber = vCpuNumber;
		this.memory = memory;
		this.storage = storage;
		this.network = network;
		this.vGpuNumber = vGpuNumber;
		this.cpuLevel = cpuLevel;
		this.gpuLevel = gpuLevel;
	}

	/**
	 * @return the vCpuNumber
	 */
	public int getvCpuNumber() {
		return vCpuNumber;
	}

	/**
	 * @return the memory
	 */
	public int getMemory() {
		return memory;
	}

	/**
	 * @return the storage
	 */
	public int getStorage() {
		return storage;
	}

	/**
	 * @return the network
	 */
	public int getNetwork() {
		return network;
	}

	/**
	 * @return the vGpuNumber
	 */
	public int getvGpuNumber() {
		return vGpuNumber;
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
	
	

}
