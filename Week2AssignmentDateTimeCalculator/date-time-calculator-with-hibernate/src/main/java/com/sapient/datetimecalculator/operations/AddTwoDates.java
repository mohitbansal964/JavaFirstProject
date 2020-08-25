package com.sapient.datetimecalculator.operations;

import java.time.LocalDateTime;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class AddTwoDates implements CalculatorOperation {

	@Override
	public CalculatorOutput perform(CalculatorInput inp) {
		LocalDateTime date1 = inp.getDate1();
		NumericalDate date3 = inp.getDate3();

		LocalDateTime dateAfterNDays = date1.plusDays(date3.getNumberOfDays());
		LocalDateTime dateAfterNWeeks = dateAfterNDays.plusWeeks(date3.getNumberOfWeeks());
		LocalDateTime dateAfterNMonths = dateAfterNWeeks.plusMonths(date3.getNumberOfMonths());
		LocalDateTime finalDate = dateAfterNMonths.plusYears(date3.getNumberOfYears());

		int day = finalDate.getDayOfMonth() % 7;
		int week = finalDate.getDayOfMonth() / 7;
		int month = finalDate.getMonthValue();
		int year = finalDate.getYear();

		NumericalDate result = new NumericalDate(day, week, month, year);
		CalculatorOutput out = new CalculatorOutput();
		out.setNumericalDate(result);
		return out;
	}

}
