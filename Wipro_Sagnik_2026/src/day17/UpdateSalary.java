package day17;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.DBConnection;

public class UpdateSalary {
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection("companydb");
			
			String query = "update employees set salary = ? where emp_id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setDouble(1, 75000);
			
			ps.setInt(2, 101);
			
			int rows = ps.executeUpdate();
			
		
			
			System.out.println(rows+ " row updated");
			
			con.close();
		}catch(Exception e ) {
			System.out.println(e);
		}
	}

}
