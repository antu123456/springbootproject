package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Train;
import com.example.demo.Entity.User;
@Repository
public interface TrainRepository extends JpaRepository<Train,Integer>{
	/**
	 * This method is used to save the user in database
	 */
	public Train save(Train train);
	/**
	 * This method is used to find the user by its username in database
	 */
	
	public Train findByTrainNumber(Integer trainNumber);
	/**
	 *This method is used to find the user by its userid in database
	 */
	
	public Train findByTrainId(int id);

}
