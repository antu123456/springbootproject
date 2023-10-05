package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserIdNotExistsException.class)
	public ResponseEntity<Object> handleUserIdNotExistsException(UserIdNotExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TrainNumberAlreadyExistsException.class)
	public ResponseEntity<Object> handleTrainNumberAlreadyExistsException(TrainNumberAlreadyExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TrainIdNotExistsException.class)
	public ResponseEntity<Object> handleTrainIdNotExistsException(TrainIdNotExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingIdNotExistsException.class)
	public ResponseEntity<Object> handleBookingIdNotExistsException(BookingIdNotExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TrainScheduleAlreadyExistsException.class)
	public ResponseEntity<Object> handleTrainScheduleAlreadyExistsException(TrainScheduleAlreadyExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TrainScheduleIdNotFoundException.class)
	public ResponseEntity<Object> handleTrainScheduleIdNotFoundException(TrainScheduleIdNotFoundException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StationCodeAlreadyExistsException.class)
	public ResponseEntity<Object> handleStationCodeAlreadyExistsException(StationCodeAlreadyExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StationIdNotExistsException.class)
	public ResponseEntity<Object> handleStationIdAlreadyExistsException(StationIdNotExistsException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
