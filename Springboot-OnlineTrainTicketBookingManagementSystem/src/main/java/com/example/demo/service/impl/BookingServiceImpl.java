package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.TrainSchedule;
import com.example.demo.Entity.User;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.TrainScheduleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.BookingIdNotExistsException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserIdNotExistsException;
import com.example.demo.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TrainScheduleRepository trainScheduleRepository;
	
	@Override
	public Booking addBooking(Booking booking) {
		//fetching User and Schedule
		User user = userRepository.findByUserId(booking.getUserId());
		TrainSchedule schedule = trainScheduleRepository.findByScheduleId(booking.getTrainScheduleId());
		
		//setting User and Schedule
		booking.setUser(user);
		booking.setTrainSchedule(schedule);
		
		//Calculating TotalFare and setting in booking
		int baseFare = schedule.getTicketFare();
		booking.setTotalFare(baseFare * booking.getNumberOfTickets());
		
		//Adding Booking
		Booking savedBooking =bookingRepository.save(booking);
		
		//Updating the Schedule Available Seats
		schedule.setAvailableSeat(schedule.getAvailableSeat() - booking.getNumberOfTickets());
		trainScheduleRepository.save(schedule);
		return savedBooking ;
	}
	@Override
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}
	@Override
	public Booking getBookingById(int id) {
		
		Booking booking = bookingRepository.findByBookingId(id);
		if(booking == null)
			// throw BookingIdNotExistsException
		{
			throw new BookingIdNotExistsException("Booking "+id+" Does not exits");
		}
		return booking;
	}
	@Override
	public String deleteBooking(int id) {
		Booking booking = bookingRepository.findByBookingId(id);
		if (booking == null) {
			// throw userIdNotExistsException
			throw new BookingIdNotExistsException("Booking Id " +id + " Does not Exists");
		}
		bookingRepository.delete(booking);
		return "booking is deleted";
	}
	@Override 
	public Booking updateBooking(Booking booking) {
		//Not Decided Yet
		if(booking.getBookingId() == null || bookingRepository.findById(booking.getBookingId()) == null)
		{
			throw new BookingIdNotExistsException("Booking Id " +booking.getBookingId() + " Does not Exists");
		}
		return bookingRepository.save(booking);
	}

	

}
