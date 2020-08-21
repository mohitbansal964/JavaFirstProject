package com.sapient.processingfeecalculator;

import java.time.LocalDate;

public class Transaction {
	private int id;
	private int clientId;
	private String securityId;
	private String type;
	private LocalDate date;
	private int marketValue;
	private String priorityFlag;
	private int processingFee;

	public Transaction() {
		this.processingFee = 0;
	}

	public Transaction(int id, int clientId, String securityId, String type, LocalDate date, int marketValue,
			String priorityFlag) {
		this.id = id;
		this.clientId = clientId;
		this.securityId = securityId;
		this.type = type;
		this.date = date;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
		this.processingFee = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public int getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}
}
