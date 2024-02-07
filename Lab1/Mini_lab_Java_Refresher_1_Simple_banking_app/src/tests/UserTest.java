package tests;

import model.User;

import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testUserConstructor();
	}
	
	public static void testUserConstructor() {
		// move all the test code of the User Constructor from the main() to this method
		/* OLD: manual testing
		 * User testUser = new User("mike", "my_password", "Mike", "Smith", "07771234567");
		 * System.out.println(testUser.toString());
		 */
		// automated testing
		// 1-Setup
		String testUsername = "mike";
		String testPassword = "my_password";
		String testFirstName = "Mike";
		String testLastName = "Smith";
		String testMobileNumber = "07771234567";
		
		// 2-Exercise, run the object under test (constructor)
		User testUser = new User(testUsername, testPassword, testFirstName, testLastName, testMobileNumber);
		
		// 3-Verify (Assert)
		System.out.println("Starting the assertions of the test method: testUserConstructor");

		assert (testUser.getUsername() == testUsername)
		
		assert (testUser.getPassword() == testPassword)
		
		assert (testUser.getFirstName() == testFirstName)

		assert (testUser.getLastName() == testLastName)

		assert (testUser.getMobileNumber() == testMobileNumber)
		
		if(testUser.getUsername() == testUsername) { // injected defect: "==" was intentionally changed to "!="
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-Failed" + TestUtils.TEXT_COLOR_RESET);
		}
		
		if(testUser.getPassword() == testPassword) {	
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-Failed" + TestUtils.TEXT_COLOR_RESET);
		}
		
		if(testUser.getFirstName() == testFirstName) {	
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirstName-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirstName-Failed" + TestUtils.TEXT_COLOR_RESET);
		}
		
		if(testUser.getLastName() == testLastName) {	
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLastName-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLastName-Failed" + TestUtils.TEXT_COLOR_RESET);
		}
		
		if(testUser.getMobileNumber() == testMobileNumber) {	
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobileNumber-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobileNumber-Failed" + TestUtils.TEXT_COLOR_RESET);
		}
	}
}
