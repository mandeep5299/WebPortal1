
package com.wipro.portal.util;

import java.text.SimpleDateFormat;

public class Validator {

	public static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setLenient(false);
	}

	public static boolean isBlank(String value) {
		boolean result = false;
		if (value == null) result = true;
		else if("".equals(value.trim())) result = true;
		return result;
	}

	public static boolean isBlank(int value) {
		return false;
	}
	
	public static boolean isBlank(long value) {
		return false;
	}
	
	public static boolean isNull(String value) {
		return (value == null) ? true : false;
	}

	public static boolean isDate(String value) {
		boolean result = false;
		try {
			sdf.parse(value);
			result = true;
		}
		catch(Exception ex) {}
		return result;
	}

	public static boolean isNumber(String value) {
		boolean result = false;
		try {
			Double.parseDouble(value);
			result = true;
		}
		catch(Exception ex) {}
		return result;
	}
}
