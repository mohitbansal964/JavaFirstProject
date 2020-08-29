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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfDays;
		result = prime * result + numberOfMonths;
		result = prime * result + numberOfWeeks;
		result = prime * result + numberOfYears;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumericalDate other = (NumericalDate) obj;
		if (numberOfDays != other.numberOfDays)
			return false;
		if (numberOfMonths != other.numberOfMonths)
			return false;
		if (numberOfWeeks != other.numberOfWeeks)
			return false;
		if (numberOfYears != other.numberOfYears)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NumericalDate [numberOfDays=" + numberOfDays + ", numberOfWeeks=" + numberOfWeeks + ", numberOfMonths="
				+ numberOfMonths + ", numberOfYears=" + numberOfYears + "]";
	}

}
