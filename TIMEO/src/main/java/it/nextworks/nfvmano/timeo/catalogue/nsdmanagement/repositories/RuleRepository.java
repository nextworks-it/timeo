package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.common.elements.Rule;



public interface RuleRepository extends JpaRepository<Rule, Long> {
	Optional<Rule> findByNfpdNfpIdAndNfpdFgVnffgdIdAndNfpdFgNsdNsdIdentifierAndNfpdFgNsdVersion(String nfpId, String vnffgdId, String nsdId, String nsdVersion);
}
