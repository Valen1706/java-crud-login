package controller;

import java.sql.*;
import java.util.Scanner;

public class Delete {
    Connection conn = SQLconnection.connnectDB();
    PreparedStatement pstmt;
    Scanner scanner = new Scanner(System.in);

    public void delete(){
        System.out.println("Please Enter an ID Number to Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try{
            String query = "SELECT id_number FROM personal_details WHERE id_number = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()){
                System.out.println("ID not found. No record deleted.");
                return;
            }

            query = "DELETE FROM personal_details WHERE id_number = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
