package com.example.ezioproject.Model;

import java.time.LocalDateTime;
import java.util.Date;


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
@Table(name = "assigndata")
public class Assign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    // select the multiple employee that time increment the id
	private Long id;

	private Long employeeid;

	private Long visitorId;

	private String visitorname;
	
	private String visitoremail;

	private String employeename;
	
	private String employeeemail;

	private String reason;
	
	private String timestamp;

	private String status;


	

}
