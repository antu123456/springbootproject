package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Station;
import com.example.demo.service.StationService;
@RestController
public class StationController {
	@Autowired
	StationService stationService;
	
	@PostMapping("/stations")
	public Station addStation(@RequestBody Station station)
	{
		return stationService.addStation(station);
		
	}
	@GetMapping("/stations")
	public List<Station> getAllStation()
	{
		return stationService.getAllStation();
	}
	@GetMapping("/stations/{id}")
	public Station getStationById(@PathVariable int id)
	{
		return stationService.getStationById(id);
	}
	
	@DeleteMapping("/stations/{id}")
	public String deleteStation(@PathVariable int id)
	{
		return stationService.deleteStation(id);
	}
	@PutMapping("/stations/{id}")
	public Station updateStation(@RequestBody Station station)
	{
		return stationService.updateStation(station);
	}


}
