package com.example.ezioproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Checkbox;

@Service
public interface CheckboxService 
{
	public void save(Checkbox checkbox);

    public Checkbox findByVisitorId(Long visitorId);

	public List<Checkbox> getAllCheckboxStates();

	public void saveCheckboxState(Long id, String status);

	public void truncateCheckData();

//	public void truncateMeetRow();     

	
}
