package com.kumar.springboot.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	Integer userId;
	
	public String firstName;
	
	public String lastName;
	
	@OneToOne(mappedBy = "user")
	Address address;
}
