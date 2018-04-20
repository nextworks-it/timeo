package it.nextworks.nfvmano.timeo.sbdriver.vim.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualNetworkInterfaceData;

public interface VirtualNetworkInterfaceDataRepository extends JpaRepository<VirtualNetworkInterfaceData, Long> {
	Set<VirtualNetworkInterfaceData> findByVcfFlavourId(String flavourId);
}	
