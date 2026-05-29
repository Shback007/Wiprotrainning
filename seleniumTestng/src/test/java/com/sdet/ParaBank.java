package com.sdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParaBank {
	WebDriver driver;
	WebDriverWait wait;
	
	
	static String login_username ="Mohan123";
	static String login_password ="mohan123";
	static String fromAcount="15675";
	static String toAcount="17229";
	static String amount= "10";
	
	public void type(By locator, String value) {

	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
	        .sendKeys(value);
	}

	public void click(By locator) {

	    wait.until(ExpectedConditions.elementToBeClickable(locator))
	        .click();
	}
	
	public void selectDropdown(By locator, String visibleText) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		
		wait.until(driver -> dropdown.getOptions().size() >1);
		
		dropdown.selectByVisibleText(visibleText);
	}
	public void login(String username, String password) {

	    type(By.name("username"), username);

	    type(By.name("password"), password);

	    click(By.xpath("//input[@value='Log In']"));
	}
	public void registerUser(
	        String first,
	        String last,
	        String address,
	        String city,
	        String state,
	        String zipcode,
	        String phoneNumber,
	        String ssn,
	        String username,
	        String password,
	        String confirm) {
		  type(By.id("customer.firstName"), first);

		    type(By.id("customer.lastName"), last);

		    type(By.id("customer.address.street"), address);

		    type(By.id("customer.address.city"), city);

		    type(By.id("customer.address.state"), state);

		    type(By.id("customer.address.zipCode"), zipcode);

		    type(By.id("customer.phoneNumber"), phoneNumber);

		    type(By.id("customer.ssn"), ssn);

		    type(By.id("customer.username"), username);

		    type(By.id("customer.password"), password);

		    type(By.id("repeatedPassword"), confirm);
		    
			click(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
	}
	  @BeforeMethod
	  public void setup() {
		  System.out.println("Launching Browser");
		  driver= new EdgeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://parabank.parasoft.com/parabank/");
		  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register"))).click();
	  }
	  
	  @Test(priority=1)
	  public void verigyLoginPageTitle() {
		  String actTitle = driver.getTitle();
		  Assert.assertEquals(actTitle, "ParaBank | Register for Free Online Account Access");
		  System.out.println("Title Validation Passed");
	  }
	  
	  @Test(priority=2)
	  	public void registrationOrLogin() {
		  registerUser(
				  "Mohan",
				  "Gupta",
				  "Uttam Nagar Street 12",
				  "Delhi",
				  "Delhi",
				  "201456",
				  "7845961247",
				  "12458",
				  login_username,
				  login_password,
				  login_password
				  );

		  String pageText =driver.findElement(By.tagName("body")).getText();
	        if (pageText.contains("This username already exists")) {

	            System.out.println("Username already exists.");

	            System.out.println("Trying Login with Existing Credentials");
	            

	            login(login_username, login_password);

	            Assert.assertTrue(driver.getCurrentUrl().contains("overview"));

	            System.out.println("Login Successful");
	            
	        }
	        else if(pageText.contains("Your account was created successfully")) {
	        	System.out.println("Registration Successfull");
	        	
	        	Assert.assertTrue(true);
	        }
	        else {
	        	Assert.fail("Registration failed");
	        }
	        
	  }
	  
	  @Test(priority=3)
	  public void transferFunds() throws InterruptedException {
		  login(login_username, login_password);
		  
		  click(By.linkText("Transfer Funds"));
		  
		  type(By.id("amount"), amount);
		  
		  selectDropdown(By.id("fromAccountId"),fromAcount);
		    
		  selectDropdown(By.id("toAccountId"),toAcount);
		  	
		  click(By.xpath("//input[@value='Transfer']"));
		  
		  String successText =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showResult"))).getText();
		  
		  Assert.assertTrue(successText.contains("Transfer Complete!"));

		  System.out.println("Fund Transfer Successful");
	  }
	  
	  @AfterMethod
	  public void tearDown() throws InterruptedException {
		  Thread.sleep(1000);
		  System.out.println("closing browser");
		  driver.quit();
	  }
}

