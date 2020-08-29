package com.sapient.datetimecalculator.bo;

import java.time.LocalDateTime;

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

	public CalculatorInput convert(int choice, LocalDateTime date1, LocalDateTime date2, int numberOfDays,
			int numberOfWeeks, int numberOfMonths, int numberOfYears) {
		NumericalDate date3 = null;
		if (choice == 0 || choice == 2 || choice == 3) {
			date3 = new NumericalDate(numberOfDays, numberOfWeeks, numberOfMonths, numberOfYears);
			numDateDao.insert(date3);
		}
		CalculatorInput input = new CalculatorInput(choice, date1, date2, date3);
		Integer id = inpDao.insert(input);
		return input;
	}

}
