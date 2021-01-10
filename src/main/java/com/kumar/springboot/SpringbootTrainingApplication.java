package com.kumar.springboot;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SpringbootTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrainingApplication.class, args);
	}
	
}
