package com.sapient.datetimecalculator;

public class DateTime {
	private int numberOfDays;
	private int numberOfWeeks;
	private int numberOfMonths;
	private int numberOfYears;

	public DateTime(int numberOfDays, int numberOfWeeks, int numberOfMonths, int numberOfYears) {
		this.numberOfDays = numberOfDays;
		this.numberOfWeeks = numberOfWeeks;
		this.numberOfMonths = numberOfMonths;
		this.numberOfYears = numberOfYears;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public int getNumberOfWeeks() {
		return numberOfWeeks;
	}

	public void setNumberOfWeeks(int numberOfWeeks) {
		this.numberOfWeeks = numberOfWeeks;
	}

	public int getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	@Override
	public String toString() {
		return "DateTime [numberOfDays=" + numberOfDays + ", numberOfWeeks=" + numberOfWeeks + ", numberOfMonths="
				+ numberOfMonths + ", numberOfYears=" + numberOfYears + "]";
	}

}
