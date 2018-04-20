package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.appd.AppExternalCpd;

public interface AppExternalCpdRepository extends JpaRepository<AppExternalCpd, Long>{
	List<AppExternalCpd> findByAppdAppDIdAndAppdAppDVersion(String appdId, String version);
	Optional<AppExternalCpd> findByCpdIdAndAppdAppDIdAndAppdAppDVersion(String cpdId, String appdId, String version);
}
