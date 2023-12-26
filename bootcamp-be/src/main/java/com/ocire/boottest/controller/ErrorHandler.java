package com.ocire.boottest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ocire.boottest.dto.ErrorResDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResDto<String>> handleNullPointerException(NullPointerException npe) {
		npe.printStackTrace();
		final ErrorResDto<String> errorResult = new ErrorResDto<>();
		errorResult.setMessage(npe.getMessage());
		
		return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorResDto<String>> badCredentialsException(BadCredentialsException npe) {
		npe.printStackTrace();
		final ErrorResDto<String> errorResult = new ErrorResDto<>();
		errorResult.setMessage("Invalid Email / Password!");
		
		return new ResponseEntity<>(errorResult, HttpStatus.UNAUTHORIZED);
	}
}
