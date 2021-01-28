package com.kumar.springboot.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	Integer id;
	
	@OneToOne
	User user;
	
	String state;
	
	String city;
	
	Integer pincode;
}
