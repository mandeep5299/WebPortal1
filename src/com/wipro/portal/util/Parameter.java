package com.wipro.portal.util;

import javax.servlet.http.HttpServletRequest;

public class Parameter {

    HttpServletRequest request;

    public Parameter(HttpServletRequest request) {
        this.request = request;
    }

    public String getString(String name) {
        return getString(name, null);
    }

    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return (value == null) ? defaultValue : value;
    }

    public Long getLong(String name, long defaultValue) {
        String value = request.getParameter(name);
        return (value == null) ? new Long(defaultValue) : Long.parseLong(value);
    }

    public int getint(String name,int defaultValue) {
    	  // TODO Auto-generated method stub
    	  String value = request.getParameter(name);
    	        return (value == null) ? new Integer(defaultValue) : Integer.parseInt(value);
    	 }

}