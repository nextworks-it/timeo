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
package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationConsumerInterface;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;


public class VnfConfigTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(VnfConfigTask.class);
	
	private VnfConfigurationConsumerInterface consumer;
	private SetConfigurationRequest request;
	private VnfRestClient client;

	public VnfConfigTask(VnfRestClient restClient, SetConfigurationRequest request, VnfConfigurationConsumerInterface consumer) {
		this.client = restClient;
		this.consumer = consumer;
		this.request = request;
	}

	@Override
	public void run() {
		log.debug("Running VNF config task");
		try {
			SetConfigurationResponse response = client.setConfiguration(request);
			consumer.notifySetConfigurationResult(ResponseCode.OK, response);
			log.debug("VNFM notified about VNF configuration.");
		} catch (FailedOperationException e) {
			log.error("VNF configuration failed: " + e.getMessage());
			try {
				consumer.notifySetConfigurationResult(ResponseCode.FAILED_GENERIC, null);
			} catch (Exception e1) {
				log.error("Error while notifying the VNFM about the VNF config result" + e1.getMessage());
			}
		} catch (Exception e) {
			log.error("Error while notifying the VNFM about the VNF config result" + e.getMessage());
		}
	}

}
