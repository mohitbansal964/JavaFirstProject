package com.sapient.week8.employee;

import java.util.ArrayList;
import java.util.List;

public class AddEmployee {

	private List<Employee> list;

	public AddEmployee() {
		list = new ArrayList<Employee>();
	}

	public void addEmployee(Employee emp) {
		list.add(emp);
	}

	public Employee getEmployee(int id) {
		for (Employee emp : list) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

}
