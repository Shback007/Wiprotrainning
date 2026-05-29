package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    static Connection con;
    public static Connection getConnection(String database) {
        try {

            if (con == null || con.isClosed()) {

                Properties prop = new Properties();

                FileInputStream fis =new FileInputStream("db.properties");

                prop.load(fis);

                String host = prop.getProperty("host");
                String port = prop.getProperty("port");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password");

                String url ="jdbc:mysql://" + host + ":" + port + "/" + database;

                con = DriverManager.getConnection(url,username,password);
                
                System.out.println("Connection Created");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}