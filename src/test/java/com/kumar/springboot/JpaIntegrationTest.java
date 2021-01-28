package com.kumar.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.kumar.springboot.employee.entity.UserDto;
import com.kumar.springboot.employee.repository.AddressRepository;
import com.kumar.springboot.employee.repository.AddressView;
import com.kumar.springboot.employee.repository.UserRepository;
import com.kumar.springboot.employee.repository.UserView;

@SpringBootTest
@Sql(scripts = "database/jpa-insert-data.sql")
@Sql(scripts = "database/jpa-delete-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class JpaIntegrationTest {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testClosedProjection() {
		AddressView addressView = addressRepository.getAddressByCity("Salem").get(0);
		assertThat(addressView.getPincode()).isEqualTo(636307);
	}

	@Test
	public void testNestedClosedProjection() {
		AddressView addressView = addressRepository.getAddressByCity("Salem").get(0);
		UserView userView = addressView.getUser();
		assertEquals("Satheesh Kumar", userView.getFirstName());
	}

	@Test
	@DisplayName("OpenProjection")
	public void testOpenProjection() {
		AddressView addressView = addressRepository.getAddressByCity("Salem").get(0);
		UserView userView = addressView.getUser();
		System.out.println(userView.getFullName());
		assertEquals("Satheesh Kumar Saravanan", userView.getFullName());

		userView = userRepository.getUserByLastName("Saravanan");
		System.out.println(userView.getFullName());
		assertEquals("Satheesh", userView.getFullName());

	}

	@Test
	@RepeatedTest(2)
	@DisplayName("ClassProjection")
	public void testClassProjection() {
		UserDto userDto = userRepository.getUserByFirstName("Satheesh Kumar");
		assertEquals("Saravanan", userDto.getLastName());
		assertEquals("Satheesh", userDto.getFirstName());
	}
	
	@Test
	@DisplayName("DynamicProjection")
	public void testDynamicProjection() {
		UserView userView = userRepository.getUserByFirstName("Satheesh Kumar", UserView.class);
		assertEquals("Satheesh Kumar", userView.getFirstName());
		
		UserDto userDto = userRepository.getUserByFirstName("Satheesh Kumar", UserDto.class);
		assertEquals("Saravanan", userDto.getLastName());
	}
}