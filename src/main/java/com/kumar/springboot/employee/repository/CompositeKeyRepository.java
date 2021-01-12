package com.kumar.springboot.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kumar.springboot.employee.entity.ProductRating;
import com.kumar.springboot.employee.entity.ProductRatingKey;

public interface CompositeKeyRepository extends JpaRepository<ProductRating, ProductRatingKey>{

}
