
package com.wipro.portal.exception;

public class AppleException extends Exception {

	public AppleException() {
		super();
	}

	public AppleException(String message) {
		super(message);
	}

	public AppleException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppleException(Throwable cause) {
		super(cause);
	}    

}
