package com.sapient.processingfeecalculator;

import java.util.ArrayList;

public class FeeCalculatorRunner {

	public static void main(String[] args) {
		FileReader reader = new CSVFileReader();
		ArrayList<String[]> data = reader.read("C:\\Users\\Archana Gupta\\Desktop\\sample_data.csv");
		TransactionDao tDao = new TransactionDao(data);
		ArrayList<Transaction> transactionData = tDao.convert();
		TransactionBo tBo = new TransactionBo(transactionData);
		tBo.calculateProcessingFees();
		transactionData = tBo.getTransactionData();
		SummaryReport report = new SummaryReport(transactionData);
		report.displayReport();

	}

}
