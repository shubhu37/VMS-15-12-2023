package com.example.ezioproject;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Repo.EmployeeRepo;
@SpringBootApplication
public class VisitorManagementSystemApplication 
{

	public static void main(String[] args)
	{
		
		SpringApplication.run(VisitorManagementSystemApplication.class, args);
		
			System.out.println("VMS Project!!!!!!");
		
	}

}
