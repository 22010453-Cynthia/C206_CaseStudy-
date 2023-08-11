import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscussionTest {
	
	private Discussions d1;
	private Discussions d2;
	
    private ArrayList<Discussions> discussionList;
    
    public DiscussionTest() {
    	super();
    }

    @Before
    public void setUp() throws Exception{
    	//prepare test data
        d1 = new Discussions("Summer Adventure Ride", "Summer");
        d1 = new Discussions("Family Fun Bike Rally", "Family");
        
        discussionList = new ArrayList<Discussions>();
    }

    //ADD
    @Test
    public void testAddDiscussion() {
    	// Item list is not null, so that can add a new item - boundary
    	assertNotNull("Check if there is valid Discussion arraylist to add to", discussionList);
    	//Given an empty list, after adding 1 item, the size of the list is 1 - normal
    	//The item just added is as same as the first item of the list
        C206_CaseStudyDiscussions.addDiscussions(discussionList, d1);
        assertEquals("Check that Discussion arraylist size is 1", 1, discussionList.size());
        assertSame("Check that Discussion is added", d1, discussionList.get(0));
        
    }


    
    @Test
    public void testDeleteDiscussion() {
        discussionList.add(d1);
        discussionList.add(d2);

        // Test deleting an existing discussion
        C206_CaseStudyDiscussions.deleteDiscussion(discussionList, "Summer Adventure Ride");
        assertEquals("Check that Discussion arraylist size is 1 after deletion", 1, discussionList.size());
        assertNull("Check that deleted discussion is no longer in the list", ("Summer Adventure Ride"));

 
    }

    
    //VIEW
    @Test
    public void testViewAllDiscussions() {
    	//fail("Not yet implemented");
    	// Test if Item list is not null but empty - boundary
    	assertNotNull("Test if there is valid Discussion arraylist to retrieve item from", discussionList);
    			
    	//test if the list of discussions retrieved from the CaseStudy is empty - boundary
    	String allDiscussion= C206_CaseStudyDiscussions.retrieveAllDiscussions(discussionList);
    	String testOutput = "";
    	assertEquals("Check that ViewAllCamcorderlist", testOutput, allDiscussion);
    	
    	//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
    	C206_CaseStudyDiscussions.addDiscussions(discussionList, d1);
    	C206_CaseStudyDiscussions.addDiscussions(discussionList, d2);
    	assertEquals("Test that Discussion arraylist size is 2", 2, discussionList.size());
    	
    	//test if the expected output string same as the list of discussions retrieved from the SourceCentre	
    	allDiscussion= C206_CaseStudyDiscussions.retrieveAllDiscussions(discussionList);
    			testOutput = String.format("%-25s %-10s\n","Summer Adventure Ride", "Summer");
    			testOutput += String.format("%-25s %-10s\n","Family Fun Bike Rally", "Family" );
    		
    			assertEquals("Test that ViewAllCamcorderlist", testOutput, allDiscussion);
    }

    @After
    public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		discussionList = null;
    }

}
