import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTestGroups {

    private group G1;
    private group G2;

    private ArrayList<group> groupList;

    @Before
    public void setUp() throws Exception {
        // prepare test data
        G1 = new group("Summer Adventure Ride", "9:00 AM ");
        G2 = new group("Family Fun Bike Rally", "10:00AM");

        groupList = new ArrayList<group>();
    }

    @Test
    public void c206_test() {
        assertTrue("C206_CaseStudy_SampleTest", true);
    }

    @Test
    public void testAddgroup() {
        assertNotNull("Check if there is valid Groups arraylist to add to", groupList);

        C206_CaseStudyGroups.addgroup(groupList, G1);
        assertEquals("Check that Group arraylist size is 1", 1, groupList.size());
        assertSame("Check that Group is added", G1, groupList.get(0));

        C206_CaseStudyGroups.addgroup(groupList, G2);
        assertEquals("Check that Group arraylist size is 2", 2, groupList.size());
        assertSame("Check that Group is added", G2, groupList.get(1));
    }
    
    @Test
    public void testAddgroupAlreadyExists() {
        C206_CaseStudyGroups.addgroup(groupList, G2);
        assertEquals(1, groupList.size());
    }
    
    @Test
    public void testAddgroupEmptyFields() {
    	C206_CaseStudyGroups.addgroup(groupList, G1);
        C206_CaseStudyGroups.addgroup(groupList, G2);
        assertEquals("Check that group arraylist size is 2",2, groupList.size());
    }

    @Test
    public void testRetrieveAllgroup() {
        assertNotNull("Test if there is valid Group arraylist to retrieve item", groupList);

        String allgroup = C206_CaseStudyGroups.retrieveAllGroups(groupList);
        String testOutput = "";
        assertEquals("Check that ViewAllgrouplist", testOutput, allgroup);

        C206_CaseStudyGroups.addgroup(groupList, G1);
        C206_CaseStudyGroups.addgroup(groupList, G2);
        assertEquals("Test that group arraylist size is 2", 2, groupList.size());

        allgroup = C206_CaseStudyGroups.retrieveAllGroups(groupList);
        testOutput = String.format("%-25s %-10s \n", "Summer Adventure Ride", "9:00 AM ");
        testOutput += String.format("%-25s %-10s \n", "Family Fun Bike Rally", "10:00AM");

        assertEquals("Test that ViewAllgrouplist", testOutput, allgroup);
    }

    @Test
    public void testDeleteGroup() {
        groupList.add(G1);
        groupList.add(G2);

        C206_CaseStudyGroups.deletegroup(groupList, "Summer Adventure Ride");
        assertEquals("Check that Group arraylist size is 1 after deletion", 1, groupList.size());
        assertNull("Check that deleted group is no longer in the list", getGroupByTitle(groupList, "Summer Adventure Ride"));
    }

    private group getGroupByTitle(ArrayList<group> groupList, String title) {
        for (group group : groupList) {
            if (group.getgName().equalsIgnoreCase(title)) {
                return group;
            }
        }
        return null;
    }

    @After
    public void tearDown() throws Exception {
        G1 = null;
        G2 = null;
        groupList = null;
    }
}
