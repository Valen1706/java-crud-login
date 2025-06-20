package controller;

import java.util.Scanner;

public class Selection {

    public static void select(){
        Scanner scanner = new Scanner(System.in);
        UserLogin userLogin = new UserLogin();
        int selected = -1;
        do{
            System.out.println("Please Select an Option");
            System.out.println("1. => UserLogin");
            System.out.println("2. => Registration");
            System.out.println("3. => Exit");
            selected = scanner.nextInt();

            switch (selected){
                case 1 -> userLogin.login();

                case 2 -> new Registration().register();

                case 3 -> {
                    System.out.println("Closing the program...");
                    System.exit(0);
                }

                default -> System.out.println("Invalid option. Please try again.");

            }
        } while(true);


    }

}
