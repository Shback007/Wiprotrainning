package com.sdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankRegistration {
	
	static WebDriver  driver;
	static WebDriverWait wait;
	
	public static void launchBrowser() {
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
	}
	
	
	public static void registration(String first,String last,String Address,String city,String state,String zipcode,String phoneNumber,String ssn,String username,String password,String confirm) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName"))).sendKeys(first);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.lastName"))).sendKeys(last);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.street"))).sendKeys(Address);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.city"))).sendKeys(city);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.state"))).sendKeys(state);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.zipCode"))).sendKeys(zipcode);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.phoneNumber"))).sendKeys(phoneNumber);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.ssn"))).sendKeys(ssn);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.username"))).sendKeys(username);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.password"))).sendKeys(password);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatedPassword"))).sendKeys(confirm);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"))).click();
		
	}
	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		
		registration("Sagnik","Hore","Dinhata","Dinhata","West Bengal","721245","5458796541","25465","shback007","12345","12345");
		Thread.sleep(20000);
		
		driver.quit();
	}

}
