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



import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class SbNetworkPath {

    private String networkPathId;

    private String tenantId;

    private List<NetworkPathHop> hops = new ArrayList<>();
    
    SbNetworkPathType sbNpType;

    private Classifier trafficClassifier;

    public SbNetworkPath(String networkPathId,
                         String tenantId,
                         List<NetworkPathHop> hops,
                         Classifier trafficClassifier,
                         SbNetworkPathType sbNpType) {
        this.networkPathId = networkPathId;
        this.tenantId = tenantId;
        if (hops != null) this.hops = hops;
        this.trafficClassifier = trafficClassifier;
        this.sbNpType = sbNpType;
    }

    public String getNetworkPathId() {
        return networkPathId;
    }

    public String getTenantId() { return  tenantId; }

    public List<NetworkPathHop> getHops() {
        return hops;
    }

    public Classifier getTrafficClassifier() {
        return trafficClassifier;
    }

	/**
	 * @return the sbNpType
	 */
	public SbNetworkPathType getSbNpType() {
		return sbNpType;
	}
    
    
}
