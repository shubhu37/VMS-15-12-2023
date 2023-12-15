package com.example.ezioproject.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ezioproject.Model.Admin;
import com.example.ezioproject.Service.AdminService;
import com.example.ezioproject.Service.VisitorService;

@Controller("AdminController")
public class AdminController
 {

	@Autowired
	private AdminService service;
	

	
	/*
	 * @RequestMapping("/admin-validate") public String
	 * doSignInOfAdmin(@RequestParam String email, @RequestParam String password) {
	 * Admin user = service.validateAdminCredential(email, password);
	 * 
	 * // System.err.println(" check value..   " + user);
	 * 
	 * if (user != null) { return "Admin/index";
	 * 
	 * } else { return "redirect:/login"; }
	 * 
	 * }
	 */  


	@RequestMapping("/admin-validate")
	public String Signin(@RequestParam String email, @RequestParam String password)
		{

	    if (email == null || email.isEmpty() || password == null || password.isEmpty())
	     {
	        
	        return "redirect:/login";
	     	}

	    try {
	    	
	        Admin admin = service.validateAdminCredential(email, password);

	        if (admin != null) 
	        {
	            if (admin.getRole().equals("Admin") && admin.getStatus().equals("Active"))
	            {
	          
	                    return "Admin/index";        
	            }
	            
	            
	                else if (admin.getRole().equals("Developer") && admin.getStatus().equals("Active"))
	                {
	                    return "Employee/Developer";
	                    
	                } 
	            
	            
	                else if (admin.getRole().equals("Tester") && admin.getStatus().equals("Active"))
	                {
	                    return "Employee/Tester";
	                }
	        }
	
			System.out.println("Invalid admin.......");

			return "redirect:/login";

		} catch (Exception e) {

			e.printStackTrace();

			return "redirect:/login";
		}
	}
	

	
	@GetMapping("/employee")  
	   public String Employee()
	  {
	     return "Admin/employee";
	   }
	

	
	@RequestMapping("/index")
	public String index() {

		return "Admin/index";
	}
	
	
	
	@GetMapping("/visitor")
	public String visit()
	{

		return "Admin/visitor";
	}
	
	@GetMapping("/meeting")
	public String meet()
	{

		return "Admin/assign";
	}

	

	
	@GetMapping("/login")
	public String login() {
		return "Admin/login";
	}

//	@RequestMapping("/table")
//	public String table() {
//
//		return "Admin/basic-table";
//	}
	
//	@RequestMapping("/develop")
//	public String dataShow() {
//
//		return "Employee/Developer";
//	}

	
	
	
}
