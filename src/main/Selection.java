package main;

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
            selected = scanner.nextInt();

            switch (selected){
                case 1 -> userLogin.login();

                case 2 -> new Registration().register();
            }
        } while(true);


    }

}
