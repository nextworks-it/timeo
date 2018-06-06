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
package it.nextworks.nfvmano.timeo.sbdriver;

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
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnController;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnRepository;
import it.nextworks.nfvmano.timeo.sbdriver.vim.Vim;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimRepository;

@RestController
@CrossOrigin
@RequestMapping("/nfvo/vimManagement")
public class VimManagementController {
	
	private static final Logger log = LoggerFactory.getLogger(VimManagementController.class);

	@Autowired
	private SbDriversManager sbDriversManager;
	
	@Autowired
	private VimRepository vimRepository;
	
	@Autowired
	private SdnRepository sdnRepository;
	
	public VimManagementController() { }
	
	@RequestMapping(value = "/sdn", method = RequestMethod.POST)
	public ResponseEntity<?> createSdnController(@RequestBody SdnController controller) {
		log.debug("Received request for new SDN controller loading");
		if ((controller == null) || (controller.getSdnControllerId() == null)) {
			log.error("Malformatted SDN controller - Not acceptable");
			return new ResponseEntity<String>("SDN controller or SDN controller ID null", HttpStatus.BAD_REQUEST);
		}
		String sdnControllerId = controller.getSdnControllerId();
		if (sdnRepository.findBySdnControllerId(sdnControllerId).isPresent()) {
			log.error("An SDN controller with the same ID is already available in DB - Not acceptable");
			return new ResponseEntity<String>("SDN controller already present in DB", HttpStatus.CONFLICT);
		}
		log.debug("ID: " + controller.getSdnControllerId() + " - "
				+ " type "+ controller.getSdnControllerType().toString() +" - "
						+ "URL: " + controller.getUrl() +" - "
								+ "Username: " + controller.getUsername() + " - "
										+ "Password: "+ controller.getPassword() + " - VIMid: "+ controller.getVimId());
		SdnController sdnTarget = new SdnController(controller.getSdnControllerId(), controller.getSdnControllerType(), 
				controller.getUrl(), controller.getUsername(), controller.getPassword(), controller.getVimId());
		sdnRepository.saveAndFlush(sdnTarget);
		log.debug("SDN controller uploaded in internal DB");
		try {
			sbDriversManager.addSdnController(sdnTarget);
		} catch (MalformattedElementException e) {
			log.error("Error while loading SDN controller plugin");
			sdnRepository.delete(sdnTarget);
			log.debug("SDN controller removed from DB");
		}
		return new ResponseEntity<String>(sdnControllerId, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/vim", method = RequestMethod.POST)
	public ResponseEntity<?> createVim(@RequestBody Vim vim) {
		log.debug("Received request for new VIM loading");
		if ((vim == null) || (vim.getVimId() == null)) {
			log.error("Malformatted VIM - Not acceptable");
			return new ResponseEntity<String>("VIM or VIM ID null", HttpStatus.BAD_REQUEST);
		}
		String vimId = vim.getVimId();
		if (vimRepository.findByVimId(vimId).isPresent()) {
			log.error("A VIM instance with the same ID is already available in DB - Not acceptable");
			return new ResponseEntity<String>("VIM ID already present in DB", HttpStatus.CONFLICT);
		}
		Vim vimTarget = new Vim(vimId, vim.getType(), vim.getTenant(), vim.getUrl(), vim.getDomain(), 
				vim.getUsername(), vim.getPassword(), vim.getKeyPair(), vim.getDefaultExternalNetworkId(), 
				vim.getDefaultExternalRouterId(), vim.getProviderId(), vim.getWrapperIp(), vim.getWrapperPort(), vim.getNetworkNodeMacAddress(), vim.getPhysnet());
		vimRepository.saveAndFlush(vimTarget);
		log.debug("VIM uploaded in internal DB");
		try {
			sbDriversManager.addVim(vimTarget);
		} catch (MalformattedElementException e) {
			log.error("Error while loading VIM plugin");
			vimRepository.delete(vimTarget);
			log.debug("VIM removed from DB");
		}
		return new ResponseEntity<String>(vimId, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/vim", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveVims() {
		log.debug("Received query for all VIMs");
		List<Vim> vims = vimRepository.findAll();
		return new ResponseEntity<List<Vim>>(vims, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vim/{vimId}", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveVim(@PathVariable String vimId) {
		log.debug("Received query for VIM " + vimId);
		if (vimId == null) {
			log.error("Received VIM query without VIM ID");
			return new ResponseEntity<String>("Query without VIM ID", HttpStatus.BAD_REQUEST);
		}
		Optional<Vim> vimOpt = vimRepository.findByVimId(vimId);
		if (vimOpt.isPresent()) {
			log.info("VIM found");
			return new ResponseEntity<Vim>(vimOpt.get(), HttpStatus.OK);
		} else {
			log.error("VIM not found in DB");
			return new ResponseEntity<String>("VIM not available", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/sdn", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveSdnControllers() {
		log.debug("Received query for all SDN controllers");
		List<SdnController> sdnControllers = sdnRepository.findAll();
		return new ResponseEntity<List<SdnController>>(sdnControllers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sdn/{sdnControllerId}", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveSdnController(@PathVariable String sdnControllerId) {
		log.debug("Received query for SDN controller " + sdnControllerId);
		if (sdnControllerId == null) {
			log.error("Received SDN controller query without SDN controller ID");
			return new ResponseEntity<String>("Query without SDN controller ID", HttpStatus.BAD_REQUEST);
		}
		Optional<SdnController> sdnControllerOpt = sdnRepository.findBySdnControllerId(sdnControllerId);
		if (sdnControllerOpt.isPresent()) {
			log.info("SDN controller found");
			return new ResponseEntity<SdnController>(sdnControllerOpt.get(), HttpStatus.OK);
		} else {
			log.error("SDN controller not found in DB");
			return new ResponseEntity<String>("SDN controller not available", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/vim/{vimId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteVim(@PathVariable String vimId) {
		log.debug("Received delete request for VIM " + vimId);
		if (vimId == null) {
			log.error("Received VIM delete request without VIM ID");
			return new ResponseEntity<String>("Delete request without VIM ID", HttpStatus.BAD_REQUEST);
		}
		Optional<Vim> vimOpt = vimRepository.findByVimId(vimId);
		if (vimOpt.isPresent()) {
			log.info("VIM found");
			vimRepository.delete(vimOpt.get());
			log.info("VIM deleted from DB");
			try {
				sbDriversManager.removeVim(vimId);
				log.debug("Removed VIM plugin");
			} catch (NotExistingEntityException e) {
				log.warn("VIM plugin not found");
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			log.error("VIM not found in DB");
			return new ResponseEntity<String>("VIM not available", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/sdn/{sdnControllerId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSdnController(@PathVariable String sdnControllerId) {
		log.debug("Received delete request for SDN controller " + sdnControllerId);
		if (sdnControllerId == null) {
			log.error("Received SDN controller delete request without SDN controller ID");
			return new ResponseEntity<String>("Delete request without SDN controller ID", HttpStatus.BAD_REQUEST);
		}
		Optional<SdnController> sdnControllerOpt = sdnRepository.findBySdnControllerId(sdnControllerId);
		if (sdnControllerOpt.isPresent()) {
			log.info("SDN controller found");
			sdnRepository.delete(sdnControllerOpt.get());
			log.info("SDN controller deleted from DB");
			try {
				sbDriversManager.removeSdnController(sdnControllerId);
				log.debug("Removed SDN controller plugin");
			} catch (NotExistingEntityException e) {
				log.warn("SDN controller plugin not found");
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			log.error("SDN controller not found in DB");
			return new ResponseEntity<String>("SDN controller not available", HttpStatus.NOT_FOUND);
		}
	}
	
}
