package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="StationTable")
public class Station {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stationId;
	private int stationCode;
	private String stationName;
	

}
