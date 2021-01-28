package com.kumar.springboot.employee.entity;

import lombok.Data;

@Data
public class UserDto {
	String firstName;
	String lastName;

	public UserDto(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
