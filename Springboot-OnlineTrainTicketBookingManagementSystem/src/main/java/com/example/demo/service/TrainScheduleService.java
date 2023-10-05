package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.TrainSchedule;

public interface TrainScheduleService {
	public TrainSchedule addTrainSchedule(TrainSchedule trainSchedule);
	
	public List<TrainSchedule> getAllTrainSchedule();
	
	public TrainSchedule getTrainScheduleById(int id);
	
	public String deleteTrainSchedule(int id);
	
	public TrainSchedule updateTrainSchedule(TrainSchedule trainSchedule);


}
