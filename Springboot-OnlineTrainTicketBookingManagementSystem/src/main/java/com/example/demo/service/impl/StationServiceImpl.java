package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Station;
import com.example.demo.Entity.User;
import com.example.demo.Repository.StationRepository;
import com.example.demo.exception.BookingIdNotExistsException;
import com.example.demo.exception.StationCodeAlreadyExistsException;
import com.example.demo.service.StationService;
@Service
public class StationServiceImpl implements StationService{
	@Autowired
	StationRepository stationRepository;

	@Override
	public Station addStation(Station station) {
		Station existingStation = stationRepository.findByStationCode(station.getStationCode());
		if (existingStation!= null) {
			// throw StationCodeAlreadyExistsException
			throw new StationCodeAlreadyExistsException("Station  code" + station.getStationCode() + " already Exists");
		}
		return stationRepository.save(station);
	}

	@Override
	public List<Station> getAllStation() {
		// TODO Auto-generated method stub
		return stationRepository.findAll();
	}

	@Override
	public Station getStationById(int id) {
		Station station = stationRepository.findByStationId(id);
		if(station == null)
			// throw BookingIdNotExistsException
		{
			throw new BookingIdNotExistsException("Booking "+id+" Does not exits");
		}
		return station;
	}

	@Override
	public String deleteStation(int id) {
		// TODO Auto-generated method stub
		 stationRepository.deleteById(id);
		 return "Station is deleted";
	}

	@Override
	public Station updateStation(Station station) {
		// TODO Auto-generated method stub
		Station station1=stationRepository.findById(station.getStationId()).get();
		station1.setStationId(station.getStationId());
		station1.setStationName(station.getStationName());
		station1.setStationCode(station.getStationCode());
		return stationRepository.save(station1);
	}

}
