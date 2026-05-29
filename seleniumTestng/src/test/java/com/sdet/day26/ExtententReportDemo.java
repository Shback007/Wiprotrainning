package com.sdet.day26;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtententReportDemo {
	public static void main(String[] args) throws IOException {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest test = extent.createTest("SauceDemo Login Test");
		
		WebDriver driver = new EdgeDriver();
		
		test.info("Browser Launched");
		
		driver.get("https://www.saucedemo.com");
		
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 test.pass("Username Entered");
         
         driver.findElement(By.id("password")).sendKeys("secret_sauce");
         test.pass("Password entered");
        
         driver.findElement(By.id("login-button")).click();
         test.pass("Login button  clicked");
         
         String title = driver.getTitle();
         
         if(title.contains("Swag Labs"))
        	 test.pass("Login Successful");
         else
        	 test.fail("Login Failed");
         
         
         
         TakesScreenshot ts = (TakesScreenshot) driver;

         File src = ts.getScreenshotAs(OutputType.FILE);

         File destination = new File("screenshots/SauceDemo.png");

         FileUtils.copyFile(src, destination);

         test.addScreenCaptureFromPath("screenshots/SauceDemo.png");

         test.info("Screenshot Captured");
         
         driver.quit();
         test.info("Broswer Exited");
         extent.flush();
         
         System.out.println("Extent Report Generated");
		
	}

}
