package com.kumar.springboot.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	int customerId;
	
	String customerName;
	
	@OneToOne(mappedBy = "customer", cascade= CascadeType.ALL)
	Product product;
}
