package it.nextworks.nfvmano.timeo.rc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.rc.elements.PnfAllocation;

public interface PnfAllocationRepository extends JpaRepository<PnfAllocation, Long> {

	List<PnfAllocation> findByNsRssNsInstanceId (String nsInstanceId);
	
}
