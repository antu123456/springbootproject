package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Station;

public interface StationService {
	public Station addStation(Station station);
	
	public List<Station> getAllStation();
	
	public Station getStationById(int id);
	
	public String deleteStation(int id);
	
	public Station updateStation(Station station);


}
