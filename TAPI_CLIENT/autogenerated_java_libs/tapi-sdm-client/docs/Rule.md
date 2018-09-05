
# Rule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
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



