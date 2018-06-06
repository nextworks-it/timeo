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
package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SdnController {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	private String sdnControllerId;
	private SdnControllerType sdnControllerType;
	private String url;
	private String username;
	private String password;
	private String vimId;

	public SdnController() {
		// TODO Auto-generated constructor stub
	}
	
	public SdnController(String sdnControllerId,
			SdnControllerType sdnControllerType, 
			String url,
			String username,
			String password,
			String vimId) {
		this.sdnControllerId = sdnControllerId;
		this.sdnControllerType = sdnControllerType;
		this.url = url;
		this.username = username;
		this.password = password;
		this.vimId = vimId;
	}

	/**
	 * @return the sdnControllerId
	 */
	public String getSdnControllerId() {
		return sdnControllerId;
	}

	/**
	 * @return the sdnControllerType
	 */
	public SdnControllerType getSdnControllerType() {
		return sdnControllerType;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return the VIM ID
	 */
	public String getVimId() {
		return vimId;
	}
	
}
