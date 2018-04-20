package it.nextworks.nfvmano.timeo.rc.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;

public interface VnfResourceAllocationRepository extends JpaRepository<VnfResourceAllocation, Long> {
	List<VnfResourceAllocation> findByNsRssNsInstanceIdAndVnfdIdAndVnfIndex (String nsInstanceId, String vnfdId, int vnfIndex);
	List<VnfResourceAllocation> findByNsRssNsInstanceIdNotAndVimIdAndHostId(String nsInstanceId, String vimId, String hostId);
}
