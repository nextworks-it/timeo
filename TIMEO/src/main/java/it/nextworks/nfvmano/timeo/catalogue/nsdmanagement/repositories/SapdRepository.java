package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.Sapd;


public interface SapdRepository extends JpaRepository<Sapd, Long> {
	Optional<Sapd> findByCpdIdAndNsdNsdIdentifierAndNsdVersion(String sapdId, String nsdId, String nsdVersion);
}
