package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.ExtVirtualLinkInfo;

public interface ExtVirtualLinkInfoRepository extends JpaRepository<ExtVirtualLinkInfo, Long> {
	List<ExtVirtualLinkInfo> findByIVnfInfoVnfInfoVnfInstanceId(String vnfInstanceId);
	Optional<ExtVirtualLinkInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndExtVirtualLinkId(String vnfInstanceId, String extVirtualLinkId);
}
