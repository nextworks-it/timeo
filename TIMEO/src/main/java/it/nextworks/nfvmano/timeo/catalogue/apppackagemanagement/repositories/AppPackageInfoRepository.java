package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.AppPackageInfo;

public interface AppPackageInfoRepository extends JpaRepository<AppPackageInfo, Long>{
	
	@Transactional
	Optional<AppPackageInfo> findByAppPackageInfoId(String appPackageInfoId);
	
	@Transactional
	Optional<AppPackageInfo> findByAppdIdAndVersion(String appdId, String version);
	
	@Transactional
	Optional<AppPackageInfo> findByAppdId(String appdId);

}
