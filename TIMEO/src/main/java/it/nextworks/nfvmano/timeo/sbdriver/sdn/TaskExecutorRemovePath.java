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
package it.nextworks.nfvmano.timeo.sbdriver.sdn;


import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
@Component
@Scope("prototype")
public class TaskExecutorRemovePath implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(TaskExecutorRemovePath.class);

    private NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient;

    private Map<String, List<String>> opIdToNetPathId = new ConcurrentHashMap<>();

    private Map<String, SdnControllerConsumerInterface> opIdToConsumerInterface = new ConcurrentHashMap<>();

    public void setNfvoOpenDaylightRestClient(NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient) {
        this.nfvoOpenDaylightRestClient = nfvoOpenDaylightRestClient;
    }

    @Override
    public void run() {
        log.debug("Running thread TaskExecutorRemovePath");
        while (!isEmpty()) {
            log.debug("Cicling in TaskExecutorRemovePath thread");
            // Foreach element on map, delete paths
            synchronized (this) {

                for (Map.Entry<String, List<String>> entry : opIdToNetPathId.entrySet()) {
                    SdnControllerConsumerInterface consumer = opIdToConsumerInterface.get(entry.getKey());

                    for (String netPathId : entry.getValue()) {
                        try {
                            nfvoOpenDaylightRestClient.sendDeletePathRequest(netPathId);
                        } catch (RemoteEntityFailureException e) {
                            log.debug("Sending notification for failed RemovePathsRequest.");
                            consumer.notifySdnControllerOperationResult(entry.getKey(), ResponseCode.FAILED_GENERIC,
                                    e.getMessage());
                            removeFromMap(entry.getKey());
                            continue;
                        }
                    }
                    log.debug("Sending notification for successful RemovePathsRequest.");
                    consumer.notifySdnControllerOperationResult(entry.getKey(), ResponseCode.OK, "");
                    removeFromMap(entry.getKey());
                }

				/*
                try {
					Iterator<Entry<String, List<String>>> iterator = opIdToNetPathId.entrySet().iterator();
					while (iterator.hasNext()) {
						Entry<String, List<String>> element = iterator.next();
						SdnControllerConsumerInterface consumer = opIdToConsumerInterface.get(element.getKey());
						for(String netPathId : element.getValue()){
							try {
								nfvoOpenDaylightRestClient.sendDeletePathRequest(netPathId);
							} catch (RemoteEntityFailureException e) {
								log.debug("Sending notification for failed RemovePathsRequest.");
								consumer.notifySdnControllerOperationResult(element.getKey(), ResponseCode.FAILED_GENERIC,
										e.getMessage());
								continue;
							}
						}
						log.debug("Sending notification for successful RemovePathsRequest.");
						consumer.notifySdnControllerOperationResult(element.getKey(), ResponseCode.OK, "");
						//REMOVING NETPATHIDS
						iterator.remove();
						//REMOVING CONSUMER
						Iterator<Entry<String, SdnControllerConsumerInterface>> iteratorConsumer = opIdToConsumerInterface.entrySet().iterator();
						while (iteratorConsumer.hasNext()) {
							Entry<String, SdnControllerConsumerInterface> elementConsumer = iteratorConsumer.next();
							if(elementConsumer.getKey().equals(element.getKey())){
								iteratorConsumer.remove();
							}
						}
					}
				} catch (ConcurrentModificationException e) {
					log.error("ConcurrentModificationException" + e.getMessage());
				}*/
            }
        }
        log.debug("Shutting down TaskExecutorRemovePath");
    }

    public boolean isEmpty() {

        synchronized (opIdToNetPathId) {
            return opIdToNetPathId.isEmpty();
        }
    }

    public void putToMap(String operationId, List<String> networkPathIds,
                         SdnControllerConsumerInterface consumer) {

        synchronized (opIdToNetPathId) {
            opIdToNetPathId.put(operationId, networkPathIds);
        }
        synchronized (opIdToConsumerInterface) {
            opIdToConsumerInterface.put(operationId, consumer);
        }
    }

    public void removeFromMap(String operationId) {

        synchronized (opIdToNetPathId) {
            opIdToNetPathId.remove(operationId);
        }
        synchronized (opIdToConsumerInterface) {
            opIdToConsumerInterface.remove(operationId);
        }
    }
}
