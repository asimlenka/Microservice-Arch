package com.org.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorHandler {

	private final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(Exception.class)
	public @ResponseBody com.org.auth.domain.Error processValidationError(Exception e) {
		log.info("Error Occured", e.getMessage());
		com.org.auth.domain.Error error = new com.org.auth.domain.Error();
		if (e instanceof IllegalArgumentException) {
			error.setErrorCode("401");
			error.setErrorDesc("UnAuthorized");
		} else {
			error.setErrorCode("500");
			error.setErrorDesc(e.getMessage());
		}
		return error;
	}
}
