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

import com.example.demo.Entity.TrainSchedule;
import com.example.demo.service.TrainScheduleService;
@RestController
public class TrainScheduleController {
	@Autowired
	TrainScheduleService trainScheduleService;
	
	@PostMapping("/trainSchedules")
	public ResponseEntity<TrainSchedule> addTrainSchedule(@RequestBody TrainSchedule trainSchedule)
	{
		TrainSchedule savedSchedule = trainScheduleService.addTrainSchedule(trainSchedule);
		return  new ResponseEntity<TrainSchedule>(savedSchedule,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/trainSchedules")
	public ResponseEntity<List<TrainSchedule>> getAllTrainSchedule()
	{
		List<TrainSchedule> schedules = trainScheduleService.getAllTrainSchedule();
		return new ResponseEntity<List<TrainSchedule>>(schedules,HttpStatus.OK);
	}
	
	@GetMapping("/trainSchedules/{id}")
	public ResponseEntity<TrainSchedule> getTrainScheduleById(@PathVariable int id)
	{
		TrainSchedule trainSchedule = trainScheduleService.getTrainScheduleById(id);
		return new ResponseEntity<TrainSchedule>(trainSchedule,HttpStatus.OK);
	}
	
	@DeleteMapping("/trainSchedules/{id}")
	public ResponseEntity<String> deleteTrainSchedule(@PathVariable int id)
	{
		String response = trainScheduleService.deleteTrainSchedule(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@PutMapping("/trainSchedules/{id}")
	public ResponseEntity<TrainSchedule> updateTrainSchedule(@RequestBody TrainSchedule trainSchedule)
	{
		TrainSchedule schedule  = trainScheduleService.updateTrainSchedule(trainSchedule);
		return new ResponseEntity<TrainSchedule>(schedule,HttpStatus.OK);
	}



}
