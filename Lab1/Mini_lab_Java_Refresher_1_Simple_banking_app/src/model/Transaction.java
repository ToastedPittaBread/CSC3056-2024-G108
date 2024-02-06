package model;

import java.text.SimpleDateFormat;

import java.util.Date;

public class Transaction {
	private String accountNumber;
	private double transactionAmount;
	private Date transactionDate;
	
	public Transaction(String accountNumber, double transactionAmount, Date transactionDate) {
		super();
		this.accountNumber = accountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String toString() {
		// return accountNumber + ", " + transactionAmount + ", " + transactionDate;
		return String.format("%-15s | %-15s | %-15s", 
				accountNumber, transactionAmount, transactionDate);
	}
}
