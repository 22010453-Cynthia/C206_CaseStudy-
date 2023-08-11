import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class BikeTest {

    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream simulatedSystemIn;
    private ArrayList<BikeModel> testBikes;
    private BikeManager bikeManager;

    @Before
    public void setUp() {
        simulatedSystemIn = new ByteArrayInputStream("1\nTestBrand\nTestModel\nTestDescription\n3\n2\n4\n".getBytes());
        System.setIn(simulatedSystemIn);
        testBikes = new ArrayList<>();
        bikeManager = new BikeManager();
        bikeManager.bikes = testBikes;
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testAddNewBike() {
        bikeManager.addNewBike();
        assertEquals(1, testBikes.size());
        assertEquals("TestBrand", testBikes.get(0).getBrand());
        assertEquals("TestModel", testBikes.get(0).getModel());
        assertEquals("TestDescription", testBikes.get(0).getDescription());
    }

    @Test
    public void testDeleteBike() {
        BikeModel bikeToDelete = new BikeModel("ToDeleteBrand", "ToDeleteModel", "ToDeleteDescription", 1);
        testBikes.add(bikeToDelete);
        bikeManager.deleteBike();
        assertEquals(0, testBikes.size());
    }
    @Test
    public void testViewBike() {
     
    }
}