
package com.wipro.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

public class AppService {

	protected String designCenter;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ModelMap modelMap;

	public String getDesignCenter() {
		return this.designCenter;
	}

	public void setDesignCenter(String designCenter) {
		this.designCenter = designCenter;
	}

	public ModelMap getModelMap() {
		return this.modelMap;
	}

	public void setModelMap(ModelMap modelMap) {
		this.modelMap = modelMap;
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
