package com.sapient.percapitaincomecalculator;

import java.util.ArrayList;

import com.sapient.processingfeecalculator.CSVFileReader;
import com.sapient.processingfeecalculator.FileReader;

public class IncomeCalculatorRunner {

	public static void main(String[] args) {
		String filename = "C:\\Users\\Archana Gupta\\Desktop\\sample_data1.csv";
		FileReader reader = new CSVFileReader();
		ArrayList<String[]> data = reader.read(filename);
		IncomeInformationDao incomeDao = new IncomeInformationDao(data);
		ArrayList<IncomeInformation> incomeData = incomeDao.convert();
		IncomeInformationBo incomeBo = new IncomeInformationBo(incomeData);
		incomeBo.perCapitaIncomeInUSD();
		incomeData = incomeBo.getIncomeData();
		SummaryReport report = new SummaryReport(incomeData);
		report.displayReport();

	}

}