package com.example.ezioproject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ezioproject.Model.Assign;



@Repository("AssignRepo")
public interface AssignRepo extends JpaRepository<Assign, Long>
{

public void save(List<Assign> assign);

	
	

}
