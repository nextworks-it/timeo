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
package it.nextworks.nfvmano.timeo.vnfm.sdkimpl;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;


public class CloudInitGenerator {

	private static final Logger log = LoggerFactory.getLogger(CloudInitGenerator.class);

	public CloudInitGenerator() {

	}
	
	/**
	 * Method to create the cloud init script with the right parameters
	 * 
	 * @param originalScript script to be modified
	 * @param hostname hostname to be included in the script
	 * @param domainName domain name to be included in the script
	 * @param ipAddresses IP addresses to be included in the script
	 * @return the modified cloud init script
	 */
	public static String fillInCloudInitScript(String originalScript, String hostname, String domainName, Map<String, String> ipAddresses, String gatewayIpManagement, Map<String, String> userConfig, Map<String, String > floatingIps, Map<String, String> gwAddresses) {

		log.debug("Processing cloud init script");
		log.debug("Original script: \n" + originalScript);
		log.debug("Hostname: " + hostname);
		log.debug("Domain name: " + domainName);
		log.debug("IP Addresses: ");
		for (Map.Entry<String, String> e : ipAddresses.entrySet()) {
			log.debug("CP: " + e.getKey() + " - IP address: " + e.getValue());
		}
		log.debug("Management network - gateway IP address: " + gatewayIpManagement);
		for (Map.Entry<String, String> e : floatingIps.entrySet()) {
			log.debug("CP: " + e.getKey() + " - Floating IP address: " + e.getValue());
		}
		
		String resultingScript = CloudInitGenerator.modifyParameter(originalScript, "$$config$$hostname", hostname);
		
		List<String> userConfigDomain = userConfig.entrySet()
				.stream()
				.filter(entry -> (entry.getKey().startsWith("uservnf") && (entry.getKey().endsWith("domainname"))))
				.map(Map.Entry<String,String>::getValue)
				.collect(Collectors.toList());
		Map<String, String> userVnfParameters = userConfig.entrySet()
				.stream()
				.filter(entry->(entry.getKey().startsWith("uservnf")))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		if (!(userConfigDomain.isEmpty())) {
			String d = userConfigDomain.get(0);
			log.debug("The domain name is set from the user: " + d);
			resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$domainname", d);
		} else {
			log.debug("The domain name is not set from the user. The default static one is used.");
			resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$domainname", domainName);
		}
		for (Map.Entry<String, String> e : ipAddresses.entrySet()) {
			resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$intCp." + e.getKey() + ".address", e.getValue());
		}
		for (Map.Entry<String, String> e : floatingIps.entrySet()) {
			resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$extCp." + e.getKey() + ".floating", e.getValue());
		}
		for (Map.Entry<String, String> e : gwAddresses.entrySet()) {
			resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$extCp." + e.getKey() + ".gateway", e.getValue());
		}
		for (Map.Entry<String, String> e : userVnfParameters.entrySet()){

				resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$" + e.getKey(), e.getValue());


		}
		resultingScript = CloudInitGenerator.modifyParameter(resultingScript, "$$config$$managementGw", gatewayIpManagement);
		log.debug("Resulting cloud init script: \n" + resultingScript);
		return resultingScript;
	}
	
	/**
	 * Method to substitute a parameter with its value. It returns the modified script.
	 * 
	 * @param originalScript script to be modified
	 * @param parameter type of parameter to be substituted
	 * @param parameterValue value of the parameter
	 * @return the modified script
	 */
	private static String modifyParameter(String originalScript, String parameter, String parameterValue) {
		log.debug("Setting parameter " + parameter + " to " + parameterValue);
		String p = createRegex(parameter);
		log.debug("Regex: " + p);
		String result = originalScript.replaceAll(p, parameterValue);
		log.debug("Result \n:" + result);
		return result;
	}
	
	/**
	 * Method to create a string compliant with the regular expression format
	 * 
	 * @param s	string to be modified
	 * @return	modified string
	 */
	private static String createRegex(String s) {
		StringBuilder b = new StringBuilder();
		for(int i=0; i<s.length(); ++i) {
			char ch = s.charAt(i);
			if ("\\.^$|?*+[]{}()".indexOf(ch) != -1)
				b.append('\\').append(ch);
			else if (Character.isLetter(ch))
				//b.append("[A-Za-z]");
				b.append(ch);
			else if (Character.isDigit(ch))
				//b.append("\\d");
				b.append(ch);
			else
				b.append(ch);
		}
		return b.toString();
	}




}
