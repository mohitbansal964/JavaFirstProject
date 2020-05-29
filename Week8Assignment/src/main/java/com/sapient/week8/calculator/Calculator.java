package com.sapient.week8.calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		int a, b, ch;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number: ");
		a = scan.nextInt();
		System.out.println("Enter Second Number: ");
		b = scan.nextInt();
		System.out.println("Enter choice: 1 for add, 2 for sub, 3 for mul, 4 for div: ");
		ch = scan.nextInt();
		Operation op;
		switch (ch) {
		case 1:
			op = new Addition();
			break;
		case 2:
			op = new Subtraction();
			break;
		case 3:
			op = new Multiplication();
			break;
		case 4:
			op = new Division();
			break;
		default:
			op = new Addition();
		}
		int result = op.calculate(a, b);
		System.out.println("Result = " + result);
		scan.close();
	}

}
