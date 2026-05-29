package com.checkboxes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleAlerts {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		
		//1. Normal Alert With Ok Button
		
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		Thread.sleep(3000);
		
	 	Alert myalert=driver.switchTo().alert();
	 	
	 	System.out.println(myalert.getText());
		myalert.accept();
	 	
	 	Thread.sleep(2000);
		driver.quit();
		*/
		
		//2. Confirmation Alert - Ok & Cancel
		
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();// close alert using Ok button
//		driver.switchTo().alert().dismiss();// close alert using cancel
		
		Thread.sleep(2000);
		driver.quit()
		 */
		
		//3. Promt Alert - Input Box
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Thread.sleep(2000);
		
		Alert myalert = driver.switchTo().alert();
		
		myalert.sendKeys("Jai Shree Ram");
	
		myalert.accept();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}
}
