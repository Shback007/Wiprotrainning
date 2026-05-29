package com.sdet.day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
public class FillForm {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@Test
	public void fillform() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("Sagnik Hore");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("shback@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress"))).sendKeys("Dinhata");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress"))).sendKeys("Dinhata");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress"))).clear();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
		
		
		
		
	
 
}
 