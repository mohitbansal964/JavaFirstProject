package com.sapient.datetimecalculator.dbms;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class History {

	@Id
	@GeneratedValue
	private int id;

	private LocalDateTime date;
	@OneToOne(cascade = CascadeType.ALL)
	private CalculatorInput input;
	@OneToOne(cascade = CascadeType.ALL)
	private CalculatorOutput output;

	public History() {

	}

	public History(LocalDateTime date, CalculatorInput input, CalculatorOutput output) {
		this.date = date;
		this.input = input;
		this.output = output;
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

	public CalculatorInput getInput() {
		return input;
	}

	public void setInput(CalculatorInput input) {
		this.input = input;
	}

	public CalculatorOutput getOutput() {
		return output;
	}

	public void setOutput(CalculatorOutput output) {
		this.output = output;
	}

}
