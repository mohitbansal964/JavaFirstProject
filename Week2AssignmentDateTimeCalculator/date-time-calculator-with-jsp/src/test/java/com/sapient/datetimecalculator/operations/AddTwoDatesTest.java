package com.sapient.datetimecalculator.operations;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class AddTwoDatesTest {
	private AddTwoDates op;

	@Before
	public void setUp() throws Exception {
		op = new AddTwoDates();
	}

	@Test
	public void addingDaysTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:30:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(2, 0, 0, 0));
		NumericalDate actual = op.perform(inp).getNumericalDate();
		NumericalDate expected = new NumericalDate(6, 3, 8, 2020);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void addingWeeksTest() {
		LocalDateTime date1 = LocalDateTime.parse("15-08-2020 18:30:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(0, 1, 0, 0));
		NumericalDate actual = op.perform(inp).getNumericalDate();
		NumericalDate expected = new NumericalDate(1, 3, 8, 2020);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void addingMonthsTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:30:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(0, 0, 3, 0));
		NumericalDate actual = op.perform(inp).getNumericalDate();
		NumericalDate expected = new NumericalDate(4, 3, 11, 2020);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void addingYearsTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:30:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(0, 0, 0, 4));
		NumericalDate actual = op.perform(inp).getNumericalDate();
		NumericalDate expected = new NumericalDate(4, 3, 8, 2024);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void addingAllTest() {
		LocalDateTime date1 = LocalDateTime.parse("04-08-2020 18:30:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(2, 1, 2, 3));
		NumericalDate actual = op.perform(inp).getNumericalDate();
		NumericalDate expected = new NumericalDate(6, 1, 10, 2023);
		assertTrue(actual.equals(expected));
	}

}
