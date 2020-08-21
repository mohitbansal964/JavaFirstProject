package com.sapient.percapitaincomecalculator;

import java.util.Comparator;

public class IncomeInformationComparator implements Comparator<IncomeInformation> {

	@Override
	public int compare(IncomeInformation info1, IncomeInformation info2) {
		String countryCity1 = info1.getCountry().isEmpty()? info1.getCity(): info1.getCountry();
		String countryCity2 = info2.getCountry().isEmpty()? info2.getCity(): info2.getCountry();
		
		if (countryCity1.equalsIgnoreCase(countryCity2)) {
			if(info1.getGender().equalsIgnoreCase(info2.getGender())) {
				return Double.compare(info1.getAmountInUSD(), info2.getAmountInUSD());
			}
			return info1.getGender().compareToIgnoreCase(info2.getGender());
		}
		return countryCity1.compareToIgnoreCase(countryCity2);
	}

}
