package com.example.ezioproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Assign;
import com.example.ezioproject.Model.Checkbox;
import com.example.ezioproject.Repo.AssignRepo;
import com.example.ezioproject.Repo.CheckboxRepo;

@Service
public class AssignServiceIMPL implements AssignService {
	@Autowired
	private AssignRepo assignRepo;

	@Autowired
	private CheckboxRepo checkboxRepo;

	@Override
	public void save(List<Assign> assign)
	{
		assignRepo.save(assign);
	}

	@Override
	public List<Long> getVisitorIdByStates(String status)
	{
		return checkboxRepo.findVisitorIdByStatus(status);
	}

	@Override
	public List<Assign> getAllVisitorAssign()
	{
	return assignRepo.findAll();

	}

	@Override
	public String deleteAssignById(Long id)
	{
	 this .assignRepo.deleteById(id);
	 
	return null;   
	
	}

	
	 public Assign approveMeeting(Long meetingId)
	 {
	        Assign assign = assignRepo.findById(meetingId).orElse(null);
	        if (assign != null)
	        {
	            return assignRepo.save(assign);
	        }
	        
	        return null; 
	    }
	 
	 
	 public Assign rejectMeeting(Long meetingId) 
	   {
	        Assign assign = assignRepo.findById(meetingId).orElse(null);
	        if (assign != null) 
	        {
	            return assignRepo.save(assign);
	        }
	        return null; 
	    }

	
	
	
	

}
