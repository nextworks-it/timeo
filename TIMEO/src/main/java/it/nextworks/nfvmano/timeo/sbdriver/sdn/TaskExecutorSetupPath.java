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
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SetupPathRequest;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.TrafficClassifierType;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.VlanClassifier;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.ComputedPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.ComputedStep;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.Connection;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.EthernetDestination;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.EthernetMatch;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.EthernetSource;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.OFresource;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.PathRequestDestination;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.PathRequestSource;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.Resourcespec;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.VlanId;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning.VlanMatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
@Component
@Scope("prototype")
public class TaskExecutorSetupPath implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(TaskExecutorSetupPath.class);

    private NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient;

    private Map<String, List<SbNetworkPath>> opIdToNetPathId = new ConcurrentHashMap<>();

    private Map<String, SdnControllerConsumerInterface> opIdToConsumerInterface = new ConcurrentHashMap<>();

    public void setNfvoOpenDaylightRestClient(NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient) {
        this.nfvoOpenDaylightRestClient = nfvoOpenDaylightRestClient;
    }

    @Override
    public void run() {
        log.debug("Running thread TaskExecutorSetupPath");
        while (!isEmpty()) {
            log.debug("Cicling in TaskExecutorSetupPath thread");
            synchronized (this) {
                for (Map.Entry<String, List<SbNetworkPath>> entry : opIdToNetPathId.entrySet()) {

                    SdnControllerConsumerInterface consumer = opIdToConsumerInterface.get(entry.getKey());

                    for (SbNetworkPath netPath : entry.getValue()) {

                        String netPathId = netPath.getNetworkPathId();
                        String tenantId = netPath.getTenantId();
                        log.debug("Got tenant ID: " + tenantId);
                        PathRequestSource pathRequestSource = null;
                        PathRequestDestination pathRequestDestination = null;

                        if (netPath.getTrafficClassifier().getType() == TrafficClassifierType.VLAN_CLASSIFIER) {
                            log.debug("Traffic Classifier Type: " + TrafficClassifierType.VLAN_CLASSIFIER.toString());
                            OFresource src_ofresource = new OFresource(
                                    netPath.getHops().get(0).getIngressPortId(),
                                    new VlanMatch(new VlanId(((VlanClassifier) netPath.getTrafficClassifier()).getVlanId(), true), 0),
                                    new EthernetMatch(new EthernetSource(((VlanClassifier) netPath.getTrafficClassifier()).getSrcMac()), null)
                            );

                            OFresource dst_ofresource = new OFresource(
                                    netPath.getHops().get(netPath.getHops().size() - 1).getEgressPortId(),
                                    null,
                                    new EthernetMatch(null, new EthernetDestination(((VlanClassifier) netPath.getTrafficClassifier()).getDstMac()))
                            );
                            Resourcespec src_resourcespec = new Resourcespec(src_ofresource);
                            Resourcespec dst_resourcespec = new Resourcespec(dst_ofresource);
                            pathRequestSource = new PathRequestSource(
                                    netPath.getHops().get(0).getNodeId(),
                                    ((VlanClassifier) netPath.getTrafficClassifier()).getSrcMac(),
                                    src_resourcespec
                            );
                            pathRequestDestination = new PathRequestDestination(
                                    netPath.getHops().get(netPath.getHops().size() - 1).getNodeId(),
                                    ((VlanClassifier) netPath.getTrafficClassifier()).getDstMac(),
                                    dst_resourcespec
                            );
                        } else if (netPath.getTrafficClassifier().getType() == TrafficClassifierType.L2_CLASSIFIER) {
                            // TODO
                            log.error("Not yet implemented for " + TrafficClassifierType.L2_CLASSIFIER.toString());
                        } else if (netPath.getTrafficClassifier().getType() == TrafficClassifierType.L3_CLASSIFIER) {
                            // TODO
                            log.error("Not yet implemented for " + TrafficClassifierType.L3_CLASSIFIER.toString());
                        }

                        List<PathRequestDestination> destination = new ArrayList<>();
                        destination.add(pathRequestDestination);

                        List<NetworkPathHop> networkPathHops = netPath.getHops();
                        List<ComputedStep> computedSteps = new ArrayList<>();

                        for (NetworkPathHop hop : networkPathHops) {
                            ComputedStep computedStep = new ComputedStep(hop.getHopNumber(),
                                    hop.getNodeId(),
                                    hop.getIngressPortId(),
                                    hop.getEgressPortId(),
                                    hop.getIncomingLinkId(),
                                    hop.getOutgoingLinkId(),
                                    hop.getHopQueue(),
                                    hop.isFirst(),
                                    hop.isLast());
                            computedSteps.add(computedStep);
                        }

                        ComputedPath computedPath = new ComputedPath(computedSteps);
                        Connection connection = new Connection(netPathId, tenantId, pathRequestSource, destination, computedPath);
                        SetupPathRequest setupPathRequest = new SetupPathRequest(connection);

                        try {
                            nfvoOpenDaylightRestClient.sendSetupPathRequest(setupPathRequest);
                        } catch (RemoteEntityFailureException e) {
                            log.debug("Sending notification for failed SetupPathsRequest.");
                            consumer.notifySdnControllerOperationResult(entry.getKey(), ResponseCode.FAILED_GENERIC, e.getMessage());
                            removeFromMap(entry.getKey());
                            continue;
                        }
                    }

                    log.debug("Sending notification for successful SetupPathsRequest.");
                    consumer.notifySdnControllerOperationResult(entry.getKey(), ResponseCode.OK, "");
                    removeFromMap(entry.getKey());
                }
            }
        }
        log.debug("Shutting down TaskExecutorSetupPath");
    }

    public boolean isEmpty() {

        synchronized (opIdToNetPathId) {
            return opIdToNetPathId.isEmpty();
        }

    }

    public void putToMap(String operationId, List<SbNetworkPath> networkPaths, SdnControllerConsumerInterface consumer) {

        synchronized (opIdToNetPathId) {
            opIdToNetPathId.put(operationId, networkPaths);
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
