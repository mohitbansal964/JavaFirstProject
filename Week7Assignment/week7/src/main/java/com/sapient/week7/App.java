package com.sapient.week7;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
	public static void main( String[] args )
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("Spring-Module.xml");
		Employee emp = (Employee) factory.getBean("emp1");
		System.out.println(emp);

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter emp: ");
		String empId = scan.next();

		Employee emp1 = (Employee) factory.getBean(empId);
		System.out.println(emp1);
		scan.close();

		ApplicationContext factory1 = new AnnotationConfigApplicationContext(EmployeeJavaContainer.class);
		Employee emp2 = (Employee) factory1.getBean("emp5");
		System.out.println(emp2);

	}
}
