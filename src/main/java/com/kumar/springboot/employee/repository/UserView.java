package com.kumar.springboot.employee.repository;

import org.springframework.beans.factory.annotation.Value;

public interface UserView {
	String getFirstName();
	
	@Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
