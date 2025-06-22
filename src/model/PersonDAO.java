package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {
    private Connection conn;

    public PersonDAO(Connection conn){
        this.conn = conn;
    }

    PreparedStatement pstmt;
    ResultSet rs;
    String query = "";


    public boolean savePerson(Person person){
        try {
            query = "INSERT INTO `personal_details`(`id_number`, `firstname`, `middlename`, `lastname`, `gender`, `address`) VALUES (?,?,?,?,?,?)";
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
            return false;
        }
    }

    public Person readPerson(Person person){
        try{
            query = "SELECT * FROM personal_details WHERE INSTR(lastname,?)>0";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, person.getLastname());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                person.setId(rs.getInt(1));
                rs.getString(2);
                rs.getString(3);
                rs.getString(4);
            }

            return person;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

}

