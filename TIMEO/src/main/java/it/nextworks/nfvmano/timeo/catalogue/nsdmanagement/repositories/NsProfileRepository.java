package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.NsProfile;



public interface NsProfileRepository extends JpaRepository<NsProfile, Long> {
	Optional<NsProfile> findByNsProfileIdAndNsDfNsDfIdAndNsDfNsdNsdIdentifierAndNsDfNsdVersion(String nsProfileId, String nsDfId, String nsdId, String nsdVersion);
}
