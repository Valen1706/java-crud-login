package controller;

import model.Person;
import model.PersonDAO;
import view.PersonView;

import java.sql.Connection;
import java.util.ArrayList;

public class PersonController {
    private PersonView view;
    private PersonDAO dao;

    public PersonController(Connection conn) {
        this.view = new PersonView();
        this.dao = new PersonDAO(conn);
    }

    public void createPerson() {
        Person person = view.getCreatePersonInput();
        boolean success = dao.saveCreatePerson(person);
        if (success) {
            view.showCreatedSuccessMessage();
        }
    }

    public void readPerson(){
        int option;
        do{
            option = view.askReadOption();
            if(option > 2 || option < 1){
                System.out.println("Number out of range! Try again.");
            }

        } while (option > 2 || option < 1);

        if(option == 1){
            showListOfStudents();
        } else {
            Person person = view.getReadPersonInput();
            boolean success = dao.saveReadPerson(person);
            if (success) {
                int id = person.getId();
                String firstN = person.getFirstname();
                String middleN = person.getMiddlename();
                String lastN = person.getLastname();
                String address = person.getAddress();

                String name = firstN + " " + middleN + " " + lastN;

                System.out.println(id + " - " + name + " (" + address + ")");
            }
        }
    }

    public void showListOfStudents(){
        ArrayList <Person> list = dao.getListOfStudents();
        view.ListOfStudents(list);
    }

    public void updatePerson(){
        showListOfStudents();

        int id;
        Person person;

        do {
            id = view.getIdInput();
            person = dao.selectPersonToUpdate(id);
            if (person == null){
                view.showMessageUpdateIDnotFound();
            }

        } while (person == null);

        view.getUpdatePersonInput(person);
        dao.saveNewDetailUpdate(view.getInfoToUpdate(person.getId()));
    }

    public void deletePerson(){
        int id;
        showListOfStudents();
        do {
            id = view.idToDelete();
            if(!dao.idExist(id)){
                view.showMessageDeleteIDnotFound();
            }
        } while (!dao.idExist(id));

        dao.selectPersontoDelete(id);
        view.showDeletedSuccessfully();
    }


}
