package com.kumar.springboot.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kumar.springboot.employee.entity.Employee;
import com.kumar.springboot.employee.repository.EmployeeRepository;
import com.kumar.springboot.exception.UserNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(Integer id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isEmpty())
			throw new UserNotFoundException("Employee is not found");
		else
			return employeeOptional.get();
	}

	public List<Employee> getEmployees(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Employee> pagedResult = employeeRepository.findAll(paging);
		System.err.println(pagedResult.getTotalPages());
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}


}
