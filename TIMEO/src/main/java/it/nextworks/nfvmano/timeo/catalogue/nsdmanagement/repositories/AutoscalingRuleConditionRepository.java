package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.AutoscalingRuleCondition;

public interface AutoscalingRuleConditionRepository extends JpaRepository<AutoscalingRuleCondition, Long> {

}
