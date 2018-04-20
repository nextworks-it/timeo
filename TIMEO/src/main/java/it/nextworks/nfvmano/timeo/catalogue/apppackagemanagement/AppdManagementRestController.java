package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.AppPackageInfo;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.OnboardAppPackageRequest;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.OnboardAppPackageResponse;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;

/**
 * This class implements the REST APIs for the AppD management
 * service of the NFVO. 
 * The internal implementation of the service is implemented through
 * the AppddManagementService.
 * 
 * @author nextworks
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/nfvo/appdManagement")
public class AppdManagementRestController {

	private static final Logger log = LoggerFactory.getLogger(AppdManagementRestController.class);
	
	@Autowired
	AppdManagementService appdManagement;
	
	public AppdManagementRestController() {	}
	
	@RequestMapping(value = "/appd/query", method = RequestMethod.POST)
	public ResponseEntity<?> queryApplicationPackage(@RequestBody GeneralizedQueryRequest request) {
		log.debug("Received query Application Package request");
		try {
			List<AppPackageInfo> response = appdManagement.queryApplicationPackage(request);
			return new ResponseEntity<List<AppPackageInfo>>(response, HttpStatus.OK);
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (NotExistingEntityException e) {
			log.error("Not existing entities: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (MethodNotImplementedException e) {
			log.error("Method not implemented. " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value = "/appd/subscription", method = RequestMethod.POST)
	public ResponseEntity<?> subscribe(@RequestBody SubscribeRequest request) {
		log.debug("Received appd subscribe request");
		try {
			String response = appdManagement.subscribeMecAppPackageInfo(request, new AppdManagementRestConsumer(request.getCallbackUri(), null));
			return new ResponseEntity<String>(response, HttpStatus.CREATED);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FailedOperationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/appd/subscription/{subscriptionId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> unsubscribe(@PathVariable String subscriptionId) {
		log.debug("Received appd unsubscribe request for subscription " + subscriptionId);
		try {
			appdManagement.unsubscribeMecAppPackageInfo(subscriptionId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/appd", method = RequestMethod.POST)
	public ResponseEntity<?> onboardAppPackage(@RequestBody OnboardAppPackageRequest request) {
		log.debug("Received on board App package request");
		try {
			OnboardAppPackageResponse response = appdManagement.onboardAppPackage(request);
			return new ResponseEntity<OnboardAppPackageResponse>(response, HttpStatus.CREATED);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (AlreadyExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (FailedOperationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/appd/{appPackageId}/enable", method = RequestMethod.PUT)
	public ResponseEntity<?> enableAppPackage(@PathVariable String appPackageId) {
		log.debug("Received request to enable App package " + appPackageId);
		try {
			appdManagement.enableAppPackage(appPackageId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/appd/{appPackageId}/disable", method = RequestMethod.PUT)
	public ResponseEntity<?> disableAppPackage(@PathVariable String appPackageId) {
		log.debug("Received request to disable App package " + appPackageId);
		try {
			appdManagement.disableAppPackage(appPackageId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/appd/{appPackageId}/delete", method = RequestMethod.PUT)
	public ResponseEntity<?> deleteAppPackage(@PathVariable String appPackageId) {
		log.debug("Received request to delete App package " + appPackageId);
		try {
			appdManagement.deleteAppPackage(appPackageId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//TODO: add methods to fetch App package, abort App package deletion
}
