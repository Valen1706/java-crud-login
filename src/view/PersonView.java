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
        System.out.println("==================================================================================");
        for (Person p : students){
            System.out.println(p.getId() + " - " + p.getFirstname() + " " + p.getMiddlename() + " " + p.getLastname() + " " + p.getGender() + " " + p.getAddress());
        }
        System.out.println("==================================================================================");
    }


    public int getIdInput(){
        System.out.print("Please Enter Id Number of Student to Update:");
        int id = scanner.nextInt();
        System.out.println();
        return id;
    }
    public void getUpdatePersonInput(Person person){
        System.out.printf("%-15s %-15s %-15s %-10s %-30s\n",
                "Firstname", "Middlename", "Lastname", "Gender", "Address");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-10s %-30s\n",
                person.getFirstname(), person.getMiddlename(), person.getLastname(), person.getGender(), person.getAddress());
        System.out.println();
    }

    public Person getInfoToUpdate(int id){
        System.out.println("UPDATE INFO");
        scanner.nextLine();
        System.out.println("First Name => ");
        String firstname = scanner.nextLine();
        System.out.println("Middle Name => ");
        String middlename = scanner.nextLine();
        System.out.println("Last Name => ");
        String lastname = scanner.nextLine();
        System.out.println("Gender => ");
        String gender = scanner.nextLine();
        System.out.println("Address => ");
        String address = scanner.nextLine();
        return new model.Person(id, firstname, middlename, lastname, gender, address);
    }

    public void showMessageUpdateIDnotFound(){
        System.out.println("ID Not Found. Try again\n");
    }

    public int idToDelete(){
        System.out.println("Please Enter an ID Number to Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public void showMessageDeleteIDnotFound(){
        System.out.println("ID Not Found. No record deleted.\n");
    }

    public void showDeletedSuccessfully(){
        System.out.println("Record deleted successfully");
    }

}
