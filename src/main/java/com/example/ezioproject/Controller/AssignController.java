package com.example.ezioproject.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ezioproject.Model.Assign;
import com.example.ezioproject.Model.Checkbox;
import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Model.Visitor;
import com.example.ezioproject.Repo.AssignRepo;
import com.example.ezioproject.Repo.EmployeeRepo;
import com.example.ezioproject.Service.AssignService;
import com.example.ezioproject.Service.CheckboxService;
import com.example.ezioproject.Service.EmployeeService;
import com.example.ezioproject.Service.VisitorService;
import com.example.ezioproject.mail.Mail;




@Controller
public class AssignController 
{
	
	@Autowired
	private AssignService assignService;

	@Autowired
	private CheckboxService checkboxService;

	@Autowired
	private VisitorService visitorService;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private AssignRepo assignRepo;
	

	@Autowired                                     // new add
 	private EmployeeService employeeService;
	
	

	@PostMapping("/save")
	@ResponseBody
	public Employee save(@RequestParam Long empId) {

		List<Long> visitorId = assignService.getVisitorIdByStates("true");
		
		
		 Employee employee = employeeService.getEmployeeById(empId);		 
		 
       //  String employeeEmail = employeeService.getEmployeeEmailByVisitor(visitorId);
		 
	        String employeeEmail = employee.getEmail();


		for (Long id : visitorId) {

			Assign assign = new Assign();
			assign.setEmployeeid(empId);
			assign.setVisitorId(id);
			
			visitorService.updateStatusToAssign(id);      // assign name show
 
 
			
		   String currentTimestamp = new String();
		 
		 

			Visitor visitor = visitorService.getVisitorById(id);
			
			assign.setVisitorname(visitor.getName());
			assign.setReason(visitor.getReason());
			assign.setVisitoremail(visitor.getEmail());	
			assign.setStatus(visitor.getStatus());
	        

			Employee employee1 = employeeRepo.findById(empId).orElse(null);
			assign.setEmployeeemail(employee1.getEmail());
			
			//this is the mail section
			
			  if (employeeEmail != null)
			    {
		            String emailSubject = "Visitor Details:";
		            String emailText = "Visitor Name: " + visitor.getName() +
		                    "\nVisitor Email: " + visitor.getEmail() +
		                    "\nReason: " + visitor.getReason();

		            Mail mail = new Mail(); // Assuming Mail is your mail  class
		            mail.sendPasswordMail(emailSubject, employeeEmail, employee.getName(), emailText);
		        }
			
			
			// set the employee name in assign
			if (employee1 != null)
			{
				assign.setEmployeename(employee1.getName());         
			}
			
			
                    // SHOW THE CURRENT TIME
			    LocalDateTime currentDateTime = LocalDateTime.now();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm"); 
	            String currentTimestamp1 = currentDateTime.format(formatter);
	            assign.setTimestamp(currentTimestamp1);

	            
	            
	            visitor.setMeetwhom(employee1.getName());     // add to employee in meet to whom
		        visitorService.saveVisitor(visitor);
		        
			
			assignRepo.save(assign);
			
		}
		
		
        checkboxService.truncateCheckData();

		return null;
		
	}
	


	@GetMapping("/assignAll")
	@ResponseBody
	public List<Assign> getAllVisitorAssign() {

		List<Assign> list = assignService.getAllVisitorAssign();

		//System.err.println(" All Assign data  " + list);

		return list;

	}

	@DeleteMapping("/deleteAssignmeet/{id}") // delete by employeeid
	@ResponseBody
	public String deleteMeeting(@PathVariable Long id) {
		this.assignService.deleteAssignById(id);

		System.err.println(" delete ");
		return "redirect:/";

	}

	
	@PostMapping("/approveMeeting/{id}")               // check to the id
	@ResponseBody
	public String approveMeeting(@PathVariable Long id)
	{
	    Assign assign = assignRepo.findById(id).orElse(null);
	    if (assign != null)
	    {
	        assign.setStatus("APPROVE");
	        assignRepo.save(assign);
	        
	        return "Meeting approved.........";
	    } 
	    else 
	    {
	        return " not found";
	    }
	}

	@PostMapping("/rejectMeeting/{id}")
	@ResponseBody
	public String rejectMeeting(@PathVariable Long id)
	{
	    Assign assign = assignRepo.findById(id).orElse(null);
	    if (assign != null) 
	    {
	        assign.setStatus("REJECT");
	        assignRepo.save(assign);
	       	        
	        return "Meeting rejected............";
	        
	    } 
	    else {
	        return "not found";
	    }
	}
}
	

