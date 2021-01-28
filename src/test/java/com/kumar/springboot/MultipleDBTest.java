package com.kumar.springboot;

import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kumar.springboot.employee.entity.Employee;
import com.kumar.springboot.employee.repository.EmployeeRepository;
import com.kumar.springboot.user.entity.User1;
import com.kumar.springboot.user.repository.User1Repository;

@SpringBootTest
@EnableTransactionManagement
public class MultipleDBTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private User1Repository userRepository;

	@Test
	public void testEmployee() {
		Employee employee = new Employee(1, "Satheesh", 15000);
		employeeRepository.save(employee);
		Employee data = employeeRepository.findById(employee.getId()).get();
		System.out.println(data.getName());
		Assertions.assertNotNull(employeeRepository.findById(employee.getId()).get());
	}

	@Test
	public void testUser() {
		User1 user = new User1(1, "Kumar");
		userRepository.save(user);
		User1 data = userRepository.findById(user.getId()).get();
		System.out.println(data.getName());
		Assertions.assertNotNull(userRepository.findById(user.getId()).get());
	}
}