import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTestReg {

    private Registration R1;
    private Registration R2;
    private Registration R3;
    
    private ArrayList<Registration> regList;
    
    @Before
    public void setUp() throws Exception {
        // prepare test data
        Events event1 = new Events("Event 1", "10:00 AM", "2023-08-20", "Venue 1", "Description 1");
        Events event2 = new Events("Event 2", "2:00 PM", "2023-08-21", "Venue 2", "Description 2");
        Events event3 = new Events("Event 3", "5:30 PM", "2023-08-22", "Venue 3", "Description 3");
        
        R1 = new Registration("John Doe", "john@example.com", event1);
        R2 = new Registration("Jane Smith", "jane@example.com", event2);
        R3 = new Registration("Alice Johnson", "alice@example.com", event3);
        
        regList = new ArrayList<>();
    }

    @Test
	public void testAddRegistration() {
		// Test that the list starts empty
		assertEquals("Test that the EventRegistration arraylist is empty.", 0, regList.size());
		
		// Add EventRegistrations to the list
		regList.add(R1);
		regList.add(R2);
		regList.add(R3);
		
		// Test the size after adding
		assertEquals("Test that the EventRegistration arraylist size is 3.", 3, regList.size());

		// Test that the added items are the same as the ones added
		assertSame("Test that EventRegistration is added to the list.", R1, regList.get(0));
		assertSame("Test that EventRegistration is added to the list.", R2, regList.get(1));
		assertSame("Test that EventRegistration is added to the list.", R3, regList.get(2));
	}
    
    @Test
    public void testDisplayRegistration() {
        // Test that the list starts empty
        assertEquals("Test that the EventRegistration arraylist is empty.", 0, regList.size());

        // Add EventRegistrations to the list
        regList.add(R1);
        regList.add(R2);
        regList.add(R3);

        // Call the method that returns the formatted registrations
        String actualOutput = C206_CaseStudyRegistration.displayRegistration(regList);

        // Expected output
        String expectedOutput = "Attendee Name: John Doe\nAttendee Email: john@example.com\nEvent Name: Event 1\nEvent Time: 10:00 AM\nEvent Date: 2023-08-20\nEvent Venue: Venue 1\nEvent Description: Description 1\n------------------------\n"
                + "Attendee Name: Jane Smith\nAttendee Email: jane@example.com\nEvent Name: Event 2\nEvent Time: 2:00 PM\nEvent Date: 2023-08-21\nEvent Venue: Venue 2\nEvent Description: Description 2\n------------------------\n"
                + "Attendee Name: Alice Johnson\nAttendee Email: alice@example.com\nEvent Name: Event 3\nEvent Time: 5:30 PM\nEvent Date: 2023-08-22\nEvent Venue: Venue 3\nEvent Description: Description 3\n------------------------\n";

        // Check that the actual output matches the expected output
        assertEquals("Test the display of registrations.", expectedOutput, actualOutput);
    }
    
    @Test
    public void testDeleteRegistration() {
        // Add and Test that the list contains 3 registrations
    	regList.add(R1);
        regList.add(R2);
        regList.add(R3);
        assertEquals("Test that the EventRegistration arraylist size is 3.", 3, regList.size());
        
        // Delete a registration (e.g., R2)
        C206_CaseStudyRegistration.deleteRegistration(regList);
        
        // Test that the list size has decreased after deletion
        assertEquals("Test that the EventRegistration arraylist size is 2 after deletion.", 2, regList.size());
        
        // Verify that the deleted registration (R2) is not in the list
        for (Registration reg : regList) {
            assertNotSame("Test that the deleted registration is not in the list.", R2, reg);
        }
        
        // Try deleting a registration that doesn't exist
        C206_CaseStudyRegistration.deleteRegistration(regList);
        
        // Test that the list size remains unchanged
        assertEquals("Test that the EventRegistration arraylist size is still 2 after attempting to delete a nonexistent registration.", 2, regList.size());
        
        // Try deleting a registration using event name
        C206_CaseStudyRegistration.deleteRegistration(regList);
        
        // Test that the list size has decreased after deletion
        assertEquals("Test that the EventRegistration arraylist size is 1 after deleting by event name.", 1, regList.size());
    }
    
    @After
    public void tearDown() throws Exception {
        // Clean up or reset anything if needed after each test
    }
}
