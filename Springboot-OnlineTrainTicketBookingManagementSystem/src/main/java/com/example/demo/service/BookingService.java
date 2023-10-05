package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Booking;

public interface BookingService {
	public Booking addBooking(Booking booking);
	
	public List<Booking> getAllBooking();
	
	public Booking getBookingById(int id);
	
	public String deleteBooking(int id);
	
	public Booking updateBooking(Booking booking);

}
