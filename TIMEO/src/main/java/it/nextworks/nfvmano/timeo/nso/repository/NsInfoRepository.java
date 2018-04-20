package it.nextworks.nfvmano.timeo.nso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;

public interface NsInfoRepository extends JpaRepository<NsInfo, Long> {
	Optional<NsInfo> findByNsInstanceId(String nsInstanceId);
}
