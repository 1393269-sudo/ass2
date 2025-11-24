package Repository;

import Models.Resource;
import java.util.List;
import java.util.ArrayList;

public class store {

    private List<Resource> nodes = new ArrayList<>();

    public void addResource(Resource node) {
        nodes.add(node);
    }

    public void countResources() {
        System.out.println("Number of Nodes: " + nodes.size());
    }
}
