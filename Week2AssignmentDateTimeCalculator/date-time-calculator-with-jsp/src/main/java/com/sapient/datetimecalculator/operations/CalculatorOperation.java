package com.sapient.datetimecalculator.operations;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;

public interface CalculatorOperation {

	public CalculatorOutput perform(CalculatorInput inp);

}
