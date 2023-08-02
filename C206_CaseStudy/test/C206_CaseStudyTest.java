import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	

		private Events E1;
		private Events E2;
		private Events E3;

		private ArrayList<Events> eventsList;



		@Before
		public void setUp() throws Exception {
			// prepare test data

			E1 = new Events("Summer Adventure Ride", "9:00 AM ", "15 AUG 2023", "Forest Trails Park",
					"Join us for an exhilarating summer adventure ride .");

			E2 = new Events("Family Fun Bike Rally", "10:00AM", "5 SEP 2023", "City Park", "Calling all families! .");

			E3 = new Events("Night Glow Bike Parade", "7:00PM", "20 NOV 2023", "Downtown City Streets",
					"Embrace the magic of the night!");

			eventsList = new ArrayList<Events>();
		}


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
		
	@Test
		public void testAddEvent() {
			// Item list is not null, so that can add a new item - boundary
			assertNotNull("Check if there is valid Events arraylist to add to", eventsList);

			// Given an empty list, after adding 1 item, the size of the list is 1 - normal
			// The item just added is as same as the first item of the list
			C206_CaseStudy.addEvents(eventsList, E1);
			assertEquals("Check that Event arraylist size is 1", 1, eventsList.size());
			assertSame("Check that Event is added", E1, eventsList.get(0));

			// Add another item. test The size of the list is 2? -normal
			// The item just added is as same as the second item of the list
			C206_CaseStudy.addEvents(eventsList, E2);
			assertEquals("Check that Event arraylist size is 2", 2, eventsList.size());
			assertSame("Check that Event is added", E2, eventsList.get(1));

		}
	
	@Test
	public void testRetrieveAllEvent() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Event arraylist to retrieve item", eventsList);
		
		//test if the list of events retrieved from the SourceCentre is empty - boundary
		String allEvents= C206_CaseStudy.retrieveAllEvents(eventsList);
		String testOutput = "";
		assertEquals("Check that ViewAllEventlist", testOutput, allEvents);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addEvents(eventsList, E1);
		C206_CaseStudy.addEvents(eventsList, E2);
		assertEquals("Test that event arraylist size is 2", 2, eventsList.size());
		
		//test if the expected output string same as the list of events retrieved from the SourceCentre	
		allEvents= C206_CaseStudy.retrieveAllEvents(eventsList);
		testOutput = String.format("%-25s %-10s %-15s %-25s %-30s\n","Summer Adventure Ride", "9:00 AM ", "15 AUG 2023", "Forest Trails Park",
				"Join us for an exhilarating summer adventure ride .");
		testOutput += String.format("%-25s %-10s %-15s %-25s %-30s\n","Family Fun Bike Rally", "10:00AM", "5 SEP 2023", "City Park", "Calling all families! ." );
	
		assertEquals("Test that ViewAllEventlist", testOutput, allEvents);
		
	}

}
