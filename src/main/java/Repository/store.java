package Repository;

import Models.Link;
import Models.Resource;
import java.util.List;
import java.util.ArrayList;

public class store {

    private List<Resource> nodes = new ArrayList<>();

    public void addResource(Resource node) {
        nodes.add(node);
    }

    public int countResources() {
        System.out.println("Number of Nodes: " + nodes.size());
        return nodes.size();
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
    // linking nodes
    private List<String> links = new ArrayList<>();

    public void addLink(Resource from, Resource to, Link type) {
        String linkText = from.getName() + " -> " + type + " -> " + to.getName();
    }
    public void dispalyLink(){
        if (links.isEmpty()){
            System.out.println("No links");
            return;
        }
        for (String link : links){
            System.out.println("Link: " + link);
        }
    }
}
