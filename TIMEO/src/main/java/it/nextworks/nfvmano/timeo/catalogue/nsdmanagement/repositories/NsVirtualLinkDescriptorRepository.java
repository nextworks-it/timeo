package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkDesc;



public interface NsVirtualLinkDescriptorRepository extends JpaRepository<NsVirtualLinkDesc, Long> {
	Optional<NsVirtualLinkDesc> findByVirtualLinkDescIdAndVirtuaLinkDescVersionAndNsdNsdIdentifierAndNsdVersion(String vlId, String vlVersion, String nsdId, String nsdVersion);
}
