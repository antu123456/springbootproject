package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.User;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
	/**
	 * This method is used to save the user in database
	 */
	public Booking save(Booking booking);

	/**
	 *This method is used to find the user by its userid in database
	 */
	
	public Booking findByBookingId(Integer id);

}
