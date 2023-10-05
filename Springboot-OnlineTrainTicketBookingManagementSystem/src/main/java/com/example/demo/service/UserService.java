package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.User;

public interface UserService {
	/**
	 * This method is used to Add the user in the System
	 * @param user
	 * @return
	 */
	public User addUser(User user);
	
	public List<User> getAllUser();
	
	public User getUserById(int id);
	
	public String deleteUser(int id);
	
	public User updateUser(User user);

}
