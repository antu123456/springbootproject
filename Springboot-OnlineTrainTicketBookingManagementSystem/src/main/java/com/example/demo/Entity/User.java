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
@Table(name="UserTable")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String name;
	private String phoneNumber;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	//@JsonIgnore
	private List<Booking> booking;

}
