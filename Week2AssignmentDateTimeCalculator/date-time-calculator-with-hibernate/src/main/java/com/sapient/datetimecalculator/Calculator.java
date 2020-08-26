package com.sapient.datetimecalculator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.sapient.datetimecalculator.bo.CalculatorInputBo;
import com.sapient.datetimecalculator.bo.CalculatorOutputBo;
import com.sapient.datetimecalculator.bo.HistoryBo;
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
		menu.addChoice("Display Session History");
		menu.addChoice("Display History of Last 100 Sessions");
		menu.displayMenu();
		CalculatorInputBo inpBo = new CalculatorInputBo();
		CalculatorOutputBo outBo = new CalculatorOutputBo();
		HistoryBo historyBo = new HistoryBo();
		LocalDateTime now = LocalDateTime.now();
		CalculatorInput input = inpBo.calculatorInput();
		int choice = input.getChoice();
		CalculatorOutput output = null;
		while (choice != -1) {
			if (choice <= 6) {
				output = switchMap.get(choice).perform(input);
				Integer outId = outBo.calculatorOutput(output, choice);
				historyBo.addHistory(now, input, output);
			} else if (choice == 7) {
				historyBo.displaySessionHistory(now);
			} else if (choice == 8) {
				historyBo.displayLast100SessionsHistory();
			}
			input = inpBo.calculatorInput();
			choice = input.getChoice();

		}

		System.out.println("Closing...");
	}

}
