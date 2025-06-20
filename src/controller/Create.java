package controller;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;
import database.SQLconnection;

public class Create {
    Connection conn = SQLconnection.connnectDB();
    PreparedStatement pstmt;
    Scanner scanner = new Scanner(System.in);
    Random num = new Random();
    int min = 100000, max = 999999;

    public void create(){
        System.out.println("CRUD - Create - Personal Details");
        int id = num.nextInt(max-min+1)+min;
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

        String sql = "INSERT INTO personal_details (`id_number`, `firstname`, `middlename`, `lastname`, `gender`, `address`) VALUES (?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, middlename);
            pstmt.setString(4, lastname);
            pstmt.setString(5, gender);
            pstmt.setString(6, address);
            int record = pstmt.executeUpdate();
            if (record >= 1){
                System.out.println("Records added succesfully");
                System.out.println("Add another one?, Press Y-(yes) or N-(no): ");
                String reply = scanner.nextLine();
                if(reply.equalsIgnoreCase("Y")){
                    create();
                } else {
                    new CRUD_Selection().select();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
