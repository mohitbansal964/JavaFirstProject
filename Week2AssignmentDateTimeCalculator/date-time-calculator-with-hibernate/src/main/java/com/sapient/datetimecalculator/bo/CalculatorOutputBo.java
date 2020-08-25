package com.sapient.datetimecalculator.bo;

import java.time.format.DateTimeFormatter;

import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.CalculatorOutputDao;
import com.sapient.datetimecalculator.dbms.NumericalDateDao;

public class CalculatorOutputBo {
	private NumericalDateDao numDateDao;
	private CalculatorOutputDao outDao;

	public CalculatorOutputBo() {
		numDateDao = new NumericalDateDao();
		outDao = new CalculatorOutputDao();
	}

	public Integer calculatorOutput(CalculatorOutput out, int choice) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		if (choice == 3 || choice == 4) {
			String formatDateTime = out.getDate().format(format);
			System.out.println("Result: " + formatDateTime);
		} else if (choice == 1 || choice == 2) {
			System.out.println("Result -");
			System.out.println("Number of days: " + out.getNumericalDate().getNumberOfDays());
			System.out.println("Number of weeks: " + out.getNumericalDate().getNumberOfWeeks());
			System.out.println("Number of months: " + out.getNumericalDate().getNumberOfMonths());
			System.out.println("Number of years: " + out.getNumericalDate().getNumberOfYears());
			numDateDao.insert(out.getNumericalDate());
		} else if (choice == 5) {
			System.out.println("Result: " + out.getDayOfWeek());
		} else if (choice == 6) {
			System.out.println("Result: " + out.getWeekNumber());
		}
		Integer id = outDao.insert(out);
		return id;

	}
}
