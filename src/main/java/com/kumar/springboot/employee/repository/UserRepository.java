package com.kumar.springboot.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.springboot.employee.entity.User;
import com.kumar.springboot.employee.entity.UserDto;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	UserView getUserByLastName(String lastName);
	
	UserDto getUserByFirstName(String firstName);
	
	<T>T getUserByFirstName(String firstName, Class<T> type);
}
