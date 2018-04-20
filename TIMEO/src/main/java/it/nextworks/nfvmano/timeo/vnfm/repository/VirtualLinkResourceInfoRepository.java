package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.VirtualLinkResourceInfo;

public interface VirtualLinkResourceInfoRepository extends JpaRepository<VirtualLinkResourceInfo, Long> {
	List<VirtualLinkResourceInfo> findByIVnfInfoVnfInfoVnfInstanceId(String vnfInstanceId);
	Optional<VirtualLinkResourceInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndVirtualLinkInstanceId(String vnfInstanceId, String resourceId);
	Optional<VirtualLinkResourceInfo> findByIVnfInfoVnfInfoVnfInstanceIdAndVirtualLinkDescId(String vnfInstanceId, String vldId);
}
