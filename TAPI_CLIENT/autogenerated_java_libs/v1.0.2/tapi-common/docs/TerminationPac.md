
# TerminationPac

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**terminationState** | [**TerminationStateEnum**](#TerminationStateEnum) | Indicates whether the layer is terminated and if so how. |  [optional]
**terminationDirection** | [**TerminationDirectionEnum**](#TerminationDirectionEnum) | The overall directionality of the LP. - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows |  [optional]


<a name="TerminationStateEnum"></a>
## Enum: TerminationStateEnum
Name | Value
---- | -----
LP_CAN_NEVER_TERMINATE | &quot;LP_CAN_NEVER_TERMINATE&quot;
LT_NOT_TERMINATED | &quot;LT_NOT_TERMINATED&quot;
TERMINATED_SERVER_TO_CLIENT_FLOW | &quot;TERMINATED_SERVER_TO_CLIENT_FLOW&quot;
TERMINATED_CLIENT_TO_SERVER_FLOW | &quot;TERMINATED_CLIENT_TO_SERVER_FLOW&quot;
TERMINATED_BIDIRECTIONAL | &quot;TERMINATED_BIDIRECTIONAL&quot;
LT_PERMENANTLY_TERMINATED | &quot;LT_PERMENANTLY_TERMINATED&quot;
TERMINATION_STATE_UNKNOWN | &quot;TERMINATION_STATE_UNKNOWN&quot;


<a name="TerminationDirectionEnum"></a>
## Enum: TerminationDirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
SINK | &quot;SINK&quot;
SOURCE | &quot;SOURCE&quot;
UNDEFINED_OR_UNKNOWN | &quot;UNDEFINED_OR_UNKNOWN&quot;



