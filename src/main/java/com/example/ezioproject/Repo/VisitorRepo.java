package com.example.ezioproject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ezioproject.Model.Visitor;


@Repository
public interface VisitorRepo extends JpaRepository<Visitor, Long> 
{

	
	
	/*
	 * @Query(value =
	 * "SELECT visitordata.name , visitordata.reason FROM  `visitor-managment-system`.visitordata"
	 * , nativeQuery = true) List<Visitor> getAllVisitors();
	 */
}
