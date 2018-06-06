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
package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.List;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

/**
 * Created by Marco Capitani on 24/04/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class VMSize {
    public int vCPUs;
    public int memory;
    public int hddSize;

    public VMSize(int vCPUs, int memory, int hddSize) {
        this.vCPUs = vCPUs;
        this.memory = memory;
        this.hddSize = hddSize;
    }

    public boolean fitsIn(TopologyNode node) {
        return vCPUs <= node.vCPUs
                && memory <= node.memory
                && hddSize <= node.hddSize;
    }

    public VMSize sum(VMSize other) {
        return new VMSize(
                vCPUs + other.vCPUs,
                memory + other.memory,
                hddSize + other.hddSize
        );
    }

    public static VMSize sum(VMSize... sizes) {
        if (sizes.length == 0) {
            return new VMSize(0,0,0);
        }
        VMSize output = null;
        for (VMSize size : sizes) {
            if (null == output) {
                output = size;
            } else {
              output = output.sum(size);
            }
        }
        return output;
    }

    public static VMSize sum(List<VMSize> sizes) {
        if (sizes.size() == 0) {
            return new VMSize(0,0,0);
        }
        VMSize output = null;
        for (VMSize size : sizes) {
            if (null == output) {
                output = size;
            } else {
                output = output.sum(size);
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return String.format("VMSize[vCPUS: %s, memory: %s, HDD: %s]", vCPUs, memory, hddSize);
    }
}
