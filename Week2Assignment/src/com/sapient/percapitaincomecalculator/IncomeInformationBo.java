package com.sapient.percapitaincomecalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IncomeInformationBo {
	ArrayList<IncomeInformation> incomeData;

	public IncomeInformationBo() {
	}

	public IncomeInformationBo(ArrayList<IncomeInformation> incomeData) {
		this.incomeData = incomeData;
	}

	public ArrayList<IncomeInformation> getIncomeData() {
		return incomeData;
	}

	public void setIncomeData(ArrayList<IncomeInformation> incomeData) {
		this.incomeData = incomeData;
	}

	public void perCapitaIncomeInUSD() {
		CurrencyConversion inr = (double amount) -> amount / 66;
		CurrencyConversion gbp = (double amount) -> amount / 0.67;
		CurrencyConversion sgd = (double amount) -> amount / 1.5;
		CurrencyConversion hkd = (double amount) -> amount / 8;

		Map<String, CurrencyConversion> currencies = new HashMap<String, CurrencyConversion>();
		currencies.put("INR", inr);
		currencies.put("GBP", gbp);
		currencies.put("SGD", sgd);
		currencies.put("HKD", hkd);

		for (IncomeInformation info : incomeData) {
			double amount = info.getAmount();
			info.setAmountInUSD(currencies.get(info.getCurrency()).convert(info.getAmount()));
		}
	}

}
