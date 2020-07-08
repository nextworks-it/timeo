package it.nextworks.nfvmano.timeo.ro;

import org.junit.Before;
import org.junit.Test;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.enums.PnfChangeType;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfExtCpInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Marco Capitani on 09/07/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class ResourceAllocationUtilitiesTest {

    private ResourceAllocationUtilities utils;

    @Before
    public void setUp() {
        utils = new ResourceAllocationUtilities(
                new HashMap<>(),
                new HashMap<>(),
                null,
                null
        );
    }

    @Test
    public void buildConfigurationData() {
        //vnf.<vnfd_id>.vdu.<vdu_id>.intcp.<extcp>.address
        //vnf.<vnfd_id>.vdu.<vdu_id>.hostname
        //vnf.<vnfd_id>.vdu.<vdu_id>.domainname
        //vnf.<vnfd_id>.vdu.<vdu_id>.extcp.<expcp>.floating
        //uservnf.<vnfd_id>.vdu.<vdu_id>.domainname	--> this is used for parameters set by the user
        //rcoutput.<param-name> --> this is used for parameters computed by the algorithm related to PNF config
        List<String> props = Arrays.asList(
//                "vnf.vnfdid.vdu.0.intcp.intcpid.address",
//                "vnf.vnfdid.vdu.0.hostname",
//                "vnf.vnfdid.vdu.0.domainname",
//                "vnf.vnfdid.vdu.0.extcp.extcpid.floating",
                "uservnf.vnfd.vdu.0.domainname",
                "rcoutput.connectionNo",
                "pnf.testpnfdId.cp.extcp.address"
        );
        Map<String, String> user = Collections.singletonMap("uservnf.vnfd.vdu.0.domainname", "domain");
        Map<String, String> rc = Collections.singletonMap("rcoutput.connectionNo", "1000");
        PnfExtCpInfo extCp =  new PnfExtCpInfo("extcp", "1.1.1.1");
        PnfInfo pnfInfo = new PnfInfo(null, //NsInfo
        		"testpnfid", //pnfId
        		"testpnfname", //pnfName
        		"testpnfdId", //pnfdId
        		"testpnfdinfoid", //pnfdInfoId
        		"testpnfprofileid", //pnfProfileId
        		new ArrayList<PnfExtCpInfo>(Arrays.asList(extCp)));
        List<PnfInfo> pnfs = Arrays.asList(pnfInfo);
        Map<String, String> stringStringMap;
		try {
			stringStringMap = utils.buildConfigurationData(props, user, rc, pnfs);
			assertEquals("domain", stringStringMap.get("uservnf.vnfd.vdu.0.domainname"));
	        //assertEquals("1000", stringStringMap.get("rcoutput.connectionNo"));
	        //pnf.<pnfd_id>.cp.<cp_id>.address
	        assertEquals("1.1.1.1", stringStringMap.get("pnf.testpnfdId.cp.extcp.address") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
        
    }
}