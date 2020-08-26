package com.sapient.datetimecalculator.dbms;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CalculatorInput {

	@Id
	@GeneratedValue
	private int id;

	private int choice;
	private LocalDateTime date1;
	private LocalDateTime date2;
	@OneToOne(cascade = CascadeType.ALL)
	private NumericalDate date3;

	public CalculatorInput() {
	}

	public CalculatorInput(int choice, LocalDateTime date1, LocalDateTime date2, NumericalDate date3) {
		this.choice = choice;
		this.date1 = date1;
		this.date2 = date2;
		this.date3 = date3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public LocalDateTime getDate1() {
		return date1;
	}

	public void setDate1(LocalDateTime date1) {
		this.date1 = date1;
	}

	public LocalDateTime getDate2() {
		return date2;
	}

	public void setDate2(LocalDateTime date2) {
		this.date2 = date2;
	}

	public NumericalDate getDate3() {
		return date3;
	}

	public void setDate3(NumericalDate date3) {
		this.date3 = date3;
	}

	@Override
	public String toString() {
		return "CalculatorInput [choice=" + choice + ", date1=" + date1 + ", date2=" + date2 + ", date3=" + date3 + "]";
	}

}
