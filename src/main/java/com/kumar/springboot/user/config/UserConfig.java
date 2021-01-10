package com.kumar.springboot.user.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory",
transactionManagerRef = "userTransactionManager",
basePackages = {
 "com.kumar.springboot.user.repository"
})
public class UserConfig {

	@Primary
	@Bean(name="userDataSource")
	@ConfigurationProperties(prefix="spring.datasource.training2")
	public DataSource userDataSource(){
		return DataSourceBuilder.create().build();	
	}

	@Primary
	@Bean(name="userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("userDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.kumar.springboot.user.entity").persistenceUnit("mysql_training2").build();
	}
	
	@Primary
	@Bean(name="userTransactionManager")
	public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory);
	}
}
