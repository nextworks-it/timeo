
# Rule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ruleType** | [**RuleTypeEnum**](#RuleTypeEnum) |  |  [optional]
**forwardingRule** | [**ForwardingRuleEnum**](#ForwardingRuleEnum) |  |  [optional]
**overridePriority** | **String** |  |  [optional]


<a name="RuleTypeEnum"></a>
## Enum: RuleTypeEnum
Name | Value
---- | -----
FORWARDING | &quot;FORWARDING&quot;
CAPACITY | &quot;CAPACITY&quot;
COST | &quot;COST&quot;
TIMING | &quot;TIMING&quot;
RISK | &quot;RISK&quot;
GROUPING | &quot;GROUPING&quot;


<a name="ForwardingRuleEnum"></a>
## Enum: ForwardingRuleEnum
Name | Value
---- | -----
MAY_FORWARD_ACROSS_GROUP | &quot;MAY_FORWARD_ACROSS_GROUP&quot;
MUST_FORWARD_ACROSS_GROUP | &quot;MUST_FORWARD_ACROSS_GROUP&quot;
CANNOT_FORWARD_ACROSS_GROUP | &quot;CANNOT_FORWARD_ACROSS_GROUP&quot;
NO_STATEMENT_ON_FORWARDING | &quot;NO_STATEMENT_ON_FORWARDING&quot;



