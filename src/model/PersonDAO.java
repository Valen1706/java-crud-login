package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO {
    private Connection conn;

    public PersonDAO(Connection conn){
        this.conn = conn;
    }

    PreparedStatement pstmt;


    public boolean savePerson(Person person){
        try {
            String query = "INSERT INTO `personal_details`(`id_number`, `firstname`, `middlename`, `lastname`, `gender`, `address`) VALUES (?,?,?,?,?,?)"
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, person.getId());
            pstmt.setString(2, person.getFirstname());
            pstmt.setString(3, person.getMiddlename());
            pstmt.setString(4, person.getLastname());
            pstmt.setString(5, person.getGender());
            pstmt.setString(6, person.getAddress());

            return pstmt.executeUpdate() >= 1;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }


    }

}

