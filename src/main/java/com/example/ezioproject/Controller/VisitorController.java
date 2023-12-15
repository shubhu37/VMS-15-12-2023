package com.example.ezioproject.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Model.Visitor;
import com.example.ezioproject.Repo.VisitorRepo;
import com.example.ezioproject.Service.EmployeeService;
import com.example.ezioproject.Service.VisitorService;

@Controller
public class VisitorController
{
	@Autowired
	private VisitorService visitorService;
	
	

	@GetMapping("/visitorAll")
	@ResponseBody
	public List<Visitor> getAllVisitors() 
	{
		List<Visitor> list = visitorService.getAllVisitors();

		return list;

	}
	

	@PostMapping("/visitorSave")
	@ResponseBody
	public String saveVisitor(Visitor visitor) 
	{	 
		this.visitorService.saveVisitor(visitor);
		return "Save the Visitor..";
	}

	
	
	@DeleteMapping("/deleteVisitor/{id}")
	@ResponseBody
	public String deleteVisitor(@PathVariable Long id) {
		this.visitorService.deleteVisitorById(id);

		return "redirect:/";

	}



	  @GetMapping("/updateVisitor")
	  @ResponseBody
	  public Visitor getVisitor(Long id)
	  { 
		  
	 // System.err.println("working... "); 		  
	  return visitorService.getVisitorById(id);
	   
	  }
	

	    @GetMapping("/showvisitor")
		@ResponseBody
		public long countAll()
		{
			return visitorService.countAll();
		}
		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 

}
