import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTestEvents {

	private Events E1;
	private Events E2;
	private ArrayList<Events> eventsList;

	@Before
	public void setUp() throws Exception {
		// prepare test data

		E1 = new Events("Summer Adventure Ride", "9:00 AM ", "15 AUG 2023", "Forest Trails Park",
				"Join us for an exhilarating summer adventure ride .");

		E2 = new Events("Family Fun Bike Rally", "10:00AM", "5 SEP 2023", "City Park", "Calling all families! .");

		new Events("Night Glow Bike Parade", "7:00PM", "20 NOV 2023", "Downtown City Streets",
				"Embrace the magic of the night!");

		eventsList = new ArrayList<Events>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testAddEvent() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Events arraylist to add to", eventsList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudyEvents.addEvents(eventsList, E1);
		assertEquals("Check that Event arraylist size is 1", 1, eventsList.size());
		assertSame("Check that Event is added", E1, eventsList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudyEvents.addEvents(eventsList, E2);
		assertEquals("Check that Event arraylist size is 2", 2, eventsList.size());
		assertSame("Check that Event is added", E2, eventsList.get(1));

	}

	@Test
	public void testRetrieveAllEvent() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Event arraylist to retrieve item", eventsList);

		// test if the list of events retrieved from the SourceCentre is empty -
		// boundary
		String allEvents = C206_CaseStudyEvents.retrieveAllEvents(eventsList);
		String testOutput = "";
		assertEquals("Check that ViewAllEventlist", testOutput, allEvents);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudyEvents.addEvents(eventsList, E1);
		C206_CaseStudyEvents.addEvents(eventsList, E2);
		assertEquals("Test that event arraylist size is 2", 2, eventsList.size());

		// test if the expected output string same as the list of events retrieved from
		// the SourceCentre
		allEvents = C206_CaseStudyEvents.retrieveAllEvents(eventsList);
		testOutput = String.format("%-25s %-10s %-15s %-25s %-30s\n", "Summer Adventure Ride", "9:00 AM ",
				"15 AUG 2023", "Forest Trails Park", "Join us for an exhilarating summer adventure ride .");
		testOutput += String.format("%-25s %-10s %-15s %-25s %-30s\n", "Family Fun Bike Rally", "10:00AM", "5 SEP 2023",
				"City Park", "Calling all families! .");

		assertEquals("Test that ViewAllEventlist", testOutput, allEvents);

	}

	@Test
	public void testDeleteEvent() {
		C206_CaseStudyEvents.addEvents(eventsList, E1);
		C206_CaseStudyEvents.addEvents(eventsList, E2);
		// normal test case
		// Given that there have 2 event in the event list , when delete E2 event from
		// the list the number of event in the list should be 1
		assertEquals("Check that the numer of event is 2 ", 2, eventsList.size());
		C206_CaseStudyEvents.deleteEvent(eventsList, "Family Fun Bike Rally");
		assertEquals("Check that Event isdeleted the event in the list should 1 ", 1, eventsList.size());

		// boundary test case
		// given that there are only one event in the event list , when deleted the last
		// event in the list the number of event in the list should be 0
		assertEquals("Check that the numer of event is 1 ", 1, eventsList.size());
		C206_CaseStudyEvents.deleteEvent(eventsList, "Summer Adventure Ride");
		assertEquals("Check that Event isdeleted the event in the list should 0 ", 0, eventsList.size());

		// error test case
		// when user deleted a event which not exist in the event list it should display event + event name + not found.
		assertEquals("Check that the numer of event is 0 ", 0, eventsList.size());
		assertFalse("test that E1 does not exist in event list", eventsList.contains(E1));
		C206_CaseStudyEvents.deleteEvent(eventsList, "Summer Adventure Ride");
		assertEquals("Check that the numer of event is 0 ", 0, eventsList.size());

	}
	@Test
	public void testUpdateEvent() {
		// normal test case
		//given a correct event name to update the event information it should display event + event name + has been updated.
		C206_CaseStudyEvents.addEvents(eventsList, E1);
		C206_CaseStudyEvents.updateEvent(eventsList, "Summer Adventure Ride");
		
		//error test case
		//given a wrong event name to update the event information it should display event + event name + not found.
		C206_CaseStudyEvents.updateEvent(eventsList, "Night Glow Bike Parade");

	}
	
	 @After
	 public void tearDown() throws Exception {
	 // Clean up or reset anything if needed after each test
	 }
	

}
