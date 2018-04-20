package it.nextworks.nfvmano.timeo.rc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;

public interface NetworkPathHopRepository extends JpaRepository<NetworkPathHop, Long> {
	List<NetworkPathHop> findByNpNsRssNsInstanceIdNotAndNodeId(String nsInstaceId, String nodeId);
}
