package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.InstantiatedVnfInfo;

public interface InstantiatedVnfInfoRepository extends JpaRepository<InstantiatedVnfInfo, Long> {
	Optional<InstantiatedVnfInfo> findByVnfInfoVnfInstanceId(String vnfInstanceId);
}
