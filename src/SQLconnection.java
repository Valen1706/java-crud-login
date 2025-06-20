package controller;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconnection {
    public static Connection connnectDB(){
        String host = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String pass = "";

        try {
            Connection conn = DriverManager.getConnection(host, username, pass);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
