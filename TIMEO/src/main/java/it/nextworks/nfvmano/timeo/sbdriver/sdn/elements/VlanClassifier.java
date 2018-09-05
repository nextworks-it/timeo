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
package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class VlanClassifier extends Classifier {

    private String srcMac;
    private String dstMac;
    private int vlanId;

    /**
     * Constructor
     *
     * @param srcMac source MAC address
     * @param dstMac destination MAC address
     * @param vlanId VLAN ID
     */
    public VlanClassifier(String srcMac, String dstMac, int vlanId) {
        super(TrafficClassifierType.VLAN_CLASSIFIER);
        this.srcMac = srcMac;
        this.dstMac = dstMac;
        this.vlanId = vlanId;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public String getDstMac() {
        return dstMac;
    }

    public int getVlanId() {
        return vlanId;
    }
}
