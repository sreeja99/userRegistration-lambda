package com.userregistration.lambda;

public class InvalidException extends Exception {
	String message;
	enum ExceptionType{
		INVALID_FIRST_NAME,INVALID_LAST_NAME,INVALID_EMAIL,INVALID_MOBILE,INVALID_PASSWORD;
	}
	ExceptionType type;
	InvalidException(ExceptionType type,String message) {
		super(message);
		this.type=type;
	}
}
