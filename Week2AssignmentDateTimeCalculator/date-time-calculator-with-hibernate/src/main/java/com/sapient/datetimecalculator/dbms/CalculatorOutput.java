package com.sapient.datetimecalculator.dbms;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CalculatorOutput {

	@Id
	@GeneratedValue
	private int id;

	private LocalDateTime date;
	@OneToOne(cascade = CascadeType.ALL)
	private NumericalDate numericalDate;

	private String dayOfWeek;
	private Integer weekNumber;

	public CalculatorOutput() {
		date = null;
		numericalDate = null;
		dayOfWeek = "";
		weekNumber = 0;
	}

	public CalculatorOutput(LocalDateTime date, NumericalDate numericalDate, String dayOfWeek, Integer weekNumber) {
		this.date = date;
		this.numericalDate = numericalDate;
		this.dayOfWeek = dayOfWeek;
		this.weekNumber = weekNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public NumericalDate getNumericalDate() {
		return numericalDate;
	}

	public void setNumericalDate(NumericalDate numericalDate) {
		this.numericalDate = numericalDate;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	@Override
	public String toString() {
		return "CalculatorOutput [date=" + date + ", numericalDate=" + numericalDate + ", dayOfWeek=" + dayOfWeek
				+ ", weekNumber=" + weekNumber + "]";
	}

}
