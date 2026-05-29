package com.sdet.day26;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnection {

    static Connection con;
    public static Connection getConnection(String database) {
        try {

            if (con == null || con.isClosed()) {


                ResourceBundle rb = ResourceBundle.getBundle("db");

                String host = rb.getString("host");
                String port = rb.getString("port");
                String username = rb.getString("username");
                String password = rb.getString("password");

                String url ="jdbc:mysql://" + host + ":" + port + "/" + database;

                con = DriverManager.getConnection(url,username,password);
                
                System.out.println("Connection Created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}