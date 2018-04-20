package it.nextworks.nfvmano.timeo.nso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.nsinfo.NsLinkPort;

public interface NsLinkPortRepository extends JpaRepository<NsLinkPort, Long> {
	List<NsLinkPort> findByVlInfoNsInfoNsInstanceId(String nsInstanceId);
	List<NsLinkPort> findByVlInfoNsInfoNsInstanceIdAndVlInfoNsVirtualLinkDescId(String nsInstanceId, String vldId);
	List<NsLinkPort> findByVlInfoNsInfoNsInstanceIdAndVlInfoNsVirtualLinkDescIdAndCpId(String nsInstanceId, String vldId, String cpId);
	Optional<NsLinkPort> findByVlInfoNsInfoNsInstanceIdAndResourceHandleResourceId(String nsInstanceId, String resourceId);
}
