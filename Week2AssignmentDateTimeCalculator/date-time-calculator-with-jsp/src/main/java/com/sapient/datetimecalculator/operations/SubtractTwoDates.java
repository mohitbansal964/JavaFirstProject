package com.sapient.datetimecalculator.operations;

import java.time.LocalDateTime;
import java.time.Period;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class SubtractTwoDates implements CalculatorOperation {

	public CalculatorOutput perform(CalculatorInput inp) {
		LocalDateTime date1 = inp.getDate1();
		LocalDateTime date2 = inp.getDate2();

		NumericalDate result;
		Period period = Period.between(date1.toLocalDate(), date2.toLocalDate());
		int numberOfDays = Math.abs(period.getDays()) % 7;
		int numberOfWeeks = Math.abs(period.getDays()) / 7;
		int numberOfMonths = Math.abs(period.getMonths());
		int numberOfYears = Math.abs(period.getYears());
		result = new NumericalDate(numberOfDays, numberOfWeeks, numberOfMonths, numberOfYears);

		CalculatorOutput out = new CalculatorOutput();
		out.setNumericalDate(result);
		return out;

	}

}
