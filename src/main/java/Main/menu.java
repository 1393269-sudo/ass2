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
            System.out.println("2. Test count node");

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
                    break;
                    default:
                        System.out.println("Invalid option");
            }
        }
    }
}
