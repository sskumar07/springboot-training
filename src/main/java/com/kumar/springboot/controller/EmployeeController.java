package com.kumar.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.springboot.entity.DemoData;

@RestController
@CrossOrigin("http://localhost:4201")
public class EmployeeController {

	@GetMapping("/getData")
	public ResponseEntity<DemoData> getDataInterceptor() {
		DemoData data = new DemoData(1, "Satheesh");
		//return new ResponseEntity<String>("Success", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}
