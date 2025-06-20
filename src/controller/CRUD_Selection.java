package controller;

import java.util.Scanner;

public class CRUD_Selection {
    public static void select(){
        Scanner scanner = new Scanner(System.in);
        UserLogin userLogin = new UserLogin();
        int selected = -1;
        do{
            System.out.println("Please Select an Option for CRUD");
            System.out.println("1. => Create");
            System.out.println("2. => Read");
            System.out.println("3. => Update");
            System.out.println("4. => Delete");
            System.out.println("5. => Exit");
            selected = scanner.nextInt();

            switch (selected){
                case 1 -> new Create().create();
                case 2 -> new Read().read();
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
