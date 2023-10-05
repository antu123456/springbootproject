package com.example.demo.exception;

public class TrainNumberAlreadyExistsException extends RuntimeException{
	
	public TrainNumberAlreadyExistsException(String msg)
	{
		super(msg);
	}

}
