package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="trains")
public class Train {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer trainId;
	private int trainNumber;
	private String trainName;
	private int totalSeat;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},  mappedBy = "train")
	@JsonIgnore
	List<TrainSchedule> trainSchedule;
	

}
