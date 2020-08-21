package com.sapient.percapitaincomecalculator;

import java.util.ArrayList;


public class IncomeInformationDao {
	private ArrayList<String[]> data;

	public IncomeInformationDao() {
	}

	public IncomeInformationDao(ArrayList<String[]> data) {
		this.data = data;
	}

	public ArrayList<String[]> getData() {
		return data;
	}

	public void setData(ArrayList<String[]> data) {
		this.data = data;
	}

	public ArrayList<IncomeInformation> convert() {
		ArrayList<IncomeInformation> incomeData = new ArrayList<IncomeInformation>();
		for (String[] row : data) {
			IncomeInformation info = new IncomeInformation();
			info.setCity(row[0]);
			info.setCountry(row[1]);
			info.setGender(row[2]);
			info.setCurrency(row[3]);
			info.setAmount(Double.parseDouble(row[4]));
			incomeData.add(info);
		}
		return incomeData;
	}
}
