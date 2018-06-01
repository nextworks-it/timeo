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
class VmInstantiation implements Variable {
    TopologyNode node;
    String vm;

    VmInstantiation(TopologyNode node, String vm) {
        if (node == null) {
            throw new IllegalArgumentException("Node Id must not be null.");
        }
        if (vm == null) {
            throw new IllegalArgumentException("Vm id must not be null.");
        }
        this.node = node;
        this.vm = vm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VmInstantiation that = (VmInstantiation) o;

        return node.equals(that.node) && vm.equals(that.vm);
    }

    @Override
    public int hashCode() {
        int result = node.hashCode();
        result = 31 * result + vm.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("DELTA(%s, %s)", node, vm);
    }
}
