package com.checkboxes;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		
	 	Alert myalert=wait.until(ExpectedConditions.alertIsPresent());
	 	
	 	System.out.println(myalert.getText());
		myalert.accept();
	 	
		driver.quit();
	}

}
