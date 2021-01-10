package com.kumar.springboot.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employee", schema="mysql_training1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	int id;
	String name;
	int salary;
	
}
