/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.ro;

public enum ResourceAllocationStatus {

	INIT,
	CREATING_VLS_NETS,
	CREATING_VLS_SUBNETS,
	CREATING_VLS_SAPS,
	CREATED_VLS,
	CREATING_VNF,
	SCALING_VNF,
	CREATED_VNF,
	SCALED_VNF,
	CONFIGURING_VNF,
	CONFIGURED_VNF,
	CREATING_NETWORK_CONNECTIONS,
	CREATED_NETWORK_CONNECTIONS,
	TERMINATING_VNF,
	TERMINATED_VNF,
	TERMINATING_NETWORK_CONNECTIONS,
	TERMINATED_NETWORK_CONNECTIONS,
	TERMINATING_VLS_SAPS,
	TERMINATING_VLS_SUBNETS,
	TERMINATING_NETS,
	TERMINATED_NETS,
	FAILED
	
}
