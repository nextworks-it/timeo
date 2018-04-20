package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;



public interface NsdRepository extends JpaRepository<Nsd, Long>{
	Optional<Nsd> findById(Long id);
	Optional<Nsd> findByNsdIdentifierAndVersion(String id, String version);
	Set<Nsd> findByNsdIdentifier(String id);
}
