package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.appd.MecServiceDescriptor;

public interface MecServiceDescriptorRepository extends JpaRepository<MecServiceDescriptor, Long>{
	
	List<MecServiceDescriptor> findByAppdAppDIdAndAppdAppDVersion(String appdId, String version);
	Optional<MecServiceDescriptor> findBySerNameAndAppdAppDIdAndAppdAppDVersion(String serName, String appdId, String version);

}
