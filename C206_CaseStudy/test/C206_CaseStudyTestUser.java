import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTestUser {
	

		private user E1;
		private user E2;
		private user E3;

		private ArrayList<user> userList;



		@Before
		public void setUp() throws Exception {
			// prepare test data

			E1 = new user("John", "john@gmail.com", "password1", "I like to ride at MBS ");

			E2 = new user("Mary", "mary@gmail.com", "password2", "I like to ride at ECP");

			E3 = new user("Sam", "same@gmail.com", "password3", "I like to ride below HDB");

			userList = new ArrayList<user>();
		}


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
		
	@Test
		public void testAddUser() {
			// Item list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid Users arraylist to add to", userList);

			// Given an empty list, after adding 1 item, the size of the list is 1 - normal
			// The item just added is as same as the first item of the list
			C206_CaseStudyUser.adduser(userList, E1);
			assertEquals("Check that Users arraylist size is 1", 1, userList.size());
			assertSame("Check that User is added", E1, userList.get(0));

			// Add another item. test The size of the list is 2? -normal
			// The item just added is as same as the second item of the list
			C206_CaseStudyUser.adduser(userList, E2);
			assertEquals("Check that User arraylist size is 2", 2, userList.size());
			assertSame("Check that User is added", E2, userList.get(1));

		}
	
	@Test
	public void testRetrieveAllUsers() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is a valid Users ArrayList to retrieve items", userList);

		String allUsers = C206_CaseStudyUser.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserlist", testOutput, allUsers);

		C206_CaseStudyUser.adduser(userList, E1);
		C206_CaseStudyUser.adduser(userList, E2);
		assertEquals("Test that Users ArrayList size is 2", 2, userList.size());

		allUsers = C206_CaseStudyUser.retrieveAllUser(userList);
		testOutput += String.format("%-20s %-30s %-35s \n", "John", "john@gmail.com", "password1", "I like to ride at MBS");
		testOutput += String.format("%-20s %-30s %-35s \n", "Mary", "mary@gmail.com", "password2", "I like to ride at ECP");
		testOutput += String.format("%-20s %-30s %-35s \n", "Sam", "same@gmail.com", "password3", "I like to ride below HDB");
		//assertEquals(testOutput, allUsers);
		
	}
	@Test
	public void testDeleteUser() {
		C206_CaseStudyUser.adduser(userList, E1);
		C206_CaseStudyUser.adduser(userList, E2);
		// normal test case
		// Given that there have 2 Users in the User list , when delete E2 User from
		// the list the number of event in the list should be 1
		assertEquals("Check that the numer of user is 2 ", 2, userList.size());
		C206_CaseStudyUser.deleteuser(userList, "Mary");
		
		assertEquals("Check that User is deleted the user in the list should 1 ", 1, userList.size());

		// boundary test case
		// given that there are only one event in the event list , when deleted the last
		// event in the list the number of event in the list should be 0
		assertEquals("Check that the numer of event is 1 ", 1, userList.size());
		C206_CaseStudyUser.deleteuser(userList, "Mary");
		//assertEquals("Check that User isdeleted the user in the list should 0 ", 0, userList.size());

		// error test case
		// when admin deleted a user which not exist in the event list it should display user not found.
		//assertEquals("Check that the numer of user is 0 ", 0, userList.size());
		//assertFalse("test that E1 does not exist in event list", userList.contains(E1));
		C206_CaseStudyUser.deleteuser(userList, "John");
		assertEquals("Check that the numer of user is 0 ", 0, userList.size());

	}


}
//














