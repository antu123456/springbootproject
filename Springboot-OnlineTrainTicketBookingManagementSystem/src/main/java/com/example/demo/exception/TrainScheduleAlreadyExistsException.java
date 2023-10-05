package com.example.demo.exception;

public class TrainScheduleAlreadyExistsException extends RuntimeException{

	public TrainScheduleAlreadyExistsException(String message) {
		super(message);
	}
}
