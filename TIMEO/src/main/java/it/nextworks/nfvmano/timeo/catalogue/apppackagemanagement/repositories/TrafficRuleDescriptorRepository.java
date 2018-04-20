package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.appd.TrafficRuleDescriptor;

public interface TrafficRuleDescriptorRepository extends JpaRepository<TrafficRuleDescriptor, Long> {

	List<TrafficRuleDescriptor> findByAppdAppDIdAndAppdAppDVersion(String appdId, String version);
	Optional<TrafficRuleDescriptor> findByTrafficRuleIdAndAppdAppDIdAndAppdAppDVersion(String trafficRuleId, String appdId, String version);
	
}
