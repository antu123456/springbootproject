package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Train;
import com.example.demo.Entity.TrainSchedule;
import com.example.demo.Repository.TrainRepository;
import com.example.demo.Repository.TrainScheduleRepository;
import com.example.demo.exception.TrainScheduleAlreadyExistsException;
import com.example.demo.exception.TrainScheduleIdNotFoundException;
import com.example.demo.service.TrainScheduleService;
@Service
public class TrainScheduleServiceImpl implements TrainScheduleService{
	@Autowired
	TrainScheduleRepository trainScheduleRepository;
	
	@Autowired
	TrainRepository trainRepository;

	@Override
	public TrainSchedule addTrainSchedule(TrainSchedule trainSchedule) {
		
		Train train = trainRepository.findByTrainNumber(trainSchedule.getTrainNumber());
		
		//Schedule Date is unique for a particular trainNumber
		List<TrainSchedule> schedules = trainScheduleRepository.findByScheduleDate(trainSchedule.getScheduleDate());
		int existingTrainCount = (int) schedules.stream().
		filter(schedule -> schedule.getTrainNumber() == trainSchedule.getTrainNumber())
		.count();
		
		if(existingTrainCount >0) {
			//Throw ScheduleAreadyExistsException
			throw new TrainScheduleAlreadyExistsException("SChedule Already Exists for "+trainSchedule.getScheduleDate());
			
		}
		//once trainSchedule added available seats will be equals to the trains total seat
		trainSchedule.setAvailableSeat(train.getTotalSeat());
		trainSchedule.setTrain(train);
		
		return trainScheduleRepository.save(trainSchedule);
	}

	@Override
	public List<TrainSchedule> getAllTrainSchedule() {
		// TODO Auto-generated method stub
		return trainScheduleRepository.findAll();
	}

	@Override
	public TrainSchedule getTrainScheduleById(int id) {
		TrainSchedule trainSchedule = trainScheduleRepository.findByScheduleId(id);
		if(trainSchedule == null) {
			throw new TrainScheduleIdNotFoundException("Cannot find Schedule with id "+id);
		}
		return trainSchedule;
	}

	@Override
	public String deleteTrainSchedule(int id) {
		TrainSchedule trainSchedule = trainScheduleRepository.findByScheduleId(id);
		if(trainSchedule == null) {
			throw new TrainScheduleIdNotFoundException("Cannot find Schedule with id "+id);
		}
		
		trainScheduleRepository.delete(trainSchedule);
		return "TrainSchedule is deleted";
	}

	@Override
	public TrainSchedule updateTrainSchedule(TrainSchedule trainSchedule) {
		return trainScheduleRepository.save(trainSchedule);
	}

}
