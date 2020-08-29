package com.sapient.datetimecalculator.operations;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.NumericalDate;

public class AddNToGivenDateTest {
	private CalculatorOperation op;

	@Before
	public void setUp() throws Exception {
		op = new AddNToGivenDate();
	}

	@Test
	public void add5DaysTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(5, 0, 0, 0));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("30-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void add5WeeksTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(0, 5, 0, 0));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("29-09-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void add5MonthsTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(0, 0, 5, 0));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("25-01-2021 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void add5YearsTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(0, 0, 0, 5));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("25-08-2025 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}

	@Test
	public void add5AllTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, new NumericalDate(5, 5, 5, 5));
		LocalDateTime actual = op.perform(inp).getDate();
		LocalDateTime expected = LocalDateTime.parse("04-03-2026 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		assertTrue(actual.equals(expected));
	}
}
