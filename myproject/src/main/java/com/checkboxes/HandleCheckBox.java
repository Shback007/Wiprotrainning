package com.checkboxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleCheckBox {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//1 Select Specific CheckBox
//		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2 Select All the checkboxes
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
//		for(int i=0;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//		}
//		
		
//		for(WebElement checkbox:checkboxes) {
//			checkbox.click();
//		}
		
		//3 Select Last 3 Checkboxes
//		for(int i=4;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//		}
		
		//4 Select First 3 CheckBoxes
//		for(int i=0;i<3;i++) {
//			checkboxes.get(i).click();
//		}
//		
		
		//5 Unselect CheckBoxes
		for(int i=0;i<3;i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(2000);
		
		for(int i=0;i<checkboxes.size();i++) {
			if(checkboxes.get(i).isSelected())
				checkboxes.get(i).click();
		}
		
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
