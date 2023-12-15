package com.example.ezioproject.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ezioproject.Model.Admin;
@Repository("AdminRepo")
public interface AdminRepo extends JpaRepository<Admin , Long>
{

	Admin findByEmailAndPassword(String email, String password);
    
	
}