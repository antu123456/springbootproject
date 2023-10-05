package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.User;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User registeredUser = userService.addUser(user);
		return new ResponseEntity<User>(registeredUser,HttpStatus.CREATED);
		
	}
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users = userService.getAllUser();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id)
	{
		User getUserId = userService.getUserById(id);
		return new ResponseEntity<User>(getUserId,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id)
	{
		String message = userService.deleteUser(id);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}


}
