package tests;

import java.text.SimpleDateFormat;

import java.util.Date;

import model.Account;

import utils.TestUtils;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAccountConstructor();
		testAccountSetters();
	}
	
	/*
	 * Similar to testUserConstructor() of UserTest, this test method will test the constructor of
	 * Account, using all its getter methods
	 */
	public static void testAccountConstructor() {
		// automated testing
		// 1-Setup
		String testAccountNumber = "01234456789";
		String testUsernameOfAccountHolder = "mike";
		String testAccountType = "Standard";
		Date testAccountOpeningDate = new Date();
		
		// 2-Exercise, run the object under test (constructor)
		Account testAccount = new Account(testAccountNumber, testUsernameOfAccountHolder, testAccountType, testAccountOpeningDate);
		
		// 3-Verify (Assert)
		System.out.println("Starting the assertions of the test method: testAccountConstructor");
		
		// testAccountNumber = "0123";
		// testUsernameOfAccountHolder = "Mike";
		// testAccountType = "Savings";
		
		assert (testAccount.getAccountNumber() == testAccountNumber) : "Account Number: " + testAccount.getAccountNumber() + " does not match Test Account Number: " 
																		+ testAccountNumber;
		assert (testAccount.getUsernameOfAccountHolder() == testUsernameOfAccountHolder) : "Username of Account Holder: " + testAccount.getUsernameOfAccountHolder() 
																							+ " does not match Test Username of Account Holder: " + testUsernameOfAccountHolder;
		assert (testAccount.getAccountType() == testAccountType) : "Account Type: " + testAccount.getAccountType() + " does not match Test Account Type: " + testAccountType;
		assert (testAccount.getAccountOpeningDate() == testAccountOpeningDate) : "Account Opening Date: " + testAccount.getAccountOpeningDate() 
																				+ " does not match Test Account Opening Date: " + testAccountOpeningDate;
		
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "All Java Assertions in the 'testAccountConstructor' test suite passed (ie. none failed)" + TestUtils.TEXT_COLOR_RESET);
	}
	
	/*
	 * This test method will test all the setter methods of Account
	 */
	public static void testAccountSetters() {
		// automated testing
		// 1-Setup
		Date date = new Date();
		
		String testAccountNumber = "01234456789";
		String testUsernameOfAccountHolder = "mike";
		String testAccountType = "Standard";
		Date testAccountOpeningDate = new Date();
		
		// 2-Exercise, run the object under test (setters)
		Account testAccount = new Account("", "", "", date);
		
		testAccount.setAccountNumber(testAccountNumber);
		testAccount.setUsernameOfAccountHolder(testUsernameOfAccountHolder);
		testAccount.setAccountType(testAccountType);
		testAccount.setAccountOpeningDate(testAccountOpeningDate);
		
		// 3-Verify (Assert)
		System.out.println("Starting the assertions of the test method: testAccountSetters");
		
		// testAccountNumber = "0123";
		// testUsernameOfAccountHolder = "Mike";
		// testAccountType = "Savings";
		
		assert (testAccount.getAccountNumber() == testAccountNumber) : "Account Number: " + testAccount.getAccountNumber() + " does not match Test Account Number: " 
																		+ testAccountNumber;
		assert (testAccount.getUsernameOfAccountHolder() == testUsernameOfAccountHolder) : "Username of Account Holder: " + testAccount.getUsernameOfAccountHolder() 
																							+ " does not match Test Username of Account Holder: " + testUsernameOfAccountHolder;
		assert (testAccount.getAccountType() == testAccountType) : "Account Type: " + testAccount.getAccountType() + " does not match Test Account Type: " + testAccountType;
		assert (testAccount.getAccountOpeningDate() == testAccountOpeningDate) : "Account Opening Date: " + testAccount.getAccountOpeningDate() 
																				+ " does not match Test Account Opening Date: " + testAccountOpeningDate;
		
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "All Java Assertions in the 'testAccountSetters' test suite passed (ie. none failed)" + TestUtils.TEXT_COLOR_RESET);
	}
}
