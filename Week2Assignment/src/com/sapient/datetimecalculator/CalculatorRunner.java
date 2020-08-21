package com.sapient.datetimecalculator;

import java.time.LocalDateTime;

public class CalculatorRunner {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.displayMenu();

		LocalDateTime d1, d2, d3;
		DateTime n, result;

		int choice = cal.enterChoice();
		switch (choice) {
		case 1:
			d1 = cal.enterDate();
			d2 = cal.enterDate();
			result = cal.subtractTwoDates(d1, d2);
			cal.displayResult(result);
			break;
		case 2:
			d1 = cal.enterDate();
			n = cal.enterN();
			d3 = cal.addNToGivenDate(d1, n);
			cal.displayDate(d3);
			break;
		case 3:
			d1 = cal.enterDate();
			n = cal.enterN();
			d3 = cal.subtractNToGivenDate(d1, n);
			cal.displayDate(d3);
			break;
		case 4:
			d1 = cal.enterDate();
			System.out.println("Result: " + cal.dayOfWeek(d1));
			break;
		case 5:
			d1 = cal.enterDate();
			System.out.println("Result: " + cal.weekNumber(d1));
			break;

		}

	}

}
