package com.sapient.student;

public class StudentRunner {

	public static void main(String[] args) {
		StudentBO cls = new StudentBO();
		cls.addStudent();
		cls.addStudent();
		cls.addStudent();
		cls.displayStudents();
		cls.displayStudents("New Delhi");
		cls.sortByCity();
		cls.sortByName();
		cls.displayStudent(1);
		cls.displayStudent(10);
	}

}
