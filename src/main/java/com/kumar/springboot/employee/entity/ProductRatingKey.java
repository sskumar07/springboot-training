package com.kumar.springboot.employee.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class ProductRatingKey implements Serializable{
	private int productId;
	private int customerId;
}
