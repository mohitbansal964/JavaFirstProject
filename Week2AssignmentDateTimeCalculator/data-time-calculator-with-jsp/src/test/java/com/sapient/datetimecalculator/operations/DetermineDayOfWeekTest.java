package com.sapient.datetimecalculator.operations;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.sapient.datetimecalculator.dbms.CalculatorInput;

public class DetermineDayOfWeekTest {
	private CalculatorOperation op;

	@Before
	public void setUp() throws Exception {
		op = new DetermineDayOfWeek();
	}

	@Test
	public void sundayTest() {
		LocalDateTime date1 = LocalDateTime.parse("23-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "SUNDAY";
		assertEquals(expected, actual);
	}

	@Test
	public void mondayTest() {
		LocalDateTime date1 = LocalDateTime.parse("24-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "MONDAY";
		assertEquals(expected, actual);
	}

	@Test
	public void tuesdayTest() {
		LocalDateTime date1 = LocalDateTime.parse("25-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "TUESDAY";
		assertEquals(expected, actual);
	}

	@Test
	public void wednesdayTest() {
		LocalDateTime date1 = LocalDateTime.parse("26-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "WEDNESDAY";
		assertEquals(expected, actual);
	}

	@Test
	public void thursdayTest() {
		LocalDateTime date1 = LocalDateTime.parse("27-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "THURSDAY";
		assertEquals(expected, actual);
	}

	@Test
	public void fridayTest() {
		LocalDateTime date1 = LocalDateTime.parse("28-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "FRIDAY";
		assertEquals(expected, actual);
	}

	@Test
	public void saturdayTest() {
		LocalDateTime date1 = LocalDateTime.parse("29-08-2020 18:15:15",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		CalculatorInput inp = new CalculatorInput(1, date1, null, null);
		String actual = op.perform(inp).getDayOfWeek();
		String expected = "SATURDAY";
		assertEquals(expected, actual);
	}

}
