package controller;

import java.sql.*;
import java.util.Scanner;

public class UserLogin {
    Connection conn = SQLconnection.connnectDB();
    PreparedStatement pstmt;
    ResultSet rs;
    Scanner scanner = new Scanner(System.in);


    boolean authenticate = false;
    int attempt = 1;


    public void login(){
        do{
            System.out.println("PLease Enter Username:");
            String username = scanner.nextLine();
            System.out.println("PLease Enter Password:");
            String pass = scanner.nextLine();


            try {
                String sqlQuery = "SELECT * FROM userlogin where username = ? AND userpass = ?";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    System.out.println("Login Succesful. Welcome " + firstname + " " + lastname);
                    authenticate = true;
                    new CRUD_Selection().select();
                } else {
                    System.out.println("Invalid Username and Password. Please try again. Attempts: " + attempt);
                    attempt++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } while(attempt < 4 && !authenticate );
        if(attempt > 3){
            System.out.println("Sorry. Maximum attempts have been used. ");
        }
    }
}
