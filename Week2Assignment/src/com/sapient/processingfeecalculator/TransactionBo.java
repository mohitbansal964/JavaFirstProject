package com.sapient.processingfeecalculator;

import java.util.ArrayList;

public class TransactionBo {

	ArrayList<Transaction> transactionData;

	public TransactionBo(ArrayList<Transaction> transactionData) {
		this.transactionData = transactionData;
	}

	public void calculateProcessingFees() {
		for (Transaction t : transactionData) {
			if (t.getPriorityFlag().equalsIgnoreCase("y")) {
				t.setProcessingFee(500);
			} else if (t.getPriorityFlag().equalsIgnoreCase("n")
					&& (t.getType().equalsIgnoreCase("sell") || t.getType().equalsIgnoreCase("withdraw"))) {
				t.setProcessingFee(100);
			} else if (t.getPriorityFlag().equalsIgnoreCase("n")
					&& (t.getType().equalsIgnoreCase("buy") || t.getType().equalsIgnoreCase("deposit"))) {
				t.setProcessingFee(50);
			}
		}

		for (int i = 0; i < transactionData.size(); i++) {
			Transaction t1 = transactionData.get(i);
			if (t1.getType().equalsIgnoreCase("buy")) {
				for (int j = i + 1; j < transactionData.size(); j++) {
					Transaction t2 = transactionData.get(j);
					if (t2.getType().equalsIgnoreCase("sell") && t1.getClientId() == t2.getClientId()
							&& t1.getSecurityId().equals(t2.getSecurityId()) && t1.getDate().equals(t2.getDate())) {
						t1.setProcessingFee(t1.getProcessingFee() + 10);
						t2.setProcessingFee(t2.getProcessingFee() + 10);
						break;
					}
				}
			}
		}
	}

	public ArrayList<Transaction> getTransactionData() {
		return transactionData;
	}

	public void setTransactionData(ArrayList<Transaction> transactionData) {
		this.transactionData = transactionData;
	}

}
