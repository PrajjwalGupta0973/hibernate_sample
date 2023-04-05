package com.prajjwal.hibernate_sample.error;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleUnknownException(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		log.error(ex.getMessage());
		ErrorModel error = new ErrorModel();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ex.getBindingResult().getFieldError("firstName").getDefaultMessage());
		error.setHttpStatusValue(HttpStatus.FORBIDDEN.value());
		error.setError(HttpStatus.FORBIDDEN.getReasonPhrase());
		error.setPath(((HttpServletRequest) request).getRequestURI());
		ex.printStackTrace();
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
}
