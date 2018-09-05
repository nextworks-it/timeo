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
package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

/**
 * This class provides the JSON element for an authentication response through the Wrapper
 * 
 * @author Elian Kraja: e.kraja@nextworks.it
 *
 */
public class AuthenticationResponse {

	private String status;
	private String token;
	private String expires_at;
	private String error;
	
	
	
	public AuthenticationResponse() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param status Status of the request
	 * @param token Token generated during request. If empty, request failed
	 * @param expires_at Timestamp of the expiration for the given token
	 * @param error Error of the request. If not empty, request failed. 
	 */
	public AuthenticationResponse(String status, String token, String expires_at, String error){
		this.status = status;
		this.token = token;
		this.expires_at = expires_at;
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public String getToken() {
		return token;
	}

	public String getExpires_at() {
		return expires_at;
	}

	public String getError() {
		return error;
	}
	
	public String toString(){
		return ("{status: "+status+", token: "+token+", expires_at: "+ expires_at +", error: "+error+"}");
	}
}
