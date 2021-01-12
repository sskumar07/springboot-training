package com.kumar.springboot.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kumar.springboot.employee.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	/* JPQL */
	//@Query("select c from Customer c Where customername= 'Satheesh'")
	
	/* Native Query */
	//@Query(value="SELECT * FROM Customer WHERE customername='Satheesh'", nativeQuery=true)
	@Modifying
	@Query(value="update Customer c set c.customerName='sat' WHERE c.customerName='Satheesh'")
	void getAllData();
}
