package com.sdet;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
	
	  WebDriver driver;
	  
	  @BeforeMethod
	  public void setup() {
		  System.out.println("Launching Browser");
		  driver= new EdgeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://saucedemo.com/");
	  }
	  
	  @Test(priority=1)
	  public void verigyLoginPageTitle() {
		  String actTitle = driver.getTitle();
		  Assert.assertEquals(actTitle, "Swag Labs");
		  System.out.println("Title Validation Passed");
	  }
	  
	  @Test(priority=2)
	  public void loginTest() throws InterruptedException {
		  
		  driver.findElement(By.id("user-name")).sendKeys("standard_user");
		  
		  driver.findElement(By.id("password")).sendKeys("secret_sauce");
		  
		  driver.findElement(By.id("login-button")).click();
		  
		  String currentURL = driver.getCurrentUrl();
		  
		  Assert.assertTrue(currentURL.contains("inventory"));
		  
		  System.out.println("Login Successful");
	  }
	  
	  @Test(priority=3)
	  public void verifyProductPage() throws InterruptedException {
		  loginTest();
		  String productText=driver.findElement(By.className("title")).getText();
		  
		  Assert.assertEquals(productText, ("Products"));
		  
		  System.out.println("Product Page Passed");	  }
	  
	  
	  @AfterMethod
	  public void tearDown() {
		  System.out.println("Closing Browser");
		  driver.quit();
	  }

}
