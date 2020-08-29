package com.sapient.datetimecalculator.operations;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class SubtractTwoDatesTest {
	private SubtractTwoDates op;

	@Before
	public void setUp() throws Exception {
		op = new SubtractTwoDates();
	}

	@Test
	public void test() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:30:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		LocalDateTime date2 = LocalDateTime.parse("12-04-1999 14:10:13",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, date2, null);
		NumericalDate actual = op.perform(inp).getNumericalDate();
		NumericalDate expected = new NumericalDate(6, 1, 4, 21);
		assertTrue(actual.equals(expected));

	}

}
