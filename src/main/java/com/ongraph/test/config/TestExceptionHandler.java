package com.ongraph.test.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ongraph.test.exception.BadRequestException;
import com.ongraph.test.payload.response.ErrorResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class TestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {

		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), errors);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}