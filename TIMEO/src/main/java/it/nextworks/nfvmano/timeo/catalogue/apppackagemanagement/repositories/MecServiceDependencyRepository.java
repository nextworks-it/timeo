package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.appd.MecServiceDependency;

public interface MecServiceDependencyRepository extends JpaRepository<MecServiceDependency, Long>{

	List<MecServiceDependency> findByAppdRequiredAppDIdAndAppdRequiredAppDVersion(String appdId, String version);
	Optional<MecServiceDependency> findBySerNameAndAppdRequiredAppDIdAndAppdRequiredAppDVersion(String serName, String appdId, String version);
	
	List<MecServiceDependency> findByAppdOptionalAppDIdAndAppdOptionalAppDVersion(String appdId, String version);
	Optional<MecServiceDependency> findBySerNameAndAppdOptionalAppDIdAndAppdOptionalAppDVersion(String serName, String appdId, String version);
}
