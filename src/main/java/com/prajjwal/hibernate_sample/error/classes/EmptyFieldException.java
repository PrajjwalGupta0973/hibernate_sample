package com.prajjwal.hibernate_sample.error.classes;

public class EmptyFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyFieldException(String exception) {
		super(exception);
	}

}