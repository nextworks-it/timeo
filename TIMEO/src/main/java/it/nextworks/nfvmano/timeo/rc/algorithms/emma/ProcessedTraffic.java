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
package it.nextworks.nfvmano.timeo.rc.algorithms.emma;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
class ProcessedTraffic implements Variable {

    private TopologyNode sourceNode;
    private TopologyNode actualNode;
    private String previousVM;
    private String nextVM;

    ProcessedTraffic(TopologyNode actualNode, TopologyNode sourceNode,
                     String previousVM, String nextVM) {
        if (actualNode == null) {
            throw new IllegalArgumentException("Actual Node must not be null.");
        }
        if (sourceNode == null) {
            throw new IllegalArgumentException("Source Node must not be null.");
        }
        if (previousVM == null) {
            throw new IllegalArgumentException("Previous VM must not be null.");
        }
        if (nextVM == null) {
            throw new IllegalArgumentException("Next VM must not be null.");
        }
        this.actualNode = actualNode;
        this.sourceNode = sourceNode;
        this.previousVM = previousVM;
        this.nextVM = nextVM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcessedTraffic that = (ProcessedTraffic) o;

        return sourceNode.equals(that.sourceNode)
                && actualNode.equals(that.actualNode)
                && previousVM.equals(that.previousVM)
                && nextVM.equals(that.nextVM);
    }

    @Override
    public int hashCode() {
        int result = sourceNode.hashCode();
        result = 37 * result + actualNode.hashCode();
        result = 37 * result + previousVM.hashCode();
        result = 37 * result + nextVM.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("P_%s (%s, %s, %s)", actualNode, sourceNode, previousVM, nextVM);
    }
}
