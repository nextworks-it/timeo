package it.nextworks.nfvmano.bluespace.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

@RestController
@CrossOrigin
@RequestMapping("/bluespace/algorithm")
public class BluespaceAlgorithmRestController {

	private static final Logger log = LoggerFactory.getLogger(BluespaceAlgorithmRestController.class);
	
	@Autowired
	BluespaceAlgorithmService algorithm;
	
	public BluespaceAlgorithmRestController() {	}
	
	@RequestMapping(value = "/computation", method = RequestMethod.POST)
	public ResponseEntity<?> computeResourceAllocation(@RequestBody BluespaceAlgorithmAllocationRequest request) {
		log.debug("Received request for blueSPACE resource computation");
		try {
			BluespaceAlgorithmAllocationResponse response = algorithm.computeAllocation(request);
			log.debug("Found solution.");
			Gson gson = new Gson();
			System.out.println(gson.toJson(response));
			return new ResponseEntity<BluespaceAlgorithmAllocationResponse>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			log.error("Error. Method not implemented.");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			log.error("Error. Elements in the request not found." + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			log.error("Error. Solution not found. " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (MalformattedElementException e) {
			log.error("Error. Request malformatted. " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error. Generic exception. "+ e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
