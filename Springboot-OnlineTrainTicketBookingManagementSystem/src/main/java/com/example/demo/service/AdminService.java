package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Admin;

public interface AdminService {
	
	public Admin addAdmin(Admin admin);

	public List<Admin> getAllAdmin();

	public Admin getAdminById(int id);

	public String deleteAdmin(int id);

	public Admin updateAdmin(Admin admin);

}
