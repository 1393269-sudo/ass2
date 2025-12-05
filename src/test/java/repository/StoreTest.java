package repository;

import Models.Resource;
import Repository.store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class StoreTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void test_adding_nodes() {

        // Initialise data
        store s = new store();

        Resource n = new Resource("name1", "description1");
        s.addResource(n);

        Resource n1 = new Resource("name2", "description2");
        s.addResource(n1);

        int expected = 2;
        int actual = s.countResources();

        // test
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_adding_nodes_edge_case() {
        // Initialise data
        store s = new store();

        Resource n = new Resource("name1", "description1");
        s.addResource(n);

        Assertions.assertThrows(Exception.class, () -> s.addResource(null));
    }

    @Test
    public void test_nothing_to_display() {
        //Initialise data
        store s = new store();

        s.displayAllResources();

        String expected = "Nothing to display" + System.lineSeparator();
        Assertions.assertEquals(expected, outContent.toString());
    }

//testing if node exists
    @Test
    public void test_Search_by_name() {

        store s = new store();
        Resource n = new Resource("name1", "description1");

        s.addResource(n);

        Resource result = s.searchByName("name1");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("name1", result.getName());
    }
    //testing search by wrong name
    @Test
    public void test_Search_by_name_not_found_edge_case() {

        store s = new store();

        Resource n = new Resource("name1", "description1");

        Resource result = s.searchByName("name2");

        Assertions.assertNull(result);
    }
    //testing updating node name and description
    @Test
    public void test_update_nodes() {
        store s = new store();
        Resource n = new Resource("Old Name", "Old Description");

        s.addResource(n);

        s.updateNode(n, "NewName", "New Description");

        Assertions.assertNull(s.searchByName("Old Name"));
        Assertions.assertNull(s.searchByName("NewName"));

        Assertions.assertEquals("NewName", n.getName());
        Assertions.assertEquals("New Description", n.getDescription());

        Assertions.assertEquals(0, s.countResources());
    }
    //test number of nodes if 0 nodes
    @Test
    public void test_number_of_nodes() {
        store s = new store();

        Assertions.assertEquals(0, s.countResources());

    }
    //test number of nodes if 3 nodes
    @Test
    public void test_number_of_nodes_edge_case() {
        store s = new store();
        Resource n = new Resource("Name1", "Description1");
        Resource n1 = new Resource("Name2", "Description2");
        Resource n2 = new Resource("Name3", "Description3");

        s.addResource(n);
        s.addResource(n1);
        s.addResource(n2);

        Assertions.assertEquals(3, s.countResources());
    }


}
