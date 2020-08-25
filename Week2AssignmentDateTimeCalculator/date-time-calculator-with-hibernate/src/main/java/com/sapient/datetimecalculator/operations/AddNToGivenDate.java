package com.sapient.datetimecalculator.operations;

import java.time.LocalDateTime;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class AddNToGivenDate implements CalculatorOperation {

	@Override
	public CalculatorOutput perform(CalculatorInput inp) {
		LocalDateTime date1 = inp.getDate1();
		NumericalDate date3 = inp.getDate3();

		LocalDateTime dateAfterNDays = date1.plusDays(date3.getNumberOfDays());
		LocalDateTime dateAfterNWeeks = dateAfterNDays.plusWeeks(date3.getNumberOfWeeks());
		LocalDateTime dateAfterNMonths = dateAfterNWeeks.plusMonths(date3.getNumberOfMonths());
		LocalDateTime result = dateAfterNMonths.plusYears(date3.getNumberOfYears());

		CalculatorOutput out = new CalculatorOutput();
		out.setDate(result);
		return out;
	}

}
