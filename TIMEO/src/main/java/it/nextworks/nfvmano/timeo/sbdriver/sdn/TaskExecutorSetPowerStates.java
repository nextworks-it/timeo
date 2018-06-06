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
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Marco Capitani on 24/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
@Component
@Scope("prototype")
public class TaskExecutorSetPowerStates implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(TaskExecutorSetPowerStates.class);

    private NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient;

    private HashMap<String, Map<String, PowerState>> opIdToStateMap = new HashMap<>();

    private Map<String, SdnControllerConsumerInterface> opIdToConsumerInterface = new HashMap<>();

    private Lock operationLock = new ReentrantLock();

    /**
     * Class that locks when instantiated, and unlocks when closed.
     * To be used in a try-with-resources block
     */
    private class LockedContext implements AutoCloseable {

        private LockedContext() {
            operationLock.lock();
        }

        @Override
        public void close() {
            operationLock.unlock();
        }
    }

    public boolean isEmpty() {
        return opIdToStateMap.isEmpty();
    }


    public TaskExecutorSetPowerStates() {

    }

    public TaskExecutorSetPowerStates(NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient) {
        this.nfvoOpenDaylightRestClient = nfvoOpenDaylightRestClient;
    }

    public void setNfvoOpenDaylightRestClient(NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient) {
        this.nfvoOpenDaylightRestClient = nfvoOpenDaylightRestClient;
    }

    @Override
    public void run() {
        log.debug("Running thread TaskExecutorSetPowerStates");
        while (!isEmpty()) {
            log.debug("Cycling in TaskExecutorSetPowerStates");
            try (LockedContext context = new LockedContext()) {
                String opId = pollOperation();
                if (opId == null) {
                    continue;
                }
                Map<String, PowerState> states = opIdToStateMap.get(opId);
                SdnControllerConsumerInterface consumer = opIdToConsumerInterface.get(opId);
                try {
                    internalRun(states);
                } catch (RemoteEntityFailureException e) {
                    log.debug("Sending notification for failed set power states.");
                    consumer.notifySdnControllerOperationResult(
                            opId,
                            ResponseCode.FAILED_GENERIC,
                            e.getMessage());
                    continue;
                }

                opIdToConsumerInterface.get(opId).notifySdnControllerOperationResult(
                        opId, ResponseCode.OK, null
                );
            }
        }
    }

    public synchronized void addOperation(String opId,
                                          Map<String, PowerState> states,
                                          SdnControllerConsumerInterface consumer) {
        opIdToConsumerInterface.put(opId, consumer);
        opIdToStateMap.put(opId, states);
    }

    public synchronized void removeOperation(String opId) {
        opIdToStateMap.remove(opId);
        opIdToConsumerInterface.remove(opId);
    }

    private synchronized String pollOperation() {
        Iterator<String> iterator = opIdToStateMap.keySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        String next = iterator.next();
        removeOperation(next);
        return next;
    }

    void internalRun(Map<String, PowerState> states) throws RemoteEntityFailureException {
        nfvoOpenDaylightRestClient.sendSetStatesRequest(states);
    }

}
