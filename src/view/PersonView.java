package view;

import model.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PersonView {

    Scanner scanner = new Scanner(System.in);
    Random num = new Random();
    int min = 100000, max = 999999;

    public Person getCreatePersonInput() {
        int id = num.nextInt(max-min+1)+min;

        System.out.println("Complete the following personal detail:");

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

    public void showCreatedSuccessMessage() {
        System.out.println("Person created successfully!");
    }

    public Person getReadPersonInput(){
        System.out.println("Please, Enter Last name");
        String lastName = scanner.nextLine();
        return new model.Person(lastName);
    }

    public void ListOfStudents(ArrayList <Person> students){
        System.out.println("List of Students");
        for (Person p : students){
            System.out.println(p.getId() + " - " + p.getFirstname() + " " + p.getMiddlename() + " " + p.getLastname() + " " + p.getGender() + " " + p.getAddress());
        }
        System.out.println("==================================================================================");
    }

}
