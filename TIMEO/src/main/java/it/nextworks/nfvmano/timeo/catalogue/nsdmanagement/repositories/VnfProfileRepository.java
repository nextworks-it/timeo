package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.VnfProfile;



public interface VnfProfileRepository extends JpaRepository<VnfProfile, Long>{
	Optional<VnfProfile> findByVnfProfileIdAndNsDfNsDfIdAndNsDfNsdNsdIdentifierAndNsDfNsdVersion(String vnfProfileId, String nsDfId, String nsdId, String nsdVersion);
}
