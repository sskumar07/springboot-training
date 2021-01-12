package com.kumar.springboot.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Product{
	
	@Id
	int productId;
	
	String productName;
	
	@OneToOne
	@JoinColumn(name="customerId", referencedColumnName = "customerId")
	Customer customer;
}