package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.VnfcResourceInfo;

public interface VnfcResourceInfoRepository extends JpaRepository<VnfcResourceInfo, Long> {
	List<VnfcResourceInfo> findByIVnfInfoVnfInfoVnfInstanceId(String vnfInstanceId);
	List<VnfcResourceInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndVduId(String vnfInstanceId, String vduId);
	Optional<VnfcResourceInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndVnfcInstanceId(String vnfInstanceId, String vnfcInstanceId);

}
