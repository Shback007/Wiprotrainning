package com.assignments.day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginFunctionality {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	//TC 01 - Valid Login
	@Test(priority =1)
	public void validLoginTest() {
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		String successMessage = driver.findElement(By.id("flash")).getText();
		
		Assert.assertTrue(successMessage.contains("You logged into a secure area!"));
		
		System.out.println("Valid Login Test Passed");
	}
	
	
	//TC 02 - Invalid Login
	@Test(priority=2)
	public void invalidLoginTest() {
		driver.findElement(By.id("username")).sendKeys("InvalidUser");
		
		driver.findElement(By.id("password")).sendKeys("InvalidPassword");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		String errorMessage = driver.findElement(By.id("flash")).getText();
		
		Assert.assertTrue(errorMessage.contains("Your username is invalid!"));
		
		System.out.println("Invalid Login Test Passed");
				
	}
	
	//TC 03 - Empty Fields	
	@Test(priority=3)
	public void emptyFieldsTest() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		String errorMessage = driver.findElement(By.id("flash")).getText();
		
		Assert.assertTrue(errorMessage.contains("Your username is invalid!"));
		
		System.out.println("Empty Fields Test Passed");
	}
	
	//TC 04 - Password Masking
	@Test(priority=4)
	public void passwordMaskingTest() {
		WebElement password = driver.findElement(By.id("password"));
		
		String typeAttribute = password.getAttribute("type");
		
		Assert.assertEquals(typeAttribute, "password");
		
		System.out.println("Password Masking Test Passed");
	}
	
	//TC 05 - Forgot Password Link
	@Test(priority = 5)
	public void forgotPasswordLinkTest() {
		
		driver.navigate().to("https://the-internet.herokuapp.com/forgot_password");
		
		String heading = driver.findElement(By.xpath("//h2[normalize-space()='Forgot Password']")).getText();
		
		Assert.assertEquals(heading, "Forgot Password");
		
		System.out.println("Forgot Password Link Test Passed");
	}
	
	//TC 06 - Multiple Failed Attempts
	@Test(priority = 6)
    public void multipleFailedAttemptsTest() {

        for (int i = 1; i <= 3; i++) {

            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).clear();

            driver.findElement(By.id("username")).sendKeys("wrongUser");

            driver.findElement(By.id("password")).sendKeys("wrongPass");

            driver.findElement(By.cssSelector("button[type='submit']")).click();
        }

        String errorMessage =driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(errorMessage.contains("Your username is invalid!"));

        System.out.println("Multiple Failed Attempts Test Passed");
    }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
