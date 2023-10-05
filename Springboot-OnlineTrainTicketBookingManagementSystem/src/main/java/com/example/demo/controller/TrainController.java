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

import com.example.demo.Entity.Train;
import com.example.demo.service.TrainService;
@RestController
public class TrainController {
	@Autowired
	TrainService trainService;
	
	@PostMapping("/trains")
	public ResponseEntity<Train> addTrain(@RequestBody Train train)
	{
		Train registerTrain=trainService.addTrain(train);
		return new ResponseEntity<Train>(registerTrain,HttpStatus.CREATED);
		
	}
	@GetMapping("/trains")
	public ResponseEntity<List<Train>> getAllTrain()
	{
		List<Train> trains=trainService.getAllTrain();
		return new ResponseEntity<List<Train>>(trains,HttpStatus.OK);
	}
	@GetMapping("/trains/{id}")
	public ResponseEntity<Train> getTrainById(@PathVariable int id)
	{
		Train getTrainId=trainService.getTrainById(id);
		return new ResponseEntity<Train>(getTrainId,HttpStatus.OK);
	}
	
	@DeleteMapping("/trains/{id}")
	public ResponseEntity<String> deleteTrain(@PathVariable int id)
	{
		String message=trainService.deleteTrain(id);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@PutMapping("/trains/{id}")
	public ResponseEntity<Train> updateTrain(@RequestBody Train train)
	{
		Train updateTrain=trainService.updateTrain(train);
		return new ResponseEntity<Train>(updateTrain,HttpStatus.OK);
	}


}
