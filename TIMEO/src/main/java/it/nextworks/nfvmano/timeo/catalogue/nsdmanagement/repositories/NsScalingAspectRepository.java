package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.NsScalingAspect;



public interface NsScalingAspectRepository extends JpaRepository<NsScalingAspect, Long> {
	Optional<NsScalingAspect> findByNsScalingAspectIdAndNsDfNsDfIdAndNsDfNsdNsdIdentifierAndNsDfNsdVersion(String nsScalingAspectId, String nsDfId, String nsdId, String nsdVersion);
}
