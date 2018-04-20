package it.nextworks.nfvmano.timeo.rc.algorithms.emma;


import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.algorithms.AbstractNsResourceAllocationAlgorithm;
import it.nextworks.nfvmano.timeo.rc.algorithms.AlgorithmType;
import it.nextworks.nfvmano.timeo.rc.algorithms.ComputationSolution;
import it.nextworks.nfvmano.timeo.rc.algorithms.Formatter;
import it.nextworks.nfvmano.timeo.rc.algorithms.RequestParser;
import it.nextworks.nfvmano.timeo.rc.algorithms.SolutionParser;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperPlugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Class implementing the POLITO algorithm
 *
 * @author nextworks
 */
public class EmmaNetCompAlgorithm extends AbstractNsResourceAllocationAlgorithm {

    private static final Logger log = LoggerFactory.getLogger(EmmaNetCompAlgorithm.class);

    public EmmaNetCompAlgorithm() {
        super(AlgorithmType.EMMA_NET_COMP);
    }

    public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
            InstantiateNsRequest request,
            Nsd nsd,
            Map<Vnfd, Map<String, String>> vnfds,
            VimPlugin vimPlugin,
            SdnControllerPlugin sdnPlugin,
            VimWrapperPlugin wrapper)
            throws NotExistingEntityException, ResourceAllocationSolutionNotFound {
        log.info("Received NS instantiation request {}.", request.getNsInstanceId());
        log.trace("START ALLOCATION COMP FOR NS {}.", request.getNsInstanceId());

        RequestParser requestParser;
        if (null != wrapper) {
            requestParser = new RequestParser(request, sdnPlugin, vimPlugin, nsd, vnfds, wrapper);
        } else {
            requestParser = new RequestParser(request, sdnPlugin, vimPlugin, nsd, vnfds);
        }
        Formatter formatter = requestParser.makeFormatter(LPFormatter::new);
        log.trace("Topology: {}", requestParser.networkTopology);
        log.trace("Logical links: {}", requestParser.logLinks);
        log.trace("Coefficients: {}", requestParser.coefficients);
        log.trace("Vm placement: {}", requestParser.vmPlacement);
        log.trace("Sizes: {}", requestParser.sizes);

        ComputationSolution solution = formatter.solve();
        SolutionParser solutionParser = new SolutionParser(
                solution,
                requestParser.getVms(),
                requestParser.getSap2vldId(),
                request.getNsInstanceId()
        );
        NsResourceSchedulingSolution schedSolution = solutionParser.buildSolution();
        log.info("NS instantiation request {} solution ready.", request.getNsInstanceId());
        log.trace("END ALLOCATION COMP FOR NS {}.", request.getNsInstanceId());
        return schedSolution;
    }

    @Override
    public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
            InstantiateNsRequest request,
            Nsd nsd,
            Map<Vnfd, Map<String, String>> vnfds,
            VimPlugin vimPlugin,
            SdnControllerPlugin sdnPlugin
    ) throws NotExistingEntityException, ResourceAllocationSolutionNotFound {
        return computeNsResourceAllocationSolution(
                request,
                nsd,
                vnfds,
                vimPlugin,
                sdnPlugin,
                null
        );
    }
}
