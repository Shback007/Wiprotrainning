package day17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.DBConnection;

public class DepartmentWise {
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection("companydb");
			
			Statement st = con.createStatement();
			
			String query="select * from employees order by department";
			
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
                System.out.println(
                        rs.getString("department") +
                        " " +
                        rs.getString("employee_name")
                );
            }
			con.close();
			
			
		}catch(Exception e ) {
			System.out.println(e);
		}
	}

}
