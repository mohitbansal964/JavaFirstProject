package com.sapient.datetimecalculator;

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

	public void displayMenu() {
		System.out.println(" ".repeat(17) + "Date-Time Calculator Menu (Enter -1 for exit)");
		System.out.println("-".repeat(65));
		for (int i = 1; i <= choices.size(); i++) {
			System.out.println(i + ". " + choices.get(i - 1));
		}
		System.out.println("-".repeat(65));
	}
}
