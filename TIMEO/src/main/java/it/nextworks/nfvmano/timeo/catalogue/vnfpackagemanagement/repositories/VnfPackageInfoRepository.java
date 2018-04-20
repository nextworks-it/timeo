package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.transaction.annotation.Transactional;

import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;

public interface VnfPackageInfoRepository extends JpaRepository<OnboardedVnfPkgInfo, Long> {
	@Transactional
	Optional<OnboardedVnfPkgInfo> findByOnboardedVnfPkgInfoId(String vnfPackageId);

	@Transactional
	Optional<OnboardedVnfPkgInfo> findByVnfProductNameAndVnfSoftwareVersionAndVnfProvider(String name, String version, String provider);
	
	@Transactional
	Optional<OnboardedVnfPkgInfo> findByVnfdId(String vnfdId);
}
