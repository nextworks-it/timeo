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
package it.nextworks.nfvmano.timeo.rc.elements;

import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;

/**
 * Created by Marco Capitani on 17/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class TopologyCp {

    protected TopologyNode node;
    protected TopologyLink outgoingLink;
    protected TopologyLink incomingLink;
    public String cpId;
    public String address;
    protected String cpdId;
    
    protected LayerProtocol layerProtocol;

    public TopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                      String address, String cpId, String cpdId) {
        this.node = node;
        this.outgoingLink = outgoingLink;
        this.incomingLink = incomingLink;
        this.address = address;
        this.cpId = cpId;
        this.cpdId = cpdId;
        this.layerProtocol = LayerProtocol.NOT_SPECIFIED;
    }

    public TopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                      String address, String cpId) {
        this.node = node;
        this.outgoingLink = outgoingLink;
        this.incomingLink = incomingLink;
        this.address = address;
        this.cpId = cpId;
        this.cpdId = null;
        this.layerProtocol = LayerProtocol.NOT_SPECIFIED;
    }
    
    public TopologyCp(TopologyNode node, LayerProtocol layerProtocol, TopologyLink outgoingLink, TopologyLink incomingLink,
    		String address, String cpId, String cpdId) {
    	this.node = node;
    	this.outgoingLink = outgoingLink;
    	this.incomingLink = incomingLink;
    	this.address = address;
    	this.cpId = cpId;
    	this.cpdId = cpdId;
    	this.layerProtocol = layerProtocol;
    }

    public TopologyCp(TopologyNode node, LayerProtocol layerProtocol, TopologyLink outgoingLink, TopologyLink incomingLink,
    		String address, String cpId) {
    	this.node = node;
    	this.outgoingLink = outgoingLink;
    	this.incomingLink = incomingLink;
    	this.address = address;
    	this.cpId = cpId;
    	this.cpdId = null;
    	this.layerProtocol = layerProtocol;
    }

	/**
	 * @return the node
	 */
	public TopologyNode getNode() {
		return node;
	}

	/**
	 * @return the outgoingLink
	 */
	public TopologyLink getOutgoingLink() {
		return outgoingLink;
	}

	/**
	 * @return the incomingLink
	 */
	public TopologyLink getIncomingLink() {
		return incomingLink;
	}

	/**
	 * @return the cpId
	 */
	public String getCpId() {
		return cpId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the cpdId
	 */
	public String getCpdId() {
		return cpdId;
	}

	/**
	 * @return the layerProtocol
	 */
	public LayerProtocol getLayerProtocol() {
		return layerProtocol;
	}

	/**
	 * @param outgoingLink the outgoingLink to set
	 */
	public void setOutgoingLink(TopologyLink outgoingLink) {
		this.outgoingLink = outgoingLink;
	}

	/**
	 * @param incomingLink the incomingLink to set
	 */
	public void setIncomingLink(TopologyLink incomingLink) {
		this.incomingLink = incomingLink;
	}
    
    
}
