package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Station;
@Repository
public interface StationRepository extends JpaRepository<Station,Integer>{
	/**
	 * This method is used to save the station in database
	 */
	public Station save(Station station);

	/**
	 *This method is used to find the user by its userid in database
	 */
	
	public Station findByStationCode(int code);
	
	public Station findByStationId(Integer id);


}
