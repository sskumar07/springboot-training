package com.kumar.springboot.employee.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "employeeEntityManagerFactory",
transactionManagerRef = "employeeTransactionManager",
basePackages = {
 "com.kumar.springboot.employee.repository"
})
public class EmployeeConfig {

//	@Primary
	@Bean(name="employeeDataSource")
	@ConfigurationProperties(prefix="spring.datasource.training1")
	public DataSource employeeDataSource(){
		return DataSourceBuilder.create().build();	
	}

//	@Primary
	@Bean(name="employeeEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("employeeDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.kumar.springboot.employee.entity").persistenceUnit("mysql_training1").build();
	}
	
//	@Primary
	@Bean(name="employeeTransactionManager")
	public PlatformTransactionManager employeeTransactionManager(@Qualifier("employeeEntityManagerFactory") EntityManagerFactory employeeEntityManagerFactory) {
		return new JpaTransactionManager(employeeEntityManagerFactory);
	}
}
