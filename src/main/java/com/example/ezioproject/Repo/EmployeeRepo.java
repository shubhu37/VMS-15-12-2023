package com.example.ezioproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Model.Visitor;

@Repository("EmployeeRepo")
public interface EmployeeRepo extends JpaRepository<Employee,Long>
{

	
}



				