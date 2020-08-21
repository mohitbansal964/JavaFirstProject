package com.sapient.processingfeecalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransactionDao {
	
	private ArrayList<String[]> data;
	
	
	public TransactionDao() {
	}

	public TransactionDao(ArrayList<String[]> data) {
		this.data = data;
	}

	public ArrayList<String[]> getData() {
		return data;
	}

	public void setData(ArrayList<String[]> data) {
		this.data = data;
	}
	
	public ArrayList<Transaction> convert(){
		ArrayList<Transaction> transactionData = new ArrayList<Transaction>();
		for(String[] row : data) {
			Transaction t = new Transaction();
			t.setId(Integer.parseInt(row[0]));
			t.setClientId(Integer.parseInt(row[1]));
			t.setSecurityId(row[2]);
			t.setType(row[3]);
			t.setDate(LocalDate.parse(row[4], DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			t.setMarketValue(Integer.parseInt(row[5]));
			t.setPriorityFlag(row[6]);
			transactionData.add(t);
		}
		return transactionData;
	}
}