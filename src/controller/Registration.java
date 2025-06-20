package controller;

import java.sql.*;
import java.util.Scanner;
import database.SQLconnection;

public class Registration {

    Connection conn = SQLconnection.connnectDB();
    PreparedStatement pstmt;
    Scanner scanner = new Scanner(System.in);
    String firstname, lastname, username, password;

    public void register(){
        System.out.println("USERLOGIN");
        System.out.println("Enter Firstname: ");
        firstname = scanner.nextLine();
        System.out.println("Enter Lastname: ");
        lastname = scanner.nextLine();
        System.out.println("Enter Username: ");
        username = scanner.nextLine();
        System.out.println("Enter Password: ");
        password = scanner.nextLine();
        String sql = "INSERT INTO userlogin (`username`, `userpass`, `firstname`, `lastname`) VALUES (?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstname);
            pstmt.setString(4, lastname);
            int record = pstmt.executeUpdate();
            if (record>=1){
                System.out.println("Registration complete");
                new Selection().select();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
