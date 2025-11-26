package Main;

import  Models.Resource;
import Repository.store;

import java.util.Scanner;

public class menu {
    public static void main(String[] args){

        store store = new store();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1. Add Node");
            System.out.println("2. List of Nodes");
            System.out.println("3. Search Node");
            System.out.println("4. Edit Node");

            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Enter node name");
                    String name = sc.nextLine();

                    System.out.println("Enter Description");
                    String description = sc.nextLine();

                    Resource newNode = new Resource (name, description);
                    store.addResource(newNode);
                    break;

                case "2":
                    store.countResources();
                    store.displayAllResources();
                    break;


                   // default:
                     //   System.out.println("Invalid option");

                case "3":
                    System.out.println("Enter node name");
                    String searchName = sc.nextLine();

                    Resource found = store.searchByName(searchName);

                    if (found != null) {
                        System.out.println("found");
                        System.out.println("Name: " + found.getName());
                        System.out.println("Description: " + found.getDescription());
                    }
                    else {
                        System.out.println("Please enter a valid node name");
                    }
                    break;

                    case "4":
                        System.out.println("Enter node name");
                        String oldName = sc.nextLine();

                        Resource nodeEdit = store.searchByName(oldName);

                        if (nodeEdit == null) {
                            System.out.println("node not found");
                            break;
                        }
                        System.out.println("current name:" + nodeEdit.getName());
                        System.out.println("current description:" + nodeEdit.getDescription());

                        System.out.println("Enter new name or press enter to continue");
                        String newName = sc.nextLine();
                        if (newName.isEmpty()) newName = nodeEdit.getName();

                        System.out.println("Enter new description:" + nodeEdit.getDescription());
                        String newDescription = sc.nextLine();
                        if (newDescription.isEmpty()) newDescription = nodeEdit.getDescription();

                        nodeEdit.setName(newName);
                        nodeEdit.setDescription(newDescription);

                        System.out.println("Update Successfull");




            }
        }
    }
}
