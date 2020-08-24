package com.sapient.datetimecalculator;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class Calculator {

	private Scanner scan;
	
	public Calculator() {
		scan = new Scanner(System.in);
	}

	public void displayMenu() {

		System.out.println(" ".repeat(17) + "Date-Time Calculator Menu (Enter -1 for exit)");
		System.out.println("-".repeat(65));
		System.out.println("1. Add two Dates");
		System.out.println("2. Subtract Two Dates");
		System.out.println("3. Add N Days, Months, Weeks and Years to given Date");
		System.out.println("4. Subtract N  Days, Months, Weeks, Years from given Date");
		System.out.println("5. Determine the day of the week");
		System.out.println("6. Determine the week number for a given date");
		System.out.println("7. Display history of session");
		System.out.println("8. Display history of all the sessions");
//		System.out.println("7. Translate natural language phrases");
		System.out.println("-".repeat(65));
	}

	public int enterChoice() {
		System.out.print("\nEnter choice from menu: ");
		int choice = -1;
		choice = scan.nextInt();
		scan.nextLine();
		return choice;
	}

	public LocalDateTime enterDate() {
		System.out.print("Enter Date and Time in (dd-mm-yyyy hh:mm:ss) format: ");
		String date = scan.nextLine();
		LocalDateTime enteredDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

		return enteredDate;
	}

	public DateTime enterN() {
		int numberOfDays = 0;
		int numberOfWeeks = 0;
		int numberOfMonths = 0;
		int numberOfYears = 0;

		System.out.print("Enter number of days: ");
		numberOfDays = scan.nextInt();
		System.out.print("Enter number of weeks: ");
		numberOfWeeks = scan.nextInt();
		System.out.print("Enter number of months: ");
		numberOfMonths = scan.nextInt();
		System.out.print("Enter number of years: ");
		numberOfYears = scan.nextInt();

		DateTime n = new DateTime(numberOfDays, numberOfWeeks, numberOfMonths, numberOfYears);
		return n;
	}

	public DateTime addTwoDates(LocalDateTime d1, DateTime n) {
		LocalDateTime dateAfterNDays = d1.plusDays(n.getNumberOfDays());
		LocalDateTime dateAfterNWeeks = dateAfterNDays.plusWeeks(n.getNumberOfWeeks());
		LocalDateTime dateAfterNMonths = dateAfterNWeeks.plusMonths(n.getNumberOfMonths());
		LocalDateTime finalDate = dateAfterNMonths.plusYears(n.getNumberOfYears());

		int day = finalDate.getDayOfMonth() % 7;
		int week = finalDate.getDayOfMonth() / 7;
		int month = finalDate.getMonthValue();
		int year = finalDate.getYear();

		DateTime result = new DateTime(day, week, month, year);
		return result;
	}

	public DateTime subtractTwoDates(LocalDateTime d1, LocalDateTime d2) {
		DateTime result;
		Period period = Period.between(d1.toLocalDate(), d2.toLocalDate());
		int numberOfDays = Math.abs(period.getDays())%7;
		int numberOfWeeks = Math.abs(period.getDays())/7;
		int numberOfMonths = Math.abs(period.getMonths());
		int numberOfYears = Math.abs(period.getYears());
		
		result = new DateTime(numberOfDays, numberOfWeeks, numberOfMonths, numberOfYears);
		return result;
	}

	public LocalDateTime addNToGivenDate(LocalDateTime d1, DateTime n) {
		LocalDateTime dateAfterNDays = d1.plusDays(n.getNumberOfDays());
		LocalDateTime dateAfterNWeeks = dateAfterNDays.plusWeeks(n.getNumberOfWeeks());
		LocalDateTime dateAfterNMonths = dateAfterNWeeks.plusMonths(n.getNumberOfMonths());
		LocalDateTime finalDate = dateAfterNMonths.plusYears(n.getNumberOfYears());

		return finalDate;

	}

	public LocalDateTime subtractNToGivenDate(LocalDateTime d1, DateTime n) {
		LocalDateTime dateBeforNYears = d1.minusYears(n.getNumberOfYears());
		LocalDateTime dateBeforeNMonths = dateBeforNYears.minusMonths(n.getNumberOfMonths());
		LocalDateTime dateBeforeNWeeks = dateBeforeNMonths.minusWeeks(n.getNumberOfWeeks());
		LocalDateTime finalDate = dateBeforeNWeeks.minusDays(n.getNumberOfDays());

		return finalDate;
	}

	public String dayOfWeek(LocalDateTime d1) {
		return d1.getDayOfWeek().toString();
	}

	public int weekNumber(LocalDateTime d1) {
		return d1.get(ChronoField.ALIGNED_WEEK_OF_YEAR);

	}

	public LocalDateTime translateNaturalLanguagePhrases(String phrase) {
		return null;

	}

	public void displayDate(LocalDateTime d1) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = d1.format(format);
        System.out.println("Result: " + formatDateTime);
	}
	
	public void displayResult(DateTime n) {
		System.out.println("Result:");
		System.out.println("Number of days: " + n.getNumberOfDays());
		System.out.println("Number of weeks: " + n.getNumberOfWeeks());
		System.out.println("Number of months: " + n.getNumberOfMonths());
		System.out.println("Number of years: " + n.getNumberOfYears());
	}

	public void finalize() {
		scan.close();
	}

}
