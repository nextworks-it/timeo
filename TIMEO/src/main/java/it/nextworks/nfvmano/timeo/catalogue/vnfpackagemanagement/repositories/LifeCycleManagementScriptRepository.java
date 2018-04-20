package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

import it.nextworks.nfvmano.libs.descriptors.common.elements.LifeCycleManagementScript;

public interface LifeCycleManagementScriptRepository extends JpaRepository<LifeCycleManagementScript, Long> {
	@Transactional
	List<LifeCycleManagementScript> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	
	@Transactional
	List<LifeCycleManagementScript> findByNsdNsdIdentifier(String nsdId);
}
