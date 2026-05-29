package com.sdet.day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class DemoDrop {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver=new EdgeDriver();
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();	
	}
	
	@Test
	public void dropDownTest() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rc-tree-switcher"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]/span[3]"))).click();
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
