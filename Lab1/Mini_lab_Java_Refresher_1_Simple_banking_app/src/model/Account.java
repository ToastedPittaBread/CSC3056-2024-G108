package model;

import java.util.Date;

import java.text.SimpleDateFormat;

public class Account {
	private String accountNumber;
	private String usernameOfAccountHolder;
	private String accountType; // "Standard" or "Savings"
	private Date accountOpeningDate;
	
	public Account(String accountNumber, String usernameOfAccountHolder, String accountType, 
			Date accountOpeningDate) {
		super();
		this.accountNumber = accountNumber;
		this.usernameOfAccountHolder = usernameOfAccountHolder;
		this.accountType = accountType;
		this.accountOpeningDate = accountOpeningDate;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getUsernameOfAccountHolder() {
		return usernameOfAccountHolder;
	}
	public String getAccountType() {
		return accountType;
	}
	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setUsernameOfAccountHolder(String usernameOfAccountHolder) {
		this.usernameOfAccountHolder = usernameOfAccountHolder;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	
	public String toString() {
		return accountNumber + ", " + usernameOfAccountHolder + ", " + accountType + ", " + accountOpeningDate;
	}
}
