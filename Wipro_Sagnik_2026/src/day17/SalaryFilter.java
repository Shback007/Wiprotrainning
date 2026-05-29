package day17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.DBConnection;

public class SalaryFilter {

    public static void main(String[] args) {

        try {
            Connection con= DBConnection.getConnection("companydb");
            
            Statement st = con.createStatement();

            ResultSet rs =st.executeQuery("select * from employees where salary > 50000");

            while(rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " " +
                        rs.getString("employee_name") + " " +
                        rs.getDouble("salary")
                );
            }
            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}