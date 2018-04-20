package it.nextworks.nfvmano.timeo.rc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;

public interface NsResourceSchedulingSolutionRepository extends JpaRepository<NsResourceSchedulingSolution, Long>{

	Optional<NsResourceSchedulingSolution> findByNsInstanceId(String nsInstanceId);
	
}
