package com.kumar.springboot.employee.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class ProductRating {

	@EmbeddedId
	ProductRatingKey productRatingKey;

	int rating;
}
