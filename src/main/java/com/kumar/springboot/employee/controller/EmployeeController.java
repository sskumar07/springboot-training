package com.kumar.springboot.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.springboot.employee.entity.DemoData;
import com.kumar.springboot.employee.entity.Employee;
import com.kumar.springboot.employee.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:4201")
public class EmployeeController {

	@Autowired	
	EmployeeService employeeService;
	
	@GetMapping("/getData")
	public ResponseEntity<DemoData> getDataInterceptor() {
		DemoData data = new DemoData(1, "Satheesh");
		//return new ResponseEntity<String>("Success", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
		return employeeService.getEmployees(pageNo, pageSize, sortBy);
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@GetMapping(path = {"/getEmployee", "/getEmployee/{id}"})
	public Employee getEmployee(@PathVariable Optional<Integer> id) {
		if(id.isEmpty())
			return new Employee();
		return employeeService.getEmployee(id.get());
	}	

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
