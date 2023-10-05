package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	/**
	 * This method is used to save the user in database
	 */
	public User save(User user);
	/**
	 * This method is used to find the user by its username in database
	 */
	
	public User findByUsername(String username);
	/**
	 *This method is used to find the user by its userid in database
	 */
	
	public User findByUserId(int id);
	
}
