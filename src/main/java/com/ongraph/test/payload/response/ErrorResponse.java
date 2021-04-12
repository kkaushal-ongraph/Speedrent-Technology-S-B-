package com.ongraph.test.payload.response;

import java.util.List;

public class ErrorResponse {

	String errorMessage;
	List<String> errors;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public ErrorResponse(String errorMessage, List<String> errors) {
		super();
		this.errorMessage = errorMessage;
		this.errors = errors;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
