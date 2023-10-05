package com.example.demo.exception;

public class TrainIdNotExistsException extends RuntimeException{
	
	public TrainIdNotExistsException(String msg)
	{
		super(msg); 
	}

}
