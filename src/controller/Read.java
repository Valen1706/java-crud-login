package controller;

import java.util.Scanner;
import java.sql.*;
import database.SQLconnection;

public class Read {
    Connection conn = SQLconnection.connnectDB();
    PreparedStatement pstmt;
    ResultSet rs;
    Scanner scanner = new Scanner(System.in);

    public void read(){
        System.out.println("Please, Enter Lastname");
        String lastname = scanner.nextLine();
        String sql = "SELECT * FROM personal_details WHERE INSTR(lastname,?)>0";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lastname);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String id = Integer.toString(rs.getInt(1));
                String firstN =  rs.getString(2);
                String middleN = rs.getString(3);
                String lastN = rs.getString(4);
                String name = firstN + " " + middleN+ " " + lastN;
                System.out.println(id + " - " + name);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
