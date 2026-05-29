package day17;

import java.sql.Connection;
import jdbc.DBConnection;

import java.sql.PreparedStatement;
public class InsertEmployees {
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection("companydb");
			
			String query = "insert into employees values(?,?,?,?,?,?)";
			
			PreparedStatement  ps = con.prepareStatement(query);
			
			ps.setInt(1, 101);
			ps.setString(2, "Sagnik");
			ps.setString(3, "SDET");
			ps.setDouble(4, 55000);
			ps.setString(5, "sagnikhore@gmail.com");
			ps.setDate(6, java.sql.Date.valueOf("2026-06-22"));
			
			ps.executeUpdate();
			
			ps.setInt(1, 102);
			ps.setString(2, "Aniket");
			ps.setString(3, "SDET");
			ps.setDouble(4, 55000);
			ps.setString(5, "anikettal@gmail.com");
			ps.setDate(6, java.sql.Date.valueOf("2026-06-22"));
			
			ps.executeUpdate();
			
			ps.setInt(1, 103);
			ps.setString(2, "Arka");
			ps.setString(3, "SDET");
			ps.setDouble(4, 55000);
			ps.setString(5, "arkad02@gmail.com");
			ps.setDate(6, java.sql.Date.valueOf("2026-06-22"));
			
			ps.executeUpdate();
			
			ps.setInt(1, 104);
			ps.setString(2, "Arpan");
			ps.setString(3, "SDET");
			ps.setDouble(4, 55000);
			ps.setString(5, "arpanj21@gmail.com");
			ps.setDate(6, java.sql.Date.valueOf("2026-06-22"));
			
			ps.executeUpdate();
			
			ps.setInt(1, 105);
			ps.setString(2, "Sharyua");
			ps.setString(3, "SDET");
			ps.setDouble(4, 55000);
			ps.setString(5, "sha456@gmail.com");
			ps.setDate(6, java.sql.Date.valueOf("2026-06-22"));
			
			ps.executeUpdate();
			System.out.println("5 Employees Inserted");
			
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
