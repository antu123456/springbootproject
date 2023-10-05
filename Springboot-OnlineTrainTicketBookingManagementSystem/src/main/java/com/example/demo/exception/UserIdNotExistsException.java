package com.example.demo.exception;

public class UserIdNotExistsException extends RuntimeException{
	public UserIdNotExistsException(String msg) {
		super(msg);
	}

}
