package com.sapient.datetimecalculator.operations;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;

public class DetermineWeekNumber implements CalculatorOperation {

	@Override
	public CalculatorOutput perform(CalculatorInput inp) {
		LocalDateTime date1 = inp.getDate1();
		Integer result = date1.get(ChronoField.ALIGNED_WEEK_OF_YEAR);

		CalculatorOutput out = new CalculatorOutput();
		out.setWeekNumber(result);
		return out;
	}

}
