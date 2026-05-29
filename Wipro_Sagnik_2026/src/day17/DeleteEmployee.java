package day17;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.DBConnection;

public class DeleteEmployee {
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection("companydb");
			
			String query = "delete from employees where emp_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, 105);
			
			int rows = ps.executeUpdate();
			
			System.out.println(rows + " row deleted");
			
			con.close();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
