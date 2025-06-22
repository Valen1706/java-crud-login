package view;

import model.Person;

import java.util.Random;
import java.util.Scanner;

public class PersonView {

    Scanner scanner = new Scanner(System.in);
    Random num = new Random();
    int min = 100000, max = 999999;

    public Person getPersonInput() {
        int id = num.nextInt(max-min+1)+min;

        System.out.println("First Name: ");
        String firstname = scanner.nextLine();
        System.out.println("Middle Name: ");
        String middlename = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastname = scanner.nextLine();
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();

        return new model.Person(id, firstname, middlename, lastname, gender, address);
    }

    public void showSuccessMessage() {
        System.out.println("Person created successfully!");
    }

}
