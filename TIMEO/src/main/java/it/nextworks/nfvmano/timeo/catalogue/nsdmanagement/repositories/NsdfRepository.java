package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.NsDf;




public interface NsdfRepository extends JpaRepository<NsDf, Long> {
	Optional<NsDf> findByNsDfIdAndNsdNsdIdentifierAndNsdVersion(String nsDfId, String nsdId, String nsdVersion);
}
