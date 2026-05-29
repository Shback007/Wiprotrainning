package com.sdet.day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get("https://saucedemo.com/");
	}
	
	 @Test(priority=1)
	  public void verigyLoginPageTitle() {
		  String actTitle = driver.getTitle();
		  Assert.assertEquals(actTitle, "Swag Labs");
		  System.out.println("Title Validation Passed by: " + Thread.currentThread().getId());
	  }
	  
	  @Test(priority=2)
	  @Parameters({"username", "password"})
	  public void loginTest(String uname, String pass) throws InterruptedException {
		  
		  driver.findElement(By.id("user-name")).sendKeys(uname);
		  
		  driver.findElement(By.id("password")).sendKeys(pass);
		  
		  driver.findElement(By.id("login-button")).click();
		  
		  String currentURL = driver.getCurrentUrl();
		  
		  Assert.assertTrue(currentURL.contains("inventory"));
		  
		  System.out.println("Login Successful by: " + Thread.currentThread().getId());
	  }
	  
	  @Test(priority=3)
	  public void verifyProductPage() throws InterruptedException {

		  String productText=driver.findElement(By.className("title")).getText();
		  
		  Assert.assertEquals(productText, ("Products"));
		  
		  System.out.println("Product Page Passed by: " +Thread.currentThread().getId());	  }
	  
	  
	  @AfterTest
	  public void tearDown() {
		  System.out.println("Closing Browser by: " + Thread.currentThread().getId());
		  driver.quit();
	  }
}
