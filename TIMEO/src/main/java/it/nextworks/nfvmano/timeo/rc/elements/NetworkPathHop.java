package it.nextworks.nfvmano.timeo.rc.elements;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This information element models a hop of a network path
 * 
 * @author nextworks
 *
 */
@Entity
public class NetworkPathHop {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private NetworkPath np;

	private int hopNumber;			//hop number					--> this can be removed
	private String nodeId;			//ID of the network node
	private String ingressPortId;	//ID of the ingress port
	private String egressPortId;	//ID of the egress port
	private String incomingLinkId;	//ID of the incoming link
	private String outgoingLinkId;	//ID of the outgoing link
	private int hopQueue;			//hop egress queue
	private boolean first;			//true if this is the first hop --> this can be removed
	private boolean last;			//true if this is the last hop	--> this can be removed
	
	public NetworkPathHop() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param hopNumber hop number
	 * @param nodeId ID of the network node
	 * @param ingressPortId ID of the ingress port
	 * @param egressPortId ID of the egress port
	 * @param incomingLinkId ID of the incoming link
	 * @param outgoingLinkId ID of the outgoing link
	 * @param hopQueue hop egress queue
	 * @param first true if this is the first hop
	 * @param last true if this is the last hop
	 */
	public NetworkPathHop(NetworkPath np,
			int hopNumber,
			String nodeId,
			String ingressPortId,
			String egressPortId,
			String incomingLinkId,
			String outgoingLinkId,
			int hopQueue,
			boolean first,
			boolean last) {
		this.np = np;
		this.hopNumber = hopNumber;
		this.nodeId = nodeId;
		this.incomingLinkId = incomingLinkId;
		this.ingressPortId = ingressPortId;
		this.egressPortId = egressPortId;
		this.outgoingLinkId = outgoingLinkId;
		this.hopQueue = hopQueue;
		this.first = first;
		this.last = last;
	}

	

	/**
	 * @return the hopNumber
	 */
	public int getHopNumber() {
		return hopNumber;
	}

	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}

	/**
	 * @return the ingressPortId
	 */
	public String getIngressPortId() {
		return ingressPortId;
	}

	/**
	 * @return the egressPortId
	 */
	public String getEgressPortId() {
		return egressPortId;
	}

	/**
	 * @return the incomingLinkId
	 */
	public String getIncomingLinkId() {
		return incomingLinkId;
	}

	/**
	 * @return the outgoingLinkId
	 */
	public String getOutgoingLinkId() {
		return outgoingLinkId;
	}

	/**
	 * @return the hopQueue
	 */
	public int getHopQueue() { return hopQueue; }

	/**
	 * @return the first
	 */
	public boolean isFirst() {
		return first;
	}

	/**
	 * @return the last
	 */
	public boolean isLast() {
		return last;
	}


	
	

}
