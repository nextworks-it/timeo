package it.nextworks.nfvmano.timeo.nso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.nsinfo.NsVirtualLinkInfo;

public interface NsVirtualLinkInfoRepository extends JpaRepository<NsVirtualLinkInfo, Long> {
	List<NsVirtualLinkInfo> findByNsInfoNsInstanceId(String nsInstanceId);
	Optional<NsVirtualLinkInfo> findByNsInfoNsInstanceIdAndNsVirtualLinkDescId(String nsInstanceId, String vldId);
	Optional<NsVirtualLinkInfo> findByResourceId(String resourceId);
}
