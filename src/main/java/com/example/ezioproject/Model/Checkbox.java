package com.example.ezioproject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="checkdata")
public class Checkbox
{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;    
	
	private Long visitorId;

	private String status;


}
