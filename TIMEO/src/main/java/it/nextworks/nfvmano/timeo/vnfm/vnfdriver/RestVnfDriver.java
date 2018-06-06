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
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationConsumerInterface;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.VnfIndicatorConsumerInterface;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;

/**
 * REF. SOL 002 - v060
 * 
 * 
 * @author nextworks
 *
 */
public class RestVnfDriver extends VnfDriver {

	private static final Logger log = LoggerFactory.getLogger(RestVnfDriver.class);
	
	private VnfRestClient restClient;
	
	private TaskExecutor taskExecutor;
	
	public RestVnfDriver(String vnfInstanceId, String managementIpAddress, RestTemplate restTemplate, TaskExecutor taskExecutor) {
		super(VnfDriverType.REST, vnfInstanceId);
		this.taskExecutor = taskExecutor;
		restClient = new VnfRestClient(restTemplate, managementIpAddress);
	}

	@Override
	public void setConfiguration(SetConfigurationRequest request,
			VnfConfigurationConsumerInterface consumer) throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		log.debug("Modifying VNF configuration.");
		taskExecutor.execute(new VnfConfigTask(restClient, request, consumer));
	}

	

	@Override
	public String subscribe(SubscribeRequest request,
			VnfIndicatorConsumerInterface consumer) throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}

	@Override
	public void unsubscribe(String subscriptionId) throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}

	@Override
	public GetIndicatorValueResponse getIndicatorValue(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}

	@Override
	public void queryVnfIndicatorSubscription(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}
}
