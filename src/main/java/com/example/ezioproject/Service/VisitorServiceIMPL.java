package com.example.ezioproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ezioproject.Model.Employee;
import com.example.ezioproject.Model.Visitor;
import com.example.ezioproject.Repo.EmployeeRepo;
import com.example.ezioproject.Repo.VisitorRepo;

@Service
public  class VisitorServiceIMPL  implements VisitorService 
	{

	@Autowired
	private VisitorRepo visitorRepo;
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	
    
    @Override
    public List<Visitor> getAllVisitors() 
    {
    	
        return visitorRepo.findAll();  
        
    }
    
    
    @Override
    public void saveVisitor(Visitor visitor)
    {
    	visitorRepo.save(visitor);
    }
    
    

	@Override
	public void deleteVisitorById(Long id) 
	 {
	    this.visitorRepo.deleteById(id);
		
	}
	
	
	@Override
	public Visitor find(Long id) {
		
		return visitorRepo.findById(id).get();
	}
     
    
	
	@Override
	 public Visitor getVisitorById(Long id)
		
	{
		Optional<Visitor> Optional = visitorRepo.findById(id);
		
		Visitor visitor = null;
		
		if(Optional.isPresent())
		{
			visitor = Optional.get();			
		}
		
		else
		{
			throw new RuntimeException("not found id :  "+ id);
		}
		
		return visitor;
		
	 }


	@Override
	public long countAll()
	{
		
		return visitorRepo.count();
		
	}

	

	 @Override
	    public void updateStatusToAssign(Long visitorId)
	 {
	       
	        Visitor visitor = visitorRepo.findById(visitorId).orElse(null);

	        if (visitor != null)
	           {
	            visitor.setStatus("ASSIGN"); 
	            visitorRepo.save(visitor);
	            
	        }
	    }
	 
	 
	}
