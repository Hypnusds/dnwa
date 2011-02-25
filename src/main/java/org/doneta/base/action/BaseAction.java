package org.doneta.base.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseAction {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
		this.session = this.request.getSession();
	}
	
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
