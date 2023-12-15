package com.example.ezioproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Admin;
import com.example.ezioproject.Repo.AdminRepo;

@Service("AdminService")
public class AdminService {

	@Autowired
	private AdminRepo repo;

	public Admin validateAdminCredential(String email, String password) {

		return repo.findByEmailAndPassword(email, password);
	}
	
	
	

	
	
	
	
	
}