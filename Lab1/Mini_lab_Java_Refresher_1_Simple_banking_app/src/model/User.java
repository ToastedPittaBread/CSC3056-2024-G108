package model;

public class User {
	private String username; // email address
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	public User(String username, String password, String firstName, String lastName, 
			String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String toString() {
		return username + ", " + password + ", " + firstName + ", " + lastName + ", " + mobileNumber;
	}
}
