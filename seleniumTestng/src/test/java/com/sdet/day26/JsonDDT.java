package com.sdet.day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Duration;

public class JsonDDT {
	
	static WebDriver driver;
	JsonArray users;
	
	@BeforeMethod
	public void Setup() {
		driver= new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		InputStream fis = JsonDDT.class.getClassLoader().getResourceAsStream("users.json");
		
		Reader reader = new InputStreamReader(fis);
		
		Gson gson = new Gson();
		
		users = gson.fromJson(reader, JsonArray.class);
		
	}
	
	@Test(priority=1)
	public void DDTJsonWithGson() {
		
		for(int i=0;i<users.size();i++) {
			
			driver.get("https://www.saucedemo.com");
			
			JsonObject user = users.get(i).getAsJsonObject();
			
			String username = user.get("username").getAsString();
			
			String password = user.get("password").getAsString();
			
			driver.findElement(By.id("user-name")).sendKeys(username);
			
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.id("login-button")).click();
			
			System.out.println("Login Attempted with : " + username);
			
			
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}

}
