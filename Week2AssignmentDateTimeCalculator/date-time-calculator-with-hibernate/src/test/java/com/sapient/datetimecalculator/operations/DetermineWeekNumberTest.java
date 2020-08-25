package com.sapient.datetimecalculator.operations;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.sapient.datetimecalculator.dbms.CalculatorInput;

public class DetermineWeekNumberTest {
	private CalculatorOperation op;

	@Before
	public void setUp() throws Exception {
		op = new DetermineWeekNumber();
	}

	@Test
	public void weekNumberTest() {
		LocalDateTime date1 = LocalDateTime.parse("01-01-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		Integer actual = op.perform(inp).getWeekNumber();
		Integer expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void weekNumberTest2() {
		LocalDateTime date1 = LocalDateTime.parse("23-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		Integer actual = op.perform(inp).getWeekNumber();
		Integer expected = 34;
		assertEquals(expected, actual);
	}

}
