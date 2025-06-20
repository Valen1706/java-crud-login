package controller;

import java.sql.*;
import java.util.Scanner;

public class Update {
    Connection conn = SQLconnection.connnectDB();
    PreparedStatement pstmt;
    Scanner scanner = new Scanner(System.in);
    ResultSet rs;
    int id;
    String firstname, middlename, lastname, gender, address;

    public void update(){
        String sql = "SELECT * FROM personal_details";
        System.out.println();
        System.out.println("List of Students");
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
                firstname =  rs.getString(2);
                middlename = rs.getString(3);
                lastname = rs.getString(4);
                gender = rs.getString(5);
                address = rs.getString(6);
                System.out.println(id + " " + firstname + " " + middlename + " " + lastname + " " + gender + " " + address);
            }

            System.out.println("==================================================================================");
            System.out.print("Please Enter Id Number of Student to Update:");
            id = scanner.nextInt();
            String sql2 = "SELECT * FROM personal_details WHERE id_number = ?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(!rs.next()){
                System.out.println("ID Not Found");
                update();
            } else {
                firstname =  rs.getString(2);
                middlename = rs.getString(3);
                lastname = rs.getString(4);
                gender = rs.getString(5);
                address = rs.getString(6);
                System.out.printf("%-15s %-15s %-15s %-10s %-30s\n",
                        "Firstname", "Middlename", "Lastname", "Gender", "Address");
                System.out.println("---------------------------------------------------------------------------");
                System.out.printf("%-15s %-15s %-15s %-10s %-30s\n",
                        firstname, middlename, lastname, gender, address);

                System.out.println();
                System.out.println("UPDATE INFO");
                scanner.nextLine();
                System.out.println("First Name => ");
                firstname = scanner.nextLine();
                System.out.println("Middle Name => ");
                middlename = scanner.nextLine();
                System.out.println("Last Name => ");
                lastname = scanner.nextLine();
                System.out.println("Gender => ");
                gender = scanner.nextLine();
                System.out.println("Address => ");
                address = scanner.nextLine();
                String sql3 = "UPDATE `personal_details` SET `id_number`=?, `firstname`=?,`middlename`=?,`lastname`=?,`gender`=?,`address`=? WHERE id_number = ?";
                pstmt = conn.prepareStatement(sql3);

                pstmt.setInt(1, id);
                pstmt.setString(2, firstname);
                pstmt.setString(3, middlename);
                pstmt.setString(4, lastname);
                pstmt.setString(5, gender);
                pstmt.setString(6, address);
                pstmt.setInt(7, id);

                pstmt.execute();
                System.out.println("Datails update successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
