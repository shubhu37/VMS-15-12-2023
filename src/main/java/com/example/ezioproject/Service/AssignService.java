package com.example.ezioproject.Service;

import org.springframework.stereotype.Service;

import java.util.*;
import com.example.ezioproject.Model.Assign;
import com.example.ezioproject.Model.Checkbox;

@Service
public interface AssignService 
{

	public void save(List<Assign> assign);

	public List<Long> getVisitorIdByStates(String string);

	public List<Assign> getAllVisitorAssign();

	public String deleteAssignById(Long id);
	
    public  Assign approveMeeting(Long meetingId);

    public Assign rejectMeeting(Long meetingId);


	
}
