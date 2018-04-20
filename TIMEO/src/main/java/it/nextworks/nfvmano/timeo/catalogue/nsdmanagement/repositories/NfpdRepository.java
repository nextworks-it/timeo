package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.Nfpd;



public interface NfpdRepository extends JpaRepository<Nfpd, Long> {
	Optional<Nfpd> findByNfpIdAndFgVnffgdIdAndFgNsdNsdIdentifierAndFgNsdVersion(String nfpId, String vnffgdId, String nsdId, String nsdVersion);
}
