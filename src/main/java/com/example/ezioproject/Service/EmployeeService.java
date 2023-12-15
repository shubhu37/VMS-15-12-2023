package com.example.ezioproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Assign;
import com.example.ezioproject.Model.Employee;

@Service("EmployeeService")
public interface EmployeeService {

	List<Employee> getAllEmployee();

	void saveEmployee(Employee employee);

	public Employee find(Long id);   // id through find

	public void deleteEmployeeById(Long id);

	public Employee getEmployeeById(Long id);


	
	

}
