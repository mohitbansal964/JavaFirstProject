package com.sapient.processingfeecalculator;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class SummaryReport {
	private ArrayList<Transaction> transactionData;

	public SummaryReport(ArrayList<Transaction> transactionData) {
		this.transactionData = transactionData;
	}

	public ArrayList<Transaction> getTransactionData() {
		return transactionData;
	}

	public void setTransactionData(ArrayList<Transaction> transactionData) {
		this.transactionData = transactionData;
	}

	private void sortTransactionData() {
		Collections.sort(transactionData, new TransactionComparator());
	}

	public void displayReport() {
		this.sortTransactionData();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.printf("%9s | %16s | %16s | %8s | %14s\n", "Client ID", "Transaction Type", "Transaction Date",
				"Priority", "Processing Fee");
		for (Transaction t : transactionData) {
			System.out.printf("%9s | %16s | %16s | %8s | %14s\n", t.getClientId(), t.getType(),
					t.getDate().format(format), t.getPriorityFlag(), t.getProcessingFee());
		}

	}

}
