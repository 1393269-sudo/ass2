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

    public void displayAllResources() {
        if (nodes.isEmpty()){
            System.out.println("Nothing to Display");
            return;
        }
        for (Resource node : nodes){
            System.out.println("\n" + node.getName());
        }
    }

    public Resource searchByName(String name) {
        for (Resource node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }
    public void updateNode(Resource node, String newName, String newDescription) {
        node.setName(newName);
        node.setDescription(newDescription);
        nodes.remove(node);
    }
}
