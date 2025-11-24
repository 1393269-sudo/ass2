package Models;

import  java.util.List;

public class Resource {
    private int ID;
    private String name;
    private String description;

    public Resource(int ID, String name, String description) {}

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
