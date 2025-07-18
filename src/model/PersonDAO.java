package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO {
    private Connection conn;

    public PersonDAO(Connection conn){
        this.conn = conn;
    }

    PreparedStatement pstmt;
    ResultSet rs;
    String query = "";


    public boolean saveCreatePerson(Person person){
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

    public boolean saveReadPerson(Person person){
        boolean success = false;
        try{
            query = "SELECT * FROM personal_details WHERE INSTR(lastname,?)>0";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, person.getLastname());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                person.setId(rs.getInt(1));
                person.setFirstN(rs.getString(2));
                person.setMiddleN(rs.getString(3));
                person.setLastN(rs.getString(4));
                person.setGender(rs.getString(5));
                person.setAddress(rs.getString(6));
                success = true;

            }

            return success;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return success;
        }
    }

    public ArrayList <Person> getListOfStudents(){
        ArrayList <Person> list = new ArrayList<>();
        query = "SELECT * FROM personal_details";
        /*System.out.println();
        System.out.println("List of Students");*/
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt(1));
                p.setFirstN(rs.getString(2));
                p.setMiddleN(rs.getString(3));
                p.setLastN(rs.getString(4));
                p.setGender(rs.getString(5));
                p.setAddress(rs.getString(6));
                list.add(p);


                //System.out.println(id + " " + firstname + " " + middlename + " " + lastname + " " + gender + " " + address);

            } return list;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
    }

    public Person selectPersonToUpdate(int id){
        try{
            while (true){
                query = "SELECT * FROM personal_details WHERE id_number = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if(!rs.next()){
                    break;
                } else {
                    Person person = new Person();
                    person.setId(rs.getInt(1));
                    person.setFirstN(rs.getString(2));
                    person.setMiddleN(rs.getString(3));
                    person.setLastN(rs.getString(4));
                    person.setGender(rs.getString(5));
                    person.setAddress(rs.getString(6));
                    return person;
                }
            }


        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
        return null;
    }

    public void saveNewDetailUpdate(Person person){
        try{
            String sql3 = "UPDATE `personal_details` SET `id_number`=?, `firstname`=?,`middlename`=?,`lastname`=?,`gender`=?,`address`=? WHERE id_number = ?";
            pstmt = conn.prepareStatement(sql3);

            pstmt.setInt(1, person.getId());
            pstmt.setString(2, person.getFirstname());
            pstmt.setString(3, person.getMiddlename());
            pstmt.setString(4, person.getLastname());
            pstmt.setString(5, person.getGender());
            pstmt.setString(6, person.getAddress());
            pstmt.setInt(7, person.getId());

            pstmt.execute();
            System.out.println("Datails update successfully");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public boolean idExist(int id){
        try{
            String query = "SELECT id_number FROM personal_details WHERE id_number = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public void selectPersontoDelete(int id){
        try{
            query = "DELETE FROM personal_details WHERE id_number = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }



}

