package database;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLconnection {
    public static Connection connnectDB(){
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("db.properties")){
            props.load(fis);
            String host = props.getProperty("DB_HOST");
            String username = props.getProperty("DB_USER");
            String pass = props.getProperty("DB_PASSWORD");
            Connection conn = DriverManager.getConnection(host, username, pass);
            return conn;
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
