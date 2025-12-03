package repository;

import Models.NodeModel;
import Models.Resource;
import Repository.store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
