package com.sapient.week7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeJavaContainer {
	@Bean
	public Employee emp4() {
		Employee e = new Employee();
		e.setId(104);
		e.setName("efg");
		e.setCity("New Delhi");
		return e;
	}

	@Bean
	public Employee emp5() {
		Employee e = new Employee();
		e.setId(105);
		e.setName("abc");
		e.setCity("Pune");
		return e;
	}

	@Bean
	public Employee emp6() {
		Employee e = new Employee();
		e.setId(106);
		e.setName("klm");
		e.setCity("Noida");
		return e;
	}
}
