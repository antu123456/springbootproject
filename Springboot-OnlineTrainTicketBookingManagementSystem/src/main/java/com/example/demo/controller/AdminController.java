package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Admin;
import com.example.demo.service.AdminService;
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admins")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return adminService.addAdmin(admin);
		
	}
	@GetMapping("/admins")
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	@GetMapping("/admins/{id}")
	public Admin getAdminById(@PathVariable int id)
	{
		return adminService.getAdminById(id);
	}
	
	@DeleteMapping("/admins/{id}")
	public String deleteAdmin(@PathVariable int id)
	{
		return adminService.deleteAdmin(id);
	}
	@PutMapping("/admins/{id}")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		return adminService.updateAdmin(admin);
	}

}
