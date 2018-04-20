package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

/**
 * This class provides the JSON element for an authentication request through the Wrapper
 * 
 * @author Elian Kraja: e.kraja@nextworks.it
 *
 */
public class AuthenticationRequest {

	private String domain;
	private String username;
	private String password;
	private String project;
	private String url;

	public AuthenticationRequest(){
		
	}
	
	/**
	 * 
	 * @param domain Domain ID of the openstack installation to be used
 	 * @param username Username to be used 
	 * @param password Password to be used 
	 * @param project Project ID of the openstack installation to be used 
	 * @param url URL of keystone service to be used
	 */
	public AuthenticationRequest(
			String domain,
			String username,
			String password,
			String project,
			String url
			){
		this.domain = domain;
		this.username = username;
		this.password = password;
		this.project = project;
		this.url = url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
