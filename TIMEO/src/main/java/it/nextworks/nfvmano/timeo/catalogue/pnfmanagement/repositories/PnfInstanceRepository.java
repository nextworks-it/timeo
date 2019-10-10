package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;

public interface PnfInstanceRepository extends JpaRepository<PnfInstance, Long> {

	Optional<PnfInstance> findByPnfInstanceId(String pnfInstanceId);
	List<PnfInstance> findByPnfdId(String pnfdId);

}
