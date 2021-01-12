package com.kumar.springboot;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.kumar.springboot.employee.entity.ProductRating;
import com.kumar.springboot.employee.entity.ProductRatingKey;
import com.kumar.springboot.employee.repository.CompositeKeyRepository;
import com.kumar.springboot.employee.repository.CustomerRepository;

@SpringBootTest
class SpringbootTrainingApplicationTests {

	@Autowired
	CompositeKeyRepository compositeRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	//@Test
	public void testCompositeKey() {
		Optional<ProductRating> a = compositeRepository.findById(new ProductRatingKey(1,1));
		System.out.println(a.get().getRating());
	}
	
	//@Test
	public void testCascade() {
		customerRepository.deleteById(1);
	}
	
	@Test
	@Transactional("employeeTransactionManager")
	public void testCustomQuery() {
		customerRepository.getAllData();
	}
}
