package com.emse.semweb.beans;

import javax.servlet.http.HttpServletRequest;

public class WebAppUrl {

	private String URL;
	
	public WebAppUrl(HttpServletRequest request) {
		String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    this.URL = scheme + serverName + serverPort + contextPath;
	}
	
	public String getURL() {
		return this.URL;
	}
	
	
}
