package com.sapient.processingfeecalculator;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction t1, Transaction t2) {
		if(t1.getClientId() == t2.getClientId()) {
			if(t1.getType().equals(t2.getType())) {
				if(t1.getDate().equals(t2.getDate())) {
					return t1.getPriorityFlag().compareTo(t2.getPriorityFlag());
				}
				return t1.getDate().compareTo(t2.getDate());
			}
			return t1.getType().compareTo(t2.getType());
		}
		return Integer.compare(t1.getClientId(), t2.getClientId());
	}

}
