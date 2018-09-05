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
package it.nextworks.nfvmano.timeo.vnfm;

import java.util.List;
import java.util.Optional;

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

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;


@RestController
@CrossOrigin
@RequestMapping("/nfvo/vnfmManagement")
public class VnfmManagementController {

	private static final Logger log = LoggerFactory.getLogger(VnfmManagementController.class);
	
	@Autowired
	private VnfmInfoRepository vnfmInfoRepository;
	
	@Autowired 
	VnfmHandler vnfmHandler;
	
	public VnfmManagementController() {	}
	
	@RequestMapping(value = "/vnfm", method = RequestMethod.POST)
	public ResponseEntity<?> createVnfm(@RequestBody VnfmInfo vnfmInfo) {
		log.debug("Received request for new VNFM loading");
		if ((vnfmInfo == null) || (vnfmInfo.getName() == null)) {
			log.error("Malformatted VNFM - Not acceptable");
			return new ResponseEntity<String>("VNFM info or VNFM name null", HttpStatus.BAD_REQUEST);
		}
		String name = vnfmInfo.getName();
		if (vnfmInfoRepository.findByName(name).isPresent()) {
			log.error("A VNFM with the same name is already available in DB - Not acceptable");
			return new ResponseEntity<String>("VNFM already present in DB", HttpStatus.CONFLICT);
		}
		VnfmInfo vnfmInfoTarget = new VnfmInfo(vnfmInfo.getType(), vnfmInfo.getName());
		vnfmInfoRepository.saveAndFlush(vnfmInfoTarget);
		log.debug("VNFM uploaded in internal DB");
		try {
			vnfmHandler.addVnfm(vnfmInfoTarget);
		} catch (MalformattedElementException e) {
			log.error("Error while loading VNFM");
			vnfmInfoRepository.delete(vnfmInfoTarget);
			log.debug("VNFM removed from DB");
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/vnfms", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveVnfms() {
		log.debug("Received query for all VNFMs");
		List<VnfmInfo> vnfms = vnfmInfoRepository.findAll();
		return new ResponseEntity<List<VnfmInfo>>(vnfms, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vnfm/{vnfmName}", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveVnfm(@PathVariable String vnfmName) {
		log.debug("Received query for VNFM " + vnfmName);
		if (vnfmName == null) {
			log.error("Received VNFM query without VNFM name");
			return new ResponseEntity<String>("Query without VNFM name", HttpStatus.BAD_REQUEST);
		}
		Optional<VnfmInfo> vnfmInfoOpt = vnfmInfoRepository.findByName(vnfmName);
		if (vnfmInfoOpt.isPresent()) {
			log.info("VNFM found");
			return new ResponseEntity<VnfmInfo>(vnfmInfoOpt.get(), HttpStatus.OK);
		} else {
			log.error("VNFM not found in DB");
			return new ResponseEntity<String>("VNFM not available", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/vnfm/{vnfmName}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteVnfm(@PathVariable String vnfmName) {
		log.debug("Received delete request for VNFM " + vnfmName);
		if (vnfmName == null) {
			log.error("Received VNFM delete request without VNFM name");
			return new ResponseEntity<String>("Request without VNFM name", HttpStatus.BAD_REQUEST);
		}
		Optional<VnfmInfo> vnfmInfoOpt = vnfmInfoRepository.findByName(vnfmName);
		if (vnfmInfoOpt.isPresent()) {
			log.info("VNFM found");
			vnfmInfoRepository.delete(vnfmInfoOpt.get());
			log.info("VNFM deleted from DB");
			try {
				vnfmHandler.removeVnfm(vnfmName);
				log.debug("Removed VNFM from VNFM handler");
			} catch (NotExistingEntityException e) {
				log.warn("VNFM not found in VNFM handler. Skipping");
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			log.error("VNFM not found in DB");
			return new ResponseEntity<String>("VNFM not available", HttpStatus.NOT_FOUND);
		}
	}

}
