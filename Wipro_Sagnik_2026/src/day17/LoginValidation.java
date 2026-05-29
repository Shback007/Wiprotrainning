package day17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jdbc.DBConnection;

public class LoginValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DBConnection.getConnection("companydb");
			
			System.out.print("Enter Username:");
            String username = sc.nextLine();

            System.out.print("Enter Password:");
            String password = sc.nextLine();

            String query = "select * from users where username =? and password =?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
                System.out.println("Login Successful!");
            else System.out.println("Invalid Username or Password");
			con.close();

			
			sc.close();
		}catch(Exception e ) {
			System.out.println(e);
		}
	}

}
