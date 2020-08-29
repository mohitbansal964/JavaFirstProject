package com.sapient.datetimecalculator.bo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<String> choices;

	public Menu() {
		this.choices = new ArrayList<String>();
		choices.add("Add two Dates");
		choices.add("Subtract Two Dates");
		choices.add("Add N Days, Months, Weeks and Years to given Date");
		choices.add("Subtract N  Days, Months, Weeks, Years from given Date");
		choices.add("Determine the day of the week");
		choices.add("Determine the week number for a given date");
	}

	public void addChoice(String choice) {
		choices.add(choice);
	}

	public List<String> getChoices() {
		return choices;
	}

}
