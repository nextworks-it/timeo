package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.Vnffgd;



public interface VnffgdRepository extends JpaRepository<Vnffgd, Long> {
	Optional<Vnffgd> findByVnffgdIdAndNsdNsdIdentifierAndNsdVersion(String vnffgdId, String nsdId, String nsdVersion);
}
