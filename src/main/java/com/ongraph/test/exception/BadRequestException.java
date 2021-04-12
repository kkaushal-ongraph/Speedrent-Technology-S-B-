package com.ongraph.test.exception;

import com.ongraph.test.constants.ErrorContstants;

public class BadRequestException extends Exception {

	int status;

	public BadRequestException() {
		super(ErrorContstants.BAD_REQUEST);
	}

	public BadRequestException(String msg) {
		super(msg);

	}

	public BadRequestException(int status, String message) {
		super(message);
		this.status = status;
	}

}
