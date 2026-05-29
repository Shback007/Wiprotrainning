package com.sdet.day24;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
 
public class DatePicker {
	public static void main(String[]args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/date-picker");
		
		Thread.sleep(2000);
		
		WebElement date =driver.findElement(By.id("datePickerMonthYearInput"));

		date.click();

		date.sendKeys(Keys.CONTROL + "a");

		date.sendKeys("08/16/2025");

		date.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement dateAndTime = driver.findElement(By.id("dateAndTimePickerInput"));
		
		dateAndTime.click();
		dateAndTime.sendKeys(Keys.CONTROL + "a");
		dateAndTime.sendKeys("May 20, 2026 5:59 PM");
		dateAndTime.sendKeys(Keys.ENTER);
		
		
		Thread.sleep(3000);
		
		driver.quit();		
		}
 
}
 

 