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

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;

import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationConsumerInterface;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.VnfIndicatorConsumerInterface;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * REF. SOL 002 - v060
 * 
 * 
 * @author nextworks
 *
 */
public class RestVnfDriver extends VnfDriver implements Consumer<VnfGetIndicatorTask> {

	private static final Logger log = LoggerFactory.getLogger(RestVnfDriver.class);
	
	private VnfRestClient restClient;
	
	private TaskExecutor taskExecutor;

	private Map<UUID, Consumer<GetIndicatorValueResponse>> listeners = new HashMap<>();

	public RestVnfDriver(
			String vnfInstanceId,
			TaskExecutor taskExecutor,
			VnfRestClient restClient
	) {
		super(VnfDriverType.REST, vnfInstanceId);
		this.taskExecutor = taskExecutor;
		this.restClient = restClient;
	}

	public RestVnfDriver(
			String vnfInstanceId,
			String managementIpAddress,
			RestTemplate restTemplate,
			TaskExecutor taskExecutor
	) {
		super(VnfDriverType.REST, vnfInstanceId);
		this.taskExecutor = taskExecutor;
		restClient = new VnfRestClient(restTemplate, managementIpAddress);
	}

	public RestVnfDriver(
			String vnfInstanceId,
			String managementIpAddress,
			int port,
			RestTemplate restTemplate,
			TaskExecutor taskExecutor
	) {
		super(VnfDriverType.REST, vnfInstanceId);
		this.taskExecutor = taskExecutor;
		restClient = new VnfRestClient(restTemplate, managementIpAddress, port);
	}

	@Override
	public void setConfiguration(SetConfigurationRequest request,
			VnfConfigurationConsumerInterface consumer) {
		log.debug("Modifying VNF configuration.");
		taskExecutor.execute(new VnfConfigTask(restClient, request, consumer));
	}

	@Override
	public String subscribe(SubscribeRequest request,
			VnfIndicatorConsumerInterface consumer) throws MethodNotImplementedException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}

	@Override
	public void unsubscribe(String subscriptionId) throws MethodNotImplementedException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}

	@Override
	public GetIndicatorValueResponse getIndicatorValue(GeneralizedQueryRequest request)
			throws FailedOperationException {
		log.debug("Requesting VNF indicator values");
		VnfGetIndicatorTask task = new VnfGetIndicatorTask(request, restClient, vnfInstanceId, this);
		taskExecutor.execute(task);

		Instant startWait = Instant.now();

		while(task.result == null) { // cycle until our result got back
			try {
				synchronized (this) { // Only needed to call "wait()"
					wait(10000); // Wait until a result is returned. We'll see if it's ours the next iteration
				}
			} catch (InterruptedException e) {
				log.warn("Thread interrupted while waiting GetIndicatorResponse");
				// Keep waiting...
			}
			if (Instant.now().isAfter(startWait.plusSeconds(180))) { // Give up after 60 seconds
				throw new FailedOperationException("No response from VNF");
			}
		}
		// We got the result
		return task.result;
	}

	public void getIndicatorValueAsync(GeneralizedQueryRequest request, Consumer<GetIndicatorValueResponse> listener) {
		log.debug("Requesting VNF indicator values (async)");
		VnfGetIndicatorTask task = new VnfGetIndicatorTask(request, restClient, vnfInstanceId, this);
		listeners.put(task.id, listener);
		taskExecutor.execute(task);
	}

	@Override
	public void queryVnfIndicatorSubscription(GeneralizedQueryRequest request) throws MethodNotImplementedException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException();
	}

	@Override
	public synchronized void accept(VnfGetIndicatorTask task) {
		if (task.result == null) {
			throw new IllegalArgumentException("Unfinished task!");
		}
		Consumer<GetIndicatorValueResponse> listener = listeners.get(task.id);
		if (listener != null) {
			listener.accept(task.result);
		} else { // it's a sync request
			notifyAll(); // Wake all threads waiting. They will re-wait if this is not their result
		}
	}
}
