package com.example.demo.exception;

public class StationCodeAlreadyExistsException extends RuntimeException{
	public StationCodeAlreadyExistsException(String msg) {
		super(msg);
	}

}
