package com.example.ezioproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Repo.EmployeeRepo;

@Service
public class EmployeeServiceIMPL implements EmployeeService
{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployee()
	{
	return employeeRepo.findAll();
	
	}
	
	
	
	@Override
	public Employee find(Long id) 
	{
		return employeeRepo.findById(id).get();
	}
	

	
	@Override
	public void saveEmployee(Employee employee)
	{
		employeeRepo.save(employee);
	}

	
	@Override
	public void deleteEmployeeById(Long id) 
	 {
	    this.employeeRepo.deleteById(id);
		
	}
 
	  @Override 
	  public Employee getEmployeeById(Long id)
	  {
	Optional<Employee>findId = employeeRepo.findById(id);
	  
	  Employee employee1 = null;
	  
	  if (findId.isPresent())
	  {
		  employee1 = findId.get();
	  
	  }
	  else
	  {
		  throw new RuntimeException("Employee Not Found....." + id);
		  
		  }
	  			return employee1; 
	  }






	  
	

	}
	  
	  
	  
	  
	  
