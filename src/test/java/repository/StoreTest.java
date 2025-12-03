package repository;

import Models.NodeModel;
import Models.Resource;
import Repository.store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class StoreTest {

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

//@Test
//public void test_nothing_to_display() {
    //Initialise data
  //  store s = new store();

   // store.displayAllResources();

   // String expected = "Nothing to display" + System.lineSeparator();
   // Assertions.assertEquals(expected, outContent.toString());
}

