package com.example.ezioproject.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Service.EmployeeService;
import com.example.ezioproject.Service.EmployeeServiceIMPL;


@Controller
public class EmployeeController
 {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employeeAll") 
	@ResponseBody
	public List<Employee> getAllEmployee() 
	{
		List<Employee> list = employeeService.getAllEmployee();

		//System.err.println("data show"+ list);	
		return list;
	}
	
	
	
	@PostMapping("/saveEmployee")
	@ResponseBody
	public String saveEmployee(Employee employee) 
	{
	//System.err.println(" ..data..." + employee);
		
		this.employeeService.saveEmployee(employee); 

		return "Saved The Employee....";
	}
	  
	
	
	
		@DeleteMapping("/deleteEmployee/{id}")
		@ResponseBody
		public String deleteEmployee(@PathVariable Long id)
		{

			this.employeeService.deleteEmployeeById(id);
			
			return "redirect:/"; 
		}
		
		
		
//		  @PostMapping("/updateEmployee/{id}") 
//		  public ResponseEntity<Employee> employee(@PathVariable Long id, @RequestBody Employee employee)
//		  {
//			  Employee emp1 = employeeService.employee(id, employee);
//			  
//			  if(emp1 != null)
//			  { 
//				  return ResponseEntity.ok(emp1);	  
//			  }
//			  else
//			  {
//				  return ResponseEntity.notFound().build(); 
//				  } 
//		  }
		
		  @GetMapping("/updateEmployee")
		  @ResponseBody
		  public Employee getEmployee(Long id)
		  { 
			  
		  // System.err.println("working...."); 	  
		  return employeeService.getEmployeeById(id);
		   
		  }
 
			
		  
			/*
			 * @GetMapping("/getEmployeeDetailsById")
			 * 
			 * @ResponseBody public ResponseEntity<?> getEmployeeDetailsById(@RequestParam
			 * Long id) { Employee employee = employeeService.getEmployeeById(id);
			 * 
			 * if (employee != null) { HashMap<String, Object> response = new HashMap<>();
			 * response.put("employeeId", employee.getId()); response.put("employeeName",
			 * employee.getName());
			 * 
			 * // You can add other required fields of the employee here return
			 * ResponseEntity.ok(response); } else { return
			 * ResponseEntity.notFound().build(); } }  */
		  
		  

}
