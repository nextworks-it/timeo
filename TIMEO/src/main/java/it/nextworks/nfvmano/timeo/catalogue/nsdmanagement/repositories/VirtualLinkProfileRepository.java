package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkProfile;




public interface VirtualLinkProfileRepository extends JpaRepository<VirtualLinkProfile, Long> {
	Optional<VirtualLinkProfile> findByVirtualLinkProfileIdAndNsDfNsDfIdAndNsDfNsdNsdIdentifierAndNsDfNsdVersion(String vlProfileId, String nsDfId, String nsdId, String nsdVersion);
	List<VirtualLinkProfile> findByVnfDfFlavourIdAndVnfDfVnfdVnfdIdAndVnfDfVnfdVnfProviderAndVnfDfVnfdVnfdVersion(String flavourId, String vnfdId, String vnfProvider, String version);
	Optional<VirtualLinkProfile> findByVirtualLinkProfileIdAndVnfDfFlavourIdAndVnfDfVnfdVnfdIdAndVnfDfVnfdVnfProviderAndVnfDfVnfdVnfdVersion(String vlProfileId, String flavourId, String vnfdId, String vnfProvider, String version);
}
