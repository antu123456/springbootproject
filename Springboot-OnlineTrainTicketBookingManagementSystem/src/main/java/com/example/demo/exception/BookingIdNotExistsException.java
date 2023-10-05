package com.example.demo.exception;

public class BookingIdNotExistsException extends RuntimeException{
	public BookingIdNotExistsException(String msg)
	{
		super(msg);
	}

}
