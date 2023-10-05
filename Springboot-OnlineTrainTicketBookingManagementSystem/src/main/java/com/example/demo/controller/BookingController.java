package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.Booking;
import com.example.demo.service.BookingService;
@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/bookings")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking)
	{
		Booking registerBooking=bookingService.addBooking(booking);
		return new ResponseEntity<Booking>(registerBooking,HttpStatus.CREATED);
		
	}
	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> getAllAppointment()
	{
		List<Booking> booking=bookingService.getAllBooking();
		return new ResponseEntity<List<Booking>>(booking,HttpStatus.OK);
	}
	@GetMapping("/bookings/{id}")
	public ResponseEntity<Booking> getAppointmentById(@PathVariable int id)
	{
		Booking getBookingId=bookingService.getBookingById(id);
		return new ResponseEntity<Booking>(getBookingId,HttpStatus.OK);
	}
	
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable int id)
	{
		String message=bookingService.deleteBooking(id);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@PutMapping("/bookings/{id}")
	public ResponseEntity<Booking> updateAppointment(@RequestBody Booking booking)
	{
		Booking getBooking=bookingService.updateBooking(booking);
		return new ResponseEntity<Booking>(getBooking,HttpStatus.OK);
	}


}
