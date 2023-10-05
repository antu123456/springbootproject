package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TrainSchedule;
@Repository
public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Integer>{

	public List<TrainSchedule> findByScheduleDate(Date date);

	public TrainSchedule findByScheduleId(int id);
}
