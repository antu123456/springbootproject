package com.example.demo.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="trainschedules")
public class TrainSchedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer scheduleId;
	private Date scheduleDate;
	private String source;
	private String destination;
	private int totalNumberOfStation;
	private Date arrivalDate;
	private Date departureDate;
	private  int ticketFare;
	private int availableSeat;
	private int trainNumber;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="trainSchedule")
	@JsonIgnore
	private List<Booking> booking;
	
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private Train train;

}
