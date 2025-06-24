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
                view.showMessageIDnotFound();
            }

        } while (person == null);

        dao.saveNewDetailUpdate(view.getInfoToUpdate(person.getId()));
    }


}
