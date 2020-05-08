package com.sapient.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		return stu1.getName().compareToIgnoreCase(stu2.getName());
	}

}

class CityComparator implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		// TODO Auto-generated method stub
		return stu1.getCity().compareToIgnoreCase(stu2.getCity());
	}

}

public class StudentBO {
	private List<Student> students;
	private Scanner scan;
	public StudentBO() {
		this.students = new ArrayList<>();
		this.scan = new Scanner(System.in);
	}

	private Student readStudent() {

		Student newStudent = new Student();
		System.out.println("Enter Student details: ");
		System.out.println("Enter id: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Name: ");
		String name = scan.nextLine();
		System.out.println("Enter city: ");
		String city = scan.nextLine();
		newStudent.setId(id);
		newStudent.setName(name);
		newStudent.setCity(city);
		return newStudent;
	}

	public void addStudent() {
		Student newStudent = readStudent();
		students.add(newStudent);
	}

	public void displayStudents() {
		System.out.println("Displaying all students:");
		students.stream().forEach(System.out::println);
	}

	public void displayStudents(String city) {
		System.out.println("Displaying students for city= " + city);
		students.stream().filter(student -> student.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
	}

	public void sortByName() {
		System.out.println("Sorted by name: ");
		students.stream().sorted(new NameComparator()).forEach(System.out::println);
	}

	public void sortByCity() {
		System.out.println("Sorted by city: ");
		students.stream().sorted(new CityComparator()).forEach(System.out::println);

	}

	public void displayStudent(int id) throws RuntimeException {
		System.out.println("Displaying student for id= " + id);
		boolean flag = false;
		for (Student stu : students) {
			if (stu.getId() == id) {
				flag = true;
				System.out.println(stu);
				break;
			}
		}
		if (!flag) {
			throw new RuntimeException("ID not found");
		}
	}

	@Override
	public void finalize() {
		scan.close();
	}

}
