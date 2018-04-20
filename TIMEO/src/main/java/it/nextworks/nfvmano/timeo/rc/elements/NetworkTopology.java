package it.nextworks.nfvmano.timeo.rc.elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NetworkTopology {

	public List<TopologyNode> nodes;
	public List<TopologyLink> links;
	private Map<String, TopologyNode> id2nodeMap;
	private Map<String, TopologyCp> id2cpMap;
	private Map<String, TopologyCp> addressMap;

	public double processing; // in W/Kb TODO should become a mapping flavor -> PC
	// TODO: yes, it is node-agnostic, and it needs to be such.

	public NetworkTopology(List<TopologyNode> nodes, List<TopologyLink> links) {
		this.nodes = nodes;
		this.links = links;
		id2nodeMap = new HashMap<>();
		for (TopologyNode node : nodes) {
			id2nodeMap.put(node.nodeId, node);
		}
		id2cpMap = nodes.stream()
				.flatMap((n) -> n.cps.stream())
				.collect(Collectors.toMap((cp) -> cp.cpId, Function.identity()));
		addressMap = nodes.stream()
				.flatMap((n) -> n.cps.stream().filter((cp) -> cp.address != null))
				.collect(Collectors.toMap((cp) -> cp.address, Function.identity()));

		this.processing = 6E-6;
		validate();
	}

	private void validate() {
		for (TopologyLink link : links) {
			if (!(link.source == (id2nodeMap.get(link.source.nodeId)))) {
				throw new IllegalArgumentException(String.format("Link %s source not found in topology.", link));
			}
			if (!(link.destination == (id2nodeMap.get(link.destination.nodeId)))) {
				throw new IllegalArgumentException(String.format("Link %s destination not found in topology.", link));
			}
		}
	}

	public TopologyNode fetchNodeById(String nodeId) {
		return id2nodeMap.get(nodeId);
	}

	public void addNode(TopologyNode node) {
		TopologyNode previousNode = id2nodeMap.get(node.nodeId);
		if (previousNode != null) {
			if (previousNode != node) {
				throw new IllegalArgumentException("Node with id " + node.nodeId + " already in the topology.");
			}
			// Else skip adding
		} else {
			nodes.add(node);
			id2nodeMap.put(node.nodeId, node);
			for (TopologyCp cp : node.cps) {
				TopologyCp prevCp = addressMap.get(cp.address);
				if (prevCp == cp) {
					continue;
				}
				if (null != prevCp) {
					throw new IllegalStateException("Address " + cp.address + " already in use.");
				}
				// else
				addressMap.put(cp.address, cp);
			}
		}
	}

	public void addCp(String node, TopologyCp cp) {
		TopologyNode topoNode = id2nodeMap.get(node);
		addCp(topoNode, cp);
	}


	public void addCp(TopologyNode node, TopologyCp cp) {
		TopologyCp prevCp = addressMap.get(cp.address);
		if (prevCp == cp) {
			return;
		}
		if (prevCp != null) {
			throw new IllegalStateException("Address " + cp.address + " already in use.");
		}
		node.cps.add(cp);
		id2cpMap.put(cp.cpId, cp);
		if (cp.address != null) {
			addressMap.put(cp.address, cp);
		}
	}

	public void addLink(TopologyLink link) {
		if (!(link.source == (id2nodeMap.get(link.source.nodeId)))) {
			throw new IllegalArgumentException(String.format("Link %s source not found in topology.", link));
		}
		if (!(link.destination == (id2nodeMap.get(link.destination.nodeId)))) {
			throw new IllegalArgumentException(String.format("Link %s destination not found in topology.", link));
		}
		links.add(link);
	}

	public void addLink(String linkId,
						TopologyNode source, TopologyNode dest,
						String sourceAddress, String sourcePort,
						String destAddress, String destPort,
						double power, int bandwidth, boolean duplex) {
		TopologyLink newLink = new TopologyLink(linkId, source, dest, null, null, power, bandwidth);
		TopologyCp sourceCp = new TopologyCp(source, newLink, null, sourceAddress, sourcePort);
		TopologyCp destCp = new TopologyCp(dest, null, newLink, destAddress, destPort);
		newLink.sourceCp = sourceCp;
		newLink.destinationCp = destCp;
		addCp(source, sourceCp);
		addCp(dest, destCp);
		addLink(newLink);
		if (duplex) {
			TopologyLink reverseLink = new TopologyLink(
					"rev_" + linkId, dest, source, destCp, sourceCp, power, bandwidth
			);
			sourceCp.incomingLink = reverseLink;
			destCp.outgoingLink = reverseLink;
			addLink(reverseLink);
		}
	}

	public void addLink(String linkId,
						TopologyNode source, TopologyNode dest,
						String sourceAddress, String sourcePort,
						String destAddress, String destPort,
						double power, int bandwidth) {
		addLink(linkId, source, dest, sourceAddress, sourcePort, destAddress, destPort, power, bandwidth, true);
	}

	public TopologyCp getCpByAddress(String address) {
		return addressMap.get(address);
	}

	public TopologyCp getCpById(String cpId) {
		return id2cpMap.get(cpId);
	}

	@Override
	public String toString() {
		return String.format("Nodes: %s. Links: %s.", nodes, links);
	}
}
