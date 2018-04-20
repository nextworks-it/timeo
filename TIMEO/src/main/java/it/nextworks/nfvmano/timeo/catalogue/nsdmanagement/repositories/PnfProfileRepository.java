package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.PnfProfile;




public interface PnfProfileRepository extends JpaRepository<PnfProfile, Long> {
	Optional<PnfProfile> findByPnfProfileIdAndNsDfNsDfIdAndNsDfNsdNsdIdentifierAndNsDfNsdVersion(String pnfProfileId, String nsDfId, String nsdId, String nsdVersion);
}
