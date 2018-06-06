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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.rc.ResourceSchedulingManager;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.DummySdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.OpenDaylightPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnController;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerType;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnRepository;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.TaskExecutorRemovePath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.TaskExecutorSetPowerStates;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.TaskExecutorSetupPath;
import it.nextworks.nfvmano.timeo.sbdriver.vim.DummyVimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.OpenStackVimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.Vim;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimRepository;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.repositories.VimRepoWrapper;

import org.springframework.web.client.RestTemplate;

/**
 * Class responsible to handle the instantiation of the south-bound drivers
 * 
 * @author nextworks
 *
 */
@Service
public class SbDriversManager {

	private static final Logger log = LoggerFactory.getLogger(SbDriversManager.class);
	
	public Map<String, VimPlugin> vimDrivers = new HashMap<>();
	public Map<String, SdnControllerPlugin> sdnControllerDrivers = new HashMap<>();
	
	@Value("${timeo.defaultVimType}")
	private String defaultVimType;

	@Value("${timeo.defaultSdnControllerType}")
	private String defaultSdnControllerType;
	
	@Autowired
	VimRepository vimRepository;
	
	@Autowired
	VimRepoWrapper vimRepoWrapper;
	
	@Autowired
	SdnRepository sdnRepository;
	
	@Autowired
	ResourceSchedulingManager resourceSchedulingManager;
	
	@Autowired
	ThreadPoolTaskExecutor taskExecutor;
	
	@Autowired
	TaskExecutorSetupPath taskExecutorSetupPath;
	
	@Autowired
	TaskExecutorRemovePath taskExecutorRemovePath;

	@Autowired
	TaskExecutorSetPowerStates taskExecutorSetPowerStates;

	private RestTemplate restTemplate = new RestTemplate();
	

	public SbDriversManager() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void initSbDrivers() {
		
		log.debug("Initializing VIM plugins");
		List<Vim> vims = vimRepository.findAll();
		for (Vim vim : vims) {
			try {
				addVim(vim);
			} catch (MalformattedElementException e) {
				log.warn("Malformed VIM: " + e.getMessage() + ". Skipping.");
				continue;
			}
		}
		log.debug("VIM plugins initialized");
		
		log.debug("Initializing SDN controller plugins");
		List<SdnController> controllers = sdnRepository.findAll();
		for (SdnController controller : controllers) {
			try {
				addSdnController(controller);
			} catch (MalformattedElementException e) {
				log.warn("Malformed SDN controller: " + e.getMessage() + ". Skipping.");
				continue;
			}
		}
		log.debug("SDN controller plugins initialized");
	}
	
	public void addVim(Vim vim) throws MalformattedElementException {
		VimPlugin vimPlugin = buildVimPlugin(vim);
		vimDrivers.put(vim.getVimId(), vimPlugin);
		log.debug("Loaded plugin for VIM " + vim.getVimId());
		resourceSchedulingManager.notifySbDriverChange(SbDriverType.SB_VIM);
	}
	
	public void removeVim(String vimId) throws NotExistingEntityException {
		if (vimDrivers.containsKey(vimId)) {
			vimDrivers.remove(vimId);
			log.debug("Removed plugin for VIM " + vimId);
			resourceSchedulingManager.notifySbDriverChange(SbDriverType.SB_VIM);
		} else throw new NotExistingEntityException("Plugin for VIM " + vimId + " not found");
	}
	
	public void addSdnController(SdnController sdnController) throws MalformattedElementException {
		SdnControllerPlugin sdnPlugin = buildSdnControllerPlugin(sdnController);
		sdnControllerDrivers.put(sdnController.getSdnControllerId(), sdnPlugin);
		log.debug("Loaded plugin for SDN controller " + sdnController.getSdnControllerId());
		resourceSchedulingManager.notifySbDriverChange(SbDriverType.SB_SDN_CONTROLLER);
	}
	
	public void removeSdnController (String sdnControllerId) throws NotExistingEntityException {
		if (sdnControllerDrivers.containsKey(sdnControllerId)) {
			sdnControllerDrivers.remove(sdnControllerId);
			log.debug("Removed plugin for SDN controller " + sdnControllerId);
			resourceSchedulingManager.notifySbDriverChange(SbDriverType.SB_SDN_CONTROLLER);
		} else throw new NotExistingEntityException("Plugin for SDN controller " + sdnControllerId + " not found");
	}
	
	private VimPlugin buildVimPlugin(Vim vim) throws MalformattedElementException {
		if (vim.getType().equals(VimType.DUMMY)) {
			return new DummyVimPlugin(vim, vimRepoWrapper);
		} else if (vim.getType().equals(VimType.OPENSTACK)) {
			return new OpenStackVimPlugin(vim, vimRepoWrapper);
		} else {
			throw new MalformattedElementException("Unsupported VIM type. Skipping.");
		}
	}
	
	private SdnControllerPlugin buildSdnControllerPlugin(SdnController controller) throws MalformattedElementException {
		if (controller.getSdnControllerType().equals(SdnControllerType.SDN_CONTROLLER_DUMMY)) {
			return new DummySdnControllerPlugin(controller);
		} else if (controller.getSdnControllerType().equals(SdnControllerType.SDN_CONTROLLER_OPENDAYLIGHT)) {
//			ApplicationContext context = new AnnotationConfigApplicationContext(ThreadPoolClass.class);
//		    ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean(ThreadPoolClass.taskExecutor);
//		    TaskExecutorSetupPath taskExecutorSetupPath = (TaskExecutorSetupPath) context.getBean("taskExecutorSetupPath");
//		    TaskExecutorRemovePath taskExecutorRemovePath = (TaskExecutorRemovePath) context.getBean("taskExecutorRemovePath");
			return new OpenDaylightPlugin(
					controller,
					taskExecutor,
					taskExecutorSetupPath,
					taskExecutorRemovePath,
					taskExecutorSetPowerStates,
					restTemplate
			);
		} else {
			throw new MalformattedElementException("Unsupported SDN controller type. Skipping.");
		}
	}
	
	public VimPlugin getVimPlugin(String vimId) throws NotExistingEntityException {
		log.debug("Getting VIM with ID " + vimId);
		if (vimDrivers.containsKey(vimId)) {
			return vimDrivers.get(vimId);
		} else throw new NotExistingEntityException("Plugin for VIM " + vimId + " not found");
	}
	
	public VimPlugin getDefaultVim() throws NotExistingEntityException {
		log.debug("Searching for default VIM.");
		List<Vim> vims = new ArrayList<>();
		if (defaultVimType.equals("DUMMY")) {
			vims = vimRepository.findByType(VimType.DUMMY); 
		} else if (defaultVimType.equals("OPENSTACK")) {
			vims = vimRepository.findByType(VimType.OPENSTACK);
		} else {
			throw new NotExistingEntityException("Unacceptable default VIM type.");
		}
		if ((vims == null) || (vims.isEmpty())) {
			throw new NotExistingEntityException("No VIMs found in DB");
		}
		String vimId = vims.get(0).getVimId();
		log.debug("Default VIM ID: " + vimId);
		if (vimDrivers.containsKey(vimId)) {
			return vimDrivers.get(vimId);
		} else throw new NotExistingEntityException("Plugin for VIM " + vimId + " not found");
	}
	
	public SdnControllerPlugin getDefaultSdnController() throws NotExistingEntityException {
		log.debug("Searching for default SDN controller.");
		List<SdnController> controllers = new ArrayList<>();
		if (defaultSdnControllerType.equals("DUMMY")) {
			controllers = sdnRepository.findBySdnControllerType(SdnControllerType.SDN_CONTROLLER_DUMMY); 
		} else if (defaultSdnControllerType.equals("OPENDAYLIGHT")) {
			controllers = sdnRepository.findBySdnControllerType(SdnControllerType.SDN_CONTROLLER_OPENDAYLIGHT);
		} else {
			throw new NotExistingEntityException("Unacceptable default SDN controller type.");
		}
		if ((controllers == null) || (controllers.isEmpty())) {
			throw new NotExistingEntityException("No SDN controller found in DB");
		}
		String sdnControllerId = controllers.get(0).getSdnControllerId();
		log.debug("Default SDN controller ID: " + sdnControllerId);
		if (sdnControllerDrivers.containsKey(sdnControllerId)) {
			return sdnControllerDrivers.get(sdnControllerId);
		} else throw new NotExistingEntityException("Plugin for SDN controller " + sdnControllerId + " not found");
	}
	

}
