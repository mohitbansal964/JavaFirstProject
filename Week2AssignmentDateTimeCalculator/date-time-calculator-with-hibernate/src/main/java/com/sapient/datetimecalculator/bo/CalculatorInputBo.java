package com.sapient.datetimecalculator.bo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorInputDao;
import com.sapient.datetimecalculator.dbms.NumericalDate;
import com.sapient.datetimecalculator.dbms.NumericalDateDao;

public class CalculatorInputBo {
	private NumericalDateDao numDateDao;
	private CalculatorInputDao inpDao;

	public CalculatorInputBo() {
		numDateDao = new NumericalDateDao();
		inpDao = new CalculatorInputDao();
	}

	public CalculatorInput calculatorInput() {
		System.out.println();
		System.out.print("Enter choice: ");
		int choice = Reader.scan.nextInt();
		Reader.scan.nextLine();
		if (choice == -1 || choice == 7 || choice == 8) {
			return new CalculatorInput(choice, null, null, null);
		}
		System.out.print("Enter Date and Time in (dd-mm-yyyy hh:mm:ss) format: ");
		String dateText = Reader.scan.nextLine();
		LocalDateTime date1 = LocalDateTime.parse(dateText, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		LocalDateTime date2 = null;
		NumericalDate date3 = null;
		if (choice == 2) {
			System.out.print("Enter Date and Time in (dd-mm-yyyy hh:mm:ss) format: ");
			dateText = Reader.scan.nextLine();
			date2 = LocalDateTime.parse(dateText, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		}
		if (choice == 1 || choice == 3 || choice == 4) {
			int numberOfDays = 0;
			int numberOfWeeks = 0;
			int numberOfMonths = 0;
			int numberOfYears = 0;
			System.out.print("Enter number of days: ");
			numberOfDays = Reader.scan.nextInt();
			System.out.print("Enter number of weeks: ");
			numberOfWeeks = Reader.scan.nextInt();
			System.out.print("Enter number of months: ");
			numberOfMonths = Reader.scan.nextInt();
			System.out.print("Enter number of years: ");
			numberOfYears = Reader.scan.nextInt();
			date3 = new NumericalDate(numberOfDays, numberOfWeeks, numberOfMonths, numberOfYears);
			numDateDao.insert(date3);
		}
		CalculatorInput input = new CalculatorInput(choice, date1, date2, date3);
		Integer id = inpDao.insert(input);
		return input;
	}

}
