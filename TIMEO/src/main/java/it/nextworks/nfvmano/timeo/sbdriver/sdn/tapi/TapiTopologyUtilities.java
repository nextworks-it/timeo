package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;


import io.swagger.client.model.*;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TapiTopologyUtilities {
    private static final Logger log = LoggerFactory.getLogger(TapiTopologyUtilities.class);

    public static NetworkTopology translateTapiTopology(Topology source, ContextSchema contextSchema) throws NotExistingEntityException{


        log.debug("Translating TAPI topology into TIMEO topology format.");
        log.debug("Source TAPI topology: " + source.toString());
        NetworkTopology target = translateTapiNodes(source, contextSchema);

        List<Link> links = source.getLink();

        log.debug("The TAPI topology has " + source.getNode().size() + " nodes and " + links.size() + " links.");

        List<io.swagger.client.model.Topology.LayerProtocolNameEnum> origProtocolLayers = source.getLayerProtocolName();
        Set<LayerProtocol> supportedProtocolLayers = new HashSet<>();
        for (Topology.LayerProtocolNameEnum lp : origProtocolLayers) {
            supportedProtocolLayers.add(convertLayerProtocol(lp));
        }



        log.debug("Adding links to topology");
        for (Link l : links) {
            String linkId = l.getUuid();
            List<NodeEdgePointRef> neprs = l.getNodeEdgePoint();
            List<String> neps = new ArrayList<>();
            for (NodeEdgePointRef n : neprs) {
                neps.add(n.getNodeEdgePointUuid());
            }
            String srcPortId = getIdFromUrl(neps.get(0));
            String srcNodeId = getNodeFromPortId(target.nodes, srcPortId).nodeId;
            String dstPortId = getIdFromUrl(neps.get(1));
            String dstNodeId = getNodeFromPortId(target.nodes, dstPortId).nodeId;
            if ((srcNodeId != null) && (dstNodeId != null)) {
                TapiTopologyLink targetLink = new TapiTopologyLink(linkId,
                        target.fetchNodeById(srcNodeId),
                        target.fetchNodeById(dstNodeId),
                        target.getCpById(srcPortId),
                        target.getCpById(dstPortId));
                log.debug("Created link with ID " + linkId + " between port " + srcPortId + " and port " + dstPortId);
                targetLink.setDirection(l.getDirection());
                if (l.getAvailableCapacity() != null) {
                    targetLink.setAvailableCapacity(l.getAvailableCapacity());
                    log.debug("Set available capacity");
                }
                if (l.getTotalPotentialCapacity() != null) {
                    targetLink.setTotalPotentialCapacity(l.getTotalPotentialCapacity());
                    log.debug("Set total potential capacity");
                }
                if (l.getLatencyCharacteristic() != null) {
                    targetLink.setLatencyCharacteristic(l.getLatencyCharacteristic());
                    log.debug("Set latency");
                }
                if (l.getLayerProtocolName() != null) {
                  /*
                    for (Link.LayerProtocolNameEnum lp : l.getLayerProtocolName()) {
                        supportedProtocolLayers.add(convertLayerProtocol(lp));
                    }
                    targetLink.setLayerProtocol(supportedProtocolLayers);
                    log.debug("Set protocol layers");

                   */
                }
                target.addLink(targetLink);
                target.getCpById(srcPortId).setOutgoingLink(targetLink);
                target.getCpById(dstPortId).setIncomingLink(targetLink);
            } else {
                log.error("Source or destination node not found for link " + linkId + ". Skipping it.");
            }
        }
        log.debug("All links have been added to the topology");

        return target;
    }


    /**
     *
     * @param contextSchema
     * @return a map where the key is the Id of the connectivity service while the value contains the two SIPs of the connection
     */
    public static Map<String, List<String>> getObfnActivePaths(ContextSchema contextSchema){

        Map<String, List<String>> values = new HashMap<>();
        ConnectivityContext connectivityContext = contextSchema.getConnectivityContext();
        List<ConnectivityService> connectivityServices = connectivityContext.getConnectivityService();
        for(ConnectivityService connectivityService: connectivityServices){
            ArrayList<String> sips  = new ArrayList<>();
            String sip1 = connectivityService.getEndPoint().get(0).getLocalId();
            String sip2 = connectivityService.getEndPoint().get(1).getLocalId();
            TapiCpDirection port1direction = getTapiPortDirection(contextSchema, sip1);
            if(port1direction.equals(TapiCpDirection.INPUT)){
                sips.add(sip1);
                sips.add(sip2);
            }else if(port1direction.equals(TapiCpDirection.OUTPUT)){
                sips.add(sip2);
                sips.add(sip1);
            }
            values.put(connectivityService.getUuid(), sips);

        }
        return values;
    }

    public static NetworkTopology translateTapiNodes(Topology source, ContextSchema contextSchema) throws NotExistingEntityException{
        List<Node> nodes = source.getNode();
        //if (links == null) throw new NotExistingEntityException("Topology without links");
        if (nodes == null) throw new NotExistingEntityException("Topology without nodes");
        NetworkTopology target = new NetworkTopology(new ArrayList<>(), new ArrayList<>());
        log.debug("Adding nodes to topology");
        for (Node n : nodes) {
            String nodeId = n.getUuid();
            //AROF j.brenes: AROF API nodes do not responde with the layer protocol supported, using
            //the one supported by the topology
            //List<Node.LayerProtocolNameEnum> origProtocolLayers = n.getLayerProtocolName();

            List<TopologyCp> connectionPoints = new ArrayList<>();

            TopologyNode targetNode = new TopologyNode(nodeId, null);
            List<OwnedNodeEdgePointSchema> ports = n.getOwnedNodeEdgePoint();

            for (OwnedNodeEdgePointSchema p : ports) {
                OwnedNodeEdgePointSchema.LayerProtocolNameEnum proto = p.getLayerProtocolName();
                String portId = p.getUuid();

                if (proto.equals(OwnedNodeEdgePointSchema.LayerProtocolNameEnum.ETH)) {
                    TapiTopologyCp tapiCp;
                    tapiCp = new TapiTopologyCp(targetNode, null, null, null, portId);
                    log.debug("Created ETH port with ID " + portId);

                }else if (proto.equals(OwnedNodeEdgePointSchema.LayerProtocolNameEnum.PHOTONIC_MEDIA)) {

                    List<String> protocolLayerQualifiers = p.getSupportedCepLayerProtocolQualifier();
                    if(protocolLayerQualifiers.contains("tapi-arof:PHOTONIC_LAYER_QUALIFIER_AROF")) {
                        TapiTopologyCp tapiCp;
                        tapiCp = new TapiTopologyArofCp(targetNode, null, null, null, portId);
                        String sipUuid = p.getMappedServiceInterfacePoint().get(0).getServiceInterfacePointUuid();
                        ((TapiTopologyArofCp) tapiCp).setArofServiceInterfacePointSpec(getArofConnectionEndPointSpec(contextSchema, sipUuid));
                        log.debug("Created TAPI port with ID " + portId);
                        target.addCp(targetNode, tapiCp);
                        connectionPoints.add(tapiCp);
                    }else if (protocolLayerQualifiers.contains("tapi-obfn:PHOTONIC_LAYER_QUALIFIER_OBFN")){
                        for(ServiceInterfacePointRef sipRef: p.getMappedServiceInterfacePoint()){
                            TapiObfnCpSpec cpSpec = getTapiObfnCpSpec(contextSchema, sipRef.getServiceInterfacePointUuid() );
                            List<Integer> usedBeams = getObfnUsedBeams(sipRef.getServiceInterfacePointUuid(), contextSchema);
                            TapiCpDirection direction = getTapiPortDirection(contextSchema, sipRef.getServiceInterfacePointUuid());
                            TapiTopologyCp tapiCp = new TapiTopologyObfnCp(targetNode, sipRef.getServiceInterfacePointUuid(), cpSpec, direction, usedBeams);
                            log.debug("Created TAPI port with ID " + portId);
                            target.addCp(targetNode, tapiCp);
                            connectionPoints.add(tapiCp);
                        }

                    }else {
                        TapiTopologyCp tapiCp = new TapiTopologySdmCp(targetNode, null, null, null, portId);
                        //TODO: add info of the port
                        log.debug("Created SDM port with ID " + portId);
                        connectionPoints.add(tapiCp);
                        target.addCp(targetNode, tapiCp);
                    }

                } else {
                    TapiTopologyCp tapiCp = new TapiTopologyCp(targetNode, null, null, null, portId);
                    log.debug("Created generalized port with ID " + portId);
                    target.addCp(targetNode, tapiCp);
                }
                log.debug("Added ports to topology");
                targetNode.setCps(new HashSet<>(connectionPoints));
                target.addNode(targetNode);
				/*
				List<ServiceInterfacePointRef> sips = p.getMappedServiceInterfacePoint();
				if (sips != null) {
					for (ServiceInterfacePointRef sip : sips) {
						TapiTopologyCp tapiCp = new TapiTopologyCp(targetNode, null, null, "", sip.getServiceInterfacePointUuid());
						tapiCp.addSip(sip.getServiceInterfacePointUuid());
						log.debug("Added mapped Service Interface Point " + sip.getServiceInterfacePointUuid() + " to port.");
					}
				}*/


            }
        }
        log.debug("All nodes and ports have been added to the topology");
        return target;

    }

    private static TapiObfnCpSpec getTapiObfnCpSpec(ContextSchema contextSchema, String sipUuid) {
        Optional<ServiceInterfacePoint> optSip = contextSchema.getServiceInterfacePoint().stream()
                .filter(s -> s.getUuid().equals(sipUuid) )
                .findFirst();
        if(optSip.isPresent()){
            ObfnServiceInterfacePointSpec obfnSpec = optSip.get().getObfnServiceInterfacePointSpec();
            SupportedWavelength supWavelength = obfnSpec.getSupportedWavelength();

            String adjustmentGranularity = null;
            if (supWavelength.getFrequencyConstraint().getAdjustmentGranularity()!=null ){
                adjustmentGranularity = supWavelength.getFrequencyConstraint().getAdjustmentGranularity().toString();
            }
            TapiFrequencyConstraint fc = new TapiFrequencyConstraint(adjustmentGranularity,
                    supWavelength.getFrequencyConstraint().getGridType().toString());
            TapiSupportedWavelength supportedWavelength = new TapiSupportedWavelength(supWavelength.getUpperFrequency(),
                    supWavelength.getLowerFrequency(),  fc);


            return new TapiObfnCpSpec(obfnSpec.getSupportedLowerAngle(),
                    obfnSpec.getSupportedUpperAngle(),
                    obfnSpec.getSupportedMinWidth(),
                    obfnSpec.getSupportedMaxWidth(),
                    obfnSpec.getSupportedBeams(),
                    supportedWavelength);

        }else{
            log.debug("Failed to retrieve OBFN ServiceInterfacePointSpec");
            return null;
        }

    }

    private static TopologyNode getNodeFromPortId(List<TopologyNode> topologyNodes, String cpId){
        for(TopologyNode tn : topologyNodes){
            for (TopologyCp tCp: tn.cps){
                if(tCp.getCpId().equals(cpId)){
                    return tn;
                }
            }
        }
        return null;
    }

    public static LayerProtocol convertLayerProtocol(Topology.LayerProtocolNameEnum source) {
        if (source.equals(Node.LayerProtocolNameEnum.ETH)) return LayerProtocol.ETHERNET;
        else if (source.equals(Node.LayerProtocolNameEnum.PHOTONIC_MEDIA)) return LayerProtocol.SDM;
        else {
            log.warn("Unsopported layer protocol. Setting to NOT_SPECIFIED.");
            return LayerProtocol.NOT_SPECIFIED;
        }
    }

    public static ArofServiceInterfacePointSpec getArofConnectionEndPointSpec(ContextSchema contextSchema, String sipUuid ) {

    	Optional<ServiceInterfacePoint> optServiceInterfacePoint = contextSchema.getServiceInterfacePoint().stream()
    		.filter(s -> s.getUuid().equals(sipUuid) )
            .findFirst();
		if(optServiceInterfacePoint.isPresent()){
            return optServiceInterfacePoint.get().getArofServiceInterfacePointSpec();

        }else{
            log.debug("Failed to retrieve AROF ServiceInterfacePointSpec");
            return null;
        }



    }



    public static List<Integer> getObfnUsedBeams(String ingressSip, ContextSchema contextSchema){
        log.debug("Determining used beams for:"+ingressSip);
        List<Integer> usedBeams = new ArrayList<>();
        for(ConnectivityService cs : contextSchema.getConnectivityContext().getConnectivityService()){
            String sip1 = cs.getEndPoint().get(0).getServiceInterfacePoint().getServiceInterfacePointUuid();
            String sip2 = cs.getEndPoint().get(1).getServiceInterfacePoint().getServiceInterfacePointUuid();
            log.debug("CS sips: "+sip1+" "+sip2);
            if(sip1.equals(ingressSip) || sip2.equals(ingressSip) ){
                for(Obfn obfnSpec : cs.getObfnConnectivityConstraintSpec().getObfnPool()){
                   usedBeams.add(new Integer(obfnSpec.getObfnId()));
                }
            }
        }
        log.debug("Found used beams: "+usedBeams);
        return usedBeams;


    }

    public static TapiCpDirection getTapiPortDirection(ContextSchema contextSchema, String sipUuid){
        Optional<ServiceInterfacePoint> optSip = contextSchema.getServiceInterfacePoint().stream()
                .filter(s -> s.getUuid().equals(sipUuid) )
                .findFirst();
        if(optSip.isPresent()){
            List<NameAndValue> names = optSip.get().getName();
            for(NameAndValue aux : names){
                if(aux.getValueName().equals("port-direction"))
                    return TapiCpDirection.valueOf(aux.getValue());
            }
            log.debug("Could not find tapi port direction configuration");
            return TapiCpDirection.OTHER;
        }else{
            log.debug("Failed to retrieve ServiceInterfacePointSpec, using PortDirection OTHER");
            return TapiCpDirection.OTHER;
        }
    }




    private static LayerProtocol convertLayerProtocol(Link.LayerProtocolNameEnum source) {
        if (source.equals(Link.LayerProtocolNameEnum.ETH)) return LayerProtocol.ETHERNET;
        else if (source.equals(Link.LayerProtocolNameEnum.PHOTONIC_MEDIA)) return LayerProtocol.SDM;
        else {
            log.warn("Unsopported layer protocol. Setting to NOT_SPECIFIED.");
            return LayerProtocol.NOT_SPECIFIED;
        }
    }

    private static LayerProtocol convertLayerProtocol(LayerProtocol source) {
        if (source.equals(Link.LayerProtocolNameEnum.ETH)) return LayerProtocol.ETHERNET;
        else if (source.equals(Link.LayerProtocolNameEnum.PHOTONIC_MEDIA)) return LayerProtocol.SDM;
        else {
            log.warn("Unsopported layer protocol. Setting to NOT_SPECIFIED.");
            return LayerProtocol.NOT_SPECIFIED;
        }
    }


    private static String getIdFromUrl(String url) {
        String[] parts = url.split("/");
        String uuid = parts[parts.length - 1];
        return uuid;
    }



}
