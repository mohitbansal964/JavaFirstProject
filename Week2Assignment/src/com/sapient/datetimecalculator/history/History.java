package com.sapient.datetimecalculator.history;

import java.time.LocalDateTime;

import com.sapient.datetimecalculator.DateTime;

public class History {
	private int choice;
	private LocalDateTime d1;
	private LocalDateTime d2;
	private DateTime n;
	private LocalDateTime result;
	private DateTime resultN;
	private String resultDayOfWeek;
	private int resultWeekNumber;

	public History() {
		this.choice = -1;
		this.d1 = null;
		this.d2 = null;
		this.n = null;
		this.result = null;
		this.resultN = null;
		this.resultDayOfWeek = "";
		this.resultWeekNumber = 0;
	}

	public String getResultDayOfWeek() {
		return resultDayOfWeek;
	}

	public void setResultDayOfWeek(String resultDayOfWeek) {
		this.resultDayOfWeek = resultDayOfWeek;
	}

	public int getResultWeekNumber() {
		return resultWeekNumber;
	}

	public void setResultWeekNumber(int resultWeekNumber) {
		this.resultWeekNumber = resultWeekNumber;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public LocalDateTime getD1() {
		return d1;
	}

	public void setD1(LocalDateTime d1) {
		this.d1 = d1;
	}

	public LocalDateTime getD2() {
		return d2;
	}

	public void setD2(LocalDateTime d2) {
		this.d2 = d2;
	}

	public DateTime getN() {
		return n;
	}

	public void setN(DateTime n) {
		this.n = n;
	}

	public LocalDateTime getResult() {
		return result;
	}

	public void setResult(LocalDateTime result) {
		this.result = result;
	}

	public DateTime getResultN() {
		return resultN;
	}

	public void setResultN(DateTime resultN) {
		this.resultN = resultN;
	}

	@Override
	public String toString() {
		return "History [choice=" + choice + ", d1=" + d1 + ", d2=" + d2 + ", n=" + n + ", result=" + result
				+ ", resultN=" + resultN + ", resultDayOfWeek=" + resultDayOfWeek + ", resultWeekNumber="
				+ resultWeekNumber + "]\n";
	}

}
