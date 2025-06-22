package controller;

import database.SQLconnection;

import java.sql.Connection;
import java.util.Scanner;

public class CRUD_Selection {
    public static void select(){
        Scanner scanner = new Scanner(System.in);
        UserLogin userLogin = new UserLogin();
        int selected;
        do{
            System.out.println("Please Select an Option for CRUD");
            System.out.println("1. => Create");
            System.out.println("2. => Read");
            System.out.println("3. => Update");
            System.out.println("4. => Delete");
            System.out.println("5. => Exit");
            selected = scanner.nextInt();

            Connection conn = SQLconnection.connnectDB();

            switch (selected){
                case 1 -> new PersonController(conn).createPerson();
                case 2 -> new PersonController(conn).readPerson();
                case 3 -> new Update().update();
                case 4 -> new Delete().delete();
                case 5 -> new Selection().select();
                default -> {
                    System.out.println("Selection out of range");
                }
            }
        }while(true);
    }
}
