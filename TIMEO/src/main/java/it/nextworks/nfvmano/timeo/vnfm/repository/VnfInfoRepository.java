package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;


public interface VnfInfoRepository extends JpaRepository<VnfInfo, Long> {
	Optional<VnfInfo> findByVnfInstanceId(String vnfInstanceId);
}
