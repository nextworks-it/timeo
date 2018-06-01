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
package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import it.nextworks.nfvmano.timeo.rc.algorithms.LogicalLinkParameters;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 28/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
abstract class ConfLink {

    protected TopologyNode node;
    ConfLinkType linkType;
    NetConfiguration source;
    NetConfiguration destination;

    private ConfLink(TopologyNode node, ConfLinkType linkType,
                     NetConfiguration source, NetConfiguration destination) {
        this.node = node;
        this.linkType = linkType;
        this.source = source;
        this.destination = destination;
    }

    abstract double weight(double traffic);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfLink confLink = (ConfLink) o;

        return node.equals(confLink.node)
                && linkType == confLink.linkType
                && source.equals(confLink.source)
                && destination.equals(confLink.destination);
    }

    @Override
    public int hashCode() {
        int result = node.hashCode();
        result = 31 * result + linkType.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + destination.hashCode();
        return result;
    }

    enum ConfLinkType {
        NODE_STATE_CHANGE,
        VM_INSTANTIATION,
        TRAFFIC_PROCESSING
    }

    static class StateChangeLink extends ConfLink {
        Integer newState;

        StateChangeLink(TopologyNode node, Integer newState,
                        NetConfiguration source, NetConfiguration destination) {
            super(node, ConfLinkType.NODE_STATE_CHANGE, source, destination);
            this.newState = newState;
        }

        @Override
        double weight(double traffic) {
            return node.idle;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            StateChangeLink that = (StateChangeLink) o;

            return newState.equals(that.newState);
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + newState.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return String.format("Conf Link[type: %s, node: %s, new state: %s]", linkType, node, newState);
        }
    }

    static class VMInstantiationLink extends ConfLink {

        String vmInstantiated;

        VMInstantiationLink(TopologyNode node, String vmInstantiated,
                            NetConfiguration source, NetConfiguration destination) {
            super(node, ConfLinkType.VM_INSTANTIATION, source, destination);
            this.vmInstantiated = vmInstantiated;
        }

        @Override
        double weight(double traffic) {
            return node.getIdleVM();
        }

        double processingWeight(double traffic) {
            return (node.getProcessing() * traffic);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            VMInstantiationLink that = (VMInstantiationLink) o;

            return vmInstantiated.equals(that.vmInstantiated);
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + vmInstantiated.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return String.format("Conf Link[type: %s, node: %s, vm: %s]", linkType, node, vmInstantiated);
        }
    }

    static class TrafficProcessingLink extends ConfLink {

        String vmProcessing;
        LogicalLinkParameters logLink;

        TrafficProcessingLink(TopologyNode node, String vmProcessing,
                              NetConfiguration source, NetConfiguration destination,
                              LogicalLinkParameters logLink) {
            super(node, ConfLinkType.TRAFFIC_PROCESSING, source, destination);
            this.vmProcessing = vmProcessing;
            this.logLink = logLink;
        }

        @Override
        double weight(double traffic) {
            return node.getProcessing() * traffic;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            TrafficProcessingLink that = (TrafficProcessingLink) o;

            return vmProcessing.equals(that.vmProcessing)
                    && logLink.equals(that.logLink);
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + vmProcessing.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return String.format("Conf Link[type: %s, node: %s, vm: %s]", linkType, node, vmProcessing);
        }
    }
}
