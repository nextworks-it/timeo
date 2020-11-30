package it.nextworks.nfvmano.timeo.rc.algorithms;

import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.SapData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnController;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerType;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiSdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.OpenStackVimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.Vim;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.repositories.VimRepoWrapper;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco Capitani on 29/11/18.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class PnfAlgoTest {

    private NsResourceAllocationAlgorithmInterface algorithm = new BluespaceStaticAlgorithm();

//    @Test
//    public void testAlgorithm() throws Exception {
//        InstantiateNsRequest request = new InstantiateNsRequest(
//                "test-instance",
//                "test-flavour",
//                Arrays.asList(new SapData[] {
//                        new SapData()
//                }),
//        );
//        Nsd nsd = new Nsd();
//        Map<Vnfd, Map<String, String>> vnfds = new HashMap<>();
//        Vim vim = new Vim(
//                "test-vim",
//                VimType.OPENSTACK,
//                "test-tenant",
//                "http://test.example.com",
//                "test-domain",
//                "test-user",
//                "test-password",
//                "test=keypair",
//                "test-ext-net",
//                "test-ext-router",
//                "test-provider",
//                9999,
//                "de:ad:de:ad:de:ad",
//                "test-phy-net"
//        );
//        VimPlugin vimPlugin = new OpenStackVimPlugin( // TODO to be mocked
//                vim,
//                new VimRepoWrapper()
//        );
//        SdnController sdnController = new SdnController(
//                "test-sdn",
//                SdnControllerType.SDN_CONTROLLER_TAPI,
//                "http://test.example.com",
//                "test-user",
//                "test-password",
//                "test-vim"
//        );
//        SdnControllerPlugin sdnPlugin = new TapiSdnControllerPlugin( // TODO to be mocked
//                sdnController,
//                new ThreadPoolTaskExecutor()
//        );
//        Map<String, Pnfd> pnfds = new HashMap<>();
//        Map<String, List<PnfInstance>> pnfInstances = new HashMap<>();
//
//        algorithm.computeNsResourceAllocationSolution(
//                request,
//                nsd,
//                vnfds,
//                vimPlugin,
//                sdnPlugin,
//                pnfds,
//                pnfInstances
//        );
//    }
}
