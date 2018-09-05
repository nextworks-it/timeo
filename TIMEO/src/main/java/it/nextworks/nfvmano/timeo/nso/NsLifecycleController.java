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
package it.nextworks.nfvmano.timeo.nso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.CreateNsIdentifierRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.HealNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.QueryNsResponse;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.UpdateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.UpdateNsResponse;



/**
 * This class implements the REST APIs for the NS lifecycle
 * management service of the NFVO. 
 * The internal implementation of the service is implemented through
 * the NsLifecycleService.
 * 
 * @author nextworks
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/nfvo/nsLifecycle")
public class NsLifecycleController {

	private static final Logger log = LoggerFactory.getLogger(NsLifecycleController.class);
	
	@Autowired
	NsLifecycleService nsLifecycleService;
	
	public NsLifecycleController() { }
	
	@RequestMapping(value = "/ns", method = RequestMethod.POST)
	public ResponseEntity<?> createNsIdentifier(@RequestBody CreateNsIdentifierRequest request) {
		log.debug("Received create NS ID request");
		try {
			String response = nsLifecycleService.createNsIdentifier(request);
			return new ResponseEntity<String>(response, HttpStatus.CREATED);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ns/{nsId}/instantiate", method = RequestMethod.PUT)
	public ResponseEntity<?> instantiateNs(@RequestBody InstantiateNsRequest request) {
		log.debug("Received instantiate NS request");
		try {
			request.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		try {
			String response = nsLifecycleService.instantiateNs(request);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} 
	}
	
	@RequestMapping(value = "/ns/{nsId}/scale", method = RequestMethod.PUT)
	public ResponseEntity<?> scaleNs(@RequestBody ScaleNsRequest request) {
		log.debug("Received scale NS request");
		try {
			request.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		try {
			String response = nsLifecycleService.scaleNs(request);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ns/{nsId}/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateNs(@RequestBody UpdateNsRequest request) {
		log.debug("Received update NS request");
		try {
			request.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		try {
			UpdateNsResponse response = nsLifecycleService.updateNs(request);
			return new ResponseEntity<UpdateNsResponse>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ns/{nsId}", method = RequestMethod.GET)
	public ResponseEntity<?> queryNs(@PathVariable String nsId) {
		log.debug("Received query NS request");
		
		try {
			Map<String,String> parameters = new HashMap<String, String>();
			parameters.put("NS_ID", nsId);
			GeneralizedQueryRequest request = new GeneralizedQueryRequest(new Filter(parameters), new ArrayList<>());
			QueryNsResponse response = nsLifecycleService.queryNs(request);
			return new ResponseEntity<QueryNsResponse>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ns", method = RequestMethod.GET)
	public ResponseEntity<?> queryNs() {
		log.debug("Received query NS request");
		
		try {
			Map<String,String> parameters = new HashMap<String, String>();
			GeneralizedQueryRequest request = new GeneralizedQueryRequest(new Filter(parameters), new ArrayList<>());
			QueryNsResponse response = nsLifecycleService.queryNs(request);
			return new ResponseEntity<QueryNsResponse>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ns/{nsId}/terminate", method = RequestMethod.PUT)
	public ResponseEntity<?> terminateNs(@RequestBody TerminateNsRequest request) {
		log.debug("Received terminate NS request");
		try {
			request.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		try {
			String response = nsLifecycleService.terminateNs(request);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/ns/{nsId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteNsIdentifier(@PathVariable String nsId) {
		log.debug("Received delete NS ID request");
		try {
			nsLifecycleService.deleteNsIdentifier(nsId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/ns/{nsId}/heal", method = RequestMethod.PUT)
	public ResponseEntity<?> healNs(@RequestBody HealNsRequest request) {
		log.debug("Received heal NS request");
		try {
			request.isValid();
		} catch (MalformattedElementException e) {
			log.error("Malformatted request: " + e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		try {
			String response = nsLifecycleService.healNs(request);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (FailedOperationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformattedElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/operation/{operationId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOperationStatus(@PathVariable String operationId) {
		log.debug("Received get operation status request");
		try {
			OperationStatus result = nsLifecycleService.getOperationStatus(operationId);
			return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
		} catch (MethodNotImplementedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotExistingEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}
