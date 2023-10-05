package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Train;
import com.example.demo.Entity.User;
import com.example.demo.Repository.TrainRepository;
import com.example.demo.exception.TrainIdNotExistsException;
import com.example.demo.exception.TrainNumberAlreadyExistsException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserIdNotExistsException;
import com.example.demo.service.TrainService;
@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	TrainRepository trainRepository;

	@Override
	public Train addTrain(Train train) {
		Train existingTrain = trainRepository.findByTrainNumber(train.getTrainNumber());
		if (existingTrain != null) {
			// throw trainNumberAlradyExistsException
			throw new TrainNumberAlreadyExistsException("Train number " + train.getTrainNumber() + " already Exists");
		}
		return trainRepository.save(train);
	}

	@Override
	public List<Train> getAllTrain() {
		// TODO Auto-generated method stub
		return trainRepository.findAll();
	}

	@Override
	public Train getTrainById(int id) {
		Train train = trainRepository.findByTrainId(id);
		if (train == null) {
			// throw trainIdNotExistsException
			throw new TrainIdNotExistsException("Train Id " + id + " Does not Exists");
		}
		return train;
	}

	@Override
	public String deleteTrain(int id) {
		Train train = trainRepository.findByTrainId(id);
		if (train == null) {
			// throw trainIdNotExistsException
			throw new TrainIdNotExistsException("train Id " +id + " Does not Exists");
		}
		trainRepository.delete(train);
		return "Train is deleted";
	}

	@Override
	public Train updateTrain(Train train) {
		if (train.getTrainId() == null || trainRepository.findByTrainId(train.getTrainId()) == null) {
			// throw trainIdNotExistsException
			throw new TrainIdNotExistsException("Train Id " + train.getTrainId() + " Does not Exists");
		}

		return trainRepository.save(train);
	}

}
