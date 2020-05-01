package com.sapient.numprocess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumProcessRunner {

	public static void main(String[] args) {
		NumProcess add = (num1, num2) -> num1 + num2;
		NumProcess subtract = (num1, num2) -> num1 - num2;
		NumProcess multiply = (num1, num2) -> num1 * num2;
		NumProcess divide = (num1, num2) -> num1 / num2;

		int num1, num2, choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		System.out.println("Enter choice: ");
		choice = scan.nextInt();
		scan.close();

		Map<Integer, NumProcess> calculator = new HashMap<>();
		calculator.put(1, add);
		calculator.put(2, subtract);
		calculator.put(3, multiply);
		calculator.put(4, divide);
		System.out.println("Num1 = " + num1);
		System.out.println("Num2 = " + num2);
		NumProcess op = calculator.get(choice);
		int num3 = op.call(num1, num2);
		System.out.println("After operation = " + num3);

	}
}
