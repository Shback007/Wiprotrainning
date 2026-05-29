package jdbc;


import java.sql.*;

public class jdbcUpdate {
	public static void main(String[] args) {
		try {

			Connection con = DBConnection.getConnection("wipro_trainning");
			
			Statement st = con.createStatement();
			
			String query = "Update employees2"
					+ " set department='SDET' where emp_id=111 ";
			
			int rows = st.executeUpdate(query);
			
			System.out.println(rows + " updated");
			
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
