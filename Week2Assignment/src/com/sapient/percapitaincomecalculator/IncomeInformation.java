package com.sapient.percapitaincomecalculator;

public class IncomeInformation {
	private String city;
	private String country;
	private String gender;
	private String currency;
	private double amount;
	private double amountInUSD;

	public IncomeInformation() {
		this.amountInUSD = 0;
	}

	public IncomeInformation(String city, String country, String gender, String currency, double amount) {
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.currency = currency;
		this.amount = amount;
		this.amountInUSD = 0;
	}

	public IncomeInformation(String city, String gender, String currency, double amount) {
		this.city = city;
		this.gender = gender;
		this.currency = currency;
		this.amount = amount;
		this.amountInUSD = 0;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmountInUSD() {
		return amountInUSD;
	}

	public void setAmountInUSD(double amountInUSD) {
		this.amountInUSD = amountInUSD;
	}

}
