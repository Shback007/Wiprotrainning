package com.sdet.day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenu {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver=new EdgeDriver();
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();	
	}
	
	@Test
	public void dropDownTest() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"withOptGroup\"]/div"))).click();
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='A root option']"))).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectOne"))).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dr.']"))).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldSelectMenu"))).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"oldSelectMenu\"]/option[10]"))).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-input"))).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Green']"))).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Black']"))).click();
	    
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
