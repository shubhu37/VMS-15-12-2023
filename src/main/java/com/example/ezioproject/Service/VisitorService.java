package com.example.ezioproject.Service;

import java.util.List;


import com.example.ezioproject.Model.Visitor;

public interface VisitorService
{

	List<Visitor> getAllVisitors();

	void saveVisitor(Visitor visitor);
	
	public void deleteVisitorById(Long id);

	public Visitor getVisitorById(Long id);

	public Visitor find(Long id);

	public long countAll();

    public void updateStatusToAssign(Long id);
    

	

}
