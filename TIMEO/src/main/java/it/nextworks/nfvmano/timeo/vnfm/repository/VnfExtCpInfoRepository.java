package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.VnfExtCpInfo;


public interface VnfExtCpInfoRepository extends JpaRepository<VnfExtCpInfo, Long> {
	List<VnfExtCpInfo> findByIVnfInfoVnfInfoVnfInstanceId(String vnfInstanceId);
	Optional<VnfExtCpInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndCpdId(String vnfInstanceId, String cpdId);
	Optional<VnfExtCpInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndCpInstanceId(String vnfInstanceId, String cpInstanceId);
}
