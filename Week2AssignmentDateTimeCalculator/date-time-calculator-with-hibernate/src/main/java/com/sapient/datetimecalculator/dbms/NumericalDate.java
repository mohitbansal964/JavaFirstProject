package com.sapient.datetimecalculator.dbms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NumericalDate {

	@Id
	@GeneratedValue
	private int id;

	private int numberOfDays;
	private int numberOfWeeks;
	private int numberOfMonths;
	private int numberOfYears;

	public NumericalDate() {

	}

	public NumericalDate(int numberOfDays, int numberOfWeeks, int numberOfMonths, int numberOfYears) {
		this.numberOfDays = numberOfDays;
		this.numberOfWeeks = numberOfWeeks;
		this.numberOfMonths = numberOfMonths;
		this.numberOfYears = numberOfYears;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
