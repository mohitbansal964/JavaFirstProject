package com.sapient.datetimecalculator;

import java.util.HashMap;
import java.util.Map;

import com.sapient.datetimecalculator.bo.CalculatorInputBo;
import com.sapient.datetimecalculator.bo.CalculatorOutputBo;
import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.operations.AddNToGivenDate;
import com.sapient.datetimecalculator.operations.AddTwoDates;
import com.sapient.datetimecalculator.operations.CalculatorOperation;
import com.sapient.datetimecalculator.operations.DetermineDayOfWeek;
import com.sapient.datetimecalculator.operations.DetermineWeekNumber;
import com.sapient.datetimecalculator.operations.SubtractNFromGivenDate;
import com.sapient.datetimecalculator.operations.SubtractTwoDates;

public class Calculator {
	public static void main(String[] args) {
		Map<Integer, CalculatorOperation> switchMap = new HashMap<Integer, CalculatorOperation>();
		switchMap.put(1, new AddTwoDates());
		switchMap.put(2, new SubtractTwoDates());
		switchMap.put(3, new AddNToGivenDate());
		switchMap.put(4, new SubtractNFromGivenDate());
		switchMap.put(5, new DetermineDayOfWeek());
		switchMap.put(6, new DetermineWeekNumber());

		Menu menu = new Menu();
		menu.displayMenu();
		CalculatorInputBo inpBo = new CalculatorInputBo();
		CalculatorOutputBo outBo = new CalculatorOutputBo();
		CalculatorInput inp = inpBo.calculatorInput();
		int choice = inp.getChoice();
		CalculatorOutput out = null;
		while (choice != -1) {
			out = switchMap.get(inp.getChoice()).perform(inp);
			Integer outId = outBo.calculatorOutput(out, choice);
			inp = inpBo.calculatorInput();
			choice = inp.getChoice();
		}

		System.out.println("Closing...");
	}

}
