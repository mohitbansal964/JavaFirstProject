package com.sapient.week8.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddEmployeeTest {

	private AddEmployee empList;

	@BeforeEach
	void setUp() {
		empList = new AddEmployee();
		Employee emp1 = new Employee(1, "Mohit", "New Delhi");
		Employee emp2 = new Employee(2, "abcd", "Mumbai");
		Employee emp3 = new Employee(3, "xyz", "Bangalore");
		empList.addEmployee(emp1);
		empList.addEmployee(emp2);
		empList.addEmployee(emp3);
	}

	@Test
	void testGetEmployee() {
		Employee emp = empList.getEmployee(1);
		Employee emp1 = new Employee(1, "Mohit", "New Delhi");
		assertNotNull(emp);
		assertEquals(emp1, emp);
	}

	@Test
	void testGetEmployeeForNull() {
		Employee emp = empList.getEmployee(0);
		assertNull(emp);
	}

}
