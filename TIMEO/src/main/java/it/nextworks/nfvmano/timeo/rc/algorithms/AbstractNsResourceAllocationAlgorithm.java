package it.nextworks.nfvmano.timeo.rc.algorithms;

public abstract class AbstractNsResourceAllocationAlgorithm implements NsResourceAllocationAlgorithmInterface {

	AlgorithmType type;
	
	public AbstractNsResourceAllocationAlgorithm(AlgorithmType type) {
		this.type = type;
	}

}
