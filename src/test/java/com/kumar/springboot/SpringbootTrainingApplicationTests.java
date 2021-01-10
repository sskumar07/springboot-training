package com.kumar.springboot;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.web.client.RestTemplate;

import com.kumar.springboot.employee.entity.Employee;
import com.kumar.springboot.employee.repository.EmployeeRepository;
import com.kumar.springboot.employee.service.EmployeeService;

@SpringBootTest
class SpringbootTrainingApplicationTests {

	@Autowired
	RestTemplate restTemplate;
	
	String url = "http://localhost:8081/";
	
	@Test
	public void testGetEmployee() {
		Employee employee = restTemplate.getForObject(url + "getEmployee/1", Employee.class);
		Assertions.assertNotNull(employee);
	}
	
	
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Test
	public void testMockGetEmployee() {
		Employee employee = new Employee(1, "Saravanan", 30000);
		Optional<Employee> employeeOptional = Optional.of(employee);
		
		when(employeeRepository.findById(1)).thenReturn(employeeOptional);
//		Employee employees = restTemplate.getForObject(url + "getEmployee/1", Employee.class);
		
		Employee employees = employeeService.getEmployee(employee.getId());
		System.out.println(employees.getName());
		Assertions.assertNotNull(employee);
	}
}
