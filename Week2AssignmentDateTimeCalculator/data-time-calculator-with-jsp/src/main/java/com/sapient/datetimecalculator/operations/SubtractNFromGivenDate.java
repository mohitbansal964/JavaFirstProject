package com.sapient.datetimecalculator.operations;

import java.time.LocalDateTime;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class SubtractNFromGivenDate implements CalculatorOperation {

	public CalculatorOutput perform(CalculatorInput inp) {
		LocalDateTime date1 = inp.getDate1();
		NumericalDate date3 = inp.getDate3();

		LocalDateTime dateBeforNYears = date1.minusYears(date3.getNumberOfYears());
		LocalDateTime dateBeforeNMonths = dateBeforNYears.minusMonths(date3.getNumberOfMonths());
		LocalDateTime dateBeforeNWeeks = dateBeforeNMonths.minusWeeks(date3.getNumberOfWeeks());
		LocalDateTime result = dateBeforeNWeeks.minusDays(date3.getNumberOfDays());

		CalculatorOutput out = new CalculatorOutput();
		out.setDate(result);
		return out;
	}

}
