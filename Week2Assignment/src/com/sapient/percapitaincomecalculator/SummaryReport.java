package com.sapient.percapitaincomecalculator;

import java.util.ArrayList;
import java.util.Collections;

public class SummaryReport {
	private ArrayList<IncomeInformation> incomeData;

	public SummaryReport() {
	}

	public SummaryReport(ArrayList<IncomeInformation> incomeData) {
		this.incomeData = incomeData;
	}

	public ArrayList<IncomeInformation> getIncomeData() {
		return incomeData;
	}

	public void setIncomeData(ArrayList<IncomeInformation> incomeData) {
		this.incomeData = incomeData;
	}
	
	private void sortIncomeData() {
		Collections.sort(incomeData, new IncomeInformationComparator());
	}
	
	public void displayReport() {
		this.sortIncomeData();
		System.out.printf("%12s | %6s | %s\n", "Country/City", "Gender", "Amount (in USD)");
		for(IncomeInformation info: incomeData) {
			String countryCity = info.getCountry().isEmpty()? info.getCity(): info.getCountry();
			System.out.printf("%12s | %6s | %.2f\n", countryCity, info.getGender(), info.getAmountInUSD());
		}
	}
}
