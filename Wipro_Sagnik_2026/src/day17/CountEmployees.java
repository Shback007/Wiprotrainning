package day17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.DBConnection;

public class CountEmployees {
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection("companydb");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select count(*) as total from employees");
			
			if(rs.next()) {
				System.out.println("Total Employees :" + rs.getInt("total"));
			}
			con.close();
		}catch(Exception e ) {
			System.out.println();
		}
	}

}
