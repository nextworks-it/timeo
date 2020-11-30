package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.MonitoredData;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsAutoscalingRule;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.StringMetadata;
import it.nextworks.nfvmano.timeo.monitoring.elements.AutoScalingRulesWrapperTest;
import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
@Ignore
public class PnfInstanceMetadataTest {

	@Test

	public void test() {
		ObjectMapper mapper = new ObjectMapper();
		InputStream stringDataStream;
		try {
			stringDataStream = PnfInstanceMetadataTest.class.getClassLoader()
			        .getResource("pnfinstance.json")
			        .openStream();
			PnfInstance pnfInstance = mapper.readValue(stringDataStream, new TypeReference<PnfInstance>() {});
	        
	        PnfManagementService service = mock(PnfManagementService.class);
	        service.addPnfInstance(pnfInstance);
	       
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyExistingEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformattedElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}

}
