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
package it.nextworks.nfvmano.timeo.nso;

public enum InternalNsStatus {

	TO_BE_INSTANTIATED,
	COMPUTING_RESOURCES,
	ALLOCATING_NS_VLS,
	CREATING_VNFS,
	CONFIGURING_VNFS,
	CREATING_CONNECTIVITY,
	ALLOCATED,
	TERMINATING_MONITORING,
	TERMINATING_VNFS,
	TERMINATING_CONNECTIVITY,
	REMOVING_NS_VLS,
	RELEASING_COMPUTED_RESOURCES,
	TERMINATED,
	FAILED,
	COMPUTING_SCALING_RESOURCES,
	SCALE_CREATING_VNFS, 
	SCALE_TERMINATING_VNFS,
	SCALE_CREATING_CONNECTIVITY, 
	SCALE_CONFIGURING_VNFS, 
	SCALE_ALLOCATED,
	
}
