package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.NsLevel;




public interface NsLevelRepository extends JpaRepository<NsLevel, Long> {
	Optional<NsLevel> findByNsLevelIdAndNsDfNsDfIdAndNsDfNsdNsdIdentifierAndNsDfNsdVersion(String nsLevelId, String nsDfId, String nsdId, String nsdVersion);
	Optional<NsLevel> findByNsLevelIdAndNsScaleNsScalingAspectIdAndNsScaleNsDfNsDfIdAndNsScaleNsDfNsdNsdIdentifierAndNsScaleNsDfNsdVersion(String nsLevelId, String scalingAspectId, String nsDfId, String nsdId, String nsdVersion);
}
