package com.wipro.portal.util;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
	public static final Map<String, String> errors = new HashMap<String, String>();

	static {
		
		errors.put("001", "User Name is required ");
        errors.put("002", "Password is required");
        
		errors.put("100", "EmployeeID is required ");
        errors.put("101", "Name is required");
        errors.put("102", "BusinessUnit is required");
        errors.put("103", "Status is required");
        errors.put("104", "ContactNo is required");
        errors.put("105","AIMMailID is required");
        errors.put("106","WiproMailID is  required");
        errors.put("107", "AIMChatID is required");
        errors.put("108", "AppleMailID is required");
        
        errors.put("109", "Visa ID is required. ");
        errors.put("110", "Visa Type is required. ");
        errors.put("111", "Visa Valid from date is required. ");
        errors.put("112", "Visa Valid to date is required. ");
        errors.put("113", "Country is required. ");
        
        errors.put("200", "Asset Name is required. ");
		errors.put("201", "Asset Id is required. ");
		errors.put("202", "Brand is required. ");
		errors.put("203", "IP is required. ");
        
        errors.put("300", "Training ID is required. ");
        errors.put("301", "Training Name is required. ");
        errors.put("302", "Training Description is required. ");
        errors.put("303", "Pre Requistics is required. ");
        errors.put("304", "Date is required. ");
        errors.put("305", "Time is required. ");
        errors.put("306", "Venue is required. ");
        errors.put("307", "Contact Person is required. ");

}
	public static String getMessage(String errorCode) {
		return errors.get(errorCode);
	}
}
