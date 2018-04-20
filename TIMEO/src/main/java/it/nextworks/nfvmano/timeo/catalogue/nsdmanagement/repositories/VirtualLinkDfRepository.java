package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkDf;



public interface VirtualLinkDfRepository extends JpaRepository<VirtualLinkDf, Long> {
	Optional<VirtualLinkDf> findByFlavourIdAndNsVldVirtualLinkDescIdAndNsVldVirtuaLinkDescVersionAndNsVldNsdNsdIdentifierAndNsVldNsdVersion(String flavourId, 
			String nsVldId,
			String nsVldVersion,
			String nsdId,
			String nsdVersion);
	
	Optional<VirtualLinkDf> findByFlavourIdAndVnfVldVirtualLinkDescIdAndVnfVldVnfdVnfdIdAndVnfVldVnfdVnfProviderAndVnfVldVnfdVnfdVersion(String dfId,
			String vnfVdlId,
			String vnfdId,
			String vnfProvider,
			String vnfdVersion);

}
