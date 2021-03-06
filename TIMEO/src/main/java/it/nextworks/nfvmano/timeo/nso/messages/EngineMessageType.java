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
package it.nextworks.nfvmano.timeo.nso.messages;

public enum EngineMessageType {

	INSTANTIATE_NS_REQUEST,
	TERMINATE_NS_REQUEST,
	SCALE_NS_REQUEST,
	NOTIFY_COMPUTATION_RESULT,
	NOTIFY_COMPUTATION_RELEASE,
	NOTIFY_ALLOCATION_RESULT,
	NOTIFY_SCALE_COMPUTATION_RESULT,
	NOTIFY_SCALE_VNF_ALLOCATION_RESULT,
	NOTIFY_SCALE_VNF_TERMINATION_RESULT
	
}
