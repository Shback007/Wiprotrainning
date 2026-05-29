package jdbc;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class jdbcExample {
	public static void main(String[] args)  {
		try {
		Connection con = DBConnection.getConnection("wipro_trainning");
		Statement stm = con.createStatement();
		
		System.out.println("connection created");
		
		String query = "Select * from employees2";
		ResultSet rs = stm.executeQuery(query);
		 while(rs.next()) {

	            System.out.println(
	                    rs.getInt("emp_id") + " " +
	                    rs.getString("employee_name") + " " +
	                    rs.getString("department") + " " +
	                    rs.getDouble("salary") + " " +
	                    rs.getString("email") + " " +
	                    rs.getDate("joinning_date") + " " +
	                    rs.getInt("department_id")
	            );
	        }
		con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
