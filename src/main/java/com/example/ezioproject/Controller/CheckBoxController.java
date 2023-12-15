package com.example.ezioproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.ezioproject.Model.Checkbox;
import com.example.ezioproject.Repo.CheckboxRepo;
import com.example.ezioproject.Service.CheckboxService;
import java.util.*;

@Controller
public class CheckBoxController {

	@Autowired
	private CheckboxService checkboxService;

	/*
	 * @GetMapping("/passing-checkbox-id-and-status") //@ResponseBody //public void
	 * saveCheckboxStatus(@RequestParam Long visitorId, @RequestParam String status)
	 * { Checkbox checkbox = new Checkbox();
	 * 
	 * Checkbox check = checkboxService.findByVisitorId(visitorId);
	 * 
	 * System.err.println(check);
	 * 
	 * System.err.println(" status  " + status + "    vid   " + visitorId);
	 * 
	 * if (check != null) {
	 * 
	 * checkbox.setId(check.getId()); checkbox.setVisitorId(visitorId);
	 * checkbox.setStatus(status); checkboxService.save(checkbox); } else {
	 * 
	 * checkbox.setVisitorId(visitorId); checkbox.setStatus(status);
	 * checkboxService.save(checkbox); } }
	 * 
	 */

	@GetMapping("/passing-checkbox-id-and-status")
	@ResponseBody
	public void saveCheckboxStatus1(@RequestParam Long visitorId, @RequestParam String status) {
		Checkbox checkbox1 = checkboxService.findByVisitorId(visitorId); 

		if (checkbox1 == null)
		{
			checkbox1 = new Checkbox(); 

			checkbox1.setVisitorId(visitorId); 
		}

		checkbox1.setStatus(status);

		checkboxService.save(checkbox1);
	}

	
	
	@GetMapping("/get-checkbox-id-and-status")
	public ResponseEntity<List<Checkbox>> getCheckboxStates() 
	 {
		try {
			List<Checkbox> checkboxStates = checkboxService.getAllCheckboxStates();

			//System.err.println(checkboxStates);
			
			return ResponseEntity.ok(checkboxStates);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/*
	 * @GetMapping("/save-checkbox-state")
	 * 
	 * @ResponseBody public ResponseEntity<String> saveCheckboxState(@RequestParam
	 * Long id, @RequestParam String status) { try {
	 * checkboxService.saveCheckboxState(id, status);
	 * 
	 * return ResponseEntity.ok("Checkbox state saved successfully"); } catch
	 * (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Error saving checkbox state"); } }
	 */

	
	
	
	
	
}
