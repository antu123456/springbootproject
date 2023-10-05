 package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserIdNotExistsException;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			// throw userAlradyExistsException
			throw new UserAlreadyExistsException("Username " + user.getUsername() + " already Exists");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		User user = userRepository.findByUserId(id);
		if (user == null) {
			// throw userIdNotExistsException
			throw new UserIdNotExistsException("User Id " + id + " Does not Exists ");
		}
		return user;
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserId(id);
		if (user == null) {
			// throw userIdNotExistsException
			throw new UserIdNotExistsException("User Id " +id + " Does not Exists");
		}
		userRepository.delete(user);
		return "User is deleted";
	}

	@Override
	public User updateUser(User user) {

		/*
		 * user1.setUserId(user.getUserId()); user1.setUsername(user.getUsername());
		 * user1.setPassword(user.getPassword()); user1.setEmail(user.getEmail());
		 * user1.setName(user.getName()); user1.setPhoneNumber(user.getPhoneNumber());
		 */
		if (user.getUserId() == null || userRepository.findByUserId(user.getUserId()) == null) {
			// throw userIdNotExistsException
			throw new UserIdNotExistsException("User Id " + user.getUserId() + " Does not Exists");
		}

		return userRepository.save(user);
	}

}
