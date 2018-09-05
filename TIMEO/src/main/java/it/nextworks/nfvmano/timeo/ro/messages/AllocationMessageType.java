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
package it.nextworks.nfvmano.timeo.ro.messages;

public enum AllocationMessageType {

	//COMMANDS
	ALLOCATE_NS_VLS,
	ALLOCATE_VNF,
	CONFIGURE_VNF,
	SETUP_UNDERLYING_CONNECTIVITY,
	REMOVE_NS_VLS,
	REMOVE_VNF,
	REMOVE_UNDERLYING_CONNECTIVITY,
	
	//ACKs from VIM
	VIM_ACK_ALLOCATE_VNET_RESOURCE,
	
	//ACKs from VNFM
	VNFM_OPERATION_ACK,
	
	//ACKs from SDN controller
	SDN_CONTROLLER_ACK
	
}
