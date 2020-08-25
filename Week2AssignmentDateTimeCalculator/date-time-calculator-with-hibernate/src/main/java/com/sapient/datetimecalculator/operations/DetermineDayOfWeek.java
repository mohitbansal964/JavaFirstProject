package com.sapient.datetimecalculator.operations;

import java.time.LocalDateTime;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;

public class DetermineDayOfWeek implements CalculatorOperation {

	@Override
	public CalculatorOutput perform(CalculatorInput inp) {
		LocalDateTime date1 = inp.getDate1();
		String result = date1.getDayOfWeek().toString();

		CalculatorOutput out = new CalculatorOutput();
		out.setDayOfWeek(result);
		return out;
	}

}
