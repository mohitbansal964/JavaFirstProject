package com.sapient.datetimecalculator.operations;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class SubtractNFromGivenDateTest {

	private CalculatorOperation op;

	@Before
	public void setUp() throws Exception {
		op = new SubtractNFromGivenDate();
	}

	@Test
	public void subtract5DaysTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(5, 0, 0, 0));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("20-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void subtract5AllTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(5, 5, 5, 5));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("13-02-2015 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}
}
