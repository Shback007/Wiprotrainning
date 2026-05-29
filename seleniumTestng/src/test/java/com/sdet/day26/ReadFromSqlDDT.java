package com.sdet.day26;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import org.apache.logging.log4j.Logger;



public class ReadFromSqlDDT {
	
	private static final Logger logger =
            LogManager.getLogger(ReadFromSqlDDT.class);
	 
	
	static WebDriver driver;
	public static void main(String[] args) throws SQLException, InterruptedException {
		Connection con = DBConnection.getConnection("wipro_trainning");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from users");
		
		
		while(rs.next()) {
			String username = rs.getString("username");
			
			String password = rs.getString("password");
			
			 
			driver = new EdgeDriver();
			
			driver.get("https://www.saucedemo.com");
			
			driver.findElement(By.id("user-name")).sendKeys(username);
			logger.info(username);
			
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.id("login-button")).click();
			
			logger.info("Current Title: " + driver.getTitle());
			
			
			driver.quit();
		}
				
	}

}
