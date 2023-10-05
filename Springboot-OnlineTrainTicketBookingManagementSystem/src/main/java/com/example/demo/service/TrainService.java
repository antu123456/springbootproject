package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Train;

public interface TrainService {
	public Train addTrain(Train train);
	
	public List<Train> getAllTrain();
	
	public Train getTrainById(int id);
	
	public String deleteTrain(int id);
	
	public Train updateTrain(Train train);



}
