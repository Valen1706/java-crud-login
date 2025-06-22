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
        Person person = view.getPersonInput();
        boolean success = dao.savePerson(person);
        if (success) {
            view.showSuccessMessage();
        }
    }
}
