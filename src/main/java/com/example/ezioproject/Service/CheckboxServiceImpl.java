package com.example.ezioproject.Service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Checkbox;
import com.example.ezioproject.Repo.CheckboxRepo;

@Service
public class CheckboxServiceImpl implements CheckboxService {

	@Autowired
	private CheckboxRepo checkboxRepo;

	@Override
	public void save(Checkbox checkbox)
	{
		checkboxRepo.save(checkbox);
	}

	@Override
	public Checkbox findByVisitorId(Long visitorId)
	{

		return checkboxRepo.findByVisitorId(visitorId);
	}

	
	@Override
	public List<Checkbox> getAllCheckboxStates()
	{
		List<Checkbox> checkboxes = checkboxRepo.findByStatus("true");
		
		return checkboxes;
	}

	
	
	@Override
	public void saveCheckboxState(Long id, String status) {
		Checkbox checkbox = checkboxRepo.findById(id).orElse(null);

		if (checkbox != null) 
		{
			checkbox.setStatus(status);

			checkboxRepo.save(checkbox);
		}
	}

	
	   @Override
	    public void truncateCheckData()
	     {
	        checkboxRepo.truncateCheckData();
	    }
	

	
	
}


