package com.lastminute.flights.exceptions;

/**
 * This class represents the custom exceptions
 * @author JLHM
 *
 */
public class SearchException extends Exception {

	private static final long serialVersionUID = 1L;
	private String error = "";

	public SearchException() {
		super();
	}
	
	public SearchException(String message) {
		this.setError(message);
	}
	@Override
	public String getMessage() {
		return "Error: "+ this.getError();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
