package controller;

import model.Person;
import model.PersonDAO;
import view.PersonView;

import java.sql.Connection;

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
}
