package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface NsdInfoRepository extends JpaRepository<InternalNsdInfo, Long> {
	Optional<InternalNsdInfo> findByNsdIdAndVersion(String nsdId, String version);
	Optional<InternalNsdInfo> findByNsdInfoId(String nsdInfoId);
	List<InternalNsdInfo> findByNsdId(String nsdId);
}
