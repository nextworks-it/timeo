package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;



public interface PnfdRepository extends JpaRepository<Pnfd, Long> {
	Optional<Pnfd> findByPnfdIdAndVersion(String pnfdId, String version);
	Set<Pnfd> findByPnfdId(String pfndId);
}
