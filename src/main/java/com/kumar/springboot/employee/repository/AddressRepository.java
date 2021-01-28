package com.kumar.springboot.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.springboot.employee.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<AddressView> getAddressByCity(String city);
}
