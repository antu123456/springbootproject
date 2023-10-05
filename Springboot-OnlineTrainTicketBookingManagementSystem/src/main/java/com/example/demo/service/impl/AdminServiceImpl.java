package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).get();
	}

	@Override
	public String deleteAdmin(int id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(id);
		return "Admin is deleted";
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin admin1=adminRepository.findById(admin.getAdminId()).get();
		admin1.setAdminId(admin.getAdminId());
		admin1.setUserName(admin.getUserName());
		admin1.setPassword(admin.getPassword());
		admin1.setAdminName(admin.getAdminName());
		return adminRepository.save(admin1);
	}

}
